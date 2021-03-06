package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.Parc010Elementos.campoDescricaoNoticiaTraducao;
import static br.com.projedata.arcturus.teste.webelements.Parc010Elementos.campoIdEmpresa;
import static br.com.projedata.arcturus.teste.webelements.Parc010Elementos.campoIdNoticia;
import static br.com.projedata.arcturus.teste.webelements.Parc010Elementos.campoIdioma;
import static br.com.projedata.arcturus.teste.webelements.Parc010Elementos.campoTituloNoticia;
import static br.com.projedata.arcturus.teste.webelements.Parc010Elementos.campoUrlLink;
import static br.com.projedata.arcturus.teste.webelements.Parc010Elementos.campoUrlTraducao;
import static br.com.projedata.arcturus.teste.webelements.Parc010Elementos.campoVisivel;
import static br.com.projedata.arcturus.teste.webelements.Parc010Elementos.linkParaNoticiaInglesPortal;
import static br.com.projedata.arcturus.teste.webelements.Parc010Elementos.linkParaNoticiaPortal;
import static br.com.projedata.arcturus.teste.webelements.Parc010Elementos.noticiaNoPortalEspanhol;
import static br.com.projedata.arcturus.teste.webelements.Parc010Elementos.noticiaNoPortalIngles;
import static br.com.projedata.arcturus.teste.webelements.Parc010Elementos.noticiaNoPortalPortugues;
import static br.com.projedata.arcturus.teste.webelements.Parc010Elementos.paginaDoLinkExibida;

import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.InternacionalizacaoMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class TesteParc010 extends TesteGenerico {

	LoginMetodos login;
	String codigoNoticia;
	String paginaPrincipal;
	String urlLink;
	InternacionalizacaoMetodos idiomas;

	@Parameters(value = { "login2", "senha", "base" })
	@Test(testName = "id: 1 - Abrir rotina parc010")
	public void abrirParc010(String usuario, String senha, String base) {
		login = new LoginMetodos(this);
		login.logar(usuario, senha, base);
		espera.aguardarSistemaCarregar();
		rotina.selecionarRotina("arc010", "p");
		rotina.aguardarProcessarRotina();
		idiomas = new InternacionalizacaoMetodos(this);
		urlLink = "http://www.projedata.com.br";
	}

	@Test(testName = "id: 2 - Cadastrar nova noticia", dependsOnMethods = { "abrirParc010" })
	public void cadastrarNovaNoticia() {
		acao.escreverNoElemento(campoIdEmpresa, "1");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoTituloNoticia, "Notícia Teste");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoUrlLink, urlLink);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		codigoNoticia = acao.localizarElementoNaPosicao(campoIdNoticia, 0).getAttribute("value");
	}

	@Test(testName = "id: 3 - Inserir traducoes", dependsOnMethods = { "cadastrarNovaNoticia" })
	public void cadastrarTraducoesParaNoticia() {
		acao.selecionarNoElemento(campoIdioma, 0, "Español");
		acao.escreverNoElemento(campoDescricaoNoticiaTraducao, "Noticias de prueba");
		acao.escreverNoElemento(campoUrlTraducao, urlLink);
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		acao.clicarNoElemento(campoIdioma, 1);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoIdioma, 1, "English");
		acao.escreverNoElementoNaPosicao(campoDescricaoNoticiaTraducao, 1, "News test");
		acao.escreverNoElementoNaPosicao(campoUrlTraducao, 1, urlLink);
		acao.clicarNoElemento(rotina.botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
	}

	@Test(testName = "id: 4 - Verificar noticia cadastrada", dependsOnMethods = { "cadastrarTraducoesParaNoticia" })
	public void verificarNoticiaCadastradaNaTelaDeLoginPortugues() {
		sairPortal();
		espera.aguardarElementoEstarVisivel(noticiaNoPortalPortugues);
	}

	@Test(testName = "id: 5 - Verificar se o link para noticia esta funcionando", dependsOnMethods = {
			"verificarNoticiaCadastradaNaTelaDeLoginPortugues" }, enabled=false)
	public void acessarLinkVermaisDaNoticia() throws InterruptedException {
		paginaPrincipal = navegador.retornarPaginaAtual();
		Thread.sleep(1500);
		acao.clicarNoElemento(rotina, linkParaNoticiaPortal);
		navegador.trocarDeAba();
		try {
			espera.aguardarElementoEstarVisivel(paginaDoLinkExibida);
		} catch (Exception e) {
			navegador.trocarDeAba();
		}
		navegador.retornarPaginaPrincipal(paginaPrincipal);
	}

	@Parameters(value = { "login2", "senha", "base" })
	@Test(testName = "id: 6 - Alterar noticia para nao visivel e verificar se nao sera exibida no portal", dependsOnMethods = {
			"verificarNoticiaCadastradaNaTelaDeLoginPortugues" })
	public void alterarNoticiaParaNaoVisivel(String usuario, String senha, String base) {
		login.logar(usuario, senha, base);
		rotina.selecionarRotina("arc010", "p");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoIdNoticia, codigoNoticia);
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoVisivel, "Não");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		sairPortal();
		testar.passouSeElementoNaoExistir(noticiaNoPortalPortugues);
		login.logar(usuario, senha, base);
		rotina.selecionarRotina("arc010", "p");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoIdNoticia, codigoNoticia);
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoVisivel, "Sim");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}

	@Parameters(value = { "login2", "senha", "base" })
	@Test(testName = "id: 7 - Verificar noticia em espanhol", dependsOnMethods = { "alterarNoticiaParaNaoVisivel" })
	public void verificarNoticiaNaTelaDeLoginEmEspanhol(String usuario, String senha, String base) {
		idiomas.alterarIdiomaParaEspanhol();
		sairPortal();
		espera.aguardarElementoEstarVisivel(noticiaNoPortalEspanhol);
	}

	@Parameters(value = { "login2", "senha", "base" })
	@Test(testName = "id: 8 - Verificar noticia em ingles", dependsOnMethods = { "verificarNoticiaNaTelaDeLoginEmEspanhol" })
	public void verificarNoticiaNaTelaDeLoginEmIngles(String usuario, String senha, String base) {
		login.logar(usuario, senha, base);
		idiomas.alterarIdiomaParaIngles();
		sairPortal();
		espera.aguardarElementoEstarVisivel(noticiaNoPortalIngles);
	}

	@Test(testName = "id: 9 - Acessar Link Idioma Ingles", dependsOnMethods = { "verificarNoticiaNaTelaDeLoginEmIngles" })
	public void acessarLinkIdiomaIngles() {
		paginaPrincipal = navegador.retornarPaginaAtual();
		acao.clicarNoElemento(linkParaNoticiaInglesPortal);
		navegador.trocarDeAba();
		try {
			espera.aguardarElementoEstarVisivel(paginaDoLinkExibida);
		} catch (Exception e) {
			navegador.trocarDeAba();
		}
		navegador.retornarPaginaPrincipal(paginaPrincipal);
	}

	@Parameters(value = { "login2", "senha", "base" })
	@Test(testName = "id: 10 - Excluir Noticia", dependsOnMethods = { "acessarLinkIdiomaIngles" })
	public void excluirNoticia(String usuario, String senha, String base) {
		login.logar(usuario, senha, base);
		rotina.selecionarRotina("arc010", "p");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoIdNoticia, codigoNoticia);
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoDescricaoNoticiaTraducao);
		rotina.aguardarProcessarRotina();
		rotina.excluirESalvar();
		rotina.excluirESalvar();
		acao.clicarNoElemento(campoIdNoticia, 0);
		rotina.aguardarProcessarRotina();
		rotina.excluirESalvar();
	}

}

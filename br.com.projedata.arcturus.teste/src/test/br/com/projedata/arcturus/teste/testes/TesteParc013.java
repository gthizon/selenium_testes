package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.Parc013Elementos.campoEstado;
import static br.com.projedata.arcturus.teste.webelements.Parc013Elementos.campoId;
import static br.com.projedata.arcturus.teste.webelements.Parc013Elementos.campoNomePainel;
import static br.com.projedata.arcturus.teste.webelements.Parc013Elementos.painelDinamicoExibido;

import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.Pger001Metodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;
import br.com.projedata.arcturus.teste.webelements.AtualizadorElementos;

public class TesteParc013 extends TesteGenerico {

	LoginMetodos log;
	AtualizadorElementos atualizador;
	Pger001Metodos ger001;
	String urlPrincipal;
	String usuarioUrl2;

	@Parameters(value = { "login", "senha", "base", "url" })
	@Test(testName = "id: 1 - Verificar se painel dinamico esta sendo exibido.")
	public void verificarPainelDinamicoExibido(String login, String senha, String base, String url) {
		log = new LoginMetodos(this);
		log.logar(login, senha, base);
		try {
			espera.aguardarElementoEstarVisivel(5, painelDinamicoExibido);
		} catch (TimeoutException e) {
			espera.aguardarElementoEstarVisivel(5, painelDinamicoExibido);
		}
	}

	@Test(testName = "id: 2 - Abrir rotina parc013.", dependsOnMethods = { "verificarPainelDinamicoExibido" })
	public void abrirParc013() {
		rotina.selecionarRotina("arc013");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoId, "11");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		espera.aguardarAtributoDoElementoConterOValor(campoNomePainel, "value", "teste");
	}

	@Test(testName = "id: 3 - Inativar painel dinamico.", dependsOnMethods = { "abrirParc013" })
	public void alterarPainelParaInativo() {
		acao.selecionarNoElemento(campoEstado, "Inativo");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		navegador.atualizarBrowser();
		espera.verificarSeElementoNaoExiste(painelDinamicoExibido);
	}

	@Test(testName = "id: 4 - Ativar painel dinamico.", dependsOnMethods = { "alterarPainelParaInativo" })
	public void alterarPainelParaAtivo() {
		abrirParc013();
		acao.selecionarNoElemento(campoEstado, "Ativo");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		navegador.atualizarBrowser();
		try {
			espera.aguardarElementoEstarVisivel(5, painelDinamicoExibido);
		} catch (TimeoutException e) {
			espera.aguardarElementoEstarVisivel(5, painelDinamicoExibido);
		}
	}
}

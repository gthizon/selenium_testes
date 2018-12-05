package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.Parc015Elementos.botaoEnviarMsgParaSessao;
import static br.com.projedata.arcturus.teste.webelements.Parc015Elementos.botaoEnviarMsgTodasSessoes;
import static br.com.projedata.arcturus.teste.webelements.Parc015Elementos.botaoEnviarNotificacao;
import static br.com.projedata.arcturus.teste.webelements.Parc015Elementos.botaoFinalizarSessao;
import static br.com.projedata.arcturus.teste.webelements.Parc015Elementos.campoCpfUsuario;
import static br.com.projedata.arcturus.teste.webelements.Parc015Elementos.campoDuracaoNotificacao;
import static br.com.projedata.arcturus.teste.webelements.Parc015Elementos.campoTextoNotificacao;

import java.awt.AWTException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.Pger001Metodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;
import br.com.projedata.arcturus.teste.webelements.AtualizadorElementos;

public class TesteParc015 extends TesteGenerico {

	LoginMetodos log;
	AtualizadorElementos atualizador;
	Pger001Metodos ger001;
	String urlPrincipal;
	String usuarioUrl2;

	@Parameters(value = { "login2", "senha", "base", "url" })
	@Test(testName = "id: 1 - Abrir rotina.")
	public void abrirParc015(String login, String senha, String base, String url) throws AWTException, InterruptedException {
		log = new LoginMetodos(this);
		log.logar(login, senha, base);
	}

	@Parameters(value = { "url" })
	@Test(testName = "id: 2 - Enviar notificacao para 1 usuario apenas.", dependsOnMethods = { "abrirParc015" })
	public void enviarNotificacaoParaUsuario(String url) throws AWTException, InterruptedException {
		urlPrincipal = navegador.retornarPaginaAtual();
		navegador.abrirNovaGuiaNavegador();
		navegador.alterarUrl(url + "/#/login");
		log.logar("gustavo.projedata", "guth055", "desenvolvimento");
		usuarioUrl2 = navegador.retornarPaginaAtual();
		rotina.selecionarRotina("arc015");
		acao.clicarNoElemento(campoCpfUsuario, 0);
		int posicao = retornarPosicaoUsuarioSessao("5509522925");
		acao.clicarNoElemento(botaoEnviarMsgParaSessao, posicao);
		espera.aguardarElementoEstarVisivel(campoTextoNotificacao);
		acao.escreverNoElemento(campoTextoNotificacao, "Automação teste");
		acao.escreverNoElemento(campoDuracaoNotificacao, "10");
		acao.clicarNoElemento(rotina, botaoEnviarNotificacao);
		espera.aguardarElementoDesaparecer(campoTextoNotificacao);
		msg.aguardarMensagem("Automação teste");
		navegador.trocarDeAba();
		navegador.retornarPaginaPrincipal(urlPrincipal);
		testar.passouSeElementoNaoExistir(msg.retornarMensagemNotificacao("Automação teste"));
	}

	@Parameters(value = { "url" })
	@Test(testName = "id: 3 - Enviar notificacao para todas as sessoes.", dependsOnMethods = { "enviarNotificacaoParaUsuario" })
	public void enviarNotificacaoParaTodasSessoes(String url) throws AWTException, InterruptedException {
		navegador.abrirNovaGuiaNavegador();
		navegador.alterarUrl(url + "/#/login");
		log.logar("gustavo.projedata", "guth055", "desenvolvimento");
		rotina.selecionarRotina("arc015");
		acao.clicarNoElemento(botaoEnviarMsgTodasSessoes);
		espera.aguardarElementoEstarVisivel(campoTextoNotificacao);
		acao.escreverNoElemento(campoTextoNotificacao, "Automação Todas sessões");
		acao.escreverNoElemento(campoDuracaoNotificacao, "3");
		acao.clicarNoElemento(rotina, botaoEnviarNotificacao);
		espera.aguardarElementoDesaparecer(campoTextoNotificacao);
		msg.aguardarMensagem("Automação Todas sessões");
		navegador.retornarPaginaPrincipal(urlPrincipal);
		msg.aguardarMensagem("Automação Todas sessões");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		msg.aguardarMensagemDesaparecer("Automação Todas sessões");
	}

	@Test(testName = "id: 4 - Excluir sessao do usuario.", dependsOnMethods = { "enviarNotificacaoParaTodasSessoes" }, enabled = true)
	public void eliminiarSessao() throws AWTException, InterruptedException {
		rotina.selecionarRotina("arc015");
		acao.clicarNoElemento(campoCpfUsuario, 0);
		rotina.aguardarProcessarRotina();
		String cpf = acao.localizarElementoNaPosicao(campoCpfUsuario, 0).getAttribute("value");
		int i = 1;
		while (!cpf.equals("5509522925")) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			rotina.aguardarProcessarRotina();
			cpf = acao.localizarElementoNaPosicao(campoCpfUsuario, i).getAttribute("value");
			i++;
		}
		acao.clicarNoElemento(botaoFinalizarSessao, i - 1);
		msg.aguardarMensagem("Confirma a eliminação da sessão");
		espera.aguardarElementoEstarVisivel(msg.simConfirmacao);
		acao.clicarNoElemento(msg.simConfirmacao);
		msg.aguardarMensagemDesaparecer("Confirma a eliminação da sessão");
		msg.aguardarMensagem("Sessão eliminada!");
		acao.clicarNoElemento(msg.okNotificacao);
		msg.aguardarMensagemDesaparecer("Sessão eliminada!");
		rotina.aguardarProcessarRotina();
	}

	public int retornarPosicaoUsuarioSessao(String cpf) {
		acao.clicarNoElemento(campoCpfUsuario, 0);
		rotina.aguardarProcessarRotina();
		String cpfUsu = acao.localizarElementoNaPosicao(campoCpfUsuario, 0).getAttribute("value");
		int i = 0;
		while (!cpfUsu.equals(cpf)) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			rotina.aguardarProcessarRotina();
			cpfUsu = acao.localizarElementoNaPosicao(campoCpfUsuario, i).getAttribute("value");
			i++;
		}
		return i;
	}

}

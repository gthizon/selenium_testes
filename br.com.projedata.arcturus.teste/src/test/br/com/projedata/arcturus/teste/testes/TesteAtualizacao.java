package br.com.projedata.arcturus.teste.testes;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.GeradorRelatoriosMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;
import br.com.projedata.arcturus.teste.webelements.AtualizadorElementos;
import static br.com.projedata.arcturus.teste.webelements.AtualizacaoElementos.*;

import java.awt.AWTException;

public class TesteAtualizacao extends TesteGenerico {

	LoginMetodos login;
	AtualizadorElementos atualizador;
	String paginaPortal;
	GeradorRelatoriosMetodos metodosGerador;

	@Parameters(value = { "login", "senha", "base", "url2" })
	@Test(testName = "id: 1 - Testar se nao permite aplicar versao menor que a versao minima permitida")
	public void testarAplicacaoVersaoMenorQuePermitida(String usuario, String senha, String base, String url2)
			throws AWTException, InterruptedException {
		metodosGerador = new GeradorRelatoriosMetodos(this);
		LoginMetodos login = new LoginMetodos(this);
		espera.aguardarElementoEstarVisivel(versaoSistema);
		String versao = acao.localizarElemento(versaoSistema).getText();
		login.logar(usuario, senha, base);
		paginaPortal = navegador.retornarPaginaAtual();
		rotina.selecionarRotina("teste021");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento("versaoMinima", versao);
		acao.escreverNoElemento("testeAtualizacao", "19");
		acao.clicarNoElemento("alterarVersao");
		rotina.aguardarProcessarRotina();
		navegador.irParaNovaUrlEmNovaAba(url2);
		login.logar(usuario, senha, "homologacao");
		navegador.alterarUrl("http://arcturus-teste-homo.prj:8881/#/admin");
		espera.aguardarElementoEstarVisivel(menuAplicarAtualizacoes);
		try {
			acao.clicarNoElemento(menuAplicarAtualizacoes);
		} catch (WebDriverException e) {
			Thread.sleep(1000);
			acao.clicarNoElemento(menuAplicarAtualizacoes);
		}
		espera.aguardarElementoEstarVisivel(baseHomologacao);
		acao.clicarNoElemento(baseHomologacao);
		espera.aguardarElementoEstarVisivel(atualizacaoParaAplicar);
		espera.aguardarElementoEstarVisivel(marcarAtualizacaoParaAplicar);
		acao.clicarNoElemento(marcarAtualizacaoParaAplicar);
		acao.clicarNoElemento(botaoAplicar);
		espera.aguardarElementoEstarVisivel(confirmaAplicacao);
		acao.clicarNoElemento(confirmaAplicacao);
		espera.aguardarElementoDesaparecer(confirmaAplicacao);
		 espera.aguardarElementoEstarVisivel(mensagemVersaoInferior);
		 acao.clicarNoElemento(okMensagemAtualizador);
		 espera.aguardarElementoDesaparecer(okMensagemAtualizador);
		navegador.retornarPaginaPrincipal(paginaPortal);

	}

}

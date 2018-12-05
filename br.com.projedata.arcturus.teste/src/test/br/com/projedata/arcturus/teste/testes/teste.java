package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.GeradorRelatoriosElementos.faixaPeriodoFinal;
import static br.com.projedata.arcturus.teste.webelements.GeradorRelatoriosElementos.faixaPeriodoInicial;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.barraRolagemProximoRelatorio;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.barraRolagemProximoRelatorioDesabilitada;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.botaoExecutarHabilitado;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.campoCodigoRelatorio;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.AtualizadorMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.ConstrutorTelasMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class teste extends TesteGenerico {

	String nomeOrigemIntegracao = "teste automatizado";
	String nomeAlteradoIntegracao = "teste alteracao integracao";
	LoginMetodos login;
	AtualizadorMetodos atualizador;
	ConstrutorTelasMetodos metodosConstrutor;
	LoginMetodos log;
	String campoIdRegistroCriado;
	String campoIdAcessoIntegracao;
	int posicaoRegistro = 0;

	@Parameters(value = { "login", "senha", "base" })
	@Test(testName = "id: 1 - Abrir rotina Parc020.")
	public void abrirParc020(String login, String senha, String base) {
		log = new LoginMetodos(this);
		log.logar(login, senha, base);
	}
	
	@Test(testName = "id: 21 - Testar filtro periodo do relatorio", dependsOnMethods = { "abrirParc020" })
	public void testarFiltroPeriodo() throws InvalidPasswordException, IOException, AWTException, InterruptedException {
//		navegador.irParaNovaUrlEmNovaAba("chrome://settings/content/pdfDocuments");
//		espera.aguardarElementoEstarVisivel(By.xpath("//div[@id='button']"));
//		acao.clicarNoElemento("//div[@id='button']");
		
		rotina.selecionarRotina("ger001");
		selecionarRelatorioParaEdicao("rger2");
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		acao.limparElemento(faixaPeriodoInicial);
		acao.escreverNoElemento(faixaPeriodoInicial, "02042013");
		acao.limparElemento(faixaPeriodoFinal);
		acao.escreverNoElemento(faixaPeriodoFinal, "02042013");
		acao.clicarNoElemento(rotina.botaoProcessarFiltros);
		espera.aguardarElementoDesaparecer(rotina.botaoProcessarFiltros);
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "147");
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "02/04/2013 - 02/04/2013");
	}
	
	public void selecionarRelatorioParaEdicao(String relatorio) {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoRelatorio, 0);
		rotina.aguardarProcessarRotina();
		rotina.limparCampoERealizarNovaConsulta();
		int posicao = 0;
		while (!acao.localizarElementos(campoCodigoRelatorio).get(posicao).getAttribute("value").equals(relatorio)) {
			if (acao.localizarElementos(barraRolagemProximoRelatorioDesabilitada).size() == 0) {
				acao.clicarNoElemento(barraRolagemProximoRelatorio);
				rotina.aguardarProcessarRotina();
				posicao = -1;
			}
			posicao++;
		}
		acao.clicarNoElemento(campoCodigoRelatorio, posicao);
		rotina.aguardarProcessarRotina();
	}

}

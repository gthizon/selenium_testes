package br.com.projedata.arcturus.teste.metodosgenericos;

import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoCodigoCliente;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoCodigoItem;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoCondPagto;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoDataEmissao;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoDescricaoItem;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoNomeCliente;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoQtdeItem;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoSerieNota;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoSituacaoNota;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoValorUn;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.estaProcessando;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class ConstrutorTelasMetodos {

	private TesteGenerico teste;

	public ConstrutorTelasMetodos(TesteGenerico teste) {
		this.teste = teste;
	}
		
	public void aguardaProcessarConstrutorTelas() {
		if (teste.webDriver.findElements(estaProcessando).size() != 0) {
			WebDriverWait wait = new WebDriverWait(teste.webDriver, 30);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(estaProcessando));
		}
	}

	public void retornarPaginaConstrutor(String pagina) {
		teste.webDriver.switchTo().window(pagina);
	}

	public void insereRegistroRotinaPteste014(WebDriver driver) {
		teste.espera.aguardarElementoEstarVisivel(campoSerieNota);
		teste.acao.escreverNoElemento(campoSerieNota, "1");
		teste.acao.escreverNoElemento(campoCodigoCliente, "1");
		teste.teclado.pressionarTeclaDeControle(Keys.TAB);
		teste.rotina.aguardarProcessarRotina();
		teste.testar.passouSeAtributoDoElementoContem(campoNomeCliente, "value", "PROJEDATA");
		teste.rotina.aguardarProcessarRotina();
		teste.acao.escreverNoElemento(campoCondPagto, "30");
		teste.acao.escreverNoElemento(campoDataEmissao, "10102017");
		teste.teclado.pressionarTeclaDeControle(Keys.TAB);
		teste.rotina.aguardarProcessarRotina();
		teste.acao.selecionarNoElemento(campoSituacaoNota, "Gerada");
		teste.rotina.aguardarProcessarRotina();
		teste.rotina.salvarEAguardarMensagemRegistrosAlterados();
		teste.acao.escreverNoElemento(campoCodigoItem, "1001");
		teste.teclado.pressionarTeclaDeControle(Keys.TAB);
		teste.rotina.aguardarProcessarRotina();
		teste.espera.aguardarAtributoDoElementoConterOValor(campoDescricaoItem, "value", "LAPISEIRA");
		teste.acao.escreverNoElemento(campoQtdeItem, "10");
		teste.teclado.pressionarTeclaDeControle(Keys.TAB);
		teste.rotina.aguardarProcessarRotina();
		teste.acao.escreverNoElemento(campoValorUn, "10");
		teste.rotina.salvarEAguardarMensagemRegistrosAlterados();
	}

}

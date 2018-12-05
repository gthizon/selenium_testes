package br.com.projedata.arcturus.teste.metodosgenericos;

import static br.com.projedata.arcturus.teste.webelements.GeradorRelatoriosElementos.estaProcessando;
import static br.com.projedata.arcturus.teste.webelements.GeradorRelatoriosElementos.tipoSaidaRelatorio;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class GeradorRelatoriosMetodos {

	TesteGenerico teste;

	public GeradorRelatoriosMetodos(TesteGenerico teste) {
		this.teste = teste;
	}

	public void aguardaProcessarGeradorRelatorios() {

		try {
			if (teste.webDriver.findElements(estaProcessando).size() != 0) {
				WebDriverWait wait = new WebDriverWait(teste.webDriver, 10);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(estaProcessando));
			}
		} catch (TimeoutException e) {
			teste.navegador.atualizarBrowser();
			aguardaProcessarGeradorRelatorios();
		}
	}

	public void salvarAlteracoesRelatorio() {

		try {
			teste.teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "s");
			teste.espera.aguardarElementoEstarVisivel(teste.msg.mensagemSucesso);
			teste.teclado.pressionarTeclaDeControle(Keys.ESCAPE);
			teste.espera.aguardarElementoDesaparecer(teste.msg.mensagemSucesso);
		} catch (TimeoutException e) {
			salvarAlteracoesRelatorio();
		}
	}

	public void selecionarTipoSaida(String tipo) {
		teste.acao.selecionarNoElemento(tipoSaidaRelatorio, tipo);
	}

}

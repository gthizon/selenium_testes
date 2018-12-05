package br.com.projedata.arcturus.teste.metodosgenericos;

import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.barraRolagemProximoRelatorio;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.barraRolagemProximoRelatorioDesabilitada;

import org.openqa.selenium.By;

import br.com.projedata.arcturus.teste.recursos.RotinaRecurso;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class MetodosGenericos {

	TesteGenerico teste;

	public MetodosGenericos(TesteGenerico teste) {
		this.teste = teste;
	}

	public boolean verificarSeElementoExiste(By elemento) {

		if (teste.webDriver.findElements(elemento).size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void selecionarElementoComDeterminadoValorEmUmBloco(String valor, By elemento, RotinaRecurso rotina) {
		rotina.aguardarProcessarRotina();
		teste.acao.clicarNoElemento(elemento, 0);
		rotina.aguardarProcessarRotina();
		rotina.limparCampoERealizarNovaConsulta();
		int posicao = 0;
		while (!teste.acao.localizarElementos(elemento).get(posicao).getAttribute("value").equals(valor)) {
			if (teste.acao.localizarElementos(barraRolagemProximoRelatorioDesabilitada).size() == 0) {
				teste.acao.clicarNoElemento(barraRolagemProximoRelatorio);
				rotina.aguardarProcessarRotina();
				posicao = -1;
			}
			posicao++;
		}
		teste.acao.clicarNoElemento(elemento, posicao);
		rotina.aguardarProcessarRotina();
	}

}

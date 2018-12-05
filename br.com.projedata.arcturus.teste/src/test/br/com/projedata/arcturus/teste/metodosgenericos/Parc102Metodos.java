package br.com.projedata.arcturus.teste.metodosgenericos;

import static br.com.projedata.arcturus.teste.webelements.Parc102Elementos.botaoListarAtualizacoesAplicadasPorAtualizacao;
import static br.com.projedata.arcturus.teste.webelements.Parc102Elementos.botaoListarAtualizacoesAplicadasPorCliente;
import static br.com.projedata.arcturus.teste.webelements.Parc102Elementos.campoClienteAtualizacaoAplicada;
import static br.com.projedata.arcturus.teste.webelements.Parc102Elementos.campoCodigoAtualizacaoAplicada;
import static br.com.projedata.arcturus.teste.webelements.Parc102Elementos.campoCodigoAtualizacaoFilaAplicacao;
import static br.com.projedata.arcturus.teste.webelements.Parc102Elementos.campoCodigoClienteFilaAplicacao;

import org.openqa.selenium.Keys;

import br.com.projedata.arcturus.teste.recursos.RotinaRecurso;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class Parc102Metodos {

	private TesteGenerico teste;

	public Parc102Metodos(TesteGenerico teste) {
		this.teste = teste;
	}

	public void listarClientes(int posicao, RotinaRecurso rotina) {
		String codigoAtualizacao = teste.acao.localizarElementoNaPosicao(campoCodigoAtualizacaoFilaAplicacao, posicao).getAttribute("value");
		teste.acao.clicarNoElemento(campoCodigoAtualizacaoFilaAplicacao, posicao);
		rotina.aguardarProcessarRotina();
		teste.acao.clicarNoElemento(botaoListarAtualizacoesAplicadasPorAtualizacao, posicao);
		rotina.aguardarProcessarRotina();
		teste.acao.clicarNoElemento(campoCodigoAtualizacaoAplicada, 0);
		rotina.aguardarProcessarRotina();
		int i = 0;
		while (!teste.acao.localizarElementoNaPosicao(campoCodigoAtualizacaoAplicada, i).getAttribute("value").isEmpty()) {
			teste.testar.passouSeAtributoDoElementoContem(campoCodigoAtualizacaoAplicada, i, "value", codigoAtualizacao);
			teste.teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			rotina.aguardarProcessarRotina();
			if (i < 5) {
				i++;
			} else {
				i = 5;
			}
		}
	}

	public void listarAtualizacoes(int posicao, RotinaRecurso rotina) {
		String codigoCliente = teste.acao.localizarElementoNaPosicao(campoCodigoClienteFilaAplicacao, posicao).getAttribute("value");
		teste.acao.clicarNoElemento(campoCodigoClienteFilaAplicacao, posicao);
		rotina.aguardarProcessarRotina();
		teste.acao.clicarNoElemento(botaoListarAtualizacoesAplicadasPorCliente, posicao);
		rotina.aguardarProcessarRotina();
		teste.acao.clicarNoElemento(campoClienteAtualizacaoAplicada, 0);
		rotina.aguardarProcessarRotina();
		int i = 0;
		int j = 0;
		while (j < 20 || teste.acao.localizarElementoNaPosicao(campoClienteAtualizacaoAplicada, i).getAttribute("value").isEmpty()) {
			teste.testar.passouSeAtributoDoElementoContem(campoClienteAtualizacaoAplicada, i, "value", codigoCliente);
			teste.teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			rotina.aguardarProcessarRotina();
			if (i < 5) {
				i++;
			} else {
				i = 5;
			}
			j++;
		}
	}

}

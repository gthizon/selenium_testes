package br.com.projedata.arcturus.teste.metodosgenericos;

import org.openqa.selenium.By;

import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class Parc119Metodos {
	private TesteGenerico teste;

	public Parc119Metodos(TesteGenerico teste) {
		this.teste = teste;
	}

	public By rotinasBloqueadas(String usuario) {
		return By.xpath("//div[@id='rotinas_bloqueadas']//parent::label[contains(text(),'Rotinas Bloqueadas por " + usuario + "')]");
	}

	public By objetosBloqueados(String usuario) {
		return By.xpath("//div[@id='objetos_negocio_bloqueados']//parent::label[contains(text(),'Objetos de Negócio Bloqueados por "
				+ usuario + "')]");
	}

	public void limparFiltros() {
		teste.acao.clicarNoElemento(teste.rotina, teste.rotina.botaoMostrarFiltros);
		teste.espera.aguardarElementoEstarVisivel("usuarioAtual-1");
		teste.acao.clicarNoElemento(teste.rotina, "usuarioAtual-1");
		teste.acao.limparElemento("usuarioAtual-1");
		teste.acao.clicarNoElemento(teste.rotina, "usuarioCriador-1");
		teste.acao.limparElemento("usuarioCriador-1");

		By removerAcao = By.xpath("//button[contains(@name,'acaoAtual-1-0-aux') and contains(@style,'red')]");
		By removerAcaoDesabilitado = By
				.xpath("//button[contains(@name,'acaoAtual-1-0-aux') and contains(@style,'red') and contains(@class,'desabilitado')]");

		while (teste.acao.localizarElementos(removerAcaoDesabilitado).size() == 0) {
			teste.acao.clicarNoElemento(removerAcao);
			teste.rotina.aguardarProcessarRotina();
		}
		teste.acao.limparElemento(teste.rotina, "acaoAtual-1-0");
	}

}

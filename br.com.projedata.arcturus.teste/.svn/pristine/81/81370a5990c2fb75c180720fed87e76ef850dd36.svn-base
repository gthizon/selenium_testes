package br.com.projedata.arcturus.teste.metodosgenericos;

import org.openqa.selenium.By;

import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class Parc001Metodos {
	private TesteGenerico teste;

	public Parc001Metodos(TesteGenerico teste) {
		this.teste = teste;
	}

	public By checkDiaDaSemana(String dia) {
		return By.xpath("//label[contains(@class,'etiqueta-label') and text()='" + dia
				+ "']//following::input[@type='checkbox'][1]");
	}

}

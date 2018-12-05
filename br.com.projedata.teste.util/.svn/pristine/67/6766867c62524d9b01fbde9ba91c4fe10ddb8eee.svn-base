package br.com.projedata.teste.util.recursos;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Teclado {

	private WebDriver webDriver;

	public Teclado(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void pressionarTeclaDeControle(Keys tecla) {
		Actions action = new Actions(webDriver);
		action.sendKeys(tecla).perform();
	}

	public void pressionarTeclaAlfanumerica(String tecla) {
		Actions action = new Actions(webDriver);
		action.sendKeys(tecla).perform();
	}

	public void pressionarConjuntoDeTeclas(Keys tecla1, String tecla2) {
		Actions action = new Actions(webDriver);
		action.keyDown(tecla1).sendKeys(tecla2).keyUp(tecla1).build().perform();
	}

	public void pressionarConjuntoDeTeclasDeControle(Keys tecla1, Keys tecla2) {
		Actions action = new Actions(webDriver);
		action.keyDown(tecla1).sendKeys(tecla2).keyUp(tecla1).build().perform();
	}

	public String retornarCaracterBarra() {
		return "\uE029";
	}
}

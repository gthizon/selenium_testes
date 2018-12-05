package br.com.projedata.teste.util.recursos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Mouse {

	private WebDriver webDriver;
	private Acao acao;

	public Mouse(WebDriver driver, Acao acao) {
		this.webDriver = driver;
		this.acao = acao;
	}

	public void moverCursorParaElemento(By elemento) {
		Actions action = new Actions(webDriver);
		action.moveToElement(localizarElemento(elemento)).build().perform();
	}
	
	public void moverCursorParaElemento(String elemento) {
		By componente = acao.localizarComponente(elemento);
		Actions action = new Actions(webDriver);
		action.moveToElement(localizarElemento(componente)).build().perform();
	}

	public void doubleClick(By elemento) {
		Actions action = new Actions(webDriver);
		action.moveToElement(localizarElemento(elemento)).doubleClick().perform();
	}
	
	public void doubleClick(String elemento) {
		By componente = acao.localizarComponente(elemento);
		Actions action = new Actions(webDriver);
		action.moveToElement(localizarElemento(componente)).doubleClick().perform();
	}

	private WebElement localizarElemento(By elemento) {
		return webDriver.findElement(elemento);
	}

	public void click(By elemento) {
		Actions action = new Actions(webDriver);
		action.moveToElement(localizarElemento(elemento)).click().perform();
	}
	
	public void click(String elemento) {
		By componente = acao.localizarComponente(elemento);
		Actions action = new Actions(webDriver);
		action.moveToElement(localizarElemento(componente)).click().perform();
	}

	public void scrollParaElemento(By elemento) {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", localizarElemento(elemento));
	}
	
	public void scrollParaElemento(String elemento) {
		By componente = acao.localizarComponente(elemento);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", localizarElemento(componente));
	}

	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("scroll(0, 250)");
	}

	public void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("scroll(-10, 0)");
	}

}

package br.com.projedata.arcturus.teste.metodosgenericos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class PortalMetodos {
	private TesteGenerico teste;
	
	public PortalMetodos(TesteGenerico teste) {
		this.teste = teste;
	}
	
	public By ligarDesligarPaineis(String painel) {
		return By.xpath("//div[@class='portal-menu-painel-opcao' and text()='" + painel
				+ "']//following::span[@class='slider'][1]");
	}

	public boolean painelDesligado(String painel) {
		WebElement element = teste.webDriver.findElement(By.xpath("//div[@class='portal-menu-painel-opcao' and text()='"
				+ painel + "']//following::span[@class='slider'][1]"));
		boolean ligado = element.isSelected();
		if (!ligado) {
			return true;
		}
		return false;
	}

	public boolean painelLigado(String painel) {
		WebElement element = teste.webDriver.findElement(By.xpath("//div[@class='portal-menu-painel-opcao' and text()='"
				+ painel + "']//following::span[@class='slider'][1]"));
		boolean ligado = element.isSelected();
		if (ligado) {
			return true;
		}
		return false;
	}

	public By painelPortal(String painel) {
		return By.xpath("//div[@class='panel panel-widget']//parent::div[contains(text(),'" + painel + "')]");
	}
	
	public By dicaDeCampo(String dica) {
		return By.xpath("//div[@class='tooltip-inner' and contains(text(),'"+dica+"')]");
	}

}

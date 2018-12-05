package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

public class Parc008Elementos {
	
	public static By campoIdConsulta = By.xpath("//input[contains(@id,'arcconsultaId')]"); 
	public static By campoComando = By.xpath("//textarea[contains(@id,'arcconsultaComandoConsulta')]"); 
	public static By campoNomeConsulta = By.xpath("//input[contains(@id,'arcconsultaNome-1')]"); 
	public static By campoChaveConsulta = By.xpath("//input[contains(@id,'arcconsultaChave-1')]"); 
	public static By botaoCarregarConsulta = By.xpath("//button[contains(@id,'arcconsultaBotaoCarregar-1')]"); 
	public static By campoColunaConsulta = By.xpath("//input[contains(@id,'arcconsultacolunaColuna')]"); 
	public static By campoTipoDadoConsulta = By.xpath("//select[contains(@id,'arcconsultacolunaTipoDado')]"); 
}

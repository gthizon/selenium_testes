package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

public class Parc011Elementos {

	public static By campoId = By.xpath("//input[contains(@id,'campo17049')]");
	public static By campoCodigo = By.xpath("//input[contains(@id,'arcareaCodigo')]");
	public static By campoNome = By.xpath("//input[contains(@id,'campo17052')]");
	public static By campoSituacao = By.xpath("//select[contains(@id,'campo17050')]");
	public static By campoOrdem = By.xpath("//input[contains(@id,'campo17051')]");
	public static By barraRolagemProximoRegistro = By.xpath(
			"//*[@id='barra_rolagem18545']//following-sibling::div[contains(@class,'proximo botao-navegacao')][1]");

}

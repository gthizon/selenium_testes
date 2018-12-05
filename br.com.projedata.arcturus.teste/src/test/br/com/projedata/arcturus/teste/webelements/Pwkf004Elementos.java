package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class Pwkf004Elementos extends TesteGenerico{
	
	public static By usuarioDestino = By.xpath("//button[contains(@name,'usuarioDestino-1-0')]");
	public static By campoAssunto = By.xpath("//input[contains(@id,'assunto-1-0')]");
	public static By campoSolicitanteOrigem = By
			.xpath("//textarea[contains(@id,'.c_7-1-0') and contains(@style,'height: 18px')]");
	public static By campoSolicitanteExpandido = By
			.xpath("//textarea[contains(@id,'.c_7-1-0') and (contains(@style,'height: 63px') or contains(@style,'height: 73px')]");
	public static By campoSolicitante = By.xpath("//textarea[contains(@id,'.c_7-1-0')]");
	public static By selecionaDestino = By.xpath("//td[contains(text(),'ATENDIMENTO COMERCIAL')]");

}

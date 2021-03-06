package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class Parc004Elementos extends TesteGenerico{
	
	public static By campoIdSistema = By.xpath("//input[contains(@id,'componente14849-1')]");
	public static By campoCodigoSistema = By.xpath("//input[contains(@id,'componente14848-')]");
	public static By campoDescricaoMenu = By.xpath("//input[contains(@id,'componente14850-')]");
	public static By campoIdItemRotina = By.xpath("//input[contains(@id,'arcmenuitId')]");
	public static By campoTipoItem = By.xpath("//select[contains(@id,'componente14879-')]");
	public static By campoIdRotina = By.xpath("//input[contains(@id,'componente14880')]");
	public static By campoSubmenu = By.xpath("//input[contains(@id,'campo14896')]");
	public static By botaoLovSubmenu = By.xpath("//button[contains(@name,'campo14896')]");
	public static By campoOrdemItem = By.xpath("//input[contains(@id,'componente14878-')]");
	public static By menuTeste = By.linkText("Teste");
	public static By subMenuTeste = By.xpath("//div[@class='portal-menu-titulo']//following::a[contains(text(),'Teste')][2]");
	public static By subMenuAutomation = By.xpath("//div[@class='portal-menu-titulo']//following::a[contains(text(),'automation')]");
	public static By rotinaMenuAutomation = By.xpath("//div[@class='portal-menu-titulo' and contains(text(),'automation')]//following::a[contains(text(),'Grupos de Ace')]");
}

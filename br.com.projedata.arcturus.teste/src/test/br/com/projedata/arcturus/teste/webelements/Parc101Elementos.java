package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class Parc101Elementos extends TesteGenerico {
		
	public static By campoDescricaoAcao = By.xpath("//input[contains(@id,'ARCATUALIZADORACAOTitulo-')]");
	public static By campoTipoAcao = By.xpath("//select[contains(@id,'ARCATUALIZADORACAOIconeClasse-')]");
	public static By campoTipoEspecial = By.xpath("//select[contains(@id,'ARCATUALIZADORACAOTipo-')]");
	public static By campoFilaUnica = By.xpath("//select[contains(@id,'ARCATUALIZADORACAOFilaUnica-')]");
	public static By barraRolagemAcao = By.xpath("//*[@id=\"barra_rolagem145898\"]/div[1]");
	public static By campoIdParticipante = By.xpath("//input[contains(@id,'lov145908')]");
	public static By campoBotaoParticipante = By.xpath("//button[contains(@name,'lov145908-')]");
	public static By campoDescricaoParticipante = By.xpath("//input[contains(@id,'ARCATUALIZADORACAOUSUARIONomeUsuario')]");
	public static By barraRolagemParticipante = By.xpath("//*[@id=\"barra_rolagem145904\"]/div[1]");
	public static By campoIdAcaoDestino = By.xpath("//input[contains(@id,'idAcaoDestino')]");
	public static By campoBotaoAcaoDestino = By.xpath("//button[contains(@name,'idAcaoDestino-')]");
	public static By campoDescricaoAcaoDestino = By.xpath("//input[contains(@id,'ARCATUALIZADORACAODESTINONomeAcao')]");
	public static By barraRolagemAcaoDestino = By.xpath("//*[@id=\"barra_rolagem145907\"]/div[1]");
	public static By campoIdAcaoWorkflow = By.xpath("//input[contains(@id,'lov145909')]");
	public static By campoBotaoAcaoWorkflow = By.xpath("//button[contains(@name,'lov145909-')]");
	public static By campoDescricaoAcaoWorkflow = By.xpath("//input[contains(@id,'ARCATUALIZADORACAODESTINONovo_item_82866')]");
	public static By barraRolagemAcaoWorkflow = By.xpath("//*[@id=\"barra_rolagem145911\"]/div[1]");

}

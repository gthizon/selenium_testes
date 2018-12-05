package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

public class Parc002Elementos {
	
	public static By campoIdSistema = By.xpath("//input[contains(@id,'arcsistemaId')]");
	public static By campoCodigoSistema = By.xpath("//input[contains(@id,'arcsistemaCodigo')]");
	public static By campoNomeSistema = By.xpath("//input[contains(@id,'arcsistemaNome')]");
	public static By campoIdArea = By.xpath("//input[contains(@id,'arcsistemaIdArea')]");
	public static By campoNomeArea = By.xpath("//input[contains(@id,'arcsistemaNomeArea')]");
	public static By campoIdRotina = By.xpath("//input[contains(@id,'arcrotinaId')]");
	public static By campoChaveRotina = By.xpath("//input[contains(@id,'arcrotinaChave')]");
	public static By campoNomeRotina = By.xpath("//input[contains(@id,'arcrotinaNome')]");
	public static By campoPermiteDestacarRotina = By.xpath("//select[contains(@id,'arcrotinaPermiteDestacar')]");
	public static By campoConexaoLocal = By.xpath("//select[contains(@id,'arcrotinaConexaoLocal')]");
	public static By campoTipoRotina = By.xpath("//select[contains(@id,'arcrotinaTipo')]");
	public static By campoIdMenu = By.xpath("//input[contains(@id,'arcmenuitIdMenu')]");
	public static By campoDescricaoMenu = By.xpath("//input[contains(@id,'arcmenuitDsMenu')]");
	public static By campoDescricaoSistemaMenu = By.xpath("//input[contains(@id,'arcmenuitDsSistema')]");
	public static By campoTipoMenu = By.xpath("//select[contains(@id,'arcmenuitTipo')]");
	public static By campoOrdemMenu = By.xpath("//input[contains(@id,'arcmenuitOrdem')]");
	
}

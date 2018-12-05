package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

public class Parc100Elementos {

	public static By campoCodigoCliente = By.xpath("//input[contains(@id,'ARCCLIENTEId-')]");
	public static By campoNomeCliente = By.xpath("//input[contains(@id,'ARCCLIENTENome-')]");
	public static By campoSituacao = By.xpath("//select[contains(@id,'ARCCLIENTESituacao-')]");
	public static By campoPadrao = By.xpath("//select[contains(@id,'ARCCLIENTEPadrao-')]");
	public static By campoExterno = By.xpath("//select[contains(@id,'ARCCLIENTEExterno-')]");
	public static By campoPermiteAtualizacao = By.xpath("//select[contains(@id,'ARCCLIENTEPermiteAtualizacao-')]");
	public static By barraRolagemCliente = By.xpath("//*[@id=\"barra_rolagem_clientes\"]/div[1]");
	public static By abaConexoes = By.xpath("//div[@class='titulo']//p[contains(text(),'Conexões')]");
	public static By campoNomeConexao = By.xpath("//input[contains(@id,'ARCCLIENTECONEXAONome-')]");
	public static By campoEnderecoConexao = By.xpath("//input[contains(@id,'ARCCLIENTECONEXAOEndereco-')]");
	public static By campoPortaConexao = By.xpath("//input[contains(@id,'ARCCLIENTECONEXAOPorta-')]");
	public static By campoTipoConexao = By.xpath("//select[contains(@id,'ARCCLIENTECONEXAOTipo-')]");
	public static By campoSituacaoConexao = By.xpath("//select[contains(@id,'ARCCLIENTECONEXAOSituacao-')]");
	public static By barraRolagemConexao = By.xpath("//*[@id=\"barra_rolagem_Conexoes\"]/div[1]");
	public static By abaCorrentistas = By.xpath("//div[@class='titulo']//p[contains(text(),'Correntistas')]");
	public static By campoNomeCorrentista = By.xpath("//input[contains(@id,'ARCCLIENTECORRENTISTANome-')]");
	public static By campoCnpjCorrentista = By.xpath("//input[contains(@id,'ARCCLIENTECORRENTISTACnpj-')]");
	public static By barraRolagemCorrentista = By.xpath("//*[@id=\"barra_rolagem_correntistas\"]/div[1]");
	public static By campoNomeAmbiente = By.xpath("//input[contains(@id,'ARCAMBIENTENovo_item_83619-')]");
	public static By campoSituacaoAmbiente = By.xpath("//select[contains(@id,'Situação Ambiente-')]");
	public static By campoTipoAmbiente = By.xpath("//select[contains(@id,'Tipo ambiente-')]");
	public static By barraRolagemAmbiente = By.xpath("//*[@id=\"barra_rolagem148323\"]/div[1]");
	public static By abaBases = By.xpath("//div[contains(@class,'titulo')]//p[contains(text(),'Bases')]");
	public static By campoNome = By.xpath("//input[contains(@id,'ARCBASENome-')]"); 
	public static By campoDescricaoBase = By.xpath("//input[contains(@id,'ARCBASENovo_item_84026-')]"); 
	public static By campoEnderecoBase = By.xpath("//input[contains(@id,'ARCBASEEndereco-')]"); 
	public static By campoPortaBase = By.xpath("//input[contains(@id,'ARCBASEPorta-')]"); 
	public static By campoNomeBase = By.xpath("//input[contains(@id,'ARCBASENomeBase-')]"); 
	public static By campoAtivaBase = By.xpath("//select[contains(@id,'ARCBASEAtiva-')]");
	public static By campoVisivelBase = By.xpath("//select[contains(@id,'ARCBASEVisivel-')]");
	public static By campoConexaoLocal = By.xpath("//select[contains(@id,'ARCBASEConexaoLocal-')]");
	public static By campoTipoBase = By.xpath("//select[contains(@id,'ARCBASETipo-')]");
	public static By barraRolagemBase = By.xpath("//*[@id=\"barra_rolagem145887\"]/div[1]");
	public static By campoUsuarioAdmin = By.xpath("//input[contains(@id,'ARCBASEUsuarioAdmin-')]"); 
	public static By campoSenhaAdmin = By.xpath("//input[contains(@id,'ARCBASESenhaAdmin-')]"); 
	public static By campoUsuarioAcesso = By.xpath("//input[contains(@id,'ARCBASEUsuarioAcesso-')]"); 
	public static By campoSenhaAcesso = By.xpath("//input[contains(@id,'ARCBASESenhaAcesso-')]"); 
	public static By campoUsuarioSO = By.xpath("//input[contains(@id,'ARCBASEUsuarioSo-')]"); 
	public static By campoSenhaSo = By.xpath("//input[contains(@id,'ARCBASESenhaUsuarioSo-')]"); 
	public static By campoContrato = By.xpath("//input[contains(@id,'ARCBASENumeroContrato-')]"); 
	public static By campoBotaoContrato = By.xpath("//button[contains(@name,'ARCBASENumeroContrato-')]");
	
}

package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

public class Parc102Elementos {
	
	public static By campoCodigoAtualizacaoFilaAplicacao = By.xpath("//input[contains(@id,'idAtualizacao')]");
	public static By botaoListarAtualizacoesAplicadasPorAtualizacao = By.xpath("//button[contains(@id,'botaoListarPorAtualizacao')]");
	public static By campoCodigoClienteFilaAplicacao = By.xpath("//input[contains(@id,'ARCFILAAPLICAATUALIZACAOIdCliente')]");
	public static By botaoLovClienteFilaAplicacao = By.xpath("//button[contains(@name,'ARCFILAAPLICAATUALIZACAOIdCliente')]");
	public static By campoNomeClienteFilaAplicacao = By.xpath("//input[contains(@id,'nomeCliente')]");
	public static By botaoListarAtualizacoesAplicadasPorCliente = By.xpath("//button[contains(@id,'botaoListarPorCliente')]");
	public static By campoNomeUsuarioFilaAplicacao = By.xpath("//input[contains(@id,'nomeUsuario')]");
	public static By campoDataInicio = By.xpath("//input[contains(@id,'dataInicio')]");
	public static By campoDataPrevista = By.xpath("//input[contains(@id,'previsaoAplicacao')]");
	public static By botaoCancelarAtualizacao = By.xpath("//button[contains(@id,'botaoCancelar')]");
	public static By campoCodigoAtualizacaoAplicada = By.xpath("//input[contains(@id,'ARCATUALIZACAOAPLICADAIdAtualizacao')]");
	public static By campoVersaoAtualizacao = By.xpath("//input[contains(@id,'ARCATUALIZACAOAPLICADANovo_item_83106')]");
	public static By campoClienteAtualizacaoAplicada = By.xpath("//input[contains(@id,'lov146738')]");
	public static By botaoLovClienteAplicadas = By.xpath("//button[contains(@name,'lov146738')]");
	public static By campoNomeClienteAplicadas = By.xpath("//input[contains(@id,'ARCATUALIZACAOAPLICADANovo_item_83110')]");
	public static By campoBaseAplicada = By.xpath("//input[contains(@id,'ARCATUALIZACAOAPLICADANovo_item_83107')]");
	public static By campoUsuarioAplicacao = By.xpath("//input[contains(@id,'ARCATUALIZACAOAPLICADANovo_item_83108')]");
	public static By campoDataAplicacao = By.xpath("//input[contains(@id,'ARCATUALIZACAOAPLICADAData')]");
}

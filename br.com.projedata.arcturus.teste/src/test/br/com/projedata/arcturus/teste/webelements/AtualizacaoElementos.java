package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

public class AtualizacaoElementos {

	public static By versaoSistema = By.xpath("//span[@class='versao-sistema']");
	public static By menuAplicarAtualizacoes = By.linkText("Aplicar Atualizações");
	public static By baseHomologacao = By.partialLinkText("homologacao");
	public static By atualizacaoParaAplicar = By.xpath("//span[text()='2018.09.5']");
	public static By marcarAtualizacaoParaAplicar = By.xpath("//*[@id='conteudo']/div[1]/div/div[2]/section/div[1]/div[3]/div/div[3]/div[2]/div[2]/table/tbody/tr/td[1]/input");
	public static By botaoAplicar = By.xpath("//button[@ng-click='aplica()']");
	public static By confirmaAplicacao = By.xpath("//button[@data-type='yes']");
	public static By mensagemVersaoInferior = By.xpath("//span[contains(text(),'Esta atualização requer a versão')]");
	public static By okMensagemAtualizador = By.xpath("//button[@data-type='ok']");
}

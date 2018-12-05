package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

public class Parc005Elementos {
	
	public static By campoCodigoSistema(int linha) {
		return By.xpath("//input[contains(@id,'arcacessogrupoIdSistema-"+linha+"-0')]");
	}
	public static By campoAcessoTotal(int linha) {
		return By.xpath("//select[contains(@id,'arcacessogrupoAcessoTotal-"+linha+"-0')]");
	}
	public static By campoNomeGrupo(int linha) {
		return By.xpath("//input[contains(@id,'arcacessogrupoNome-"+linha+"-0')]");
	}
	
	public static By botaoCarregarRotinas(int linha) {
		return By.xpath("//button[contains(@id,'arcacessogrupoBotaoCarregar-"+linha+"-0')]");
	}
	
	public static By campoCodigoRotina(int linha) {
		return By.xpath("//input[contains(@id,'arcacessogruporotinaIdRotina-"+linha+"-0')]");
	}

	public static By campoIdSistema(int linha) {
		return By.xpath("//input[contains(@id,'arcacessogrupoId-"+linha+"-0')]");
	}
	public static By campoDescricaoSistema(int linha) {
		return By.xpath("//input[contains(@id,'arcacessogrupoNome-"+linha+"-0')]");
	}

}

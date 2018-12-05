package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

public class PainelRelatoriosElementos {

	public static By botaoAdicionarPasta = By.xpath("//div[@title = 'Adicionar Pasta']");
	public static By modalAlterarGrupo = By.id("modalAlterarGrupo");
	public static By campoNomeGrupo = By.id("grupo-nome");
	public static By botaoConfirmarGrupo = By.xpath("//div[@id='modalAlterarGrupo']//parent::button[contains(text(),'Confirmar')]");
	public static By botaoAlterarPasta = By.xpath("//b[contains(text(),'rger307')]//following::td[@title='Alterar pasta'][1]");
	public static By modalSelecionarGrupo = By.id("modalGrupoRelatorio");
	public static By selecionarSubPasta1 = By.xpath("//span[contains(text(),'Mover para pasta')]//following::td[contains(text(),'teste')]");
	public static By abrirSubPasta1 = By.xpath("//div[@class='item nome-pasta']//following::p[@class='nome' and contains(text(),'teste')]");
	public static By botaoAbrirModalExcluirPasta = By.xpath("//p[contains(text(),'Grupo 1')]//following::div[@class='item']");
	public static By botaoExcluirPasta = By.xpath("//button[contains(text(),' Excluir pasta')]");
	public static By botaoAtualizarListaRelatorios = By.xpath("//div[contains(text(),'Relatórios')]//following::i[@class='fa fa-refresh'][1]");
	public static By botaoAbrirPger001 = By.xpath("//div[@title='Abrir Gerador de Relatórios']");
	
	public static By selecionarGrupo(String grupo) {
		return By.xpath("//div[@class='item nome-pasta']//following::p[@class='nome' and contains(text(),'"+grupo+"')]");
	}
	
	public static By selecionarPastaParaMoverRelatorio(String grupo) {
		return By.xpath("//span[contains(text(),'Mover para pasta')]//following::td[contains(text(),'"+grupo+"')]");
	}
	
	public static By botaoMoverParaPasta(String relatorio) {
		return By.xpath("//b[(text()='"+relatorio+"')]//following::td[1]");
	}
	
	public static By abrirPasta(String pasta) {
		return By.xpath("//div[@class='item nome-pasta']//parent::p[contains(text(),'"+pasta+"')]");
	}
	public static By navegarParaPastaSeguinte(String pasta) {
		return By.xpath("//td[contains(text(),'"+pasta+"')]//following::i[@class='fa fa-chevron-right']");
	}
	
}






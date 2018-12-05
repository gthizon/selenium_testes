package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

public class Teste02Elementos {

	public static By botaoAbrirRotinaModal = By.xpath("//button[contains(@id,'arctesteBotaoAbrirRotina')]");
	public static By rotinaModalAberta = By.xpath("//p[contains(text(),'ARC001')]");
	public static By rotinaModalCarregada = By.xpath(
			"//p[contains(text(),'ARC001')]//following::li[contains(@class,'info-navegacao')]//child::span[contains(text(),'1/1')]");
	public static By fecharRotinaPrincipal = By
			.xpath("//p[contains(text(),'TESTE02')]//following::*[@title='Fechar'][1]");
	public static By mensagemRotinaFinalizada = By.xpath("//div[contains(text(),'Rotina finalizada com sucesso.')]");
	public static By fecharRotinaModal = By.xpath("//p[contains(text(),'ARC001')]//following::*[@title='Fechar']");
	public static By maximizarRotinaModal = By
			.xpath("//p[contains(text(),'ARC001')]//following::div[@title='Restaurar']");
	public static By minimizarRotinaModal = By
			.xpath("//p[contains(text(),'ARC001')]//following::div[@title='Minimizar']");
	public static By campoValorBlocoMaster = By.xpath("//*[contains(@id,'.arctesteValor')]");
	public static By campoNome = By.xpath("//*[contains(@id,'.arctesteNome')]");
	public static By campoSituacao = By.xpath("//*[contains(@id,'.arctesteSituacao')]");
	public static By campoCodigo = By.xpath("//*[contains(@id,'.arctesteCodigo')]");
	public static By campoNomeBlocoDetail = By.xpath("//input[contains(@id,'.arctesteitNome-')]");
	public static By campoNomeListaBlocoDetail = By.xpath("//input[contains(@id,'.arctesteitNomeLista')]");
	public static By descricaoCampoLovBlocoDetail = By.xpath("//textarea[contains(@id,'.c_99996_aux')]");
	public static By campoComboBox = By.xpath("//*[contains(@id,'.c_99999')]");
	public static By campoNumerico = By.xpath("//*[contains(@id,'.c_99998')]");
	public static By campoDataTabelaDinamica = By.xpath("//*[contains(@id,'.c_99995')]");
	public static By campoMultivalorado = By.xpath("//textarea[contains(@id,'.c_99997')]");
	public static By campoCodigoLov = By.xpath("//input[contains(@id,'.c_99996')]");
	public static By campoDescricaoListaBlocoMaster = By.xpath("//*[contains(@id,'arctesteDescricaoLista')]");
	public static By campoCodigoListaBlocoMaster = By.xpath("//*[contains(@id,'.arctesteIdLista')]");
	public static By campoCodigoListaBlocoDetail = By.xpath("//input[contains(@id,'.arctesteitIdentificacaoLista')]");
	public static By botaoPermiteExclusao = By.xpath("//*[contains(@id,'.botaoPermiteExclusao')]");
	public static By botaoPermiteAlteracao = By.xpath("//*[contains(@id,'.botaoPermiteAlteracao')]");
	public static By botaoPermiteInclusao = By.xpath("//*[contains(@id,'.botaoPermiteInclusao')]");
	public static By botaoabrirLovCampoListaBlocoMaster = By.xpath("//*[contains(@name,'.arctesteIdLista')][1]");
	public static By botaoCalendarioTabelaDinamica = By
			.xpath("//i[@class='fa fa-calendar-check-o']//ancestor::button[contains(@name,'c_99995-1-0-aux')]");
	public static By campoQtde = By.xpath("//*[contains(@id,'.parametrosTesteQuantidade')]");
	public static By campoQtdeItens = By.xpath("//*[contains(@id,'.parametrosTesteitQuantidade')]");
	public static By botaoLovIdLista = By.xpath("//button[contains(@name, 'arctesteIdLista')][1]");
	public static By botaoCalendarioCampoData = By.xpath("//i[@class='fa fa-calendar-check-o']//ancestor::button[contains(@name,'arctesteDataCadastro-1-0-aux')]");
	public static By campoData = By.xpath("//*[contains(@id,'arctesteDataCadastro-1')]");

}

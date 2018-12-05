package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

public class RotinasAtualizadorElementos {

	public static By menuRotinas = By.linkText("Rotinas");
	public static By telaRotinas = By.xpath("//*[contains(@ng-controller,'AtualizadorRotinasControlador')]");
	public static By selecionarRotina = By.xpath("//td[3][contains(text(),'PWKF007')]");
	public static By detalhesRotina = By.xpath("//*[(@class='my-fade-animation') and (@ng-show='mostraDetalhesRotina && !mostraDetalhesVersoesRotina')]");
	public static By botaoHistoricoVersoes = By.xpath("//*[contains(@ng-click,'mostraHistorico(rotina)')]");
	public static By telaHistoricoVersoes = By.xpath("//*[(@class='my-fade-animation') and (@ng-show='mostraDetalhesVersoesRotina')]");
	public static By botaoCriarPrimeiraVersao = By.xpath("//*[@ng-click='confirmaCriarRascunho()' and @class='btn btn-primary ng-scope']");
	public static By mensagemConfirmaCriacaoRascunho = By.xpath("//*[contains(text(),'Confirma criação de um rascunho?')]");
	public static By simNotificacao = By.xpath("//*[contains(@data-type,'yes')]");
	public static By mensagemRascunhoCriado = By.xpath("//*[contains(text(),'Rascunho criado com sucesso!')]");
	public static By botaoCriarNovaVersao = By.xpath("//*[@class='flaticon flaticon-approval-symbol-in-badge']//following::td[7]/a/i");
	public static By janelaCriarNovaVersaoRotina = By.xpath("//*[contains(text(),'Criar nova versão rotina')]");
	public static By botaoConfirmarCriarNovaVersaoRotina = By.xpath("//*[(@class='btn btn-success') and (@ng-click='confirmaCriarRascunho()')]");
	public static By campoBuscaRotina = By.xpath("//input[@ng-model='busca']");
	public static By descricaoDaVersao = By.id("versao-descricao");
	public static By mensagemDescricaoVersaoInvalida = By.xpath("//*[contains(text(),'Informe a descrição técnica da alteração!')]");
		
}

package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

public class Parc015Elementos {
	
	public static By campoCpfUsuario = By.xpath("//input[contains(@id,'sessoesCodigoUsuario')]");
	public static By campoNomeUsuario = By.xpath("//input[contains(@id,'sessoesNomeUsuario')]");
	public static By campoLicenca = By.xpath("//input[contains(@id,'sessoesLicenca')]");
	public static By campoIp = By.xpath("//input[contains(@id,'sessoesIpOrigem')]");
	public static By campoData = By.xpath("//input[contains(@id,'sessoesDataCriacao')]");
	public static By campoUltimaConexao = By.xpath("//input[contains(@id,'sessoesDataUltimaConexao')]");
	public static By campoBaseDados = By.xpath("//input[contains(@id,'sessoesNomeBase')]");
	public static By campoCodigoEmpresa = By.xpath("//input[contains(@id,'sessoesCodigoEmpresa')]");
	public static By campoNomeEmpresa = By.xpath("//input[contains(@id,'sessoesNomeEmpresa')]");
	public static By botaoFinalizarSessao = By.xpath("//button[contains(@id,'sessoesBtFinalizar')]");
	public static By campoCodigoRotinaEmExecucao = By.xpath("//input[contains(@id,'rotinasRotina')]");
	public static By campoDescricaoRotinaEmExecucao = By.xpath("//input[contains(@id,'rotinasDsRotina')]");
	public static By campoRotinaDataAbertura = By.xpath("//input[contains(@id,'rotinasDataAbertura')]");
	public static By botaoEnviarMsgTodasSessoes = By.xpath("//button[contains(@id, 'sessoesBt_notificar_todos-1')]");
	public static By botaoEnviarMsgParaSessao = By.xpath("//button[contains(@id, 'sessoesBt_notificar')]");
	public static By campoTextoNotificacao = By.xpath("//textarea[contains(@id,'sessoesTextoNotificacao-')]");
	public static By campoDuracaoNotificacao = By.xpath("//input[contains(@id,'sessoesNovo_item_88360')]");
	public static By botaoEnviarNotificacao = By.xpath("//button[contains(@id,'botaoEnviarNotificacao')]");

}

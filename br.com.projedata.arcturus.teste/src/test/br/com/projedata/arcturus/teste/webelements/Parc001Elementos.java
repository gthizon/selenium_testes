package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class Parc001Elementos {

	TesteGenerico teste = new TesteGenerico();

	public static By campoCodigoArc001 = By.xpath("//input[contains(@id,'campo2799-1')]");
	public static By campoAlterarSenhaArc001 = By.xpath("//select[contains(@id,'arcusuarioAlterarSenha-1')]");
	public static By campoCodigoBaseArc001 = By.xpath("//input[contains(@id,'campo2809-1-')]");
	public static By campoCodigoBaseArc001Linha2 = By.xpath("//input[contains(@id,'campo2809-2')]");
	public static By campoCodigoBaseNovoRegistorArc001 = By.xpath("//input[contains(@id,'campo2809-10')]");
	public static By mensagemSemResultadoParaValorCampoBase = By
			.xpath("//*[contains(text(),'Sem resultado para o valor informado no campo Base Emp.!')]");
	public static By mensagemValorInvalidoCampoBase = By
			.xpath("//*[contains(text(),'Valor inválido para  Base Emp.!') or contains(text(),'não permitida')]");
	public static By barraRolagemRegistroAnterior = By.xpath("//*[@id=\"barra_rolagem18658\"]/div[1]");
	public static By barraRolagemPaginaAnterior = By.xpath("//div[@class='pagina-anterior botao-navegacao']");
	public static By campoUsuarioCopiarAcesso = By.xpath("//input[contains(@id,'copiarparametrosCodigoUsuario-1-0')]");
	public static By botaoLovUsuarioCopiarAcesso = By
			.xpath("//button[contains(@name,'copiarparametrosCodigoUsuario-1-0')]");
	public static By campoBaseEmpresaCopiarAcesso = By
			.xpath("//input[contains(@id,'copiaparametrosIdBaseEmpresa-1-0')]");
	public static By botaoLovBaseEmpresaCopiarAcesso = By
			.xpath("//button[contains(@name,'copiaparametrosIdBaseEmpresa-1-0-aux')]");
	public static By botaoCarregarAcessos = By.xpath("//button[contains(@id,'botaoCarregarAcessos-1-0')]");
	public static By verificarTotalDeRotinasAbertasArc001 = By.xpath("//p[contains(text(),'(ARC001)')]");
	public static By botaoCarregarImagem = By.xpath("//input[contains(@id,'campo16448-1-0')]");
	public static By botaoEditarImagem = By.xpath("//input[contains(@id,'campo16448-1-0')]");
	public static By botaoRemoverImagem = By
			.xpath("//i[@class='fa fa-close']//ancestor::button[contains(@name,'campo16448-1-0-aux')]");
	public static By imagemCarregada = By
			.xpath("//*[contains(@id,'janela-rotina')]/div[2]/div[1]/div[3]/div[10]/div/div/div/img");
	public static By botaoAbrirLovGrupoEmpresa = By.xpath("//button[contains(@name,'campo15052-1-0-aux')]");
	public static By rotinaSelecionadaNaLista = By
			.xpath("//div[@id='parc001' and contains(@class,'rotina-item selecionado')]");
	public static By botaoAbrirOutraRotina = By.xpath("//button[@class='btn-abrirOutra atalho-a']");
	public static By botaoMostrarRotinaAberta = By.xpath("//button[@class='btn-mostrarAberta atalho-m']");
	public static By botaoCancelarAberturaRotina = By.xpath("//button[@class='btn-cancelar atalho-c']");
	public static By mensagemUsuarioSeraBloqueado = By
			.xpath("//*[contains(text(),'O usuário será bloqueado caso a tentativa de login falhe outra vez.')]");
	public static By mensagemUsuarioBloqueado = By.xpath("//*[contains(text(),'Usuário com acesso bloqueado.')]");
	
	public static By campoSituacaoUsuario = By.xpath("//select[contains(@id,'campo2804')]");
	public static By campoRegraAcesso = By.xpath("//select[contains(@id,'arcusuarioctrlacessoRegra-1-0')]");
	public static By campoHoraInicio = By.xpath("//input[contains(@id,'arcusuarioctrlacessoHorarioInicio')]");
	public static By campoHoraFim = By.xpath("//input[contains(@id,'arcusuarioctrlacessoHorarioFim')]");
	public static By checkFinalizaSessaoAtiva = By.xpath("//input[contains(@id,'arcusuarioctrlacessoFinalizaSessaoAtiva')]");
	public static By campoDataInicio = By.xpath("//input[contains(@id,'arcusuarioctrlacessoDataInicio-') and contains(@class,'elemento')]");
	public static By campoDataFim = By.xpath("//input[contains(@id,'arcusuarioctrlacessoDataFim-') and contains(@class,'elemento')]");
	public static By abaConfiguracoes = By.xpath("//div[@class='titulo']//p[contains(text(),'Configurações')]");
	public static By mensagemAcessoBloqueado = By.xpath("//div[@class='titulo selecionado']//p[contains(text(),'Configurações')]");
	public static By mensagemUsuarioBloqueadoPelasRegrasDeAcesso = By.xpath("//*[contains(text(),'Acesso bloqueado')]");

}

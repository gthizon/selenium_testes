package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

public class Pger001Elementos {

	public static By botaoNovoRelatorio = By.xpath("//button[contains(@id,'botaoNovoRelatorio')]");
	public static By botaoLiberarRelatorio = By.xpath("//button[contains(@id,'botaoLiberar')]");
	public static By botaoBloquearHabilitado = By.xpath("//button[contains(@id,'botaoBloquear')]");
	public static By botaoBloquearDesabilitado = By.xpath("//button[contains(@id,'botaoBloquear') and @disabled='disabled']");
	public static By botaoEditarHabilitado = By.xpath("//button[contains(@id,'botaoEditar')]");
	public static By botaoEditarDesabilitado = By.xpath("//button[contains(@id,'botaoEditar') and @disabled='disabled']");
	public static By botaoClonarHabilitado = By.xpath("//button[contains(@id,'botaoClonar-')]");
	public static By botaoClonarDesabilitado = By.xpath("//button[contains(@id,'botaoClonar-') and @disabled='disabled']");
	public static By botaoExecutarHabilitado = By.xpath("//button[contains(@id,'botaoExecutar')]");
	public static By botaoExecutarDesabilitado = By.xpath("//button[contains(@id,'botaoExecutar') and @disabled='disabled']");
	public static By botaoExcluirHabilitado = By
			.xpath("//button[contains(@id,'botaoExcluir') and not(contains(@id,'Grupo'))]");
	public static By botaoExcluirDesabilitado = By
			.xpath("//button[contains(@id,'botaoExcluir') and not(contains(@id,'Grupo')) and @disabled='disabled']");
	public static By janelaCriarRotina = By.xpath("//div[contains(@id,'_janelaCriarRotina')]");
	public static By campoNomeRelatorioCriarNovo = By.xpath(
			"//div[contains(@id,'_janelaCriarRotina')]//following::input[contains(@id,'parametrosNomeRelatorio-')]");
	public static By campoDescricaoRelatorioCriarNovo = By.xpath("//textarea[contains(@id,'parametrosDescricaoRelatorio')]");
	public static By botaoCriarNovoRelatorio = By.xpath("//button[contains(@id,'botaoCriarRelatorio')]");
	public static By fecharJanelaCriarRelatorio = By
			.xpath("//div[contains(@id,'_janelaCriarRotina')]//ancestor::div[@title='Fechar']");
	public static By campoCodigoRelatorio = By.xpath("//input[contains(@id,'arcrotinaChave')]");
	public static By mensagemConfirmaLiberarRelatorio = By.xpath("//*[contains(text(),'Como deseja liberar?')]");
	public static By botaoFinalizarVersao = By.xpath("//button[@class=\"btn-F atalho-f\"]");
	public static By botaoCancelarVersao = By.xpath("//button[@class=\"btn-C atalho-c\"]");
	public static By botaoVoltar = By.xpath("//button[@class=\"btn-V atalho-v\"]");
	public static By selecionarRelatorioNaLov = By.xpath("//div[@class='lov-modal-componente']//child::tbody/tr[1]");
	public static By modalClonarRelatorio = By.xpath("//div[contains(@title,'Clonar Relat')]");
	public static By modalClonarRelatorioCampoNome = By.xpath("//input[contains(@id,'parametrosNomeRelatorioClone')]");
	public static By modalClonarRelatorioCampoDescricao = By.xpath("//textarea[contains(@id,'paramDescricaoRelClone')]");
	public static By botaoFecharModalClonar = By
			.xpath("//div[@id='cabecalho-janelajanelaClonarRotina']//following::div[@title='Fechar']");
	public static By botaoConfirmarClonar = By.xpath("//button[contains(@id,'botaoClonarRelatorio')]");
	public static By mensagemExcluirRotina = By.xpath("//*[contains(text(),'Excluir a rotina:')]");
	public static By botaoExcluirRotina = By.xpath("//button[@class='btn-E atalho-e']");
	public static By mensagemRotinaExcluidaComSucesso = By.xpath("//*[contains(text(),'Rotina excluída com sucesso')]");
	public static By campoCodigoAcessoUsuario = By.xpath("//input[contains(@id,'arcusuarioacessoIdUsuario')]");
	public static By campoCodigoAcessoUsuarioInformarPosicao = By.xpath("//input[contains(@id,'arcusuarioacessoIdUsuario')]");
	public static By lovUsuarios = By.xpath("//div[@title='Usuários']");
	public static By campoDescricaoAcessoUsuario = By.xpath("//input[contains(@id,'arcusuarioacessoNomeUsuario')]");
	public static By campoPermissaoAcessoUsuario = By.xpath("//select[contains(@id,'arcusucessoPermissaoCombo')]");
	public static By campoCodigoAcessoGrupo = By.xpath("//input[contains(@id,'arcacessogruporotinaIdGrupo')]");
	public static By campoDescricaoAcessoGrupo = By.xpath("//input[contains(@id,'arcacessogruporotinaNomeGrupo')]");
	public static By campoPermissaoAcessoGrupo = By.xpath("//select[contains(@id,'arcacessogrprotinaPermCombo')]");
	public static By abrirLovCodigoAcessoUsuario = By.xpath("//button[contains(@name,'arcusuarioacessoIdUsuario')]");
	public static By barraRolagemProximoRelatorio = By
			.xpath("//*[@id='barraRolagemRotina']//following-sibling::div[@class='proximo botao-navegacao'][1]");
	public static By barraRolagemProximoRelatorioDesabilitada = By.xpath(
			"//*[@id='barraRolagemRotina']//following-sibling::div[@class='proximo botao-navegacao desabilitado'][1]");
	public static By fecharJanelaEmissaoRelatorio = By
			.xpath("//div[contains(@title,'Maximizar') or contains(@title,'Maximize')]//following-sibling::div[@title='Fechar' or @title='Close' or @title='Cerrar']");
	public static By campoNomeUsuarioGrupoAcesso = By.xpath("//input[contains(@id,'arcusuarioacessogNmUsuario')]");
	public static By barraRolagemRelatorioAnteriorDesabilitada = By
			.xpath("//*[@id='barraRolagemRotina']//ancestor::div[@class='anterior botao-navegacao desabilitado']");
	public static By botaoExcluirGrupoAcesso = By.xpath("//button[contains(@id,'botaoExcluirGrupo-1-0')]");
	public static By pdfDoRelatorioGerado = By.xpath("//iframe[contains(@src,'rger307')]");
	public static By relatorioFocado = By
			.xpath("//div[@class='janela-modal-componente']//parent::p[text()='(GER307) Teste Gustavo']");
	public static By filtroPeriodoInicial = By.xpath("//input[contains(@id,'data_nascto-1-0') or contains(@id,'periodo-1')]");
	public static By filtroPeriodoFinal = By.xpath("//input[contains(@id,'data_nascto-1-1') or contains(@id,'periodo-1-1')]");
	public static By botaoAdicionarCorrentistaAtividade1 = By
			.xpath("//button[contains(@name,'.correntistaAtividade-1-0') and contains(@style,'color: green')]");
	public static By botaoAdicionarCorrentistaAtividade2 = By
			.xpath("//button[contains(@name,'.correntistaAtividade-1-1') and contains(@style,'color: green')]");
	public static By campoCorrentistaAtividade1 = By.xpath("//input[contains(@id,'.correntistaAtividade-1-0')]");
	public static By campoCorrentistaAtividade2 = By.xpath("//input[contains(@id,'.correntistaAtividade-1-1')]");
	public static By botaoLovCorrentistaAtividade1 = By.xpath("//button[contains(@name,'.correntistaAtividade-1-0') and not(contains(@style,'color'))]");
	public static By botaoLovCorrentistaAtividade2 = By.xpath("//button[contains(@name,'.correntistaAtividade-1-1') and not(contains(@style,'color'))]");
	public static By botaoRemoverCorrentistaAtividade2 = By
			.xpath("//button[contains(@name,'.correntistaAtividade-1-1') and contains(@style,'color: red')]");
	public static By selecionarSerieNaLov = By.xpath("//div[@class='lov-modal-componente']//parent::table/tbody/tr[4]");
	public static By estaProcessando = By.xpath("//*[@class='fa fa-spinner fa-spin fa-lg']");
	public static By campoNomeRelatorio = By.xpath("//input[contains(@id,'arcrotinaNome')]");
	public static By botaoAgendar = By.xpath("//button[contains(@id,'b_agendar')]");
	public static By botaoCriarNovoAgendamento = By.xpath("//button[contains(text(),'riar Novo Agendamento')]");
	public static By campoSelecionarPerfil = By.xpath("//select[contains(@id,'_perfil')]");
	public static By botaoAbrirParc016 = By.xpath("//button[contains(@id,'b_gerenciar_perfis')]");
	public static By botaoAtualizarPerfis = By.xpath("//button[contains(@id,'b_atualizar_perfis')]");
	public static By botaoBloquearParcial = By.xpath("//button[@class='btn-U atalho-p']");
	public static By botaoBloquearTotal = By.xpath("//button[@class='btn-R atalho-t']");
	public static By campoExibeTipoBloqueio = By.xpath("//input[contains(@id,'arcrotinaNovo_item_85084')]");
	public static By filtroObrigatorio = By.xpath("//input[contains(@id,'codigo_atividade-1') and (@class = 'elemento input obrigatorio')]");
	
	public static By filtroNaoOculto = By.xpath("//input[contains(@id,'correntista 2-1')]");
	public static By filtroNaoOculto2 = By.xpath("//input[contains(@id,'id_usuario-1')]");
	public static By filtroOculto = By.xpath("//input[contains(@id,'correntista-1')]");
	public static By filtroOculto2 = By.xpath("//input[contains(@id,'.usuario-1')]");

	
	public static By totalDeRegistrosNoBloco(String reg1, String reg2) {
		return By.xpath("//li[contains(@text(),'" + reg1 + "/" + reg2 + "')]");
	}

}

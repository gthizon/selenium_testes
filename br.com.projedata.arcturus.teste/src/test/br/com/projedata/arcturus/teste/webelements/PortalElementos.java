package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

public class PortalElementos {

	public static By botaoAlterarSenha = By.xpath("//li[contains(text(),'Alterar senha')]");
	public static By janelaAlterarSenha = By.xpath("//*[contains(@id,'modalAlterarSenha')]");
	public static By senhaAtual = By.id("senhaAtual");
	public static By novaSenha = By.id("novaSenha");
	public static By confirmarNovaSenha = By.id("confirmarNovaSenha");
	public static By salvarNovaSenha = By.xpath("//div[@id='modalAlterarSenha']//ancestor::button[@title='Salvar']");
	public static By botaoSalvarDesabilitado = By
			.xpath("//div[@id='modalAlterarSenha']//ancestor::button[@title='Salvar' and @disabled='disabled']");
	public static By mensagemSenhaAlterada = By.xpath("//*[contains(text(),'Senha alterada com sucesso')]");
	public static By mensagemSenhaInvalida = By.xpath("//*[contains(text(),'Usuário e/ou senha inválidos.')]");
	public static By sairPortal = By.xpath("//div[@title='Sair do sistema']");
	public static By fecharJanelaAlterarSenha = By
			.xpath("//*[@id='modalAlterarSenha']//ancestor::button[@tabindex=\"-1\" and @aria-hidden=\"true\"]");
	public static By painelEmpresa = By.xpath("html/body/div[1]/div[2]/section/div/article[1]/div[1]/header/div");
	public static By painelProjetos = By.xpath("//*[@id='widget-id-6']");
	public static By botaoAbrirEstilos = By.xpath("//li[contains(text(),'Configuração de cor')]");
	public static By listaDeCores = By.xpath("//*[@id='modalEstilo']");
	public static By corVerde = By
			.xpath("//div[@id='modalEstilo']//descendant::div[@style='background-color: rgb(53, 110, 53);']");
	public static By corAzul = By
			.xpath("//div[@id='modalEstilo']//descendant::div[@style='background-color: rgb(0, 106, 166);']");
	public static By cabecalhoCorAzul = By.xpath(
			"//*[contains(@style,'background-color: rgb(0, 106, 166)')]//ancestor::div[@class='localizar-rotina barra-ferramentas-item']");
	public static By cabecalhoCorVerde = By.xpath(
			"//*[contains(@style,'background-color: rgb(53, 110, 53)')]//ancestor::div[@class='localizar-rotina barra-ferramentas-item']");
	public static By botaoAbrirMenu = By
			.xpath("//i[@class='fa fa-bars fa-lg portal-botoes-hover']//ancestor::div[contains(@class,'abrir-menu ')]");
	public static By menuPrincipal = By.xpath("//div[@class='menu-sistema']");
	public static By menu2 = By.xpath("//a[@class='portal-menu-selecionado' and contains(text(),'Administração')]");
	public static By menu3 = By.xpath("//a[@class='portal-menu-selecionado' and contains(text(),'Cadastros')]");
	public static By menu4 = By.xpath("//*[@id=\"portal\"]/div[3]/div/div[4]");
	public static By menuApoio = By.linkText("Apoio");
	public static By menuAdmArcturus = By.linkText("Administração");
	public static By menuWorkflow = By.linkText("Workflow");
	public static By menuCadastros = By.linkText("Cadastros");
	public static By menuRelatoriosPersonlalizados = By.linkText("Relatórios Personalizados");
	public static By menuRelatorioRger024 = By.xpath("//font[contains(text(),'rger24')]");
	public static By menuRotinaParc001 = By.linkText("parc001 Cadastro de Usuários");
	public static By cadastroUsuarios = By.xpath(
			"//p[contains(text(),'ARC001')]//following::li[contains(@class,'info-navegacao')]//child::span[contains(text(),'1/1')]");
	public static By menuTrocarEmpresa = By.xpath("//li[@title=\"Trocar Empresa\"]");
	public static By lovTrocarEmpresa = By.xpath("//div[@id='modalSelecaoEmpresa']");
	public static By selecionaEmpresa2 = By.xpath("//td[contains(text(),'Teste Automação')]");
	public static By selecionaEmpresa1 = By.xpath("//td[contains(text(),'Empresa Teste')]");
	public static By mensagemSemLicencaDisponivel = By
			.xpath("//*[contains(text(),'Não há licença disponível para o acesso.')]");
	public static By localizarRotina = By.xpath("//div[@class='localizar-rotina barra-ferramentas-item']/input");
	public static By selecionaRotina = By.xpath("//*[contains(@id,'pven116')]");
	public static By botaoSalvarRotina = By.xpath("//button[contains(@id,'salvar_')]");
	public static By rotinaCarregada = By.id("//li[@class='info-navegacao']//span[contains(text(),'1/1')]");
	public static By campoQuantidade = By.xpath("//*[contains(@id,'.quantidade')]");
	public static By campoDesconto = By.xpath("//*[contains(@id,'.desconto')]");
	public static By campoComissao = By.xpath("//*[contains(@id,'.comissao')]");
	public static By dicaDeCampo = By.xpath("//div[@class='tooltip']");
	public static By janelaRecuperarSenha = By.xpath("//div[contains(@class,'modal-mask modal-recuperar-senha')]");
	public static By radioBoxRecuperarLogin = By.xpath("//input[@type='radio' and @value='L']");
	public static By radioBoxRecuperarSenha = By.xpath("//input[@type='radio' and @value='S']");
	public static By campoEmailRecuperacao = By.xpath("//input[@type='email' and @class='recuperacao']");
	public static By campoRecuperarLogin = By.xpath("//input[@type='text' and @class='recuperacao']");
	public static By botaoRecuperar = By.xpath("//button[contains(text(),'Recuperar')]");
	public static By botaoCancelar = By.xpath("//button[contains(text(),'Cancelar')]");
	public static By botaoAbrirRecuperarLoginESenha = By.xpath("//div[@class='recuperar-senha']//a");
	public static By mensagemInformeEmailValido = By.xpath("//*[text()='Informe um endereço de e-mail válido']");
	public static By mensagemInformeLogin = By.xpath("//*[text()='Informe o login']");
	public static By mensagemUsuarioNaoLocalizado = By.xpath("//*[contains(text(),'Usuário não localizado.')]");
	public static By mensagemVerifiqueSeuEmail = By.xpath("//*[contains(text(),'Verifique seu e-mail.')]");
	public static By mensagemInformeUmaSenhaDiferente = By
			.xpath("//*[contains(text(),'Informe uma senha diferente.')]");
	public static By campoLoginJanelaAlteracaoDeSenha = By.id("login");
	public static By campoSenhaJanelaAlteracaoDeSenha = By.id("senha");
	public static By campoConfirmacaoSenhaJanelaAlteracaoDeSenha = By.id("senha-confirmacao");
	public static By botaoAlterarSenhaJanelaAlterarSenha = By.xpath("//button[text()='Alterar Senha']");
	public static By comboPapelUsuarioArc001 = By.xpath("//label[text()='Papel']//following::select[1]");
	public static By botaoExpandirRelatorio = By
			.xpath("//*[contains(text(),'VEN269')]//following::div[@title='Maximizar']");
	public static By botaoRestaurarRelatorio = By
			.xpath("//*[contains(text(),'VEN269')]//following::div[@title='Restaurar']");
	public static By relatorioExpandido = By
			.xpath("//div[contains(@style,'height: calc(100%') and @class='janela-modal-componente']");
	public static By redimensionarJanela = By.xpath("//div [@class='ui-resizable-handle ui-resizable-e']");
	public static By botaoAbrirOutraRotina = By.xpath("//button[@class='btn-abrirOutra atalho-a']");
	public static By botaoMostrarRotinaAberta = By.xpath("//button[@class='btn-mostrarAberta atalho-m']");
	public static By botaoCancelarAberturaRotina = By.xpath("//button[@class='btn-cancelar atalho-c']");
	public static By botaoDestacarRotina = By.xpath("//div[@title='Destacar']");
	public static By janelaDeInformacoesF1 = By.xpath(
			"//b[contains(text(),'Nome:') or contains(text(),'Item Vinculado:') or contains(text(),'Tipo Dado:')]//preceding::p[@class='titulo' and text()='Informações do componente']");
	public static By janelaDeInformacoesF5 = By
			.xpath("//p[contains(text(),'Informação')]//following::p[@class='titulo' and text()='Blocos de Dados']");
	public static By botaoAbrirListaPaineis = By.xpath("//li[contains(text(),'Exibir/ocultar painéis')]");
	public static By botaoAbrirIdiomas = By.xpath(
			"//li[contains(text(),'Alterar idioma') or contains(text(),'Cambiar idioma') or contains(text(),'Change language')]");
	public static By fecharListaPaineis = By
			.xpath("//div[@class='portal-menu-painel-close' and contains(@title,'Fechar')]");
	public static By listaPaineis = By.xpath("//div[@id='divPainel']");
	public static By areaTrabalhoPortal = By.xpath("//div[@id='mouseposition-extension-element-full-container']");
	public static By empresa2Selecionada = By
			.xpath("//div[@class='portal-fundo-separador' and contains(text(),'5 - Teste Automação')]");
	public static By empresa1Selecionada = By
			.xpath("//div[@class='portal-fundo-separador' and contains(text(),'1 - Empresa Teste')]");
	public static By janelaAlterarIdioma = By.xpath("//div[@id='modal-selecao-idioma']");
	public static By idiomaPortugues = By.xpath("//td[contains(text(),'Português')]");
	public static By idiomaEspanhol = By.xpath("//td[contains(text(),'Español')]");
	public static By idiomaIngles = By.xpath("//td[contains(text(),'English')]");
	public static By mensagemConfirmacaoIdiomaPortugues = By.xpath(
			"//p[contains(text(),'Algumas informações podem estar no idioma antigo. Para completar a alteração de idioma é necessário recarregar a página.')]");
	public static By mensagemConfirmacaoIdiomaEspanhol = By.xpath(
			"//p[contains(text(),'Algunas informaciones pueden estar en el idioma antiguo. Para completar el cambio de idioma es necesario recargar la página.')]");
	public static By mensagemConfirmacaoIdiomaIngles = By.xpath(
			"//p[contains(text(),'Some information may not have been translated. To complete the language change you need to reload the page.')]");
	public static By botaoRecarregarMensagemConfirmacao = By
			.xpath("//button[contains(text(),'ecargar ahora') or contains(text(),'eload now') or contains(text(),'ecarregar agora')]");
	
	public static By painelRelatoriosCinza = By
			.xpath("//div[@class='panel-title arcwidget arcwidget-color-gray']//div[contains(text(),'Relatórios')]");
	public static By painelRelatoriosVermelho = By
			.xpath("//div[@class='panel-title arcwidget arcwidget-color-redDark']//div[contains(text(),'Relatórios')]");
	public static By botaoAbrirCaixaDeCores = By
			.xpath("//div[contains(text(),'Relatórios')]//following::a[@class='color-box'][1]");
	public static By caixaDeCoresAberta = By
			.xpath("//div[contains(text(),'Relatórios')]//following::div[@class='arcwidget-editbox branco'][1]");
	public static By selecionarCorVermelha = By
			.xpath("//div[contains(text(),'Relatórios')]//following::div[@class='arcwidget-editbox branco'][1]//span[@class='bg-color-redDark']");
	public static By selecionarCorCinza = By
			.xpath("//div[contains(text(),'Relatórios')]//following::div[@class='arcwidget-editbox branco'][1]//span[@class='bg-color-gray']");
	
	public static By listaNotificacoes = By.xpath("//*[@id='div-notificacoes']");
	public static By notificacaoRepasseAtualizacao = By.xpath("//*[@id='div-notificacoes']/ul/li[2]/span[1]/text()[2]");
	public static By abrirNotificacoes = By.xpath("//*[@class='barra-ferramentas-item notificacao']");
	public static By voceTemUmNovoRecado = By.xpath("//li[@class='titulo' and contains(text(),'Você tem 1 novo recado')]");
	
	

}

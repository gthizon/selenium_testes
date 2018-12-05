package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

import br.com.projedata.teste.util.recursos.Rotina;

public class ConstrutorTelasElementos {

	Rotina rotina;

	public static By areaEdicaoConstrutor = By.xpath("//div[@class='titulo' and text()='Layout']");
	public static By rotinaAbertaEmModal = By.xpath("//div[@class='prjModal-header' and @draggable-prj='']");
	public static By abrirListaRotinas = By.xpath("//div[@ng-click='cc.entrarCampoRotina()']");
	public static By listaRotinasAberta = By.xpath("//div[@id='divRotinas' and contains(@style,'display: block')]");
	public static By filtroLocalizar = By.xpath("//input[@id='filtroSelecionarRotina']");
	public static By selecionaRotina = By.xpath("//td[@ng-click='cc.getVersao(versao.id)']//following::*[text()='pteste014']");
	public static By estaProcessando = By.xpath("//*[@class='fa fa-spinner fa-spin fa-lg']");
	public static By rotinaPteste014ExibidaNoConstrutor = By
			.xpath("//div[@class='ng-binding' and contains(text(),'TESTE014')]");
	public static By botaoAbrirRotina = By.xpath("//a[@title='Abrir Rotina']");
	public static By checkBoxNaoPermiteAlteracao = By
			.xpath("//input[contains(@id,'naoPermite') and @disabled='disabled' and @type='checkbox']");
	public static By checkBoxPermiteAlteracaoDesmarcado = By.xpath("//input[contains(@id,'.Permite-')]");
	public static By checkBoxPermiteAlteracaoMarcado = By.xpath("//input[contains(@id,'.Permite')]");
	public static By checkBoxApenasConsultaDesmarcado = By.xpath("//input[contains(@id,'somenteConsulta')]");
	public static By checkBoxApenasConsultaMarcado = By.xpath("//input[contains(@id,'somenteConsulta')]");
	public static By checkBoxApenasConsulta = By.xpath("//input[contains(@id,'somenteConsulta')]");
	public static By menuArvoreBlocos = By.xpath(
			"//*[@id='tree-bloco']/ol/li/div/ol[1]/li/div/a/span");
	public static By abrirPropriedadesBloco = By.xpath("//*[@id='tree-bloco']/ol/li/div/ol[1]/li/ol/li[2]/div/div/div[2]/div");
	public static By PropriedadesBlocoAberta = By.xpath("//div[@id='construtor-propriedades' and @style='display: block;']");
	public static By atributoComportamentoRelacionamento = By.xpath(
			"//td[@class='nome-propriedade' and text()='Comportamento do Relacionamento']//following::select[contains(@title,'Não Isolado: Restringe operação')]");
	public static By botaoSalvar = By.xpath("//div[@ng-click='cc.salvar(cc.versao)']");
	public static By semPendenciasParaSalvar = By.xpath("//font[@class='ng-hide' and @ng-show='versao.blocoAlterado']");
	public static By botaoAdicionarEvento = By
			.xpath("//div/ol/li/div/ol/li/ol/li[2]/div/div/div[2]/div//following::i[@title='Adicionar Evento'][1]");
	public static By modalSelecionarBlocoEvento = By.id("modalSelecionarBlocoEvento");
	public static By selecionaEventoAposConsultarRegistro = By.xpath("//td[text()='aposConsultarRegistro']");
	public static By editorDoEvento = By.xpath("//div[text()='Editor (TABNOTAIT.aposConsultarRegistro)']");
	public static By abrirArvoreBlocoNotaIt = By.xpath(
			"//*[@id='tree-bloco']/ol/li/div/ol[1]/li/ol/li[2]/div/div/div[1]/a");
	public static By abrirArvoreEventos = By
			.xpath("//*[@id='tree-bloco']/ol/li/div/ol[1]/li/ol/li[2]/div/ol[2]/li/div/a/span");
	public static By botaoRemoverEvento = By.xpath(
			"//*[@id='tree-bloco']/ol/li/div/ol[1]/li/ol/li[2]/div/ol[2]/li/ol/li[3]/div/div/div[3]/i");
	public static By eventoMarcadoParaExcluir = By.xpath(
			"//div[@class='construtor-wrap-item ng-binding' and contains(text(),'aposConsultarRegistro') and @style='color: rgb(255, 0, 0);']");
	public static By editorSql = By.xpath("//textarea[@class='ace_text-input']");
	public static By eventoAposConsultarRegistro = By
			.xpath("//div[@class='construtor-wrap-item ng-binding' and contains(text(),'aposConsultarRegistro')]");
	public static By menuArvoreComponentes = By.xpath(
			"//*[@id='tree-bloco']/ol/li/div/ol[10]/li/div/a/span");
	public static By selecionarComponenteCampoLov = By
			.xpath("//*[@id='tree-bloco']/ol/li/div/ol[10]/li/ol/li[4]/div/div/div[2]/div");
	public static By componenteExibirBotoes = By.xpath("//select[@ng-model='cc.componente.exibirBotoesArquivos']");
	public static By lovEventosCarregada = By.xpath("//div[@id='modalSelecionarBlocoEvento' and contains(@style,'display: block;')]");
	public static By localizarEvento = By.xpath("//div[@class='modal fade in']//input[@id='localizarEvento' and @placeholder='Localizar']");
	public static By campoTesteFocoBloco = By.xpath("//input[contains(@id,'testeBlocoFoco-1')]");
	

	/* Campos pteste014 */

	public static By campoSerieNota = By.xpath("//input[contains(@id,'TABNOTASerie')]");
	public static By campoCodigoCliente = By.xpath("//input[contains(@id,'TABNOTACliente')]");
	public static By campoNomeCliente = By.xpath("//input[contains(@id,'TABNOTANomeCliente')]");
	public static By campoNumeroNota = By.xpath("//input[contains(@id,'TABNOTANota')]");
	public static By campoCondPagto = By.xpath("//input[contains(@id,'TABNOTACondPagto')]");
	public static By campoDataEmissao = By.xpath("//input[contains(@id,'TABNOTADataEmissao')]");
	public static By campoSituacaoNota = By.xpath("//select[contains(@id,'TABNOTASituacao')]");
	public static By campoSeqItem = By.xpath("//input[contains(@id,'TABNOTAITSequencia')]");
	public static By campoCodigoItem = By.xpath("//input[contains(@id,'TABNOTAITItem')]");
	public static By campoDescricaoItem = By.xpath("//input[contains(@id,'TABNOTAITNomeItem')]");
	public static By campoQtdeItem = By.xpath("//input[contains(@id,'TABNOTAITQuantidade')]");
	public static By campoValorUn = By.xpath("//input[contains(@id,'TABNOTAITUnitario')]");
	public static By rotinaPteste014CompiladaExibida = By.xpath("//p[contains(text(),'TESTE014')]");
	public static By botaoFecharRotinaPteste014Modal = By
			.xpath("//p[contains(text(),'TESTE014')]//following::*[@title=('Fechar')]");
	public static By botaoLovCliente = By.xpath("//button[contains(@name,'TABNOTACliente-1-0-aux')]");
	public static By botaoPosicaoAlterada = By.xpath(
			"//button[contains(@id,'TABNOTAPosicionamento-1-0') and contains(@style,'left: 10px') and contains(@style,'top: 100px')]");
	public static By botaoPosicaoOrigem = By.xpath(
			"//button[contains(@id,'TABNOTAPosicionamento-1-0') and contains(@style,'left: 282') and contains(@style,'top: 471px')]");
	public static By posicaoAlteradaLabel = By.xpath(
			"//label[contains(@class,'etiqueta-label') and text()='Mudar Posição']//parent::div[contains(@style,'left: 10px') and contains(@style,'top: 100px')]");
	public static By posicaoOrigemLabel = By.xpath(
			"//label[contains(@class,'etiqueta-label') and text()='Mudar Posição']//parent::div[contains(@style,'left: 282px') and contains(@style,'top: 471px')]");
	public static By botaoPosicaoInicial = By
			.xpath("//button[contains(@id,'TABNOTAPosicionamento-1-0') and contains(@style,'left: 282')]");
	public static By botaoAbrirCalendarioDataEmissao = By.xpath("//button[contains(@name,'TABNOTADataEmissao-1-0-aux')]");
	public static By calendarioComMascaraDeHorario = By.xpath("//div[@class='flatpickr-time time24hr hasSeconds']");
	public static By campoSequenciaComCor = By
			.xpath("//input[contains(@id,'TABNOTAITSequencia-1-0') and contains(@style, 'color: rgb(204, 102, 102)')]");
	public static By campoCodigoItemNegrito = By
			.xpath("//input[contains(@id,'TABNOTAITItem-1-0') and contains(@style, 'font-weight: bold')]");
	public static By campoDescricaoItemNegrito = By
			.xpath("//input[contains(@id,'TABNOTAITNomeItem-1-0') and contains(@style, 'font-weight: bold')]");
	public static By campoQuantidadeItemNegrito = By
			.xpath("//input[contains(@id,'TABNOTAITQuantidade-1-0') and contains(@style, 'font-weight: bold')]");
	public static By campoUnitarioItemComCor = By
			.xpath("//input[contains(@id,'TABNOTAITUnitario-1-0') and contains(@style, 'color: rgb(204, 102, 102)')]");
	public static By campoTotalItemNegrito = By
			.xpath("//input[contains(@id,'TABNOTAITValorItem-1-0') and contains(@style, 'font-weight: bold')]");
	public static By botaoMudarBarraRolagem = By.xpath("//button[contains(@id,'botaoBarraRolagem-1-0')]");
	public static By barraRolagemPosicaoOrigem = By.xpath(
			"//div[@id='barraRolagemItem' and contains(@style,'width: 15px; height: 208px; top: 32px; left: 557px;')]");
	public static By barraRolagemPosicaoAlterada = By.xpath(
			"//div[@id='barraRolagemItem' and contains(@style,'width: 30px; height: 100px; top: 2px; left: 300px;')]");
	public static By quadroItens = By.xpath("//div[@id='Itens']//following::div[@class='quadro-conteudo-container']");
	public static By botaoSalvarComMensagemSucesso = By.xpath("//button[contains(@id,'salvarComMsg')]");
	public static By botaoSalvarSemMensagemSucesso = By.xpath("//button[contains(@id,'salvarSemMsg')]");
	public static By botaoAbrirRelatorio = By.xpath("//button[contains(@id,'abrirRotina-1')]");
	public static By campoComboDesabilitado = By.xpath("//select[contains(@id,'lista103')]");
	public static By campoImagemItem = By.xpath("//img[contains(@src,'data:image/png;base64')]");
	public static By campoQuantidadeItem = By.xpath("//input[contains(@id,'TABNOTAITQuantidade-1-0')]");
	public static By campoUnitarioItem = By.xpath("//input[contains(@id,'TABNOTAITUnitario-1-0')]");
	
	public static By campoLovAlinhadoDireita = By.xpath("//th[contains(@style, 'text-align: right;') and contains(text(),'descricao')]");
	public static By campoLovAlinhadoCentro = By.xpath("//th[contains(@style, 'text-align: center;') and contains(text(),'unidade')]");
	public static By campoLovAlinhadoEsquerda = By.xpath("//th[contains(@style, 'text-align: left;') and contains(text(),'codigo')]");
	public static By campoLovSemAlinhamento = By.xpath("//th[contains(@style, 'text-align: left;') and contains(text(),'preco')]");
	public static By etiquetaBotaoDesabilitada = By.xpath("//label[contains(@class,'etiqueta-label  desabilitado')]");
	
	
	/* Campos pteste015 */

	public static By rotinaTeste015Aberta = By.xpath("//*[text()='(TESTE015) ']");
	public static By primeiroNoh = By.xpath("//span[text()='Nível 1']");
	public static By mensagemNohSemAcao = By.xpath("//*[contains(text(),'Esse nó não tem nenhuma ação!')]");
	public static By segundoNoh = By.xpath("//span[text()='Nível 2']");
	public static By abrirSegundoNoh = By.xpath("//span[text()='Nível 2']//preceding::i[@class='fa fa-plus'][1]");
	public static By nohDoisPontoUm = By.xpath("//span[text()='Nível 2.1']");
	public static By botaoMetodoConsultaBloco = By.xpath("//button[contains(@id,'MetodoConsultaBloco')]");
	public static By painelAbas = By.id("testeAbas");
	public static By aba1 = By.xpath("//p[contains(text(),'Aba1')]");
	public static By aba2 = By.xpath("//p[contains(text(),'Aba2')]");
	public static By aba3 = By.xpath("//p[contains(text(),'Aba3')]");
	public static By abaSelecionada;
	public static By campoTesteFoco1 = By.xpath("//input[contains(@id,'testeFoco')]");
	public static By campoTesteFoco2 = By.xpath("//input[contains(@id,'testeFoco2')]");
	public static By botaoAbrirJanela = By.xpath("//button[contains(@id,'abrirJanela-1-0')]");
	public static By botaoAbrirLovDaJanela = By.xpath("//button[contains(@name,'campoLov-1-0')]");
	public static By backDropJanela = By.xpath("//div[contains(@id,'back-drop-janelaTeste')]");
	public static By backDropLov = By.xpath("//div[contains(@id,'back-drop-lov')]");
	public static By janelaTeste = By.xpath("//div[contains(@id,'_janelaTeste')]");
	public static By fecharJanelaTeste = By.xpath("//div[contains(text(),'Janela Teste')]//following::*[@title='Fechar'][1]");
	public static By campoTotal = By.xpath("//input[contains(@id,'campoTotal-1-0')]");
	public static By mensagemInformeValorCampoTotal = By.xpath("//*[contains(text(),'Informe um valor para  Total')]");
	public static By aba3LabelNegrito = By
			.xpath("//p[contains(text(),'Aba3')]//ancestor::p[contains(@style,'font-weight: bold;')]");
	public static By campoValor1 = By.xpath("//input[contains(@id,'testeCodigo-1-0')]");
	public static By dataNoFinalDoCalendario = By.xpath("//div[contains(@class,'flatpickr-calendar') and contains(@class, 'open')]//child::span[contains(@class,'flatpickr-day')][38]");
	public static By botaoAbrirCalendario = By.xpath("//button[contains(@name,'testeCalendario')]");
	public static By campoData = By.xpath("//input[contains(@id,'testeCalendario')]");
	public static By botaoAbrirCalendarioDataHora = By.xpath("//button[contains(@name,'dataHora')]");
	public static By campoDataHora = By.xpath("//input[contains(@id,'dataHora')]");
	public static By botaoProntoCalendario = By.xpath("//button[contains(text(),'Pronto')]");
	public static By componenteQuadroComCor = By.xpath("//div[@class='quadro-componente teste']");
	public static By lovAbrirRotina = By.xpath("//button[contains(@name,'lovAbrirRotina')]");
	public static By botaoLovAbrirLista = By.xpath("//button[contains(@name,'lovAbrirLista')]");
	public static By campoLovAbrirLista = By.xpath("//input[contains(@id,'lovAbrirLista')]");
	public static By imagemNaLov = By.xpath("//td/img[contains(@src,'data:image')]");
	public static By botaoAbrirLovImagem = By.xpath("//button[contains(@name,'lovImagem-1')]");
	public static By botaoAbrirLovPeloEventoComParametro = By.xpath("//button[contains(@id,'botaoEventoLov')]");
	public static By botaoAbrirLovPeloEventoSemParametro = By.xpath("//button[contains(@id,'botaoEventoLovSemParam')]");
	public static By campoTextoVisivelJanelaVisibilidade = By.xpath("//p[contains(@class,'etiqueta-label') and text() = 'Texto']");
	public static By quadroImagemJanelaVisibilidade = By.xpath("//div[contains(@class,'etiqueta-componente')]/div/label[contains(text(),'imagem')]//following::div[@class='quadro-imagem-componente'][1]");
	public static By campoTextoOcultoJanelaVisibilidade = By.xpath("//p[contains(@class,'etiqueta-label') and text() = 'Oculto']");
	public static By quadroImagemOcultaJanelaVisibilidade = By.xpath("//div[contains(@class,'etiqueta-componente')]/div/label[contains(text(),'oculto')]//following::div[@class='quadro-imagem-componente'][1]");
	public static By campoLocalizarLovCorrentista = By.xpath("//div[contains(@class,'lov-modal-componente')]//following::input[@placeholder]");
	
	
	public static By verificarPaginaAtualLov(String pagina) {
		return By.xpath("//div[@class='coluna lov-paginacao']/p[contains(text(),'" + pagina + "/')]");
		
	}
	
	public static By selecionarRotina(String rotina) {
		return By.xpath("//td[@ng-click='cc.getVersao(versao.id)']//following::*[text()='" + rotina + "']");
		
	}
	
	public static By abaSelecionada(String aba) {
		return By.xpath("//p[contains(text(),'" + aba + "')]//ancestor::div[@class='titulo selecionado']");
	}

}

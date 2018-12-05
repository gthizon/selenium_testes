package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

public class WizardRelatoriosElementos {

	public static By wizardAssistente = By.id("modalAssistente");
	public static By campoSinopse = By.xpath("//textarea[@ng-model='rc.versao.assistente.sinopse']");
	public static By botaoAvancarWizard = By.xpath("//a[@ng-click='rc.geradorProximo()']");
	public static By botaoRetornarWizard = By.xpath("rc.geradorAnterior()");
	public static By abaConfiguracoes = By.xpath("//label[@ng-click=\"rc.selecionarAba('tabx1');\"]");
	public static By abaConsulta = By.xpath("//label[@ng-click=\"rc.selecionarAba('tabx2');\"]");
	public static By abaEventos = By.xpath("//label[@ng-click=\"rc.selecionarAba('tabx3');\"]");
	public static By abaCampos = By.xpath("//label[@ng-click=\"rc.selecionarAba('tabx4');\"]");
	public static By abaGrupos = By.xpath("//label[@ng-click=\"rc.selecionarAba('tabx5');\"]");
	public static By abaGruposGraficoLinha = By.xpath("//label[@ng-click=\"rc.selecionarAba('tabx6');\"]");
	public static By abaTotalizadores = By.xpath("//label[@ng-click=\"rc.selecionarAba('tabx7');\"]");
	public static By abaGraficoLinha = By.xpath("//label[@ng-click=\"rc.selecionarAba('tabx10');\"]");
	public static By abaGraficoBarras = By.xpath("//label[@ng-click=\"rc.selecionarAba('tabx11');\"]");
	public static By abaFiltrosGraficos = By.xpath("//label[@ng-click=\"rc.selecionarAba('tabx9');\"]");
	public static By abaGraficoPizza = By.xpath("//label[@ng-click=\"rc.selecionarAba('tabx12');\"]");
	public static By abaMatriz = By.xpath("//label[@ng-click=\"rc.selecionarAba('tabx13');\"]");
	public static By tipoConsultaSql = By.xpath("//input[@type='radio' and @value='S']");
	public static By editorSql = By.xpath("//div[@id='geradorComandoSQL']//preceding::textarea[@class='ace_text-input']");
	public static By editorConsulta = By
			.xpath("//div[@id='geradorComandoSQLConsulta']//following::textarea[@class='ace_text-input'][1]");
	public static By botaoFinalizarAssistente = By.xpath("//a[@ng-click='rc.criarRelatorioAssistente()']");
	public static By botaoAdicionarCampos = By.xpath("//a[@ng-click=\"rc.mover('ADD');\" and @title='Adicionar']");
	public static By botaoAdicionarCamposGrafico = By.xpath("//a[@ng-click=\"rc.moverGraficoValor('ADD');\" and @title='Adicionar']");
	public static By camposParaSelecao = By
			.xpath("//select[@ng-model='rc.versao.assistente.itensMarcados']/option[text()='numero_os']");
	public static By botaoAdicionarCamposGrupo = By.xpath("//a[@ng-click=\"rc.moverGrupo('ADD');\" and @title='Adicionar']");
	public static By quadroCamposGrupoSelecionados = By
			.xpath("//select[@ng-dblclick=\"rc.moverGrupo('DEL');\"]/option[text()='correntista']");
	public static By itensSelecionadosFuncaoContar = By.xpath(
			"//select[@ng-model='rc.versao.assistente.itensSelecionadosMarcadosTotal']/option[text()='con_numero_os']");
	public static By localizarFiltro = By.xpath("//div[2]/div/div[5]/div/div[2]/input[@id='localizarConsulta']");
	public static By selecionarFiltroPeriodo = By.xpath("//div[3]/table/tbody/tr[1]/td[contains(text(),'Período')]");
	public static By adicionarFiltroPeriodoNaConsulta = By.xpath("//div[6]/div[2]/table/tbody/tr[2]/td[1]/i");
	public static By filtroPeriodoInicial = By.xpath(
			"//input[((contains(@name,'periodo') or contains(@name,'data')) and @indice=0) or (contains(@id,'periodo-1-0') or contains(@id,'dataAssoc-1-0') or contains(@id,'data_assoc-1-0'))]");
	public static By filtroPeriodoFinal = By.xpath(
			"//input[((contains(@name,'periodo') or contains(@name,'data')) and @indice=1) or (contains(@id,'periodo-1-1') or contains(@id,'dataAssoc-1-1') or contains(@id,'data_assoc-1-1'))]");
	public static By totalOsGraficoLinha = By.xpath("//*[@id=\"conteudo10\"]/div[1]/div/select[1]/option[text()='total_os']");
	public static By botaoAdicionarValoresGraficoLinha = By.xpath(
			"//*[@id=\"conteudo10\"]/div[1]/div/ul/li[1]/a[@ng-click=\"rc.moverGraficoValor('ADD');\" and @title='Adicionar']");
	public static By selecionarCategoria = By
			.xpath("//*[@id=\"conteudo10\"]/div[2]/div/select[@ng-model=\"rc.versao.assistente.graficoCategoria\"]");
	public static By selecionarSerie = By
			.xpath("//*[@id=\"conteudo10\"]/div[3]/div/select[@ng-model=\"rc.versao.assistente.graficoSerie\"]");
	public static By selecionarConsulta = By.xpath(
			"//td[@ng-click='rc.selecionarConsultaAssistente(consulta);' and contains(text(),'Consulta Teste automatizado')]");
	public static By campoAcaoSelecionado = By
			.xpath("//select[@ng-dblclick=\"rc.mover('DEL');\"]//ancestor::option[text()='acao'][1]");
	public static By campoAtividadeSelecionado = By
			.xpath("//select[@ng-dblclick=\"rc.mover('DEL');\"]//ancestor::option[text()='atividade'][1]");
	public static By mediaNumeroOsSelecionado = By
			.xpath("//select[@ng-dblclick=\"rc.mover('DEL');\"]//ancestor::option[text()='med_numero_os'][1]");
	public static By selecionarValorParaGraficoBarras = By
			.xpath("//*[@id=\"conteudo11\"]/div[1]/div/select[1]/option[text()='med_numero_os']");
	public static By botaoAddValorParaGraficoBarras = By.xpath(
			"//label[@ng-click=\"rc.selecionarAba('tabx11');\"]//following::a[@ng-click=\"rc.moverGraficoValor('ADD');\" and @title='Adicionar'][1]");
	public static By valorParaGraficoBarrasSelecionado = By
			.xpath("//*[@id=\"conteudo11\"]/div[1]/div/select[2]/option[text()='med_numero_os']");
	public static By selecionarCategoriaGraficoBarras = By
			.xpath("//*[@id=\"conteudo11\"]/div[2]/div/select[@ng-model=\"rc.versao.assistente.graficoCategoria\"]");
	public static By selecionarSerieGraficoBarras = By
			.xpath("//*[@id=\"conteudo11\"]/div[3]/div/select[@ng-model=\"rc.versao.assistente.graficoSerie\"]");
	public static By botaoAddFiltrosGraficoBarras = By.xpath("//a[@ng-click=\"rc.moverFiltro('ADD');\"]");
	public static By selecionarFiltrosGraficoBarras = By.xpath(
			"//label[@ng-click=\"rc.selecionarAba('tabx9');\"]//following::select[@ng-model=\"rc.versao.assistente.consulta.filtrosMarcados\"]/option[contains(text(),'Data assoc ')]");
	public static By maximoNumeroOsSelecionado = By
			.xpath("//select[@ng-dblclick=\"rc.mover('DEL');\"]//ancestor::option[text()='max_numero_os'][1]");
	public static By selecionarValorGraficoPizza = By.xpath("//select[@ng-model=\"rc.versao.assistente.graficoValor\"]");
	public static By selecionarSerieGraficoPizza = By.xpath(
			"//label[@ng-click=\"rc.selecionarAba('tabx12');\"]//following::select[@ng-model=\"rc.versao.assistente.graficoSerie\"][1]");
	public static By marcarLegendaSerie = By.xpath("//input[@ng-model='rc.versao.assistente.graficoLegendaExibirSerie']");
	public static By legendaSerieMarcada = By.xpath(
			"//input[@ng-model='rc.versao.assistente.graficoLegendaExibirSerie' and contains(@class,'ng-not-empty')]");
	public static By desmarcarLegendaValor = By.xpath("//input[@ng-model='rc.versao.assistente.graficoLegendaExibirValor']");
	public static By legendaValorDesmarcada = By.xpath(
			"//input[@ng-model='rc.versao.assistente.graficoLegendaExibirValor' and contains(@class,'ng-empty')]");
	public static By somarNumeroOsSelecionado = By
			.xpath("//select[@ng-dblclick=\"rc.mover('DEL');\"]//ancestor::option[text()='som_numero_os'][1]");
	public static By selecionarValorParaMatriz = By
			.xpath("//*[@id=\"conteudo13\"]/div[1]/div/select[1]/option[text()='som_numero_os']");
	public static By botaoAddValorParaMatriz = By.xpath(
			"//label[@ng-click=\"rc.selecionarAba('tabx13');\"]//following::a[@ng-click=\"rc.moverGraficoValor('ADD');\" and @title='Adicionar'][1]");
	public static By selecionaValorLinhaMatriz = By
			.xpath("//*[@id=\"conteudo13\"]/div[2]/div/select[@ng-model=\"rc.versao.assistente.graficoCategoria\"]");
	public static By selecionaValorColunaMatriz = By
			.xpath("//*[@id=\"conteudo13\"]/div[3]/div/select[@ng-model=\"rc.versao.assistente.graficoSerie\"]");
	public static By exibirTotalPorLinhaMatriz = By.xpath("//input[@ng-model='rc.versao.assistente.matrizExibirTotalLinha']");
	public static By exibirTotalPorColunaMatriz = By
			.xpath("//input[@ng-model='rc.versao.assistente.matrizExibirTotalColuna']");
	public static By selecionarCampoParaTotalizar = By
			.xpath("//label[@ng-click=\"rc.selecionarAba('tabx7');\"]//following::option[text()='som_numero_os'][1]");
	public static By totalizadorMinimoSelecionado = By.xpath("//option[text()='min_som_numero_os']");
	public static By botaoAbrirWizard = By.xpath("//i[@class='fa fa-magic construtor-icon']");
	
	public static By legendaExibirValor = By.xpath("//input[@type='checkbox' and @ng-model='rc.versao.assistente.graficoLegendaExibirValor']");
	public static By legendaExibirSerie = By.xpath("//input[@type='checkbox' and @ng-model='rc.versao.assistente.graficoLegendaExibirSerie']");
	public static By legendaExibirPercentual = By.xpath("//input[@type='checkbox' and @ng-model='rc.versao.assistente.graficoLegendaExibirSerie']");
	public static By legendaCasasDecimais = By.xpath("//input[@ng-model='rc.versao.assistente.legendaCasasDecimais']");
	public static By legendaExibirSeparadorDecimal = By.xpath("//select[@ng-model='rc.versao.assistente.legendaExibirSeparadorCentesimal']");
	public static By legendaMascara = By.xpath("//input[@ng-model='rc.versao.assistente.legendaMascara']");

	public static By etiquetaExibirValor = By.xpath("//input[@type='checkbox' and @ng-model='rc.versao.assistente.graficoEtiquetaExibirValor']");
	public static By etiquetaExibirSerie = By.xpath("//input[@type='checkbox' and @ng-model='rc.versao.assistente.graficoEtiquetaExibirSerie']");
	public static By etiquetaExibirPercentual = By.xpath("//input[@type='checkbox' and @ng-model='rc.versao.assistente.graficoEtiquetaExibirPercentual']");
	public static By etiquetaCasasDecimais = By.xpath("//*[@id='conteudo12']/div[4]/div/table[2]/tbody/tr[3]/td[2]/input");
	public static By etiquetaExibirSeparadorDecimal = By.xpath("//*[@id='conteudo12']/div[4]/div/table[2]/tbody/tr[4]/td[2]/select");
	public static By etiquetaMascara = By.xpath("//*[@id='conteudo12']/div[4]/div/table[2]/tbody/tr[5]/td[2]/input");
	
	public static By abrirArvoreComponentes = By.xpath("//*[@id='tree-bloco']/ol/li/ol[7]/li/div/a");
	public static By abrirArvoreDetalhes = By.xpath("//*[@id='tree-bloco']/ol/li/ol[7]/li/ol/li/div/div/div[1]/a");
	public static By abrirArvoreRodape = By.xpath("//*[@id='tree-bloco']/ol/li/ol[7]/li/ol/li/ol/li[3]/div/div/div[1]/a");
	public static By abrirArvoreDetalhesComponenteGrafico = By.xpath("//*[@id='tree-bloco']/ol/li/ol[7]/li/ol/li/ol/li[3]/ol/li/div/div/div[1]/a");
	public static By abrirArvoreComponentesGrafico = By.xpath("//*[@id='tree-bloco']/ol/li/ol[7]/li/ol/li/ol/li[3]/ol/li/div/div/div[1]/a");
	public static By abrirPropriedadesSerieGrafico = By.xpath("//*[@id='tree-bloco']/ol/li/ol[7]/li/ol/li/ol/li[3]/ol/li/ol/li[1]/div/div/div[2]/div");
	public static By abrirPropriedadesValorGrafico = By.xpath("//*[@id='tree-bloco']/ol/li/ol[7]/li/ol/li/ol/li[3]/ol/li/ol/li[2]/div/div/div[2]/div");
	
	public static By propriedadeLegendaExibirValor = By.xpath("//input[@type='checkbox' and @ng-model='rc.versao.componente.legendaGraficoExibirValor']");
	public static By propriedadeLegendaExibirSerie = By.xpath("//input[@type='checkbox' and @ng-model='rc.versao.componente.legendaGraficoExibirSerie']");
	public static By propriedadeLegendaExibirPercentual = By.xpath("//input[@type='checkbox' and @ng-model='rc.versao.componente.legendaGraficoExibirPercentual']");
	public static By propriedadeLegendaCasasDecimais = By.xpath("//input[@ng-model='rc.versao.componente.casasDecimais']");
	public static By propriedadeLegendaMascara = By.xpath("//input[@ng-model='rc.versao.componente.mascaraFormato']");
	public static By propriedadeLegendaSeparadorDecimal = By.xpath("//select[@ng-model='rc.versao.componente.exibirSeparadorCentesimal']");
	public static By propriedadeEtiquetaExibirValor = By.xpath("//input[@type='checkbox' and @ng-model='rc.versao.componente.etiquetaGraficoExibirValor']");
	public static By propriedadeEtiquetaExibirSerie = By.xpath("//input[@type='checkbox' and @ng-model='rc.versao.componente.etiquetaGraficoExibirSerie']");
	public static By propriedadeEtiquetaExibirPercentual = By.xpath("//input[@type='checkbox' and @ng-model='rc.versao.componente.etiquetaGraficoExibirPercentual']");
	public static By propriedadeEtiquetaCasasDecimais = By.xpath("//input[@ng-model='rc.versao.componente.casasDecimais']");
	public static By propriedadeEtiquetaExibirSeparadorDecimal = By.xpath("//select[@ng-model='rc.versao.componente.exibirSeparadorCentesimal']");
	public static By propriedadeEtiquetaMascara = By.xpath("//input[@ng-model='rc.versao.componente.mascaraFormato']");
	public static By quadroRepeticaoGrafico = By.xpath("//div[@tipoelemento='GL' or @tipoelemento='GB' or @tipoelemento='GP']//div[contains(@class,'chart')]");
	
	
	public static By abaTotalizadorFuncoes(String funcao) {
		return By.xpath("//label[@ng-click=\"rc.selecionarAba('tabx7');\"]//following::a[text()='" + funcao + "'][1]");
	}

	public static By botaoFuncaoTotalizador(String funcao) {
		return By.xpath("//a[text()='" + funcao + "']");
	}

	public static By camposParaSelecaoTotalizador(String campo) {
		return By.xpath("//select[@ng-model='rc.versao.assistente.itensMarcadosTotal']/option[text()='" + campo + "']");
	}

	public static By camposParaSelecaoGrupo(String campo) {
		return By.xpath("//select[@ng-model='rc.versao.assistente.itensMarcadosGrupo']/option[text()='" + campo + "']");
	}

	public static By camposParaSelecao(String campo) {
		return By.xpath("//select[@ng-model='rc.versao.assistente.itensMarcados']/option[text()='" + campo + "']");
	}

	public static By modeloRelatorio(String modelo) {
		return By.xpath("//input[@type='radio' and @ng-model='rc.versao.assistente.modelo' and @value='"
				+ modelo.toUpperCase() + "']");
	}
	
	public static By selecionarRelatorioParaEdicao(String relatorio) {
		return By.xpath("//strong[contains(text(),'" + relatorio + "')]");
	}

}

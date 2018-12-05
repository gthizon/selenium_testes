package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.abrirRascunhoConstrutorModoListagem;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.campoLocalizarRascunho;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.menuRascunhos;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.simConfirmacao;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.situacaoRotina;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.telaRascunhosAberta;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.PropriedadesBlocoAberta;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.aba1;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.aba2;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.aba3;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.aba3LabelNegrito;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.abaSelecionada;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.abrirArvoreBlocoNotaIt;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.abrirArvoreEventos;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.abrirListaRotinas;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.abrirPropriedadesBloco;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.abrirSegundoNoh;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.areaEdicaoConstrutor;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.*;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.backDropJanela;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.backDropLov;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.barraRolagemPosicaoAlterada;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.barraRolagemPosicaoOrigem;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoAbrirCalendario;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoAbrirCalendarioDataEmissao;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoAbrirCalendarioDataHora;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoAbrirJanela;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoAbrirLovDaJanela;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoAbrirLovPeloEventoComParametro;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoAbrirLovPeloEventoSemParametro;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoAdicionarEvento;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoLovAbrirLista;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoLovCliente;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoMetodoConsultaBloco;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoMudarBarraRolagem;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoPosicaoAlterada;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoPosicaoInicial;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoPosicaoOrigem;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoProntoCalendario;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoRemoverEvento;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoSalvar;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoSalvarComMensagemSucesso;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoSalvarSemMensagemSucesso;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.calendarioComMascaraDeHorario;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoCodigoCliente;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoCodigoItem;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoCodigoItemNegrito;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoComboDesabilitado;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoCondPagto;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoData;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoDataHora;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoDescricaoItem;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoDescricaoItemNegrito;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoLovAbrirLista;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoNumeroNota;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoQtdeItem;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoQuantidadeItemNegrito;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoSequenciaComCor;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoSerieNota;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoTesteFoco1;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoTesteFocoBloco;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoTotal;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoTotalItemNegrito;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoUnitarioItemComCor;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoValor1;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.campoValorUn;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.checkBoxApenasConsulta;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.checkBoxApenasConsultaDesmarcado;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.checkBoxApenasConsultaMarcado;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.checkBoxNaoPermiteAlteracao;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.checkBoxPermiteAlteracaoDesmarcado;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.checkBoxPermiteAlteracaoMarcado;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.componenteExibirBotoes;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.componenteQuadroComCor;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.dataNoFinalDoCalendario;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.editorSql;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.eventoMarcadoParaExcluir;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.fecharJanelaTeste;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.filtroLocalizar;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.janelaTeste;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.localizarEvento;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.lovAbrirRotina;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.lovEventosCarregada;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.mensagemInformeValorCampoTotal;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.mensagemNohSemAcao;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.menuArvoreBlocos;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.menuArvoreComponentes;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.modalSelecionarBlocoEvento;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.nohDoisPontoUm;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.painelAbas;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.posicaoAlteradaLabel;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.posicaoOrigemLabel;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.primeiroNoh;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.quadroItens;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.rotinaPteste014ExibidaNoConstrutor;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.rotinaTeste015Aberta;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.segundoNoh;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.selecionaEventoAposConsultarRegistro;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.selecionarComponenteCampoLov;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.selecionarRotina;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.AtualizadorMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.ConstrutorTelasMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class TesteConstrutorTelas extends TesteGenerico {

	LoginMetodos login;
	AtualizadorMetodos atualizador;
	private String paginaConstrutor;
	private ConstrutorTelasMetodos metodosConstrutor;

	@Parameters(value = { "login", "senha", "base" })
	@Test(testName = "id: 1 - Abrir rascunho de rotina no construtor")
	public void abrirRascunhoNoConstrutor(String usuario, String senha, String base) {
		login = new LoginMetodos(this);
		login.logar(usuario, senha, base);
		atualizador = new AtualizadorMetodos(this);
		metodosConstrutor = new ConstrutorTelasMetodos(this);
		atualizador.acessarAtualizador(webDriver);
		espera.aguardarElementoEstarVisivel(menuRascunhos);
		espera.aguardarElementoSerClicavel(menuRascunhos);
		acao.clicarNoElemento(menuRascunhos);
		metodosConstrutor.aguardaProcessarConstrutorTelas();
		espera.aguardarElementoEstarVisivel(telaRascunhosAberta);
		acao.escreverNoElemento(campoLocalizarRascunho, "teste014");
		espera.aguardarElementoEstarVisivel(situacaoRotina);
		espera.aguardarElementoEstarVisivel(abrirRascunhoConstrutorModoListagem);
		espera.aguardarElementoSerClicavel(abrirRascunhoConstrutorModoListagem);
		acao.clicarNoElemento(abrirRascunhoConstrutorModoListagem);
		espera.aguardarElementoEstarVisivel(simConfirmacao);
		acao.clicarNoElemento(simConfirmacao);
		espera.aguardarElementoDesaparecer(simConfirmacao);
		navegador.trocarDeAba();
		metodosConstrutor.aguardaProcessarConstrutorTelas();
		espera.aguardarElementoEstarVisivel(areaEdicaoConstrutor);
		metodosConstrutor.aguardaProcessarConstrutorTelas();
	}

	@Test(testName = "id: 2 - Abrir rotina para testes", dependsOnMethods = { "abrirRascunhoNoConstrutor" })
	public void abrirRotinaTeste() {
		acao.clicarNoElemento(abrirListaRotinas);
		acao.escreverNoElemento(filtroLocalizar, "pteste014");
		acao.clicarNoElemento(selecionarRotina("pteste014"));
		metodosConstrutor.aguardaProcessarConstrutorTelas();
		espera.aguardarElementoEstarVisivel(rotinaPteste014ExibidaNoConstrutor);
	}
	
	@Test(testName = "id: 62 - Verificar se não permite fechar janela caso exista registro inválido", dependsOnMethods = {
	"abrirRotinaTeste" }, enabled = true)
	public void testarNaoPermitirFecharJanelaComRegistroInvalido() {
		paginaConstrutor = navegador.retornarPaginaAtual();
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "r");
		navegador.trocarDeAba();
		espera.aguardarRotinaCarregada("TESTE014");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel("TABNOTAAbrirJanela");
		acao.clicarNoElemento("TABNOTAAbrirJanela");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel("cabecalho-janelajanelaTeste");
		acao.escreverNoElemento("wkfosId-1", "teste");
		acao.limparElemento("wkfosId-1");
		By botaoFechar = By
				.xpath("//*[contains(text(),'janelaTeste')]//following::*[@title='Fechar' or @title='Cerrar' or @title='Close'][1]");
		acao.clicarNoElemento(botaoFechar);
		msg.aguardarMensagem("Informe um valor para  id e numeroOs!");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		msg.aguardarMensagemDesaparecer("Informe um valor para id e numeroOs!");
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoFechar);
		espera.aguardarElementoDesaparecer("cabecalho-janelajanelaTeste");
	}

	@Test(testName = "id: 59 - Alterar máscara do campo número via comando", dependsOnMethods = { "testarNaoPermitirFecharJanelaComRegistroInvalido" }, enabled = true)
	public void alterarMascaraDoCampoViaComando() {
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(rotina.botaoLimparConsulta);
		acao.clicarNoElemento(rotina, rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoNumeroNota, "42");
		acao.clicarNoElemento(rotina, rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		testar.passouSeAtributoDoElementoContem("campoMascaraAlterada", "value", "100,0000");
	}

	@Test(testName = "id: 60 - Verificar alinhamento das colunas da LOV conforme definido no cadastro da LOV", dependsOnMethods = {
	"alterarMascaraDoCampoViaComando" }, enabled = true)
	public void testarAlinhamentoDaLov() {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(By.xpath("//*[contains(@id,'TABNOTAITTesteTituloLov-1-0-aux') or contains(@name,'TABNOTAITTesteTituloLov-1-0-aux')]"));
		rotina.aguardarLovProcessar();
		testar.passouSeElementoEstiverVisivel(campoLovAlinhadoDireita);
		testar.passouSeElementoEstiverVisivel(campoLovAlinhadoCentro);
		testar.passouSeElementoEstiverVisivel(campoLovAlinhadoEsquerda);
		testar.passouSeElementoEstiverVisivel(campoLovSemAlinhamento);
		rotina.fecharLov();
	}
	
	@Test(testName = "id: 61 - Verificar se a etiqueta do botão está desabilitada", dependsOnMethods = {
	"testarAlinhamentoDaLov" }, enabled = true)
	public void verificarSeEtiquetaDoBotaoEstaDesabilitada() {
		testar.passouSeElementoEstiverVisivel(etiquetaBotaoDesabilitada, 1);
		testar.passouSeElementoEstiverVisivel(etiquetaBotaoDesabilitada, 2);
		testar.passouSeElementoEstiverVisivel(etiquetaBotaoDesabilitada, 3);
	}
	
	@Test(testName="id: 58 - Quando exibir mensagem de validação, manter o foco no registro atual", dependsOnMethods={"verificarSeEtiquetaDoBotaoEstaDesabilitada"})
	public void verificarMensagemDoBackEManterFocoNoRegistroAtual() {
		acao.clicarNoElemento(campoCodigoItem, 0);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.F6);
		msg.aguardarMensagem("testes");
		acao.clicarNoElemento(msg.okNotificacao);
		msg.aguardarMensagemDesaparecer("testes");
		rotina.aguardarProcessarRotina();
		testar.passouSeElementoFocadoFor(campoSeqItem, 0);

	}

	@Test(testName = "id: 57 - Verificar se salvara o registro após dar excecao no gatilho apos alterar registro", dependsOnMethods = {
			"verificarMensagemDoBackEManterFocoNoRegistroAtual" })
	public void testarExcecaoGatilhoAposAlterarRegistro() {
		acao.clicarNoElemento(campoCondPagto);
		rotina.aguardarProcessarRotina();
		rotina.limparCampoERealizarNovaConsulta();
		acao.limparElemento(campoCondPagto);
		acao.escreverNoElemento(campoCondPagto, "50");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.okNotificacao);
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarElementoDesaparecer(msg.okNotificacao);
		acao.limparElemento(campoCondPagto);
		acao.escreverNoElemento(campoCondPagto, "31");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		rotina.limparCampoERealizarNovaConsulta();
		testar.passouSeAtributoDoElementoContem(campoCondPagto, "value", "31");
		rotina.aguardarProcessarRotina();
		navegador.retornarPaginaPrincipal(paginaConstrutor);
	}

	@Test(testName = "id: 3 - Alterar propriedade Exibir Botoes da Lov para 'Nao'", dependsOnMethods = {
			"testarExcecaoGatilhoAposAlterarRegistro" })
	public void naoExibirBotaoDaLov() throws InterruptedException {
		acao.clicarNoElemento(menuArvoreComponentes);
		espera.aguardarElementoEstarVisivel(selecionarComponenteCampoLov);
		acao.clicarNoElemento(selecionarComponenteCampoLov);
		espera.aguardarElementoEstarVisivel(PropriedadesBlocoAberta);
		espera.aguardarElementoEstarVisivel(componenteExibirBotoes);
		acao.selecionarNoElemento(componenteExibirBotoes, "Não");
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "s");
		try {
			msg.aguardarMensagem("Operação realizada com sucesso!");
		} catch (Exception e) {
			teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "s");
			msg.aguardarMensagem("Operação realizada com sucesso!");
		}
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "r");
		navegador.trocarDeAba();
		espera.aguardarRotinaCarregada("TESTE014");
		espera.aguardarElementoDesaparecer(botaoLovCliente);
		rotina.aguardarProcessarRotina();
		navegador.retornarPaginaPrincipal(paginaConstrutor);
	}

	@Test(testName = "id: 4 - Alterar propriedade Exibir Botoes da Lov para 'Sim'", dependsOnMethods = { "naoExibirBotaoDaLov" })
	public void exibirBotaoDaLov() {
		espera.aguardarElementoEstarVisivel(selecionarComponenteCampoLov);
		acao.selecionarNoElemento(componenteExibirBotoes, "Sim");
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "s");
		try {
			msg.aguardarMensagem("Operação realizada com sucesso!");
		} catch (Exception e) {
			teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "s");
			msg.aguardarMensagem("Operação realizada com sucesso!");
		}
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "r");
		navegador.trocarDeAba();
		espera.aguardarRotinaCarregada("TESTE014");
		espera.aguardarElementoEstarVisivel(botaoLovCliente);
	}

	@Test(testName = "id: 48 - Informar um valor invalido e teclar F9 para abrir a LOV", dependsOnMethods = { "exibirBotaoDaLov" })
	public void testarAberturaDaLovAposInformarUmValorInvalido() {
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoCliente, "aaaaa");
		teclado.pressionarTeclaDeControle(Keys.F9);
		msg.aguardarMensagem("Caractere inválido");
		testar.passouSeElementoNaoExistir(rotina.lov);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		msg.aguardarMensagemDesaparecer("Caractere inválido");
		rotina.limparCampoERealizarNovaConsulta();
		teclado.pressionarTeclaDeControle(Keys.F6);
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 5 - Ordenar bloco conforme ordenado no construtor", dependsOnMethods = {
			"testarAberturaDaLovAposInformarUmValorInvalido" })
	public void testarFocoNoBlocoConformeOrdemNoConstrutor() {
		testar.passouSeElementoFocadoFor(campoSerieNota);
		rotina.aguardarProcessarRotina();
		navegador.retornarPaginaPrincipal(paginaConstrutor);
	}

	@Test(testName = "id: 6 - Teclar ctrl+R para verificar se a pagina nao sera atualizada", dependsOnMethods = {
			"testarFocoNoBlocoConformeOrdemNoConstrutor" })
	public void teclarCtrlR() {
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "r");
		navegador.trocarDeAba();
		metodosConstrutor.aguardaProcessarConstrutorTelas();
		espera.aguardarRotinaCarregada("TESTE014");
	}

	@Test(testName = "id: 7 - Verificar se scrool bar esta presente", dependsOnMethods = { "teclarCtrlR" }, enabled = true)
	public void verificarPresencaScrollBar() {

		String overFlow = acao.localizarElemento(quadroItens).getCssValue("overflow");
		if (overFlow.equals("auto")) {
			testar.testePassou();
		} else {
			testar.testeFalhou();
		}
	}

	@Test(testName = "id: 8 - Testar se o checkbox desabilitado permite alteracao", dependsOnMethods = { "verificarPresencaScrollBar" })
	public void checkBoxNaoPermiteMarcar() {
		try {
			acao.clicarNoElemento(checkBoxNaoPermiteAlteracao);
		} catch (InvalidElementStateException e) {
			testar.testePassou();
		}
		if (!webDriver.findElement(checkBoxNaoPermiteAlteracao).isDisplayed()) {
			testar.testePassou();
		}
	}

	@Test(testName = "id: 9 - Testar se o checkbox habilitado permite alteracao", dependsOnMethods = { "checkBoxNaoPermiteMarcar" })
	public void checkBoxPermiteMarcar() {
		espera.aguardarElementoEstarVisivel(checkBoxPermiteAlteracaoDesmarcado);
		acao.clicarNoElemento(checkBoxPermiteAlteracaoDesmarcado);
		if (webDriver.findElement(checkBoxPermiteAlteracaoMarcado).isSelected()) {
			testar.testePassou();
		}
	}

	@Test(testName = "id: 10 - Desmarcar checkbox", dependsOnMethods = { "checkBoxPermiteMarcar" })
	public void desmarcarCheckBox() {
		espera.aguardarElementoEstarVisivel(checkBoxPermiteAlteracaoMarcado);
		acao.clicarNoElemento(checkBoxPermiteAlteracaoMarcado);
		if (!webDriver.findElement(checkBoxPermiteAlteracaoMarcado).isSelected()) {
			testar.testePassou();
		}
		acao.clicarNoElemento(rotina.botaoConsultar);
		espera.aguardarElementoEstarVisivel(msg.mensagemSalvarAlteracoesPendentes);
		acao.clicarNoElemento(msg.naoConfirmacao);
		espera.aguardarElementoDesaparecer(msg.mensagemSalvarAlteracoesPendentes);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 11 - Testar se o checkbox nao permite alterar em modo insercao", dependsOnMethods = { "desmarcarCheckBox" })
	public void checkBoxNaoPermiteAlterarEmModoInsercao() {
		try {
			acao.clicarNoElemento(checkBoxApenasConsultaDesmarcado);
		} catch (InvalidElementStateException e) {
			testar.testePassou();
		}
		Assert.assertTrue(!webDriver.findElement(checkBoxApenasConsultaMarcado).isSelected());
	}

	@Test(testName = "id: 12 - Testar se o checkbox permite alterar em modo consulta", dependsOnMethods = {
			"checkBoxNaoPermiteAlterarEmModoInsercao" })
	public void checkBoxPermiteAlterarEmModoConsulta() {
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(checkBoxApenasConsulta);
		testar.passouSeElementoNaoEstiverSelecionado(checkBoxApenasConsulta);
		acao.clicarNoElemento(checkBoxApenasConsulta);
		Assert.assertTrue(webDriver.findElement(checkBoxApenasConsulta).isSelected());
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		navegador.retornarPaginaPrincipal(paginaConstrutor);
	}

	@Test(testName = "id: 13 - Testar o bloco com o comportamento de exclusao nao isolado", dependsOnMethods = {
			"checkBoxPermiteAlterarEmModoConsulta" })
	public void excluirBlocoNaoIsolado() {
		espera.aguardarElementoEstarVisivel(menuArvoreBlocos);
		acao.clicarNoElemento(menuArvoreBlocos);
		espera.aguardarElementoEstarVisivel(abrirPropriedadesBloco);
		acao.clicarNoElemento(abrirPropriedadesBloco);
		espera.aguardarElementoEstarVisivel(PropriedadesBlocoAberta);
		espera.aguardarElementoEstarVisivel(atributoComportamentoRelacionamento);
		acao.selecionarNoElemento(atributoComportamentoRelacionamento, "Não Isolado");
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "s");
		try {
			msg.aguardarMensagem("Operação realizada com sucesso!");
		} catch (Exception e) {
			teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "s");
			msg.aguardarMensagem("Operação realizada com sucesso!");
		}
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "r");
		navegador.trocarDeAba();
		metodosConstrutor.insereRegistroRotinaPteste014(webDriver);
		acao.clicarNoElemento(campoSerieNota);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoExcluir);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosFilhosLocalizados);
		msg.fecharMensagemNotificacao();
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoCancelar);
		rotina.aguardarProcessarRotina();
		navegador.retornarPaginaPrincipal(paginaConstrutor);
	}

	@Test(testName = "id: 14 - Testar o bloco com o comportamento de exclusao Cascata", dependsOnMethods = { "excluirBlocoNaoIsolado" })
	public void excluirBlocoCascata() {
		acao.selecionarNoElemento(atributoComportamentoRelacionamento, "Em Cascata");
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemSucesso);
		msg.fecharMensagemNotificacao();
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "r");
		navegador.trocarDeAba();
		rotina.aguardarProcessarRotina();
		espera.aguardarRotinaCarregada("TESTE014");
		acao.clicarNoElemento(campoSerieNota);
		espera.aguardarElementoEstarVisivel(rotina.botaoConsultar);
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		String numeroNota = acao.retornarValorDoElemento(campoNumeroNota);
		acao.clicarNoElemento(rotina.botaoExcluir);
		espera.aguardarElementoEstarVisivel(rotina.blocoDeRegistrosAlterados);
		acao.clicarNoElemento(rotina.botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		msg.fecharMensagemNotificacao();
		rotina.limparCampoERealizarNovaConsulta();
		testar.passouSeAtributoDoElementoForDiferenteDe(campoNumeroNota, "value", numeroNota);
		rotina.aguardarProcessarRotina();
		navegador.retornarPaginaPrincipal(paginaConstrutor);
	}

	@Test(testName = "id: 15 - Testar o bloco com o comportamento de exclusao Isolado", dependsOnMethods = { "excluirBlocoCascata" })
	public void excluirBlocoIsolado() {
		acao.selecionarNoElemento(atributoComportamentoRelacionamento, "Isolado");
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemSucesso);
		msg.fecharMensagemNotificacao();
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "r");
		navegador.trocarDeAba();
		espera.aguardarRotinaCarregada("TESTE014");
		metodosConstrutor.insereRegistroRotinaPteste014(webDriver);
		acao.clicarNoElemento(campoSerieNota);
		rotina.aguardarProcessarRotina();
		String numeroNota = acao.retornarValorDoElemento(campoNumeroNota);
		acao.clicarNoElemento(rotina.botaoExcluir);
		espera.aguardarElementoEstarVisivel(rotina.blocoDeRegistrosAlterados);
		acao.clicarNoElemento(rotina.botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		msg.fecharMensagemNotificacao();
		rotina.limparCampoERealizarNovaConsulta();
		testar.passouSeAtributoDoElementoForDiferenteDe(campoNumeroNota, "value", numeroNota);
		rotina.aguardarProcessarRotina();
		navegador.retornarPaginaPrincipal(paginaConstrutor);
	}

	@Test(testName = "id: 16 - Testar funcionamento metodo consulta bloco", dependsOnMethods = { "excluirBlocoIsolado" })
	public void metodoConsultaBloco() {
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "r");
		navegador.trocarDeAba();
		espera.aguardarRotinaCarregada("TESTE014");
		espera.aguardarElementoEstarVisivel(botaoMetodoConsultaBloco);
		acao.clicarNoElemento(botaoMetodoConsultaBloco);
		rotina.aguardarProcessarRotina();
		espera.aguardarAtributoDoElementoSer(campoNumeroNota, "value", "30");
	}

	@Test(testName = "id: 17 - Testar metodo salvar, sem exibir mensagem de sucesso", dependsOnMethods = { "metodoConsultaBloco" })
	public void testarMetodoSalvarSemMensagem() throws InterruptedException, AWTException {
		rotina.limparCampoERealizarNovaConsulta();
		acao.limparElemento(campoCondPagto);
		acao.escreverNoElemento(campoCondPagto, "30");
		acao.clicarNoElemento(botaoSalvarSemMensagemSucesso);
		rotina.aguardarProcessarRotina();
		espera.verificarSeElementoNaoExiste(msg.mensagemRegistrosAlterados);
	}

	@Test(testName = "id: 18 - Testar metodo salvar, exibindo mensagem de sucesso", dependsOnMethods = { "testarMetodoSalvarSemMensagem" })
	public void testarMetodoSalvarComMensagem() throws InterruptedException, AWTException {
		rotina.limparCampoERealizarNovaConsulta();
		acao.limparElemento(campoCondPagto);
		acao.escreverNoElemento(campoCondPagto, "40");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoSalvarComMensagemSucesso);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		acao.limparElemento(campoCondPagto);
		acao.escreverNoElemento(campoCondPagto, "30");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}

	@Test(testName = "id: 19 - Verificar se ao clicar no botao, seu estilo sera alterado", dependsOnMethods = {
			"testarMetodoSalvarComMensagem" })
	public void alterarCssBotaoEmTempoDeExecucao() {
		rotina.limparCampoERealizarNovaConsulta();
		String backGroundOrigem = acao.localizarElemento(botaoMetodoConsultaBloco).getCssValue("background-color");
		testar.passouSeValorContem(backGroundOrigem, "156, 66, 66");
		acao.clicarNoElemento(botaoMetodoConsultaBloco);
		rotina.aguardarProcessarRotina();
		String backGroundAlterado = acao.localizarElemento(botaoMetodoConsultaBloco).getCssValue("background-color");
		testar.passouSeValorContem(backGroundAlterado, "255, 255, 255");
	}

	@Test(testName = "id: 20 - Verificar se quadro possui a cor conforme definido em suas propriedades", dependsOnMethods = {
			"alterarCssBotaoEmTempoDeExecucao" })
	public void verificarCorNoQuadro() {
		String backGroundQuadro = acao.localizarElemento(componenteQuadroComCor).getCssValue("background-color");
		testar.passouSeValorContem(backGroundQuadro, "156, 66, 66");
		rotina.aguardarProcessarRotina();
		navegador.retornarPaginaPrincipal(paginaConstrutor);
	}

	@Test(testName = "id: 21 - Testar metodo AlterarComponente em tempo de execucao, opcao Nao", dependsOnMethods = {
			"verificarCorNoQuadro" })
	public void alterarComponenteEmTempoDeExecucaoOpcaoNaoNavegavel() {

		acao.clicarNoElemento(abrirArvoreBlocoNotaIt);
		espera.aguardarElementoEstarVisivel(abrirArvoreEventos);
		acao.clicarNoElemento(abrirArvoreEventos);
		excluirEvento();
		acao.clicarNoElemento(botaoAdicionarEvento);
		espera.aguardarElementoEstarVisivel(lovEventosCarregada);
		espera.aguardarElementoEstarVisivel(selecionaEventoAposConsultarRegistro);
		espera.aguardarElementoEstarVisivel(localizarEvento);
		acao.limparElemento(localizarEvento);
		acao.escreverNoElemento(localizarEvento, "aposconsultar");
		acao.clicarNoElemento(selecionaEventoAposConsultarRegistro);
		espera.aguardarElementoDesaparecer(modalSelecionarBlocoEvento);
		acao.escreverNoElemento(editorSql, "alterarComponente(\"TABNOTAITQuantidade\", NAVEGAVEL_TECLADO, N);");
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemSucesso);
		msg.fecharMensagemNotificacao();
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "r");
		navegador.trocarDeAba();
		metodosConstrutor.aguardaProcessarConstrutorTelas();
		espera.aguardarRotinaCarregada("TESTE014");
		espera.aguardarElementoEstarVisivel(rotina.botaoConsultar);
		acao.clicarNoElemento(campoSerieNota);
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoItem);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		testar.passouSeElementoFocadoFor(campoValorUn);
		rotina.aguardarProcessarRotina();
		navegador.retornarPaginaPrincipal(paginaConstrutor);
	}

	@Test(testName = "id: 22 - Testar metodo AlterarComponente em tempo de execucao, opcao Sim", dependsOnMethods = {
			"alterarComponenteEmTempoDeExecucaoOpcaoNaoNavegavel" })
	public void alterarComponenteEmTempoDeExecucaoOpcaoSimNavegavel() {
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		acao.escreverNoElemento(editorSql, selectAll);
		acao.escreverNoElemento(editorSql, "alterarComponente(\"TABNOTAITQuantidade\", NAVEGAVEL_TECLADO, S);");
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemSucesso);
		msg.fecharMensagemNotificacao();
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "r");
		navegador.trocarDeAba();
		espera.aguardarRotinaCarregada("TESTE014");
		espera.aguardarElementoEstarVisivel(rotina.botaoConsultar);
		acao.clicarNoElemento(campoSerieNota);
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoItem);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		testar.passouSeElementoFocadoFor(campoQtdeItem);
		rotina.aguardarProcessarRotina();
		navegador.retornarPaginaPrincipal(paginaConstrutor);
	}

	@Test(testName = "id: 23 - Testar metodo alterar bloco se quando em evento, nao deve estar permitindo alteracoes", dependsOnMethods = {
			"alterarComponenteEmTempoDeExecucaoOpcaoSimNavegavel" })
	public void metodoAlterarBlocoNaoPermiteCrud() {

		String selectAll = Keys.chord(Keys.CONTROL, "a");
		acao.escreverNoElemento(editorSql, selectAll);
		acao.escreverNoElemento(editorSql,
				"alterarBloco(\"TABNOTAIT\", PERMITE_INCLUSAO, \"N\");\r\n" + "alterarBloco(\"TABNOTAIT\", PERMITE_ALTERACAO, \"N\");\r\n"
						+ "alterarBloco(\"TABNOTAIT\", PERMITE_EXCLUSAO, \"N\"); \r\n"
						+ "alterarComponenteAtual(\"TABNOTAITSequencia\", FONTE_COR,\"#cc6666\");\r\n"
						+ "alterarComponenteAtual(\"TABNOTAITItem\", FONTE_PESO, \"B\");\r\n"
						+ "alterarComponenteAtual(\"TABNOTAITQuantidade\", FONTE_PESO, \"B\");\r\n"
						+ "alterarComponenteAtual(\"TABNOTAITUnitario\", FUNDO_COR, \"#cc6666\");\r\n"
						+ "alterarComponenteAtual(\"TABNOTAITValorItem\", FONTE_PESO, \"B\");\r\n"
						+ "alterarComponenteAtual(\"TABNOTAITNomeItem\", FONTE_PESO, \"B\");");

		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "s");
		espera.aguardarElementoEstarVisivel(msg.mensagemSucesso);
		msg.fecharMensagemNotificacao();
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "r");
		navegador.trocarDeAba();
		espera.aguardarRotinaCarregada("TESTE014");
		metodosConstrutor.aguardaProcessarConstrutorTelas();
		espera.aguardarElementoEstarVisivel(rotina.botaoLimparConsulta);
		acao.clicarNoElemento(campoSerieNota);
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoNumeroNota, "36");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoItem);
		rotina.aguardarProcessarRotina();
		String valorAtual = acao.localizarElemento(campoCodigoItem).getAttribute("value");
		acao.escreverNoElemento(campoCodigoItem, "5454");
		testar.passouSeAtributoDoElementoForIgualA(campoCodigoItem, "value", valorAtual);
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
		espera.aguardarElementoEstarVisivel(msg.mensagemOperacaoNaoPermitida);
		msg.fecharMensagemNotificacao();
		espera.aguardarElementoDesaparecer(msg.mensagemOperacaoNaoPermitida);
		teclado.pressionarTeclaDeControle(Keys.F6);
		espera.aguardarElementoEstarVisivel(msg.mensagemOperacaoNaoPermitida);
		msg.fecharMensagemNotificacao();
		espera.aguardarElementoDesaparecer(msg.mensagemOperacaoNaoPermitida);
		teclado.pressionarTeclaDeControle(Keys.F4);
		espera.aguardarElementoEstarVisivel(msg.mensagemOperacaoNaoPermitida);
		msg.fecharMensagemNotificacao();
		espera.aguardarElementoDesaparecer(msg.mensagemOperacaoNaoPermitida);
	}

	@Test(testName = "id: 24 - Testar mudanca de posicao do componente na tela, ao receber o click. ", dependsOnMethods = {
			"metodoAlterarBlocoNaoPermiteCrud" })
	public void mudancaDePosicaoDoComponenteDaTelaBotaoELabelJuntos() {
		acao.clicarNoElemento(botaoPosicaoInicial);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(botaoPosicaoAlterada);
		espera.aguardarElementoEstarVisivel(posicaoAlteradaLabel);
		acao.clicarNoElemento(botaoPosicaoAlterada);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(botaoPosicaoOrigem);
		espera.aguardarElementoEstarVisivel(posicaoOrigemLabel);
	}

	@Test(testName = "id: 25 - Testar mudanca de posicao e redimensionamento do componente barra rolagem. ", dependsOnMethods = {
			"mudancaDePosicaoDoComponenteDaTelaBotaoELabelJuntos" })
	public void mudancaDePosicaoERedimensionamentoBarraRolagem() {
		acao.clicarNoElemento(botaoMudarBarraRolagem);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(barraRolagemPosicaoAlterada);
		acao.clicarNoElemento(botaoMudarBarraRolagem);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(barraRolagemPosicaoOrigem);
	}

	@Test(testName = "id: 26 - Teste de propriedade do metodo alterarComponenteAtual", dependsOnMethods = {
			"mudancaDePosicaoERedimensionamentoBarraRolagem" })
	public void metodoAlterarComponenteAtual() {
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoNumeroNota, "30");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(campoSequenciaComCor);
		espera.aguardarElementoEstarVisivel(campoCodigoItemNegrito);
		espera.aguardarElementoEstarVisivel(campoDescricaoItemNegrito);
		espera.aguardarElementoEstarVisivel(campoQuantidadeItemNegrito);
		espera.aguardarElementoEstarVisivel(campoUnitarioItemComCor);
		espera.aguardarElementoEstarVisivel(campoTotalItemNegrito);
	}

	@Test(testName = "id: 27 - Escrever em um campo que esteja configurado como caixa baixa e verificar se os demais campos não alteram", dependsOnMethods = {
			"metodoAlterarComponenteAtual" })
	public void verificarCaixaDaFonte() {
		acao.clicarNoElemento(campoCondPagto);
		String descItemInicial = acao.localizarElementos(campoDescricaoItem).get(0).getAttribute("value");
		rotina.aguardarProcessarRotina();
		String caixaAlta = "A VISTA";
		acao.limparElemento(rotina, campoCondPagto);
		acao.escreverNoElemento(campoCondPagto, caixaAlta);
		String descItem = acao.localizarElementos(campoDescricaoItem).get(0).getAttribute("value");
		String condicoes = acao.localizarElemento(campoCondPagto).getAttribute("value");
		testar.passouSeValoresForemDiferentes(caixaAlta, condicoes);
		testar.passouSeValoresForemIguais(descItem, descItemInicial);
		acao.clicarNoElemento(rotina.botaoCancelar);
		espera.aguardarElementoEstarVisivel(msg.simConfirmacao);
		acao.clicarNoElemento(msg.simConfirmacao);
		espera.aguardarElementoDesaparecer(msg.simConfirmacao);
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 50 - Adicionar item com imagem e depois excluir verificando se a imagem nao sera excluida do banco", dependsOnMethods = {
			"verificarCaixaDaFonte" })
	public void excluirItemQuePossuaImagemRelacionada() {
		navegador.retornarPaginaPrincipal(paginaConstrutor);
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		acao.escreverNoElemento(editorSql, selectAll);
		acao.escreverNoElemento(editorSql, "//");
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemSucesso);
		msg.fecharMensagemNotificacao();
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "r");
		navegador.trocarDeAba();
		rotina.aguardarProcessarRotina();
		espera.aguardarRotinaCarregada("TESTE014");
		espera.aguardarElementoEstarVisivel(rotina.botaoLimparConsulta);
		acao.clicarNoElemento(rotina, rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoNumeroNota, "40");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoItem);
		acao.escreverNoElemento(campoCodigoItem, "1002");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoQuantidadeItem, "10");
		acao.escreverNoElemento(campoUnitarioItem, "10");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		rotina.excluirESalvar();
		acao.clicarNoElemento(campoCodigoItem);
		acao.escreverNoElemento(campoCodigoItem, "1002");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoQuantidadeItem, "10");
		acao.escreverNoElemento(campoUnitarioItem, "10");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		espera.aguardarElementoEstarVisivel(campoImagemItem);
		rotina.excluirESalvar();

	}

	@Test(testName = "id: 49 - Verificar se nao permite selecionar opcao no checkbox desabilitado", dependsOnMethods = {
			"excluirItemQuePossuaImagemRelacionada" }, enabled = true)
	public void verificarCheckboxDesabilitadoNaoPermiteSelecionar() {
		try {
			acao.selecionarNoElemento(campoComboDesabilitado, "Gerada");
			testar.passouSeValorDoElementoSelecionadoFor(campoComboDesabilitado, "");
		} catch (NoSuchElementException e) {
			testar.testePassou();
		}
	}

	@Test(testName = "id: 53 - Testar paginacao do filtro da lov", dependsOnMethods = {
			"verificarCheckboxDesabilitadoNaoPermiteSelecionar" }, enabled = true)
	public void testarPaginacaoFiltroLov() {
		acao.clicarNoElemento("TABNOTACliente-1-0-aux");
		rotina.aguardarLovProcessar();
		espera.aguardarElementoEstarVisivel(campoLocalizarLovCorrentista);
		acao.clicarNoElemento(rotina.botaoAvancarPaginacaoLov);
		espera.aguardarElementoEstarVisivel(rotina.verificarPaginaAtualLov("2"));
		acao.clicarNoElemento(rotina.botaoAvancarPaginacaoLov);
		espera.aguardarElementoEstarVisivel(rotina.verificarPaginaAtualLov("3"));
		acao.escreverNoElemento(campoLocalizarLovCorrentista, "refrigeracao");
		espera.aguardarElementoEstarVisivel(rotina.verificarPaginaAtualLovETotalDePaginas("3", "4"));
		acao.limparElemento(campoLocalizarLovCorrentista);
		espera.aguardarElementoEstarVisivel(rotina.verificarPaginaAtualLovETotalDePaginas("3", "282"));
		acao.clicarNoElemento(rotina.botaoRetornarPaginacaoLov);
		espera.aguardarElementoEstarVisivel(rotina.verificarPaginaAtualLov("2"));
		acao.clicarNoElemento(rotina.botaoRetornarPaginacaoLov);
		espera.aguardarElementoEstarVisivel(rotina.verificarPaginaAtualLovETotalDePaginas("1", "282"));
		rotina.filtrarESelecionarValorNaLov("DESPORTIVA");
		espera.aguardarAtributoDoElementoConterOValor(campoCodigoCliente, "value", "2834");
		espera.aguardarAtributoDoElementoConterOValor(campoNomeCliente, "value", "A DESPORTIVA TRES IRMAOS LTDA");
		acao.clicarNoElemento(rotina.botaoExcluir);
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 28 - Verificar se calendario exibe mascara de horario", dependsOnMethods = { "testarPaginacaoFiltroLov" })
	public void calendarioMascaraHorario() {
		acao.clicarNoElemento(botaoAbrirCalendarioDataEmissao);
		espera.aguardarElementoEstarVisivel(calendarioComMascaraDeHorario);
		rotina.aguardarProcessarRotina();
		navegador.retornarPaginaPrincipal(paginaConstrutor);
	}

	@Test(testName = "id: 29 - Excluir gatilho", dependsOnMethods = { "calendarioMascaraHorario" })
	public void excluirEvento() {
		if (webDriver.findElements(botaoRemoverEvento).size() != 0) {
			espera.aguardarElementoEstarVisivel(botaoRemoverEvento);
			acao.clicarNoElemento(botaoRemoverEvento);
			espera.aguardarElementoEstarVisivel(eventoMarcadoParaExcluir);
			acao.clicarNoElemento(botaoSalvar);
			espera.aguardarElementoEstarVisivel(msg.mensagemSucesso);
			msg.fecharMensagemNotificacao();
		}
	}

	@Test(testName = "id: 30 - Abrir rotina pteste015", dependsOnMethods = { "excluirEvento" })
	public void abrirRotinaPteste015NoConstrutor() {
		acao.clicarNoElemento(abrirListaRotinas);
		acao.escreverNoElemento(filtroLocalizar, "pteste015");
		acao.clicarNoElemento(selecionarRotina("pteste015"));
		metodosConstrutor.aguardaProcessarConstrutorTelas();
		espera.aguardarElementoEstarVisivel(rotinaTeste015Aberta);
	}

	@Test(testName = "id: 31 - Reordenar blocos e verificar se o foco estara no primeiro campo do primeiro bloco", dependsOnMethods = {
			"abrirRotinaPteste015NoConstrutor" })
	public void testarFocoAposReordenarBloco() {
		metodosConstrutor.aguardaProcessarConstrutorTelas();
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "r");
		navegador.trocarDeAba();
		metodosConstrutor.aguardaProcessarConstrutorTelas();
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(rotina.rotinaCarregada);
		testar.passouSeElementoFocadoFor(campoTesteFocoBloco);
	}

	@Test(testName = "id: 32 - Clicar no noh do primeiro nivel e verificar a mensagem exibida", dependsOnMethods = {
			"testarFocoAposReordenarBloco" }, enabled = true)
	public void testarEventoNohPrimeiroNivel() {
		espera.aguardarElementoEstarVisivel(primeiroNoh);
		acao.clicarNoElemento(primeiroNoh);
		espera.aguardarElementoEstarVisivel(mensagemNohSemAcao);
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarElementoDesaparecer(mensagemNohSemAcao);
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 33 - Clicar no noh do segundo nivel e verificar a mensagem exibida", dependsOnMethods = {
			"testarEventoNohPrimeiroNivel" }, enabled = true)
	public void testarEventoNohSegundoNivel() {
		while (acao.localizarElementos(mensagemNohSemAcao).size() == 0) {
			acao.clicarNoElemento(segundoNoh);
			try {
				espera.aguardarElementoEstarVisivel(mensagemNohSemAcao);
			} catch (Exception e) {
			}
		}
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarElementoDesaparecer(mensagemNohSemAcao);
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 34 - Clicar no sub noh do segundo nivel e aguardar a rotina abrir", dependsOnMethods = {
			"testarEventoNohSegundoNivel" }, enabled = true)
	public void abrirRotinaAoClicarNoSubNoh() {
		acao.clicarNoElemento(abrirSegundoNoh);
		espera.aguardarElementoEstarVisivel(nohDoisPontoUm);
		acao.clicarNoElemento(nohDoisPontoUm);
		espera.aguardarElementoEstarVisivel(rotina.retornarRotinaCarregada("arc001"));
		rotina.fecharRotina("arc001");
	}

	@Test(testName = "id: 35 - verificar se componente abas esta sendo exibido", dependsOnMethods = {
			"abrirRotinaAoClicarNoSubNoh" }, enabled = true)
	public void verificaSeComponenteAbasEstaExibindo() {
		testar.passouSeElementoEstiverVisivel(painelAbas);
	}

	@Test(testName = "id: 36 - verificar se a aba 3 vem selecionada ao abrir a rotina propriedade 'selecionada = sim'", dependsOnMethods = {
			"verificaSeComponenteAbasEstaExibindo" }, enabled = true)
	public void abaMarcadaComoSelecionadaPorPadrao() {
		espera.aguardarElementoEstarVisivel(abaSelecionada("Aba3"));
	}

	@Test(testName = "id: 37 - verificar se a troca de abas esta funcionando", dependsOnMethods = {
			"abaMarcadaComoSelecionadaPorPadrao" }, enabled = true)
	public void trocarDeAbas() {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(aba1);
		espera.aguardarElementoEstarVisivel(abaSelecionada("Aba1"));
		acao.clicarNoElemento(campoTesteFoco1);
	}

	@Test(testName = "id: 38 - verificar funcionamento do evento QuandoSelecionarAba", dependsOnMethods = {
			"trocarDeAbas" }, enabled = true)
	public void eventoQuandoSelecionarAba() {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(aba2);
		espera.aguardarElementoEstarVisivel(abaSelecionada("Aba2"));
		rotina.aguardarProcessarRotina();
		rotina.verificarElementoFocado("id", "testeFoco2");
		acao.posicionarFocoNoElemento(rotina, campoTotal);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(aba3);
		espera.aguardarElementoEstarVisivel(abaSelecionada("Aba3"));
	}

	@Test(testName = "id: 39 - verificar funcionamento do evento alterarComponente devera alterar o titulo da aba para negrito", dependsOnMethods = {
			"eventoQuandoSelecionarAba" }, enabled = true)
	public void alterarLabelDaAbaParaNegrito() {
		espera.aguardarElementoEstarVisivel(aba3LabelNegrito);
	}

	@Test(testName = "id: 40 - Nao permitir executar evento em arvore quando existir registro invalido", dependsOnMethods = {
			"alterarLabelDaAbaParaNegrito" }, enabled = true)
	public void naoFuncionarArvoreComRegistroInvalido() {
		acao.clicarNoElemento(campoTotal);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoTotal, "10");
		acao.limparElemento(campoTotal);
		acao.clicarNoElemento(nohDoisPontoUm);
		espera.aguardarElementoEstarVisivel(mensagemInformeValorCampoTotal);
		msg.fecharMensagemNotificacao();
		espera.aguardarElementoDesaparecer(mensagemInformeValorCampoTotal);
	}

	@Test(testName = "id: 41 - Verificar se backdrop da rotina continua ativo apos fechar lov", dependsOnMethods = {
			"naoFuncionarArvoreComRegistroInvalido" }, enabled = true)
	public void verificarSeBackDropContinuaAtivo() {
		acao.clicarNoElemento(botaoAbrirJanela);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(janelaTeste);
		acao.clicarNoElemento(botaoAbrirLovDaJanela);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(rotina.lov);
		espera.aguardarElementoEstarVisivel(backDropLov);
		acao.clicarNoElemento(rotina.fecharLov);
		espera.aguardarElementoDesaparecer(rotina.lov);
		espera.aguardarElementoDesaparecer(backDropLov);
		acao.clicarNoElemento(fecharJanelaTeste);
		espera.aguardarElementoDesaparecer(janelaTeste);
		espera.aguardarElementoDesaparecer(backDropJanela);
	}
	

	@Test(testName = "id: 51 - Verificar se evento apos fechar janela eh executado via comando", dependsOnMethods = {
			"verificarSeBackDropContinuaAtivo" }, enabled = true)
	public void verificarFuncionamentoEventoAposFecharJanela() {
		msg.aguardarMensagem("Janela fechada com sucesso");
		espera.aguardarElementoEstarVisivel(msg.okNotificacao);
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarElementoDesaparecer(msg.okNotificacao);
		acao.clicarNoElemento(botaoAbrirJanela);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(janelaTeste);
		acao.clicarNoElemento("botaoFecharJanela-1");
		msg.aguardarMensagem("Janela fechada com sucesso");
		espera.aguardarElementoEstarVisivel(msg.okNotificacao);
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarElementoDesaparecer(msg.okNotificacao);
	}

	@Test(testName = "id: 42 - Verificar se compoente calendario abre corretamente dentro de componente aba", dependsOnMethods = {
			"verificarFuncionamentoEventoAposFecharJanela" }, enabled = true)
	public void verificarComponenteCalendarioEmAba() {
		espera.aguardarElementoEstarVisivel(botaoAbrirCalendario);
		acao.clicarNoElemento(botaoAbrirCalendario);
		espera.aguardarElementoEstarVisivel(dataNoFinalDoCalendario);
		acao.clicarNoElemento(dataNoFinalDoCalendario);
		espera.aguardarElementoDesaparecer(dataNoFinalDoCalendario);
		espera.aguardarElementoNaoEstarVazio(campoData, 0, "value");
	}

	@Test(testName = "id: 43 - Verificar se compoente calendario com data exibe botao para fechar apos selecionar", dependsOnMethods = {
			"verificarComponenteCalendarioEmAba" }, enabled = true)
	public void fecharCalendarioPeloBotaoAposSelecionarData() {
		espera.aguardarElementoEstarVisivel(botaoAbrirCalendarioDataHora);
		acao.clicarNoElemento(botaoAbrirCalendarioDataHora);
		espera.aguardarElementoEstarVisivel(dataNoFinalDoCalendario);
		acao.clicarNoElemento(dataNoFinalDoCalendario);
		espera.aguardarElementoEstarVisivel(botaoProntoCalendario);
		acao.clicarNoElemento(botaoProntoCalendario);
		espera.aguardarElementoDesaparecer(botaoProntoCalendario);
		espera.aguardarElementoNaoEstarVazio(campoDataHora, 0, "value");

	}

	@Test(testName = "id: 44 - Testar evento processarLista abrir rotina", dependsOnMethods = {
			"fecharCalendarioPeloBotaoAposSelecionarData" }, enabled = true)
	public void testarEventoProcessarListaAbrirRotina() {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(lovAbrirRotina);
		rotina.retornarRotinaCarregada("arc001");
		rotina.fecharRotina("arc001");
	}

	@Test(testName = "id: 45 - Testar evento processarLista abrir lista", dependsOnMethods = {
			"testarEventoProcessarListaAbrirRotina" }, enabled = true)
	public void testarEventoProcessarListaAbrirLista() {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoLovAbrirLista);
		espera.aguardarElementoEstarVisivel(rotina.verificarLovAberta("empresas"));
		acao.clicarNoElemento(rotina.fecharLov);
		espera.aguardarElementoDesaparecer(rotina.lov);
	}

	@Test(testName = "id: 46 - Testar evento abrirLov com parametro", dependsOnMethods = {
			"testarEventoProcessarListaAbrirLista" }, enabled = true)
	public void testarEventoAbrirLovComParametro() {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoAbrirLovPeloEventoComParametro);
		espera.aguardarElementoEstarVisivel(rotina.verificarLovAberta("empresas"));
		acao.clicarNoElemento(rotina.selecionarValorLov("5"));
		espera.aguardarElementoDesaparecer(rotina.lov);
		rotina.aguardarProcessarRotina();
		espera.aguardarAtributoDoElementoConterOValor(campoLovAbrirLista, "value", "5");
		espera.aguardarAtributoDoElementoConterOValor(campoValor1, "value", "1000");
	}

	@Test(testName = "id: 47 - Testar evento abrirLov sem parametro", dependsOnMethods = {
			"testarEventoAbrirLovComParametro" }, enabled = true)
	public void testarEventoAbrirLovSemParametro() {
		acao.limparElemento(campoValor1);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, botaoAbrirLovPeloEventoSemParametro);
		espera.aguardarElementoEstarVisivel(rotina.verificarLovAberta("empresas"));
		acao.limparElemento(rotina.filtrarLov);
		acao.escreverNoElemento(rotina.filtrarLov, "1%Teste");
		acao.clicarNoElemento(rotina.selecionarValorLov("1"));
		espera.aguardarElementoDesaparecer(rotina.lov);
		rotina.aguardarProcessarRotina();
		espera.aguardarAtributoDoElementoConterOValor(campoLovAbrirLista, "value", "1");
		espera.aguardarAtributoDoElementoConterOValor(campoValor1, "value", "500");
	}

	@Test(testName = "id: 52 - Verificar se componentes estao sendo exibidos quando marcado visivel = sim e ocultado quando marcado visivel = nao", dependsOnMethods = {
			"testarEventoAbrirLovSemParametro" }, enabled = true)
	public void testarFuncionamentoDaPropriedadeVisivel() {
		acao.clicarNoElemento("botaoAbrirJanelaVisibilidade-1");
		espera.aguardarElementoEstarVisivel("janelaVisibilidade");
		espera.aguardarElementoEstarVisivel("quadroVisivel");
		espera.aguardarElementoEstarVisivel("dataVisivel-1");
		espera.aguardarElementoEstarVisivel("checkVisivel");
		espera.aguardarElementoEstarVisivel("arquivoVisivel");
		espera.aguardarElementoEstarVisivel("barra_rolagemVisivel");
		espera.aguardarElementoEstarVisivel(campoTextoVisivelJanelaVisibilidade);
		espera.aguardarElementoEstarVisivel("campoInputVisivel");
		espera.aguardarElementoEstarVisivel("listaVisivel");
		espera.aguardarElementoEstarVisivel("lovVisivel");
		espera.aguardarElementoEstarVisivel("textAreaVisivel");
		espera.aguardarElementoEstarVisivel("botaoVisivel");
		espera.aguardarElementoEstarVisivel("arvoreVisivel");
		espera.aguardarElementoEstarVisivel(quadroImagemJanelaVisibilidade);

		espera.aguardarElementoDesaparecer("quadroOculto");
		espera.aguardarElementoDesaparecer(campoTextoOcultoJanelaVisibilidade);
		espera.aguardarElementoDesaparecer("campoInputOculto");
		espera.aguardarElementoDesaparecer("lovOculto");
		espera.aguardarElementoDesaparecer("dataOculto");
		espera.aguardarElementoDesaparecer("textAreaOculto");
		espera.aguardarElementoDesaparecer("checkOculto");
		espera.aguardarElementoDesaparecer(quadroImagemOcultaJanelaVisibilidade);
		espera.aguardarElementoDesaparecer("listaOculto");
		espera.aguardarElementoDesaparecer("botaoOculto");
		espera.aguardarElementoDesaparecer("arvoreOculto");
		espera.aguardarElementoDesaparecer("barra_rolagemOculto");
		espera.aguardarElementoDesaparecer("arquivoOculto");
		rotina.fecharJanelaModal("Visibilidade");
	}

	@Test(testName = "id: 54 - Informar um valor válido no campo e verificar se o método IsValido realizara a validacao", dependsOnMethods = {
			"testarFuncionamentoDaPropriedadeVisivel" }, enabled = true)
	public void testarMetodoIsItemValido() {
		acao.escreverNoElemento("testeValidarItem-1", "10");
		acao.clicarNoElemento(rotina, "testeBotaoValidarItem-1");
		msg.aguardarMensagem("Item válido parabéns");
		acao.clicarNoElemento(msg.okNotificacao);
		msg.aguardarMensagemDesaparecer("Item válido parabéns");
	}

	@Test(testName = "id: 55 - Deixar o campo em branco e verificar se exibira a mensagem de erro", dependsOnMethods = {
			"testarMetodoIsItemValido" }, enabled = true)
	public void testarCampoInvalido() {
		acao.limparElemento("testeValidarItem-1");
		acao.clicarNoElemento(rotina, "testeBotaoValidarItem-1");
		msg.aguardarMensagem("valor inválido");
		acao.clicarNoElemento(msg.okNotificacao);
		msg.aguardarMensagemDesaparecer("valor inválido");
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 56 - Alterar uma lista via comando e verificar se nao altera as listas de outros componentes.", dependsOnMethods = {
			"testarCampoInvalido" }, enabled = true)
	public void testarAlterarListaDinamicamente() {
		acao.clicarNoElemento("bloco_testeAlterarValorLista-1");
		rotina.aguardarProcessarRotina();
		ArrayList<String> lista2 = acao.retornarValoresDeUmaLista("Lista2-1", 0);
		for (String valor : lista2) {
			assertTrue("".equals(valor) || "Será?".contains(valor) || "Quem Sabe".contains(valor));
		}
		ArrayList<String> lista1 = acao.retornarValoresDeUmaLista("Lista1-1", 0);
		for (String valor : lista1) {
			assertTrue("".equals(valor) || !"Será?".contains(valor) || !"Quem Sabe".contains(valor));
		}
		ArrayList<String> lista3 = acao.retornarValoresDeUmaLista("Lista3-1", 0);
		for (String valor : lista3) {
			assertTrue("".equals(valor) || "Não".contains(valor) || "Sim".contains(valor));
		}
	}

}

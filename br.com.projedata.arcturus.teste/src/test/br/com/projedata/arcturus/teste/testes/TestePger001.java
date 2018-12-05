package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.GeradorRelatoriosElementos.botaoAbrirCalendarioInicial;
import static br.com.projedata.arcturus.teste.webelements.GeradorRelatoriosElementos.campoDelimitadorCsv;
import static br.com.projedata.arcturus.teste.webelements.GeradorRelatoriosElementos.faixaPeriodoFinal;
import static br.com.projedata.arcturus.teste.webelements.GeradorRelatoriosElementos.faixaPeriodoInicial;
import static br.com.projedata.arcturus.teste.webelements.GeradorRelatoriosElementos.informarAnoCalendarioInicial;
import static br.com.projedata.arcturus.teste.webelements.GeradorRelatoriosElementos.paginaDeEdicaoDoRelatorio;
import static br.com.projedata.arcturus.teste.webelements.GeradorRelatoriosElementos.selecionarDataInicial;
import static br.com.projedata.arcturus.teste.webelements.GeradorRelatoriosElementos.tipoSaidaRelatorio;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.*;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.botaoAbrirMenu;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.menuApoio;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.menuPrincipal;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.menuRelatorioRger024;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.menuRelatoriosPersonlalizados;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.menuWorkflow;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.Store;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.PortalMetodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;
import br.com.projedata.teste.util.email.MailReader;

public class TestePger001 extends TesteGenerico {

	private String codigoRelatorioClone;
	private String codigoNovoRelatorio;
	private int i = 0;
	private int j = -1;
	private String paginaPortal;
	LoginMetodos login;
	PortalMetodos portal;

	@Parameters(value = { "login", "senha", "base" })
	@Test(testName = "id: 1 - Abrir rotina pger001")
	public void abrirPger001(String usuario, String senha, String base) {
		login = new LoginMetodos(this);
		login.logar(usuario, senha, base);
		espera.aguardarSistemaCarregar();
		rotina.selecionarRotina("ger001");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoConsultar);
		espera.aguardarElementoNaoEstarVazio(campoCodigoRelatorio, 0, "value");
		rotina.aguardarProcessarRotina();
		paginaPortal = navegador.retornarPaginaAtual();
	}

	@Test(testName = "id: 2 - Selecionar relatorio para edicao", dependsOnMethods = { "abrirPger001" })
	public void selecionarRelatorioEdicao() {
		selecionarRelatorioParaEdicao("rger4");
	}

	@Test(testName = "id: 3 - Bloquear relatorio para ser editado.", dependsOnMethods = { "selecionarRelatorioEdicao" })
	public void bloquearRelatorioParaEdicao() {
		if (acao.localizarElemento(botaoLiberarRelatorio).isDisplayed()) {
			acao.clicarNoElemento(botaoLiberarRelatorio);
			espera.aguardarElementoEstarVisivel(mensagemConfirmaLiberarRelatorio);
			acao.clicarNoElemento(botaoCancelarVersao);
			espera.aguardarElementoDesaparecer(mensagemConfirmaLiberarRelatorio);
			espera.aguardarElementoEstarVisivel(botaoBloquearHabilitado);
		}
		acao.clicarNoElemento(botaoBloquearHabilitado);
		msg.aguardarMensagem("Selecione o tipo de bloqueio");
		acao.clicarNoElemento(botaoBloquearTotal);
		espera.aguardarElementoDesaparecer(botaoBloquearTotal);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(botaoLiberarRelatorio);
	}

	@Test(testName = "id: 4 - Abrir relatorio no construtor de relatorios", dependsOnMethods = { "bloquearRelatorioParaEdicao" })
	public void abrirEditorDoRelatorio() {
		espera.aguardarElementoEstarVisivel(botaoEditarHabilitado);
		acao.clicarNoElemento(botaoEditarHabilitado);
		rotina.aguardarProcessarRotina();
		navegador.trocarDeAba();
		aguardaProcessarGeradorRelatorios();
		espera.aguardarElementoEstarVisivel(paginaDeEdicaoDoRelatorio);
		retornarPaginaPger001();
	}

	@Test(testName = "id: 5 - Abrir lista de relatorios pela barra de ferramentas", dependsOnMethods = { "abrirEditorDoRelatorio" })
	public void testarLovListaRelatorios() throws InterruptedException {
		rotina.aguardarProcessarRotina();
		rotina.limparCampoERealizarNovaConsulta();
		espera.aguardarElementoNaoEstarVazio(campoCodigoRelatorio, 0, "value");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.fecharMensagemNotificacao);
		acao.clicarNoElemento(rotina.botaoListar);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(rotina.lov);
		acao.escreverNoElemento(rotina.filtrarLov, "rger2%per");
		acao.clicarNoElemento(selecionarRelatorioNaLov);
		espera.aguardarElementoDesaparecer(rotina.lov);
		rotina.aguardarProcessarRotina();
		testar.passouSeAtributoDoElementoForIgualA(campoCodigoRelatorio, 0, "value", "rger2");
		testar.passouSeAtributoDoElementoForNulo(campoCodigoRelatorio, 1, "value");
	}

	@Test(testName = "id: 6 - Testar a clonagem do relatorio", dependsOnMethods = { "testarLovListaRelatorios" })
	public void clonarRelatorio() {
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemRegistrosAlterados);
		selecionarRelatorioParaEdicao("rger2");
		acao.clicarNoElemento(botaoClonarHabilitado);
		espera.aguardarElementoEstarVisivel(modalClonarRelatorio);
		String nomeClone = "Teste clonagem";
		acao.limparElemento(modalClonarRelatorioCampoNome);
		acao.escreverNoElemento(modalClonarRelatorioCampoNome, nomeClone);
		acao.limparElemento(modalClonarRelatorioCampoDescricao);
		acao.escreverNoElemento(modalClonarRelatorioCampoDescricao, "Descrição teste Clonagem");
		acao.clicarNoElemento(rotina, botaoConfirmarClonar);
		rotina.aguardarProcessarRotina();
		navegador.trocarDeAba();
		aguardaProcessarGeradorRelatorios();
		espera.aguardarElementoEstarVisivel(paginaDeEdicaoDoRelatorio);
		retornarPaginaPger001();
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		testar.passouSeAtributoDoElementoForIgualA(campoNomeRelatorio, 0, "value", nomeClone);
		codigoRelatorioClone = webDriver.findElements(campoCodigoRelatorio).get(0).getAttribute("value");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemRegistrosAlterados);
	}

	@Test(testName = "id: 7 - Dar permissao de execucao para outro usuario", dependsOnMethods = { "clonarRelatorio" })
	public void permissaoExecucao() {
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoSerClicavel(botaoLiberarRelatorio);
		acao.clicarNoElemento(botaoLiberarRelatorio);
		espera.aguardarElementoEstarVisivel(mensagemConfirmaLiberarRelatorio);
		acao.clicarNoElemento(botaoCancelarVersao);
		espera.aguardarElementoDesaparecer(mensagemConfirmaLiberarRelatorio);
		espera.aguardarElementoEstarVisivel(botaoBloquearHabilitado);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoAcessoUsuario, 0);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.F6);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(abrirLovCodigoAcessoUsuario, 1);
		espera.aguardarElementoEstarVisivel(lovUsuarios);
		acao.escreverNoElemento(rotina.filtrarLov, "TESTE ARCTURUS");
		acao.clicarNoElemento(rotina.selecionarValorLov("TESTE ARCTURUS"));
		espera.aguardarAtributoDoElementoConterOValor(campoDescricaoAcessoUsuario, 1, "value", "TESTE ARCTURUS");
		acao.selecionarNoElemento(campoPermissaoAcessoUsuario, 1, "Execução");
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}

	@Test(testName = "id: 8 - Verificar se a permissao de execucao esta funcionando corretamente", dependsOnMethods = {
			"permissaoExecucao" })
	public void testarPermissaoExecucaoConcedida() {
		rotina.aguardarProcessarRotina();
		sairPortal();
		login.logar("teste", "guth055", "desenvolvimento");
		rotina.selecionarRotina("ger001");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoConsultar);
		espera.aguardarElementoNaoEstarVazio(campoCodigoRelatorio, 0, "value");
		rotina.aguardarProcessarRotina();
		selecionarRelatorioParaEdicao(codigoRelatorioClone);
		testar.passouSeElementoEstiverHabilitado(botaoExecutarHabilitado);
		testar.passouSeElementoEstiverHabilitado(botaoNovoRelatorio);
		testar.passouSeElementoEstiverDesabilitado(botaoBloquearDesabilitado);
		testar.passouSeElementoEstiverDesabilitado(botaoClonarDesabilitado);
		testar.passouSeElementoEstiverDesabilitado(botaoEditarDesabilitado);
		testar.passouSeElementoEstiverDesabilitado(botaoExcluirDesabilitado);
	}

	@Test(testName = "id: 9 - Verificar se nao permite alterar permissoes do relatorio com permissao apenas de execucao", dependsOnMethods = {
			"testarPermissaoExecucaoConcedida" })
	public void tentarEditarRelatorioComPermissaoExecucaoConcedida() {
		rotina.aguardarProcessarRotina();
		testar.passouSeAtributoDoElementoForDiferenteDe(campoCodigoAcessoUsuario, 0, "readonly", "readonly");
	}

	@Test(testName = "id: 10 - Dar permissao total para outro usuario", dependsOnMethods = {
			"tentarEditarRelatorioComPermissaoExecucaoConcedida" })
	public void permissaoTotal() {
		sairPortal();
		login.logar("usuario", "usuario", "desenvolvimento");
		rotina.selecionarRotina("ger001");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoConsultar);
		espera.aguardarElementoNaoEstarVazio(campoCodigoRelatorio, 0, "value");
		selecionarRelatorioParaEdicao(codigoRelatorioClone);
		rotina.aguardarProcessarRotina();
		int contador = 0;
		while (!acao.buscarObjetoTipoSelect(campoPermissaoAcessoUsuario, contador).getFirstSelectedOption().getAttribute("value")
				.equals("E")) {
			contador++;
		}
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoAcessoUsuarioInformarPosicao, contador);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoPermissaoAcessoUsuario, contador, "Total");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		msg.fecharMensagemNotificacao();
	}

	@Test(testName = "id: 11 - Verificar permissao total concedida", dependsOnMethods = { "permissaoTotal" })
	public void testarPermissaoTotalConcedida() {
		sairPortal();
		login.logar("teste", "guth055", "desenvolvimento");
		rotina.selecionarRotina("ger001", "p");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoConsultar);
		espera.aguardarElementoNaoEstarVazio(campoCodigoRelatorio, 0, "value");
		selecionarRelatorioParaEdicao(codigoRelatorioClone);
		testar.passouSeElementoEstiverHabilitado(botaoBloquearHabilitado);
		testar.passouSeElementoEstiverHabilitado(botaoClonarHabilitado);
		testar.passouSeElementoEstiverHabilitado(botaoExecutarHabilitado);
		testar.passouSeElementoEstiverHabilitado(botaoNovoRelatorio);
		testar.passouSeElementoEstiverDesabilitado(botaoEditarDesabilitado);
		testar.passouSeElementoEstiverDesabilitado(botaoExcluirDesabilitado);
	}

	@Test(testName = "id: 12 - Testar a exclusao do relatorio", dependsOnMethods = { "testarPermissaoTotalConcedida" })
	public void excluirRelatorioClone() {
		excluirRelatorio(codigoRelatorioClone);
	}

	@Test(testName = "id: 13 - Testar a criacao de um novo relatorio", dependsOnMethods = { "excluirRelatorioClone" }, enabled = true)
	public void criarNovoRelatorio() {
		acao.clicarNoElemento(campoCodigoRelatorio, 0);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoNovoRelatorio);
		espera.aguardarElementoEstarVisivel(janelaCriarRotina);
		String nomeNovoRel = "Novo relatório teste Automação";
		acao.limparElemento(campoNomeRelatorioCriarNovo);
		acao.escreverNoElemento(campoNomeRelatorioCriarNovo, nomeNovoRel);
		acao.limparElemento(campoDescricaoRelatorioCriarNovo);
		acao.escreverNoElemento(campoDescricaoRelatorioCriarNovo, "Novo relatório teste Automação");
		acao.posicionarFocoNoElemento(rotina, botaoCriarNovoRelatorio);
		acao.clicarNoElemento(botaoCriarNovoRelatorio);
		rotina.aguardarProcessarRotina();
		navegador.trocarDeAba();
		aguardaProcessarGeradorRelatorios();
		retornarPaginaPger001();
		testar.passouSeAtributoDoElementoForIgualA(campoNomeRelatorio, 0, "value", nomeNovoRel);
		codigoNovoRelatorio = acao.localizarElementos(campoCodigoRelatorio).get(0).getAttribute("value");
	}

	@Test(testName = "id: 14 - Conceder permissao Execucao para grupo de usuarios", dependsOnMethods = {
			"criarNovoRelatorio" }, enabled = true)
	public void permissaoExecucaoParaGrupo() {
		msg.fecharMensagemNotificacao();
		espera.aguardarElementoDesaparecer(msg.mensagemNotificacao);
		acao.clicarNoElemento(botaoLiberarRelatorio);
		espera.aguardarElementoEstarVisivel(mensagemConfirmaLiberarRelatorio);
		acao.clicarNoElemento(botaoCancelarVersao);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer(botaoCancelarVersao);
		espera.aguardarElementoEstarVisivel(botaoBloquearHabilitado);
		acao.clicarNoElemento(rotina, "arcacessogruporotinaIdGrupo-1");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento("arcacessogruporotinaIdGrupo-1", "16");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoPermissaoAcessoGrupo, "Execução");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}

	@Test(testName = "id: 15 - Verificar acesso de permissao de execucao por grupo", dependsOnMethods = {
			"permissaoExecucaoParaGrupo" }, enabled = true)
	public void verificarAcessoPermissaoExecucaoParaGrupo() {
		sairPortal();
		login.logar("gustavo.projedata", "guth055", "desenvolvimento");
		rotina.selecionarRotina("ger001");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoConsultar);
		espera.aguardarElementoNaoEstarVazio(campoCodigoRelatorio, 0, "value");
		selecionarRelatorioParaEdicao(codigoNovoRelatorio);
		testar.passouSeElementoEstiverHabilitado(botaoNovoRelatorio);
		testar.passouSeElementoEstiverHabilitado(botaoExecutarHabilitado);
		testar.passouSeElementoEstiverDesabilitado(botaoExcluirDesabilitado);
		testar.passouSeElementoEstiverDesabilitado(botaoEditarDesabilitado);
		testar.passouSeElementoEstiverDesabilitado(botaoBloquearDesabilitado);
		testar.passouSeElementoEstiverDesabilitado(botaoClonarDesabilitado);
	}

	@Test(testName = "id: 16 - Conceder permissao total para o grupo", dependsOnMethods = {
			"verificarAcessoPermissaoExecucaoParaGrupo" }, enabled = true)
	public void permissaoTotalParaGrupo() {
		sairPortal();
		login.logar("usuario", "usuario", "desenvolvimento");
		rotina.selecionarRotina("ger001");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoConsultar);
		espera.aguardarElementoNaoEstarVazio(campoCodigoRelatorio, 0, "value");
		selecionarRelatorioParaEdicao(codigoNovoRelatorio);
		acao.clicarNoElemento(campoCodigoAcessoGrupo);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoPermissaoAcessoGrupo, "Total");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
	}

	@Test(testName = "id: 17 - Verificar permissao total concedida para o grupo", dependsOnMethods = {
			"permissaoTotalParaGrupo" }, enabled = true)
	public void verificarAcessoPermissaoTotalParaGrupo() {
		sairPortal();
		login.logar("gustavo.projedata", "guth055", "desenvolvimento");
		rotina.selecionarRotina("ger001");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoConsultar);
		espera.aguardarElementoNaoEstarVazio(campoCodigoRelatorio, 0, "value");
		selecionarRelatorioParaEdicao(codigoNovoRelatorio);
		testar.passouSeElementoEstiverHabilitado(botaoBloquearHabilitado);
		testar.passouSeElementoEstiverHabilitado(botaoClonarHabilitado);
		testar.passouSeElementoEstiverHabilitado(botaoNovoRelatorio);
		testar.passouSeElementoEstiverHabilitado(botaoExecutarHabilitado);
		testar.passouSeElementoEstiverDesabilitado(botaoExcluirDesabilitado);
		testar.passouSeElementoEstiverDesabilitado(botaoEditarDesabilitado);
	}

	@Test(testName = "id: 18 - Testar a exclusao do novo relatorio criado", dependsOnMethods = { "verificarAcessoPermissaoTotalParaGrupo" })
	public void excluirRelatorioNovo() {
		excluirRelatorio(codigoNovoRelatorio);
	}

	@Test(testName = "id: 19 - Verificar se nao permite editar/inserir registros no bloco que está como nao permite inclusao", dependsOnMethods = {
			"excluirRelatorioNovo" })
	public void verificarSeNaoPermiteEdicaoNoBlocoSemPermissaoDeAlteracao() {
		rotina.aguardarProcessarRotina();
		selecionarRelatorioParaEdicao("rger5");
		acao.clicarNoElemento(campoCodigoAcessoUsuarioInformarPosicao, 0);
		rotina.aguardarProcessarRotina();
		testar.passouSeAtributoDoElementoForDiferenteDe(campoCodigoAcessoUsuarioInformarPosicao, 0, "readonly", "readonly");
	}

	@Test(testName = "id: 20 - Verificar se apos limpar o bloco (ctrl q) nao permite alteracao", dependsOnMethods = {
			"verificarSeNaoPermiteEdicaoNoBlocoSemPermissaoDeAlteracao" })
	public void verificarSeNaoPermiteInclusaoNoBlocoAposCtrlQ() {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoAcessoUsuarioInformarPosicao, 0);
		teclado.pressionarConjuntoDeTeclas(Keys.CONTROL, "q");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElementoNaPosicao(campoCodigoAcessoUsuarioInformarPosicao, 0, "16");
		testar.passouSeAtributoDoElementoForNulo(campoCodigoAcessoUsuarioInformarPosicao, 0, "value");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 21 - Testar filtro periodo do relatorio", dependsOnMethods = { "verificarSeNaoPermiteInclusaoNoBlocoAposCtrlQ" })
	public void testarFiltroPeriodo() throws InvalidPasswordException, IOException {
		selecionarRelatorioParaEdicao("rger2");
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		acao.limparElemento(faixaPeriodoInicial);
		acao.escreverNoElemento(faixaPeriodoInicial, "02042013");
		acao.limparElemento(faixaPeriodoFinal);
		acao.escreverNoElemento(faixaPeriodoFinal, "02042013");
		acao.clicarNoElemento(rotina.botaoProcessarFiltros);
		espera.aguardarElementoDesaparecer(rotina.botaoProcessarFiltros);
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "147");
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "02/04/2013 - 02/04/2013");
		fecharJanelaEmissaoDoRelatorio();
	}

	@Test(testName = "id: 22 - Verificar se a navegacao com page down page up esta funcionando", dependsOnMethods = {
			"testarFiltroPeriodo" })
	public void testarNavegacaoComPageDownPageUpBlocoPrincipal() {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoRelatorio, 0);
		rotina.aguardarProcessarRotina();
		while (webDriver.findElements(barraRolagemRelatorioAnteriorDesabilitada).size() == 0) {
			teclado.pressionarTeclaDeControle(Keys.PAGE_UP);
			rotina.aguardarProcessarRotina();
		}
		selecionarRelatorioParaEdicao("rger2");
		rotina.aguardarProcessarRotina();
		while (webDriver.findElements(barraRolagemProximoRelatorioDesabilitada).size() == 0) {
			teclado.pressionarTeclaDeControle(Keys.PAGE_DOWN);
			rotina.aguardarProcessarRotina();
		}
		teclado.pressionarTeclaDeControle(Keys.PAGE_UP);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.PAGE_DOWN);
		rotina.aguardarProcessarRotina();
		Assert.assertTrue(rotina.posicaoRegistro().trim().equals(rotina.totalRegistros().trim()));
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
	}

	@Test(testName = "id: 23 - Verificar se a navegacao com page down page up esta funcionando", dependsOnMethods = {
			"testarNavegacaoComPageDownPageUpBlocoPrincipal" })
	public void testarNavegacaoComPageDownPageUpBlocoDetalhes() {
		teclado.pressionarTeclaDeControle(Keys.PAGE_UP);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoRelatorio, 0);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoNomeUsuarioGrupoAcesso);
		rotina.aguardarProcessarRotina();
		while (rotina.posicaoRegistro().trim() != rotina.totalRegistros().trim()) {
			i = Integer.parseInt(rotina.posicaoRegistro());
			if (i == j) {
				break;
			}
			teclado.pressionarTeclaDeControle(Keys.PAGE_DOWN);
			j = i;
		}
		if (rotina.posicaoRegistro().equals(rotina.totalRegistros())) {
			Assert.assertTrue(true);
		} else {
			while (Integer.parseInt(rotina.posicaoRegistro()) != 1) {
				teclado.pressionarTeclaDeControle(Keys.PAGE_UP);
			}
			while (Integer.parseInt(rotina.posicaoRegistro()) != Integer.parseInt(rotina.totalRegistros())) {
				teclado.pressionarTeclaDeControle(Keys.PAGE_DOWN);
			}
		}
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
	}

	@Test(testName = "id: 24 - Verificar foco ao teclar shift F6 num campo com valor invalido", dependsOnMethods = {
			"testarNavegacaoComPageDownPageUpBlocoPrincipal" })
	public void teclarShiftF6NumCampoComValorInvalido() {
		selecionarRelatorioParaEdicao("rger3");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, campoCodigoAcessoUsuarioInformarPosicao, 2);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElementoNaPosicao(campoCodigoAcessoUsuarioInformarPosicao, 2, "9999");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.fecharMensagemNotificacao);
		acao.clicarNoElemento(campoCodigoAcessoUsuarioInformarPosicao, 2);
		rotina.aguardarProcessarRotina();
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
		rotina.aguardarProcessarRotina();
		testar.passouSeElementoFocadoFor(campoCodigoAcessoUsuarioInformarPosicao, 1);
	}

	@Test(testName = "id: 25 - Verificar se setas de navegacao da barra de ferramentas estao desabilitando", dependsOnMethods = {
			"teclarShiftF6NumCampoComValorInvalido" })
	public void setasDeNavegacaoAnteriorDesabilitadas() {
		selecionarRelatorioParaEdicao("rger3");
		acao.clicarNoElemento(campoNomeUsuarioGrupoAcesso, 0);
		rotina.aguardarProcessarRotina();
		while (!rotina.posicaoRegistro().equals(rotina.totalRegistros())) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
		}
		espera.aguardarElementoEstarDesabilitado(acao.localizarElemento(rotina.botaoProximoRegistro));
		testar.passouSeAtributoDoElementoContem(rotina.botaoProximoRegistro, "class", "desabilitado");
		testar.passouSeAtributoDoElementoContem(rotina.botaoProximaPagina, "class", "desabilitado");
	}

	@Test(testName = "id: 26 - Verificar se setas de navegacao da barra de ferramentas estao desabilitando", dependsOnMethods = {
			"setasDeNavegacaoAnteriorDesabilitadas" })
	public void setasDeNavegacaoSeguinteDesabilitadas() {
		acao.clicarNoElemento(campoNomeUsuarioGrupoAcesso, 0);
		rotina.aguardarProcessarRotina();
		while (!rotina.posicaoRegistro().equals("1")) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_UP);
		}
		espera.aguardarElementoEstarDesabilitado(acao.localizarElemento(rotina.botaoRegistroAnterior));
		testar.passouSeAtributoDoElementoContem(rotina.botaoRegistroAnterior, "class", "desabilitado");
		testar.passouSeAtributoDoElementoContem(rotina.botaoPaginaAnterior, "class", "desabilitado");
	}

	@Test(testName = "id: 27 - Testar se esta sendo possivel selecionar uma data corretamente no componente calendario", dependsOnMethods = {
			"setasDeNavegacaoSeguinteDesabilitadas" })
	public void componenteCalendarioNoFiltroDoRelatorio() throws InvalidPasswordException, IOException {
		selecionarRelatorioParaEdicao("rger2");
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoAbrirCalendarioInicial);
		espera.aguardarElementoEstarVisivel(informarAnoCalendarioInicial);
		acao.clicarNoElemento(informarAnoCalendarioInicial);
		acao.escreverNoElemento(informarAnoCalendarioInicial, "2013");
		acao.clicarNoElemento(selecionarDataInicial);
		rotina.aguardarProcessarRotina();
		String data = acao.retornarValorDoElemento(faixaPeriodoInicial);
		acao.escreverNoElemento(faixaPeriodoFinal, data);
		espera.aguardarAtributoDoElementoConterOValor(faixaPeriodoFinal, "value", data);
		acao.clicarNoElemento(rotina.botaoProcessarFiltros);
		espera.aguardarElementoDesaparecer(rotina.botaoProcessarFiltros);
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), data + " - " + data);
		fecharJanelaEmissaoDoRelatorio();
	}

	@Test(testName = "id: 28 - Verificar se exibe tolltip no componente botao", dependsOnMethods = {
			"componenteCalendarioNoFiltroDoRelatorio" }, enabled = false)
	public void testarTolltipComponenteBotao() {
		portal = new PortalMetodos(this);
		rotina.aguardarProcessarRotina();
		selecionarRelatorioParaEdicao("rger001");
		mouse.moverCursorParaElemento(botaoExcluirGrupoAcesso);
		espera.aguardarElementoEstarVisivel(portal.dicaDeCampo("Excluir grupo de acesso."));
	}

	@Test(testName = "id: 29 - Abrir os filtros utilizando Shift+F2", dependsOnMethods = { "componenteCalendarioNoFiltroDoRelatorio" })
	public void abrirFiltroPeloShiftF2() {
		selecionarRelatorioParaEdicao("rger2");
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F2);
		espera.aguardarElementoDesaparecer(rotina.botaoProcessarFiltros);
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F2);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
	}

	@Test(testName = "id: 30 - Executar relatorio pelo F2", dependsOnMethods = { "abrirFiltroPeloShiftF2" })
	public void executarPeloF2() throws InvalidPasswordException, IOException {
		teclado.pressionarTeclaDeControle(Keys.F2);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer(rotina.botaoProcessarFiltros);
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "PROJEDATA");
		fecharJanelaEmissaoDoRelatorio();
	}

	@Test(testName = "id: 31 - Testar passagem de foco filtro periodo", dependsOnMethods = { "executarPeloF2" })
	public void passagemDeFocoFiltroPeriodo() {
		selecionarRelatorioParaEdicao("rger2");
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(filtroPeriodoInicial);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		testar.passouSeAtributoDoElementoFocadoFor("id", rotina.elementoAtualFocado());
		fecharJanelaEmissaoDoRelatorio();
	}

	@Test(testName = "id: 32 - Teclar F4 num bloco somente leitura", dependsOnMethods = { "passagemDeFocoFiltroPeriodo" })
	public void tentarIncluirRegistroPeloF4EmBlocoSomenteLeitura() {
		rotina.aguardarProcessarRotina();
		selecionarRelatorioParaEdicao("rger2");
		teclado.pressionarTeclaDeControle(Keys.F4);
		espera.aguardarElementoEstarVisivel(msg.mensagemOperacaoNaoPermitida);
		msg.fecharMensagemNotificacao();
		espera.aguardarElementoDesaparecer(msg.mensagemOperacaoNaoPermitida);
	}

	@Test(testName = "id: 33 - Teclar F6 num bloco somente leitura", dependsOnMethods = {
			"tentarIncluirRegistroPeloF4EmBlocoSomenteLeitura" })
	public void tentarIncluirRegistroPeloF6EmBlocoSomenteLeitura() {
		teclado.pressionarTeclaDeControle(Keys.F6);
		espera.aguardarElementoEstarVisivel(msg.mensagemOperacaoNaoPermitida);
		msg.fecharMensagemNotificacao();
		espera.aguardarElementoDesaparecer(msg.mensagemOperacaoNaoPermitida);
	}

	@Test(testName = "id: 34 - Clicar no relatorio em segundo plano e verificar se a rotina passara a ser focada", dependsOnMethods = {
			"tentarIncluirRegistroPeloF6EmBlocoSomenteLeitura" }, enabled = false)
	public void clicarNoPdfEmSegundoPlano() {
		selecionarRelatorioParaEdicao("rger2");
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoProcessarFiltros);
		espera.aguardarElementoDesaparecer(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		int width = acao.localizarElemento(pdfDoRelatorioGerado).getSize().getWidth();
		rotina.selecionarRotina("arc011", "p");
		Actions act = new Actions(webDriver);
		act.moveToElement(acao.localizarElemento(pdfDoRelatorioGerado)).moveByOffset((width / 2) - 1, 0).click().perform();
		rotina.aguardarProcessarRotina();
		testar.passouSeElementoEstiverVisivel(relatorioFocado);
	}

	@Test(testName = "id: 35 - Selecionar mais de um valor no filtro de campo multivalorado e verificar se ao abrir novamente se o valor sera mantido", dependsOnMethods = {
			"tentarIncluirRegistroPeloF4EmBlocoSomenteLeitura" })
	public void testeCampoMultiValorado() {
		sairPortal();
		login.logar("usuario", "usuario", "desenvolvimento");
		rotina.selecionarRotina("ger001", "p");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoConsultar);
		espera.aguardarElementoNaoEstarVazio(campoCodigoRelatorio, 0, "value");
		rotina.aguardarProcessarRotina();
		paginaPortal = navegador.retornarPaginaAtual();
		selecionarRelatorioParaEdicao("rger3");
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.fecharMensagemNotificacao);
		acao.posicionarFocoNoElemento(rotina, campoCorrentistaAtividade1);
		acao.clicarNoElemento(botaoLovCorrentistaAtividade1);
		espera.aguardarElementoEstarVisivel(rotina.lov);
		rotina.filtrarESelecionarValorNaLov("4727");
		espera.aguardarElementoDesaparecer(rotina.lov);
		acao.clicarNoElemento(botaoAdicionarCorrentistaAtividade1);
		espera.aguardarElementoEstarVisivel(botaoAdicionarCorrentistaAtividade2);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoLovCorrentistaAtividade2);
		espera.aguardarElementoEstarVisivel(rotina.lov);
		rotina.filtrarESelecionarValorNaLov("3113");
		espera.aguardarElementoDesaparecer(rotina.lov);
		acao.clicarNoElemento(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(msg.okNotificacao);
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarElementoDesaparecer(msg.okNotificacao);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(campoCorrentistaAtividade1);
		testar.passouSeAtributoDoElementoForIgualA(campoCorrentistaAtividade1, "value", "4727");
		testar.passouSeAtributoDoElementoForIgualA(campoCorrentistaAtividade2, "value", "3113");
	}

	@Test(testName = "id: 36 - Remover os valores dos campos multivalorado e verificar se mantera vazio", dependsOnMethods = {
			"testeCampoMultiValorado" })
	public void removerValoresCampoMultiValorado() {
		acao.clicarNoElemento(botaoRemoverCorrentistaAtividade2);
		espera.aguardarElementoDesaparecer(botaoRemoverCorrentistaAtividade2);
		acao.limparElemento(campoCorrentistaAtividade1);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		fecharJanelaEmissaoDoRelatorio();
		acao.clicarNoElemento(botaoExecutarHabilitado);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(campoCorrentistaAtividade1);
		testar.passouSeAtributoDoElementoForNulo(campoCorrentistaAtividade1, "value");
		acao.clicarNoElemento(fecharJanelaEmissaoRelatorio);
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 37 - Verificar se a passagem de foco na janela modal nao esta retornado para a janela principal", dependsOnMethods = {
			"removerValoresCampoMultiValorado" })
	public void testarPassagemDeFocoJanelaModal() {
		selecionarRelatorioParaEdicao("rger2");
		acao.clicarNoElemento(botaoClonarHabilitado);
		espera.aguardarElementoEstarVisivel(modalClonarRelatorio);
		acao.posicionarFocoNoElemento(rotina, modalClonarRelatorioCampoNome);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		testar.passouSeAtributoDoElementoFocadoFor("id", "botaoClonarRelatorio-1-0");
		acao.clicarNoElemento(botaoFecharModalClonar);
		espera.aguardarElementoDesaparecer(modalClonarRelatorio);
	}

	@Test(testName = "id: 38 - Verificar delimitador CSV", dependsOnMethods = { "testarPassagemDeFocoJanelaModal" })
	public void verificarDelimitadorCsv() {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(tipoSaidaRelatorio);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);

		Select tipoSaida = new Select(webDriver.findElement(tipoSaidaRelatorio));
		while (!tipoSaida.getFirstSelectedOption().getText().equals("CSV")) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			rotina.aguardarProcessarRotina();
		}
		espera.aguardarElementoEstarVisivel(campoDelimitadorCsv);
		acao.selecionarNoElemento(tipoSaidaRelatorio, "PDF");
		espera.aguardarElementoDesaparecer(campoDelimitadorCsv);
	}

	@Test(testName = "id: 39 - Bloquear um relatorio parcialmente e verificar se permite emitir.", dependsOnMethods = {
			"verificarDelimitadorCsv" })
	public void testarBloqueioParcialRelatorio() {
		rotina.aguardarProcessarRotina();
		fecharJanelaEmissaoDoRelatorio();
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemNotificacao);
		selecionarRelatorioParaEdicao("rger2");
		try {
			acao.clicarNoElemento(botaoBloquearHabilitado);
		} catch (ElementNotVisibleException e) {
			acao.clicarNoElemento(botaoLiberarRelatorio);
			rotina.aguardarProcessarRotina();
			acao.clicarNoElemento(botaoBloquearHabilitado);
		}
		msg.aguardarMensagem("Selecione o tipo de bloqueio");
		acao.clicarNoElemento(botaoBloquearParcial);
		espera.aguardarElementoDesaparecer(botaoBloquearParcial);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(botaoLiberarRelatorio);
		rotina.aguardarProcessarRotina();
		sairPortal();
		login.logar("gustavo.projedata", "guth055", "desenvolvimento");
		try {
			rotina.selecionarRotina("ger001", "p");
		} catch (Exception e) {
			navegador.atualizarBrowser();
			rotina.selecionarRotina("ger001", "p");
		}
		selecionarRelatorioParaEdicao("rger2");
		testar.passouSeAtributoDoElementoContem(campoExibeTipoBloqueio, "value", "Bloqueio Parcial");
		testar.passouSeElementoEstiverVisivel(botaoBloquearDesabilitado);
		testar.passouSeElementoEstiverVisivel(botaoEditarDesabilitado);
		testar.passouSeElementoEstiverVisivel(botaoClonarDesabilitado);
		testar.passouSeElementoEstiverVisivel(botaoExcluirDesabilitado);
		testar.passouSeElementoEstiverVisivel(botaoNovoRelatorio);
		testar.passouSeElementoEstiverVisivel(botaoExecutarHabilitado);
		acao.clicarNoElemento(rotina, botaoExecutarHabilitado);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		fecharJanelaEmissaoDoRelatorio();
	}

	@Test(testName = "id: 40 - Bloquear um relatorio total e verificar se permite emitir.", dependsOnMethods = {
			"testarBloqueioParcialRelatorio" })
	public void testarBloqueioTotalRelatorio() {
		sairPortal();
		login.logar("usuario", "usuario", "desenvolvimento");
		rotina.selecionarRotina("ger001", "p");
		selecionarRelatorioParaEdicao("rger2");
		desbloquearRelatorio();
		acao.clicarNoElemento(botaoBloquearHabilitado);
		msg.aguardarMensagem("Selecione o tipo de bloqueio");
		acao.clicarNoElemento(botaoBloquearTotal);
		espera.aguardarElementoDesaparecer(botaoBloquearTotal);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(botaoLiberarRelatorio);
		rotina.aguardarProcessarRotina();
		selecionarRelatorioParaEdicao("rger2");
		testar.passouSeAtributoDoElementoContem(campoExibeTipoBloqueio, "value", "Bloqueio Total");
		sairPortal();
		login.logar("gustavo.projedata", "guth055", "desenvolvimento");
		rotina.selecionarRotina("ger001", "p");
		selecionarRelatorioParaEdicao("rger2");
		testar.passouSeElementoEstiverVisivel(botaoBloquearDesabilitado);
		testar.passouSeElementoEstiverVisivel(botaoEditarDesabilitado);
		testar.passouSeElementoEstiverVisivel(botaoClonarDesabilitado);
		testar.passouSeElementoEstiverVisivel(botaoExcluirDesabilitado);
		testar.passouSeElementoEstiverVisivel(botaoNovoRelatorio);
		testar.passouSeElementoEstiverVisivel(botaoExecutarDesabilitado);
		sairPortal();
		login.logar("usuario", "usuario", "desenvolvimento");
		rotina.selecionarRotina("ger001", "p");
		selecionarRelatorioParaEdicao("rger2");
	}

	@Test(testName = "id: 41 - Verificar se usuario com acesso total nao conseguira emitir relatorio bloqueado.", dependsOnMethods = {
			"testarBloqueioParcialRelatorio" })
	public void testarBloqueioTotalRelatorioParaUsuarioComAcessoTotal() {
		acao.clicarNoElemento(rotina, campoCodigoAcessoUsuario, 1);
		acao.selecionarNoElemento(campoPermissaoAcessoUsuario, 1, "Total");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		sairPortal();
		login.logar("gustavo.projedata", "guth055", "desenvolvimento");
		rotina.selecionarRotina("ger001", "p");
		selecionarRelatorioParaEdicao("rger2");
		testar.passouSeElementoEstiverVisivel(botaoBloquearDesabilitado);
		testar.passouSeElementoEstiverVisivel(botaoEditarDesabilitado);
		testar.passouSeElementoEstiverVisivel(botaoClonarDesabilitado);
		testar.passouSeElementoEstiverVisivel(botaoExcluirDesabilitado);
		testar.passouSeElementoEstiverVisivel(botaoNovoRelatorio);
		testar.passouSeElementoEstiverVisivel(botaoExecutarDesabilitado);
		sairPortal();
		login.logar("usuario", "usuario", "desenvolvimento");
		rotina.selecionarRotina("ger001", "p");
		selecionarRelatorioParaEdicao("rger2");
		acao.clicarNoElemento(rotina, campoCodigoAcessoUsuario, 1);
		acao.selecionarNoElemento(campoPermissaoAcessoUsuario, 1, "Execução");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		desbloquearRelatorio();
	}

	@Test(testName = "id: 42 - Testar componente imagem do relatorio.", dependsOnMethods = {
			"testarBloqueioTotalRelatorioParaUsuarioComAcessoTotal" })
	public void testarComponenteImagemDoRelatorio() throws InvalidPasswordException, IOException {
		selecionarRelatorioParaEdicao("rger10");
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoProcessarFiltros);
		ArrayList<Integer> relatorios = new ArrayList<>();
		relatorios = rotina.verificarSeConteudoDoPdfPossuiImagens();
		for (int i = 0; i <= relatorios.size(); i++) {
			int tamanhoRelatorio = relatorios.get(i);
			if (tamanhoRelatorio == 252717) {
				testar.testePassou();
				break;
			} else {
				testar.testeFalhou();
			}
		}
	}

	@Test(testName = "id: 43 - Testar filtro obrigatorio do relatorio.", dependsOnMethods = { "testarComponenteImagemDoRelatorio" })
	public void testarFiltroObrigatorioDoRelatorio() throws InvalidPasswordException, IOException {
		fecharJanelaEmissaoDoRelatorio();
		selecionarRelatorioParaEdicao("rger20");
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoProcessarFiltros);
		msg.aguardarMensagem("Informe um valor para o item codigoAtividade");
		acao.clicarNoElemento(fecharJanelaEmissaoRelatorio);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer(fecharJanelaEmissaoRelatorio);
	}

	@Test(testName = "id: 44 - Emitir o relatorio e verificar se o codigo de barras sera exibido corretamente", dependsOnMethods = {
			"testarFiltroObrigatorioDoRelatorio" })
	public void testarPropriedadeCodigoBarras()
			throws NotFoundException, ChecksumException, FormatException, InvalidPasswordException, IOException {
		selecionarRelatorioParaEdicao("rger21");
		acao.clicarNoElemento("botaoExecutar-1");
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		espera.aguardarElementoEstarVisivel("numero_os-1");
		acao.limparElemento("numero_os-1");
		acao.escreverNoElemento("numero_os-1", "1147");
		acao.clicarNoElemento(rotina, rotina.botaoProcessarFiltros);
		espera.aguardarElementoDesaparecer(rotina.botaoProcessarFiltros);
		espera.aguardarPdfSerGerado();
		for (String codigoBarras : rotina.retornarCodigoBarras()) {
			testar.passouSeValorContem("51465589570001, 1147", codigoBarras);
		}
		fecharJanelaEmissaoDoRelatorio();
	}

	@Test(testName = "id: 45 - Quando tenho 2 filtros, que estão vinculado ao mesmo cadastro, atribuir valores ao registros filhos de um, sem informar valores nos 2", dependsOnMethods = {
			"testarPropriedadeCodigoBarras" })
	public void testarSelecaoFiltroPai()
			throws NotFoundException, ChecksumException, FormatException, InvalidPasswordException, IOException {
		selecionarRelatorioParaEdicao("rger22");
		acao.clicarNoElemento("botaoExecutar-1");
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		String filtro1Pai = "usuario-1-0";
		String filtro1Filho = "correntista 2-1";
		String filtro2Pai = "id_usuario-1-0";
		String filtro2Filho = "correntista-1";

		acao.escreverNoElemento(filtro1Pai, "1");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.abrirLov(rotina, filtro1Filho);
		teclado.pressionarTeclaDeControle(Keys.ENTER);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(filtro2Pai, "1");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.abrirLov(rotina, filtro2Filho);
		teclado.pressionarTeclaDeControle(Keys.ENTER);
		rotina.aguardarProcessarRotina();

		acao.limparElemento(filtro2Pai);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();

		espera.aguardarElementoEstarVazio(filtro2Filho);
		espera.aguardarElementoNaoEstarVazio(filtro1Filho, 0, "value");

		acao.abrirLov(rotina, filtro2Filho);
		teclado.pressionarTeclaDeControle(Keys.ENTER);
		rotina.aguardarProcessarRotina();
		acao.limparElemento(filtro1Pai);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVazio(filtro1Filho);

		acao.limparElemento(filtro2Filho);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();

		fecharJanelaEmissaoDoRelatorio();
	}

	@Test(testName = "id: 46 - Verificar se filtro obrigatorio é exibido corretamente", dependsOnMethods = { "testarSelecaoFiltroPai" })
	public void verificarSeFiltroObrigatorioEhExibido() {
		selecionarRelatorioParaEdicao("rger23");
		acao.clicarNoElemento("botaoExecutar-1");
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		testar.passouSeElementoEstiverVisivel(filtroObrigatorio);
		fecharJanelaEmissaoDoRelatorio();
	}

	@Test(testName = "id: 47 - Salvar os filtros do relatório e verificar se na próxima emissão serão exibidos os filtros salvos", dependsOnMethods = {
			"verificarSeFiltroObrigatorioEhExibido" })
	public void salvarFiltrosDoRelatorio() throws InvalidPasswordException, IOException {
		selecionarRelatorioParaEdicao("rger24");
		acao.clicarNoElemento("botaoExecutar-1");
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		acao.clicarNoElemento(rotina, "periodo-1-0");
		rotina.aguardarProcessarRotina();
		acao.limparElemento("periodo-1-0");
		acao.escreverNoElemento("periodo-1-0", "01042013");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "periodo-1-1");
		acao.limparElemento("periodo-1-1");
		acao.escreverNoElemento("periodo-1-1", "01052013");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElementoPeloValor("exibir_cabecalho-1", "N");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "b_salvar-1");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemRegistrosAlterados);
		acao.clicarNoElemento(rotina, rotina.botaoProcessarFiltros);
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "01/04/2013 - 01/05/2013");
		testar.passouSeValorNaoContem(rotina.retornarConteudoDoPdf(), "PROJEDATA INFORMÁTICA LTDA");

		fecharJanelaEmissaoDoRelatorio();

		selecionarRelatorioParaEdicao("rger24");
		acao.clicarNoElemento("botaoExecutar-1");
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		testar.passouSeValorDoElementoSelecionadoFor("exibir_cabecalho-1", "Não");
		testar.passouSeAtributoDoElementoContem("periodo-1-0", "value", "01/04/2013");
		testar.passouSeAtributoDoElementoContem("periodo-1-1", "value", "01/05/2013");

		fecharJanelaEmissaoDoRelatorio();
	}

	@Test(testName = "id: 48 - Limpar filtros e salvar", dependsOnMethods = { "salvarFiltrosDoRelatorio" })
	public void salvarFiltrosDoRelatorioEmBranco() throws InvalidPasswordException, IOException {
		selecionarRelatorioParaEdicao("rger24");
		acao.clicarNoElemento("botaoExecutar-1");
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		acao.clicarNoElemento(rotina, "periodo-1-0");
		rotina.aguardarProcessarRotina();
		acao.limparElemento(rotina, "periodo-1-0");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "periodo-1-1");
		rotina.aguardarProcessarRotina();
		acao.limparElemento(rotina, "periodo-1-1");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElementoPeloValor("exibir_cabecalho-1", "S");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "b_salvar-1");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemRegistrosAlterados);
		acao.clicarNoElemento(rotina.botaoProcessarFiltros);
		testar.passouSeValorNaoContem(rotina.retornarConteudoDoPdf(), "01/04/2013 - 01/05/2013");
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "PROJEDATA INFORMÁTICA LTDA");

		fecharJanelaEmissaoDoRelatorio();
	}

	@Test(testName = "id: 49 - Vincular um sistema ao relatório e verificar se aparecerá no menu", dependsOnMethods = {
			"salvarFiltrosDoRelatorioEmBranco" })
	public void vincularSistemaAoRelatorio() throws InvalidPasswordException, IOException {
		selecionarRelatorioParaEdicao("rger24");
		acao.limparElemento("idSistemaVinculado-1");
		acao.escreverNoElemento("idSistemaVinculado-1", "2");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		rotina.fecharRotina("ger001");
		acao.clicarNoElemento(botaoAbrirMenu);
		espera.aguardarElementoEstarVisivel(menuPrincipal);
		espera.aguardarElementoEstarVisivel(menuApoio);
		acao.clicarNoElemento(menuApoio);
		espera.aguardarElementoEstarVisivel(menuWorkflow);
		acao.clicarNoElemento(menuWorkflow);
		espera.aguardarElementoEstarVisivel(menuRelatoriosPersonlalizados);
		acao.clicarNoElemento(menuRelatoriosPersonlalizados);
		espera.aguardarElementoEstarVisivel(menuRelatorioRger024);
		acao.clicarNoElemento(menuRelatorioRger024);
		espera.aguardarRotinaAberta("ger24");
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		espera.aguardarElementoEstarVisivel(fecharJanelaEmissaoRelatorio);
		rotina.aguardarProcessarRotina();
		fecharJanelaEmissaoDoRelatorio();
	}

	@Test(testName = "id: 50 - Testar exibição imagem fundo do relatório.", dependsOnMethods = { "vincularSistemaAoRelatorio" })
	public void verificarSeImagemFundoEhExibiba() throws InvalidPasswordException, IOException {
		rotina.selecionarRotina("ger001");
		rotina.aguardarProcessarRotina();
		selecionarRelatorioParaEdicao("rger25");
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "periodo-1-0");
		rotina.aguardarProcessarRotina();
		acao.limparElemento("periodo-1-0");
		acao.escreverNoElemento("periodo-1-0", "01042013");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.limparElemento("periodo-1-1");
		acao.escreverNoElemento("periodo-1-1", "01052013");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoProcessarFiltros);
		ArrayList<Integer> relatorios = new ArrayList<>();
		relatorios = rotina.verificarSeConteudoDoPdfPossuiImagens();
		boolean possuiImagemFundo = false;
		for (int i = 0; i <= relatorios.size(); i++) {
			int tamanhoRelatorio = relatorios.get(i);
			if (tamanhoRelatorio == 1173849) {
				testar.testePassou();
				possuiImagemFundo = true;
				break;
			}
		}
		if (!possuiImagemFundo) {
			testar.testeFalhou();
		}
		fecharJanelaEmissaoDoRelatorio();
	}

	@Test(testName = "id: 51 - Testar ocultar filtro", dependsOnMethods = { "verificarSeImagemFundoEhExibiba" })
	public void ocultarFiltro() throws InvalidPasswordException, IOException {
		selecionarRelatorioParaEdicao("rger26");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		testar.passouSeElementoNaoExistir(filtroOculto);
		testar.passouSeElementoNaoExistir(filtroOculto2);
		testar.passouSeElementoNaoExistir(filtroPeriodoInicial);
		testar.passouSeElementoNaoExistir(filtroPeriodoFinal);
		testar.passouSeElementoEstiverVisivel(filtroNaoOculto);
		testar.passouSeElementoEstiverVisivel(filtroNaoOculto2);
		fecharJanelaEmissaoDoRelatorio();
	}

	@Test(testName = "id: 52 - Criar um relatório clonando um fixo do sistema", dependsOnMethods = { "ocultarFiltro" })
	public void clonarRelatorioApartirDeUmFixo() throws InvalidPasswordException, IOException {
		acao.clicarNoElemento(campoCodigoRelatorio, 0);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoNovoRelatorio);
		espera.aguardarElementoEstarVisivel(janelaCriarRotina);
		String nomeNovoRel = "Novo relatório teste Automação";
		acao.limparElemento(campoNomeRelatorioCriarNovo);
		acao.escreverNoElemento(campoNomeRelatorioCriarNovo, nomeNovoRel);
		acao.limparElemento(campoDescricaoRelatorioCriarNovo);
		acao.escreverNoElemento(campoDescricaoRelatorioCriarNovo, "Novo relatório teste Automação");
		acao.clicarNoElemento("parametrosIdRotina-1-0-aux");
		rotina.aguardarLovProcessar();
		rotina.filtrarESelecionarValorNaLov("rwkf001");
		espera.aguardarAtributoDoElementoConterOValor("parametrosDsRotina-1", "value", "Espelho da Ordem de Serviço");
		acao.clicarNoElemento(rotina, botaoCriarNovoRelatorio);
		rotina.aguardarProcessarRotina();
		navegador.trocarDeAba();
		aguardaProcessarGeradorRelatorios();
		retornarPaginaPger001();
		testar.passouSeAtributoDoElementoForIgualA(campoNomeRelatorio, 0, "value", nomeNovoRel);
		codigoNovoRelatorio = acao.localizarElementos(campoCodigoRelatorio).get(0).getAttribute("value");
		acao.clicarNoElemento(rotina, botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		acao.clicarNoElemento(rotina, rotina.botaoProcessarFiltros);
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), nomeNovoRel.toUpperCase());
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), codigoNovoRelatorio.toUpperCase());
		fecharJanelaEmissaoDoRelatorio();
	}

	@Test(testName = "id: 53 - Testar o método salvarFiltros()", dependsOnMethods = { "clonarRelatorioApartirDeUmFixo" })
	public void testarMetodoSalvarFiltros() throws InvalidPasswordException, IOException {
		selecionarRelatorioParaEdicao("rger28");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		acao.limparElemento("numero_os-1");
		acao.escreverNoElemento("numero_os-1", "1147");
		acao.clicarNoElemento(rotina, rotina.botaoProcessarFiltros);
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "TESTE MÉTODO SALVAR FILTROS");
		fecharJanelaEmissaoDoRelatorio();
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		testar.passouSeValorContem(acao.retornarValorDoElemento("numero_os-1"), "1147");
		acao.limparElemento("numero_os-1");
		acao.clicarNoElemento("correntista-1");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento("correntista-1");
		rotina.aguardarProcessarRotina();
		acao.limparElemento("correntista-1");
		acao.escreverNoElemento("correntista-1", "8715");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoProcessarFiltros);
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "TESTE MÉTODO SALVAR FILTROS");
		fecharJanelaEmissaoDoRelatorio();
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		testar.passouSeValorContem(acao.retornarValorDoElemento("correntista-1"), "8715");
		testar.passouSeAtributoDoElementoForNulo("numero_os-1", "value");
		fecharJanelaEmissaoDoRelatorio();
	}

	@Test(testName = "id: 54 - Adicionar e remover campos multivalorados dos filtros e verificar se os valores mantidos estão corretos.", dependsOnMethods = {
			"testarMetodoSalvarFiltros" })
	public void testarFiltroMultivaloradoTipoComboBox() throws InvalidPasswordException, IOException {
		selecionarRelatorioParaEdicao("rger30");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		rotina.adicionarCampoMultiValorado("sentidoListaOs-1-0-aux");
		rotina.adicionarCampoMultiValorado("sentidoListaOs-1-1-aux");
		acao.selecionarNoElemento("sentidoListaOs-1-0", "Crescente");
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento("sentidoListaOs-1-2", "Decrescente");
		rotina.removerCampoMultiValorado("sentidoListaOs-1-0-aux");
		espera.aguardarElementoDesaparecer("sentidoListaOs-1-2-aux");
		rotina.removerCampoMultiValorado("sentidoListaOs-1-1-aux");
		espera.aguardarElementoDesaparecer("sentidoListaOs-1-1-aux");
		testar.passouSeElementoSelecionadoForNulo("sentidoListaOs-1-0");

		rotina.adicionarCampoMultiValorado("sentidoListaOs-1-0-aux");
		rotina.adicionarCampoMultiValorado("sentidoListaOs-1-1-aux");
		acao.selecionarNoElemento("sentidoListaOs-1-0", "Crescente");
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento("sentidoListaOs-1-2", "Decrescente");
		rotina.removerCampoMultiValorado("sentidoListaOs-1-1-aux");
		espera.aguardarElementoDesaparecer("sentidoListaOs-1-2-aux");
		rotina.removerCampoMultiValorado("sentidoListaOs-1-1-aux");
		espera.aguardarElementoDesaparecer("sentidoListaOs-1-1-aux");
		testar.passouSeValorDoElementoSelecionadoFor("sentidoListaOs-1-0", "Crescente");

		fecharJanelaEmissaoDoRelatorio();
	}

	@Test(testName = "id: 55 - Testar envio de email do relatório", dependsOnMethods = { "testarFiltroMultivaloradoTipoComboBox" })
	public void testarEnvioDeEmailDoRelatorio() throws InvalidPasswordException, IOException, InterruptedException {
		selecionarRelatorioParaEdicao("rger10");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, rotina.botaoProcessarFiltros);
		By botaoEmail = By.xpath("//i[contains(@title,'e-mail')]");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(botaoEmail);
		acao.clicarNoElemento(botaoEmail);
		espera.aguardarElementoEstarVisivel(rotina.retornarRotinaCarregada("Envio de relatório"));
		acao.limparElemento("configResponderPara-1");
		acao.clicarNoElemento(rotina, "configDestinatarios-1");
		acao.escreverNoElemento("configDestinatarios-1", "gustavo@projedata.com.br");
		acao.clicarNoElemento(rotina, "configConteudo-1");
		acao.escreverNoElemento("configConteudo-1", "teste automação");
		acao.clicarNoElemento(rotina, "configBtEnviar-1");
		msg.aguardarMensagem("E-mail enviado com sucesso");
		acao.clicarNoElemento(msg.okNotificacao);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer(msg.okNotificacao);
		rotina.aguardarProcessarRotina();

		MailReader mailReader = new MailReader("imap", "webmail.projedata.com.br", 143, false);
		Store store = mailReader.connect("gustavo@projedata.com.br", "kamila");
		Thread.sleep(2000);

		boolean relatorioNoEmail = mailReader.verificarRelatorioEnviadoPorEmail(store, null);
		Assert.assertTrue(relatorioNoEmail);
		fecharJanelaEmissaoDoRelatorio();
	}

	public void fecharJanelaEmissaoDoRelatorio() {
		acao.clicarNoElemento(fecharJanelaEmissaoRelatorio);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer(fecharJanelaEmissaoRelatorio);
	}

	public void retornarPaginaPger001() {
		webDriver.close();
		webDriver.switchTo().window(paginaPortal);
		espera.aguardarElementoEstarVisivel(menuConfiguracoes);
	}

	public void selecionarRelatorioParaEdicao(String relatorio) {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoRelatorio, 0);
		rotina.aguardarProcessarRotina();
		rotina.limparCampoERealizarNovaConsulta();
		int posicao = 0;
		while (!acao.localizarElementos(campoCodigoRelatorio).get(posicao).getAttribute("value").equals(relatorio)) {
			if (acao.localizarElementos(barraRolagemProximoRelatorioDesabilitada).size() == 0) {
				acao.clicarNoElemento(barraRolagemProximoRelatorio);
				rotina.aguardarProcessarRotina();
				posicao = -1;
			}
			posicao++;
		}
		acao.clicarNoElemento(campoCodigoRelatorio, posicao);
		rotina.aguardarProcessarRotina();
	}

	public void excluirRelatorio(String relatorio) {
		login = new LoginMetodos(this);
		sairPortal();
		login.logar("usuario", "usuario", "desenvolvimento");
		rotina.selecionarRotina("ger001");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoConsultar);
		espera.aguardarElementoNaoEstarVazio(campoCodigoRelatorio, 0, "value");
		selecionarRelatorioParaEdicao(relatorio);
		acao.clicarNoElemento(botaoBloquearHabilitado);
		msg.aguardarMensagem("Selecione o tipo de bloqueio");
		acao.clicarNoElemento(botaoBloquearTotal);
		espera.aguardarElementoDesaparecer(botaoBloquearTotal);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(botaoLiberarRelatorio);
		espera.aguardarElementoEstarVisivel(botaoExcluirHabilitado);
		acao.clicarNoElemento(botaoExcluirHabilitado);
		espera.aguardarElementoEstarVisivel(mensagemExcluirRotina);
		acao.clicarNoElemento(botaoExcluirRotina);
		espera.aguardarElementoDesaparecer(mensagemExcluirRotina);
		espera.aguardarElementoEstarVisivel(mensagemRotinaExcluidaComSucesso);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(mensagemRotinaExcluidaComSucesso);
	}

	public void aguardaProcessarGeradorRelatorios() {

		try {
			if (webDriver.findElements(estaProcessando).size() != 0) {
				WebDriverWait wait = new WebDriverWait(webDriver, 10);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(estaProcessando));
			}
		} catch (TimeoutException e) {
			navegador.atualizarBrowser();
			aguardaProcessarGeradorRelatorios();
		}
	}

	public void desbloquearRelatorio() {
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer(msg.mensagemRegistrosAlterados);
		acao.clicarNoElemento(rotina, botaoLiberarRelatorio);
		rotina.aguardarProcessarRotina();
		if (acao.localizarElementos(mensagemConfirmaLiberarRelatorio).size() > 0) {
			espera.aguardarElementoEstarVisivel(mensagemConfirmaLiberarRelatorio);
			acao.clicarNoElemento(botaoCancelarVersao);
			rotina.aguardarProcessarRotina();
			espera.aguardarElementoDesaparecer(mensagemConfirmaLiberarRelatorio);
			espera.aguardarElementoEstarVisivel(botaoBloquearHabilitado);
		}
	}

}

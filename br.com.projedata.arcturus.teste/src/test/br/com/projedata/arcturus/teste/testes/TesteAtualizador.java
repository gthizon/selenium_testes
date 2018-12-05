package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.*;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.abrirGrupoObjetos;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.botaoCriarPrimeiraVersaoObjeto;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.botaoHistoricoVersoesObjetoNegocio;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.buscarObjetoNegocio;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.detalhesObjetoNegocio;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.listaDeObjetosExibidas;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.mensagemConfirmaCriacaoRascunhoObjeto;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.mensagemCriarVersao;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.mensagemRascunhoCriadoObjeto;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.menuObjetosNegocio;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.naoNotificacao;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.nomeObjeto;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.telaCriarNovaVersao;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.telaObjetoNegocio;
import static br.com.projedata.arcturus.teste.webelements.Parc102Elementos.campoCodigoAtualizacaoFilaAplicacao;
import static br.com.projedata.arcturus.teste.webelements.Parc102Elementos.campoCodigoClienteFilaAplicacao;
import static br.com.projedata.arcturus.teste.webelements.Parc102Elementos.campoDataPrevista;
import static br.com.projedata.arcturus.teste.webelements.Pwkf008Elementos.botaoNovoRepasse;
import static br.com.projedata.arcturus.teste.webelements.Pwkf008Elementos.campoNumeroOS;
import static br.com.projedata.arcturus.teste.webelements.Pwkf008Elementos.detalhesRepasseAnterior;
import static br.com.projedata.arcturus.teste.webelements.Pwkf008Elementos.detalhesRepasseAtual;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.botaoConfirmarCriarNovaVersaoRotina;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.botaoCriarNovaVersao;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.botaoCriarPrimeiraVersao;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.botaoHistoricoVersoes;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.campoBuscaRotina;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.descricaoDaVersao;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.detalhesRotina;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.janelaCriarNovaVersaoRotina;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.mensagemConfirmaCriacaoRascunho;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.mensagemDescricaoVersaoInvalida;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.mensagemRascunhoCriado;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.menuRotinas;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.selecionarRotina;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.simNotificacao;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.telaHistoricoVersoes;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.telaRotinas;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.AtualizadorMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class TesteAtualizador extends TesteGenerico {

	public static String numeroAtualizacao;
	public static String numeroAtualizacaoDependente;
	private String versaoAtualizacaoLancada;
	private static String idDependente;
	private static String mensagemAtualizacaoComOsVinculada;
	String anexo1Linux = "Anexo1.txt";
	String anexo2Linux = "processo_testes'@#$~^áà.png";
	String anexo1Windows = "\\\\arquivos.prj\\qualidade\\Plano de Testes\\Plano_de_Testes.pdf";
	String anexo2Windows = "\\\\arquivos.prj\\qualidade\\Diversos\\processo_testes'@#$~^áà.png";
	String urlAdmin;

	String elementoFocado;
	LoginMetodos login;
	AtualizadorMetodos atualiza;

	@Parameters(value = { "login", "senha", "base" })
	@Test(testName = "id: 33 - Verificar se esta sendo possivel limpar o valor da combobox selecionando valor em branco")
	public void login(String usuario, String senha, String base) {
		login = new LoginMetodos(this);
		login.logar(usuario, senha, base);
		atualiza = new AtualizadorMetodos(this);
	}

	@Test(testName = "Acessar Atualizador", dependsOnMethods = { "login" })
	public void acessarAtualizador() {
		acao.clicarNoElemento(menuConfiguracoes);
		espera.aguardarElementoEstarVisivel(botaoAcessarAtualizador);
		espera.aguardarElementoEstarVisivel(menuConfiguracoesAberto);
		acao.clicarNoElemento(botaoAcessarAtualizador);
		navegador.trocarDeAba();
		espera.aguardarElementoEstarVisivel(atalhoFerramentas);
	}

	@Test(testName = "Criar racunho de uma rotina.", dependsOnMethods = { "acessarAtualizador" })
	public void criarRascunhoRotina() throws InterruptedException {

		espera.aguardarElementoEstarVisivel(menuRotinas);
		espera.aguardarElementoSerClicavel(menuRotinas);
		Thread.sleep(500);
		acao.clicarNoElemento(menuRotinas);
		espera.aguardarElementoEstarVisivel(telaRotinas);
		acao.escreverNoElemento(campoBuscaRotina, "wkf007");
		espera.aguardarElementoEstarVisivel(selecionarRotina);
		acao.clicarNoElemento(selecionarRotina);
		espera.aguardarElementoEstarVisivel(detalhesRotina);
		acao.clicarNoElemento(botaoHistoricoVersoes);
		espera.aguardarElementoEstarVisivel(telaHistoricoVersoes);

		if (acao.localizarElementos(botaoCriarNovaVersao).size() != 0) {
			mouse.scrollParaElemento(botaoCriarNovaVersao);
			JavascriptExecutor jse = (JavascriptExecutor) webDriver;
			jse.executeScript("window.scrollBy(0, -100)");
			acao.clicarNoElemento(botaoCriarNovaVersao);
			espera.aguardarElementoEstarVisivel(janelaCriarNovaVersaoRotina);
			acao.clicarNoElemento(botaoConfirmarCriarNovaVersaoRotina);
			espera.aguardarElementoEstarVisivel(mensagemDescricaoVersaoInvalida);
			msg.fecharMensagemNotificacao();
			espera.aguardarElementoDesaparecer(mensagemDescricaoVersaoInvalida);
			acao.escreverNoElemento(descricaoDaVersao, "Teste versão");
			acao.clicarNoElemento(botaoConfirmarCriarNovaVersaoRotina);
			espera.aguardarElementoEstarVisivel(simNotificacao);
			acao.clicarNoElemento(simNotificacao);
			espera.aguardarElementoEstarVisivel(mensagemRascunhoCriado);
			msg.fecharMensagemNotificacao();
		} else {
			espera.aguardarElementoEstarVisivel(botaoCriarPrimeiraVersao);
			acao.clicarNoElemento(botaoCriarPrimeiraVersao);
			espera.aguardarElementoEstarVisivel(mensagemConfirmaCriacaoRascunho);
			acao.clicarNoElemento(simNotificacao);
			espera.aguardarElementoEstarVisivel(mensagemRascunhoCriado);
			msg.fecharMensagemNotificacao();
		}
	}

	@Test(testName = "Cadastrar Atualizacao", dependsOnMethods = { "criarRascunhoRotina" })
	public void cadastrarAtualizacao() {

		espera.aguardarElementoEstarVisivel(menuAtualizacoes);
		acao.clicarNoElemento(menuAtualizacoes);
		espera.aguardarElementoEstarVisivel(idAtualizacao);
		acao.selecionarNoElementoPeloValor(dificuldade, "B");
		acao.selecionarNoElementoPeloValor(prioridade, "B");
		acao.clicarNoElemento(descricaoTecnicaAba);
		acao.escreverNoElemento(descricaoTecnica, "Este é um teste de automação.");
		acao.clicarNoElemento(descricaoTestesAba);
		acao.escreverNoElemento(descricaoTestes, "Este é um teste de automação.");
		acao.clicarNoElemento(descricaoClienteAba);
		acao.escreverNoElemento(descricaoCliente, "Este é um teste de automação.");
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(mensagemSucesso);

		numeroAtualizacao = acao.localizarElemento(idAtualizacao).getAttribute("value");
	}

	@Test(testName = "Acessar tela de desenvolvimento", dependsOnMethods = { "cadastrarAtualizacao" })
	public void acessarTelaDeDesenvolvimento() {

		msg.fecharNotificacaoCantoDaTela();
		mouse.scrollParaElemento(botaoDesenvolver);
		acao.clicarNoElemento(botaoDesenvolver);
	}

	@Test(testName = "Inserir rotina na Atualizacao", dependsOnMethods = { "acessarTelaDeDesenvolvimento" })
	public void adicionarRotinaNaAtualizacao() throws InterruptedException {

		acao.clicarNoElemento(guiaRotinas);
		acao.clicarNoElemento(botaoInserirRotina);
		espera.aguardarElementoEstarVisivel(lovRotinasAberta);
		acao.clicarNoElemento(selecionaRotinaObjeto);
		msg.fecharNotificacaoCantoDaTela();
		espera.aguardarElementoEstarVisivel(confirmarSelecaoRotina);
		Thread.sleep(500);
		acao.clicarNoElemento(confirmarSelecaoRotina);
		Thread.sleep(500);
		if (acao.localizarElementos(mensagemRotinaEmUso).size() != 0) {

			atualiza.cancelarAtualizacaoParaDesbloquearRotina();
			mouse.scrollParaElemento(botaoDesenvolver);
			acao.clicarNoElemento(botaoDesenvolver);
			acao.clicarNoElemento(guiaRotinas);
			Thread.sleep(500);
			acao.clicarNoElemento(botaoInserirRotina);
			espera.aguardarElementoEstarVisivel(lovRotinasAberta);
			Thread.sleep(500);
			acao.clicarNoElemento(selecionaRotinaObjeto);
			espera.aguardarElementoEstarVisivel(confirmarSelecaoRotina);
			espera.aguardarElementoSerClicavel(confirmarSelecaoRotina);
			Thread.sleep(500);
			acao.clicarNoElemento(confirmarSelecaoRotina);
		}
		msg.fecharNotificacaoCantoDaTela();
		espera.aguardarElementoSerClicavel(botaoVoltar);
		Thread.sleep(1000);
		acao.clicarNoElemento(botaoVoltar);
		msg.fecharNotificacaoCantoDaTela();
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		Thread.sleep(500);
		try {
			acao.clicarNoElemento(botaoSalvar);
		} catch (Exception e) {
			Thread.sleep(500);
			teclado.pressionarTeclaDeControle(Keys.ESCAPE);
			Thread.sleep(500);
			espera.aguardarElementoDesaparecer(notificacaoCantoDaTela);
			acao.clicarNoElemento(botaoSalvar);
		}
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		msg.fecharMensagemNotificacao();
	}

	@Test(testName = "Inserir objetos de negocio na atualizacao", dependsOnMethods = { "adicionarRotinaNaAtualizacao" }, enabled = true)
	public void criarObjetosDeNegocio() throws InterruptedException {

		mouse.scrollParaElemento(menuObjetosNegocio);
		espera.aguardarElementoEstarVisivel(menuObjetosNegocio);
		acao.clicarNoElemento(menuObjetosNegocio);
		espera.aguardarElementoEstarVisivel(telaObjetoNegocio);

		acao.clicarNoElemento(abrirGrupoObjetos);
		espera.aguardarElementoEstarVisivel(listaDeObjetosExibidas);
		atualiza.criarObjeto();
		try {
			espera.aguardarElementoEstarVisivel(mensagemCriarVersao);
		} catch (Exception e) {
			atualiza.criarObjeto();
			espera.aguardarElementoEstarVisivel(mensagemCriarVersao);
		}
		acao.clicarNoElemento(naoNotificacao);
		espera.aguardarElementoDesaparecer(naoNotificacao);
		msg.fecharMensagemNotificacao();
		Thread.sleep(600);
		espera.aguardarElementoEstarVisivel(abrirGrupoObjetos);
		acao.clicarNoElemento(abrirGrupoObjetos);
		espera.aguardarElementoEstarVisivel(listaDeObjetosExibidas);
		Thread.sleep(400);
		acao.escreverNoElemento(buscarObjetoNegocio, nomeObjeto);
		espera.aguardarElementoEstarVisivel(
				By.xpath("//li[@ng-repeat='objetoNegocio in filtraObjetosNegocio(grupo.objetosNegocio)' and contains(text(),'" + nomeObjeto
						+ "')]"));
		acao.clicarNoElemento(By.xpath("//li[@ng-repeat='objetoNegocio in filtraObjetosNegocio(grupo.objetosNegocio)' and contains(text(),'"
				+ nomeObjeto + "')]"));
		espera.aguardarElementoEstarVisivel(detalhesObjetoNegocio);
		acao.clicarNoElemento(botaoHistoricoVersoesObjetoNegocio);
		espera.aguardarElementoEstarVisivel(telaCriarNovaVersao);
		acao.clicarNoElemento(botaoCriarPrimeiraVersaoObjeto);
		espera.aguardarElementoEstarVisivel(mensagemConfirmaCriacaoRascunhoObjeto);
		acao.clicarNoElemento(simNotificacao);
		espera.aguardarElementoEstarVisivel(mensagemRascunhoCriadoObjeto);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
	}

	@Test(testName = "Inserir modificacoes de cadastro na Atualizacao", dependsOnMethods = { "criarObjetosDeNegocio" })
	public void adicionarComandosDeBdComSeparador() {

		acao.clicarNoElemento(abrirAtualizacaoJaCriada);
		espera.aguardarElementoEstarVisivel(idAtualizacao);
		msg.fecharNotificacaoCantoDaTela();
		mouse.scrollParaElemento(botaoDesenvolver);
		acao.clicarNoElemento(botaoDesenvolver);
		acao.clicarNoElemento(guiaComandosBancoDados);
		acao.clicarNoElemento(botaoInserirComando);
		espera.aguardarElementoEstarVisivel(separadorComandos);
		acao.clicarNoElemento(separadorComandos);
		acao.escreverNoElemento(separadorComandos, "%");
		((JavascriptExecutor) webDriver).executeScript("$('#editorSQL').scope().sqlEditor.setValue('the new text here');");
		acao.escreverNoElemento(editorSql, "select * from teste%select 1 from teste2");
		teclado.pressionarTeclaDeControle(Keys.ENTER);
		acao.escreverNoElemento(editorSql, "%");
		teclado.pressionarTeclaDeControle(Keys.ENTER);
		acao.escreverNoElemento(editorSql, "select abc from teste3");
		acao.clicarNoElemento(botaoSalvarComandos);
		espera.aguardarElementoDesaparecer(botaoSalvarComandos);
		testar.passouSeElementoEstiverVisivel(totalDeTresComandos);
		msg.fecharNotificacaoCantoDaTela();
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		try {
			acao.clicarNoElemento(botaoSalvar);
		} catch (Exception e) {
			msg.fecharNotificacaoCantoDaTela();
			acao.clicarNoElemento(botaoSalvar);
		}
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		msg.fecharMensagemNotificacao();
	}

	@Test(testName = "Inserir modificacoes de cadastro na Atualizacao", dependsOnMethods = { "adicionarComandosDeBdComSeparador" })
	public void adicionarModificacoesCadastro() {

		msg.fecharNotificacaoCantoDaTela();
		espera.aguardarElementoEstarVisivel(guiaModificacoesCadastros);
		acao.clicarNoElemento(guiaModificacoesCadastros);
		acao.clicarNoElemento(inserirModificacoesCadastros);
		espera.aguardarElementoEstarVisivel(lovTabelaModificacoes);
		espera.aguardarElementoEstarVisivel(selecionarOpcaoObjetoNegocio);
		acao.clicarNoElemento(selecionarOpcaoObjetoNegocio);
		espera.aguardarElementoEstarVisivel(lovModificacaoCadastro);
		By target = By.xpath("//td[text()='" + nomeObjeto + "']//preceding::input[1][@type='checkbox']");
		mouse.moverCursorParaElemento(target);
		mouse.click(target);
		// acao.clicarNoElemento(By.xpath("//td[text()='" + nomeObjeto + "']//preceding::input[1][@type='checkbox']"));
		espera.aguardarElementoEstarVisivel(confirmarSelecaoModificacoesCadastros);
		msg.fecharNotificacaoCantoDaTela();
		acao.clicarNoElemento(confirmarSelecaoModificacoesCadastros);
		espera.aguardarElementoDesaparecer(lovModificacaoCadastro);
		msg.fecharNotificacaoCantoDaTela();
		mouse.scrollParaElemento(botaoSalvar);
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		msg.fecharMensagemNotificacao();
	}

	@Test(testName = "Inserir objetos de negocio na Atualizacao", dependsOnMethods = { "adicionarModificacoesCadastro" })
	public void adicionarObjetosNaAtualizacao() throws InterruptedException {

		acao.clicarNoElemento(guiaObjetosNegocio);
		acao.clicarNoElemento(botaoInserirObjetoNegocio);
		espera.aguardarElementoEstarVisivel(lovObjetosAberta);
		By target = By.xpath("//th[text()='Objeto Negócio']//following::td[text()='" + nomeObjeto + "']");
		mouse.moverCursorParaElemento(target);
		Thread.sleep(300);
		mouse.click(target);
		msg.fecharNotificacaoCantoDaTela();
		espera.aguardarElementoEstarVisivel(confirmarSelecaoObjeto);
		acao.clicarNoElemento(confirmarSelecaoObjeto);
		espera.aguardarElementoDesaparecer(confirmarSelecaoObjeto);
		msg.fecharNotificacaoCantoDaTela();
		acao.clicarNoElemento(botaoVoltar);
		mouse.scrollParaElemento(botaoSalvar);
		msg.fecharNotificacaoCantoDaTela();
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		msg.fecharMensagemNotificacao();
	}

	@Test(testName = "Cancelar repasse antes de salvar.", dependsOnMethods = { "adicionarObjetosNaAtualizacao" })
	public void cancelarRealizacaoRepasseParaUsuario() {

		String acaoAtual = acao.localizarElemento(acaoAtualHistorico).getText();
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("scroll(0, -250);");
		msg.fecharNotificacaoCantoDaTela();
		mouse.scrollParaElemento(botaoEnviarAtualizacao);
		acao.clicarNoElemento(botaoEnviarAtualizacao);
		espera.aguardarElementoEstarVisivel(janelaRepasse);
		acao.clicarNoElemento(botaoCancelarRepasse);
		espera.aguardarElementoDesaparecer(janelaRepasse);
		msg.fecharNotificacaoCantoDaTela();
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		testar.passouSeTextoDoElementoFor(acaoAtualHistorico, acaoAtual);
		msg.fecharMensagemNotificacao();
	}

	@Test(testName = "Realiza repasse da atualizacao Validar.", dependsOnMethods = { "cancelarRealizacaoRepasseParaUsuario" })
	public void realizarRepasseValidar() {
		atualiza.realizarRepasseParaUsuario("Validar", "Gustavo Thizon Waterkemper");
	}

	@Test(testName = "Realiza repasse da atualizacao Validar DBA.", dependsOnMethods = { "realizarRepasseValidar" })
	public void realizarRepasseValidarDba() {
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		atualiza.realizarRepasseFilaUnica("Validar DBA");
	}

	@Test(testName = "Validar comando de banco", dependsOnMethods = { "realizarRepasseValidarDba" })
	public void validarComandosDeBanco() {

		acao.clicarNoElemento(menuHomologar);
		espera.aguardarElementoEstarVisivel(janelaHomologarAtualizacoes);
		acao.clicarNoElemento(aprovarAtualizacao(numeroAtualizacao));
		espera.aguardarElementoEstarVisivel(mensagemConfirmarAprovacaoAtualizacao);
		acao.clicarNoElemento(simConfirmacao);
		espera.aguardarElementoEstarVisivel(mensagemAtualizacaoAplicada);
		msg.fecharMensagemNotificacao();
	}

	@Test(testName = "Excluir comando de banco da atualizacao", dependsOnMethods = { "validarComandosDeBanco" })
	public void excluirComandosDaAtualizacao() throws InterruptedException {

		msg.fecharNotificacaoCantoDaTela();
		mouse.scrollParaElemento(menuAtualizacoes);
		acao.clicarNoElemento(menuAtualizacoes);
		espera.aguardarElementoEstarVisivel(idAtualizacao);
		acao.escreverNoElemento(idAtualizacao, numeroAtualizacao);
		teclado.pressionarTeclaDeControle(Keys.ENTER);
		mouse.scrollParaElemento(botaoDesenvolver);
		acao.clicarNoElemento(botaoDesenvolver);
		acao.clicarNoElemento(guiaComandosBancoDados);
		espera.aguardarElementoEstarVisivel(botaoInserirComando);
		mouse.moverCursorParaElemento(botaoInserirComando);

		for (int i = 1; i < 4; i++) {
			msg.fecharNotificacaoCantoDaTela();
			mouse.scrollParaElemento(botaoEnviarAtualizacao);
			acao.clicarNoElemento(botaoExcluirComandoBd(i));
		}
		msg.fecharNotificacaoCantoDaTela();

		try {
			acao.clicarNoElemento(botaoSalvar);
		} catch (Exception e) {
			teclado.pressionarTeclaDeControle(Keys.ESCAPE);
			espera.aguardarElementoDesaparecer(notificacaoCantoDaTela);
			acao.clicarNoElemento(botaoSalvar);
		}
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
	}

	@Test(testName = "Aplicar atualização para testes manualmente.", dependsOnMethods = { "excluirComandosDaAtualizacao" })
	public void aplicarAtualizacaoParaTestes() {

		acao.clicarNoElemento(menuAplicarAtualizacao);
		espera.aguardarElementoEstarVisivel(lovClientes);
		espera.aguardarElementoEstarVisivel(clienteProjedataDev);
		acao.clicarNoElemento(clienteProjedataDev);
		espera.aguardarElementoEstarVisivel(quadroSelecionarBaseCliente);
		acao.selecionarNoElemento(selecaoAmbiente, "Homologação Projedata");
		espera.aguardarElementoEstarVisivel(selecionaBaseHomologacao);
		acao.clicarNoElemento(selecionaBaseHomologacao);
		acao.selecionarNoElementoPeloValor(situacao, "aplicarTestes");
		acao.clicarNoElemento(By.xpath("//span[text()='" + numeroAtualizacao + "']//preceding::td[1]/input[@type='checkbox']"));

		acao.clicarNoElemento(botaoAplicar);
		espera.aguardarElementoEstarVisivel(janelaConfirmaAplicacao);
		teclado.pressionarTeclaAlfanumerica("N");
		espera.aguardarElementoDesaparecer(janelaConfirmaAplicacao);
		acao.clicarNoElemento(botaoAplicar);
		espera.aguardarElementoEstarVisivel(janelaConfirmaAplicacao);
		teclado.pressionarTeclaAlfanumerica("S");
	}

	@Test(testName = "realizar repasse disponivel para testes pela funcionalidade.", dependsOnMethods = { "aplicarAtualizacaoParaTestes" })
	public void realizarRepasseDisponivelParaTestes() throws InterruptedException {

		acao.clicarNoElemento(abrirOpcaoFazerRepasseTestes);
		espera.aguardarElementoEstarVisivel(botaoRealizarRepasseDisponivelParaTestes);
		Thread.sleep(500);
		acao.clicarNoElemento(botaoRealizarRepasseDisponivelParaTestes);
		acao.clicarNoElemento(selecionaBaseHomologacao);
		espera.aguardarElementoDesaparecer(
				By.xpath("//span[text()='" + numeroAtualizacao + "']//preceding::td[1]/input[@type='checkbox']"));
	}

	@Test(testName = "verificar se a atualização foi aplicada para testes corretamente analisando o histórico.", dependsOnMethods = {
			"realizarRepasseDisponivelParaTestes" })
	public void verificarSeRepasseFoiRealizado() {

		acao.clicarNoElemento(menuAtualizacoes);
		espera.aguardarElementoEstarVisivel(idAtualizacao);
		acao.escreverNoElemento(idAtualizacao, numeroAtualizacao);
		teclado.pressionarTeclaDeControle(Keys.ENTER);
		espera.aguardarElementoEstarVisivel(historicoDisponivelParaTestes);
	}

	@Test(testName = "resgatar atualização para testes.", dependsOnMethods = { "verificarSeRepasseFoiRealizado" })
	public void resgatarAtualizacao() {

		msg.fecharNotificacaoCantoDaTela();
		mouse.scrollParaElemento(resgatarAtualizacao);
		acao.clicarNoElemento(resgatarAtualizacao);
		espera.aguardarElementoEstarVisivel(janelaConfirmacao);
		acao.clicarNoElemento(simConfirmacao);
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		msg.fecharMensagemNotificacao();
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
	}

	@Test(testName = "Realiza repasse da atualizacao lancar atualizacao.", dependsOnMethods = { "resgatarAtualizacao" })
	public void realizarRepasseLancarAtualizacao() {
		atualiza.realizarRepasseFilaUnica("Lançar Atualização");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
	}

	@Test(testName = "lancar atualizacao e gerar versao.", dependsOnMethods = { "realizarRepasseLancarAtualizacao" })
	public void testeLancarAtualizacao() {
		msg.fecharNotificacaoCantoDaTela();
		mouse.scrollParaElemento(botaoDesenvolver);
		acao.clicarNoElemento(botaoDesenvolver);
		msg.fecharNotificacaoCantoDaTela();
		espera.aguardarElementoEstarVisivel(lancarAtualizacao);
		acao.clicarNoElemento(lancarAtualizacao);
		espera.aguardarElementoEstarVisivel(janelaConfirmacao);
		acao.clicarNoElemento(simConfirmacao);
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		msg.fecharMensagemNotificacao();
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
	}

	@Test(testName = "verificar se a versao da atualizacao foi gerada corretamente.", dependsOnMethods = { "testeLancarAtualizacao" })
	public void verificarVersaoGerada() {

		espera.aguardarElementoEstarVisivel(botaoVoltar);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		acao.clicarNoElemento(botaoVoltar);
		versaoAtualizacaoLancada = acao.localizarElemento(versaoGerada).getText();
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
	}

	@Parameters(value = { "url" })
	@Test(testName = "Tentar repassar atualizacao sem OS vinculada.", dependsOnMethods = { "verificarVersaoGerada" }, enabled = true)
	public void repassarAtualizacaoSemOs(String url) throws AWTException, InterruptedException {

		navegador.irParaNovaUrlEmNovaAba(url + "/#/login");
		login.aguardarTelaLogin();
		login.logar("daniel.projedata", "Gustavo1!", "FONTES");
		acessarAtualizador();
		cadastrarAtualizacao();
		mouse.scrollParaElemento(botaoEnviarAtualizacao);
		msg.fecharNotificacaoCantoDaTela();
		acao.clicarNoElemento(botaoEnviarAtualizacao);
		espera.aguardarElementoEstarVisivel(janelaRepasse);
		acao.selecionarNoElemento(campoAcao, "Validar");
		acao.selecionarNoElemento(campoDestinoRepasse, "DANIEL DA ROSA");
		acao.escreverNoElemento(campoDetalhesRepasse, "Teste automação Repasse");
		acao.clicarNoElemento(botaoConfirmarRepasse);
		espera.aguardarElementoEstarVisivel(mensagemDeveTerOsCadastrada);
		msg.fecharMensagemNotificacao();
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
	}

	@Test(testName = "Repassar atualizacao com OS vinculada.", dependsOnMethods = { "repassarAtualizacaoSemOs" }, enabled = true)
	public void repassarAtualizacaoComOs() {

		mouse.scrollParaElemento(abaOSsAtendidas);
		acao.clicarNoElemento(abaOSsAtendidas);
		espera.aguardarElementoEstarVisivel(botaoInserirOs);
		acao.clicarNoElemento(botaoInserirOs);
		espera.aguardarElementoEstarVisivel(lovListaOSs);
		acao.clicarNoElemento(selecionaOSs("135960"));
		espera.aguardarElementoDesaparecer(lovListaOSs);
		espera.aguardarElementoEstarVisivel(osAdicionada("135960"));
		msg.fecharNotificacaoCantoDaTela();
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		msg.fecharMensagemNotificacao();
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
	}

	@Test(testName = "Remover OS da atualizacao", dependsOnMethods = { "repassarAtualizacaoComOs" }, enabled = true)
	public void excluirOsDaAtualizacao() throws InterruptedException {

		Thread.sleep(1000);
		mouse.scrollParaElemento(botaoExcluirOs);
		Thread.sleep(500);
		acao.clicarNoElemento(botaoExcluirOs);
		espera.aguardarElementoEstarVisivel(osMarcadaParaExclusao("135960"));
		msg.fecharNotificacaoCantoDaTela();
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		msg.fecharMensagemNotificacao();
	}

	@Parameters(value = { "url2" })
	@Test(testName = "Testar o acesso ao atualizador pela URL, sendo que no portal nao tem o botao de acesso.", dependsOnMethods = {
			"excluirOsDaAtualizacao" }, enabled = true)
	public void acessarAtualizadorBaseHomologacaoPelaUrl(String url2) throws AWTException, InterruptedException {
		
		Thread.sleep(1000);
		navegador.irParaNovaUrlEmNovaAba(url2);
		login.aguardarTelaLogin();
		login.logar("teste", "Gustavo1!", "Homologacao");
		espera.aguardarElementoDesaparecer(botaoAcessarAtualizador);
		navegador.alterarUrl(url2 + "/#/admin");
		espera.aguardarElementoEstarVisivel(paginaInicial);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
	}

	@Parameters(value = { "url" })
	@Test(testName = "aplicar atualizacao na base simulando o cliente.", dependsOnMethods = {
			"acessarAtualizadorBaseHomologacaoPelaUrl" }, enabled = true)
	public void aplicarAtualizacao(String url) throws AWTException, InterruptedException {

		espera.aguardarElementoEstarVisivel(menuAplicarAtualizacao);
		espera.aguardarElementoSerClicavel(menuAplicarAtualizacao);
		acao.clicarNoElemento(menuAplicarAtualizacao);
		espera.aguardarElementoEstarVisivel(BaseHomologacaoCliente);
		acao.clicarNoElemento(BaseHomologacaoCliente);
		espera.aguardarElementoEstarVisivel(botaoBuscarAtualizacoes);
		acao.clicarNoElemento(botaoBuscarAtualizacoes);
		Thread.sleep(1000);
		acao.clicarNoElemento(BaseHomologacaoCliente);
		espera.aguardarElementoEstarVisivel(listaAtualizacoesPendentes);
		acao.clicarNoElemento(By.xpath("//span[text()='" + versaoAtualizacaoLancada + "']//preceding::input[1]"));
		acao.clicarNoElemento(botaoAplicar);
		espera.aguardarElementoEstarVisivel(janelaConfirmacao);
		acao.clicarNoElemento(simConfirmacao);
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		navegador.irParaNovaUrlEmNovaAba(url + "#/login");
		login.aguardarTelaLogin();

	}

	@Test(testName = "adicionar dependencia na atualizacao.", dependsOnMethods = { "aplicarAtualizacao" })
	public void adicionarDependencia() throws InterruptedException {

		login.logar("gustavo.projedata", "guth055", "fontes");
		acessarAtualizador();
		cadastrarAtualizacao();
		numeroAtualizacaoDependente = acao.localizarElemento(idAtualizacao).getAttribute("value");
		acao.clicarNoElemento(menuAtualizacoes);
		espera.aguardarElementoEstarVisivel(idAtualizacao);
		cadastrarAtualizacao();
		mouse.scrollParaElemento(abaDependencias);
		acao.clicarNoElemento(abaDependencias);
		espera.aguardarElementoEstarVisivel(botaoInserirDependencias);
		acao.clicarNoElemento(botaoInserirDependencias);
		Thread.sleep(1000);
		espera.aguardarElementoEstarVisivel(lovAtualizacoesNaoFinalizadas);
		Thread.sleep(1500);
		acao.escreverNoElemento(buscarAtualizacaoDependente, numeroAtualizacaoDependente);
		Thread.sleep(1000);
		espera.aguardarElementoEstarVisivel(selecionarDependencia(numeroAtualizacaoDependente));
		acao.clicarNoElemento(selecionarDependencia(numeroAtualizacaoDependente));
		idDependente = acao.localizarElemento(idAtualizacaoDependente).getText();
		msg.fecharNotificacaoCantoDaTela();
		mouse.scrollParaElemento(botaoSalvar);
		Thread.sleep(500);
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		msg.fecharMensagemNotificacao();
	}

	@Test(testName = "tentar lançar atualizacao com dependencia.", dependsOnMethods = { "adicionarDependencia" })
	public void lancarAtualizacaoComDependencia() throws InterruptedException {

		msg.fecharNotificacaoCantoDaTela();
		atualiza.realizarRepasseParaUsuario("Validar", "Gustavo Thizon Waterkemper");
		msg.fecharNotificacaoCantoDaTela();
		atualiza.realizarRepasseFilaUnica("Aplicar para Testes");
		msg.fecharNotificacaoCantoDaTela();
		atualiza.realizarRepasseFilaUnica("Disponível para Testes");
		msg.fecharNotificacaoCantoDaTela();
		mouse.scrollParaElemento(resgatarAtualizacao);
		acao.clicarNoElemento(resgatarAtualizacao);
		espera.aguardarElementoEstarVisivel(janelaConfirmacao);
		acao.clicarNoElemento(simConfirmacao);
		msg.fecharNotificacaoCantoDaTela();
		Thread.sleep(1000);
		atualiza.realizarRepasseFilaUnica("Lançar Atualização");
		msg.fecharNotificacaoCantoDaTela();
		mouse.scrollParaElemento(botaoDesenvolver);
		msg.fecharNotificacaoCantoDaTela();
		acao.clicarNoElemento(botaoDesenvolver);
		espera.aguardarElementoEstarVisivel(lancarAtualizacao);
		msg.fecharNotificacaoCantoDaTela();
		acao.clicarNoElemento(lancarAtualizacao);
		msg.fecharNotificacaoCantoDaTela();
		espera.aguardarElementoEstarVisivel(janelaConfirmacao);
		acao.clicarNoElemento(simConfirmacao);
		espera.aguardarElementoEstarVisivel(mensagemAtualizacaoComDependencia);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
	}

	@Parameters(value = { "url2" })
	@Test(testName = "lancar Atualizacao dependente.", dependsOnMethods = { "lancarAtualizacaoComDependencia" })
	public void gerarAtualizacaoDependente(String url) throws AWTException, InterruptedException {

		Thread.sleep(1000);
		acao.clicarNoElemento(menuAtualizacoes);
		espera.aguardarElementoEstarVisivel(idAtualizacao);
		acao.escreverNoElemento(idAtualizacao, idDependente);
		teclado.pressionarTeclaDeControle(Keys.ENTER);
		msg.fecharNotificacaoCantoDaTela();
		atualiza.realizarRepasseParaUsuario("Validar", "Gustavo Thizon Waterkemper");
		msg.fecharNotificacaoCantoDaTela();
		atualiza.realizarRepasseFilaUnica("Aplicar para Testes");
		msg.fecharNotificacaoCantoDaTela();
		atualiza.realizarRepasseFilaUnica("Disponível para Testes");
		msg.fecharNotificacaoCantoDaTela();
		mouse.scrollParaElemento(resgatarAtualizacao);
		acao.clicarNoElemento(resgatarAtualizacao);
		espera.aguardarElementoEstarVisivel(janelaConfirmacao);
		acao.clicarNoElemento(simConfirmacao);
		espera.aguardarElementoDesaparecer(simConfirmacao);
		msg.fecharNotificacaoCantoDaTela();
		atualiza.realizarRepasseFilaUnica("Lançar Atualização");
		msg.fecharNotificacaoCantoDaTela();
		mouse.scrollDown();
		acao.clicarNoElemento(botaoDesenvolver);
		msg.fecharNotificacaoCantoDaTela();
		acao.clicarNoElemento(lancarAtualizacao);
		espera.aguardarElementoEstarVisivel(janelaConfirmacao);
		acao.clicarNoElemento(simConfirmacao);
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(mensagemSucesso);
		navegador.irParaNovaUrlEmNovaAba(url + "/#/login");
		login.aguardarTelaLogin();
	}

	@Test(testName = "adicionar anexo ao repasse e excluir.", dependsOnMethods = { "gerarAtualizacaoDependente" }, enabled = false)
	public void adicionarAnexoEExcluir() throws AWTException, InterruptedException {

		login.logar("gustavo.projedata", "guth055", "fontes");
		acessarAtualizador();
		cadastrarAtualizacao();
		mouse.scrollDown();
		msg.fecharNotificacaoCantoDaTela();
		acao.clicarNoElemento(botaoEnviarAtualizacao);
		espera.aguardarElementoEstarVisivel(janelaRepasse);
		acao.selecionarNoElemento(campoDestinoRepasse, "TESTE GERAL");
		mouse.moverCursorParaElemento(botaoInserirAnexoRepasse);
		acao.clicarNoElemento(botaoInserirAnexoRepasse);

		String SO = System.getProperty("os.name").toLowerCase();

		if (SO.contains("win")) {
			rotina.uploadFilesWindows(anexo1Windows);
		} else if (SO.contains("linux")) {
			rotina.uploadFilesLinux(anexo1Linux);
		}
	}

	@Test(testName = "adicionar 2 anexos ao repasse.", dependsOnMethods = { "adicionarAnexoEExcluir" }, enabled = false)
	public void adicionarAnexosAoRepasse() throws Exception {

		String so = System.getProperty("os.name").toLowerCase();

		if (so.contains("win")) {

			mouse.moverCursorParaElemento(botaoInserirAnexoRepasse);
			acao.clicarNoElemento(botaoInserirAnexoRepasse);
			rotina.uploadFilesWindows(anexo1Windows);
			espera.aguardarElementoEstarVisivel(anexo1AdicionadoAoRepasse);
			mouse.moverCursorParaElemento(botaoInserirAnexoRepasse);
			acao.clicarNoElemento(botaoInserirAnexoRepasse);
			rotina.uploadFilesWindows(anexo2Windows);
			espera.aguardarElementoEstarVisivel(anexo2AdicionadoAoRepasse);

		} else if (so.contains("linux")) {

			mouse.moverCursorParaElemento(botaoInserirAnexoRepasse);
			acao.clicarNoElemento(botaoInserirAnexoRepasse);
			rotina.uploadFilesLinux(anexo1Linux);
			espera.aguardarElementoEstarVisivel(anexo1AdicionadoAoRepasse);
			mouse.moverCursorParaElemento(botaoInserirAnexoRepasse);
			acao.clicarNoElemento(botaoInserirAnexoRepasse);
			rotina.uploadFilesLinux(anexo2Linux);
			espera.aguardarElementoEstarVisivel(anexo2AdicionadoAoRepasse);
		}
		acao.clicarNoElemento(botaoConfirmarRepasse);
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
	}

	@Parameters(value = { "url" })
	@Test(testName = "Realiza repasse de cancelamento da atualizacao.", dependsOnMethods = { "adicionarAnexosAoRepasse" }, enabled = false)
	public void cancelarAtualizacao(String url) throws AWTException, InterruptedException {

		atualiza.realizarRepasseFilaUnica("Cancelar");
		navegador.irParaNovaUrlEmNovaAba(url + "/#/login");
		login.aguardarTelaLogin();
	}

	@Parameters(value = { "url" })
	@Test(testName = "Vincular OS na atualizacao", dependsOnMethods = { "gerarAtualizacaoDependente" }, enabled = true)
	public void inserirOsNaAtualizacao(String url) throws AWTException, InterruptedException {
		navegador.irParaNovaUrlEmNovaAba(url + "/#/login");
		login.logar("gustavo.projedata", "guth055", "SUPORTE_TESTE");
		acessarAtualizador();
		cadastrarAtualizacao();
		mouse.scrollParaElemento(abaOSsAtendidas);
		acao.clicarNoElemento(abaOSsAtendidas);
		espera.aguardarElementoEstarVisivel(botaoInserirOs);
		acao.clicarNoElemento(botaoInserirOs);
		Thread.sleep(500);
		espera.aguardarElementoEstarVisivel(lovListaOSs);
		Thread.sleep(1000);
		acao.clicarNoElemento(selecionaOSs("97463"));
		Thread.sleep(1000);
		espera.aguardarElementoDesaparecer(lovListaOSs);
		espera.aguardarElementoEstarVisivel(osAdicionada("97463"));
		msg.fecharNotificacaoCantoDaTela();
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.fecharMensagemNotificacao);

		if (webDriver.findElements(mensagemOsEmUso).size() > 0) {

			int mensagem = webDriver.findElement(mensagemOsEmUso).getText().lastIndexOf(" ") + 1;
			mensagemAtualizacaoComOsVinculada = webDriver.findElement(mensagemOsEmUso).getText().substring(mensagem);

			msg.fecharMensagemNotificacao();
			removerOsDaAtualizacao();
			acao.clicarNoElemento(abrirAtualizacaoJaCriada);
			espera.aguardarAtributoDoElementoConterOValor(idAtualizacao, "value", numeroAtualizacao);
			mouse.scrollParaElemento(abaOSsAtendidas);
			msg.fecharNotificacaoCantoDaTela();
			mouse.scrollParaElemento(botaoSalvar);
			acao.clicarNoElemento(botaoSalvar);
		}

		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		msg.fecharMensagemNotificacao();
		msg.fecharNotificacaoCantoDaTela();

	}

	@Test(testName = "Tentar vincular uma OS na atualizacao com a OS ja vinculada a outra atualizacao", dependsOnMethods = {
			"inserirOsNaAtualizacao" }, enabled = true)
	public void vincularUmaOsNaAtualizacaoComAOsJaVinculada() throws InterruptedException {

		espera.aguardarElementoEstarVisivel(menuAtualizacoes);
		acao.clicarNoElemento(menuAtualizacoes);
		espera.aguardarElementoEstarVisivel(idAtualizacao);
		acao.selecionarNoElementoPeloValor(dificuldade, "B");
		acao.selecionarNoElementoPeloValor(prioridade, "B");
		acao.clicarNoElemento(descricaoTecnicaAba);
		acao.escreverNoElemento(descricaoTecnica, "Este é um teste de automação.");
		acao.clicarNoElemento(descricaoTestesAba);
		acao.escreverNoElemento(descricaoTestes, "Este é um teste de automação.");
		acao.clicarNoElemento(descricaoClienteAba);
		acao.escreverNoElemento(descricaoCliente, "Este é um teste de automação.");
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		msg.fecharMensagemNotificacao();
		mouse.scrollParaElemento(abaOSsAtendidas);
		acao.clicarNoElemento(abaOSsAtendidas);
		espera.aguardarElementoEstarVisivel(botaoInserirOs);
		acao.clicarNoElemento(botaoInserirOs);
		espera.aguardarElementoEstarVisivel(lovListaOSs);
		Thread.sleep(500);
		acao.clicarNoElemento(selecionaOSs("97463"));
		Thread.sleep(500);
		espera.aguardarElementoDesaparecer(lovListaOSs);
		espera.aguardarElementoEstarVisivel(osAdicionada("97463"));
		msg.fecharNotificacaoCantoDaTela();
		Thread.sleep(500);
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(atualiza.mensagemOsEmUso("97463"));

		int mensagem = webDriver.findElement(mensagemOsEmUso).getText().lastIndexOf(" ") + 1;
		mensagemAtualizacaoComOsVinculada = webDriver.findElement(mensagemOsEmUso).getText().substring(mensagem);

		testar.passouSeElementoEstiverVisivel(atualiza.mensagemOsEmUso("97463"));
		msg.fecharMensagemNotificacao();
	}

	@Test(testName = "Remover OS na atualizacao", dependsOnMethods = { "vincularUmaOsNaAtualizacaoComAOsJaVinculada" }, enabled = true)
	public void removerOsDaAtualizacao() {

		acao.clicarNoElemento(menuAtualizacoes);
		espera.aguardarElementoEstarVisivel(idAtualizacao);
		acao.escreverNoElemento(idAtualizacao, mensagemAtualizacaoComOsVinculada);
		teclado.pressionarTeclaDeControle(Keys.ENTER);
		espera.aguardarElementoEstarVisivel(idAtualizacaoDesabilitada);
		msg.fecharNotificacaoCantoDaTela();
		mouse.scrollParaElemento(botaoExcluirOs);
		acao.clicarNoElemento(botaoExcluirOs);
		msg.fecharNotificacaoCantoDaTela();
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(mensagemSucesso);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
	}

	@Parameters(value = { "url3" })
	@Test(testName = "Inserir repasse na atualizacao e verificar se fez na OS", dependsOnMethods = {
			"removerOsDaAtualizacao" }, enabled = true)
	public void verificarRepasseDaAtualizacaoNaOs(String url3) throws AWTException, InterruptedException {

		navegador.irParaNovaUrlEmNovaAba(url3);
		login.aguardarTelaLogin();
		login.logar("gustavo.projedata", "Kamila1!", "SUPORTE_TESTE");
		rotina.selecionarRotina("wkf008");

		acao.escreverNoElemento(campoNumeroOS, "97463");
		acao.clicarNoElemento(rotina.botaoConsultar);
		espera.aguardarElementoEstarVisivel(botaoNovoRepasse);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);

		testar.passouSeAtributoDoElementoContem(detalhesRepasseAtual, "value", "OS REMOVIDA DA ATUALIZAÇÃO " + numeroAtualizacao);
		testar.passouSeAtributoDoElementoContem(detalhesRepasseAnterior, "value", "OS INSERIDA NA ATUALIZAÇÃO: " + numeroAtualizacao);

		rotina.fecharRotina("wkf008");
		;
	}

	@Parameters(value = { "url" })
	@Test(testName = "Verificar se atributos do objeto estao sendo carregados", dependsOnMethods = {
			"verificarRepasseDaAtualizacaoNaOs" }, enabled = true)
	public void verificarSeAtributosEstaoSendoCarregados(String url) throws AWTException, InterruptedException {
		navegador.irParaNovaUrlEmNovaAba(url);
		login.logar("gustavo.projedata", "guth055", "fontes");
		acessarAtualizador();
		acao.clicarNoElemento(menuRascunhos);
		espera.aguardarElementoEstarVisivel(telaRascunhosAberta);
		Thread.sleep(500);
		acao.clicarNoElemento(rascunhoObjetoNegocio);
		Thread.sleep(500);
		acao.clicarNoElemento(pastaObjetos);
		Thread.sleep(500);
		acao.clicarNoElemento(objetoAsdUsuario);
		espera.aguardarElementoEstarVisivel(modalEditarObjetoNegocio);
		Thread.sleep(500);
		acao.clicarNoElemento(excluirAtributo1);
		Thread.sleep(300);
		acao.clicarNoElemento(excluirAtributo2);
		Thread.sleep(300);
		mouse.scrollParaElemento(botaoSalvarObjetos);
		Thread.sleep(300);
		acao.clicarNoElemento(botaoSalvarObjetos);
		msg.aguardarMensagem("Alterações salvas");
		mouse.scrollParaElemento(botaoCarregarAtributos);
		acao.clicarNoElemento(botaoCarregarAtributos);
		espera.aguardarElementoEstarVisivel(atributosCarregados);
		mouse.scrollParaElemento(botaoSalvarObjetos);
		acao.clicarNoElemento(botaoSalvarObjetos);
		msg.aguardarMensagem("Alterações salvas");
		acao.clicarNoElemento(botaoFecharModalObjetoNegocios);
		espera.aguardarElementoDesaparecer(botaoFecharModalObjetoNegocios);
	}

	@Parameters(value = { "url" })
	@Test(testName = "Adicionar atualizacao na fila de aplicacao parc102", dependsOnMethods = {
			"verificarSeAtributosEstaoSendoCarregados" }, enabled = true)
	public void adicionarAtualizacaoCriadaNaFilaAtualizacao(String url) throws AWTException, InterruptedException {
		cadastrarAtualizacao();
		realizarRepasseLancarAtualizacao();
		testeLancarAtualizacao();
		urlAdmin = navegador.retornarUrlAtual();
		navegador.alterarUrl(url);
		rotina.selecionarRotina("arc102", "p");
		acao.clicarNoElemento(rotina.botaoNovo);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElementoNaPosicao(campoCodigoAtualizacaoFilaAplicacao, 1, numeroAtualizacao);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElementoNaPosicao(campoCodigoClienteFilaAplicacao, 1, "201");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		testar.passouSeAtributoDoElementoContem(campoDataPrevista, 0, "value", "Não disponível");
	}

	@Parameters(value = { "url", "url2" })
	@Test(testName = "Abrir a tela de servicos e sincronizar as atualizacoes pendentes", dependsOnMethods = {
			"adicionarAtualizacaoCriadaNaFilaAtualizacao" }, enabled = true)
	public void sincronizarFilaDeAtualizacoes(String url, String url2) throws AWTException, InterruptedException {
		navegador.alterarUrl(url2);
		login.logar("gustavo.projedata", "Gustavo1!", "homologacao");
		navegador.alterarUrl("http://arcturus-homo.prj/#/admin");
		espera.aguardarElementoEstarVisivel(atalhoFerramentas);
		espera.aguardarElementoEstarVisivel(menuServicos);
		try {
			acao.clicarNoElemento(menuServicos);
		} catch (Exception e) {
			acao.clicarNoElemento(menuServicos);
		}
		Thread.sleep(1000);
		espera.aguardarElementoEstarVisivel(botaoSincronizarFilaAplicacao);
		acao.clicarNoElemento(botaoSincronizarFilaAplicacao);
		espera.aguardarElementoEstarVisivel(situacaoSincronizarFilaEmExecucao);
		Thread.sleep(2000);
		navegador.alterarUrl(url);
		rotina.selecionarRotina("arc102", "p");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElementoNaPosicao(campoCodigoAtualizacaoFilaAplicacao, 0, numeroAtualizacao);
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		testar.passouSeAtributoDoElementoContem(campoDataPrevista, 0, "value", "Não automático");
	}

	@Parameters(value = { "url", "url2" })
	@Test(testName = "Aplicar Atualizacao e verificar na arc102 se foi aplicada", dependsOnMethods = {
			"sincronizarFilaDeAtualizacoes" }, enabled = true)
	public void aplicarAtualizacaoNaBaseHomo(String url, String url2) throws AWTException, InterruptedException {
		navegador.alterarUrl("http://arcturus-homo.prj/#/admin");
		espera.aguardarElementoEstarVisivel(atalhoFerramentas);
		espera.aguardarElementoEstarVisivel(menuServicos);
		acao.clicarNoElemento(menuServicos);
		Thread.sleep(1000);
		espera.aguardarElementoEstarVisivel(botaoSincronizarFilaAplicacao);
		mouse.scrollParaElemento(botaoAplicarAtualizacoes);
		acao.clicarNoElemento(botaoAplicarAtualizacoes);
		// espera.aguardarElementoEstarVisivel(logAtualizacoesAplicadas);
		Thread.sleep(3000);
		acao.clicarNoElemento(botaoPausarAplicacao);
		navegador.alterarUrl(url);
		rotina.selecionarRotina("arc102", "p");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElementoNaPosicao(campoCodigoAtualizacaoFilaAplicacao, 0, numeroAtualizacao);
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		testar.passouSeValorContem("rgba(161, 195, 165, 1)",
				rotina.retornarBackGroundColorDeUmElemento(campoCodigoAtualizacaoFilaAplicacao, 0));
	}

}
package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.Parc102Elementos.botaoCancelarAtualizacao;
import static br.com.projedata.arcturus.teste.webelements.Parc102Elementos.botaoListarAtualizacoesAplicadasPorAtualizacao;
import static br.com.projedata.arcturus.teste.webelements.Parc102Elementos.botaoLovClienteAplicadas;
import static br.com.projedata.arcturus.teste.webelements.Parc102Elementos.campoClienteAtualizacaoAplicada;
import static br.com.projedata.arcturus.teste.webelements.Parc102Elementos.campoCodigoAtualizacaoAplicada;
import static br.com.projedata.arcturus.teste.webelements.Parc102Elementos.campoCodigoAtualizacaoFilaAplicacao;
import static br.com.projedata.arcturus.teste.webelements.Parc102Elementos.campoCodigoClienteFilaAplicacao;

import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.Parc102Metodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class TesteParc102 extends TesteGenerico {

	Parc102Metodos Parc102; 
	LoginMetodos login;
	String codigoSistemaInserido;
	int posicaoCodigoAtualizacaoFilaAplicacao = 0;
	int posicaoCodigoClienteFilaAplicacao = 0;
	
	@Parameters(value = { "login", "senha", "base" })
	@Test(testName = "id: 1 - Abrir rotina parc102")
	public void abrirParc102(String usuario, String senha, String base) {
		login = new LoginMetodos(this);
		login.logar(usuario, senha, base);
		espera.aguardarSistemaCarregar();
		rotina.selecionarRotina("arc102", "p");
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 2 - Não permitir adicionar uma atualização que já tenha sido aplicada no cliente", dependsOnMethods = {
			"abrirParc102" })
	public void naoPermitirAdicionarAtualizacaoJaAplicada() {
		acao.clicarNoElemento(campoCodigoAtualizacaoFilaAplicacao, posicaoCodigoAtualizacaoFilaAplicacao);
		while (!acao.localizarElementoNaPosicao(campoCodigoAtualizacaoFilaAplicacao, posicaoCodigoAtualizacaoFilaAplicacao).getAttribute("value")
				.isEmpty()) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			rotina.aguardarProcessarRotina();
			if (posicaoCodigoAtualizacaoFilaAplicacao != 12) {
				posicaoCodigoAtualizacaoFilaAplicacao++;
				posicaoCodigoClienteFilaAplicacao++;
			}
		}
		acao.escreverNoElemento(campoCodigoAtualizacaoFilaAplicacao, posicaoCodigoAtualizacaoFilaAplicacao, "4125");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoClienteFilaAplicacao, posicaoCodigoClienteFilaAplicacao, "201");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoSalvar);
		String mensagemJaAplicada = "Bases do cliente já estão em uma versão igual ou superior à atualização informada.";
		msg.aguardarMensagem(mensagemJaAplicada);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		msg.aguardarMensagemDesaparecer(mensagemJaAplicada);
	}

	@Test(testName = "id: 3 - Não permitir adicionar uma atualização inexistente", dependsOnMethods = {
			"naoPermitirAdicionarAtualizacaoJaAplicada" })
	public void naoPermitirAdicionarAtualizacaoInexistente() {
		acao.clicarNoElemento(campoCodigoAtualizacaoFilaAplicacao, posicaoCodigoAtualizacaoFilaAplicacao);
		rotina.aguardarProcessarRotina();
		acao.limparElementoNaPosicao(campoCodigoAtualizacaoFilaAplicacao, posicaoCodigoAtualizacaoFilaAplicacao);
		acao.escreverNoElemento(campoCodigoAtualizacaoFilaAplicacao, posicaoCodigoAtualizacaoFilaAplicacao, "0");
		acao.clicarNoElemento(rotina.botaoSalvar);
		rotina.aguardarProcessarRotina();
		String mensagemAtualizacaoInexistente = "Atualização inexistente ou não lançada.";
		msg.aguardarMensagem(mensagemAtualizacaoInexistente);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		msg.aguardarMensagemDesaparecer(mensagemAtualizacaoInexistente);
	}

	@Test(testName = "id: 4 - Permitir adicionar uma atualização que já tenha sido aplicada porem para outro cliente", dependsOnMethods = {
			"naoPermitirAdicionarAtualizacaoInexistente" })
	public void permitirAdicionarAtualizacaoParaClienteDiferente() {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoAtualizacaoFilaAplicacao, posicaoCodigoAtualizacaoFilaAplicacao);
		rotina.aguardarProcessarRotina();
		acao.limparElementoNaPosicao(campoCodigoAtualizacaoFilaAplicacao, posicaoCodigoAtualizacaoFilaAplicacao);
		acao.escreverNoElemento(campoCodigoAtualizacaoFilaAplicacao, posicaoCodigoAtualizacaoFilaAplicacao, "4125");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoClienteFilaAplicacao, posicaoCodigoClienteFilaAplicacao, "123");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}

	@Test(testName = "id: 5 - Não permitir adicionar uma atualização caso já exista uma requisição na fila que irá aplicá-la", dependsOnMethods = {
			"permitirAdicionarAtualizacaoParaClienteDiferente" })
	public void naoPermitirAdicionarAtualizacaoJaAdicionadaEPendente() {
		acao.clicarNoElemento(campoCodigoAtualizacaoFilaAplicacao, 0);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.F6);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoAtualizacaoFilaAplicacao, 1, "4125");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoClienteFilaAplicacao, 1, "123");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoSalvar);
		String atualizacaoJaExiste = "Já existe uma requisição de atualização (4125)";
		msg.aguardarMensagem(atualizacaoJaExiste);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		msg.aguardarMensagemDesaparecer(atualizacaoJaExiste);
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
		rotina.aguardarProcessarRotina();

	}

	@Test(testName = "id: 6 - Cancelar aplicacao da atualizacao", dependsOnMethods = {
			"naoPermitirAdicionarAtualizacaoJaAdicionadaEPendente" })
	public void excluirAtualizadaLista() {
		posicaoCodigoAtualizacaoFilaAplicacao = 0;
		acao.clicarNoElemento(campoCodigoAtualizacaoFilaAplicacao, posicaoCodigoAtualizacaoFilaAplicacao);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoCancelarAtualizacao, 0);
		msg.aguardarMensagem("Deseja cancelar a aplicação?");
		espera.aguardarElementoEstarVisivel(msg.simConfirmacao);
		acao.clicarNoElemento(msg.simConfirmacao);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemRegistrosAlterados);
	}

	@Test(testName = "id: 7 - Não deve permitir incluir atualizações que não tenham sido lançadas ou que tenham sido canceladas", dependsOnMethods = {
			"excluirAtualizadaLista" })
	public void naoPermitirLancarAtualizacaoCancelada() {
		acao.clicarNoElemento(campoCodigoAtualizacaoFilaAplicacao, posicaoCodigoAtualizacaoFilaAplicacao);
		while (!acao.localizarElementoNaPosicao(campoCodigoAtualizacaoFilaAplicacao, posicaoCodigoAtualizacaoFilaAplicacao).getAttribute("value")
				.isEmpty()) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			rotina.aguardarProcessarRotina();
			if (posicaoCodigoAtualizacaoFilaAplicacao != 12) {
				posicaoCodigoAtualizacaoFilaAplicacao++;
				posicaoCodigoClienteFilaAplicacao++;
			}
		}
		acao.escreverNoElemento(campoCodigoAtualizacaoFilaAplicacao, posicaoCodigoAtualizacaoFilaAplicacao, "3850");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		msg.aguardarMensagem("Atualização inexistente ou não lançada.");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		msg.aguardarMensagemDesaparecer("Atualização inexistente ou não lançada.");
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 8 - Ao clicar no botão para listar as atualizações aplicadas no cliente, deverá atualizar o bloco inferior.", dependsOnMethods = {
			"naoPermitirLancarAtualizacaoCancelada" })
	public void listarClientesQueEstaoComAAtualizacaoSelecionada() {
		Parc102 = new Parc102Metodos(this);
		int i = 0;
		while (i <= 5 || acao.localizarElementoNaPosicao(campoCodigoAtualizacaoFilaAplicacao, i).getAttribute("value").isEmpty()) {
			Parc102.listarClientes(i, rotina);
			i++;
		}
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemOperacaoNaoPermitida);
	}

	@Test(testName = "id: 9 - Ao clicar no botão para listar as atualizações aplicadas no cliente, deverá atualizar o bloco inferior.", dependsOnMethods = {
			"listarClientesQueEstaoComAAtualizacaoSelecionada" })
	public void listarAtualizacoesAplicadasNoCliente() {
		acao.clicarNoElemento(campoCodigoClienteFilaAplicacao, 0);
		rotina.aguardarProcessarRotina();
		rotina.limparCampoERealizarNovaConsulta();
		int i = 0;
		while (i < 5) {
			Parc102.listarAtualizacoes(i, rotina);
			i++;
		}
	}

	@Test(testName = "id: 10 - O bloco de atualizações aplicadas só permite consulta.", dependsOnMethods = {
			"listarAtualizacoesAplicadasNoCliente" })
	public void verificarSeBlocoDeAtualizcoesAplicadasPermiteApenasConsulta() {
		acao.clicarNoElemento(campoCodigoAtualizacaoFilaAplicacao, 0);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoAtualizacaoFilaAplicacao, 0, "4123");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.posicionarFocoNoElementoNaPosicao(rotina, botaoListarAtualizacoesAplicadasPorAtualizacao, 0);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoAtualizacaoAplicada, 0);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.F6);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemOperacaoNaoPermitida);
		teclado.pressionarTeclaDeControle(Keys.F4);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemOperacaoNaoPermitida);
		while (acao.localizarElementos(msg.mensagemOperacaoNaoPermitida).size() <= 0) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			rotina.aguardarProcessarRotina();
		}
	}

	@Test(testName = "id: 11 - Permitir consultar bloco atualizações aplicadas informando o codigo da atualização.", dependsOnMethods = {
			"verificarSeBlocoDeAtualizcoesAplicadasPermiteApenasConsulta" })
	public void permitirConsultarAtualizacoesAplicadasPeloCodigoAtualizacao() {
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemOperacaoNaoPermitida);
		acao.clicarNoElemento(campoCodigoAtualizacaoAplicada, 0);
		teclado.pressionarTeclaDeControle(Keys.F7);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoAtualizacaoAplicada, "4134");
		teclado.pressionarTeclaDeControle(Keys.F8);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoAtualizacaoAplicada, 0);
		while (acao.localizarElementos(msg.mensagemOperacaoNaoPermitida).size() <= 0) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			rotina.aguardarProcessarRotina();
			testar.passouSeAtributoDoElementoContem(campoCodigoAtualizacaoAplicada, "value", "4134");
		}
	}

	@Test(testName = "id: 11 - Permitir consultar bloco atualizações aplicadas informando o codigo da atualização.", dependsOnMethods = {
			"permitirConsultarAtualizacoesAplicadasPeloCodigoAtualizacao" })
	public void permitirConsultarAtualizacoesAplicadasPeloCodigoDoCliente() {
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemOperacaoNaoPermitida);
		acao.clicarNoElemento(campoClienteAtualizacaoAplicada, 0);
		teclado.pressionarTeclaDeControle(Keys.F7);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoLovClienteAplicadas);
		espera.aguardarElementoEstarVisivel(rotina.lov);
		acao.clicarNoElemento(rotina.selecionarValorLov("201"));
		espera.aguardarElementoDesaparecer(rotina.lov);
		teclado.pressionarTeclaDeControle(Keys.F8);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoClienteAtualizacaoAplicada, 0);
		while (acao.localizarElementos(msg.mensagemOperacaoNaoPermitida).size() <= 0) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			rotina.aguardarProcessarRotina();
			testar.passouSeAtributoDoElementoContem(campoClienteAtualizacaoAplicada, "value", "201");
		}
	}

	@Test(testName = "id: 12 - Caso a aplicação tenha sido executada com sucesso, o item na fila deverá ficar verde.", dependsOnMethods = {
			"permitirConsultarAtualizacoesAplicadasPeloCodigoDoCliente" })
	public void quandoAplicadaComSucessoOCampoDeveEstarComACorVerde() {
		testar.passouSeValorContem("rgba(161, 195, 165, 1)", 
				rotina.retornarBackGroundColorDeUmElemento(campoCodigoAtualizacaoFilaAplicacao, 0));
	}

}

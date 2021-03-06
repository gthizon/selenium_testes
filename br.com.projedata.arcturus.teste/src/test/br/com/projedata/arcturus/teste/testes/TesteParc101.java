package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.Parc101Elementos.campoBotaoAcaoDestino;
import static br.com.projedata.arcturus.teste.webelements.Parc101Elementos.campoBotaoAcaoWorkflow;
import static br.com.projedata.arcturus.teste.webelements.Parc101Elementos.campoBotaoParticipante;
import static br.com.projedata.arcturus.teste.webelements.Parc101Elementos.campoDescricaoAcao;
import static br.com.projedata.arcturus.teste.webelements.Parc101Elementos.campoFilaUnica;
import static br.com.projedata.arcturus.teste.webelements.Parc101Elementos.campoIdAcaoDestino;
import static br.com.projedata.arcturus.teste.webelements.Parc101Elementos.campoIdAcaoWorkflow;
import static br.com.projedata.arcturus.teste.webelements.Parc101Elementos.campoIdParticipante;
import static br.com.projedata.arcturus.teste.webelements.Parc101Elementos.campoTipoAcao;
import static br.com.projedata.arcturus.teste.webelements.Parc101Elementos.campoTipoEspecial;

import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.Pger001Metodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;
import br.com.projedata.arcturus.teste.webelements.AtualizadorElementos;

public class TesteParc101 extends TesteGenerico {

	LoginMetodos login;
	AtualizadorElementos atualizador;
	Pger001Metodos ger001;
	String codigoMenuCriado;
	int posicaoAcao = 0;

	int posicaoParticipante = 0;
	int posicaoTipoItem = 0;

	@Parameters(value = { "login", "senha", "base" })
	@Test(testName = "id: 1 - Abrir Parc101")
	public void abrirParc101(String usuario, String senha, String base) {
		login = new LoginMetodos(this);
		login.logar(usuario, senha, base);
		rotina.selecionarRotina("arc101");
	}

	@Test(testName = "id: 2 - Inserir novo registro Parc101", dependsOnMethods = { "abrirParc101" })
	public void inserirNovaAcao() {
		while (!acao.localizarElementoNaPosicao(campoDescricaoAcao, posicaoAcao).getAttribute("value").isEmpty()) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			if (posicaoAcao < 3) {
				posicaoAcao++;
			}
		}

		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoDescricaoAcao, posicaoAcao);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoDescricaoAcao, posicaoAcao, "Ação Teste");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoTipoAcao, posicaoAcao, "Validar");
		acao.selecionarNoElemento(campoTipoEspecial, posicaoAcao, "Ação Final");
		acao.selecionarNoElemento(campoFilaUnica, posicaoAcao, "Sim");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}

	@Test(testName = "id: 3 - Consultar a ação cadastrada", dependsOnMethods = { "inserirNovaAcao" })
	public void consultarAcaoCadastrada() {

		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoDescricaoAcao, "Ação Teste");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 4 - Inserir participante", dependsOnMethods = { "consultarAcaoCadastrada" })
	public void inserirParticipante() {

		acao.clicarNoElemento(campoIdParticipante, 0);
		teclado.pressionarTeclaDeControle(Keys.F6);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoBotaoParticipante);
		espera.aguardarElementoEstarVisivel(rotina.lov);
		rotina.filtrarESelecionarValorNaLov("JULIETI");
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();

	}

	@Test(testName = "id: 4 - Inserir 3 ações Destino", dependsOnMethods = { "inserirParticipante" })
	public void inserirAcoesDestino() {

		acao.clicarNoElemento(campoIdAcaoDestino, 0);
		teclado.pressionarTeclaDeControle(Keys.F6);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoBotaoAcaoDestino);
		espera.aguardarElementoEstarVisivel(rotina.lov);
		rotina.filtrarESelecionarValorNaLov("Validar");
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();

		acao.clicarNoElemento(campoIdAcaoDestino, 1);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoIdAcaoDestino, 1, "3");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();

		acao.clicarNoElemento(campoIdAcaoDestino, 2);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoIdAcaoDestino, 2, "1");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();

	}

	@Test(testName = "id: 4 - Inserir ação Workflow", dependsOnMethods = { "inserirAcoesDestino" })
	public void inserirAcaoWorkflow() {

		acao.clicarNoElemento(campoIdAcaoWorkflow, 0);
		teclado.pressionarTeclaDeControle(Keys.F6);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoBotaoAcaoWorkflow);
		espera.aguardarElementoEstarVisivel(rotina.lov);
		rotina.filtrarESelecionarValorNaLov("Avaliar");
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();

	}

	@Test(testName = "id: 5 - excluirAcao", dependsOnMethods = { "inserirAcaoWorkflow" })
	public void excluirAcao() {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoDescricaoAcao, 0);
		posicaoAcao = 0;
		rotina.aguardarProcessarRotina();
		while (!acao.localizarElementoNaPosicao(campoDescricaoAcao, posicaoAcao).getAttribute("value").equals("Ação Teste")) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			rotina.aguardarProcessarRotina();
			posicaoAcao++;
		}
		acao.posicionarFocoNoElemento(rotina, campoIdParticipante);
		rotina.aguardarProcessarRotina();
		rotina.excluirESalvar();
		rotina.aguardarProcessarRotina();

		while (!acao.localizarElementoNaPosicao(campoIdAcaoDestino, 0).getAttribute("value").isEmpty()) {
			acao.posicionarFocoNoElemento(rotina, campoIdAcaoDestino);
			rotina.aguardarProcessarRotina();
			rotina.excluirESalvar();
		}

		acao.posicionarFocoNoElemento(rotina, campoIdAcaoWorkflow);
		rotina.aguardarProcessarRotina();
		rotina.excluirESalvar();

		acao.clicarNoElemento(campoDescricaoAcao, 0);
		rotina.aguardarProcessarRotina();
		rotina.excluirESalvar();
	}

	@Test(testName = "id: 6 - Consultar a ação cadastrada", dependsOnMethods = { "excluirAcao" })
	public void consultarAcao() {
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoDescricaoAcao, "Ação Teste");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
	}

}
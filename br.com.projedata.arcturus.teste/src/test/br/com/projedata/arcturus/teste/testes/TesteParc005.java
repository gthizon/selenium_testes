package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.Parc005Elementos.botaoCarregarRotinas;
import static br.com.projedata.arcturus.teste.webelements.Parc005Elementos.campoAcessoTotal;
import static br.com.projedata.arcturus.teste.webelements.Parc005Elementos.campoCodigoRotina;
import static br.com.projedata.arcturus.teste.webelements.Parc005Elementos.campoCodigoSistema;
import static br.com.projedata.arcturus.teste.webelements.Parc005Elementos.campoDescricaoSistema;
import static br.com.projedata.arcturus.teste.webelements.Parc005Elementos.campoIdSistema;

import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class TesteParc005 extends TesteGenerico {

	LoginMetodos login;
	String codigoSistemaInserido;

	@Parameters(value = { "login2", "senha", "base" })
	@Test(testName = "id: 1 - Abrir rotina parc005")
	public void abrirParc005(String usuario, String senha, String base) {
		login = new LoginMetodos(this);
		login.logar(usuario, senha, base);
		espera.aguardarSistemaCarregar();
		rotina.selecionarRotina("arc005");
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 2 - Inserir novo sistema com acesso total", dependsOnMethods = { "abrirParc005" })
	public void inserirSistemaComAcessoTotal() {
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoSistema(1));
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.F6);
		acao.escreverNoElemento(campoCodigoSistema(2), "1");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoDescricaoSistema(2), "teste autom");
		acao.selecionarNoElemento(campoAcessoTotal(2), "Sim");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		testar.passouSeElementoEstiverDesabilitado(botaoCarregarRotinas(2));
		codigoSistemaInserido = acao.localizarElemento(campoIdSistema(2)).getAttribute("value");
	}

	@Test(testName = "id: 3 - Inserir novo sistema com acesso restrito", dependsOnMethods = {
			"inserirSistemaComAcessoTotal" })
	public void inserirSistemaComAcessoRestrito() {
		acao.selecionarNoElemento(campoAcessoTotal(2), "Não");
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		espera.aguardarElementoEstarHabilitado(botaoCarregarRotinas(2));
	}

	@Test(testName = "id: 4 - Clicar para carregar rotinas ", dependsOnMethods = { "inserirSistemaComAcessoRestrito" })
	public void carregarRotinasPorSistema() {
		acao.clicarNoElemento(rotina, botaoCarregarRotinas(2));
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		espera.aguardarElementoNaoEstarVazio(campoCodigoRotina(1), 0, "value");
	}

	@Test(testName = "id: 5 - Excluir rotinas do sistema", dependsOnMethods = { "carregarRotinasPorSistema" })
	public void excluirRotinasCarregadas() {
		acao.clicarNoElemento(campoCodigoRotina(1));
		while (!acao.localizarElemento(campoCodigoRotina(1)).getAttribute("value").isEmpty()) {
			teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
		}
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}

	@Test(testName = "id: 6 - Tentar inserir rotina para um sistema que esteja como acesso total.", dependsOnMethods = {
			"excluirRotinasCarregadas" })
	public void tentarAdicionarRotinaEmSistemaComAcessoTotal() {
		acao.clicarNoElemento(campoAcessoTotal(1));
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoIdSistema(1), codigoSistemaInserido);
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoAcessoTotal(1), "Sim");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		acao.clicarNoElemento(campoCodigoRotina(1));
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoRotina(1), "1");
		espera.aguardarElementoEstarVazio(campoCodigoRotina(1));
	}

	@Test(testName = "id: 7 - Excluir sistema adicionado.", dependsOnMethods = {
			"tentarAdicionarRotinaEmSistemaComAcessoTotal" })
	public void excluirSistema() {
		acao.clicarNoElemento(campoCodigoSistema(1));
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoExcluir);
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}

}

package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.Parc007Elementos.campoCodigo;
import static br.com.projedata.arcturus.teste.webelements.Parc007Elementos.campoFormaExibicao;
import static br.com.projedata.arcturus.teste.webelements.Parc007Elementos.campoFormato;
import static br.com.projedata.arcturus.teste.webelements.Parc007Elementos.campoId;
import static br.com.projedata.arcturus.teste.webelements.Parc007Elementos.campoLargura;
import static br.com.projedata.arcturus.teste.webelements.Parc007Elementos.campoNome;
import static br.com.projedata.arcturus.teste.webelements.Parc007Elementos.campoTamanho;
import static br.com.projedata.arcturus.teste.webelements.Parc007Elementos.campoTipoSelecao;

import java.awt.AWTException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.Pger001Metodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;
import br.com.projedata.arcturus.teste.webelements.AtualizadorElementos;

public class TesteParc007 extends TesteGenerico {

	LoginMetodos login;
	AtualizadorElementos atualizador;
	Pger001Metodos ger001;
	String idRegistro;

	@Parameters(value = { "url2" })
	@Test(testName = "id: 1 - Criar filtro na base homo e verificar se sera colocado o cl na frente do nome")
	public void testarCriacaoDeFiltroEmCliente(String url2) throws AWTException, InterruptedException {
		login = new LoginMetodos(this);
		login.aguardarTelaLogin();
		navegador.irParaNovaUrlEmNovaAba(url2);
		login.logar("usuario", "usuario", "homologacao");
		rotina.selecionarRotina("arc007", "p");
		acao.escreverNoElemento(campoCodigo, "automacao");
		acao.escreverNoElemento(campoNome, "teste automação");
		acao.selecionarNoElemento(campoFormato, "Texto");
		acao.escreverNoElemento(campoTamanho, "10");
		acao.escreverNoElemento(campoLargura, "10");
		acao.selecionarNoElemento(campoTipoSelecao, "Texto");
		acao.selecionarNoElemento(campoFormaExibicao, "Ambos");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		rotina.aguardarProcessarRotina();
		idRegistro = acao.localizarElemento(campoId).getAttribute("value").toString();
		testar.passouSeAtributoDoElementoContem(campoCodigo, "value", "cl_automacao");
	}

	@Test(testName = "id: 2 - Excluir filtro criado", dependsOnMethods = { "testarCriacaoDeFiltroEmCliente" })
	public void excluirFiltro() {
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoId, idRegistro);
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		rotina.excluirESalvar();
		sairPortal();
		
	}

	@Parameters(value = { "login", "senha", "base", "url" })
	@Test(testName = "id: 3 - Criar filtro na base do arcturus", dependsOnMethods = { "excluirFiltro" })
	public void cadastrarNovoFiltro(String log, String senha, String base, String url) throws AWTException, InterruptedException {
		navegador.alterarUrl(url);
		login.logar(log, senha, base);
		rotina.selecionarRotina("arc007");
		acao.escreverNoElemento(campoCodigo, "automacao");
		acao.escreverNoElemento(campoNome, "teste automação");
		acao.selecionarNoElemento(campoFormato, "Texto");
		acao.escreverNoElemento(campoTamanho, "10");
		acao.escreverNoElemento(campoLargura, "10");
		acao.selecionarNoElemento(campoTipoSelecao, "Texto");
		acao.selecionarNoElemento(campoFormaExibicao, "Ambos");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		rotina.aguardarProcessarRotina();
		idRegistro = acao.localizarElemento(campoId).getAttribute("value").toString();
	}

	@Test(testName = "id: 4 - Consultar filtros", dependsOnMethods = { "cadastrarNovoFiltro" })
	public void consultarFiltros() {
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(rotina.rotinaCarregada);
		acao.clicarNoElemento(campoCodigo, 0);
		rotina.aguardarProcessarRotina();
		int i = 0;
		while (i <= 10) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			rotina.aguardarProcessarRotina();
			testar.passouSeAtributoDoElementoNaoForNulo(campoCodigo, i, "value");
			i++;
		}
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoId, idRegistro);
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(rotina.rotinaCarregada);
		espera.aguardarAtributoDoElementoConterOValor(campoNome, 0, "value", "teste automação");
		espera.aguardarAtributoDoElementoConterOValor(campoCodigo, 0, "value", "automacao");
	}
	
	@Test(testName = "id: 5 - Excluir filtros", dependsOnMethods = { "consultarFiltros" })
	public void excluirFiltroArcturus() {
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoId, idRegistro);
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		rotina.excluirESalvar();
	}
}

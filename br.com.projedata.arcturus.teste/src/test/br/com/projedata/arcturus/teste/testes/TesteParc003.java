package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.*;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.imagemNaLov;
import static br.com.projedata.arcturus.teste.webelements.Parc003Elementos.*;
import static br.com.projedata.arcturus.teste.webelements.Parc003Elementos.campoComandoExibicaoLista;
import static br.com.projedata.arcturus.teste.webelements.Parc003Elementos.campoComandoListagemLista;
import static br.com.projedata.arcturus.teste.webelements.Parc003Elementos.campoIdLista;
import static br.com.projedata.arcturus.teste.webelements.Parc003Elementos.campoNomeLista;
import static br.com.projedata.arcturus.teste.webelements.Parc003Elementos.campoTipoImagemLov;
import static br.com.projedata.arcturus.teste.webelements.Parc003Elementos.campoTipoLista;
import static br.com.projedata.arcturus.teste.webelements.Parc003Elementos.campoValorLista;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.Pger001Metodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;
import br.com.projedata.arcturus.teste.webelements.AtualizadorElementos;

public class TesteParc003 extends TesteGenerico {

	LoginMetodos login;
	AtualizadorElementos atualizador;
	Pger001Metodos ger001;
	String codigoAgendamento;

	@Parameters(value = { "login2", "senha", "base" })
	@Test(testName = "id: 1 - Abrir Parc003")
	public void abrirParc003(String usuario, String senha, String base) {
		login = new LoginMetodos(this);
		login.logar(usuario, senha, base);
		rotina.selecionarRotina("arc003");
	}

	@Test(testName = "id: 2 - Testar lov com imagem", dependsOnMethods = { "abrirParc003" }, enabled = true)
	public void testarLovComImagem() {
		rotina.selecionarRotina("teste015");
		acao.clicarNoElemento(botaoAbrirLovImagem);
		espera.aguardarElementoEstarVisivel(rotina.lov);
		acao.escreverNoElemento(rotina.filtrarLov, "gustavo");
		espera.aguardarElementoEstarVisivel(imagemNaLov);
		acao.clicarNoElemento(rotina.fecharLov);
		espera.aguardarElementoDesaparecer(rotina.lov);
		rotina.fecharRotina("teste015");
	}
	
	@Test(testName = "id: 6 - Testar quantidade de 5 registros exibidos na lov", dependsOnMethods = { "testarLovComImagem" }, enabled = true)
	public void testarQuantidadeDe5Registros() {
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoIdLista, "93");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.limparElemento("arclistaQuantidadeRegistros");
		acao.escreverNoElemento("arclistaQuantidadeRegistros","5");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		rotina.selecionarRotina("teste015");
		acao.clicarNoElemento(botaoAbrirLovImagem);
		rotina.aguardarLovProcessar();
		int total = acao.retornarQuantidadeDeRegistros(By.xpath("//div[@class='lov-modal-componente']//tbody/tr"));
		testar.passouSeValoresSaoIguais(total, 5);
		acao.clicarNoElemento(rotina.fecharLov);
		espera.aguardarElementoDesaparecer(rotina.lov);
		rotina.fecharRotina("teste015");
	}
	
	@Test(testName = "id: 7 - Testar quantidade de 20 registros exibidos na lov", dependsOnMethods = { "testarQuantidadeDe5Registros" }, enabled = true)
	public void testarQuantidadeDe20Registros() {
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoIdLista, "93");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.limparElemento("arclistaQuantidadeRegistros");
		acao.escreverNoElemento("arclistaQuantidadeRegistros","20");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		rotina.selecionarRotina("teste015");
		acao.clicarNoElemento(botaoAbrirLovImagem);
		rotina.aguardarLovProcessar();
		int total = acao.retornarQuantidadeDeRegistros(By.xpath("//div[@class='lov-modal-componente']//tbody/tr"));
		testar.passouSeValoresSaoIguais(total, 20);
		acao.clicarNoElemento(rotina.fecharLov);
		espera.aguardarElementoDesaparecer(rotina.lov);
		rotina.fecharRotina("teste015");
		
	}

	@Test(testName = "id: 3 - Selecionar a lov e desabilitar o tipo imagem e verificar se nao sera exibida", dependsOnMethods = {
			"testarQuantidadeDe20Registros" }, enabled = true)
	public void desabilitarTipoImagemDaLov() {
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoIdLista, "93");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoSerClicavel(campoTipoImagemLov);
		acao.clicarNoElemento(campoTipoImagemLov);
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		rotina.selecionarRotina("teste015");
		acao.clicarNoElemento(botaoAbrirLovImagem);
		espera.aguardarElementoEstarVisivel(rotina.lov);
		acao.escreverNoElemento(rotina.filtrarLov, "gustavo");
		espera.aguardarElementoNaoEstarVisivel(imagemNaLov);
		acao.clicarNoElemento(rotina.fecharLov);
		espera.aguardarElementoDesaparecer(rotina.lov);
		rotina.fecharRotina("teste015");
		acao.clicarNoElemento(campoTipoImagemLov);
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}

	@Test(testName = "id: 4 - Inserir nova lista", dependsOnMethods = { "desabilitarTipoImagemDaLov" }, enabled = true)
	public void inserirNovaLista() {
		rotina.aguardarProcessarRotina();
		rotina.limparCampoERealizarNovaConsulta();
		acao.clicarNoElemento(campoIdLista);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.F6);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoNomeLista, "teste automacao");
		acao.selecionarNoElemento(campoTipoLista, "LOV");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		String sql = "SELECT id, numero_os, inicio FROM wkfos";
		acao.escreverNoElemento(campoComandoExibicaoLista, sql);
		acao.clicarNoElemento(campoComandoListagemLista);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoComandoListagemLista, sql);
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		acao.clicarNoElemento(BotaoCarregarLista);
		msg.aguardarMensagem("Valores carregados com sucesso!");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		msg.aguardarMensagemDesaparecer("Valores carregados com sucesso!");
		testar.passouSeAtributoDoElementoNaoForNulo(campoValorLista, "value");
	}

	@Test(testName = "id: 5 - Excluir lista", dependsOnMethods = { "inserirNovaLista" }, enabled = true)
	public void excluirLista() {
		acao.limparElemento(campoComandoExibicaoLista);
		acao.limparElemento(campoComandoListagemLista);
		acao.clicarNoElemento(rotina, campoValorLista, 0);
		rotina.aguardarProcessarRotina();
		while (!acao.localizarElementoNaPosicao(campoValorLista, 0).getAttribute("value").isEmpty()) {
			teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
			rotina.aguardarProcessarRotina();
		}
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		acao.clicarNoElemento(campoIdLista);
		rotina.excluirESalvar();
	}

}

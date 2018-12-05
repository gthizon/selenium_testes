package br.com.projedata.arcturus.teste.testes;

import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class TesteParc118 extends TesteGenerico {

	LoginMetodos log;

	@Parameters(value = { "login", "senha", "base" })
	@Test(testName = "id: 1 - Abrir rotina Parc118.")
	public void abrirParc118(String login, String senha, String base) {
		log = new LoginMetodos(this);
		log.logar(login, senha, base);
		rotina.selecionarRotina("arc118");
	}

	@Test(testName = "id: 2 - Selecionar base e lançar atualização", dependsOnMethods = { "abrirParc118" })
	public void selecionarBaseParaLancarAtualizacao() {
		acao.abrirLov(rotina, "FILTRO_CLIENTEId_cliente");
		acao.clicarNoElemento(rotina.selecionarValorLov("cliente"));
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer(rotina.lov);
		acao.posicionarFocoNoElemento(rotina, "nomeAmbiente-1");
		acao.selecionarNoElemento("nomeAmbiente-1", "Principal");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "ARCBASENome-1");
		acao.selecionarNoElemento("FILTROSNome_situacao_atualizacao-1", "Lançar");
		rotina.aguardarProcessarRotina();
		espera.aguardarAtributoDoElementoConterOValor("campoIdAtualizacao-1", "value", "32");
		acao.clicarNoElemento(rotina, "campoIdAtualizacao-1");
		acao.clicarNoElemento(rotina, "atualizacao_selecionada-1");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarSelecionado("atualizacao_selecionada-1");
		acao.clicarNoElemento("BotaoAplicar");
		espera.aguardarElementoEstarVisivel(msg.retornarMensagemNotificacao("atualização aplicada"));
		rotina.fecharRotina("arc118");
	}

	@Test(testName = "id: 3 - Abrir a parc115 e lançar a atualização", dependsOnMethods = { "selecionarBaseParaLancarAtualizacao" })
	public void lancarAtualizacao() {
		rotina.selecionarRotina("arc115");
		acao.clicarNoElemento(rotina, rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento("arcatualizacaoId-1", "32");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "botaoLancar-1");
		espera.aguardarElementoEstarVisivel(msg.simConfirmacao);
		acao.clicarNoElemento(msg.simConfirmacao);
		espera.aguardarElementoDesaparecer(msg.simConfirmacao);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel("botaoFinalizado");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
	}

	@Test(testName = "id: 4 - Verificar na parc118 se atualização foi lançada", dependsOnMethods = {"lancarAtualizacao"})
	public void verificarAtualizacaoLancada() {
		String versao = acao.retornarValorDoElemento("arcatualizacaoVersaoGerada") + " - 32";
		rotina.fecharRotina("arc115");
		rotina.selecionarRotina("arc118");
		acao.abrirLov(rotina, "FILTRO_CLIENTEId_cliente");
		acao.clicarNoElemento(rotina.selecionarValorLov("cliente"));
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer(rotina.lov);
		acao.posicionarFocoNoElemento(rotina, "nomeAmbiente-1");
		acao.selecionarNoElemento("nomeAmbiente-1", "Principal");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "ARCBASENome-1");
		acao.selecionarNoElemento("FILTROSNome_situacao_atualizacao-1", "Lançado");
		rotina.aguardarProcessarRotina();
		int i = 0;
		while (i < 9 && !acao.retornarValorDoElementoNaPosicao("campoIdAtualizacao", i).equals(versao)) {
			i++;
		}
		if (i == 9) {
			testar.testeFalhou();
		}
	}

}

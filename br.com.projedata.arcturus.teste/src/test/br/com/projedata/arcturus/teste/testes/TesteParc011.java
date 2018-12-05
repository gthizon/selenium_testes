package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.Parc011Elementos.campoCodigo;
import static br.com.projedata.arcturus.teste.webelements.Parc011Elementos.campoId;
import static br.com.projedata.arcturus.teste.webelements.Parc011Elementos.campoNome;
import static br.com.projedata.arcturus.teste.webelements.Parc011Elementos.campoOrdem;
import static br.com.projedata.arcturus.teste.webelements.Parc011Elementos.campoSituacao;

import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.Pger001Metodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;
import br.com.projedata.arcturus.teste.webelements.AtualizadorElementos;

public class TesteParc011 extends TesteGenerico {

	LoginMetodos log;
	AtualizadorElementos atualizador;
	Pger001Metodos ger001;
	String idRegistro;

	@Parameters(value = { "login", "senha", "base" })
	@Test(testName = "id: 1 - Abrir rotina Parc011.")
	public void abrirParc011(String login, String senha, String base) {
		log = new LoginMetodos(this);
		log.logar(login, senha, base);
		rotina.selecionarRotina("arc011");
	}
	
	@Test(testName = "id: 2 - Inserir nova área.", dependsOnMethods = {"abrirParc011"})
	public void inserirNovaArea() {
		teclado.pressionarTeclaDeControle(Keys.F6);
		acao.escreverNoElemento(campoCodigo, 1, "automação");
		acao.escreverNoElemento(campoNome, 1, "automação teste");
		acao.escreverNoElemento(campoSituacao, 1, "Ativo");
		acao.escreverNoElemento(campoOrdem, 1, "10");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		idRegistro = acao.localizarElementoNaPosicao(campoId, 1).getAttribute("value");
	}
	
	@Test(testName = "id: 3 - Editar nova área.", dependsOnMethods = {"inserirNovaArea"})
	public void editarNovaArea() {
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoId, idRegistro);
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.limparElemento(campoNome);
		acao.escreverNoElemento(campoNome, "teste automação");
		acao.selecionarNoElemento(campoSituacao, "Inativo");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}
	
	@Test(testName = "id: 4 - Excluir área.", dependsOnMethods = {"editarNovaArea"})
	public void excluirArea() {
		rotina.excluirESalvar();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoId, idRegistro);
		acao.clicarNoElemento(rotina.botaoConsultar);
		msg.aguardarMensagem("Registro não localizado.");
	}

}

package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.Parc009Elementos.campoChave;
import static br.com.projedata.arcturus.teste.webelements.Parc009Elementos.campoConteudo;
import static br.com.projedata.arcturus.teste.webelements.Parc009Elementos.campoDescricao;
import static br.com.projedata.arcturus.teste.webelements.Parc009Elementos.campoId;
import static br.com.projedata.arcturus.teste.webelements.Parc009Elementos.campoNome;
import static br.com.projedata.arcturus.teste.webelements.Parc009Elementos.campoNomeObjetoNegocio;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.botaoExecutarHabilitado;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.Pger001Metodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class TesteParc009 extends TesteGenerico {

	LoginMetodos login;
	Pger001Metodos ger001;
	String codigoBibliteca;

	@Parameters(value = { "login2", "senha", "base" })
	@Test(testName = "id: 1 - Abrir Parc009")
	public void abrirParc009(String usuario, String senha, String base) {
		login = new LoginMetodos(this);
		login.logar(usuario, senha, base);
		rotina.selecionarRotina("arc009");
		ger001 = new Pger001Metodos(this);
	}
	
	@Test(testName = "id: 2 - Inserir bilbioteca", dependsOnMethods = {"abrirParc009"})
	public void inserirNovaBiblioteca() {
		acao.escreverNoElemento(campoChave, "teste automacao");
		acao.escreverNoElemento(campoNome, "automação");
		acao.escreverNoElemento(campoDescricao, "descricao");
		acao.escreverNoElemento(campoConteudo, "iNSERIRTESTEUSUARIO.inserirTesteUsuario();");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		acao.escreverNoElemento(campoNomeObjetoNegocio, "INSERIRTESTEUSUARIO");
		acao.posicionarFocoNoElemento(rotina, rotina.botaoSalvar);
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		codigoBibliteca = acao.localizarElemento(campoId).getAttribute("value");
	}
	
	@Test(testName = "id: 3 - Editar bilbioteca", dependsOnMethods = {"inserirNovaBiblioteca"})
	public void alterarBiblioteca() {
		acao.clicarNoElemento(campoChave);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoId, codigoBibliteca);
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoNome);
		rotina.aguardarProcessarRotina();
		acao.limparElemento(campoNome);
		acao.escreverNoElemento(campoNome, "alteração");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}
	
	@Test(testName = "id: 4 - Excluir bilbioteca", dependsOnMethods = {"alterarBiblioteca"})
	public void excluirBiblioteca() {
		acao.clicarNoElemento(campoNomeObjetoNegocio);
		rotina.aguardarProcessarRotina();
		rotina.excluirESalvar();
		acao.clicarNoElemento(campoId);
		rotina.aguardarProcessarRotina();
		rotina.excluirESalvar();
		rotina.fecharRotina("arc009");
	}
	
	@Test(testName = "id: 5 - Vincular um objeto a biblioteca e verificar se sera utilizado corretamente. Emitir um relatorio que possua a consulta.", dependsOnMethods = {"excluirBiblioteca"})
	public void verificarSeObjetoDeNegocioEhExecutado() throws InvalidPasswordException, IOException {
		rotina.selecionarRotina("ger001");
		ger001.selecionarRelatorioParaEdicao("rger19");
		espera.aguardarElementoEstarVisivel(botaoExecutarHabilitado);
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		acao.clicarNoElemento(rotina.botaoProcessarFiltros);
		String conteudo = rotina.retornarConteudoDoPdf();
		testar.passouSeValorContem(conteudo,"1000teste lista automatacao");
	}

}

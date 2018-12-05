package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.Parc103Elementos.campoNomeSistema;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class TesteParc103 extends TesteGenerico {

	LoginMetodos login;
	String codigoSistemaInserido;
	
	@Parameters(value = { "login", "senha", "base" })
	@Test(testName = "id: 1 - Abrir rotina parc103")
	public void abrirParc103(String usuario, String senha, String base) {
		login = new LoginMetodos(this);
		login.logar(usuario, senha, base);
		espera.aguardarSistemaCarregar();
		rotina.selecionarRotina("arc103", "p");
		rotina.aguardarProcessarRotina();
	}
	
	@Test(testName = "id: 2 - Verificar titulo da pagina quando estiver configurado o nome do sistema na arc103", dependsOnMethods = {"abrirParc103"})
	public void exibirTituloConformeSistemaCadastrado() {
		String nomePagina = navegador.retornarTituloDaPagina();
		testar.passouSeValorContem(nomePagina, acao.localizarElemento(campoNomeSistema).getAttribute("value"));
	}
	
	@Test(testName = "id: 3 - Verificar titulo da pagina apos alterar o nome do sistema na arc103", dependsOnMethods = {"exibirTituloConformeSistemaCadastrado"})
	public void exibirTituloConformeNomeSistemaAlterado() {
		acao.limparElemento(campoNomeSistema);
		acao.escreverNoElemento(campoNomeSistema, "Automacao");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		sairPortal();
		navegador.atualizarBrowser();
		login.aguardarTelaLogin();
		String pagina = navegador.retornarTituloDaPagina();
		testar.passouSeValorContem(pagina, "Automacao");
	}
	
	@Parameters(value = { "login", "senha", "base" })
	@Test(testName = "id: 4 - Verificar titulo da pagina quando o nome do sistema na arc103 nao estiver preenchido", dependsOnMethods = {"exibirTituloConformeNomeSistemaAlterado"})
	public void exibirTituloQuandoCampoNomeSistemaNaoEstiverInformado(String usuario, String senha, String base) {
		login.logar(usuario, senha, base);
		espera.aguardarSistemaCarregar();
		rotina.selecionarRotina("arc103", "p");
		rotina.aguardarProcessarRotina();
		acao.limparElemento(campoNomeSistema);
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		sairPortal();
		navegador.atualizarBrowser();
		login.aguardarTelaLogin();
		String pagina = navegador.retornarTituloDaPagina();
		testar.passouSeValorContem(pagina, "Arcturus");
		
		login.logar(usuario, senha, base);
		espera.aguardarSistemaCarregar();
		rotina.selecionarRotina("arc103", "p");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoNomeSistema, "Tubarão");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}

}

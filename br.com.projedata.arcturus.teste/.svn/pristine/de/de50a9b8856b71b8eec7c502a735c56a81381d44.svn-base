package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.abaBases;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.abaConexoes;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.abaCorrentistas;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoAtivaBase;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoCnpjCorrentista;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoConexaoLocal;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoDescricaoBase;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoEnderecoBase;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoEnderecoConexao;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoExterno;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoNome;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoNomeAmbiente;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoNomeBase;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoNomeCliente;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoNomeConexao;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoNomeCorrentista;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoPadrao;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoPermiteAtualizacao;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoPortaBase;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoPortaConexao;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoSenhaAcesso;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoSenhaAdmin;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoSenhaSo;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoSituacao;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoSituacaoAmbiente;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoSituacaoConexao;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoTipoAmbiente;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoTipoBase;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoTipoConexao;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoUsuarioAcesso;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoUsuarioAdmin;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoUsuarioSO;
import static br.com.projedata.arcturus.teste.webelements.Parc100Elementos.campoVisivelBase;

import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.Pger001Metodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;
import br.com.projedata.arcturus.teste.webelements.AtualizadorElementos;

public class TesteParc100 extends TesteGenerico{
	

	LoginMetodos login;
	AtualizadorElementos atualizador;
	Pger001Metodos ger001;
	String codigoMenuCriado;
	
	int posicaoCliente = 0;
	int posicaoConexao = 0;
	int posicaoCorrentista = 0;
	int posicaoBase = 0;


	@Parameters(value = { "login", "senha", "base" })
	@Test(testName = "id: 1 - Abrir Parc100")
	public void abrirParc100(String usuario, String senha, String base) {
		login = new LoginMetodos(this);
		login.logar(usuario, senha, base);
		rotina.selecionarRotina("arc100");
	}
	
	@Test(testName = "id: 2 - Inserir novo cliente Parc100", dependsOnMethods = { "abrirParc100" })
	public void inserirNovaAcao() {
		while (!acao.localizarElementoNaPosicao(campoNomeCliente, posicaoCliente).getAttribute("value").isEmpty()) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			if (posicaoCliente < 9) {
				posicaoCliente++;
			}
		}

		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoNomeCliente, posicaoCliente);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoNomeCliente, posicaoCliente, "Novo Cliente");
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoSituacao, posicaoCliente, "Ativo");
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoPadrao, posicaoCliente, "Não");
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoExterno, posicaoCliente, "Não");
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoPermiteAtualizacao, posicaoCliente, "Sim");
		
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}
	
	@Test(testName = "id: 3 - Inserir Dados da conexão", dependsOnMethods = { "inserirNovaAcao" })
	public void inserirConexao() {
		while (!acao.localizarElementoNaPosicao(campoNomeConexao, posicaoConexao).getAttribute("value").isEmpty()) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			if (posicaoConexao < 3) {
				posicaoConexao++;
			}
		}

		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoNomeConexao, posicaoConexao);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoNomeConexao, posicaoConexao, "teste");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoEnderecoConexao, posicaoConexao, "192.168.1.10");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoPortaConexao, posicaoConexao, "8080");
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoTipoConexao, posicaoConexao, "Aplicação");
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoSituacaoConexao, posicaoConexao, "Ativo");
		
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}
	
	
	@Test(testName = "id: 3 - Inserir Correntista ao Cliente", dependsOnMethods = { "inserirConexao" })
	public void inserirCorrentista() {
		while (!acao.localizarElementoNaPosicao(campoNomeCorrentista, posicaoCorrentista).getAttribute("value").isEmpty()) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			if (posicaoCorrentista < 14) {
				posicaoCorrentista++;
			}
		}

		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(abaCorrentistas);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoNomeCorrentista, posicaoCorrentista);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoNomeCorrentista, posicaoCorrentista, "Novo Correntista");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCnpjCorrentista, posicaoCorrentista, "25625685478");
		rotina.aguardarProcessarRotina();
		
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}
	
	
	@Test(testName = "id: 3 - Inserir Base", dependsOnMethods = { "inserirCorrentista" })
	public void inserirBase() {
		while (!acao.localizarElementoNaPosicao(campoNomeAmbiente, posicaoBase).getAttribute("value").isEmpty()) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			if (posicaoBase < 3) {
				posicaoBase++;
			}
		}

		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(abaBases);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoNomeAmbiente, posicaoBase);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoNomeAmbiente, posicaoBase, "Novo Ambiente");
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoSituacaoAmbiente, posicaoBase, "Ativo");
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoTipoAmbiente, posicaoBase, "Teste");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoNome, posicaoBase);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoNome, posicaoBase, "Nova Base");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoDescricaoBase, posicaoBase, "Base");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoEnderecoBase, posicaoBase, "bd.prj");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoPortaBase, posicaoBase, "1521");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoNomeBase, posicaoBase, "base");
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoAtivaBase, posicaoBase, "Sim");
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoVisivelBase, posicaoBase, "Sim");
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoConexaoLocal, posicaoBase, "Não");
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoTipoBase, posicaoBase, "Banco de Dados");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoUsuarioAdmin, posicaoBase, "baseadmin");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoSenhaAdmin, posicaoBase, "12345");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoUsuarioAcesso, posicaoBase, "base");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoSenhaAcesso, posicaoBase, "54321");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoUsuarioSO, posicaoBase, "Basebase");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoSenhaSo, posicaoBase, "123123");
		rotina.aguardarProcessarRotina();
		
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}
	

	@Test(testName = "id: 5 - Excluir Cliente", dependsOnMethods = { "inserirBase" })
	public void excluirCliente() {
		rotina.aguardarProcessarRotina();
		/*acao.clicarNoElemento(campoNomeCliente, 0);
		posicaoCliente = 0;
		rotina.aguardarProcessarRotina();
		while (!rotina.buscarElementos(campoNomeCliente, posicaoCliente).getAttribute("value").equals("Novo Cliente")) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
			rotina.aguardarProcessarRotina();
			posicaoCliente++;
		}*/
		
		acao.clicarNoElemento(campoNomeCliente);
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoNomeCliente);
		acao.escreverNoElemento(campoNomeCliente, "Novo Cliente");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();

		acao.clicarNoElemento(abaBases);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoNome);
		acao.posicionarFocoNoElemento(rotina, campoNome);
		rotina.aguardarProcessarRotina();
		rotina.excluirESalvar();
		
		rotina.aguardarProcessarRotina();
		acao.posicionarFocoNoElemento(rotina, campoNomeAmbiente);
		rotina.aguardarProcessarRotina();
		rotina.excluirESalvar();
		rotina.aguardarProcessarRotina();
		
		acao.clicarNoElemento(abaCorrentistas);
		rotina.aguardarProcessarRotina();
		acao.posicionarFocoNoElemento(rotina, campoNomeCorrentista);
		rotina.aguardarProcessarRotina();
		rotina.excluirESalvar();
		rotina.aguardarProcessarRotina();
		
		acao.clicarNoElemento(abaConexoes);
		rotina.aguardarProcessarRotina();
		acao.posicionarFocoNoElemento(rotina, campoNomeConexao);
		rotina.aguardarProcessarRotina();
		rotina.excluirESalvar();
		rotina.aguardarProcessarRotina();
		
		acao.clicarNoElemento(campoNomeCliente, 0);
		rotina.aguardarProcessarRotina();
		rotina.excluirESalvar();
		
	}
	

}

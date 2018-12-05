package br.com.projedata.arcturus.teste.testes;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.Parc119Metodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class TesteParc119 extends TesteGenerico {

	LoginMetodos login;
	Parc119Metodos metodos;

	@Parameters(value = { "login", "senha", "base" })
	@Test(testName = "id: 1 - Abrir rotina parc119")
	public void abrirParc119(String usuario, String senha, String base) {
		login = new LoginMetodos(this);
		login.logar(usuario, senha, base);
		espera.aguardarSistemaCarregar();
		rotina.selecionarRotina("arc119", "p");
		rotina.aguardarProcessarRotina();
	}
	
	@Test(testName = "id: 2 - Abrir cadastro da atualização", dependsOnMethods = {"abrirParc119"})
	public void abrirAtualizacao() {
		String idAtualizacao = acao.retornarValorDoElemento("minhas_pendenciasId-1");
		acao.clicarNoElemento(rotina, "pendenciasBtAbrirAtualizacao-1");
		espera.aguardarElementoEstarVisivel(rotina.retornarRotinaCarregada("arc115"));
		espera.aguardarAtributoDoElementoConterOValor("arcatualizacaoId-1", "value", idAtualizacao);
		rotina.fecharRotina("arc115");
	}
	
	@Test(testName = "id: 3 - Abrir cadastro de rotinas", dependsOnMethods = {"abrirAtualizacao"})
	public void abrirCadastroDeRotinas() {
		String idRotina = acao.retornarValorDoElemento("arcrotinareservaDsRotina-1");
		acao.clicarNoElemento(rotina, "arcrotinareservaBtAbrirVersao-1");
		espera.aguardarElementoEstarVisivel(rotina.retornarRotinaCarregada("arc108"));
		String descRotina = acao.retornarValorDoElemento("ARCROTINANome-1");
		testar.passouSeValorContem(idRotina, descRotina);
		rotina.fecharRotina("arc108");
	}
	
	@Test(testName = "id: 4 - Abrir cadastro de objetos de negócio", dependsOnMethods = {"abrirCadastroDeRotinas"})
	public void abrirCadastroDeObjetosNegocio() {
		String idObjeto = acao.retornarValorDoElemento("arcatualizadorreservaDsObjetoNegocio-1");
		acao.clicarNoElemento(rotina, "arcatualizadorreservaBtAbrirVersao-1");
		espera.aguardarElementoEstarVisivel(rotina.retornarRotinaCarregada("arc109"));
		espera.aguardarAtributoDoElementoConterOValor("ARCOBJETONEGOCIODescricao-1", "value", idObjeto);
		rotina.fecharRotina("arc109");
	}
	
	@Test(testName = "id: 5 - Filtrar pela ação lançada", dependsOnMethods = {"abrirCadastroDeObjetosNegocio"})
	public void filtrarPorAcaoLancada() {
		metodos = new Parc119Metodos(this);
		metodos.limparFiltros();
		acao.clicarNoElemento(rotina, "acaoAtual-1-0");
		acao.abrirLov(rotina, "acaoAtual-1-0");
		rotina.filtrarESelecionarValorNaLov("Lançada");
		acao.clicarNoElemento(rotina, rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		int posicao = 1;
		while(!acao.retornarValorDoElemento("minhas_pendenciasDsAcaoAtual-"+String.valueOf(posicao)).isEmpty()) {
			testar.passouSeAtributoDoElementoContem("minhas_pendenciasDsAcaoAtual-"+String.valueOf(posicao), "value", "Lançada");
			posicao++;
		}
	}
	
	@Test(testName = "id: 6 - Filtrar por usuário", dependsOnMethods = {"filtrarPorAcaoLancada"})
	public void filtrarPorUsuario() {
		metodos.limparFiltros();
		espera.aguardarElementoEstarVisivel("usuarioAtual-1");
		acao.clicarNoElemento(rotina, "usuarioAtual-1");
		acao.abrirLov(rotina, "usuarioAtual-1");
		rotina.filtrarESelecionarValorNaLov("LEONARDO");
		
		acao.clicarNoElemento(rotina, rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		int posicao = 1;
		while(!acao.retornarValorDoElemento("arcatualizacaoDsUsuarioAtual-"+String.valueOf(posicao)).isEmpty()) {
			testar.passouSeAtributoDoElementoContem("arcatualizacaoDsUsuarioAtual-"+String.valueOf(posicao), "value", "LEONARDO");
			posicao++;
		}
		if(posicao > 1) {
			testar.testePassou();
		} else {
			testar.testeFalhou();
		}
	}
	
	@Test(testName = "id: 7 - Verificar se os labels dos quadros são exibidos conforme o usuário do filtro", dependsOnMethods = {"filtrarPorUsuario"})
	public void verificarLabelsDosQuadros() {
		String usuario = "LEONARDO";
		By rotinasBloqueadas = metodos.rotinasBloqueadas(usuario);
		By objetosBloqueados = metodos.objetosBloqueados(usuario);
		testar.passouSeElementoEstiverVisivel(rotinasBloqueadas);
		testar.passouSeElementoEstiverVisivel(objetosBloqueados);
		metodos.limparFiltros();
		acao.clicarNoElemento(rotina, "usuarioAtual-1");
		acao.abrirLov(rotina, "usuarioAtual-1");
		usuario = "USUARIO";
		rotinasBloqueadas = metodos.rotinasBloqueadas(usuario);
		objetosBloqueados = metodos.objetosBloqueados(usuario);
		rotina.filtrarESelecionarValorNaLov("Usuario");
		acao.clicarNoElemento(rotina, rotina.botaoProcessarFiltros);
		rotina.aguardarProcessarRotina();
		testar.passouSeElementoEstiverVisivel(rotinasBloqueadas);
		testar.passouSeElementoEstiverVisivel(objetosBloqueados);
	}
	
}

package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.GeradorRelatoriosElementos.botaoProcessarFiltros;
import static br.com.projedata.arcturus.teste.webelements.GeradorRelatoriosElementos.tipoSaidaRelatorio;
import static br.com.projedata.arcturus.teste.webelements.Parc016Elementos.botaoExcluirPerfil;
import static br.com.projedata.arcturus.teste.webelements.Parc016Elementos.botaoLovIdRotinaPerfil;
import static br.com.projedata.arcturus.teste.webelements.Parc016Elementos.campoExibirCabecalho;
import static br.com.projedata.arcturus.teste.webelements.Parc016Elementos.campoExibirParametros;
import static br.com.projedata.arcturus.teste.webelements.Parc016Elementos.campoIdPerfil;
import static br.com.projedata.arcturus.teste.webelements.Parc016Elementos.campoNomePerfil;
import static br.com.projedata.arcturus.teste.webelements.Parc016Elementos.campoPadraoPerfil;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.botaoAbrirParc016;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.botaoAtualizarPerfis;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.campoSelecionarPerfil;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.fecharJanelaEmissaoRelatorio;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.filtroPeriodoFinal;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.filtroPeriodoInicial;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.Pger001Metodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;
import br.com.projedata.arcturus.teste.webelements.AtualizadorElementos;

public class TesteParc016 extends TesteGenerico {

	LoginMetodos log;
	AtualizadorElementos atualizador;
	Pger001Metodos ger001;
	String idRegistro;
	

	@Parameters(value = { "login2", "senha", "base" })
	@Test(testName = "id: 1 - Abrir rotina parc016.")
	public void abrirParc016(String login, String senha, String base) {
		log = new LoginMetodos(this);
		log.logar(login, senha, base);
		rotina.selecionarRotina("arc016", "p");
		ger001 = new Pger001Metodos(this);
	}
	
	@Test(testName = "id: 2 - Inserir novo perfil", dependsOnMethods = {"abrirParc016"})
	public void inserirPerfil() {
		acao.clicarNoElemento(rotina.botaoNovo);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoNomePerfil, 1, "Teste automação");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		acao.clicarNoElemento(botaoLovIdRotinaPerfil, 1);
		rotina.filtrarESelecionarValorNaLov("rger2");
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoPadraoPerfil, "Sim");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		idRegistro = acao.localizarElementoNaPosicao(campoIdPerfil, 1).getAttribute("value").toString();
		rotina.fecharRotina("arc016");
	}
	
	@Test(testName = "id: 3 - Abrir a pger001 selecionar o relatorio e emitir com o perfil selecionado", dependsOnMethods = {"inserirPerfil"})
	public void abrirORelatorioEVerificarOPerfilCriado() {
		rotina.selecionarRotina("ger001","p");
		ger001.selecionarRelatorioParaEdicao("rger2");
		ger001.executarRelatorio(rotina);
		String perfil = acao.retornarValorSelecionadoNoElemento(campoSelecionarPerfil);
		testar.passouSeValorContem(perfil, "Teste automação");
		ger001.fecharRelatorio();
		rotina.fecharRotina("ger001");
	}
	
	@Test(testName = "id: 4 - Excluir perfil criado", dependsOnMethods = {"abrirORelatorioEVerificarOPerfilCriado"})
	public void excluirFiltroCriado() {
		rotina.selecionarRotina("arc016", "p");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoIdPerfil, idRegistro);
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoExcluirPerfil, 0);
		espera.aguardarElementoEstarVazio(campoIdPerfil);
		rotina.fecharRotina("arc016");
	}
	
	@Test(testName = "id: 5 - Abrir parc016 pela tela do gerador de relatorios", dependsOnMethods = {"excluirFiltroCriado"})
	public void abrirArc016PelaGer001() {
		rotina.selecionarRotina("ger001", "p");
		ger001.selecionarRelatorioParaEdicao("rger2");
		ger001.executarRelatorio(rotina);
		espera.aguardarElementoEstarVisivel(botaoAbrirParc016);
		acao.clicarNoElemento(rotina, botaoAbrirParc016);
		rotina.retornarRotinaCarregada("arc016");
		espera.aguardarElementoEstarVisivel(campoNomePerfil);
		acao.escreverNoElemento(campoNomePerfil, "teste automacao pger1");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		idRegistro = acao.localizarElementoNaPosicao(campoIdPerfil, 0).getAttribute("value").toString();
		rotina.fecharRotina("arc016");
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.TAB);
		espera.aguardarElementoDesaparecer(rotina.tolltipCampo);
		acao.clicarNoElemento(botaoAtualizarPerfis);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoSelecionarPerfil, "teste automacao pger1");
	}
	
	@Test(testName = "id: 6 - Emitir relatorio com o perfil criado", dependsOnMethods = {"abrirArc016PelaGer001"})
	public void emitirRelatorioComOPerfilCriado() throws InvalidPasswordException, IOException {
		acao.escreverNoElemento(filtroPeriodoInicial, "07022013");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(filtroPeriodoFinal, "07022013");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElemento(campoExibirParametros, "Sim");
		acao.selecionarNoElemento(campoExibirCabecalho, "Sim");
		acao.selecionarNoElemento(tipoSaidaRelatorio, "PDF");
		acao.clicarNoElemento(botaoProcessarFiltros);
		espera.aguardarElementoDesaparecer(rotina.botaoProcessarFiltros);
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "TESTE PERFIL");
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "07/02/2013 - 07/02/2013");
		acao.clicarNoElemento(fecharJanelaEmissaoRelatorio);
		espera.aguardarElementoDesaparecer(fecharJanelaEmissaoRelatorio);
		rotina.aguardarProcessarRotina();
		rotina.fecharRotina("ger001");
		excluirFiltroCriado();
	}

}

package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoAbrirJanela;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.botaoAbrirLovDaJanela;
import static br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos.janelaTeste;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.botaoCriarNovaSessaoEspanhol;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.botaoCriarNovaSessaoIngles;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.botaoEntrarEspanhol;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.botaoEntrarIngles;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.campoLoginEspanhol;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.campoLoginIngles;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.campoSenhaEspanhol;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.campoSenhaIngles;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.colunaCodigoLovEspanhol;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.colunaCodigoLovIngles;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.colunaCodigoLovPortugues;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.colunaLovRazaoSocialEspanhol;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.colunaLovRazaoSocialIngles;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.colunaLovRazaoSocialPortugues;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.dicaCampoArvoreEspanhol;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.dicaCampoArvoreIngles;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.dicaCampoArvorePortugues;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.etiquetaAba1Espanhol;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.etiquetaAba1Ingles;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.etiquetaAba1Portugues;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.etiquetaBotaoAbrirJanela015Espanhol;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.etiquetaBotaoAbrirJanela015Ingles;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.etiquetaBotaoAbrirJanela015Portugues;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.etiquetaCampoDataHora015Espanhol;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.etiquetaCampoDataHora015Ingles;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.etiquetaCampoDataHora015Portugues;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.etiquetaCampoValor1Espanhol;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.etiquetaCampoValor1Ingles;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.etiquetaCampoValor1Portugues;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.etiquetaGrupoAbas015Espanhol;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.etiquetaGrupoAbas015Ingles;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.etiquetaGrupoAbas015Portugues;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.linkEsqueciSenhaEspanhol;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.linkEsqueciSenhaIngles;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.tituloRotinaEspanhol;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.tituloRotinaIngles;
import static br.com.projedata.arcturus.teste.webelements.InternacionalizacaoElementos.tituloRotinaPortugues;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.botaoExecutarHabilitado;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.fecharJanelaEmissaoRelatorio;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.botaoAbrirIdiomas;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.botaoRecarregarMensagemConfirmacao;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.idiomaEspanhol;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.idiomaIngles;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.idiomaPortugues;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.janelaAlterarIdioma;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.mensagemConfirmacaoIdiomaEspanhol;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.mensagemConfirmacaoIdiomaIngles;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.mensagemConfirmacaoIdiomaPortugues;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.Pger001Metodos;
import br.com.projedata.arcturus.teste.metodosgenericos.PortalMetodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class TesteInternacionalizacao extends TesteGenerico {

	LoginMetodos logar;
	PortalMetodos portal;
	Pger001Metodos ger001;

	@Parameters(value = { "login2", "senha", "base" })
	@Test(testName = "id: 1- Acessar sistema", enabled = true)
	public void acessarSistema(String login, String senha, String base) {
		logar = new LoginMetodos(this);
		portal = new PortalMetodos(this);
		logar.logar(login, senha, base);
	}

	@Test(testName = "id: 2- Alterar idioma para espanhol", enabled = true, dependsOnMethods = { "acessarSistema" })
	public void alterarIdiomaParaEspanhol() {
		abrirMenuConfiguracoes();
		acao.clicarNoElemento(botaoAbrirIdiomas);
		espera.aguardarElementoEstarVisivel(janelaAlterarIdioma);
		acao.clicarNoElemento(idiomaEspanhol);
		espera.aguardarElementoDesaparecer(janelaAlterarIdioma);
		espera.aguardarElementoEstarVisivel(mensagemConfirmacaoIdiomaEspanhol);
		acao.clicarNoElemento(botaoRecarregarMensagemConfirmacao);
		espera.aguardarElementoDesaparecer(mensagemConfirmacaoIdiomaEspanhol);
		espera.aguardarSistemaCarregar();
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Más Usados"));
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Cumpleaños"));
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Empresa"));
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Favoritos"));
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Informes"));
	}

	@Test(testName = "id: 3- Alterar idioma para ingles", enabled = true, dependsOnMethods = { "alterarIdiomaParaEspanhol" })
	public void alterarIdiomaParaIngles() {
		abrirMenuConfiguracoes();
		acao.clicarNoElemento(botaoAbrirIdiomas);
		espera.aguardarElementoEstarVisivel(janelaAlterarIdioma);
		acao.clicarNoElemento(idiomaIngles);
		espera.aguardarElementoDesaparecer(janelaAlterarIdioma);
		espera.aguardarElementoEstarVisivel(mensagemConfirmacaoIdiomaIngles);
		espera.aguardarElementoEstarVisivel(botaoRecarregarMensagemConfirmacao);
		acao.clicarNoElemento(botaoRecarregarMensagemConfirmacao);
		espera.aguardarElementoDesaparecer(mensagemConfirmacaoIdiomaIngles);
		espera.aguardarSistemaCarregar();
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Most Used"));
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Birthdays"));
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Company"));
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Favorites"));
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Reports"));
	}

	@Test(testName = "id: 4- Alterar idioma para português", enabled = true, dependsOnMethods = { "alterarIdiomaParaIngles" })
	public void alterarIdiomaParaPortugues() {
		abrirMenuConfiguracoes();
		acao.clicarNoElemento(botaoAbrirIdiomas);
		espera.aguardarElementoEstarVisivel(janelaAlterarIdioma);
		acao.clicarNoElemento(idiomaPortugues);
		espera.aguardarElementoDesaparecer(janelaAlterarIdioma);
		espera.aguardarElementoEstarVisivel(mensagemConfirmacaoIdiomaPortugues);
		acao.clicarNoElemento(botaoRecarregarMensagemConfirmacao);
		espera.aguardarElementoDesaparecer(mensagemConfirmacaoIdiomaPortugues);
		espera.aguardarSistemaCarregar();
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Mais Utilizados"));
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Aniversários"));
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Empresa"));
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Favoritos"));
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Relatórios"));
	}

	@Test(testName = "id: 5- Verificar traducao na rotina para ingles", enabled = true, dependsOnMethods = { "alterarIdiomaParaPortugues" })
	public void verificarRotinaTraduzidaParaIngles() {
		alterarIdiomaParaIngles();
		rotina.selecionarRotina("teste015");
		espera.aguardarElementoEstarVisivel(rotina.rotinaCarregada);
		espera.aguardarElementoEstarVisivel(etiquetaAba1Ingles);
		espera.aguardarElementoEstarVisivel(etiquetaBotaoAbrirJanela015Ingles);
		espera.aguardarElementoEstarVisivel(etiquetaCampoDataHora015Ingles);
		espera.aguardarElementoEstarVisivel(etiquetaCampoValor1Ingles);
		espera.aguardarElementoEstarVisivel(etiquetaGrupoAbas015Ingles);
		acao.clicarNoElemento(botaoAbrirJanela);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(janelaTeste);
		acao.clicarNoElemento(botaoAbrirLovDaJanela);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(rotina.lov);
		espera.aguardarElementoEstarVisivel(colunaCodigoLovIngles);
		espera.aguardarElementoEstarVisivel(colunaLovRazaoSocialIngles);
		espera.aguardarElementoEstarVisivel(dicaCampoArvoreIngles);
		espera.aguardarElementoEstarVisivel(tituloRotinaIngles);
		rotina.fecharRotina("teste015");
	}

	@Test(testName = "id: 6- Verificar traducao na rotina para espanhol", enabled = true, dependsOnMethods = {
			"verificarRotinaTraduzidaParaIngles" })
	public void verificarRotinaTraduzidaParaEspanhol() {
		alterarIdiomaParaEspanhol();
		rotina.selecionarRotina("teste015");
		espera.aguardarElementoEstarVisivel(rotina.rotinaCarregada);
		espera.aguardarElementoEstarVisivel(etiquetaAba1Espanhol);
		espera.aguardarElementoEstarVisivel(etiquetaBotaoAbrirJanela015Espanhol);
		espera.aguardarElementoEstarVisivel(etiquetaCampoDataHora015Espanhol);
		espera.aguardarElementoEstarVisivel(etiquetaCampoValor1Espanhol);
		espera.aguardarElementoEstarVisivel(etiquetaGrupoAbas015Espanhol);
		acao.clicarNoElemento(botaoAbrirJanela);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(janelaTeste);
		acao.clicarNoElemento(botaoAbrirLovDaJanela);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(rotina.lov);
		espera.aguardarElementoEstarVisivel(colunaCodigoLovEspanhol);
		espera.aguardarElementoEstarVisivel(colunaLovRazaoSocialEspanhol);
		espera.aguardarElementoEstarVisivel(dicaCampoArvoreEspanhol);
		espera.aguardarElementoEstarVisivel(tituloRotinaEspanhol);
		rotina.fecharRotina("teste015");

	}

	@Test(testName = "id: 7- Verificar traducao na rotina para portugues", enabled = true, dependsOnMethods = {
			"verificarRotinaTraduzidaParaEspanhol" })
	public void verificarRotinaTraduzidaParaPortugues() {
		alterarIdiomaParaPortugues();
		rotina.selecionarRotina("teste015");
		espera.aguardarElementoEstarVisivel(rotina.rotinaCarregada);
		espera.aguardarElementoEstarVisivel(etiquetaAba1Portugues);
		espera.aguardarElementoEstarVisivel(etiquetaBotaoAbrirJanela015Portugues);
		espera.aguardarElementoEstarVisivel(etiquetaCampoDataHora015Portugues);
		espera.aguardarElementoEstarVisivel(etiquetaCampoValor1Portugues);
		espera.aguardarElementoEstarVisivel(etiquetaGrupoAbas015Portugues);
		acao.clicarNoElemento(botaoAbrirJanela);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(janelaTeste);
		acao.clicarNoElemento(botaoAbrirLovDaJanela);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(rotina.lov);
		espera.aguardarElementoEstarVisivel(colunaCodigoLovPortugues);
		espera.aguardarElementoEstarVisivel(colunaLovRazaoSocialPortugues);
		espera.aguardarElementoEstarVisivel(dicaCampoArvorePortugues);
		espera.aguardarElementoEstarVisivel(tituloRotinaPortugues);
		rotina.fecharRotina("teste015");
		espera.aguardarSistemaCarregar();
	}

	@Test(testName = "id: 8- Verificar tela de login traduzida para o ingles", enabled = true, dependsOnMethods = {
			"verificarRotinaTraduzidaParaPortugues" })
	public void verificarTelaDeLoginIngles() {
		alterarIdiomaParaIngles();
		sairPortal();
		espera.aguardarElementoEstarVisivel(campoLoginIngles);
		espera.aguardarElementoEstarVisivel(campoSenhaIngles);
		espera.aguardarElementoEstarVisivel(botaoEntrarIngles);
		espera.aguardarElementoEstarVisivel(linkEsqueciSenhaIngles);
	}

	@Test(testName = "id: 9- Mensagem erro em ingles", enabled = true, dependsOnMethods = { "verificarTelaDeLoginIngles" })
	public void verificarMensagemErroTraduzidaIngles() {
		acao.clicarNoElemento(logar.botaoAcessar);
		msg.aguardarMensagem("User, password and database cannot be blank.");
	}

	@Test(testName = "id: 10- Mensagem confirmação em ingles", enabled = true, dependsOnMethods = { "verificarMensagemErroTraduzidaIngles" })
	public void verificarMensagemConfirmacaoTraduzidaIngles() {
		logar.preencherCamposLogin("usuario", "usuario", "desenvolvimento");
		msg.aguardarMensagem("User already has an active session. Select an option below to continue.");
		acao.clicarNoElemento(botaoCriarNovaSessaoIngles);
		espera.aguardarElementoEstarVisivel(rotina.localizarRotina);
		espera.aguardarElementoEstarVisivel(logar.logado);
		espera.aguardarSistemaCarregar();
		navegador.atualizarBrowser();
		sairPortal();
		logar.logarSemAlterarIdioma("usuario2", "usuario", "desenvolvimento");
	}

	@Test(testName = "id: 11- Verificar traducao em ingles no relatorio", enabled = true, dependsOnMethods = {
			"verificarMensagemConfirmacaoTraduzidaIngles" })
	public void verificarRelatorioTraduzidoIngles() throws InvalidPasswordException, IOException {
		ger001 = new Pger001Metodos(this);
		rotina.selecionarRotina("ger001");
		ger001.selecionarRelatorioParaEdicao("rger2");
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		acao.clicarNoElemento(rotina.botaoProcessarFiltros);
		espera.aguardarElementoDesaparecer(rotina.botaoProcessarFiltros);
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "Number OS");
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "Start");
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "User");
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "Topic");
		acao.clicarNoElemento(fecharJanelaEmissaoRelatorio);
		espera.aguardarElementoDesaparecer(fecharJanelaEmissaoRelatorio);
	}

	@Test(testName = "id: 12- Verificar tela de login traduzida para o espanhol", enabled = true, dependsOnMethods = {
			"verificarRelatorioTraduzidoIngles" })
	public void verificarTelaDeLoginEspanhol() {
		alterarIdiomaParaEspanhol();
		sairPortal();
		espera.aguardarElementoEstarVisivel(campoLoginEspanhol);
		espera.aguardarElementoEstarVisivel(campoSenhaEspanhol);
		espera.aguardarElementoEstarVisivel(botaoEntrarEspanhol);
		espera.aguardarElementoEstarVisivel(linkEsqueciSenhaEspanhol);
	}

	@Test(testName = "id: 13- Mensagem erro em espanhol", enabled = true, dependsOnMethods = { "verificarTelaDeLoginEspanhol" })
	public void verificarMensagemErroTraduzidaEspanhol() {
		acao.clicarNoElemento(logar.botaoAcessar);
		msg.aguardarMensagem("Informe al usuario, contraseña y base");
	}

	@Test(testName = "id: 14- Mensagem confirmação em espanhol", enabled = true, dependsOnMethods = { "verificarMensagemErroTraduzidaEspanhol" })
	public void verificarMensagemConfirmacaoTraduzidaEspanhol() {
		logar.preencherCamposLogin("usuario", "usuario", "desenvolvimento");
		msg.aguardarMensagem("El usuario ya tiene una sesión activa en el sistema. Seleccione una opción para continuar.");
		acao.clicarNoElemento(botaoCriarNovaSessaoEspanhol);
		espera.aguardarElementoEstarVisivel(rotina.localizarRotina);
		espera.aguardarSistemaCarregar();
		navegador.atualizarBrowser();
		sairPortal();
		logar.logarSemAlterarIdioma("usuario2", "usuario", "desenvolvimento");
	}

	@Test(testName = "id: 15- Verificar traducao em espanhol no relatorio", enabled = true, dependsOnMethods = {
			"verificarMensagemConfirmacaoTraduzidaEspanhol" })
	public void verificarRelatorioTraduzidoEspanhol() throws InvalidPasswordException, IOException {
		rotina.selecionarRotina("ger001");
		ger001.selecionarRelatorioParaEdicao("rger2");
		acao.clicarNoElemento(botaoExecutarHabilitado);
		espera.aguardarElementoEstarVisivel(rotina.botaoProcessarFiltros);
		acao.clicarNoElemento(rotina.botaoProcessarFiltros);
		espera.aguardarElementoDesaparecer(rotina.botaoProcessarFiltros);
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "Número OS");
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "Usuário");
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "Primero");
		testar.passouSeValorContem(rotina.retornarConteudoDoPdf(), "Sujeto");
		acao.clicarNoElemento(fecharJanelaEmissaoRelatorio);
		espera.aguardarElementoDesaparecer(fecharJanelaEmissaoRelatorio);
		alterarIdiomaParaPortugues();
	}

}

package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.Parc107Elementos.campoIdRotina;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.abrirNotificacoes;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.botaoAbrirCaixaDeCores;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.botaoAbrirEstilos;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.botaoAbrirListaPaineis;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.botaoAbrirMenu;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.botaoAlterarSenha;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.botaoSalvarDesabilitado;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.cabecalhoCorAzul;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.cabecalhoCorVerde;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.cadastroUsuarios;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.caixaDeCoresAberta;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.confirmarNovaSenha;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.corAzul;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.corVerde;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.empresa1Selecionada;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.empresa2Selecionada;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.fecharJanelaAlterarSenha;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.fecharListaPaineis;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.janelaAlterarSenha;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.listaDeCores;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.listaPaineis;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.localizarRotina;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.lovTrocarEmpresa;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.mensagemSemLicencaDisponivel;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.mensagemSenhaAlterada;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.mensagemSenhaInvalida;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.menuAdmArcturus;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.menuApoio;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.menuCadastros;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.menuPrincipal;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.menuRotinaParc001;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.menuTrocarEmpresa;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.novaSenha;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.painelRelatoriosCinza;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.painelRelatoriosVermelho;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.salvarNovaSenha;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.selecionaEmpresa1;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.selecionaEmpresa2;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.selecionarCorCinza;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.selecionarCorVermelha;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.senhaAtual;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.voceTemUmNovoRecado;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.AtualizadorMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.ConstrutorTelasMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.PortalMetodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;
import br.com.projedata.arcturus.teste.webelements.ConstrutorTelasElementos;
import br.com.projedata.arcturus.teste.webelements.Parc001Elementos;
import br.com.projedata.arcturus.teste.webelements.Pwkf008Elementos;

public class TestePortal extends TesteGenerico {

	private String paginaPrincipal;
	LoginMetodos logar;
	public Pwkf008Elementos wkf008;
	String elementoFocado;
	ConstrutorTelasElementos tela;
	PortalMetodos portal;
	AtualizadorMetodos atualizador;
	ConstrutorTelasMetodos metodosConstrutor;

	public void metodoAtivarDesativarPaineis(String painel) throws InterruptedException {
		portal = new PortalMetodos(this);
		if (acao.localizarElementos(listaPaineis).size() == 0) {
			abrirMenuConfiguracoes();
			espera.aguardarElementoEstarVisivel(botaoAbrirListaPaineis);
			acao.clicarNoElemento(botaoAbrirListaPaineis);
			espera.aguardarSistemaCarregar();
			espera.aguardarElementoEstarVisivel(listaPaineis);
			espera.aguardarElementoEstarVisivel(portal.ligarDesligarPaineis(painel));
		}

		espera.aguardarElementoSerClicavel(portal.ligarDesligarPaineis(painel));
		acao.clicarNoElemento(portal.ligarDesligarPaineis(painel));
		espera.aguardarSistemaCarregar();
		Thread.sleep(1000);
		if (portal.painelDesligado(painel)) {
			espera.aguardarElementoDesaparecer(portal.painelPortal(painel));
			espera.aguardarElementoEstarVisivel(portal.ligarDesligarPaineis(painel));
			acao.clicarNoElemento(portal.ligarDesligarPaineis(painel));
			Thread.sleep(300);
			espera.aguardarSistemaCarregar();
		}

		if (portal.painelLigado(painel)) {
			espera.aguardarElementoEstarVisivel(portal.painelPortal(painel));
			espera.aguardarSistemaCarregar();
		}
	}

	@Parameters(value = { "login2", "senha", "base" })
	@Test(testName = "id: 25 - Acessar portal e verificar se a rotina arc003 será exibida. Está configurada no evento da arc103", enabled = true)
	public void abrirRotinaAoAcessarPortal(String login, String senha, String base) {
		logar = new LoginMetodos(this);
		logar.logarSemAlterarIdioma(login, senha, base);
		rotina.selecionarRotina("arc103");
		acao.clicarNoElemento(rotina, "ARCEVENTOSAcao-2");
		acao.selecionarNoElementoPeloValor("ARCEVENTOSAcao-2", "S");
		acao.clicarNoElemento(rotina, "ARCEVENTOSOrdem-2");
		acao.escreverNoElemento("ARCEVENTOSOrdem-2", "5");
		acao.clicarNoElemento(rotina, "ARCEVENTOSNomeObjetoNegocio-2");
		acao.abrirLov(rotina, "ARCEVENTOSNomeObjetoNegocio-2");
		rotina.filtrarESelecionarValorNaLov("SELECAO_EMPRESA");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		sairPortal();
		logar.logarSemAlterarIdioma(login, senha, base);
		espera.aguardarElementoEstarVisivel(rotina.retornarRotinaCarregada("arc003"));
		rotina.fecharRotina("arc003");
	}

	@Parameters(value = { "login2", "senha", "base" })
	@Test(testName = "id: 26 - Excluir o evento de abertura da rotina, sair do portal e após retornar verificar se a rotina não será exibida", enabled = true, dependsOnMethods = {"abrirRotinaAoAcessarPortal"})
	public void excluirEventoAbrirRotina(String login, String senha, String base) {
		rotina.selecionarRotina("arc103");
		acao.clicarNoElemento(rotina, "ARCEVENTOSNomeObjetoNegocio-1");
		if(!"SELECAO_EMPRESA".contains(acao.retornarValorDoElemento("ARCEVENTOSNomeObjetoNegocio-1"))) {
			acao.clicarNoElemento(rotina, "ARCEVENTOSNomeObjetoNegocio-2");
		}
		rotina.aguardarProcessarRotina();
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		sairPortal();
		logar.logarSemAlterarIdioma(login, senha, base);
		espera.aguardarSistemaCarregar();
		try {
			espera.aguardarElementoEstarVisivel(2, rotina.retornarRotinaCarregada("arc003"));
			testar.testeFalhou();
		} catch (Exception e) {
			testar.testePassou();
		}
	}

	@Parameters(value = { "login2", "senha", "base" })
	@Test(testName = "id: 1 - Ativar e desativar paineis", enabled = true, dependsOnMethods = {"excluirEventoAbrirRotina"})
	public void ativarDesativarPaineis(String login, String senha, String base) throws InterruptedException {
		metodoAtivarDesativarPaineis("Usuário e Empresa");
		metodoAtivarDesativarPaineis("Mais Utilizadas");
		metodoAtivarDesativarPaineis("Favoritos");
		metodoAtivarDesativarPaineis("Aniversários");
		metodoAtivarDesativarPaineis("Relatórios");
		acao.clicarNoElemento(fecharListaPaineis);
		espera.aguardarElementoDesaparecer(fecharListaPaineis);
	}

	@Test(testName = "id: 23 - Atualizar painel via comando", dependsOnMethods = { "ativarDesativarPaineis" }, enabled = true)
	public void atualizarPainelViaComando() throws InterruptedException {
		rotina.selecionarRotina("teste015");
		String dataAtual = acao.localizarElemento(acao.localizarPainel("painelTeste")).getText();
		rotina.aguardarProcessarRotina();
		Thread.sleep(1000);
		acao.clicarNoElemento("testeBotaoAtualizarPainel-1");
		rotina.aguardarProcessarRotina();
		espera.aguardarSistemaCarregar();
		testar.passouSeValoresForemDiferentes(dataAtual, acao.localizarElemento(acao.localizarPainel("painelTeste")).getText());
		rotina.fecharRotina("teste015");
	}

	@Test(testName = "id: 2 - altera estilo do portal", dependsOnMethods = { "atualizarPainelViaComando" }, enabled = true)
	public void alterarEstiloDoPortal() {
		abrirMenuConfiguracoes();
		acao.clicarNoElemento(botaoAbrirEstilos);
		espera.aguardarElementoEstarVisivel(listaDeCores);
		acao.clicarNoElemento(corVerde);
		espera.aguardarElementoEstarVisivel(cabecalhoCorVerde);
	}

	@Test(testName = "id: 3 - altera estilo do portal", dependsOnMethods = { "alterarEstiloDoPortal" }, enabled = true)
	public void retornarAoEstiloOriginal() {
		abrirMenuConfiguracoes();
		acao.clicarNoElemento(botaoAbrirEstilos);
		espera.aguardarElementoEstarVisivel(listaDeCores);
		acao.clicarNoElemento(corAzul);
		espera.aguardarElementoEstarVisivel(cabecalhoCorAzul);
	}

	@Test(testName = "id: 4 - Testar validacao campo senha atual", dependsOnMethods = "retornarAoEstiloOriginal")
	public void alterarSenhaSenhaAtualInvalida() {
		sairPortal();
		logar.aguardarTelaLogin();
		logar.logar("usuario2", "usuario", "desenvolvimento");
		abrirMenuConfiguracoes();
		acao.clicarNoElemento(botaoAlterarSenha);
		espera.aguardarElementoEstarVisivel(janelaAlterarSenha);
		acao.escreverNoElemento(senhaAtual, "guth55");
		acao.escreverNoElemento(novaSenha, "gustavo");
		acao.escreverNoElemento(confirmarNovaSenha, "gustavo");
		acao.clicarNoElemento(salvarNovaSenha);
		espera.aguardarElementoEstarVisivel(mensagemSenhaInvalida);
		msg.fecharMensagemNotificacao();
	}

	@Test(testName = "id: 5 - Alterar senha", dependsOnMethods = "alterarSenhaSenhaAtualInvalida")
	public void alterarSenha() {
		acao.limparElemento(senhaAtual);
		acao.limparElemento(novaSenha);
		acao.limparElemento(confirmarNovaSenha);
		acao.escreverNoElemento(senhaAtual, "usuario");
		acao.escreverNoElemento(novaSenha, "gustavo");
		acao.escreverNoElemento(confirmarNovaSenha, "gustavo");
		acao.clicarNoElemento(salvarNovaSenha);
		espera.aguardarElementoEstarVisivel(mensagemSenhaAlterada);
		msg.fecharMensagemNotificacao();
	}

	@Test(testName = "id: 6 - Senha e confirmar senha diferentes", dependsOnMethods = "alterarSenha")
	public void senhaEconfirmarSenhaDiferentes() {
		abrirMenuConfiguracoes();
		acao.clicarNoElemento(botaoAlterarSenha);
		espera.aguardarElementoEstarVisivel(janelaAlterarSenha);
		acao.escreverNoElemento(senhaAtual, "gustavo");
		acao.escreverNoElemento(novaSenha, "usuario");
		acao.escreverNoElemento(confirmarNovaSenha, "usuário");
		espera.aguardarElementoEstarVisivel(botaoSalvarDesabilitado);
	}

	@Test(testName = "id: 7 - Tentar acessar portal com senha antiga", dependsOnMethods = "senhaEconfirmarSenhaDiferentes")
	public void acessarPortalComSenhaAntiga() {
		acao.clicarNoElemento(fecharJanelaAlterarSenha);
		espera.aguardarElementoDesaparecer(janelaAlterarSenha);
		sairPortal();
		logar.aguardarTelaLogin();
		logar.logarInvalido("usuario2", "usuario", "desenvolvimento");
	}

	@Test(testName = "id: 8 - Acessar portal com nova senha", dependsOnMethods = "acessarPortalComSenhaAntiga")
	public void acessarPortalComNovaSenha() {
		logar.logar("usuario2", "gustavo", "desenvolvimento");
	}

	@Test(testName = "id: 9 - retornar a senha antiga", dependsOnMethods = "acessarPortalComNovaSenha")
	public void retornarSenhaAntiga() {
		abrirMenuConfiguracoes();
		acao.clicarNoElemento(botaoAlterarSenha);
		espera.aguardarElementoEstarVisivel(janelaAlterarSenha);
		acao.escreverNoElemento(senhaAtual, "gustavo");
		acao.escreverNoElemento(novaSenha, "usuario");
		acao.escreverNoElemento(confirmarNovaSenha, "usuario");
		acao.clicarNoElemento(salvarNovaSenha);
		espera.aguardarElementoEstarVisivel(mensagemSenhaAlterada);
		msg.fecharMensagemNotificacao();
		espera.aguardarElementoDesaparecer(janelaAlterarSenha);
	}

	@Test(testName = "id: 10 - acessar o cadastro de usuarios pelo menu", dependsOnMethods = "retornarSenhaAntiga")
	public void acessarRotinaPeloMenu() {
		acao.clicarNoElemento(botaoAbrirMenu);
		espera.aguardarElementoEstarVisivel(menuPrincipal);
		espera.aguardarElementoEstarVisivel(menuApoio);
		acao.clicarNoElemento(menuApoio);
		espera.aguardarElementoEstarVisivel(menuAdmArcturus);
		acao.clicarNoElemento(menuAdmArcturus);
		espera.aguardarElementoEstarVisivel(menuCadastros);
		acao.clicarNoElemento(menuCadastros);
		acao.clicarNoElemento(menuRotinaParc001);
		espera.aguardarElementoEstarVisivel(cadastroUsuarios);
		sairPortal();
	}

	@Test(testName = "id: 11 - trocar de empresa.", dependsOnMethods = "acessarRotinaPeloMenu")
	public void trocarDeEmpresa() {
		logar.logar("usuario2", "usuario", "desenvolvimento");
		espera.aguardarSistemaCarregar();
		espera.aguardarElementoEstarVisivel(menuTrocarEmpresa);
		espera.aguardarSistemaCarregar();
		mouse.scrollParaElemento(menuTrocarEmpresa);
		acao.clicarNoElemento(menuTrocarEmpresa);
		try {
			espera.aguardarElementoEstarVisivel(lovTrocarEmpresa);
		} catch (TimeoutException e) {
			acao.clicarNoElemento(menuTrocarEmpresa);
			espera.aguardarElementoEstarVisivel(lovTrocarEmpresa);
		}
		acao.clicarNoElemento(selecionaEmpresa2);
		espera.aguardarElementoDesaparecer(lovTrocarEmpresa);
		espera.aguardarElementoEstarVisivel(empresa2Selecionada);
		espera.aguardarSistemaCarregar();
		paginaPrincipal = navegador.retornarPaginaAtual();
	}

	@Test(testName = "id: 24 - Alterar empresa e verificar se o evento alterar empresa configurado é disparado.", dependsOnMethods = "trocarDeEmpresa")
	public void testarEventoAlterarEmpresa() {
		rotina.selecionarRotina("teste015");
		testar.passouSeAtributoDoElementoContem("bloco_testeEventoAlteracaoEmpresa", "value", "2");
		rotina.fecharRotina("teste015");

		mouse.scrollParaElemento(menuTrocarEmpresa);
		acao.clicarNoElemento(menuTrocarEmpresa);
		try {
			espera.aguardarElementoEstarVisivel(lovTrocarEmpresa);
		} catch (TimeoutException e) {
			acao.clicarNoElemento(menuTrocarEmpresa);
			espera.aguardarElementoEstarVisivel(lovTrocarEmpresa);
		}

		acao.clicarNoElemento(selecionaEmpresa1);
		espera.aguardarElementoDesaparecer(lovTrocarEmpresa);
		espera.aguardarElementoEstarVisivel(empresa1Selecionada);
		espera.aguardarSistemaCarregar();

		rotina.selecionarRotina("teste015");
		testar.passouSeAtributoDoElementoContem("bloco_testeEventoAlteracaoEmpresa", "value", "1");
		rotina.fecharRotina("teste015");
	}

	@Parameters(value = { "url2" })
	@Test(testName = "id: 12 - Testar quantidade de licencas.", dependsOnMethods = { "trocarDeEmpresa" }, enabled = false)
	public void verificaQuantidadeDeLicencas(String url2) throws AWTException, InterruptedException {
		sairPortal();
		navegador.irParaNovaUrlEmNovaAba(url2);
		logar.aguardarTelaLogin();
		logar.logar("teste", "Gustavo12!", "Homologacao");
		acao.clicarNoElemento(localizarRotina);
		navegador.irParaNovaUrlEmNovaAba(url2);
		logar.aguardarTelaLogin();
		logar.logar("teste2", "Gustavo1!", "Homologacao");
		acao.clicarNoElemento(localizarRotina);
		navegador.irParaNovaUrlEmNovaAba(url2);
		logar.aguardarTelaLogin();
		logar.logar("gustavo.projedata", "Gustavo1!", "Homologacao");
		espera.aguardarElementoEstarVisivel(mensagemSemLicencaDisponivel);
		msg.fecharMensagemNotificacao();
		navegador.retornarPaginaPrincipal(paginaPrincipal);
	}

	@Test(testName = "id: 13 - Acessar o sistema com um usuario que nao possua empresa padrao informada", dependsOnMethods = {
			"testarEventoAlterarEmpresa" }, enabled = true)
	public void usuarioSemEmpresaPadraoInformada() {
		sairPortal();
		logar.logarSemValidacao("dudel", "Gustavo1!", "desenvolvimento");
		espera.aguardarElementoEstarVisivel(lovTrocarEmpresa);
		espera.aguardarElementoEstarVisivel(selecionaEmpresa1);
		acao.clicarNoElemento(selecionaEmpresa1);
		espera.aguardarElementoDesaparecer(lovTrocarEmpresa);
		espera.aguardarElementoEstarVisivel(localizarRotina);
		sairPortal();
	}

	@Parameters(value = { "url" })
	@Test(testName = "id: 14 - Abrir lista de rotinas teclando shift F3", dependsOnMethods = {
			"usuarioSemEmpresaPadraoInformada" }, enabled = true)
	public void abrirListaDeRotinasPeloShiftF3(String url) throws AWTException, InterruptedException {
		navegador.alterarUrl(url);
		logar.logar("usuario2", "usuario", "desenvolvimento");
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F3);
	}

	@Test(testName = "id: 15 - Selecionar rotina com a seta", dependsOnMethods = { "abrirListaDeRotinasPeloShiftF3" }, enabled = true)
	public void selecionarRotinaComASetaDoTeclado() {
		acao.limparElemento(localizarRotina);
		while (acao.localizarElementos(Parc001Elementos.rotinaSelecionadaNaLista).size() == 0) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
		}
		teclado.pressionarTeclaDeControle(Keys.ENTER);
		espera.aguardarElementoDesaparecer(rotina.listaRotinasAberta);
		espera.aguardarElementoEstarVisivel(rotina.retornarRotinaCarregada("arc001"));
	}

	@Test(testName = "id: 16 - Fechar menu ao clicar fora em qualquer lugar da tela", dependsOnMethods = "selecionarRotinaComASetaDoTeclado")
	public void fecharMenuAoClicarFora() {
		espera.aguardarElementoEstarVisivel(botaoAbrirMenu);
		acao.clicarNoElemento(botaoAbrirMenu);
		espera.aguardarElementoEstarVisivel(menuPrincipal);
		espera.aguardarElementoEstarVisivel(menuApoio);
		acao.clicarNoElemento(menuApoio);
		acao.clicarNoElementoPorCoordenada(1000, 500);
		espera.aguardarElementoDesaparecer(menuPrincipal);
	}

	@Test(testName = "id: 17 - Trocar de empresa e verificar se os widgets serao mantidos", dependsOnMethods = "fecharMenuAoClicarFora")
	public void verificarWidGetsAoTrocarDeEmpresa() {
		sairPortal();
		trocarDeEmpresa();
		espera.aguardarElementoDesaparecer(portal.painelPortal("Mais Utilizados"));
		espera.aguardarElementoDesaparecer(portal.painelPortal("Favoritos"));
		espera.aguardarElementoDesaparecer(portal.painelPortal("Aniversários"));
		acao.clicarNoElemento(menuTrocarEmpresa);
		espera.aguardarElementoEstarVisivel(lovTrocarEmpresa);
		acao.clicarNoElemento(selecionaEmpresa1);
		espera.aguardarElementoDesaparecer(lovTrocarEmpresa);
		espera.aguardarElementoEstarVisivel(empresa1Selecionada);
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Empresa"));
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Utilizados"));
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Favoritos"));
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Aniversários"));
		espera.aguardarElementoEstarVisivel(portal.painelPortal("Relatórios"));
	}

	@Test(testName = "id: 18 - Trocar cor do painel", dependsOnMethods = "verificarWidGetsAoTrocarDeEmpresa")
	public void alterarCorPainelPortal() {
		acao.clicarNoElemento(botaoAbrirCaixaDeCores);
		espera.aguardarElementoEstarVisivel(caixaDeCoresAberta);
		acao.clicarNoElemento(selecionarCorVermelha);
		espera.aguardarElementoEstarVisivel(painelRelatoriosVermelho);
		espera.aguardarElementoDesaparecer(caixaDeCoresAberta);
		acao.clicarNoElemento(botaoAbrirCaixaDeCores);
		espera.aguardarElementoEstarVisivel(caixaDeCoresAberta);
		acao.clicarNoElemento(selecionarCorCinza);
		espera.aguardarElementoEstarVisivel(painelRelatoriosCinza);
	}

	@Test(testName = "id: 23 - Fazer um repasse e verificar se notificação aparecerá na lista de notificações do portal.", dependsOnMethods = "alterarCorPainelPortal")
	public void testeNotificacao() throws Exception {
		acao.clicarNoElemento(abrirNotificacoes);
		espera.aguardarElementoEstarVisivel(By.xpath("//div[contains(@id,'div-notificacoes')]"));
		acao.clicarNoElemento(abrirNotificacoes);
		espera.aguardarElementoDesaparecer(By.xpath("//div[contains(@id,'div-notificacoes')]"));
		rotina.selecionarRotina("arc115");
		acao.clicarNoElemento(rotina, rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento("arcatualizacaoId", "16");
		acao.clicarNoElemento(rotina, rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "botaoValidacao");
		espera.aguardarElementoEstarVisivel("idAcao");
		acao.selecionarNoElemento("idAcao", "Validar");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "idDestino-1");
		acao.abrirLov(rotina, "idDestino-1");
		rotina.filtrarESelecionarValorNaLov("Usuario teste");
		acao.clicarNoElemento(rotina, "campoDescricao-1");
		acao.escreverNoElemento("campoDescricao-1", "teste notificação");
		acao.clicarNoElemento(rotina, "botaoConfirmar");
		rotina.aguardarProcessarRotina();
		msg.aguardarMensagem("Repasse realizado com sucesso!");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		msg.aguardarMensagemDesaparecer("Repasse realizado com sucesso!");
		espera.aguardarMensagemDesaparecer();
		rotina.fecharRotina("arc115");
		navegador.atualizarBrowser();
		espera.aguardarSistemaCarregar();
		espera.aguardarElementoEstarVisivel(abrirNotificacoes);
		acao.clicarNoElemento(abrirNotificacoes);
		espera.aguardarElementoEstarVisivel(voceTemUmNovoRecado);
	}

	@Parameters(value = { "url" })
	@Test(testName = "id: 19 - Abrir rotina diretamente pelo link passado com parametro informado.", dependsOnMethods = "testeNotificacao")
	public void abrirRotinaAoAbrirPortalParametrizadoPelaUrl(String url) throws AWTException, InterruptedException {
		sairPortal();
		navegador.alterarUrl(url + "?arcrotina=parc107&id_rotina=41");
		logar.logarSemAlterarIdioma("usuario2", "usuario", "desenvolvimento");
		espera.aguardarElementoEstarVisivel(rotina.retornarRotinaCarregada("arc107"));
		espera.aguardarAtributoDoElementoConterOValor(campoIdRotina, 0, "value", "41");
	}

	@Parameters(value = { "url" })
	@Test(testName = "id: 20 - Abrir rotina diretamente pelo link passado caso o usuario ja esteja logado.", dependsOnMethods = "abrirRotinaAoAbrirPortalParametrizadoPelaUrl")
	public void abrirRotinaParametrizadoPelaUrlComUsuarioLogado(String url) throws AWTException, InterruptedException {
		navegador.alterarUrl(url + "?arcrotina=parc107&id_rotina=41");
		espera.aguardarElementoEstarVisivel(rotina.retornarRotinaCarregada("arc107"));
		espera.aguardarAtributoDoElementoConterOValor(campoIdRotina, 0, "value", "41");
	}

	@Parameters(value = { "url" })
	@Test(testName = "id: 21 - Abrir rotina diretamente pelo link passado sem parametro informado.", dependsOnMethods = "abrirRotinaParametrizadoPelaUrlComUsuarioLogado")
	public void abrirRotinaPelaUrlSemParametro(String url) throws AWTException, InterruptedException {
		sairPortal();
		navegador.alterarUrl(url + "?arcrotina=parc107");
		logar.logarSemAlterarIdioma("usuario2", "usuario", "desenvolvimento");
		espera.aguardarElementoEstarVisivel(rotina.retornarRotinaCarregada("arc107"));
		testar.passouSeAtributoDoElementoForNulo(campoIdRotina, 0, "value");
		espera.aguardarSistemaCarregar();
	}

	@Parameters(value = { "url" })
	@Test(testName = "id: 22 - Abrir rotina diretamente pelo link passado sem parametro informado caso o usuario ja esteja logado.", dependsOnMethods = "abrirRotinaPelaUrlSemParametro")
	public void abrirRotinaPelaUrlSemParametroComUsuarioLogado(String url) throws AWTException, InterruptedException {
		navegador.alterarUrl(url + "?arcrotina=parc107");
		espera.aguardarElementoEstarVisivel(rotina.retornarRotinaCarregada("arc107"));
		testar.passouSeAtributoDoElementoForNulo(campoIdRotina, 0, "value");
		espera.aguardarSistemaCarregar();
		sairPortal();
	}
}

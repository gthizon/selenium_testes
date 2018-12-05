package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.abaConfiguracoes;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.barraRolagemPaginaAnterior;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.barraRolagemRegistroAnterior;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.botaoAbrirLovGrupoEmpresa;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.botaoAbrirOutraRotina;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.botaoCancelarAberturaRotina;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.botaoCarregarAcessos;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.botaoLovUsuarioCopiarAcesso;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.botaoMostrarRotinaAberta;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.botaoRemoverImagem;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.campoAlterarSenhaArc001;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.campoBaseEmpresaCopiarAcesso;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.campoCodigoArc001;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.campoCodigoBaseArc001;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.campoCodigoBaseArc001Linha2;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.campoCodigoBaseNovoRegistorArc001;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.campoDataFim;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.campoDataInicio;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.campoHoraFim;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.campoHoraInicio;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.campoRegraAcesso;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.campoSituacaoUsuario;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.campoUsuarioCopiarAcesso;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.imagemCarregada;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.mensagemSemResultadoParaValorCampoBase;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.mensagemUsuarioBloqueado;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.mensagemUsuarioBloqueadoPelasRegrasDeAcesso;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.mensagemUsuarioSeraBloqueado;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.mensagemValorInvalidoCampoBase;
import static br.com.projedata.arcturus.teste.webelements.Parc001Elementos.verificarTotalDeRotinasAbertasArc001;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.barraRolagemProximoRelatorio;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.barraRolagemProximoRelatorioDesabilitada;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.botaoBloquearDesabilitado;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.botaoClonarDesabilitado;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.botaoEditarDesabilitado;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.botaoExcluirDesabilitado;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.botaoExecutarHabilitado;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.botaoNovoRelatorio;
import static br.com.projedata.arcturus.teste.webelements.Pger001Elementos.campoCodigoRelatorio;

import java.awt.AWTException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.Parc001Metodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;
import br.com.projedata.arcturus.teste.webelements.PortalElementos;

public class TesteParc001 extends TesteGenerico {

	String elementoFocado;
	private String anexo1Windows = "\\\\arquivos.prj\\qualidade\\Gustavo\\anexos_testes\\peixe.png";
	LoginMetodos login;
	Parc001Metodos parc001;

	@Parameters(value = { "login", "senha", "base" })
	@Test(testName = "id: 1 - Verificar se esta sendo possivel limpar o valor da combobox selecionando valor em branco")
	public void selecionarValorEmBrancoComboBox(String usuario, String senha, String base) {
		login = new LoginMetodos(this);
		login.logar(usuario, senha, base);
		parc001 = new Parc001Metodos(this);
		rotina.selecionarRotina("arc001", "p");
		espera.aguardarElementoEstarVisivel(rotina.rotinaCarregada);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoArc001, "550922925");
		acao.clicarNoElemento(rotina, rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		Select campoAlterarSenha = new Select(webDriver.findElement(campoAlterarSenhaArc001));
		WebElement selecionado = null;
		try {
			selecionado = campoAlterarSenha.getFirstSelectedOption();
		} catch (NoSuchElementException e) {
			acao.selecionarNoElemento(campoAlterarSenhaArc001, "Não");
			teclado.pressionarTeclaDeControle(Keys.F10);
			teclado.pressionarTeclaDeControle(Keys.ESCAPE);
			selecionado = campoAlterarSenha.getFirstSelectedOption();
		}
		String itemSelecionado = selecionado.getText();

		if (itemSelecionado.equals("Sim")) {
			campoAlterarSenha.selectByValue("N");
			acao.clicarNoElemento(rotina.botaoSalvar);
			espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
			msg.fecharMensagemNotificacao();
		}
		campoAlterarSenha.selectByValue("S");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		campoAlterarSenha.selectByValue("");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		campoAlterarSenha.selectByValue("N");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}

	@Test(testName = "id: 2 - Verificar se nao permite sair do registro caso esteja invalido", dependsOnMethods = {
			"selecionarValorEmBrancoComboBox" }, enabled = true)
	public void naoPermitirSairDoRegistroQuandoInvalido() {
		acao.clicarNoElemento(rotina, rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoArc001, "05509522925");
		acao.clicarNoElemento(rotina, rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoBaseArc001);
		rotina.aguardarProcessarRotina();

		while (!rotina.posicaoRegistro().trim().equals(rotina.totalRegistros().trim())) {
			teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
		}
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.F6);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoBaseNovoRegistorArc001, "9999");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		elementoFocado = rotina.elementoAtualFocado();
		try {
			espera.aguardarElementoEstarVisivel(mensagemSemResultadoParaValorCampoBase);
		} catch (Exception e) {
			teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.TAB);
			rotina.aguardarProcessarRotina();
			acao.limparElemento(campoCodigoBaseNovoRegistorArc001);
			acao.escreverNoElemento(campoCodigoBaseNovoRegistorArc001, "5454");
			teclado.pressionarTeclaDeControle(Keys.TAB);
			rotina.aguardarProcessarRotina();
			elementoFocado = rotina.elementoAtualFocado();
			espera.aguardarElementoEstarVisivel(mensagemSemResultadoParaValorCampoBase);
		}
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(mensagemSemResultadoParaValorCampoBase);
		teclado.pressionarTeclaDeControle(Keys.ARROW_UP);
		espera.aguardarElementoEstarVisivel(mensagemValorInvalidoCampoBase);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(mensagemValorInvalidoCampoBase);
	}

	@Test(testName = "id: 3 - Com o registro invalido, pressionar F6 par atentar inserir um registro novo", dependsOnMethods = {
			"naoPermitirSairDoRegistroQuandoInvalido" }, enabled = true)
	public void teclarF6EmBlocoComRegistroInvalido() {
		teclado.pressionarTeclaDeControle(Keys.F6);
		espera.aguardarElementoEstarVisivel(mensagemValorInvalidoCampoBase);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(mensagemValorInvalidoCampoBase);
	}

	@Test(testName = "id: 4 - Com o registro invalido, pressionar F4 par atentar inserir um registro novo", dependsOnMethods = {
			"teclarF6EmBlocoComRegistroInvalido" }, enabled = true)
	public void teclarF4EmBlocoComRegistroInvalido() {
		teclado.pressionarTeclaDeControle(Keys.F4);
		espera.aguardarElementoEstarVisivel(mensagemValorInvalidoCampoBase);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(mensagemValorInvalidoCampoBase);
	}

	@Test(testName = "id: 5 - Verificar se nao permite sair do registro caso esteja invalido ao clicar na barra de rolagem", dependsOnMethods = {
			"teclarF4EmBlocoComRegistroInvalido" }, enabled = true)
	public void naoPermitirSairDoRegistroQuandoInvalidoClicandoNaBarraDeRolagem() {
		acao.clicarNoElemento(barraRolagemRegistroAnterior);
		acao.clicarNoElemento(barraRolagemPaginaAnterior);
		testar.passouSeValoresForemIguais(elementoFocado, rotina.elementoAtualFocado());
	}

	@Test(testName = "id: 27 - Testar se não permitira focar em outros campos quando o campo atual estiver inválido.", dependsOnMethods = {
			"naoPermitirSairDoRegistroQuandoInvalidoClicandoNaBarraDeRolagem" })
	public void verificarSeNaoPermiteSairDoCampoInvalido() {
		elementoFocado = rotina.elementoAtualFocado();
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(mensagemValorInvalidoCampoBase);
		acao.clicarNoElemento(campoAlterarSenhaArc001);
		acao.clicarNoElemento(campoAlterarSenhaArc001);
		espera.aguardarElementoEstarVisivel(mensagemValorInvalidoCampoBase);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(mensagemValorInvalidoCampoBase);
		testar.passouSeValoresForemIguais(elementoFocado, rotina.elementoAtualFocado());
		acao.clicarNoElemento("campo2801-1");
		testar.passouSeValoresForemIguais(elementoFocado, rotina.elementoAtualFocado());
		try {
			acao.clicarNoElemento(botaoCarregarAcessos);
			espera.aguardarElementoEstarVisivel(1,mensagemValorInvalidoCampoBase );
		} catch (Exception e) {
			acao.clicarNoElemento(botaoCarregarAcessos);
			espera.aguardarElementoEstarVisivel(mensagemValorInvalidoCampoBase);
		}
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(mensagemValorInvalidoCampoBase);
		testar.passouSeValoresForemIguais(elementoFocado, rotina.elementoAtualFocado());
		acao.clicarNoElemento(botaoCarregarAcessos);
		espera.aguardarElementoEstarVisivel(mensagemValorInvalidoCampoBase);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(mensagemValorInvalidoCampoBase);
		testar.passouSeValoresForemIguais(elementoFocado, rotina.elementoAtualFocado());
		acao.clicarNoElemento(botaoAbrirLovGrupoEmpresa);
		espera.aguardarElementoEstarVisivel(mensagemValorInvalidoCampoBase);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(mensagemValorInvalidoCampoBase);
		testar.passouSeValoresForemIguais(elementoFocado, rotina.elementoAtualFocado());

	}

	@Test(testName = "id: 6 - Copiar acesso usuario parc001", dependsOnMethods = {
			"verificarSeNaoPermiteSairDoCampoInvalido" }, enabled = true)
	public void copiarAcessoUsuarioArc001() throws InterruptedException, AWTException {
		acao.posicionarFocoNoElemento(rotina, rotina.botaoCancelar);
		acao.clicarNoElemento(rotina.botaoCancelar);
		espera.aguardarElementoEstarVisivel(msg.mensagemSalvarAlteracoesPendentes);
		acao.clicarNoElemento(msg.naoConfirmacao);
		espera.aguardarElementoDesaparecer(msg.mensagemSalvarAlteracoesPendentes);
		rotina.aguardarProcessarRotina();
		acao.posicionarFocoNoElemento(rotina, campoCodigoArc001);
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoArc001, "123456789");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.posicionarFocoNoElemento(rotina, campoUsuarioCopiarAcesso);
		acao.clicarNoElemento(botaoLovUsuarioCopiarAcesso);
		espera.aguardarElementoEstarVisivel(rotina.lov);
		acao.escreverNoElemento(rotina.filtrarLov, "gustavo");
		acao.clicarNoElemento(rotina.selecionarValorLov("Gustavo"));
		espera.aguardarElementoDesaparecer(rotina.lov);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoBaseEmpresaCopiarAcesso);
		rotina.aguardarProcessarRotina();

		acao.escreverNoElemento(campoBaseEmpresaCopiarAcesso, "1");
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.TAB);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();

		if (acao.localizarElementos(rotina.tolltipCampo).size() > 0) {
			teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.TAB);
			espera.aguardarElementoDesaparecer(rotina.tolltipCampo);
			teclado.pressionarTeclaDeControle(Keys.TAB);
		}
		try {
			acao.clicarNoElemento(botaoCarregarAcessos);
		} catch (Exception e) {
			teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.TAB);
			mouse.moverCursorParaElemento(campoCodigoArc001);
			espera.aguardarElementoDesaparecer(rotina.tolltipCampo);
			teclado.pressionarTeclaDeControle(Keys.TAB);
			acao.clicarNoElemento(botaoCarregarAcessos);
		}
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemRegistrosAlterados);
		acao.limparElemento(campoBaseEmpresaCopiarAcesso);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();

		acao.posicionarFocoNoElemento(rotina, campoCodigoBaseArc001);
		while (!webDriver.findElement(campoCodigoBaseArc001).getAttribute("value").isEmpty()) {
			teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
			rotina.aguardarProcessarRotina();
		}
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}

	@Test(testName = "id: 7 - Digitar na busca da Lov varias opcoes separadas por %.", dependsOnMethods = {
			"copiarAcessoUsuarioArc001" }, enabled = true)
	public void filtrarLovComVariosTextosSimultaneos() {
		acao.escreverNoElemento(campoCodigoBaseArc001, "1");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();

		acao.clicarNoElemento(botaoAbrirLovGrupoEmpresa);
		espera.aguardarElementoEstarVisivel(rotina.lov);
		acao.escreverNoElemento(rotina.filtrarLov, "1%Ace%Adm");
		espera.aguardarElementoEstarVisivel(rotina.selecionarValorLov("Adm"));
		testar.passouSeValorContem(acao.localizarElemento(rotina.selecionarValorLov("Ace")).getText(), "Ace");
		testar.passouSeValorContem(acao.localizarElemento(rotina.selecionarValorLov("1")).getText(), "1");
		testar.passouSeValorContem(acao.localizarElemento(rotina.selecionarValorLov("Adm")).getText(), "Adm");
		acao.clicarNoElemento(rotina.fecharLov);
		espera.aguardarElementoDesaparecer(rotina.lov);
		rotina.aguardarProcessarRotina();
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 8 - Testar abertura da mesma rotina mais de uma vez e clicar para mostrar rotina aberta", dependsOnMethods = {
			"filtrarLovComVariosTextosSimultaneos" }, enabled = true)
	public void mostrarRotinaAberta() {
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F3);
		acao.limparElemento(PortalElementos.localizarRotina);
		rotina.selecionarRotina("arc001", "p");
		espera.aguardarElementoDesaparecer(rotina.listaRotinasAberta);
		espera.aguardarElementoEstarVisivel(botaoMostrarRotinaAberta);
		acao.clicarNoElemento(botaoMostrarRotinaAberta);
		espera.aguardarElementoDesaparecer(botaoMostrarRotinaAberta);
		rotina.aguardarProcessarRotina();
		int totalRotinas = webDriver.findElements(verificarTotalDeRotinasAbertasArc001).size();
		testar.passouSeValoresSaoIguais(totalRotinas, 1);
	}

	@Test(testName = "id: 9 - Cancelar abertura de rotina", dependsOnMethods = { "mostrarRotinaAberta" }, enabled = true)
	public void cancelarAberturaDeRotina() {
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F3);
		acao.limparElemento(rotina.localizarRotina);
		rotina.selecionarRotina("arc001", "p");
		espera.aguardarElementoDesaparecer(rotina.listaRotinasAberta);
		espera.aguardarElementoEstarVisivel(botaoMostrarRotinaAberta);
		acao.clicarNoElemento(botaoCancelarAberturaRotina);
		espera.aguardarElementoDesaparecer(botaoCancelarAberturaRotina);
		rotina.aguardarProcessarRotina();
		int totalRotinas = webDriver.findElements(verificarTotalDeRotinasAbertasArc001).size();
		testar.passouSeValoresSaoIguais(totalRotinas, 1);
	}

	@Test(testName = "id: 10 - Testar abertura da mesma rotina mais de uma vez", dependsOnMethods = {
			"cancelarAberturaDeRotina" }, enabled = true)
	public void abrirOutraRotina() {
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F3);
		acao.limparElemento(rotina.localizarRotina);
		rotina.selecionarRotina("arc001", "p");
		espera.aguardarElementoDesaparecer(rotina.listaRotinasAberta);
		espera.aguardarElementoEstarVisivel(botaoAbrirOutraRotina);
		acao.clicarNoElemento(botaoAbrirOutraRotina);
		espera.aguardarElementoDesaparecer(botaoAbrirOutraRotina);
		rotina.aguardarProcessarRotina();
		int totalRotinas = webDriver.findElements(verificarTotalDeRotinasAbertasArc001).size();
		testar.passouSeValoresSaoIguais(totalRotinas, 2);
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F4);
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 11 - Testar criacao de registro com a seta do teclado e verificar se posiciona o foco corretamente", dependsOnMethods = {
			"abrirOutraRotina" }, enabled = true)
	public void criarRegistroComASetaDoTeclado() {
		acao.clicarNoElemento(campoCodigoArc001);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoArc001, "123456789");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoBaseArc001);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoBaseArc001, "1");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
		rotina.aguardarProcessarRotina();
		testar.passouSeElementoFocadoFor(campoCodigoBaseArc001Linha2);
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
		rotina.aguardarProcessarRotina();
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}

	@Test(testName = "id: 12 - Inserir imagem na arc001", dependsOnMethods = { "criarRegistroComASetaDoTeclado" }, enabled = true)
	public void adicionarImagemArc001() throws AWTException, InterruptedException {
		acao.clicarNoElemento(campoCodigoArc001);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoArc001, "2284769926");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		String anexo1Linux = "/projedata/anexos/peixe.png";
		acao.posicionarFocoNoElemento(rotina, campoCodigoArc001);

//		acao.clicarNoElemento(botaoCarregarImagem);
//		String SO = System.getProperty("os.name").toLowerCase();
//		if (SO.contains("win")) {
//			rotina.uploadFilesWindows(anexo1Windows);
//			espera.aguardarElementoEstarVisivel(imagemCarregada);
//		} else if (SO.contains("linux")) {
//			rotina.uploadFilesLinux(anexo1Linux);
//			espera.aguardarElementoEstarVisivel(imagemCarregada);
//		}

		rotina.uploadFiles("campo16448-1-0", anexo1Linux);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(imagemCarregada);
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}

	@Test(testName = "id: 13 - Remover imagem na arc001", dependsOnMethods = { "adicionarImagemArc001" }, enabled = true)
	public void removerImagemArc001() throws AWTException, InterruptedException {
		acao.clicarNoElemento(imagemCarregada);
		espera.aguardarElementoEstarVisivel(botaoRemoverImagem);
		acao.clicarNoElemento(botaoRemoverImagem);
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		espera.aguardarElementoDesaparecer(imagemCarregada);
	}

	@Test(testName = "id: 14 - Bloquear usuario apos varias tentativas de acesso", dependsOnMethods = {
			"removerImagemArc001" }, enabled = true)
	public void bloquearUsuarioPorExcessoDetentativasDeAcesso() {
		sairPortal();
		login.preencherCamposLogin("testegeral", "teste", "desenvolvimento");
		msg.aguardarMensagem("Usuário e/ou senha inválidos");
		login.preencherCamposLogin("testegeral", "teste", "desenvolvimento");
		login.preencherCamposLogin("testegeral", "teste", "desenvolvimento");
		login.preencherCamposLogin("testegeral", "teste", "desenvolvimento");
		login.preencherCamposLogin("testegeral", "teste", "desenvolvimento");
		login.preencherCamposLogin("testegeral", "teste", "desenvolvimento");
		login.preencherCamposLogin("testegeral", "teste", "desenvolvimento");
		login.preencherCamposLogin("testegeral", "teste", "desenvolvimento");
		login.preencherCamposLogin("testegeral", "teste", "desenvolvimento");
		login.preencherCamposLogin("testegeral", "teste", "desenvolvimento");
		espera.aguardarElementoEstarVisivel(mensagemUsuarioSeraBloqueado);
		login.preencherCamposLogin("testegeral", "teste", "desenvolvimento");
		espera.aguardarElementoEstarVisivel(mensagemUsuarioBloqueado);
		msg.fecharMensagemNotificacao();
	}

	@Test(testName = "id: 15 - verifica se a situacao do usuario esta como bloqueado", dependsOnMethods = {
			"bloquearUsuarioPorExcessoDetentativasDeAcesso" }, enabled = true)
	public void verificarSituacaoUsuarioBloqueado() {
		login.logar("gustavo.projedata", "guth055", "desenvolvimento");
		rotina.selecionarRotina("arc001", "p");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		acao.escreverNoElemento(campoCodigoArc001, "777");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		testar.passouSeValorDoElementoSelecionadoFor(campoSituacaoUsuario, "Bloqueado");
	}

	@Test(testName = "id: 16 - desbloquear usuario", dependsOnMethods = { "verificarSituacaoUsuarioBloqueado" }, enabled = true)
	public void desbloquearUsuario() {
		acao.selecionarNoElemento(campoSituacaoUsuario, "Ativo");
		acao.clicarNoElemento(rotina, rotina.botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		sairPortal();
	}

	@Test(testName = "id: 17 - acessar sistema novamente com usuario desbloqueado", dependsOnMethods = {
			"desbloquearUsuario" }, enabled = true)
	public void acessarSistemaComUsuarioDesbloqueado() {
		login.logar("testegeral", "guth055", "desenvolvimento");
		sairPortal();
	}

	@Test(testName = "id: 18 - logar invalido com usuario token e verificar se nao bloquera o acesso", dependsOnMethods = {
			"acessarSistemaComUsuarioDesbloqueado" }, enabled = true)
	public void verificarSeNaoBloqueiaUsuarioToken() {
		int i = 0;
		while (i < 12) {
			login.preencherCamposLogin("05509522925", "guth055", "desenvolvimento");
			i++;
		}
		testar.passouSeElementoNaoExistir(rotina.localizarRotina);
	}

	@Test(testName = "id: 19 - Testar controle de acesso, liberar acesso em determinado horario", dependsOnMethods = {
			"verificarSeNaoBloqueiaUsuarioToken" }, enabled = true)
	public void testarControleAcessoLiberarHoraFim() {
		login.logar("testeacesso", "guth055", "desenvolvimento");
		rotina.selecionarRotina("arc001", "p");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoArc001, "3333");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(abaConfiguracoes);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(campoRegraAcesso);
		acao.selecionarNoElemento(campoRegraAcesso, 0, "Liberar");
		acao.escreverNoElementoNaPosicao(campoHoraInicio, 0, "0000");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElementoNaPosicao(campoHoraFim, 0, rotina.subtrairMinutosNaDataAtual(4));
		acao.clicarNoElemento(rotina.botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemRegistrosAlterados);
		sairPortal();
		login.preencherCamposLogin("testeacesso", "guth055", "desenvolvimento");
		espera.aguardarElementoEstarVisivel(mensagemUsuarioBloqueadoPelasRegrasDeAcesso);
	}

	@Test(testName = "id: 20 - Testar controle de acesso, liberar acesso ate determinado horario", dependsOnMethods = {
			"testarControleAcessoLiberarHoraFim" }, enabled = true)
	public void testarControleAcessoLiberarHoraInicio() {
		login.logar("gustavo.projedata", "guth055", "desenvolvimento");
		rotina.selecionarRotina("arc001", "p");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoArc001, "3333");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(abaConfiguracoes);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(campoRegraAcesso);
		acao.limparElementoNaPosicao(campoHoraInicio, 0);
		acao.escreverNoElementoNaPosicao(campoHoraInicio, 0, rotina.adicionarMinutosNaDataAtual(3));
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemRegistrosAlterados);
		sairPortal();
		login.preencherCamposLogin("testeacesso", "guth055", "desenvolvimento");
		espera.aguardarElementoEstarVisivel(mensagemUsuarioBloqueadoPelasRegrasDeAcesso);

	}

	@Test(testName = "id: 21 - Testar controle de acesso, bloquear acesso ate determinado horario", dependsOnMethods = {
			"testarControleAcessoLiberarHoraInicio" }, enabled = true)
	public void testarControleAcessoBloquearHoraFim() {
		login.logar("gustavo.projedata", "guth055", "desenvolvimento");
		rotina.selecionarRotina("arc001", "p");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoArc001, "3333");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(abaConfiguracoes);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(campoRegraAcesso);
		acao.selecionarNoElemento(campoRegraAcesso, 0, "Bloquear");
		acao.limparElementoNaPosicao(campoHoraInicio, 0);
		acao.escreverNoElementoNaPosicao(campoHoraInicio, 0, "0000");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.limparElementoNaPosicao(campoHoraFim, 0);
		acao.escreverNoElementoNaPosicao(campoHoraFim, 0, rotina.adicionarMinutosNaDataAtual(5));
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoSalvar);
		msg.aguardarMensagem(
				"Atenção! Se existirem apenas regras para bloquear os acessos do usuário, o mesmo não poderá fazer login no sistema.");
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarElementoDesaparecer(msg.okNotificacao);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemRegistrosAlterados);
		sairPortal();
		login.preencherCamposLogin("testeacesso", "guth055", "desenvolvimento");
		msg.aguardarMensagem("Acesso bloqueado");

	}

	@Test(testName = "id: 22 - Testar controle de acesso, bloquear acesso em determinado horario subtrairMinutosNaDataAtual", dependsOnMethods = {
			"testarControleAcessoBloquearHoraFim" }, enabled = true)
	public void testarControleAcessoBloquearHoraInicio() {
		login.logar("gustavo.projedata", "guth055", "desenvolvimento");
		rotina.selecionarRotina("arc001", "p");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoArc001, "3333");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(abaConfiguracoes);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(campoRegraAcesso);
		acao.selecionarNoElemento(campoRegraAcesso, 0, "Bloquear");
		acao.limparElementoNaPosicao(campoHoraInicio, 0);
		acao.escreverNoElementoNaPosicao(campoHoraInicio, 0, rotina.subtrairMinutosNaDataAtual(2));
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.limparElementoNaPosicao(campoHoraFim, 0);
		acao.escreverNoElementoNaPosicao(campoHoraFim, 0, "0000");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoSalvar);
		msg.aguardarMensagem(
				"Atenção! Se existirem apenas regras para bloquear os acessos do usuário, o mesmo não poderá fazer login no sistema.");
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarElementoDesaparecer(msg.okNotificacao);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemRegistrosAlterados);
		sairPortal();
		login.preencherCamposLogin("testeacesso", "guth055", "desenvolvimento");
		espera.aguardarElementoEstarVisivel(mensagemUsuarioBloqueadoPelasRegrasDeAcesso);
	}

	@Test(testName = "id: 23 - Testar controle de acesso, bloquear acesso a partir da data", dependsOnMethods = {
			"testarControleAcessoBloquearHoraInicio" }, enabled = true)
	public void testarControleAcessoBloquearDataInicio() {
		login.logar("gustavo.projedata", "guth055", "desenvolvimento");
		rotina.selecionarRotina("arc001", "p");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoArc001, "3333");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(abaConfiguracoes);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(campoRegraAcesso);
		acao.limparElementoNaPosicao(campoHoraInicio, 0);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.limparElementoNaPosicao(campoHoraFim, 0);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElementoNaPosicao(campoDataInicio, 0, rotina.subtrairMinutosDataHoraAtual(4));
		teclado.pressionarTeclaDeControle(Keys.TAB);
		acao.clicarNoElemento(rotina.botaoSalvar);
		msg.aguardarMensagem(
				"Atenção! Se existirem apenas regras para bloquear os acessos do usuário, o mesmo não poderá fazer login no sistema.");
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarElementoDesaparecer(msg.okNotificacao);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemRegistrosAlterados);
		sairPortal();
		login.preencherCamposLogin("testeacesso", "guth055", "desenvolvimento");
		espera.aguardarElementoEstarVisivel(mensagemUsuarioBloqueadoPelasRegrasDeAcesso);

	}

	@Test(testName = "id: 24 - Testar controle de acesso, bloquear acesso ate a data", dependsOnMethods = {
			"testarControleAcessoBloquearDataInicio" }, enabled = true)
	public void testarControleAcessoBloquearDataFim() {
		login.logar("gustavo.projedata", "guth055", "desenvolvimento");
		rotina.selecionarRotina("arc001", "p");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoArc001, "3333");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(abaConfiguracoes);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(campoRegraAcesso);
		acao.limparElementoNaPosicao(campoHoraInicio, 0);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.limparElementoNaPosicao(campoHoraFim, 0);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.limparElementoNaPosicao(campoDataInicio, 0);
		acao.clicarNoElemento(rotina, campoDataFim);
		acao.escreverNoElementoNaPosicao(campoDataFim, 0, rotina.adicionarMinutosDataHoraAtual(4));
		acao.clicarNoElemento(rotina.botaoSalvar);
		msg.aguardarMensagem(
				"Atenção! Se existirem apenas regras para bloquear os acessos do usuário, o mesmo não poderá fazer login no sistema.");
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarElementoDesaparecer(msg.okNotificacao);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemRegistrosAlterados);
		sairPortal();
		login.preencherCamposLogin("testeacesso", "guth055", "desenvolvimento");
		espera.aguardarElementoEstarVisivel(mensagemUsuarioBloqueadoPelasRegrasDeAcesso);
	}

	@Test(testName = "id: 25 - Testar controle de acesso, bloquear pelo dia da semana", dependsOnMethods = {
			"testarControleAcessoBloquearDataFim" }, enabled = true)
	public void testarBloqueioDeAcessoDiasDaSemana() {
		login.logar("gustavo.projedata", "guth055", "desenvolvimento");
		rotina.selecionarRotina("arc001", "p");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoArc001, "3333");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(abaConfiguracoes);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(campoRegraAcesso);
		acao.limparElementoNaPosicao(campoHoraInicio, 0);
		acao.clicarNoElemento(rotina.botaoExcluir);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemRegistrosAlterados);
		acao.selecionarNoElemento(campoRegraAcesso, 0, "Bloquear");
		String diaSemana = rotina.retornarDiaDaSemana(rotina.retornarDataAtual());
		acao.clicarNoElemento(parc001.checkDiaDaSemana(diaSemana));
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoSalvar);
		msg.aguardarMensagem(
				"Atenção! Se existirem apenas regras para bloquear os acessos do usuário, o mesmo não poderá fazer login no sistema.");
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarElementoDesaparecer(msg.okNotificacao);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemRegistrosAlterados);
		sairPortal();
		login.preencherCamposLogin("testeacesso", "guth055", "desenvolvimento");
		espera.aguardarElementoEstarVisivel(mensagemUsuarioBloqueadoPelasRegrasDeAcesso);

		login.logar("gustavo.projedata", "guth055", "desenvolvimento");
		rotina.selecionarRotina("arc001", "p");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoArc001, "3333");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(abaConfiguracoes);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(campoRegraAcesso);
		acao.limparElementoNaPosicao(campoHoraInicio, 0);
		acao.clicarNoElemento(rotina.botaoExcluir);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemRegistrosAlterados);
	}

	@Test(testName = "id: 26 - Posicionar o foco em uma campo combobox e clicar nos botoes de navegacao. Verificar se os registros sao alterados", dependsOnMethods = {
			"testarBloqueioDeAcessoDiasDaSemana" }, enabled = true)
	public void testarPassagemDeRegistroComFocoNoComboBox() {
		acao.clicarNoElemento(campoCodigoArc001);
		rotina.aguardarProcessarRotina();
		rotina.limparCampoERealizarNovaConsulta();
		acao.posicionarFocoNoElemento(rotina, campoAlterarSenhaArc001);
		String codigoUsuario = acao.retornarValorDoElemento(campoCodigoArc001);
		acao.clicarNoElemento(rotina.botaoProximaPagina);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.fecharMensagemNotificacao);
		testar.passouSeAtributoDoElementoForDiferenteDe(campoCodigoArc001, "value", codigoUsuario);

		codigoUsuario = acao.retornarValorDoElemento(campoCodigoArc001);
		acao.clicarNoElemento(rotina.botaoProximoRegistro);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.fecharMensagemNotificacao);
		testar.passouSeAtributoDoElementoForDiferenteDe(campoCodigoArc001, "value", codigoUsuario);

		codigoUsuario = acao.retornarValorDoElemento(campoCodigoArc001);
		acao.clicarNoElemento(rotina.botaoRegistroAnterior);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.fecharMensagemNotificacao);
		testar.passouSeAtributoDoElementoForDiferenteDe(campoCodigoArc001, "value", codigoUsuario);

		codigoUsuario = acao.retornarValorDoElemento(campoCodigoArc001);
		acao.clicarNoElemento(rotina.botaoPaginaAnterior);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.fecharMensagemNotificacao);
		testar.passouSeAtributoDoElementoForDiferenteDe(campoCodigoArc001, "value", codigoUsuario);
	}

	@Test(testName = "id: 28 - Testar permissão de acesso a rotina para o usuário", dependsOnMethods = {
			"testarPassagemDeRegistroComFocoNoComboBox" }, enabled = true)
	public void testarPermissaoDeAcesso() {
		acao.clicarNoElemento(campoCodigoArc001);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoArc001, "05509522925");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.selecionarAba("aba16477");
		espera.aguardarElementoEstarVisivel(campoCodigoBaseArc001);
		acao.clicarNoElemento(campoCodigoBaseArc001);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento("arcusuarioacessoIdRotina", 0);
		acao.escreverNoElementoNaPosicao("arcusuarioacessoIdRotina", 0, "53");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElementoPeloValor("arcusuarioacessoPermissao", 0, "S");// Sem acesso rger2
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento("arcusuarioacessoIdRotina", 0);
		acao.escreverNoElementoNaPosicao("arcusuarioacessoIdRotina", 0, "74");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElementoPeloValor("arcusuarioacessoPermissao", 0, "C");// Consulta rger5
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		sairPortal();
		login.logar("gustavo.projedata", "guth055", "desenvolvimento");
		rotina.selecionarRotina("ger001");

		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigoRelatorio, 0);
		rotina.aguardarProcessarRotina();
		rotina.limparCampoERealizarNovaConsulta();
		int posicao = 0;
		while (!acao.localizarElementos(campoCodigoRelatorio).get(posicao).getAttribute("value").equals("rger5")) {
			if (acao.localizarElementos(barraRolagemProximoRelatorioDesabilitada).size() == 0) {
				acao.clicarNoElemento(barraRolagemProximoRelatorio);
				rotina.aguardarProcessarRotina();
				posicao = -1;
			}
			posicao++;
		}

		testar.passouSeElementoEstiverHabilitado(botaoNovoRelatorio);
		testar.passouSeElementoEstiverHabilitado(botaoExecutarHabilitado);
		testar.passouSeElementoEstiverDesabilitado(botaoExcluirDesabilitado);
		testar.passouSeElementoEstiverDesabilitado(botaoEditarDesabilitado);
		testar.passouSeElementoEstiverDesabilitado(botaoBloquearDesabilitado);
		testar.passouSeElementoEstiverDesabilitado(botaoClonarDesabilitado);
	}

	@Test(testName = "id: 29 - Testar usuário sem permissão para a rotina ", dependsOnMethods = {
			"testarPermissaoDeAcesso" }, enabled = true)
	public void testarUsuarioSemPermissaoDeAcesso() {
		acao.clicarNoElemento(campoCodigoRelatorio, 0);
		rotina.aguardarProcessarRotina();
		rotina.limparCampoERealizarNovaConsulta();
		boolean resultadoFalhou = true;
		int posicao = 0;
		try {
			while (!acao.localizarElementos(campoCodigoRelatorio).get(posicao).getAttribute("value").equals("rger2")) {
				if (acao.localizarElementos(barraRolagemProximoRelatorioDesabilitada).size() == 0) {
					acao.clicarNoElemento(barraRolagemProximoRelatorio);
					rotina.aguardarProcessarRotina();
					posicao = -1;
				}
				posicao++;
			}
		} catch (IndexOutOfBoundsException e) {
			testar.testePassou();
			resultadoFalhou = false;
		}
		if (resultadoFalhou) {
			testar.testeFalhou();
		}
		rotina.fecharRotina("ger001");
		retornarPermissao();
	}

	public void retornarPermissao() {
		rotina.selecionarRotina("arc001", "p");
		acao.clicarNoElemento(campoCodigoArc001);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigoArc001, "05509522925");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.selecionarAba("aba16477");
		espera.aguardarElementoEstarVisivel(campoCodigoBaseArc001);
		acao.clicarNoElemento(campoCodigoBaseArc001);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento("arcusuarioacessoIdRotina", 0);
		acao.escreverNoElementoNaPosicao("arcusuarioacessoIdRotina", 0, "53");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElementoPeloValor("arcusuarioacessoPermissao", 0, "C");// Sem acesso rger2
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento("arcusuarioacessoIdRotina", 0);
		acao.escreverNoElementoNaPosicao("arcusuarioacessoIdRotina", 0, "74");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElementoPeloValor("arcusuarioacessoPermissao", 0, "T");// Consulta rger5
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}
}

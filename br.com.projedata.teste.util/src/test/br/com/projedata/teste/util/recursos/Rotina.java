package br.com.projedata.teste.util.recursos;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Rotina {

	public WebDriver webDriver;
	public Espera espera;
	public Acao acao;
	public Teclado teclado;

	public Rotina(WebDriver webDriver, Espera espera, Acao acao, Teclado teclado) {
		this.webDriver = webDriver;
		this.espera = espera;
		this.acao = acao;
		this.teclado = teclado;
	}

	public static final By estaProcessando = By.xpath("//div[@class='processando-rotina']");
	public static final By botaoFecharLov = By.xpath("//div[@id='cabecalho-lov']//following::div[@title='Fechar']");
	public static final By modalLov = By.id("cabecalho-lov");
	public static final By rotinaCarregada = By.xpath("//li[contains(@class,'info-navegacao')]//child::span[contains(text(),'1/')]");
	public By botaoConfirmacaoFecharRotina = By.xpath("//b[@class='rotina-fechar-sim btn-xs btn-primary']");
	public By blocoDeRegistrosAlterados = By.xpath("//li[contains(@class,'info-navegacao')]//child::span[contains(text(),'Alterados')]");
	public By sairPortal = By.xpath("//div[@title='Sair do sistema']");
	public By botaoProcessarFiltros = By.xpath("//*[contains(@id,'b_processar_filtro')]");
	public By filtrarLov = By.xpath("//div[@id='cabecalho-lov']//following::input[@placeholder='Localizar']");
	public By listaRotinasAberta = By.xpath("//div[@class='portal-div-painel exibir-rotinas']");
	public By componenteCalendario = By.xpath("//div[contains(@class,'flatpickr-calendar') and contains(@class,'open')]");
	public By modoConsulta = By.xpath("//li[@class='info-navegacao']/span[text()='Modo Consulta' or text()='Query Mode']");
	public By localizarRotina = By.xpath("//div[@class='localizar-rotina barra-ferramentas-item']//input");
	public By botaoSalvar = By
			.xpath("//div[@class='janela-modal-componente']//ancestor::button[@class='salvar' or contains(@id,'salvar_')]");
	public By botaoSalvarDesabilitado = By.xpath("//button[@class='salvar desabilitado']");
	public By botaoConsultar = By.xpath("//button[@class='buscar' or contains(@id,'consultar_')]");
	public By botaoLimparConsulta = By.xpath("//button[@class='limpar' or contains(@id,'limpar_')]");
	public By botaoExcluir = By.xpath("//button[@class='excluir' or contains(@id,'excluir_')]");
	public By botaoExcluirDesabilitado = By.xpath("//button[@class='excluir desabilitado']");
	public By botaoCancelar = By.xpath("//button[@class='cancelar' or contains(@id,'cancelar_')]");
	public By botaoNovo = By.xpath("//button[@class='novo' or contains(@id,'novo_')]");
	public By botaoNovoDesabilitado = By.xpath("//button[@class='novo desabilitado']");
	public By botaoListar = By.xpath("//button[@class='listar']");
	public By botaoProximoRegistro = By.xpath("//button[contains(@class,'navegacao proximo')]");
	public By botaoProximaPagina = By.xpath("//button[contains(@class,'navegacao proxima-pagina')]");
	public By botaoRegistroAnterior = By.xpath("//button[contains(@class,'navegacao anterior')]");
	public By botaoPaginaAnterior = By.xpath("//button[contains(@class,'navegacao pagina-anterior')]");
	public By botaoImprimir = By.xpath("//button[contains(@id,'.botaoImprimir')]");
	public By botaoMostrarFiltros = By.xpath("//button[contains(@class,'filtro')]");
	public By botaoConfirmar = By.xpath("//button[contains(@class,'confirmar')]");
	public By listaDeRotinas = By.xpath("//div[@id='rotinas-sistema']");
	public By tolltipCampo = By.xpath("//div[contains(@class,'tooltip vue-tooltip-theme')]");
	public By modalAguardandoEncerramento = By.xpath("//p[contains(text(),'Aguardando encerramento da rotina')]");
	public By processandoLov = By.xpath("//div[@class='loader-component']");
	public By janelaConfirmacao = By.xpath("//*[@class='arcbox arcbox-dialog arcbox-info']");
	public By naoConfirmacao = By
			.xpath("//button[@class='btn-nao atalho-n' or @data-type='nao' or contains(@class,'btn-no') or @class='btn-N atalho-n']");
	public By modalAnimacaoPaginaInicial = By.xpath("//div[contains(@class, 'arcbox-modal') and contains(@style,'opacity: 0;')]");
	public By botaoAvancarPaginacaoLov = By.xpath("//*[@id='cabecalho-lov']/div/div[2]/div[1]");
	public By botaoRetornarPaginacaoLov = By.xpath("//*[@id='cabecalho-lov']/div/div[2]/div[2]");

	public void cancelarAlteracao() {
		acao.clicarNoElemento(botaoCancelar);
		espera.aguardarElementoEstarVisivel(Mensagem.naoConfirmacao);
		acao.clicarNoElemento(Mensagem.naoConfirmacao);
		espera.aguardarElementoDesaparecer(Mensagem.naoConfirmacao);
		aguardarProcessarRotina();
	}
	
	public void adicionarCampoMultiValorado(String elemento) {
		By componente = By.xpath("//button[contains(@name,'"+elemento+"') and contains(@style,'green')]");
		acao.localizarElemento(componente).click();
		aguardarProcessarRotina();
	}
	
	public void removerCampoMultiValorado(String elemento) {
		By componente = By.xpath("//button[contains(@name,'"+elemento+"') and contains(@style,'red')]");
		acao.localizarElemento(componente).click();
		aguardarProcessarRotina();
	}

	public By botaoFecharRotina(String rotina) {
		By botaoFechar = By.xpath("//p[contains(text(),'" + rotina.toUpperCase()
				+ "')]//following::*[@title='Fechar' or @title='Cerrar' or @title='Close'][1]");
		return botaoFechar;
	}

	public By verificarPaginaAtualLov(String pagina) {
		return By.xpath("//div[@class='coluna lov-paginacao']/p[contains(text(),'" + pagina + "/')]");
	}

	public By verificarPaginaAtualLovETotalDePaginas(String pagina, String total) {
		return By.xpath("//div[@class='coluna lov-paginacao']/p[contains(text(),'" + pagina + "/" + total + "')]");
	}

	public void aguardarProcessarRotina() {
		if (webDriver.findElements(modalAguardandoEncerramento).isEmpty()) {
			if (!webDriver.findElements(estaProcessando).isEmpty()) {
				espera.aguardarElementoDesaparecer(estaProcessando);
			}
		}
	}

	public By verificarLovAberta(String nomeLov) {
		espera.aguardarElementoDesaparecer(processandoLov);
		return By.xpath("//div[@id='cabecalho-lov']//parent::div[@title='" + nomeLov + "']");

	}

	public By retornarRotinaCarregada(String rotina) {
		String descRotina = rotina;
		boolean possuiChave = verificarSeStringPossuiNumeros(rotina);
		if (possuiChave) {
			descRotina = rotina.toUpperCase();
		}
		return By.xpath("//div[@class='titulo']/p[contains(text(),'" + descRotina
				+ "')]//following::li[contains(@class,'info-navegacao')]/span[contains(text(),'1/')]");
	}

	public By verificarRotinaCarregadaMoDoConsulta(String rotina) {
		return By.xpath("//div[@class='titulo']/p[contains(text(),'" + rotina.toUpperCase()
				+ "')]//following::li[contains(@class,'info-navegacao')]/span[contains(text(),'Modo Consulta')]");
	}

	public String retornarIdRotinaEmFoco(String rotina) {
		WebElement element = webDriver.findElement(By.xpath("//div[@class='titulo']/p[contains(text(),'" + rotina.toUpperCase()
				+ "')]//ancestor::div[@class='janela-modal-componente']"));
		return element.getAttribute("id").toString();
	}

	public void confirmarFecharRotina() throws InterruptedException {
		if (webDriver.findElements(botaoConfirmacaoFecharRotina).size() != 0) {
			acao.clicarNoElemento(botaoConfirmacaoFecharRotina);
		}
	}

	public String retornarConteudoDoPdf() throws InvalidPasswordException, IOException {
		WebDriverWait wait = new WebDriverWait(webDriver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='conteudo conteudo-relatorio']//iframe")));

		WebElement element = webDriver.findElement(By.xpath("//iframe[1]"));
		String data = element.getAttribute("src");

		URL url = new URL(data);
		BufferedInputStream file = new BufferedInputStream(url.openStream());

		PDDocument document = PDDocument.load(file);
		String output = new PDFTextStripper().getText(document);

		PDPageTree list = document.getPages();
		for (PDPage page : list) {
			PDResources pdResources = page.getResources();
			for (COSName c : pdResources.getXObjectNames()) {
				PDXObject o = pdResources.getXObject(c);
				if (o instanceof org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) {
					org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject imagem = ((org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) o);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ImageIO.write(imagem.getImage(), "png", baos);
					baos.flush();
					baos.close();
				}
			}
		}

		return output;
	}

	public ArrayList<Integer> verificarSeConteudoDoPdfPossuiImagens() throws InvalidPasswordException, IOException {
		WebDriverWait wait = new WebDriverWait(webDriver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='conteudo conteudo-relatorio']//iframe")));

		WebElement element = webDriver.findElement(By.xpath("//iframe[1]"));
		String data = element.getAttribute("src");

		URL url = new URL(data);
		BufferedInputStream file = new BufferedInputStream(url.openStream());

		PDDocument document = PDDocument.load(file);
		ArrayList<Integer> tamanhoArquivo = new ArrayList<>();
		PDPageTree list = document.getPages();
		for (PDPage page : list) {
			PDResources pdResources = page.getResources();
			for (COSName c : pdResources.getXObjectNames()) {
				PDXObject o = pdResources.getXObject(c);
				if (o instanceof org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) {
					org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject imagem = ((org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) o);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ImageIO.write(imagem.getImage(), "png", baos);
					baos.flush();
					tamanhoArquivo.add(baos.toByteArray().length);
					baos.close();
				}
			}
		}
		return tamanhoArquivo;
	}

	public ArrayList<String> retornarCodigoBarras() throws IOException, NotFoundException, ChecksumException, FormatException {

		WebDriverWait wait = new WebDriverWait(webDriver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='conteudo conteudo-relatorio']//iframe")));
		WebElement element = webDriver.findElement(By.xpath("//iframe[1]"));
		String data = element.getAttribute("src");
		URL url = new URL(data);
		BufferedInputStream file = new BufferedInputStream(url.openStream());
		PDDocument document = PDDocument.load(file);
		PDPageTree list = document.getPages();
		ArrayList<String> codigoBarras = new ArrayList<>();
		for (PDPage page : list) {
			PDResources pdResources = page.getResources();
			for (COSName c : pdResources.getXObjectNames()) {
				PDXObject o = pdResources.getXObject(c);
				if (o instanceof org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) {
					org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject imagem = ((org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) o);
					Reader reader = new MultiFormatReader();
					BufferedImage buffImage = imagem.getImage();
					LuminanceSource lsrc = new BufferedImageLuminanceSource(buffImage);

					BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(lsrc));
					try {
						Result result = reader.decode(bitmap);
						codigoBarras.add(result.getText());
					} catch (NotFoundException e) {
						// TODO: handle exception
					}
				}
			}
		}
		return codigoBarras;
	}

	public ArrayList<String> verificarTiposDeFonteNoPDF() throws IOException {
		WebDriverWait wait = new WebDriverWait(webDriver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='conteudo conteudo-relatorio']//iframe")));

		WebElement element = webDriver.findElement(By.xpath("//iframe[1]"));
		String data = element.getAttribute("src");
		URL url = new URL(data);
		BufferedInputStream file = new BufferedInputStream(url.openStream());
		PDDocument doc = PDDocument.load(file);
		ArrayList<String> fonte = new ArrayList<>();
		for (int i = 0; i < doc.getNumberOfPages(); ++i) {
			PDPage page = doc.getPage(i);
			PDResources res = page.getResources();
			for (COSName fontName : res.getFontNames()) {
				PDFont font = res.getFont(fontName);
				fonte.add(font.getName());
			}
		}
		return fonte;
	}

	public static String padDireita(String texto, int quantidade) {
		return padDireita(texto, quantidade, ' ');
	}

	public static String padDireita(String texto, int quantidade, char caracter) {
		return padTexto(texto, quantidade, caracter, false);
	}

	public static String padEsquerda(String texto, int quantidade) {
		return padEsquerda(texto, quantidade, ' ');
	}

	public static String padEsquerda(String texto, int quantidade, char caracter) {
		return padTexto(texto, quantidade, caracter, true);
	}

	public static String padTexto(String texto, int quantidade, char caracter, boolean padEsqueda) {
		if (texto == null) {
			return texto;
		}
		int quantidadeAdicionar = quantidade - texto.length();
		if (quantidadeAdicionar <= 0) {
			return texto;
		}
		StringBuffer str = new StringBuffer(texto);
		char[] ch = new char[quantidadeAdicionar];
		Arrays.fill(ch, caracter);
		if (padEsqueda) {
			str.insert(0, ch);
		} else {
			str.append(ch);
		}
		return str.toString();
	}

	public void selecionarRotina(String rotina) {
		espera.aguardarSistemaCarregar();
		espera.aguardarElementoSerClicavel(localizarRotina);
		espera.aguardarElementoEstarVisivel(localizarRotina);
		espera.aguardarElementoDesaparecer(modalAnimacaoPaginaInicial);
		try {
			acao.clicarNoElemento(localizarRotina);
		} catch (Exception e) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
			}
			acao.clicarNoElemento(localizarRotina);
		}
		espera.aguardarSistemaCarregar();
		acao.limparElemento(localizarRotina);
		acao.escreverNoElemento(localizarRotina, rotina);
		espera.aguardarElementoEstarVisivel(
				By.xpath("//*[contains(@id,'" + rotina + "')]//ancestor::div[@class='portal-abrir-rotina-localizar'][1]"));
		espera.aguardarSistemaCarregar();
		espera.aguardarElementoEstarVisivel(
				By.xpath("//*[contains(@id,'" + rotina + "')]//ancestor::div[@class='portal-abrir-rotina-localizar'][1]"));
		acao.clicarNoElemento(By.xpath("//*[contains(@id,'" + rotina + "')]//ancestor::div[@class='portal-abrir-rotina-localizar'][1]"));
		espera.aguardarElementoEstarVisivel(By.xpath("//p[contains(text(),'(" + rotina.toUpperCase() + ")')]"));
		espera.aguardarElementoEstarVisivel(retornarRotinaCarregada(rotina), verificarRotinaCarregadaMoDoConsulta(rotina));
		espera.aguardarSistemaCarregar();
		espera.aguardarElementoDesaparecer(listaDeRotinas);
		aguardarProcessarRotina();
	}

	public void selecionarRotina(String rotina, String prefixo) {
		espera.aguardarElementoEstarVisivel(localizarRotina);
		espera.aguardarSistemaCarregar();
		espera.aguardarElementoDesaparecer(modalAnimacaoPaginaInicial);
		try {
			acao.clicarNoElemento(localizarRotina);
		} catch (Exception e) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
			}
			acao.clicarNoElemento(localizarRotina);
		}
		espera.aguardarSistemaCarregar();
		acao.limparElemento(localizarRotina);
		acao.escreverNoElemento(localizarRotina, rotina);
		espera.aguardarElementoEstarVisivel(By.xpath("//*[contains(@id,'" + prefixo + rotina + "')]"));
		espera.aguardarSistemaCarregar();
		acao.clicarNoElemento(
				By.xpath("//*[contains(@id,'" + prefixo + rotina + "')]//ancestor::div[@class='portal-abrir-rotina-localizar'][1]"));
		espera.aguardarElementoEstarVisivel(By.xpath("//p[contains(text(),'(" + rotina.toUpperCase() + ")')]"));
		espera.aguardarElementoEstarVisivel(retornarRotinaCarregada(rotina), verificarRotinaCarregadaMoDoConsulta(rotina));
		espera.aguardarSistemaCarregar();
		espera.aguardarElementoDesaparecer(listaDeRotinas);
	}

	public void fecharRotina(String rotina) {
		By botaoFechar = By.xpath("//p[contains(text(),'" + rotina.toUpperCase()
				+ "')]//following::*[@title='Fechar' or @title='Cerrar' or @title='Close'][1]");
		espera.aguardarElementoSerClicavel(botaoFechar);
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(botaoFechar));
		webDriver.findElement(botaoFechar).click();
		if (acao.localizarElementos(janelaConfirmacao).size() != 0) {
			acao.clicarNoElemento(naoConfirmacao);
			espera.aguardarElementoDesaparecer(janelaConfirmacao);
		}
		aguardarProcessarRotina();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(botaoFechar));
		espera.aguardarSistemaCarregar();
	}

	public void fecharJanelaModal(String janela) {
		By botaoFechar = By
				.xpath("//*[contains(text(),'" + janela + "')]//following::*[@title='Fechar' or @title='Cerrar' or @title='Close'][1]");
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(botaoFechar));
		webDriver.findElement(botaoFechar).click();
		if (acao.localizarElementos(janelaConfirmacao).size() != 0) {
			acao.clicarNoElemento(naoConfirmacao);
			espera.aguardarElementoDesaparecer(janelaConfirmacao);
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(botaoFechar));
		espera.aguardarSistemaCarregar();
	}

	public By selecionarValorLov(String valor) {
		return By.xpath("//div[@class='lov-modal-componente']//td[contains(text(),'" + valor + "')]");
	}
	
	public String posicaoRegistro() {
		String total = webDriver.findElement(By.xpath("//li[@class='info-navegacao']//child::span[contains(text(),'/')]")).getText();
		int posicao = total.indexOf("/");
		return total.substring(0, posicao);
	}

	public String totalRegistros() {
		String total = webDriver.findElement(By.xpath("//li[@class='info-navegacao']//child::span[contains(text(),'/')]")).getText();
		int posicao = total.indexOf("/");
		return total.substring(posicao + 1);
	}

	public void limparCampoERealizarNovaConsulta() {
		acao.clicarNoElemento(botaoLimparConsulta);
		aguardarProcessarRotina();
		WebDriverWait wait = new WebDriverWait(webDriver, 10);

		if (webDriver.findElements(Mensagem.mensagemSalvarAlteracoesPendentes).size() > 0) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Mensagem.simConfirmacao));
			acao.clicarNoElemento(Mensagem.simConfirmacao);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(Mensagem.simConfirmacao));
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(modoConsulta));
		acao.clicarNoElemento(botaoConsultar);
		aguardarProcessarRotina();
	}

	public boolean verificarElementoFocado(String atributoElemento, String valorAtributoElemento) {
		WebElement el = webDriver.switchTo().activeElement();
		String atributo = el.getAttribute(atributoElemento);
		if (atributo.equals(valorAtributoElemento) || atributo.contains(valorAtributoElemento)) {
			return true;
		} else {
			return false;
		}
	}

	public String elementoAtualFocado() {
		WebElement el = webDriver.switchTo().activeElement();
		return el.getAttribute("id");
	}

	public String janelaAtualFocada() {
		return webDriver.findElement(By.xpath("//div[@class='janela-modal-componente']")).getAttribute("id").toString();
	}

	public By selecionarDia(String dia) throws InterruptedException {
		By element = By.xpath(
				"//div[contains(@class,'flatpickr-calendar') and contains(@class,'open')]//span[contains(@class,'flatpickr-day') and text()='"
						+ dia + "']");
		return element;
	}

	public void selecionarDataNoCalendario(String data, By campoData, By botaoAbrirCalendario) throws InterruptedException {
		String semBarra = data.replaceAll("[^0123456789]", "");
		acao.limparElemento(campoData);
		webDriver.findElement(campoData).sendKeys(semBarra);
		webDriver.findElement(botaoAbrirCalendario).click();
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(componenteCalendario));
		String dia = data.substring(0, 2);
		espera.aguardarElementoEstarVisivel(selecionarDia(dia));
		acao.clicarNoElemento(selecionarDia(dia));
		aguardarProcessarRotina();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(componenteCalendario));
		wait.until(ExpectedConditions.attributeToBe(campoData, "value", data));
	}

	public void irParaProximoCampo() {
		teclado.pressionarTeclaDeControle(Keys.TAB);
		aguardarProcessarRotina();
	}

	public void fecharRotinaPeloShiftF3() {
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F3);
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listaRotinasAberta));
	}

	public void abrirEditorDeCampo(By el, String label) {
		webDriver.findElement(el).sendKeys(Keys.chord(Keys.CONTROL, "e"));
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@title,'" + label + "') and @class='coluna nome-janela']")));
	}

	public void excluirESalvar() {
		aguardarProcessarRotina();
		acao.clicarNoElemento(botaoExcluir);
		aguardarProcessarRotina();
		acao.clicarNoElemento(botaoSalvar);
		espera.aguardarElementoEstarVisivel(Mensagem.mensagemRegistrosAlterados);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(Mensagem.mensagemRegistrosAlterados);
	}

	public void salvarEAguardarMensagemRegistrosAlterados() {
		aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.F10);
		aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(Mensagem.mensagemRegistrosAlterados);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(Mensagem.mensagemRegistrosAlterados);
		espera.aguardarMensagemDesaparecer();
	}

	public String retornarBackGroundColorDeUmElemento(By elemento) {
		return acao.localizarElemento(elemento).getCssValue("background-color");
	}

	public String retornarBackGroundColorDeUmElemento(By elemento, int posicao) {
		return acao.localizarElementoNaPosicao(elemento, posicao).getCssValue("background-color");
	}

	public void filtrarESelecionarValorNaLov(String valor) {
		espera.aguardarElementoEstarVisivel(modalLov);
		acao.escreverNoElemento(filtrarLov, valor);
		espera.aguardarElementoEstarVisivel(selecionarValorLov(valor));
		acao.clicarNoElemento(selecionarValorLov(valor));
		espera.aguardarElementoDesaparecer(modalLov);
	}

	public void selecionarRegistroNoBloco(By elemento, String valorCampo, By barraRolagem) {
		aguardarProcessarRotina();
		acao.clicarNoElemento(elemento, 0);
		aguardarProcessarRotina();
		limparCampoERealizarNovaConsulta();
		int posicao = 0;
		while (!acao.retornarValorDoElementoNaPosicao(elemento, posicao).equals(valorCampo)) {
			if (acao.elementoEstaHabilitado(barraRolagem)) {
				acao.clicarNoElemento(barraRolagem);
				aguardarProcessarRotina();
				posicao = -1;
			}
			posicao++;
		}
		acao.clicarNoElemento(elemento, posicao);
		aguardarProcessarRotina();
	}

	public long retornarDiasUteisEntreDatas(String start, String end) throws ParseException {

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInicio = formato.parse(start);
		Date dataFim = formato.parse(end);

		Calendar c1 = Calendar.getInstance();
		c1.setTime(dataInicio);
		int w1 = c1.get(Calendar.DAY_OF_WEEK);
		c1.add(Calendar.DAY_OF_WEEK, -w1);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(dataFim);
		int w2 = c2.get(Calendar.DAY_OF_WEEK);
		c2.add(Calendar.DAY_OF_WEEK, -w2);

		long days = (c2.getTimeInMillis() - c1.getTimeInMillis()) / (1000 * 60 * 60 * 24);
		long daysWithoutSunday = days - (days * 2 / 7);

		return daysWithoutSunday - w1 + w2;
	}

	public By retornarBarraRolagemProximaPorRegistroDesabilitada(String idElemento) {
		return By.xpath("//div[@id='" + idElemento + "']//child::div[@class='proximo botao-navegacao desabilitado']");
	}

	public By retornarBarraRolagemProximaPorRegistro(String idElemento) {
		return By.xpath("//div[@id='" + idElemento + "']//child::div[@class='proximo botao-navegacao']");
	}

	public By retornarBarraRolagemProximaPorPaginaDesabilitada(String idElemento) {
		return By.xpath("//div[@id='" + idElemento + "']//child::div[contains(@class,'proximo') and contains(@class,'desabilitado')]");
	}

	public By retornarBarraRolagemProximaPorPagina(String idElemento) {
		return By.xpath("//div[@id='" + idElemento + "']//child::div[@class='proxima-pagina botao-navegacao border-top']");
	}

	public By retornarBarraRolagemAnteriorPorPaginaDesabilitada(String idElemento) {
		return By.xpath("//div[@id='" + idElemento + "']//child::div[@class='pagina-anterior botao-navegacao desabilitado']");
	}

	public By retornarBarraRolagemAnteriorPorPagina(String idElemento) {
		return By.xpath("//div[@id='" + idElemento + "']//child::div[@class='pagina-anterior botao-navegacao']");
	}

	public By retornarBarraRolagemAnteriorPorRegistroDesabilitada(String idElemento) {
		return By.xpath("//div[@id='" + idElemento + "']//child::div[contains(@class,'anterior') and contains(@class,'desabilitado')]");
	}

	public By retornarBarraRolagemAnteriorPorRegistro(String idElemento) {
		return By.xpath("//div[@id='" + idElemento + "']//child::div[@class='anterior botao-navegacao']");
	}

	public void uploadFiles(String xpath, String localArquivo) throws AWTException, InterruptedException {
		By elemento = By.xpath(xpath);
		acao.escreverNoElemento(elemento, localArquivo);
	}

	public void uploadFilesLinux(String arquivo) throws AWTException, InterruptedException {
		Thread.sleep(3000);
		StringSelection file = new StringSelection(arquivo);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);

		Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_ALT);
		// robot.keyPress(KeyEvent.VK_S);
		// robot.keyRelease(KeyEvent.VK_S);
		// robot.keyRelease(KeyEvent.VK_ALT);
		// Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_L);
		Thread.sleep(200);
		robot.keyRelease(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// robot.keyPress(KeyEvent.VK_KP_DOWN);
		// robot.keyRelease(KeyEvent.VK_KP_DOWN);
		// Thread.sleep(1000);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
	}

	// Função para fazer upload de arquivos no Windows

	public void uploadFilesWindows(String arquivo) throws AWTException, InterruptedException {
		Thread.sleep(3000);
		StringSelection file = new StringSelection(arquivo);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(200);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void aguardarLovProcessar() {
		espera.aguardarElementoEstarVisivel(modalLov);
		espera.aguardarElementoDesaparecer(processandoLov);
	}

	public boolean verificarSeStringPossuiNumeros(String s) {
		char[] letra = s.toCharArray();
		boolean ehNumero = false;
		for (int i = 0; i < letra.length; i++)
			if (Character.isDigit(letra[i])) {
				ehNumero = true;
				break;
			}
		return ehNumero;
	}

	public void fecharLov() {
		acao.clicarNoElemento(botaoFecharLov);
		espera.aguardarElementoDesaparecer(botaoFecharLov);
		aguardarProcessarRotina();
	}

}

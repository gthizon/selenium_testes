package br.com.projedata.teste.util.recursos;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author gustavo
 *
 */
public class Acao {

	private WebDriver webDriver;

	public Acao(WebDriver driver) {
		this.webDriver = driver;
	}

	/**
	 * 
	 * @param elemento
	 * @return
	 */
	public WebElement localizarElemento(By elemento) {
		return webDriver.findElement(elemento);
	}

	public WebElement localizarElemento(String elemento) {
		By componente = localizarComponente(elemento);
		return webDriver.findElement(componente);
	}

	public List<WebElement> localizarElementos(By elemento) {
		return webDriver.findElements(elemento);
	}

	public List<WebElement> localizarElementos(String elemento) {
		By componente = localizarComponente(elemento);
		return webDriver.findElements(componente);
	}

	public void escreverNoElemento(By elemento, CharSequence valor) {
		localizarElemento(elemento).sendKeys(valor);
	}

	public void escreverNoElemento(String elemento, CharSequence valor) {
		By componente = localizarComponente(elemento);
		localizarElemento(componente).sendKeys(valor);
	}

	public void escreverNoElementoENavegarParaOProximo(By elemento, CharSequence valor, Teclado teclado, Rotina rotina) {
		localizarElemento(elemento).sendKeys(valor);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
	}

	public void escreverNoElementoENavegarParaOProximo(String elemento, CharSequence valor, Teclado teclado, Rotina rotina) {
		By componente = localizarComponente(elemento);
		localizarElemento(componente).sendKeys(valor);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
	}

	public void escreverNoElementoENavegarParaOProximo(By elemento, int posicao, CharSequence valor, Teclado teclado, Rotina rotina) {
		localizarElementos(elemento).get(posicao).sendKeys(valor);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
	}

	public void escreverNoElementoENavegarParaOProximo(String elemento, int posicao, CharSequence valor, Teclado teclado, Rotina rotina) {
		By componente = localizarComponente(elemento);
		localizarElementos(componente).get(posicao).sendKeys(valor);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
	}

	public void escreverNoElementoNaPosicao(By elemento, int posicao, CharSequence valor) {
		localizarElementoNaPosicao(elemento, posicao).sendKeys(valor);
	}

	public void escreverNoElemento(String idOuNomeDoElemento, int posicao, CharSequence valor) {
		escreverNoElementoNaPosicao(idOuNomeDoElemento, posicao, valor);
	}

	public void escreverNoElemento(By elemento, int posicao, CharSequence valor) {
		escreverNoElementoNaPosicao(elemento, posicao, valor);
	}

	public void escreverNoElementoNaPosicao(String idOuNomeDoElemento, int posicao, CharSequence valor) {
		By componente = localizarComponente(idOuNomeDoElemento);
		localizarElementoNaPosicao(componente, posicao).sendKeys(valor);
	}

	public WebElement localizarElementoNaPosicao(By elemento, int posicao) {
		return localizarElementos(elemento).get(posicao);
	}

	public WebElement localizarElementoNaPosicao(String elemento, int posicao) {
		By componente = localizarComponente(elemento);
		return localizarElementos(componente).get(posicao);
	}

	public void clicarNoElemento(By elemento) {
		localizarElemento(elemento).click();
	}

	public void clicarNoElemento(Rotina rotina, By elemento) {
		posicionarFocoNoElemento(rotina, elemento);
		localizarElemento(elemento).click();
	}

	public void clicarNoElemento(String elemento) {
		By componente = localizarComponente(elemento);
		localizarElemento(componente).click();
	}

	public void clicarNoElemento(Rotina rotina, String elemento) {
		posicionarFocoNoElemento(rotina, elemento);
		By componente = localizarComponente(elemento);
		localizarElemento(componente).click();
	}

	public void clicarNoElemento(By elemento, int posicao) {
		localizarElementoNaPosicao(elemento, posicao).click();
	}

	public void clicarNoElemento(Rotina rotina, By elemento, int posicao) {
		posicionarFocoNoElementoNaPosicao(rotina, elemento, posicao);
		localizarElementoNaPosicao(elemento, posicao).click();
	}

	public void clicarNoElemento(Rotina rotina, String elemento, int posicao) {
		By componente = localizarComponente(elemento);
		posicionarFocoNoElementoNaPosicao(rotina, elemento, posicao);
		localizarElementoNaPosicao(componente, posicao).click();
	}

	public void clicarNoElemento(String elemento, int posicao) {
		By componente = localizarComponente(elemento);
		localizarElementoNaPosicao(componente, posicao).click();
	}

	public void selecionarNoElemento(By elemento, String valor) {
		new Select(localizarElemento(elemento)).selectByVisibleText(valor);
	}

	public void selecionarNoElemento(String elemento, String valor) {
		By componente = localizarComponente(elemento);
		new Select(localizarElemento(componente)).selectByVisibleText(valor);
	}

	public void selecionarNoElementoPeloValor(String elemento, String valor) {
		By componente = localizarComponente(elemento);
		new Select(localizarElemento(componente)).selectByValue(valor);
	}

	public void selecionarNoElementoPeloValor(By elemento, String valor) {
		new Select(localizarElemento(elemento)).selectByValue(valor);
	}

	public void selecionarNoElementoPeloValor(By elemento, int posicao, String valor) {
		new Select(localizarElementoNaPosicao(elemento, posicao)).selectByValue(valor);
	}

	public void selecionarNoElementoPeloValor(String elemento, int posicao, String valor) {
		By componente = localizarComponente(elemento);
		new Select(localizarElementoNaPosicao(componente, posicao)).selectByValue(valor);
	}

	public void selecionarNoElemento(String elemento, int posicao, String valor) {
		By componente = localizarComponente(elemento);
		new Select(localizarElementoNaPosicao(componente, posicao)).selectByVisibleText(valor);
	}

	public void selecionarNoElemento(By elemento, int posicao, String valor) {
		new Select(localizarElementoNaPosicao(elemento, posicao)).selectByVisibleText(valor);
	}

	public ArrayList<String> retornarValoresDeUmaLista(String elemento, int posicao) {
		ArrayList<String> valoresLista = new ArrayList<>();
		By componente = localizarComponente(elemento);
		List<WebElement> valores = new Select(localizarElementoNaPosicao(componente, posicao)).getOptions();
		for (WebElement val : valores) {
			valoresLista.add(val.getText());
		}
		return valoresLista;
	}

	public ArrayList<String> retornarValoresDeUmaLista(By elemento, int posicao) {
		ArrayList<String> valoresLista = new ArrayList<>();
		List<WebElement> valores = new Select(localizarElementoNaPosicao(elemento, posicao)).getOptions();
		for (WebElement val : valores) {
			valoresLista.add(val.getText());
		}
		return valoresLista;
	}

	public Select buscarObjetoTipoSelect(By elemento, int posicao) {
		return new Select(localizarElementoNaPosicao(elemento, posicao));
	}

	public Select buscarObjetoTipoSelect(String elemento, int posicao) {
		By componente = localizarComponente(elemento);
		return new Select(localizarElementoNaPosicao(componente, posicao));
	}

	public void deselecionarNoElemento(By elemento, String valor) {
		new Select(localizarElemento(elemento)).deselectByVisibleText(valor);
	}

	public void deselecionarNoElemento(String elemento, String valor) {
		By componente = localizarComponente(elemento);
		new Select(localizarElemento(componente)).deselectByVisibleText(valor);
	}

	public void limparElemento(By elemento) {
		escreverNoElemento(elemento, Keys.CONTROL + "a");
		escreverNoElemento(elemento, Keys.DELETE);
	}

	public void limparElemento(Rotina rotina, By elemento) {
		posicionarFocoNoElemento(rotina, elemento);
		escreverNoElemento(elemento, Keys.CONTROL + "a");
		escreverNoElemento(elemento, Keys.DELETE);
	}

	public void limparElemento(String elemento) {
		By componente = localizarComponente(elemento);
		escreverNoElemento(componente, Keys.CONTROL + "a");
		escreverNoElemento(componente, Keys.DELETE);
	}

	public void limparElemento(Rotina rotina, String elemento) {
		By componente = localizarComponente(elemento);
		posicionarFocoNoElemento(rotina, elemento);
		escreverNoElemento(componente, Keys.CONTROL + "a");
		escreverNoElemento(componente, Keys.DELETE);
	}

	public void limparElementoNaPosicao(By elemento, int posicao) {
		escreverNoElementoNaPosicao(elemento, posicao, Keys.CONTROL + "a");
		escreverNoElementoNaPosicao(elemento, posicao, Keys.DELETE);
	}

	public void limparElementoNaPosicao(String elemento, int posicao) {
		By componente = localizarComponente(elemento);
		escreverNoElementoNaPosicao(componente, posicao, Keys.CONTROL + "a");
		escreverNoElementoNaPosicao(componente, posicao, Keys.DELETE);
	}

	public void limparElementoNaPosicao(Rotina rotina, By elemento, int posicao) {
		posicionarFocoNoElemento(rotina, elemento);
		escreverNoElementoNaPosicao(elemento, posicao, Keys.CONTROL + "a");
		escreverNoElementoNaPosicao(elemento, posicao, Keys.DELETE);
	}

	public void limparElementoNaPosicao(Rotina rotina, String elemento, int posicao) {
		By componente = localizarComponente(elemento);
		posicionarFocoNoElemento(rotina, elemento);
		escreverNoElementoNaPosicao(componente, posicao, Keys.CONTROL + "a");
		escreverNoElementoNaPosicao(componente, posicao, Keys.DELETE);
	}

	public void limparParteDeUmTexto(By elemento, String deletar) {
		String conteudo = retornarValorDoElemento(elemento);
		escreverNoElemento(elemento, conteudo.replace(deletar, ""));
	}

	public void limparParteDeUmTexto(String elemento, String deletar) {
		By componente = localizarComponente(elemento);
		String conteudo = retornarValorDoElemento(componente);
		escreverNoElemento(componente, conteudo.replace(deletar, ""));
	}

	public void posicionarFocoNoElemento(Rotina rotina, By elemento) {
		posicionarFocoNoElementoNaPosicao(rotina, elemento, 0);
	}

	public void posicionarFocoNoElemento(Rotina rotina, String elemento) {
		By componente = localizarComponente(elemento);
		posicionarFocoNoElementoNaPosicao(rotina, componente, 0);
	}

	public void posicionarFocoNoElementoNaPosicao(Rotina rotina, By elemento, int posicao) {
		String id = retornarValorAtributoDoElementoNaPosicao(elemento, posicao, "id");
		if (!id.isEmpty()) {
			executarJavaScriptNaRotina("document.getElementById('" + id + "').focus()");
		} else {
			String name = retornarValorAtributoDoElementoNaPosicao(elemento, posicao, "name");
			if (!name.isEmpty()) {
				executarJavaScriptNaRotina("document.getElementsByName('" + name + "')[0].focus()");
			} else {
				String classe = retornarValorAtributoDoElementoNaPosicao(elemento, posicao, "class");
				executarJavaScriptNaRotina("document.getElementsByClassName('" + classe + "')[0].focus()");
			}
		}
		rotina.aguardarProcessarRotina();
	}

	public void posicionarFocoNoElementoNaPosicao(Rotina rotina, String elemento, int posicao) {
		By componente = localizarComponente(elemento);
		String id = retornarValorAtributoDoElementoNaPosicao(componente, posicao, "id");
		if (!id.isEmpty()) {
			executarJavaScriptNaRotina("document.getElementById('" + id + "').focus()");
		} else {
			String name = retornarValorAtributoDoElementoNaPosicao(componente, posicao, "name");
			if (!name.isEmpty()) {
				executarJavaScriptNaRotina("document.getElementsByName('" + name + "')[0].focus()");
			} else {
				String classe = retornarValorAtributoDoElementoNaPosicao(componente, posicao, "class");
				executarJavaScriptNaRotina("document.getElementsByClassName('" + classe + "')[0].focus()");
			}
		}
		rotina.aguardarProcessarRotina();
	}

	private Object executarJavaScriptNaRotina(String script) {
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		return jse.executeScript(script);
	}

	private String retornarValorAtributoDoElemento(By elemento, String atributo) {
		try {
			return retornarValorAtributoDoElementoNaPosicao(elemento, 0, atributo);
		} catch (IndexOutOfBoundsException e) {
			return localizarElemento(elemento).getAttribute(atributo);
		}
	}

	private String retornarValorAtributoDoElementoNaPosicao(By elemento, int posicao, String atributo) {
		return localizarElementoNaPosicao(elemento, posicao).getAttribute(atributo);
	}

	public void clicarNoElementoPorCoordenada(int x, int y) {
		Actions action = new Actions(webDriver);
		action.moveByOffset(x, y).click().build().perform();
	}

	public String retornarValorDoElemento(By elemento) {
		return retornarValorAtributoDoElemento(elemento, "value");
	}

	public String retornarValorDoElemento(String elemento) {
		By componente = localizarComponente(elemento);
		return retornarValorAtributoDoElemento(componente, "value");
	}

	public String retornarValorDoElementoNaPosicao(By elemento, int posicao) {
		return retornarValorAtributoDoElementoNaPosicao(elemento, posicao, "value");
	}

	public String retornarValorDoElementoNaPosicao(String elemento, int posicao) {
		By componente = localizarComponente(elemento);
		return retornarValorAtributoDoElementoNaPosicao(componente, posicao, "value");
	}

	public String retornarValorSelecionadoNoElemento(By elemento) {
		Select selecionado = new Select(localizarElemento(elemento));
		return selecionado.getFirstSelectedOption().getText();
	}

	public String retornarValorSelecionadoNoElemento(String elemento) {
		By componente = localizarComponente(elemento);
		Select selecionado = new Select(localizarElemento(componente));
		return selecionado.getFirstSelectedOption().getText();
	}

	public String retornarValorSelecionadoNoElemento(String elemento, int posicao) {
		By componente = localizarComponente(elemento);
		Select selecionado = new Select(localizarElementoNaPosicao(componente, posicao));
		return selecionado.getFirstSelectedOption().getText();
	}

	public boolean elementoEstaHabilitado(By barraRolagem) {
		return localizarElemento(barraRolagem).isEnabled();
	}

	public boolean elementoEstaHabilitado(String barraRolagem) {
		By componente = localizarComponente(barraRolagem);
		return localizarElemento(componente).isEnabled();
	}

	public void selecionarElementoComDeterminadoValorEmUmBloco(String valor, By elemento, Rotina rotina, String idBarraRolagem) {
		rotina.aguardarProcessarRotina();
		clicarNoElemento(elemento, 0);
		rotina.aguardarProcessarRotina();
		rotina.limparCampoERealizarNovaConsulta();
		int posicao = 0;
		while (!retornarValorDoElementoNaPosicao(elemento, posicao).equals(valor)) {
			By barraRolagemProximo = By
					.xpath("//*[@id='" + idBarraRolagem + "']//following-sibling::div[@class='proximo botao-navegacao'][1]");
			By barraRolagemProximoDesabilitada = By
					.xpath("//*[@id='" + idBarraRolagem + "']//following-sibling::div[@class='proximo botao-navegacao desabilitado'][1]");
			if (localizarElementos(barraRolagemProximoDesabilitada).isEmpty()) {
				clicarNoElemento(barraRolagemProximo);
				rotina.aguardarProcessarRotina();
				posicao = -1;
			}
			posicao++;
		}
		clicarNoElemento(elemento, posicao);
		rotina.aguardarProcessarRotina();
	}

	public void selecionarElementoComDeterminadoValorEmUmBloco(String valor, String elemento, Rotina rotina, String idBarraRolagem) {
		By componente = localizarComponente(elemento);
		rotina.aguardarProcessarRotina();
		clicarNoElemento(componente, 0);
		rotina.aguardarProcessarRotina();
		rotina.limparCampoERealizarNovaConsulta();
		int posicao = 0;
		while (!retornarValorDoElementoNaPosicao(componente, posicao).equals(valor)) {
			By barraRolagemProximo = By
					.xpath("//*[@id='" + idBarraRolagem + "']//following-sibling::div[@class='proximo botao-navegacao'][1]");
			By barraRolagemProximoDesabilitada = By
					.xpath("//*[@id='" + idBarraRolagem + "']//following-sibling::div[@class='proximo botao-navegacao desabilitado'][1]");
			if (localizarElementos(barraRolagemProximoDesabilitada).isEmpty()) {
				clicarNoElemento(barraRolagemProximo);
				rotina.aguardarProcessarRotina();
				posicao = -1;
			}
			posicao++;
		}
		clicarNoElemento(componente, posicao);
		rotina.aguardarProcessarRotina();
	}

	public By localizarComponente(String idComponente) {
		return By.xpath("//*[contains(@id,'" + janelaAtualFocada() + "')]//child::*[contains(@id,'" + idComponente
				+ "') or contains(@name,'" + idComponente + "')]");
	}

	public By localizarPainel(String idComponente) {
		return By.xpath("//*[contains(@class,'widget-container')]//following::*[contains(@id,'" + idComponente + "') or contains(@name,'"
				+ idComponente + "')]");
	}

	public void abrirOuFecharNohDaArvore(String idNoh) {
		clicarNoElemento(By.xpath("//div[@class='arvore-componente']//following::i[@id='" + idNoh + "']"));
	}

	public void selecionarNohDaArvore(String idNoh) {
		clicarNoElemento(By.xpath("//div[@class='arvore-componente']//following::span[@id='" + idNoh + "']"));
	}

	public void selecionarAba(String idAba) {
		clicarNoElemento(By.xpath("//div[contains(@id,'" + idAba + "') and @class='aba']/div[contains(@class,'titulo')]"));
	}

	public String janelaAtualFocada() {
		return webDriver.findElement(By.xpath("//div[@class='janela-modal-componente']")).getAttribute("id").toString();
	}

	public void abrirLov(Rotina rotina, String idComponente) {
		By componente = localizarComponente(idComponente);
		localizarElemento(componente).click();
		rotina.aguardarProcessarRotina();
		rotina.teclado.pressionarTeclaDeControle(Keys.F9);
		rotina.aguardarLovProcessar();
	}

	public void consultarRegistro(Rotina rotina, String elemento, String valor) {
		By componente = localizarComponente(elemento);
		clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		escreverNoElemento(componente, valor);
		clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
	}

	public void consultarRegistro(Rotina rotina, By elemento, String valor) {
		clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		escreverNoElemento(elemento, valor);
		clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
	}

	public int retornarQuantidadeDeRegistros(String idComponente) {
		List<WebElement> registros = localizarElementos(idComponente);
		return registros.size();
	}

	public int retornarQuantidadeDeRegistros(By xpath) {
		List<WebElement> registros = localizarElementos(xpath);
		return registros.size();
	}

	public void excluirTodosOsRegistrosDeUmBloco(Teclado teclado, Rotina rotina, String elemento) {
		By componente = localizarComponente(elemento);
		while (!webDriver.findElement(componente).getAttribute("value").isEmpty()) {
			teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
			rotina.aguardarProcessarRotina();
		}
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}
}

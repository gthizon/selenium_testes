package br.com.projedata.teste.util.recursos;

import java.awt.AWTException;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;

public class Navegador {

	private WebDriver webDriver;

	public Navegador(WebDriver driver) {
		this.webDriver = driver;
	}

	public String retornarUrlAtual() {
		return webDriver.getCurrentUrl();
	}

	public String retornarPaginaAtual() {
		String pagina = webDriver.getWindowHandle();
		return pagina;
	}

	public void abrirNovaGuiaNavegador() throws AWTException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.open()");

		for (String winHandle : webDriver.getWindowHandles()) {
			webDriver.switchTo().window(winHandle);
			Thread.sleep(500);
		}
		js.executeScript("sessionStorage.clear()");
	}

	public void trocarDeAba() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			for (String winHandle : webDriver.getWindowHandles()) {
				webDriver.switchTo().window(winHandle);
			}
		} catch (NoSuchSessionException e) {
			webDriver.close();
		}
	}

	public void atualizarBrowser() {
		webDriver.navigate().refresh();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void retornarPaginaPrincipal(String pagina) {
		Set<String> paginas = null;
		try {
			paginas = webDriver.getWindowHandles();
		} catch (NoSuchSessionException e) {

		}
		for (String handle : paginas) {
			if (!handle.equals(pagina)) {
				webDriver.switchTo().window(handle);
				webDriver.close();
			}
		}
		webDriver.switchTo().window(pagina);
	}

	public void irParaNovaUrlEmNovaAba(String url) throws AWTException, InterruptedException {
		abrirNovaGuiaNavegador();
		webDriver.get((url));
	}

	public void irParaPagina(String pagina) {
		webDriver.switchTo().window(pagina);

	}

	public void alterarUrl(String url) throws AWTException, InterruptedException {
		webDriver.get((url));
	}

	public String retornarTituloDaPagina() {
		return webDriver.getTitle();
	}
}

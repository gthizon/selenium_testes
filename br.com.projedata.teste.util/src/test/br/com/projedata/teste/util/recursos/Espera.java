package br.com.projedata.teste.util.recursos;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Espera {

	private WebDriver webDriver;
	private Acao acao;

	public Espera(WebDriver driver, Acao acao) {
		this.webDriver = driver;
		this.acao = acao;
	}

	public void aguardarPdfSerGerado() throws InvalidPasswordException, IOException {
		WebDriverWait wait = new WebDriverWait(webDriver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='conteudo conteudo-relatorio']//iframe")));
	}

	public void aguardarElementoEstarDesabilitado(WebElement componente) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		ExpectedCondition<Boolean> elementIsDisabled = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try {
					if (!componente.isEnabled() || componente.getAttribute("class").contains("desabilitado")
							|| componente.getAttribute("class").contains("bloquear-alteracao")
							|| componente.getAttribute("readonly").contains("readonly")
							|| componente.getAttribute("readonly").equals("true")) {
						return true;
					}
					return false;
				} catch (NoSuchElementException e) {
					return false;
				} catch (StaleElementReferenceException f) {
					return false;
				}
			}
		};
		wait.until(elementIsDisabled);
	}

	public void aguardarElementoEstarDesabilitado(String elemento) {
		WebElement componente = webDriver.findElement(acao.localizarComponente(elemento));
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		ExpectedCondition<Boolean> elementIsDisabled = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try {
					if (!componente.isEnabled() || componente.getAttribute("class").contains("desabilitado")
							|| componente.getAttribute("class").contains("bloquear-alteracao")
							|| componente.getAttribute("readonly").contains("readonly")
							|| componente.getAttribute("readonly").equals("true")) {

						return true;
					}
					return false;
				} catch (NoSuchElementException e) {
					return false;
				} catch (StaleElementReferenceException f) {
					return false;
				}
			}
		};
		wait.until(elementIsDisabled);
	}

	public void aguardarElementoEstarHabilitado(By elemento) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		ExpectedCondition<Boolean> elementIsEnabled = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try {
					if (localizarElemento(elemento).isEnabled()) {
						return true;
					}
					return false;
				} catch (NoSuchElementException e) {
					return false;
				} catch (StaleElementReferenceException f) {
					return false;
				}
			}
		};
		wait.until(elementIsEnabled);
	}

	public void aguardarElementoEstarHabilitado(String elemento) {
		WebElement componente = webDriver.findElement(acao.localizarComponente(elemento));
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		ExpectedCondition<Boolean> elementIsEnabled = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try {
					if (componente.isEnabled()) {
						return true;
					}
					return false;
				} catch (NoSuchElementException e) {
					return false;
				} catch (StaleElementReferenceException f) {
					return false;
				}
			}
		};
		wait.until(elementIsEnabled);
	}

	public void aguardarElementoSerClicavel(By el) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		ExpectedCondition<Boolean> elementoClicavel = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try {
					wait.until(ExpectedConditions.elementToBeClickable(el));
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		};
		wait.until(elementoClicavel);
	}

	public void aguardarElementoSerClicavel(String elemento) {
		WebElement componente = webDriver.findElement(acao.localizarComponente(elemento));
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		ExpectedCondition<Boolean> elementoClicavel = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try {
					wait.until(ExpectedConditions.elementToBeClickable(componente));
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		};
		wait.until(elementoClicavel);
	}

	public void verificarSeElementoNaoExiste(By elemento) {
		Assert.assertTrue(webDriver.findElements(elemento).isEmpty());
	}

	public void verificarSeElementoNaoExiste(String elemento) {
		By componente = acao.localizarComponente(elemento);
		Assert.assertTrue(webDriver.findElements(componente).isEmpty());
	}

	public void aguardarElementoDesaparecer(By elemento) {
		WebDriverWait wait = new WebDriverWait(webDriver, 15);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(elemento));
		if (!webDriver.findElements(elemento).isEmpty()) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(elemento));
		}
	}

	public void aguardarElementoDesaparecer(String elemento) {
		By componente = acao.localizarComponente(elemento);
		WebDriverWait wait = new WebDriverWait(webDriver, 15);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(componente));
		if (!webDriver.findElements(componente).isEmpty()) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(componente));
		}
	}

	public void aguardarAtributoDoElementoSer(By elemento, String atributo, String valor) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.attributeToBe(elemento, atributo, valor));
	}

	public void aguardarAtributoDoElementoSer(String elemento, String atributo, String valor) {
		By componente = acao.localizarComponente(elemento);
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.attributeToBe(componente, atributo, valor));
	}

	public boolean aguardarElementoNaoEstarVisivel(By... elementos) {
		return aguardarElementoNaoEstarVisivel(5, elementos);
	}

	public boolean aguardarElementoNaoEstarVisivel(String elementos) {
		By componente = acao.localizarComponente(elementos);
		return aguardarElementoNaoEstarVisivel(5, componente);
	}

	public boolean aguardarElementoNaoEstarVisivel(int tempo, By... elementos) {
		return new WebDriverWait(webDriver, tempo).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				for (By by : elementos) {
					try {
						localizarElemento(by);
						if (!localizarElemento(by).isDisplayed()) {
							return true;
						}
					} catch (TimeoutException t) {
						return true;
					} catch (NoSuchElementException e) {
						return true;
					}
				}
				return false;
			}
		});
	}

	public WebElement aguardarElementoEstarVisivel(By... elementos) {
		return aguardarElementoEstarVisivel(10, elementos);
	}

	public WebElement aguardarElementoEstarVisivel(String elementos) {
		By componente = acao.localizarComponente(elementos);
		return aguardarElementoEstarVisivel(10, componente);
	}

	public WebElement aguardarElementoEstarVisivel(int tempo, By... elementos) {
		return new FluentWait<WebDriver>(webDriver).withTimeout(new Long(tempo), TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class).ignoring(TimeoutException.class)
				.until(new ExpectedCondition<WebElement>() {
					@Override
					public WebElement apply(WebDriver driver) {
						for (By by : elementos) {
							WebElement elemento = null;
							try {
								elemento = localizarElemento(by);
							} catch (Exception e) {
							}
							if (elemento != null && elemento.isDisplayed()) {
								return elemento;
							}
						}
						return null;
					}
				});
	}

	public void aguardarElementoEstarVazio(By elemento) {
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(localizarElemento(elemento), ""));
	}

	public void aguardarElementoEstarVazio(String elemento) {
		By componente = acao.localizarComponente(elemento);
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(localizarElemento(componente), ""));
	}

	private WebElement localizarElemento(By elemento) {
		return webDriver.findElement(elemento);
	}

	public void aguardarElementoEstarVazio(By elemento, int posicao) {
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(localizarElementoNaPosicao(elemento, posicao), ""));
	}

	public void aguardarElementoEstarVazio(String elemento, int posicao) {
		By componente = acao.localizarComponente(elemento);
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(localizarElementoNaPosicao(componente, posicao), ""));
	}

	private WebElement localizarElementoNaPosicao(By elemento, int posicao) {
		return webDriver.findElements(elemento).get(posicao);
	}

	public void aguardarElementoNaoEstarVazio(By elemento, int posicao, String atributo) {
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		wait.until(ExpectedConditions.attributeToBeNotEmpty(localizarElementoNaPosicao(elemento, posicao), atributo));
	}
	
	public void aguardarElementoNaoEstarVazio(String elemento, int posicao, String atributo) {
		By componente = acao.localizarComponente(elemento);
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		wait.until(ExpectedConditions.attributeToBeNotEmpty(localizarElementoNaPosicao(componente, posicao), atributo));
	}

	public void aguardarAtributoDoElementoConterOValor(By elemento, String atributo, String valor) {
		(new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return localizarElemento(elemento).getAttribute(atributo).contains(valor);
			}
		});
	}

	public void aguardarAtributoDoElementoConterOValor(String elemento, String atributo, String valor) {
		By componente = acao.localizarComponente(elemento);
		(new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return localizarElemento(componente).getAttribute(atributo).contains(valor);
			}
		});
	}

	public void aguardarAtributoDoElementoConterOValor(By elemento, int posicao, String atributo, String valor) {
		(new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return localizarElementoNaPosicao(elemento, posicao).getAttribute(atributo).contains(valor);
			}
		});
	}
	
	public void aguardarAtributoDoElementoNaoConterOValor(By elemento, int posicao, String atributo, String valor) {
		(new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return !localizarElementoNaPosicao(elemento, posicao).getAttribute(atributo).contains(valor);
			}
		});
	}

	public void aguardarAtributoDoElementoConterOValor(String elemento, int posicao, String atributo, String valor) {
		By componente = acao.localizarComponente(elemento);
		(new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return localizarElementoNaPosicao(componente, posicao).getAttribute(atributo).contains(valor);
			}
		});
	}

	public void aguardarSistemaCarregar() { 
		aguardarElementoDesaparecer(By.xpath("//div[@class='loader']"));
	}

	public void aguardarRotinaAberta(String rotina) {
		aguardarElementoEstarVisivel(By.xpath("//p[contains(text(),'(" + rotina.toUpperCase() + ")')]"));
	}
	
	public void aguardarRotinaCarregada(String rotina) {
		
		aguardarElementoEstarVisivel(By.xpath("//div[@class='titulo']/p[contains(text(),'" + rotina
				+ "')]//following::li[contains(@class,'info-navegacao')]/span[contains(text(),'1/')]"));
	}

	public void aguardarElementoConterOTexto(By elemento, String valor) {
		(new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return localizarElemento(elemento).getText().contains(valor);
			}
		});
	}

	public void aguardarElementoConterOTexto(String elemento, String valor) {
		By componente = acao.localizarComponente(elemento);
		(new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return localizarElemento(componente).getText().contains(valor);
			}
		});
	}

	public void aguardarElementoConterOTexto(String elemento, int posicao, String valor) {
		By componente = acao.localizarComponente(elemento);
		(new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return localizarElementoNaPosicao(componente, posicao).getText().contains(valor);
			}
		});
	}
	
	public void aguardarElementoConterOTexto(By elemento, int posicao, String valor) {
		(new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) { 
				return localizarElementoNaPosicao(elemento, posicao).getText().contains(valor);
			}
		});
	}
	
	public void aguardarMensagemDesaparecer() {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'arcbox')]")));
	}
	
	public void aguardarElementoEstarSelecionado(String elemento) {
		By componente = By.xpath("//button[contains(@id,'"+elemento+"')]//child::i[contains(@class,'fa fa-check-square-o')]");
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(componente));
	}
}

package br.com.projedata.arcturus.teste.recursos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.teste.util.Teste;
import br.com.projedata.teste.util.recursos.Acao;
import br.com.projedata.teste.util.recursos.Espera;
import br.com.projedata.teste.util.recursos.Mouse;
import br.com.projedata.teste.util.recursos.Navegador;
import br.com.projedata.teste.util.recursos.RecursosBasicos;
import br.com.projedata.teste.util.recursos.Teclado;
import br.com.projedata.teste.util.recursos.Testar;

public class TesteGenerico implements Teste {

	public WebDriver webDriver;
	public Testar testar;
	public Acao acao;
	public Espera espera;
	public Mensagem msg;
	public Mouse mouse;
	public Navegador navegador;
	public RotinaRecurso rotina;
	public Teclado teclado;

	public By sairPortal = By.xpath("//li[contains(text(),'Sair') or contains(text(),'Logout') or contains(text(),'Salir')]");
	public By menuConfiguracoes = By.xpath(
			"//li[@class='barra-ferramentas-item' and contains(@title, 'Config') or contains(@title, 'config') or contains(@title, 'Config')]");
	public By menuConfiguracoesAberto = By.xpath("//div[@class='portal-menu-configuracoes']");

	@Parameters(value = { "browser", "url", "enderecoHub"})
	@BeforeClass
	public void configurarTeste(String browser, String url, String enderecoHub) {
		this.webDriver = RecursosBasicos.selecionarBrowser(browser, enderecoHub);
		abrirUrl(url);
		criarRecursos();
	}

	@Override
	public WebDriver getWebDriver() {
		return this.webDriver;
	}

	private void criarRecursos() {
		acao = new Acao(webDriver);
		testar = new Testar(webDriver, acao);
		espera = new Espera(webDriver, acao);
		teclado = new Teclado(webDriver);
		msg = new Mensagem(webDriver, teclado);
		mouse = new Mouse(webDriver, acao);
		navegador = new Navegador(webDriver);
		rotina = new RotinaRecurso(webDriver, espera, acao, teclado);
	}

	protected void abrirUrl(String url) {
		webDriver.get(url);
	}

	public void sairPortal() {
		espera.aguardarElementoEstarVisivel(3, menuConfiguracoes);
		acao.clicarNoElemento(menuConfiguracoes);
		espera.aguardarElementoEstarVisivel(sairPortal);
		espera.aguardarElementoEstarVisivel(menuConfiguracoesAberto);
		acao.clicarNoElemento(sairPortal);
		espera.aguardarSistemaCarregar();
		LoginMetodos log = new LoginMetodos(this);
		log.aguardarTelaLogin();
	}

	@AfterClass
	public void fecharDriver() {
		try {
			sairPortal();
		} catch (Exception e) {

		}
		RecursosBasicos.fecharDriver(webDriver);
	}

	public void abrirMenuConfiguracoes() {
		espera.aguardarSistemaCarregar();
		espera.aguardarElementoEstarVisivel(menuConfiguracoes);
		espera.aguardarElementoSerClicavel(menuConfiguracoes);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		acao.clicarNoElemento(menuConfiguracoes);
		espera.aguardarElementoEstarVisivel(menuConfiguracoesAberto);
	}

	@Override
	public Acao getAcao() {
		return acao;
	}

	@Override
	public Teclado getTeclado() {
		return teclado;
	}

	@Override
	public Espera getEspera() {
		return espera;
	}

}

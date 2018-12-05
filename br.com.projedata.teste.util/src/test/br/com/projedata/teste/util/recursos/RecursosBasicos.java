package br.com.projedata.teste.util.recursos;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RecursosBasicos {

	public static WebDriver selecionarBrowser(String browser, String enderecoHub) {
		WebDriver webDriver = null;
		MutableCapabilities capabilities = null;
		if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions ffo = new FirefoxOptions();
			ffo.addArguments("start-maximized");
			ffo.setCapability("marionette", true);
			capabilities = ffo;
			if (enderecoHub == null) {
				webDriver = new FirefoxDriver(ffo);
				webDriver.manage().window().maximize();
			}

		} else if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
			HashMap<String, String> chromePreferences = new HashMap<String, String>();
			chromePreferences.put("profile.password_manager_enabled", "false");
			options.setCapability("chrome.prefs", chromePreferences);
			options.addArguments("start-maximized");
			capabilities = options;
			if (enderecoHub == null) {
				webDriver = new ChromeDriver(options);
			}
		}
		if (enderecoHub != null) {
			try {
				webDriver = new RemoteWebDriver(new URL("http://" + enderecoHub + ":4444/wd/hub"), capabilities);
				WebDriver augmentedDriver = new Augmenter().augment(webDriver);
				((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return webDriver;
	}

	public static void fecharDriver(WebDriver webDriver) {
		webDriver.quit();
	}

}

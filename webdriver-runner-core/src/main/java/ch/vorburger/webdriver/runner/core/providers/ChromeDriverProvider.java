package ch.vorburger.webdriver.runner.core.providers;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;

/**
 * WebDriverProvider for ChromeDriver.
 * 
 * To optimize, this will only ever launch one ChromeDriverService (per JVM),
 * and then re-use it (until shutdown).
 * 
 * In order to use this, you must have previously downloaded the ChromeDriver
 * Server platform specific binary, and made it available on your %PATH%, from
 * https://code.google.com/p/chromedriver/downloads/list. That isn't the same
 * thing as the Java ChromeDriver class, or the Chrome Browser binary!
 */
public class ChromeDriverProvider implements WebDriverProvider {

	protected static LazyAutoStoppingChromeDriverService singleton = new LazyAutoStoppingChromeDriverService();
	
	@Override
	public WebDriver getNewWebDriver() throws IOException {
		DesiredCapabilities capabilities = getDesiredCapabilities();
		return new ChromeDriver(singleton.getDriverService(), capabilities);
	}

	protected DesiredCapabilities getDesiredCapabilities() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
		return capabilities;
	}

	@Override
	public String getName() {
		return "Chrome";
	}

}

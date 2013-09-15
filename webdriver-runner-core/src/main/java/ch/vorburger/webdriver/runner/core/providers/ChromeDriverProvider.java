package ch.vorburger.webdriver.runner.core.providers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;

/**
 * WebDriverProvider for ChromeDriver.
 * 
 * In order to use this, you must have previously downloaded the ChromeDriver
 * Server platform specific binary, and made it available on your %PATH%, from
 * https://code.google.com/p/chromedriver/downloads/list. That isn't the same
 * thing as the Java ChromeDriver class, or the Chrome Browesr binary!
 */
public class ChromeDriverProvider implements WebDriverProvider {

	// TODO use ChromeDriverService, @see
	// https://code.google.com/p/selenium/wiki/ChromeDriver

	@Override
	public WebDriver get() {
		return new ChromeDriver();
	}

	@Override
	public String getName() {
		return "Chrome";
	}

}

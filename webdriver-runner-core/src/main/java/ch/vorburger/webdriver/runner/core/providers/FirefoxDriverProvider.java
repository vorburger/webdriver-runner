package ch.vorburger.webdriver.runner.core.providers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;

public class FirefoxDriverProvider implements WebDriverProvider {

	// TODO make it faster by not starting up a new one each time
	
	@Override public WebDriver get() {
		return new FirefoxDriver();
	}
	
	@Override public String getName() {
		return "Chrome";
	}

}

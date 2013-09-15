package ch.vorburger.webdriver.runner.core;

import org.openqa.selenium.WebDriver;

public interface WebDriverProvider {

	WebDriver getNewWebDriver() throws Exception;
	
	/**
	 * Name of the Provider.
	 * Used e.g. for the -Dwebdriver.runner.providers list system property.
	 */
	String getName();

	// boolean canRunInParallel();
	
}

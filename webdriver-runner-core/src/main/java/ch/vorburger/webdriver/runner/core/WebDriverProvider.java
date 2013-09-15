package ch.vorburger.webdriver.runner.core;

import org.openqa.selenium.WebDriver;

public interface WebDriverProvider {

	/**
	 * Obtain a "new" (as in "available and free for you to use") WebDriver instance.
	 *
	 * @return a WebDriver, which may or may not actually be "new" (as in, a just constructed new instance) 
	 * @throws Exception if a new WebDriver instance could not be obtained / created for whatever reason
	 */
	WebDriver getNewWebDriver() throws Exception;
	
	/**
	 * Name of the Provider.
	 * Used e.g. for the -Dwebdriver.runner.providers list system property.
	 */
	String getName();

	// boolean canRunInParallel();
	
}

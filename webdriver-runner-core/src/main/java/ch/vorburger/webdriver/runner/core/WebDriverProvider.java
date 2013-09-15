package ch.vorburger.webdriver.runner.core;

import javax.inject.Provider;

import org.openqa.selenium.WebDriver;

public interface WebDriverProvider extends Provider<WebDriver> {

	/**
	 * Name of the Provider.
	 * Used e.g. for the -Dwebdriver.runner.providers list system property.
	 */
	String getName();

	// boolean canRunInParallel();
	
}

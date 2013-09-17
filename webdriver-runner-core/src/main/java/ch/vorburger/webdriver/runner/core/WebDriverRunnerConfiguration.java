package ch.vorburger.webdriver.runner.core;

public interface WebDriverRunnerConfiguration {

	Iterable<WebDriverProvider> getWebDriverProviders();
	
}

package ch.vorburger.webdriver.runner.core;

public interface WebDriverRunnerConfigurator {

	WebDriverRunnerConfiguratorBuilder register(WebDriverProvider provider);
	
}

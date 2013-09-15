package ch.vorburger.webdriver.runner.core.examples;

import ch.vorburger.webdriver.runner.core.providers.ChromeDriverProvider;
import ch.vorburger.webdriver.runner.core.providers.FirefoxDriverProvider;
import ch.vorburger.webdriver.runner.core.sugar.AbstractWebDriverRunnerConfiguration;

public class MyWebDriverTestConfiguration extends AbstractWebDriverRunnerConfiguration {

	@Override public void configure() {
		config.register(new ChromeDriverProvider());
		config.register(new FirefoxDriverProvider()).isDefault();
	}
	
}

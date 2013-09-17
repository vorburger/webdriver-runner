package ch.vorburger.webdriver.runner.core.examples;

import java.util.Arrays;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;
import ch.vorburger.webdriver.runner.core.providers.ChromeDriverProvider;
import ch.vorburger.webdriver.runner.core.providers.FirefoxDriverProvider;
import ch.vorburger.webdriver.runner.core.sugar.AbstractWebDriverRunnerConfiguration;

public class MyWebDriverTestConfiguration extends AbstractWebDriverRunnerConfiguration {

	@Override public Iterable<WebDriverProvider> doGetWebDriverProviders() {
		return Arrays.asList( new WebDriverProvider[] {
				new ChromeDriverProvider(), 
				new FirefoxDriverProvider()
			});
	}

}

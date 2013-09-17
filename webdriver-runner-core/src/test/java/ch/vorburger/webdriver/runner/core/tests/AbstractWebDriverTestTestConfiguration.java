package ch.vorburger.webdriver.runner.core.tests;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;
import ch.vorburger.webdriver.runner.core.WebDriverRunnerConfiguration;

public class AbstractWebDriverTestTestConfiguration implements WebDriverRunnerConfiguration {

	@Override public Iterable<WebDriverProvider> getWebDriverProviders() {
		final WebDriverProvider testWebDriverProvider = new WebDriverProvider() {
			@Override public WebDriver getNewWebDriver() throws Exception {
				return new HtmlUnitDriver(); // just as an example
			}

			@Override public String getName() {
				return "hello, world";
			}
		};
		return Collections.singleton(testWebDriverProvider);
	}

}

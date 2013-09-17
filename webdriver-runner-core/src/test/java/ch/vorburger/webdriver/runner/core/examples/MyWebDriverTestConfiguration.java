package ch.vorburger.webdriver.runner.core.examples;

import java.util.Arrays;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;
import ch.vorburger.webdriver.runner.core.WebDriverRunnerConfiguration;
import ch.vorburger.webdriver.runner.core.providers.ChromeDriverProvider;
import ch.vorburger.webdriver.runner.core.providers.FirefoxDriverProvider;
import ch.vorburger.webdriver.runner.core.providers.RecyclingDriverProvider;

public class MyWebDriverTestConfiguration implements WebDriverRunnerConfiguration {

	@Override public Iterable<WebDriverProvider> getWebDriverProviders() {
		return Arrays.asList( new WebDriverProvider[] {
				new ChromeDriverProvider(), 
				new FirefoxDriverProvider()
			});
	}

	// TODO move this up into a parent base class which can be re-used by other WebDriverRunnerConfiguration implementations
	protected Iterable<WebDriverProvider> getRecyclingProviders(Iterable<WebDriverProvider> providers) {
		return Iterables.transform(providers, new Function<WebDriverProvider, WebDriverProvider>() {
			public WebDriverProvider apply(WebDriverProvider provider) {
				return new RecyclingDriverProvider(provider);
			}
		});
	}

}

package ch.vorburger.webdriver.runner.core.sugar;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;
import ch.vorburger.webdriver.runner.core.WebDriverRunnerConfiguration;
import ch.vorburger.webdriver.runner.core.providers.RecyclingDriverProvider;

public abstract class AbstractWebDriverRunnerConfiguration implements WebDriverRunnerConfiguration {

	@Override
	public Iterable<WebDriverProvider> getWebDriverProviders() {
		return getRecyclingProviders(doGetWebDriverProviders());
	}

	public abstract Iterable<WebDriverProvider> doGetWebDriverProviders();
	
	protected Iterable<WebDriverProvider> getRecyclingProviders(Iterable<WebDriverProvider> providers) {
		return Iterables.transform(providers, new Function<WebDriverProvider, WebDriverProvider>() {
			public WebDriverProvider apply(WebDriverProvider provider) {
				return new RecyclingDriverProvider(provider);
			}
		});
	}
}

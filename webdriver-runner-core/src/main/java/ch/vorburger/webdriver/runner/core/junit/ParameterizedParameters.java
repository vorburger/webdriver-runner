package ch.vorburger.webdriver.runner.core.junit;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

public class ParameterizedParameters {

	private final Iterable<WebDriverProvider> providers;

	public ParameterizedParameters(Iterable<WebDriverProvider> providers) {
		this.providers = providers;
	}

	public Iterable<Object[]> webDriverProvidersAndNameData() {
		return getAsParameters(providers);
	}
	
	protected static Iterable<Object[]> getAsParameters(Iterable<WebDriverProvider> providers) {
		return Iterables.transform(providers, new Function<WebDriverProvider, Object[]>() {
			public Object[] apply(WebDriverProvider provider) {
				return new Object[] { provider.getName(), provider  } ;
			}
		});
	}

}

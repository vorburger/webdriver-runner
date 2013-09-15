package ch.vorburger.webdriver.runner.core.providers;

import org.openqa.selenium.WebDriver;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;

public abstract class DelegatingDriverProvider implements WebDriverProvider {

	protected final WebDriverProvider delegate;

	protected DelegatingDriverProvider(WebDriverProvider delegate) {
		super();
		this.delegate = delegate;
	}

	@Override public WebDriver getNewWebDriver() throws Exception {
		return delegate.getNewWebDriver();
	}

	@Override public String getName() {
		return delegate.getName();
	}

}

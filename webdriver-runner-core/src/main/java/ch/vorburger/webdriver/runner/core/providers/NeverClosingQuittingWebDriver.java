package ch.vorburger.webdriver.runner.core.providers;

import org.openqa.selenium.WebDriver;

public class NeverClosingQuittingWebDriver extends DelegatingWebDriver {

	public NeverClosingQuittingWebDriver(WebDriver delegate) {
		super(delegate);
	}

	@Override
	public void close() {
		if (getWindowHandles().size() > 1)
			super.close();
		// else: Ignore!
	}

	@Override
	public void quit() {
		// Ignore
	}

}

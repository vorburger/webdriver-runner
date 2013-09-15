package ch.vorburger.webdriver.runner.core.providers;

import org.openqa.selenium.WebDriver;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;

/**
 * WebDriverProvider which "recycles" one once constructed WebDriver,
 * instead of actually creating a new one on each call to getNewWebDriver()
 * e.g. for each test.
 * 
 * This can be useful for speed when executing a suite of tests, because
 * starting and opening up a new browser for each test is time consuming. 
 *
 * If you close() or quit() the returned WebDriver, the implementation will ensure that
 * it doesn't actually close the last window or really quit (so that it can be re-used).
 * <i>(From experience in a large in-house / proprietary test base with an older WebDriver
 * version, I vaguely recall that this didn't always work reliably, because getWindowHandles()
 * under some circumstance didn't work as expected... hopefully that's better now; else you may
 * not want to use this, in case your tests open new windows [not just DIV layers].)</i> 
 *
 * This class is, intentionally and by design, NOT multi-thread safe.
 * It is intended to be used in single threaded one-after-the-other 
 * (for a given WebDriver implementation) runners.
 * @see PoolingDriverProvider
 */
public class RecyclingDriverProvider extends DelegatingDriverProvider {

	protected WebDriver webDriver;
	
	public RecyclingDriverProvider(WebDriverProvider delegate) {
		super(delegate);
	}

	@Override public WebDriver getNewWebDriver() throws Exception {
		if (webDriver == null)
			webDriver = wrapNeverClosingOrQuitting(super.getNewWebDriver());
		return webDriver;
	}

	protected WebDriver wrapNeverClosingOrQuitting(WebDriver newWebDriver) {
		return new NeverClosingQuittingWebDriver(newWebDriver);
	}
	
}

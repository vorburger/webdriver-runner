package ch.vorburger.webdriver.runner.core.examples;

import java.util.Arrays;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;
import ch.vorburger.webdriver.runner.core.providers.ChromeDriverProvider;
import ch.vorburger.webdriver.runner.core.providers.FirefoxDriverProvider;

@RunWith(Parameterized.class)
public class WebDriverParametrizedExampleTest {
	
	// TODO refactor push up into and use AbstractWebDriverTest
	
	// Doesn't work :( @Parameter WebDriver wd; so instead (TODO raise Junit bug..)
	
	// TODO test name!!
	
	protected final WebDriver webDriver;

	public WebDriverParametrizedExampleTest(WebDriverProvider driver) {
		this.webDriver = driver.get();
	}
	
	@Parameters public static Iterable<WebDriverProvider[]> webDrivers() {
		// TODO use/delegate to MyWebDriverTestConfiguration idea instead?
		return Arrays.asList(new WebDriverProvider[][] {
				new WebDriverProvider[] { new ChromeDriverProvider() }, 
				new WebDriverProvider[] { new FirefoxDriverProvider() } 
		});
	}
	
	@Test public void testGoogle() {
		webDriver.get("http://www.google.com");
	}

	@Test public void testVorburgerCH() {
		webDriver.get("http://www.vorburger.ch");
	}
	
	@After public void afterTest() {
		webDriver.quit();
	}
	
}

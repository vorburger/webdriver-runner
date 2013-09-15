package ch.vorburger.webdriver.runner.core.examples;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

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
	
	protected final WebDriver w;

	public WebDriverParametrizedExampleTest(WebDriverProvider driver) throws Exception {
		this.w = driver.getNewWebDriver();
	}
	
	@Parameters public static Iterable<WebDriverProvider[]> webDrivers() {
		// TODO use/delegate to MyWebDriverTestConfiguration idea instead?
		return Arrays.asList(new WebDriverProvider[][] {
				new WebDriverProvider[] { new ChromeDriverProvider() }, 
				new WebDriverProvider[] { new FirefoxDriverProvider() } 
		});
	}
	
	@Test public void testGoogle() {
		w.get("http://www.google.com");
		assertThat(w.getTitle(), containsString("Google"));
	}

	@Test public void testVorburgerCH() {
		w.get("http://www.vorburger.ch");
		assertThat(w.getTitle(), containsString("Homepage"));
	}
	
	// TODO push this up / into helper.. but ideally separate class from core multi-runner stuff?
	@After public void afterTest() {
		w.quit();
	}
	
}

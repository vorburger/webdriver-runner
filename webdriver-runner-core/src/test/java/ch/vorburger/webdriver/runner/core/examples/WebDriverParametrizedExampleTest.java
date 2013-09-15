package ch.vorburger.webdriver.runner.core.examples;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;
import ch.vorburger.webdriver.runner.core.providers.ChromeDriverProvider;
import ch.vorburger.webdriver.runner.core.providers.FirefoxDriverProvider;

@RunWith(Parameterized.class)
public class WebDriverParametrizedExampleTest {
	
	// TODO refactor push up into and use AbstractWebDriverTest
	
	// TODO test name!!
	
	// Field injected @Parameter preferable over Constructor injection, because Constructor with super would have to be repeated in each test class  
	// NOTE: Until (if) https://github.com/junit-team/junit/pull/737 makes it in, this HAS to be public (cannot be protected)
	@Parameter public WebDriverProvider webDriverProvider;
	protected WebDriver w;

	@Before public void beforeTest() throws Exception {
		w = webDriverProvider.getNewWebDriver();
	}
	
	@Parameters public static Iterable<WebDriverProvider[]> webDrivers() {
		// TODO use/delegate to MyWebDriverTestConfiguration idea instead?
		// TODO switch this to use the new RecyclingDriverProvider.. keep the entire config. outside.. how/where?
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

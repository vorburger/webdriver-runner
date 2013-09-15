package ch.vorburger.webdriver.runner.core.examples;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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

@RunWith(Parameterized.class) // @see https://github.com/junit-team/junit/wiki/Parameterized-tests
public class WebDriverParametrizedExampleTest {
	
	// TODO refactor push up into and use AbstractWebDriverTest (or, better, a composed helper...)
	
	// Field injected @Parameter preferable over Constructor injection, because Constructor with super would have to be repeated in each test class  
	// NOTE: Until (if) https://github.com/junit-team/junit/pull/737 makes it in, this HAS to be public (cannot be protected)
	@Parameter(value=0) public String webDriverProviderName;
	@Parameter(value=1) public WebDriverProvider webDriverProvider;
	protected WebDriver w;

	@Before public void beforeTest() throws Exception {
		w = webDriverProvider.getNewWebDriver();
	}
	
	// TODO keep the entire config. outside.. how/where?
	// TODO use/delegate to MyWebDriverTestConfiguration idea instead?
	@Parameters(name = "{0}") 
	public static Iterable<Object[]> webDriverProvidersAndName() {
		// TODO switch this to use the new RecyclingDriverProvider.. 
		Iterable<WebDriverProvider> providers = Arrays.asList( new WebDriverProvider[] {
			new ChromeDriverProvider(), new FirefoxDriverProvider()
		});
		return getAsParameters(providers);
	}
	protected static Iterable<Object[]> getAsParameters(Iterable<WebDriverProvider> providers) {
		// TODO use Google thing to transform.. 
		Collection<Object[]> parameters = new ArrayList<Object[]>();
		for (WebDriverProvider provider : providers) {
			parameters.add(new Object[] { provider.getName(), provider  } );
		}
		return parameters;
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

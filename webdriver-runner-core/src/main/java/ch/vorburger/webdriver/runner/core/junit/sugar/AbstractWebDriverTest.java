package ch.vorburger.webdriver.runner.core.junit.sugar;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;
import ch.vorburger.webdriver.runner.core.junit.ParameterizedParameters;
import ch.vorburger.webdriver.runner.core.providers.ChromeDriverProvider;
import ch.vorburger.webdriver.runner.core.providers.FirefoxDriverProvider;
import ch.vorburger.webdriver.runner.core.providers.RecyclingDriverProvider;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * Abstract convenience test base class. 
 * With appropriate annotations, and protected @Inject WebDriver.
 * 
 * This is just "sugar" - in case e.g. your in-house WD framework already has a
 * similar base class, you do not have to use this one of course, and can just
 * use the annotations directly.
 * 
 * @author Michael Vorburger
 */
@RunWith(Parameterized.class) // @see https://github.com/junit-team/junit/wiki/Parameterized-tests
// TODO no need? @RunWith(WebDriverRunner.class)
// TODO ? @WebDriverConfiguration(MyWebDriverTestConfiguration.class) ?
public class AbstractWebDriverTest {

	@Parameters(name = "{0}") 
	public static Iterable<Object[]> webDriverProvidersAndNameData() {
		Iterable<WebDriverProvider> providers = Arrays.asList( new WebDriverProvider[] {
			// TODO don't hard-code here, but use/delegate to/integrate with MyWebDriverTestConfiguration idea...
			new ChromeDriverProvider(), new FirefoxDriverProvider()
		});
		return new ParameterizedParameters(getRecyclingProviders(providers)).webDriverProvidersAndNameData();
	}
	
	protected static Iterable<WebDriverProvider> getRecyclingProviders(Iterable<WebDriverProvider> providers) {
		return Iterables.transform(providers, new Function<WebDriverProvider, WebDriverProvider>() {
			public WebDriverProvider apply(WebDriverProvider provider) {
				return new RecyclingDriverProvider(provider);
			}
		});
	}

	// Field injected @Parameter preferable over Constructor injection, because Constructor with super would have to be repeated in each test class  
	// NOTE: Until (if) https://github.com/junit-team/junit/pull/737 makes it in, this HAS to be public (cannot be protected)
	@Parameter(value=0) public String webDriverProviderName;
	@Parameter(value=1) public WebDriverProvider webDriverProvider;
	protected WebDriver w;

	@Before public void beforeTest() throws Exception {
		w = webDriverProvider.getNewWebDriver();
	}

	@After public void afterTest() {
		w.quit();
	}
	
}

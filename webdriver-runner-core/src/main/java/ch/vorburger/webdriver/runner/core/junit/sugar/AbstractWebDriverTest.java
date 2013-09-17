package ch.vorburger.webdriver.runner.core.junit.sugar;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameter;
import org.openqa.selenium.WebDriver;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;
import ch.vorburger.webdriver.runner.core.junit.WebDriverRunner;

/**
 * Abstract convenience test base class. 
 * With appropriate annotations, and WebDriver available to subclasses.
 * 
 * Sub classes must define the JUnit Parameterized Parameters like this:
 * <pre> &#064;Parameters(name = "{0}") 
 * public static Iterable<&lt;Object[]&gt; webDriverProvidersAndNameData() {
 *     Iterable<WebDriverProvider> providers = config.getWebDriverProviders();
 *     return new ParameterizedParameters(providers).webDriverProvidersAndNameData();
 * }</pre>
 * 
 * This is just "sugar" - in case e.g. your in-house WD framework already has a
 * similar base class, you do not have to use this one of course, and you can just
 * copy/pasted (or adapt to your needs) the boilerplate code and annotations below.
 * 
 * @author Michael Vorburger
 */
@RunWith(WebDriverRunner.class)
public abstract class AbstractWebDriverTest {

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

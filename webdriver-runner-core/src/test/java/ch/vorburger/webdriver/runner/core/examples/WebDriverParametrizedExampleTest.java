package ch.vorburger.webdriver.runner.core.examples;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;
import ch.vorburger.webdriver.runner.core.junit.ParameterizedParameters;
import ch.vorburger.webdriver.runner.core.junit.sugar.AbstractWebDriverTest;

// TODO not used yet.. @WithWebDriverRunnerConfiguration(MyWebDriverTestConfiguration.class)
public class WebDriverParametrizedExampleTest extends AbstractWebDriverTest {
	
	@Parameters(name = "{0}") 
	public static Iterable<Object[]> webDriverProvidersAndNameData() {
		Iterable<WebDriverProvider> providers = new MyWebDriverTestConfiguration().getWebDriverProviders();
		return new ParameterizedParameters(providers).webDriverProvidersAndNameData();
	}
	
	@Test public void testGoogle() {
		w.get("http://www.google.com");
		assertThat(w.getTitle(), containsString("Google"));
	}

	@Test public void testVorburgerCH() {
		w.get("http://www.vorburger.ch");
		assertThat(w.getTitle(), containsString("Homepage"));
	}
	
}

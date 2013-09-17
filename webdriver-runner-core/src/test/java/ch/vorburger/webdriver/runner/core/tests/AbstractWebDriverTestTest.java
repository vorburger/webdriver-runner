package ch.vorburger.webdriver.runner.core.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;
import ch.vorburger.webdriver.runner.core.junit.ParameterizedParameters;
import ch.vorburger.webdriver.runner.core.junit.sugar.AbstractWebDriverTest;

//TODO not used yet.. @WithWebDriverRunnerConfiguration(AbstractWebDriverTestTestConfiguration.class)
public class AbstractWebDriverTestTest extends AbstractWebDriverTest {
	// TODO try a subclass..
	
	@Parameters(name = "{0}") 
	public static Iterable<Object[]> webDriverProvidersAndNameData() {
		Iterable<WebDriverProvider> providers = new AbstractWebDriverTestTestConfiguration().getWebDriverProviders();
		return new ParameterizedParameters(providers).webDriverProvidersAndNameData();
	}
	
	@Test public void testWithWebDriverRunnerConfigurationUtil() {
		Assert.assertEquals("hello, world", webDriverProvider.getName());
		Assert.assertNotNull(w);
	}
}

package ch.vorburger.webdriver.runner.core.providers.tests;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;
import ch.vorburger.webdriver.runner.core.providers.ChromeDriverProvider;
import ch.vorburger.webdriver.runner.core.providers.RecyclingDriverProvider;

public class RecyclingDriverProviderTest {

	// BEWARE: This HAS to be static - else despite all the green house effort
	// to recylce, you'll get a new Driver, because JUnit actually creates a new
	// *Test class instance for each @Test test...() method!
	protected static WebDriverProvider p = new RecyclingDriverProvider(new ChromeDriverProvider());
	
	protected WebDriver w;

	@Before public void beforeTest() throws Exception {
		w = p.getNewWebDriver(); 
	}
	
	@After public void afterTest() {
		w.quit();
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

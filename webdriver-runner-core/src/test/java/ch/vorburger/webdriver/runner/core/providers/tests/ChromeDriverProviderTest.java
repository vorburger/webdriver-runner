package ch.vorburger.webdriver.runner.core.providers.tests;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import ch.vorburger.webdriver.runner.core.providers.ChromeDriverProvider;

public class ChromeDriverProviderTest {

	@Test
	public void testChromeDriverProvider() throws Exception {
		ChromeDriverProvider p = new ChromeDriverProvider();
		WebDriver w = p.getNewWebDriver();
		w.get("http://www.vorburger.ch");
		assertThat(w.getTitle(), containsString("Homepage"));
		w.quit();
	}

}

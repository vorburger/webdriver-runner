package ch.vorburger.webdriver.runner.core.providers.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import ch.vorburger.webdriver.runner.core.providers.ChromeDriverProvider;
import static org.hamcrest.CoreMatchers.*;

public class ChromeDriverProviderTest {

	@Test
	public void testChromeDriverProvider() {
		ChromeDriverProvider p = new ChromeDriverProvider();
		WebDriver w = p.get();
		w.get("http://www.vorburger.ch");
		assertThat(w.getTitle(), containsString("Homepage"));
		w.quit();
	}

}

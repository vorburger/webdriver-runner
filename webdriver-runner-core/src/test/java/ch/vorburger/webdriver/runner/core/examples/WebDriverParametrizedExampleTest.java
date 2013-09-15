package ch.vorburger.webdriver.runner.core.examples;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ch.vorburger.webdriver.runner.core.junit.sugar.AbstractWebDriverTest;

public class WebDriverParametrizedExampleTest extends AbstractWebDriverTest {
	
	@Test public void testGoogle() {
		w.get("http://www.google.com");
		assertThat(w.getTitle(), containsString("Google"));
	}

	@Test public void testVorburgerCH() {
		w.get("http://www.vorburger.ch");
		assertThat(w.getTitle(), containsString("Homepage"));
	}
	
}

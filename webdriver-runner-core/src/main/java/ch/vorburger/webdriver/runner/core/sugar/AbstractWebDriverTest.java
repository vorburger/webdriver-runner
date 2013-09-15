package ch.vorburger.webdriver.runner.core.sugar;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import ch.vorburger.webdriver.runner.core.junit.WebDriverRunner;

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
@RunWith(WebDriverRunner.class)
//@InjectWith(MyWebDriverTestInjectorProvider.class)
//@WebDriverConfiguration(MyWebDriverTestConfiguration.class)
public class AbstractWebDriverTest {


	protected @Inject WebDriver wd;

}

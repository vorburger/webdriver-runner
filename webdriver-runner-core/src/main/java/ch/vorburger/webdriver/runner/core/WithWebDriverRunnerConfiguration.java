package ch.vorburger.webdriver.runner.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface WithWebDriverRunnerConfiguration {

	// TODO This annotation isn't used (read), yet.. implement later - or remove eventually.
	
	Class<? extends WebDriverRunnerConfiguration> value();

}

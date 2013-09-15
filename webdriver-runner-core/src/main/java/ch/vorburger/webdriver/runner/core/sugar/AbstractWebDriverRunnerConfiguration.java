package ch.vorburger.webdriver.runner.core.sugar;

import javax.inject.Inject;

import ch.vorburger.webdriver.runner.core.WebDriverRunnerConfiguration;
import ch.vorburger.webdriver.runner.core.WebDriverRunnerConfigurator;


public abstract class AbstractWebDriverRunnerConfiguration implements WebDriverRunnerConfiguration {

	protected @Inject WebDriverRunnerConfigurator config;

}

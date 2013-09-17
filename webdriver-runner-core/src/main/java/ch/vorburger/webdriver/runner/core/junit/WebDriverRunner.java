package ch.vorburger.webdriver.runner.core.junit;

import org.junit.runners.Parameterized;

public class WebDriverRunner extends Parameterized {  // @see https://github.com/junit-team/junit/wiki/Parameterized-tests

	// TODO For now, this class IS Parameterized.. remove?
	// I expect that when I have a moment to look into Parallelization stuff, it will become more interesting.  Else remove later..
	// A (parallelization unrelated) "nice to have" would be to use WithWebDriverRunnerConfiguration annotation, instead of the current approach.
	
	// copy/pasted from Parameterized (because it's private up there)
	// TODO REMOVE? private static final List<Runner> NO_RUNNERS = Collections.<Runner>emptyList();
	
	public WebDriverRunner(Class<?> klass) throws Throwable {
		 super(klass);
		 
	}

}

package ch.vorburger.webdriver.runner.core.junit;

import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Parameterized;
import org.junit.runners.model.InitializationError;

public class WebDriverRunner extends Runner {

	// TODO Since I'm able to use @RunWith(Parameterized.class), probably delete this.. 
	
	public WebDriverRunner(Class<?> testClass) throws InitializationError {
		//super(testClass);
	}
	
	@Override public Description getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override public void run(RunNotifier notifier) {
		// TODO Auto-generated method stub
	}

}

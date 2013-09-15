package ch.vorburger.webdriver.runner.core.providers;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;

/**
 * WebDriverProvider for ChromeDriver.
 * 
 * To optimize, this will only ever launch one ChromeDriverService (per JVM),
 * and then re-use it (until shutdown).
 * 
 * In order to use this, you must have previously downloaded the ChromeDriver
 * Server platform specific binary, and made it available on your %PATH%, from
 * https://code.google.com/p/chromedriver/downloads/list. That isn't the same
 * thing as the Java ChromeDriver class, or the Chrome Browser binary!
 */
public class ChromeDriverProvider implements WebDriverProvider {

	protected static Singleton singleton;
	
	// TODO rename this.. this actually is NOT a Singleton (only the static above makes it).  This is a... what? AutoStartStopDriverService ? 
	protected class Singleton {
		protected ChromeDriverService service;

		public Singleton() throws IOException {
			service = ChromeDriverService.createDefaultService();
			service.start();
			// TODO Runtime.getRuntime().addShutdownHook(shutdownHookThread);
		}
		
		@Override
		protected void finalize() {
			stop();
		}

		protected void stop() {
			try {
				if (service != null && service.isRunning()) {
					service.stop();
					service = null;
				}
			} catch (Throwable t) {
				// Ignore.
			}
		}
		
		public ChromeDriverService getDriverService() {
			return service;
		}
	}
	
	protected Singleton getSingleton() throws IOException {
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}

	@Override
	public WebDriver getNewWebDriver() throws IOException {
		Singleton singleton = getSingleton();
		DesiredCapabilities capabilities = getDesiredCapabilities();
		return new ChromeDriver(singleton.getDriverService(), capabilities);
	}

	protected DesiredCapabilities getDesiredCapabilities() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
		return capabilities;
	}

	@Override
	public String getName() {
		return "Chrome";
	}

}

package ch.vorburger.webdriver.runner.core.providers;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriverService;

/**
 * DriverService which starts up lazily on first invocation of
 * getDriverService(), subsequently returns the same, and auto-stops it on
 * shutdown or GC.
 * 
 * Quote: "Starting and stopping ChromeDriverService multiple times will add a noticeable delay to a larger test suite".
 * 
 * @see https://code.google.com/p/selenium/wiki/ChromeDriver#Running_the_server_in_a_child_process
 */
public class LazyAutoStoppingChromeDriverService {
	
	// TODO generalize this class so that it can be shared between the InternetExplorerDriverProvider and the ChromeDriverProvider
	
	protected ChromeDriverService service;

	public ChromeDriverService getDriverService() throws IOException {
		if (service == null) {
			service = start();
		}
		return service;
	}
	
	protected ChromeDriverService start() throws IOException {
		if (service != null)
			throw new IllegalStateException();
		ChromeDriverService newService = ChromeDriverService.createDefaultService();
		newService.start();
		Runtime.getRuntime().addShutdownHook(getNewShutdownHookThread());
		return newService;
	}
	
	protected Thread getNewShutdownHookThread() {
		return new Thread(new Runnable() {
			@Override
			public void run() {
				stop();
			}
		}, getClass().getSimpleName() + "ShutdownHookThread");
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
}
package ch.vorburger.webdriver.runner.core.providers;

import java.util.Collection;

import ch.vorburger.webdriver.runner.core.WebDriverProvider;

/**
 * WebDriverProvider which maintains a small pool of once constructed WebDriver instances.
 * 
 * TBD This is PLANNED TO BE USED for optimized local multi-threaded concurrent test execution (if viable). 
 */
public class PoolingDriverProvider extends DelegatingDriverProvider {

	// TODO implement me! ;-) If this idea is even viable.. unclear if (all?) WD Impl. can run several browsers concurrently locally?!

	// TODO IFF this is viable, I'll need some new API method/concept to "release" (return to pool) an obtained WD?  On quit() and last close() it could do this automatically.. if not called, explicit needed
	
	protected Collection<DelegatingDriverProvider> pool;

	/**
	 * Constructor.
	 * 
	 * @param delegate the "real" WebDriverProvider creating truly fresh new instances (e.g. a ChromeDriverProvider etc. but NOT a RecyclingDriverProvider or another RecyclingDriverProvider)
	 */
	protected PoolingDriverProvider(WebDriverProvider delegate) {
		super(delegate);
		if (delegate instanceof RecyclingDriverProvider)
			throw new IllegalArgumentException();
		if (delegate instanceof PoolingDriverProvider)
			throw new IllegalArgumentException();
	}
	
}

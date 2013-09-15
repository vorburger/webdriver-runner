webdriver-runner
================

basically an @Inject WebDriver multi-browser / parallel / cloud-remote (SauceLabs) configurable test runner infra ;)

webdriver-runner is a small micro framework/library which injects a suitable concrete 
driver implementation instance used in your write Selenium 2.0 (AKA WebDriver) JUnit Tests.

This avoids hard-coding new FirefoxDriver() etc. within your functional test code,
and enables switching by configuration e.g. from say the FirefoxDriver to the ChromeDriver, 
e.g. simply via a Java system property (-D), without changing test source code.

Likewise, the same test code could easily be made to execute twice, but once on the FirefoxDriver,
and then on the ChromeDriver.  Furthermore, you can configure webdriver-runner to let
the very same clean functional test run in parallel on different WebDriver implementations.

Lastly, the respective WebDriverProvider is implemented "efficiently" for fast tests start-up;
i.e. it ensures that it only starts the respective DriverService (if needed) once (or one per thread),
and that it pools WebDriver instances (as starting new browser windows is expensive). 

webdriver-runner is split into several artifacts:

* webdriver-runner-core is for local tests execution. 
See [WebDriverParametrizedExampleTest](https://github.com/vorburger/webdriver-runner/blob/master/webdriver-runner-core/src/test/java/ch/vorburger/webdriver/runner/core/examples/WebDriverParametrizedExampleTest.java) for a usage example.
* _webdriver-runner-saucelabs (TBD) will allow running tests on https://saucelabs.com_

_TODO: blurb with details re. -D configuration._

_TODO: blurb with details re. parallel test execution TBD._

_TODO: blurb about how to get it from my Maven repo, à la webdriver-reporting._

BTW: You may find [webdriver-reporting](https://github.com/vorburger/webdriver-reporting/) of interest to you as well?

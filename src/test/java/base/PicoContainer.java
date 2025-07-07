package Base;

import org.openqa.selenium.WebDriver;

import Pages.PageObjectManager;

public class PicoContainer {
	
	private Browser browser;
	private PageObjectManager pageobject;
	private WebDriver driver;
	
	public PicoContainer() {
		browser= new Browser();
		// Call BrowserInvoke once to ensure driver is initialized for this PicoContainer instance
		// The Browser class itself ensures only one actual browser is opened globally
		//driver = browser.BrowserInvoke();
		//pageobject = new PageObjectManager(driver);
		pageobject =new PageObjectManager(browser.BrowserInvoke());
	}
	
	public Browser getbrowser() {
		return browser;
	}
	public PageObjectManager getpageobject() {
		return pageobject;
	}
	
	// Add a getter for the driver itself if needed directly in steps/hooks
		public WebDriver getDriver() {
			return driver;
		}
	

}

package Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import Base.PicoContainer;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class PreAndPostCondition {
	
	private WebDriver driver;
	private PicoContainer picoContainer;
	
	
	public PreAndPostCondition(PicoContainer picocontainer) {
		driver=picocontainer.getbrowser().BrowserInvoke();
		// Get the WebDriver instance. PicoContainer's constructor ensures it's invoked once.
		// Directly access the driver after it's invoked in PicoContainer
		//this.picoContainer = picoContainer;
		//this.driver = picocontainer.getbrowser().driver;
	}
	
	// This @After hook will close the browser ONLY IF the scenario has the @smoke tag.
	// If you want to close the browser AFTER ALL scenarios, you'd use a different approach.
	// For example, an @After without a tag, or managing it in the TestRunner via TestNG
	@After
	public void postCondition() {
		//driver.quit();
		System.out.println("Closing browser after @smoke scenario.");
		picoContainer.getbrowser().closeBrowser(); 
	}
	
	@AfterStep
	public void screenShot(Scenario scenario) {
		if (scenario.isFailed()) {
			
			byte[] Screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(Screenshot, "image/png","screenFailure");
		}
		
	}
	

}

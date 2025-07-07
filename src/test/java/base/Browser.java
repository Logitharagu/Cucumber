package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
	
	public WebDriver driver;
	public int Sellector=1;
	
	public WebDriver BrowserInvoke() {
		// Only initialize driver if it's null (first time invocation)
		if (driver==null) {
			switch (Sellector) {
			case 1:
				System.out.println("User Select Chrome Browser");
				driver=new ChromeDriver();
				break;
			case 2:
				System.out.println("User Select Edge Browser");
				driver=new EdgeDriver();
				break;
			default:
				System.out.println("User Select Unknow Value So Open Chrome Browser");
				driver=new ChromeDriver();
				break;
			}
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		return driver;
	}
	// Getter for the static driver
	//public WebDriver getDriver() {
	//	return driver;
	//}
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
			driver = null; // Set to null after quitting to ensure a fresh instance if needed later
		}
	}

}

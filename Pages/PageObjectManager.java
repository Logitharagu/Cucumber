package Pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	private LoginPage loginpage;
	private Admin admins;
	private WebDriver driver;//123
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
   //using getter methods
	
	public LoginPage getLoginPage() {
		if(loginpage == null) {
			loginpage = new LoginPage(driver);
		}
		return loginpage;
	}

	public Admin getAdmin() {
		if(admins == null) {
			admins = new Admin(driver);
		}
		return admins;
	}

}

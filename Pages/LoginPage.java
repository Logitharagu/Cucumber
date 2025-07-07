package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Util.PropertyFileReader;

import Util.PropertyFileReader;

public class LoginPage {
	
	private WebDriver driver;
	// These locators are for getting the displayed username/password
	private By UserName = By.xpath("//p[text()='Username : Admin']");
	private By PassWord = By.xpath("//p[text()='Password : admin123']");
	// These are for the actual input fields
	private By Name=By.xpath("//input[@name='username']");
	private By Pass=By.xpath("//input[@type='password']");
	private By Button=By.xpath("//button[@type='submit']");
	private String sURL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"; //PropertyFileReader.readDataFromPropertyFile("environment", "orange");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
//		this.sURL = PropertyFileReader.readTheDataFromPropertyFile("Url", "Orange");
//	    if (sURL == null || sURL.isEmpty()) {
//	        throw new IllegalArgumentException("URL is not loaded from the property file. Check Orange.properties.");
//	    }
	}
	
	public void navigateURL() {
		driver.navigate().to(sURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); 
	}
	public void getNameAndPass() {
		WebElement Ouser,Opass;
		Ouser=driver.findElement(UserName);
	    String text = Ouser.getText();
		System.out.println("The userName: "+text);
		
		Opass=driver.findElement(PassWord);
		String text2 = Opass.getText();
		System.out.println("The password: "+text2);
	}
	
	public void enterName(String userId) {
		
		WebElement Oname;
		Oname=driver.findElement(Name);
		Oname.sendKeys(userId);	
	}
	public void enterpass(String password) {
		WebElement Opass;
		Opass=driver.findElement(Pass);
		Opass.sendKeys(password);
	}
	public void BottonClick() {
		WebElement Obutton;
		Obutton=driver.findElement(Button);
		Obutton.click();
	}
	
	

}

package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Admin {
	

	private WebDriver driver;
	private WebDriverWait wait;
	private By SelectAdmin=By.xpath("//ul[@class='oxd-main-menu']//a[1]");
	private By UserName=By.xpath("//div[2]/input");
	private By UseRole=By.xpath("//label[text()='User Role']/following::div[@class='oxd-select-wrapper'][1]");
	//private By Employee=By.xpath("//input[@placeholder='Type for hints...']");
	private By State=By.xpath("(//div[@class='oxd-select-wrapper'])[2]");
	private By Search=By.xpath("//button[@type='submit']");
	
	
	public Admin(WebDriver driver) {
		this.driver=driver;
		// Initialize WebDriverWait
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	}
	public void admin() {
		WebElement Oclick;
		Oclick=wait.until(ExpectedConditions.elementToBeClickable(SelectAdmin));
		//Oclick=driver.findElement(SelectAdmin);
		Oclick.click();
	}
	public void usereName(String Name) {
		WebElement Oname;
        Oname=driver.findElement(UserName);
		Oname.sendKeys(Name);
	}
	public void role(String TextRole) {
		WebElement Orole;
		Orole = wait.until(ExpectedConditions.elementToBeClickable(UserName));
		Orole.click();
		By roleOptionLocator = By.xpath("//div[@role='listbox']//span[text()='" + TextRole + "']");
		WebElement roleOption = wait.until(ExpectedConditions.elementToBeClickable(roleOptionLocator));
		roleOption.click();
		
	}
	
	public void state(String name) {
		WebElement Ostat;
		Ostat = wait.until(ExpectedConditions.elementToBeClickable(State));
		Ostat.click();
		By stateOptionLocator = By.xpath("//div[@role='listbox']//span[text()='" + name + "']");
		WebElement stateOption = wait.until(ExpectedConditions.elementToBeClickable(stateOptionLocator));
		stateOption.click();
	}
	public void click() {
		WebElement Oselect;
		Oselect = wait.until(ExpectedConditions.elementToBeClickable(Search));
		Oselect.click();
	}
	
}

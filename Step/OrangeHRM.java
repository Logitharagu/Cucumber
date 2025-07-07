package Step;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;

import Base.PicoContainer;
import Pages.Admin;


public class OrangeHRM {
	public WebDriver driver;
	private LoginPage loginpage;
	private Admin admins;
	
	public OrangeHRM(PicoContainer picocontainer) {
		loginpage =picocontainer.getpageobject().getLoginPage();
		admins=picocontainer.getpageobject().getAdmin();
	}
	
	@Given("User should navigated the URL")
	public void user_should_navigated_the_url() {
		loginpage.navigateURL();
	}

	@When("User Get UserName and PassWord in OrangeHRM")
	public void user_get_user_name_and_pass_word_in_orange_hrm() {
		loginpage.getNameAndPass();
	}

	@When("Used Enter the UserName as {string}")
	public void used_enter_the_user_name_as(String userId) {
		loginpage.enterName(userId);
	}

	@Then("User Enter the Password as {string}")
	public void user_enter_the_password_as(String password) {
		loginpage.enterpass(password); 
	}

	@Then("User Click on Login button")
	public void user_click_on_login_button() {
		loginpage.BottonClick();
	}
	@When("User click Admin")
	public void User_click_Admin() {
		admins.admin();
	}

	@When("User Enter System Users Information UserName as {string}")
	public void user_enter_system_users_information_user_name_as_admin(String Name) {
		admins.usereName(Name);
	}

	@When("User select the role as ([^0-9]+)")
	public void user_select_the_role_as_admin(String TextRole) {
		admins.role(TextRole);
	}


	@Then("User select the state as ([^0-9]+)")
	public void user_select_the_state_as_enabled(String name) {
		admins.state(name);
	}

	@Then("User Click Search button")
	public void user_click_search_button() {
		admins.click();
	}
	

}

package stepDefinations;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LaunchBrowser;
import pageObjects.LoginPage;

public class LoginSteps {

	public LoginSteps() {
		// TODO Auto-generated constructor stub
	}
	public WebDriver ldriver;
	public LoginPage lp;
	public HomePage hp;	
	

@Given("browser is open")
public void browser_is_open() {
	
	//LaunchBrowser.launchBrowser();
     ldriver = LaunchBrowser.getDriver();
     hp = new HomePage(ldriver);
     lp = new LoginPage(ldriver);
}

@Given("User is on the Login Page")
public void user_is_on_the_login_page() {
	hp.openHomePage();
}

@When("user enters the Valid {string} and {string}")
public void user_enters_the_valid_username_and_password(String username,String password) {
	lp.setUserName(username);
	  lp.setPassword(password);
		lp.login();
		System.out.println("User is successfully logged in to the site");
}

@Then("User is redirected to the SelectHome Page")
public void user_is_redirected_to_the_home_page() {
	//HomePage.openHomePage();
	lp.selectHome();
	System.out.println("User is successfully loged in to the select home page and home is selected");
	lp.logout();
	//LaunchBrowser.closeBrowser();
}
			
	}


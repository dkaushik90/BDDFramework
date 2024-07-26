package stepDefinations;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

@Then("User is redirected to the SelectHome Page or Dashboard page")
public void user_is_redirected_to_the_home_page_or_dashboard_page() {
	//HomePage.openHomePage();
	lp.selectHome();
	System.out.println("User is successfully loged in to the select home page and home is selected");
	lp.logout();
	//LaunchBrowser.closeBrowser();
}

@When("user enters the InValid {string} and {string}")
public void user_enters_the_in_valid_and(String username, String password) {
	lp.setUserName(username);
	  lp.setPassword(password);
		lp.login();
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
        String actualErrorMsg = wait.until(ExpectedConditions.visibilityOf(lp.getErrorMessage())).getText();
        String expectedErrorMsg = wait.until(ExpectedConditions.visibilityOf(lp.getErrorMessage())).getText();

        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
}

@Then("User should be able to view the error message")
public void user_should_be_able_to_view_the_error_message() {
  
}

@Then("User should see an error message {string}")
public void user_should_see_an_error_message(String string) {
  
}

@When("User checks the {string} checkbox")
public void user_checks_the_checkbox(String string) {

}

@When("User clicks on login button")
public void user_clicks_on_login_button() {
 
}

@Then("User should be redirected to the homepage")
public void user_should_be_redirected_to_the_homepage() {

}

@Then("Validate the user is redirected to the correct URL")
public void validate_the_user_is_redirected_to_the_correct_url() {

}

@Then("{string} should be checked on subsequent visits")
public void should_be_checked_on_subsequent_visits(String string) {

}

@When("User clicks on the {string} link")
public void user_clicks_on_the_link(String string) {

}

@Then("User should be redirected to the {string} page")
public void user_should_be_redirected_to_the_page(String string) {

}
			
	}


package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	public WebDriver rdriver;


	public LoginPage(WebDriver ldriver) {
		// TODO Auto-generated constructor stub
		this.rdriver= ldriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name="email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@class='floating__input password']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@class= 'btn bg-green-400']")
	@CacheLookup
	WebElement lgnbtn;
	
	@FindBy(xpath="//span[contains(text(),'400 Moineau Drive')]")
	@CacheLookup
	WebElement selectOne;
	
	@FindBy(xpath="//h1[contains(text(),'Select Home To View')]")
	@CacheLookup
	WebElement selectPage;
	
	//@FindBy(css="span[class='inline-block'] span[class='inline-block ml-0.5']")
	@FindBy(css="i[class='caret-down']")  
	@CacheLookup
	WebElement userName;
	
	
	@FindBy(linkText="Sign Out")   
	@CacheLookup
	WebElement logout;
	
	public void setUserName(String username)
	{
		txtEmail.clear();
		txtEmail.sendKeys(username);
	}
	public void setPassword(String password)
	{
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	
	public void login()
	{
		lgnbtn.click();
	}
	
	public void selectHome()
	{
		String expectedUrl = "https://sprint-drees-customerportal.exitest.com/selecthome";
        String actualUrl = rdriver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)) {
        	WebDriverWait wait = new WebDriverWait(rdriver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        	String selectedHome =selectPage.getText();
    		if(selectedHome=="Select Home To View")
    		{
    		selectOne.click();
            System.out.println("User is redirected to the select Home page URL: " + actualUrl);
    		}
            else 
            {
                System.out.println("User is not redirected to the correct URL. Actual URL: " + actualUrl);
            }
        } 
		else
		{
			System.out.println("USer is directly navigated to Dashboard page");
		}
	}
	
	public void logout() {
		
		String expectedUrl = "https://sprint-drees-customerportal.exitest.com";
		 String actualUrl = rdriver.getCurrentUrl();
		  if (actualUrl.equals(expectedUrl)) {
		 WebDriverWait wait = new WebDriverWait(rdriver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.urlToBe(expectedUrl));
		  }
		  else
		  {
		userName.click();
		logout.click();
		  }
		  }
	
	public void viewErrorMessage()
	{
		  System.out.println("Test print error message");
	}
}


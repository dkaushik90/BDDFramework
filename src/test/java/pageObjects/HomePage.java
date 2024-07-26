package pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {
	public WebDriver driver;


	public HomePage(WebDriver driver) {
		this.driver=driver;
	
		// TODO Auto-generated constructor stub
	}

	public void openHomePage()
	{

       driver.get("https://sprint-drees-customerportal.exitest.com/");

	      System.out.println(driver.getTitle());

	      System.out.println(driver.getCurrentUrl());

}
}
	 

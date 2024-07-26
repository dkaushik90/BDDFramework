package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	private static WebDriver driver;

	private LaunchBrowser() {
		// TODO Auto-generated constructor stub

}
	public static WebDriver getDriver()
	 {
	        //WebDriverManager.chromedriver().setup();
	        //driver = new ChromeDriver();
		//ChromeOptions co = new ChromeOptions();
		//co.setHeadless(true);
		//WebDriver driver = WebDriverManager.chromedriver().capabilities(co).create();
		if(driver==null)
		{
	         driver = WebDriverManager.chromedriver().create();
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	         driver.manage().window().maximize();
	        
	 }
		return driver;
	 }
	public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver=null;   //reset the driver instance
        }

}
}

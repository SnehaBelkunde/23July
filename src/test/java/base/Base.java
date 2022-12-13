package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
//import org.testng.annotations.Test;

public class Base 
	{
		protected WebDriver driver;
		public void launchUpstox()
		{
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://login-v2.upstox.com/");
		driver.manage().window().maximize();
		Reporter.log("Launching browser",true);
		//Utility.wait(driver, 1000);
		}
		public static void closingBrowser(WebDriver driver) throws InterruptedException
		{
		Reporter.log("closing browser", true);
		Thread.sleep(500);
		driver.close();
		}
		}

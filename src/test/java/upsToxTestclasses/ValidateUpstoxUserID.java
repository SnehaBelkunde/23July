package upsToxTestclasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import upsToxPOMclasses.UpStoxFundsPage;
import upsToxPOMclasses.UpStoxHomePage;
import upsToxPOMclasses.UpStoxLoginPage;
import upsToxPOMclasses.UpStoxPasscodePage;
import upsToxPOMclasses.UpStoxWelcomePage;
import utility.Utility;

public class ValidateUpstoxUserID extends Base
{
	UpStoxLoginPage login;
	UpStoxFundsPage funds;
	UpStoxPasscodePage passcode;
	UpStoxWelcomePage welcome;
	UpStoxHomePage home;
	String TCID="TC1234";
	@BeforeClass
	public void launchBrowser(WebDriver driver)
	{
	  launchUpstox();
	  login= new UpStoxLoginPage(driver);
	funds= new UpStoxFundsPage(driver);
	passcode= new UpStoxPasscodePage(driver);
	welcome=new UpStoxWelcomePage(driver);
	home= new UpStoxHomePage(driver);
	}
	@BeforeMethod
	public void loginToUpstox(WebDriver driver) throws EncryptedDocumentException, IOException
	{
	login.enterUserID(Utility.readDataFromExcel(1, 0));
	login.enterPassword(Utility.readDataFromExcel(1, 1));
	login.clickOnSignInButton();
	Reporter.log("Clicking on sign in button", true);
	Utility.wait(driver, 1000);
	passcode.enterPassCode(Utility.readDataFromExcel(1, 2));
	Utility.wait(driver, 5000);
	welcome.clickOnnoIAmGoodButton();
	Reporter.log("Clicking on I am good button", true);
	Utility.wait(driver, 5000);
	}
	@Test
	public void validateUserID(WebDriver driver) throws EncryptedDocumentException, IOException
	{
	Assert.assertEquals(home.getActualUserID(driver),
	Utility.readDataFromExcel(1, 3),"TC failed actual and expected useriD not Matching");
	Reporter.log("validating user ID", true);
	Utility.takeSceenshot(driver, TCID);
	}
	
	
	
	
	
	@AfterMethod
	public void logOutFromUpstox(WebDriver driver) throws InterruptedException
	{
	Utility.wait(driver, 500);
	home.logoutFromApplication();
	}
	@AfterClass
	public void closeBrowser(WebDriver driver) throws InterruptedException
	{
	 Utility.wait(driver, 500);
	 Reporter.log("closing browser", true);
	
     driver.close();
	//closingBrowser(driver);
	}
	}

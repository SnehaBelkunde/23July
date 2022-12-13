package upsToxPOMclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.Test;

public class UpStoxHomePage
{
	@FindBy(xpath = "(//span[@class='_3YI_lRyLDAFhz2WE-6yGuX'])[2]") private
	WebElement userID;
	@FindBy(id = "funds") private WebElement fundsButton;
	@FindBy(xpath = "//div[text()='Logout']") private WebElement logoutButton;
	public UpStoxHomePage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	public void validateUserID (WebDriver driver,String expUN) throwsInterruptedException, IOException
	{
	Thread.sleep(1000);
	Scrolling.scrollIntoView(driver, userID);
	String actualUserID = userID.getText();
	String expectedUserID=expUN;
	Screenshot1.takeScreenshot(driver, "actualUserID "+actualUserID);
	if(actualUserID.equalsIgnoreCase(expectedUserID))
	{
	System.out.println("Actual and Expected UserID are Matching, TC is Passed");
	}
	else
	{
	System.out.println("Actual and Expected UserID are not Matching, TC is Failed");
	}
	}
	public void clickOnFundsButton()
	{
	fundsButton.click();
	}
	public void logoutFromApplication() throws InterruptedException
	{
	userID.click();
	Thread.sleep(400);
	logoutButton.click();
	Reporter.log("logging out from application", true);
	}
	public String getActualUserID(WebDriver driver)
	{
	String actualUserID = userID.getText();
	Utility.scrollIntoView(driver, userID);
	return actualUserID;
	}
}

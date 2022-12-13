package upsToxPOMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.Test;

public class UpStoxLoginPage {
	
		//variable declaration
		@FindBy(name = "userId") private WebElement userID;
		@FindBy(name="password")private WebElement password;
		@FindBy(xpath = "//div[text()='Sign into Upstox']") private WebElement
		signInButton;
		//initialize using constructor-->uses-->pageFactory class-->(method)-->initElements
		public UpStoxLoginPage(WebDriver driver)
		{
		PageFactory.initElements(driver, this);
		}
		//variable Usage using method
		public void enterUserID(String uid)
		{
		userID.sendKeys(uid);
		}
		public void enterPassword(String pwd)
		{
		password.sendKeys(pwd);
		}
		public void clickOnSignInButton()
		{
		signInButton.click();
		}
		
  }


package upsToxPOMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.Test;

public class UpStoxPasscodePage {
	
		//variable declaration
		@FindBy(name = "yob") private WebElement passcodeField;
		//initialize variable
		public UpStoxPasscodePage(WebDriver driver)
		{
		PageFactory.initElements(driver, this);
		}
		//usage
		public void enterPassCode(String pass)
		{
		passcodeField.sendKeys(pass);
		}
		}

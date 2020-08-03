package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import tests.TestBase;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginPage extends BasePage{
	
	@FindBy(name="email")
	public WebElement emailInput;
	
	@FindBy(name="password")
	public WebElement passwordInput;
	
	@FindBy(xpath="//input[@type='Submit']")
	public WebElement submitButton;
	
	
	public void login() {
		LoginPage lp = new LoginPage();
		lp.profileButton.click();
		lp.signInButton.click();
		
		TestBase.deleteBadCookies();
		lp.emailInput.sendKeys(ConfigReader.getProperty("username"));
		lp.passwordInput.sendKeys(ConfigReader.getProperty("password"));
		lp.submitButton.click();
		TestBase.deleteBadCookies();
		
	}

}

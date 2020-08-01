package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginTest extends TestBase{
	
	@BeforeMethod(alwaysRun=true)
	public void setUpMethod2() {
		
		
	}
	
	@Test
	public void loginTest1() {
		logger = reporter.createTest("Login Test 1");
		
		LoginPage lp = new LoginPage();
		lp.login();
		
		
		lp.profileButton.click();
		lp.savedCarsButton.click();
		
		assertEquals(Driver.getDriver().getTitle(), "Saved Cars | MyCarMax");		
	}
	
	
	
}

package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;
import utilities.BrowserUtilities;
import utilities.Driver;


public class LoginTest extends TestBase{
	
	@BeforeMethod(alwaysRun=true)
	public void setUpMethod2() throws IOException {
		
	}

	
	@Test(groups="sprint1")
	public void loginTest1() {
		logger = reporter.createTest("Login Test 1");
		
		logger.info("Logging in..");
		LoginPage lp = new LoginPage();
		lp.login();		
		
		deleteBadCookies();
		lp.profileButton.click();
		lp.savedCarsButton.click();
		
		logger.info("Verifying that successfully logged in");
		assertEquals(Driver.getDriver().getTitle(), "Saved Cars | MyCarMax");		
	}
	
	@Test(groups="sprint3")
	public void logoutTest() {
		
		logger = reporter.createTest("Login Test 1");
		deleteBadCookies();
		logger.info("Logging in..");
		LoginPage lp = new LoginPage();
		lp.login();	
		
		deleteBadCookies();
		lp.profileButton.click();
		lp.logoutButton.click();
		
		BrowserUtilities.waitFor(1);
		
		lp.profileButton.click();
		
		assertTrue(lp.signInButton.isDisplayed());
	}
	
	
	
}

package tests;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.BrowserUtilities;
import utilities.Driver;


public class LoginTest extends TestBase{
	
	@BeforeMethod(alwaysRun=true)
	public void setUpMethod2() throws IOException {
		
	}

	
	@Test
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
	
	
	
}

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

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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
	
	
	//@Test
	public void justCheckingSomething() {
		
		driver = Driver.getDriver();
		driver.navigate().to("https://www.carmax.com/cars?search=toyota+camry");
		deleteBadCookies();
		
		MainPage mp = new MainPage();
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		
		driver.findElement(By.xpath("//div[@class='options--sort']//"
				+ "button[@class='kmx-menu-button kmx-button kmx-button--tertiary']")).click();
		
		driver.findElement(By.xpath("//button[.='Lowest mileage']")).click();
		
		BrowserUtilities.waitFor(5);
	}
	
	
	
}

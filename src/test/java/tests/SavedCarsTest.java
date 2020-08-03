package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;
import pages.SavedCarsPage;
import pages.SearchPage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class SavedCarsTest extends TestBase{
	
	@BeforeMethod
	public void setUpMethod2() {
		LoginPage lp = new LoginPage();
		lp.login();			
	}
	
	@Test
	public void saveCarTest() {
		logger = reporter.createTest("Save Car Test");
		SavedCarsPage scp = new SavedCarsPage();
		
		deleteBadCookies();
		
		logger.info("Logged in at this point and searching for 2017 Honda Accord");
		scp.searchBox.sendKeys("2017 Honda Accord");
		scp.searchButton.click();
		
		MainPage mp = new MainPage();
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		
		SearchPage sp = new SearchPage();
		
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		
		logger.info("Saving the first car in the list");
		js.executeScript("arguments[0].click();", sp.searchedCarsSaveButton.get(0));
		
		BrowserUtilities.waitFor(4);
		actions.moveToElement(sp.searchedCarsSaveButton.get(1)).click(sp.searchedCarsSaveButton.get(1)).build().perform();
		BrowserUtilities.waitFor(4);
		actions.moveToElement(sp.searchedCarsSaveButton.get(2)).click().build().perform();
		
		deleteBadCookies();
		
		scp.profileButton.click();
		scp.savedCarsButton.click();
		
		logger.info("Verifying that car got successfully saved");
		
		
	}
}

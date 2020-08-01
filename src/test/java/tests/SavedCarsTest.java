package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SavedCarsPage;
import pages.SearchPage;

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
		
		logger.info("Logged in at this point and searching for 2017 Honda Accord");
		scp.searchBox.sendKeys("2017 Honda Accord");
		scp.searchButton.click();
		
		logger.info("Saving the first car in the list");
		new SearchPage().searchedCarsSaveButton.get(0).click();
		
		scp.profileButton.click();
		scp.savedCarsButton.click();
		
		logger.info("Verifying that car got successfully saved");
		
		
	}
}

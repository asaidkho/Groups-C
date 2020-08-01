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
		
		scp.searchBox.sendKeys("2017 Toyota Camry");
		scp.searchButton.click();
		
		new SearchPage().searchedCarsSaveButton.get(0).click();
		
		scp.profileButton.click();
		scp.savedCarsButton.click();
		
		
	}
}

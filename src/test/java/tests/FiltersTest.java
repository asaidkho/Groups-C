package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.FilterPage;
import pages.MainPage;
import utilities.BrowserUtilities;

public class FiltersTest extends TestBase {
	
	@Test (dataProvider = "file") // add new data to file
	  public void searchMakeAddNationwide(String make, String model) {
		logger = reporter.createTest("Search by Make");
		MainPage mp = new MainPage();
		
		logger.info("Enter car make"); //BMW X5
		mp.searchBox.sendKeys(make);
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		//assertTrue(mp.searchResults.getText().contains(make));
		//assertTrue(driver.getTitle().contains(make));
		
		logger.info("Expand distance wrapper icon");
		
		FilterPage fp = new FilterPage();
		fp.nationwide.click();
		
		BrowserUtilities.waitFor(2);
		driver.manage().deleteAllCookies();
		assertTrue(fp.nationwide.isEnabled());
		
		logger.info("Select Nationwide button");
		fp.nationwide.click();
		BrowserUtilities.waitFor(2);
		logger.info("Validate that Nation wide filter is applied");
		
	/* dont know how, changes on class name> (kmx-menu-item-button selected)
		assertTrue(driver.getTitle().contains("nationwide"));*/
	
	}
      
	

/*public void searchByColor() {
		logger = reporter.createTest("Expand Features from Filters");
		MainPage mp = new MainPage();
		
		logger.info("Enter car make");
		mp.searchBox.sendKeys("Toyota");
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		driver.manage().deleteAllCookies();
		logger.info("Click and expand Features from filters");
		mp.features.click();
		BrowserUtilities.waitFor(2);
		driver.manage().deleteAllCookies();
		assertTrue(mp.features.isEnabled());
		logger.info("Scroll Down and locate See All button");
		mp.seeAll.click();
		BrowserUtilities.waitFor(2);
		logger.info("Validate");
		assertTrue(driver.getTitle().contains(""));*/
	
	
	
	
	
	/*@Test (dataProvider = "file") // add new data to file
	  public void searchMakeAddNationwide(String make, String model) {
		logger = reporter.createTest("Search by Make");
		MainPage mp = new MainPage();
		
		logger.info("Enter car make"); //BMW X5
		mp.searchBox.sendKeys(make);
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		//assertTrue(mp.searchResults.getText().contains(make));
		//assertTrue(driver.getTitle().contains(make));
		
		logger.info("Expand distance wrapper icon");
		
		FiltersPage fp = new FiltersPage();
		rp.nationwide.click();
		
		BrowserUtilities.waitFor(2);
		driver.manage().deleteAllCookies();
		assertTrue(fp.nationwide.isEnabled());
		
		logger.info("Select Nationwide button");
		rp.nationwide.click();
		BrowserUtilities.waitFor(2);
		logger.info("Validate that Nation wide filter is applied");
		
	/* dont know how, changes on class name> (kmx-menu-item-button selected)
		assertTrue(driver.getTitle().contains("nationwide"));}*/
	


      
	
    
    @Test 
    public void clearFilters(){
     
    
    
    }


}

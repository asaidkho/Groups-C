package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.ShopPage;
import utilities.BrowserUtilities;

public class MPGHighwayTest {

	/* @BeforeMethod
	 * 
	 @Test()
	public void filtersTest() {
		logger = reporter.createTest("Locate MPG Highway from filters");
		ShopPage tp = new TrucksPage();
		tp.MPGHighway.click();
		logger.info("Clicking MPG HIghway filter Button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		assertTrue(tp.localCars.isDisplayed());
		assertTrue(tp.localCars.isEnabled());
		driver.manage().deleteAllCookies();
		tp.MPGHighway.click();
		
		if (shp.locationConformPopUp.isEnabled()) {
			shp.locationConformPopUp.click();
		}
		logger.info("");
		
	}
}
      @Test
      public void MPGHighwayTest(){
       }
      
      
      @Test
      public void addToFilter(){
     
      }
      
      
      
      
       
      
      @Test 
      public void searchMakeNationwide (){
      
      @Test (dataProvider = "file") // add new data to file
	  public void searchMakeNationwide(String make, String model) {
		logger = reporter.createTest("Search by Make");
		MainPage mp = new MainPage();
		
		logger.info("Enter car make"); //BMW X5
		mp.searchBox.sendKeys(make);
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		//assertTrue(mp.searchResults.getText().contains(make));
		assertTrue(driver.getTitle().contains(make));
		
		logger.info("Expand distance wrapper icon");
		ResultPage rp = new ResultPage()
		rp.nationwide.click();
		
		BrowserUtilities.waitFor(2);
		driver.manage().deleteAllCookies();
		assertTrue(rp.nationwide.isEnabled());
		
		logger.info("Select Nationwide button");
		mp.blueColor.click();
		BrowserUtilities.waitFor(2);
		logger.info("Validate that Nation wide filter is applied");
		-- dont know how, changes on class name> (kmx-menu-item-button selected)
		assertTrue(driver.getTitle().contains("nationwide"));
	
	}
        logger.info("Clicking on distance radius dropdown");
		rp.Dropdown.click();
		logger.info("Select the distance radius - Nationwide");
		rp.Nationwide.click();
		assertEquals(mp.distanceRadiusDropdown.getText(), "Nationwide");
	
      
      @Test 
      public void clearFilters(){
       
      
      
      }

*/
	
	
	
	
	
	
	
	
	
	
}

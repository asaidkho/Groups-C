package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.ShopPage;

public class MPGHighwayTest {

	/* @BeforeMethod
	 * 
	 @Test(groups="smoke")
	public void filtersTest() {
		logger = reporter.createTest("Locate MPG Highway from filters");
		ShopPage tp = new TrucksPage();
		tp.MPGHighway.click();
		logger.info("Clicking MPG HIghway filter Button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3200)");
		assertTrue(tp.localCars.isDisplayed());
		assertTrue(tp.localCars.isEnabled());
		driver.manage().deleteAllCookies();
		tp.MPGHighway.click();
		if (shp.locationConformPopUp.isEnabled()) {
			shp.locationConformPopUp.click();
		}
		logger.info("Verifying the expected text");
		assertTrue(driver.findElement(By.id("search-results-header")).getText().contains("Used cars at CarMax Gaithersburg for Sale"));
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
      
      
      
      }
      
      
      
      @Test 
      public void clearFilters(){
      
      
      
      
      
      
      
      }
*
*
*
*
*
*
*
*/
	
	
	
	
	
	
	
	
	
	
}

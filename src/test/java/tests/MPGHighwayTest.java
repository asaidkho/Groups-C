package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



import pages.ShopPage;
import pages.FilterPage;

import utilities.BrowserUtilities;

public class MPGHighwayTest extends TestBase{

	/* @BeforeMethod*/
	
	
	@Test()
	public void MpgHighwaySliderTest() {
		
		
		logger = reporter.createTest("Test MPG Highway filter  button");
		ShopPage shp = new ShopPage();
		logger.info("Clicking on Shop button");
		shp.shopButton.click();
		
		driver.manage().deleteAllCookies();
		logger.info("Clicking on Trucks button");
		shp.trucks.click();
		driver.manage().deleteAllCookies();
		//logger.info("Locate MPG Highway from filters");
		FilterPage fp = new FilterPage();
		
		fp.MPGHighway.click();
		logger.info("Clicking MPG Highway filter Button");

		Actions a = new Actions(driver);
		
		logger.info("Moving slider to right");
		
		a.clickAndHold(fp.sliderHandle).moveByOffset(300, 0).release().build().perform();

		deleteBadCookies();

		    //if (tp.locationConformPopUp.isEnabled()) {
			//tp.locationConformPopUp.click();
		
		assertTrue(driver.findElement(By.xpath("//span[.a='Over 21 MPG']")).getText().contains("Over 21 MPG"));
		
		}

	
	@Test
	public void manualInputToFilter() {
		
		logger = reporter.createTest("SEnd Keys to  Input for MPG Highway Filter");
		ShopPage shp = new ShopPage();
		logger.info("Clicking on Shop button");
		shp.shopButton.click();
		
		driver.manage().deleteAllCookies();
		logger.info("Clicking on Trucks button");
		shp.trucks.click();
		driver.manage().deleteAllCookies();
		//logger.info("Locate MPG Highway from filters");
		FilterPage fp = new FilterPage();
		
		logger.info("Clicking MPG Highway filter Button");
		fp.MPGHighway.click();
		logger.info("Send keys to input box");
		fp.inputBox.sendKeys("21");
		
		
		
		
		
	}
	


      
      
	
}
	
	
	
	
	
	
	
	
	


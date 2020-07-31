package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ShopPage;
import utilities.Driver;

public class ShopTest extends TestBase{

	
	@BeforeMethod(alwaysRun = true)
	public void setUpMethodShopPage() {
		ShopPage shp = new ShopPage();
		shp.shopButton.click();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void clickTrucksButton() {
		logger = reporter.createTest("Verify shop by type : Trucks button");
		ShopPage shp = new ShopPage();
		shp.shopButton.click();
		logger.info("Clicking on Trucks button");
		shp.trucks.click();
		logger.info("Verifying the expected text");
		assertEquals(
				driver.findElement(By.xpath("//*[@class='refinement-pill--text kmx-typography--body-1']")).getText(),
				"Pickup Trucks");

	}
 ///change
	@Test
	public void clickToyotaButton() {
		logger = reporter.createTest("Verify shop by brand : Toyota button");
		ShopPage shp = new ShopPage();
		shp.shopButton.click();
		logger.info("Clicking on Toyota button");
		shp.toyota.click();
		logger.info("Verifying the expected text");
	  assertEquals(driver.getTitle(), "Used Toyota for Sale");

	}

	@Test
	public void clickSeeAllButton() {
		logger = reporter.createTest("Verify Shop by Price: Under $10,00button");
		ShopPage shp = new ShopPage();
		shp.shopButton.click();
		
		logger.info("Clicking on See All button");
		shp.byPrice.click();
		logger.info("Verifying the expected text");
		assertEquals(
				driver.findElement(By.className("refinement-pill--text kmx-typography--body-1")).getText(),
				"Under $10,000");
    
	}

	@Test
	public void commuterButton() {
		logger = reporter.createTest("Verify Shop by Lifestyle : Commuter button");
		ShopPage shp = new ShopPage();
		shp.shopButton.click();
		
		logger.info("Clicking on Commuter");
		shp.commuter.click();
		logger.info("Verifying the expected URL");
		assertTrue(Driver.getDriver().getCurrentUrl().equals("https://www.carmax.com/cars/coupes/hybrids/sedans/bluetooth?mpghighway=30"));
	
	}

	@Test
	public void localCarsButton() {
		logger = reporter.createTest("Verify See All button");
		ShopPage shp = new ShopPage();
		shp.shopButton.click();
		
		logger.info("Clicking Local Cars Button");
		shp.localCars.click();
		logger.info("Verifying the expected text");
		assertEquals(
				driver.findElement(By.id("search-results-header")).getText(),
				"Used cars at CarMax Gaithersburg for Sale");

		
		
	}
}


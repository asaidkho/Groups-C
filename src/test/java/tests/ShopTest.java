package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ShopPage;
import utilities.Driver;

public class ShopTest extends TestBase {

	/*
	 * /@BeforeMethod(alwaysRun = true) public void setUpMethodShopPage() { ShopPage
	 * shp = new ShopPage(); shp.shopButton.click();
	 * driver.manage().deleteAllCookies();// }
	 */

	@Test
	public void shopButton() {
		logger = reporter.createTest("Test shop button");
		ShopPage shp = new ShopPage();
		logger.info("Clicking on Shop button");
		shp.shopButton.click();
		assertEquals(driver.getTitle(), "Used Cars for Sale - CarMax");
	}

	@Test(groups="smoke")
	public void clickTrucksButton() {
		logger = reporter.createTest("Verify shop by type : Trucks button");
		ShopPage shp = new ShopPage();
		shp.shopButton.click();
		driver.manage().deleteAllCookies();
		logger.info("Clicking on Trucks button");
		shp.trucks.click();
		driver.manage().deleteAllCookies();
		logger.info("Verifying the expected text");
		assertTrue(driver.getTitle().contains("Trucks"));
	}
	@Test
	public void clickToyotaButton() {
		logger = reporter.createTest("Verify shop by brand : Toyota button");
		ShopPage shp = new ShopPage();
		shp.shopButton.click();
		driver.manage().deleteAllCookies();
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
		driver.manage().deleteAllCookies();
		logger.info("Clicking on See All button");
		shp.byPrice.click();
		driver.manage().deleteAllCookies();
		if (shp.locationConformPopUp.isEnabled()) {
			shp.locationConformPopUp.click();
		}
		logger.info("Verifying the expected text");
		assertTrue(driver.findElement(By.cssSelector("#title > h1")).getText().contains("Under $10,000"));
	}
	@Test(groups="smoke")
	public void commuterButton() {
		logger = reporter.createTest("Verify Shop by Lifestyle : Commuter button");
		ShopPage shp = new ShopPage();
		shp.shopButton.click();
		driver.manage().deleteAllCookies();
		logger.info("Clicking on Commuter");
		shp.commuter.click();
		logger.info("Verifying the expected URL");
		assertTrue(Driver.getDriver().getCurrentUrl().equals("https://www.carmax.com/cars/coupes/hybrids/sedans/bluetooth?mpghighway=30"));
	}
	@Test(groups="smoke")
	public void localCarsButton() {
		logger = reporter.createTest("Verify See All button");
		ShopPage shp = new ShopPage();
		shp.shopButton.click();
		logger.info("Clicking Local Cars Button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3200)");
		assertTrue(shp.localCars.isDisplayed());
		assertTrue(shp.localCars.isEnabled());
		driver.manage().deleteAllCookies();
		shp.localCars.click();
		if (shp.locationConformPopUp.isEnabled()) {
			shp.locationConformPopUp.click();
		}
		logger.info("Verifying the expected text");
		assertTrue(driver.findElement(By.id("search-results-header")).getText().contains("Used cars at CarMax Gaithersburg for Sale"));
	}
}

package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ShopPage;
import utilities.Driver;

public class ShopTest extends TestBase{

	
	
	
	/* @BeforeMethod(alwaysRun = true)
	public void setUpMethodShopPage() {
		ShopPage shp = new ShopPage();
		shp.shopButton.click();
		Driver.getDriver().manage().deleteAllCookies();*/
	//}
	
	
	/*@Test
	public void shopButton() {
		logger = reporter.createTest("Test shop button");
		ShopPage shp = new ShopPage();
		logger.info("Clicking on Shop button");
		shp.shopButton.click();
		assertEquals(driver.getTitle(), "Used Cars for Sale - CarMax");
	}*/

	@Test
	public void clickTrucksButton() {
		logger = reporter.createTest("Verify shop by type : Trucks button");
		ShopPage shp = new ShopPage();
       logger.info("Clicking on Trucks button");
		shp.trucks.click();
		// String expected = "Used Pickup Trucks for Sale.";
		// String actual = shp.trucks.getText();
		logger.info("Verifying the expected text");
		assertEquals(driver.findElement(By.xpath("//*[@id=\"title\"]/h1")).getText(), "Used Pickup Trucks for Sale.");
		// assertEquals(actual, expected);

	}
	
	@Test
	public void verifyToyotaButton() {
		
		
	}
	
	
	@Test
	public void seeAllButton() {
		
		
	}
	
	
	@Test
	public void commuterButton() {
		
		
	}
	
	
	@Test
	public void localCarsButton() {
		
		
	}
}



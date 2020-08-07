package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



import pages.ShopPage;
import pages.FilterPage;

import utilities.BrowserUtilities;
import utilities.Driver;

public class MPGHighwayTest extends TestBase{

	/* @BeforeMethod*/
	
	//Sprint 2;
	
	//@Test()
	@Test (enabled = true) 
	public void SliderTest() {
		logger = reporter.createTest("Test MPG Highway filter  button");
		ShopPage shp = new ShopPage();
		logger.info("Clicking on Shop button");
		shp.shopButton.click();
		//driver.manage().deleteAllCookies();
		deleteBadCookies();
		logger.info("Clicking on Trucks button");
		shp.trucks.click();
		FilterPage fp = new FilterPage();
		if (fp.locationConformPopUp.isEnabled()) {
			fp.locationConformPopUp.click();
		}
		//driver.manage().deleteAllCookies();
		deleteBadCookies();
		logger.info("Locate MPG Highway from filters");
		fp.MPGHighway.click();
		logger.info("Clicking MPG Highway filter Button");
		Actions a = new Actions(driver);
		logger.info("Moving slider to right");
		deleteBadCookies();
		/*a.clickAndHold(fp.sliderHandle).perform();
		a.moveByOffset(100, 0).perform();
		//BrowserUtilities.waitFor(3);
		a.release().perform();*/
		a.clickAndHold(fp.sliderHandle).moveByOffset(110, 0).release().build().perform();
		BrowserUtilities.waitFor(3);
		assertEquals(driver.findElement(By.xpath("//*[@class='selected-refinements']//button[2]")).getText(), "Over 31 MPG");
		//assertEquals(driver.findElement(By.xpath("//*[@class='refinement-pills']//button[2]//span")).getText(), "Over 30 MPG");
		driver.manage().deleteAllCookies();
	}
	@Test (enabled = false) 
	public void manualInputToFilter() {
		logger = reporter.createTest("Send Keys to  Input for MPG Highway Filter");
		ShopPage shp = new ShopPage();
		logger.info("Clicking on Shop button");
		shp.shopButton.click();
		driver.manage().deleteAllCookies();
		logger.info("Clicking on Trucks button");
		shp.trucks.click();
		driver.manage().deleteAllCookies();
		//logger.info("Locate MPG Highway from filters");
		FilterPage fp = new FilterPage();
		if (fp.locationConformPopUp.isEnabled()) {
			fp.locationConformPopUp.click();
		}
		//driver.manage().deleteAllCookies();
		deleteBadCookies();
		logger.info("Clicking MPG Highway filter Button");
		fp.MPGHighway.click();
		logger.info("Send keys to input box");
		fp.inputBox.click();
		fp.inputBox.sendKeys("21");
		fp.inputBox.sendKeys(Keys.ENTER);
		logger.info("Verify");
		assertTrue(driver.findElement(By.xpath("//*[@class='sidebar--header']//button[2]")).getText().contains("Over 21 MPG"));
	}
	@Test //(enabled = false)
      public void addFeaturesToFilter() {
		
		driver = Driver.getDriver();
		logger = reporter.createTest("Add features to Filter");
		ShopPage shp = new ShopPage();
		logger.info("Clicking on Shop button");
		shp.shopButton.click();
		//driver.manage().deleteAllCookies();
		deleteBadCookies();
		logger.info("Clicking on Trucks button");
		shp.trucks.click();
		if (shp.locationConformPopUp.isEnabled()) {
			shp.locationConformPopUp.click();
		}
		deleteBadCookies();
		//driver.manage().deleteAllCookies();
		//logger.info("Locate MPG Highway from filters");
		FilterPage fp = new FilterPage();
		logger.info("Locate and Expand  Features ");
		fp.features.click();
		Actions a = new Actions(driver);
		logger.info("Expand features");
		//a.moveToElement(fp.seeAll).build().perform();
		BrowserUtilities.waitFor(2);
		a.moveToElement(fp.seeAll).click().perform();
		logger.info("");
		// how to verify
		logger.info("Verify");
		
		
		
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='Features']/div[3]/ul/li[60]")));
		BrowserUtilities.waitFor(7);
		String temp = "000";
		for(WebElement feature: fp.allFeatures) {
			System.out.println(feature.getText().toLowerCase());
			assertTrue(feature.getText().toLowerCase().compareTo(temp)>=0);
			temp = feature.getText().toLowerCase();
		}
//		
//		String[] val = new String[50];
//		for(int i=1; i<val.length; i++) {	
//			val[i]=driver.findElement(By.xpath("//*[@id=\"Features\"]/div[3]/ul/li["+i+"]//span")).getText();
//			System.out.println(val[i]);
//		}
//		char[] c = new char[val.length];
//		for (int i=0; i<val.length;i++) {
//			c[i] = val[i].charAt(0);
//		}
		//a.moveToElement(driver.findElement(By.id("Features"))).perform();
		//BrowserUtilities.waitFor(2);
		//a.moveByOffset(0, 100).perform();
		//for (int i = 0; i<500; i++) {
			//a.keyDown(Keys.ARROW_DOWN).perform();
		}
		//BrowserUtilities.waitFor(3);
		//a.release();
		//a.keyUp(Keys.ARROW_DOWN).perform();
		/*
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='Features']/div[3]/ul/li[60]")));
		BrowserUtilities.waitFor(4);
		*/
		//js.executeScript("document.", driver.findElement(By.id("Features")));
		/*
		List<String> features = new ArrayList<>();
		//get the list of all features
		for(int i=3; i<10; i++) {	
			features.add(driver.findElement(By.xpath("//*[@id='Features']/div[3]/ul/li["+i+"]")).getText());
			System.out.println(features.get(i));
		}
		*/
	
	@Test (enabled = false) 
	public void moreButton() {
		logger = reporter.createTest("Hover Over More button");
		FilterPage fp = new FilterPage();
		Actions a = new Actions(driver);
		logger.info("Hover over More button , Find expanded window and Click Why Car Max?");
		a.moveToElement(fp.moreButton).perform();
		BrowserUtilities.waitFor(4);
		a.moveToElement(fp.WhyCarMax).click().build().perform();
		logger.info("Verifying the expected page");
		assertEquals(driver.getTitle(), "Why you should buy a used car from CarMax");
	}
}
	
	
	
	
	
	
	


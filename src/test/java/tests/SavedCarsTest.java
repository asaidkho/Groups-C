package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;
import pages.SavedCarsPage;
import pages.SearchPage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class SavedCarsTest extends TestBase{
	
	@BeforeMethod(alwaysRun=true)
	public void setUpMethod2() {
		LoginPage lp = new LoginPage();
		lp.login();			
	}
	
	@Test(groups = "sprint1")
	public void saveCarTest() {
		logger = reporter.createTest("Save Car Test");
		SavedCarsPage scp = new SavedCarsPage();
		
		deleteBadCookies();
		
		logger.info("Logged in at this point and searching for 2017 Honda Accord");
		scp.searchBox.sendKeys("2017 Honda Accord");
		scp.searchButton.click();
		
		MainPage mp = new MainPage();
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		
		SearchPage sp = new SearchPage();
		deleteBadCookies();
		
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		
		logger.info("Saving the first car in the list");
		if(!sp.searchedCarsSaveButton.get(0).getAttribute("class").contains("saved")) {
			js.executeScript("arguments[0].click();", sp.searchedCarsSaveButton.get(0));
			BrowserUtilities.waitFor(4);
		}
		
		if(!sp.searchedCarsSaveButton.get(1).getAttribute("class").contains("saved")) {		
			actions.moveToElement(sp.searchedCarsSaveButton.get(1)).click().build().perform();
			BrowserUtilities.waitFor(4);
		}
		
		deleteBadCookies();
		
		scp.profileButton.click();
		scp.savedCarsButton.click();
		
		logger.info("Verifying that car got successfully saved");		
		
	}
	
	@Test(groups = "sprint2")
	public void savedCarDeleteTest() {
		logger = reporter.createTest("Testing Delete feature of Saved Cars");
		
		deleteBadCookies();
		
		SavedCarsPage scp = new SavedCarsPage();
		
		logger.info("Navigating to the Saved Cars Page");
		scp.profileButton.click();
		scp.savedCarsButton.click();
		
		String firstCarTitleText = scp.carTitles.get(0).getText();
		int count = 0;
		for(WebElement carTitle: scp.carTitles) {			
			if (carTitle.getText().equals(firstCarTitleText)) {
				count++;
			}
		}
		
		deleteBadCookies();
		logger.info("Deleting the top Saved Car");
		scp.deleteCarButtons.get(0).click();
		
		logger.info("Verifying that the car got deleted");
		BrowserUtilities.waitFor(4);
		deleteBadCookies();
		int postCount = 0;
		for(WebElement carTitle: scp.carTitles) {			
			if (carTitle.getText().equals(firstCarTitleText)) {
				postCount++;
			}
		}
		
		assertEquals(count, postCount+1);	
		
	}
	
	@Test(groups="sprint2")
	public void sortByPriceTest() {
		
		logger = reporter.createTest("Testing Sort by Price in Asceding");
		
		deleteBadCookies();
		
		SavedCarsPage scp = new SavedCarsPage();
		logger.info("Navigating to the Saved Cars Page by clicking on right Menu link");
		
		scp.profileButton.click();
		scp.savedCarsButton.click();
		
		
		deleteBadCookies();
		
		logger.info("Clicking on sort by price button");
		scp.sortButton.click();
		scp.sortPriceAsc.click();
		
		logger.info("Testing if we have the right result");
		BrowserUtilities.waitFor(5);
		int p = 0;
		for(WebElement price: scp.prices) {
			
			int carPrice = Integer.parseInt(price.getText().replaceAll("\\D", ""));
			logger.info("Testing for " + carPrice);
			assertTrue(p<=carPrice);
			p = carPrice;
		}
	}
	
	@Test(groups = "sprint3")
	public void sortDropdownOffTest() {
		
		logger = reporter.createTest("Test on/off drop down by Sort Button");
		
		deleteBadCookies();
		
		SavedCarsPage scp = new SavedCarsPage();
		logger.info("Navigating to the Saved Cars Page by clicking on right Menu link");
		
		scp.profileButton.click();
		scp.savedCarsButton.click();
		
		BrowserUtilities.waitFor(1);
		deleteBadCookies();
		
		scp.sortButton.click();
		BrowserUtilities.waitFor(1);
		
		assertTrue(scp.sortPriceAsc.isDisplayed());
		
		scp.sortButton.click();
		BrowserUtilities.waitFor(1);
		
		assertTrue(!scp.sortPriceAsc.isDisplayed());
		
	}
}

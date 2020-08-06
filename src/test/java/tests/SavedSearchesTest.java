package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;
import pages.SavedCarsPage;
import pages.SavedSearchesPage;
import pages.SearchPage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class SavedSearchesTest extends TestBase{
	
	@BeforeMethod
	public void setUpMethod2() {
		LoginPage lp = new LoginPage();
		lp.login();			
	}
	
	@Test
	public void saveSearchTest() {
		logger = reporter.createTest("Save Car Test");
		SavedSearchesPage ssp = new SavedSearchesPage();
		
		deleteBadCookies();
		
		logger.info("Logged in at this point and searching for 2017 Honda Accord");
		ssp.searchBox.sendKeys("2017 Honda Accord");
		ssp.searchButton.click();
		
		MainPage mp = new MainPage();
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		
		SearchPage sp = new SearchPage();
		deleteBadCookies();
		BrowserUtilities.waitFor(3);
		sp.saveSearchLink.click();
		BrowserUtilities.waitForVisibility(sp.saveSearchInputBox, 5);
		sp.saveSearchInputBox.sendKeys("Accord" + Keys.ENTER);
		
		ssp.profileButton.click();
		ssp.savedSearchesButton.click();
		
		deleteBadCookies();
		
		logger.info("Verifying that search got successfully saved");
		
		assertTrue(ssp.savedSearchTitles.get(0).getText().equals("Accord"));		
		
	}
	
	@Test
	public void savedSeachDeleteTest() {
		logger = reporter.createTest("Testing Delete feature of Saved Search");
		
		deleteBadCookies();
		
		SavedSearchesPage ssp = new SavedSearchesPage();
		
		ssp.profileButton.click();
		ssp.savedSearchesButton.click();
		
		String firstCarTitleText = ssp.savedSearchTitles.get(0).getText();
		int count = 0;
		for(WebElement carTitle: ssp.savedSearchTitles) {			
			if (carTitle.getText().equals(firstCarTitleText)) {
				count++;
			}
		}
		
		deleteBadCookies();
		
		ssp.deleteSearchButtons.get(0).click();
		
		BrowserUtilities.waitFor(4);
		deleteBadCookies();
		int postCount = 0;
		for(WebElement carTitle: ssp.savedSearchTitles) {			
			if (carTitle.getText().equals(firstCarTitleText)) {
				postCount++;
			}
		}
		
		assertEquals(count, postCount+1);	
		
	}
	
	
}

package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;
import pages.SavedSearchesPage;
import pages.SearchPage;
import utilities.BrowserUtilities;

public class SavedSearchesTest extends TestBase{
	
	@BeforeMethod(alwaysRun=true)
	public void setUpMethod2() {
		LoginPage lp = new LoginPage();
		lp.login();	
		deleteBadCookies();
	}
	
	@Test(groups={"smoke2", "sprint2"})
	public void saveSearchTest() {
		logger = reporter.createTest("Save Search Test");
		SavedSearchesPage ssp = new SavedSearchesPage();
		
		deleteBadCookies();
		
		logger.info("Logged in at this point and searching for 2018 Ford Fusion");
		ssp.searchBox.sendKeys("2018 Ford Fusion");
		ssp.searchButton.click();
		
		MainPage mp = new MainPage();
		if (mp.locationConformPopUp.isEnabled()) {
			logger.info("Dealing with a pop-up window");
			mp.locationConformPopUp.click();
		}
		
		SearchPage sp = new SearchPage();
		deleteBadCookies();
		BrowserUtilities.waitFor(3);
		logger.info("Clicking on Save Search button/link");
		sp.saveSearchLink.click();
		BrowserUtilities.waitForVisibility(sp.saveSearchInputBox, 5);
		logger.info("Entering the name of the search we are saving");
		sp.saveSearchInputBox.sendKeys("Fusion" + Keys.ENTER);
		
		logger.info("Going to the Saved Searches page by clicking the menu on right side");
		ssp.profileButton.click();
		ssp.savedSearchesButton.click();
		
		deleteBadCookies();
		
		logger.info("Verifying that search got successfully saved");
		
		assertTrue(ssp.savedSearchTitles.get(0).getText().equals("Fusion"));		
		
	}
	
	@Test(groups = "sprint2")
	public void savedSeachDeleteTest() {
		logger = reporter.createTest("Testing Delete feature of Saved Search");
		
		deleteBadCookies();
		
		SavedSearchesPage ssp = new SavedSearchesPage();
		
		logger.info("Going to the Saved Searches page through right menu links");
		ssp.profileButton.click();
		ssp.savedSearchesButton.click();
		
		logger.info("Finding out how many of the same titles as the first one page contains");
		String firstCarTitleText = ssp.savedSearchTitles.get(0).getText();
		int count = 0;
		for(WebElement carTitle: ssp.savedSearchTitles) {			
			if (carTitle.getText().equals(firstCarTitleText)) {
				count++;
			}
		}
		
		deleteBadCookies();
		
		logger.info("Deleting the top title");
		ssp.deleteSearchButtons.get(0).click();
		
		BrowserUtilities.waitFor(4);
		deleteBadCookies();
		
		logger.info("Verifying if the title got deleted");
		int postCount = 0;
		for(WebElement carTitle: ssp.savedSearchTitles) {			
			if (carTitle.getText().equals(firstCarTitleText)) {
				postCount++;
			}
		}
		
		assertEquals(count, postCount+1);	
		
	}
	
	@Test(groups = "sprint3")
	public void getUpdatesTest() {
		
		logger = reporter.createTest("Test Email Alerts Update on Saved Searches");
		
		SavedSearchesPage ssp = new SavedSearchesPage();
		
		logger.info("Going to the Saved Searches page through right menu links");
		ssp.profileButton.click();
		ssp.savedSearchesButton.click();
		
		deleteBadCookies();
		ssp.getUpdatesLink.get(0).click();
		BrowserUtilities.waitFor(1);
		
		int randInt = (int)(Math.random()*3);
		
		List<WebElement> radioButtons = Arrays.asList(ssp.radio0, ssp.radio1, ssp.radio2);
		deleteBadCookies();
		radioButtons.get(randInt).click();
		ssp.alertUpdateButton.click();
		
		deleteBadCookies();
		BrowserUtilities.waitFor(2);
		System.out.println(ssp.alertOption.getText());
		switch(randInt) {
		case 0: assertTrue(ssp.alertOption.getText().contains("Email alerts are off")); break;
		case 1: assertTrue(ssp.alertOption.getText().contains("Daily summary")); break;
		case 2: assertTrue(ssp.alertOption.getText().contains("Instant alert")); break;
		
		}
		
	}
	
	
	
	
	
}

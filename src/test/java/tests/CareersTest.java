package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.CareersPage;
import utilities.BrowserUtilities;

public class CareersTest extends TestBase {
	
	@Test
	public void searchForJob() {
		logger = reporter.createTest("Search for a job on Careers carmax.com");
		CareersPage cp = new CareersPage();
		
		logger.info("Locate an click 'Search Jobs' link under Careers");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
		BrowserUtilities.waitFor(3);
		cp.searchJobsLink.click();
		deleteBadCookies();
		
		logger.info("Enter job to search and location and click 'Search' button");
		cp.jobFilterTextField.sendKeys("QA Engeener");
		cp.locationEntryField.sendKeys("20850");
		cp.searchJobButton.click();
		
		logger.info("Validate");
		assertEquals(cp.showingResultsForjobTitle.getText(), "QA Engeener");
	}
}

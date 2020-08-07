package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pages.FinancePage;
import utilities.BrowserUtilities;

public class FinanceTest extends TestBase{
	
	@Test
	public void carPaymentCalculator() {
		logger = reporter.createTest("Car");
		FinancePage fp = new FinancePage();
		
		logger.info("Navigate to Finance");
		fp.financeLink.click();
		deleteBadCookies();
		logger.info("Car Payment Calculator");
		fp.carPaymentCalculatorLink.click();
		//assertTrue(driver.getTitle().contains("Car Payment Calculator"));
		deleteBadCookies();
		logger.info("Fill out the form");
		Actions action = new Actions(driver);
		action.doubleClick(fp.vehicleBudgetTextField).perform();
		BrowserUtilities.waitFor(2);
		fp.vehicleBudgetTextField.sendKeys("30000");
		action.doubleClick(fp.downPaymentTextField).perform();
		BrowserUtilities.waitFor(2);
		fp.downPaymentTextField.sendKeys("5000");
		Select value = new Select(fp.stateDropDown);
		value.selectByVisibleText("Maryland");
		new Select(fp.creditRatingDropDown).selectByVisibleText("Good (670-739 FICO® Score)");
		new Select(fp.termLengthDropDown).selectByVisibleText("60 months");
		logger.info("Check the calculations");
		BrowserUtilities.waitFor(5);
		assertEquals(driver.findElement(By.xpath("//*[@class='kmx-typography--display-6 text-centered m-t-0 m-b-2xl monthly-payment']//span")).getText(), "539");
		
		logger.info("Clicking Shop Cars in Your Budget button");
		fp.shopCarsInYourBudgetButton.click();
		
		assertTrue(fp.searchResultsHeader.getText().contains("30,000"));
	}
	
}

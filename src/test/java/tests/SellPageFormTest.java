package tests;

import static org.testng.Assert.assertTrue;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.SellPage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class SellPageFormTest extends TestBase {
	
	@BeforeMethod(alwaysRun = true)
	public void setUpMethodSellPage() {
		SellPage sp = new SellPage();
		sp.sellLink.click();
		deleteBadCookies();
	}
	
	@Test(dataProvider="years", groups= {"sprint3"})
	public void sellMyCarEnterYearTest(String year) {
		logger = reporter.createTest("Test Sell my Car Form");
		
		SellPage sp = new SellPage();
		
		sp.yearInput.sendKeys(year);
		
		int y;
		boolean yearInRange = false;
		try {
			y = Integer.parseInt(year);
			yearInRange = (y<2022 && y>1989);
		} catch (NumberFormatException e) {}		
		
		if (yearInRange) {
			BrowserUtilities.waitForClickablility(sp.selectMake, 4);
			assertTrue(sp.selectMake.isEnabled());	
		} else {
			BrowserUtilities.waitForClickablility(sp.textBoxMake, 4);
			assertTrue(sp.textBoxMake.isEnabled());	
		}			
	}
	
	@Test(groups = "sprint3")
	public void selectModelAppearenceTest() {
		logger = reporter.createTest("Test Appearance of Models select form");
		
		SellPage sp = new SellPage();
		assertTrue(!sp.selectModel.isEnabled());
		sp.yearInput.sendKeys("2015");
		BrowserUtilities.waitForClickablility(sp.selectMake, 4);
		Select sel = new Select(sp.selectMake);
		sel.selectByVisibleText("TOYOTA");
		BrowserUtilities.waitForClickablility(sp.selectModel, 4);
		assertTrue(sp.selectModel.isEnabled());
		
	}
	
	
	
	
	@Test(dataProvider = "personal-info-positive", groups={"smoke", "sprint1"})
	public void appointmentForm1PositiveTest(String fname, String lname, String phone_number, String email) {
		
		logger = reporter.createTest("Positive Schedule Appointment Test");
		
		SellPage sp = new SellPage();
		logger.info("Filling up the form with the data by DataProvider");
		sp.fillApptFormPersonal(fname, lname, phone_number, email);
		logger.info("Validating that Next button gets activated");
		assertTrue(sp.apptPersonalNext.isEnabled());
		
		BrowserUtilities.waitFor(2);
	}
	
	@Test(dataProvider = "personal-info-negative", groups= {"sprint1"})
	public void appointmentForm1NegativeTest(String fname, String lname, String phone_number, String email) {
		
		logger = reporter.createTest("Negative Schedule Appointment Test");
		
		SellPage sp = new SellPage();
		logger.info("Filling up the form with the data by DataProvider");
		sp.fillApptFormPersonal(fname, lname, phone_number, email);
		logger.info("Validating that Next button is not going to get activated");
		assertTrue(!sp.apptPersonalNext.isEnabled());
		
		BrowserUtilities.waitFor(2);	
	}
	
	@Test(groups={"smoke", "sprint1"})
	public void whatToBringTest() {
		logger = reporter.createTest("What To Bring Form Test");
		SellPage sp = new SellPage();
		logger.info("Selecting a state");
		Select sel = new Select(sp.selectState);
		sel.selectByVisibleText("Alabama");
		
		logger.info("selecting radio buttons");
		sp.radioMakingPaymentsNo.click();
		sp.radioMultipleTitleOwnersNo.click();
		sp.radioTitleOwnersCanComeNo.click();
		logger.info("Submitting the form");
		sp.buttonWhatToBring.click();
		logger.info("Validating that popup window with info shows up");
		assertTrue(sp.popupWhatBringText.isDisplayed());
	}
	
	@Test(groups={"smoke", "sprint1"})
	public void faqCollapseTest() {
		
		logger = reporter.createTest("Testing FAQ Collapse feature");
		SellPage sp = new SellPage();
		
		SoftAssert sa = new SoftAssert();
		
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();		
		js.executeScript("window.scrollBy(0, 4500)");
		
		logger.info("Verifying that all collapse faq answers show up and hide back");
		for(int i = 0; i<sp.faqs.size(); i++) {
			sp.faqs.get(i).click();
			BrowserUtilities.waitForVisibility(sp.faqs_text.get(i), 5);
			sa.assertTrue(sp.faqs_text.get(i).isDisplayed());
			sp.faqs.get(i).click();
			BrowserUtilities.waitForInvisibility(sp.faqs_text.get(i), 5);
			sa.assertTrue(!sp.faqs_text.get(i).isDisplayed());
		}
		
		logger.info("Doing assert all for soft assertion");
		sa.assertAll();
		
	}
	
	@DataProvider(name="years")
	public String[][] provideYears() {
		return new String[][] {
			{"1995"},
			{"2020"},
			{"2030"},
			{"ABC"},
			{"234"}
			
		};
	}
	
	@DataProvider(name="personal-info-positive")
	public String[][] providePersonalInfoPositive() {
		return new String[][]{ 
			{"Evangelin", "Arndt", "7783644351", "earndt0@upenn.edu"},
			{"Mara", "Daltrey", "7052168429", "mdaltrey1@topsy.com"},
			//{"Skippy", "Beloe", "2345026772", "sbeloe2@zimbio.com"},
			//{"June", "Enterlein", "1551808338", "jenterlein3@slashdot.org"},
		};
		
	}
	
	@DataProvider(name="personal-info-negative")
	public String[][] providePersonalInfoNegative() {
		return new String[][]{ 
			{"", "Arndt", "7783644351", "earndt0@upenn.edu"},
			{"Mara", "", "7052168429", "mdaltrey1@topsy.com"},
			//{"Skippy", "Beloe", "234502633", "sbeloe2@zimbio.com"},
			//{"June", "Enterlein", "1551808338", "jenterlein3@slashdot"},
		};
		
	}
	

}

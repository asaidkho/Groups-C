package tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.SellPage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class SellPageFormTest extends TestBase {
	
	@BeforeMethod(alwaysRun = true)
	public void setUpMethodSellPage() {
		SellPage sp = new SellPage();
		sp.sellLink.click();
		Driver.getDriver().manage().deleteAllCookies();
	}
	
	
	
	//@Test(dataProvider = "personal-info-positive")
	public void appointmentForm1PositiveTest(String fname, String lname, String phone_number, String email) {
		
		logger = reporter.createTest("Positive Schedule Appointment Test");
		
		SellPage sp = new SellPage();
		sp.fillApptFormPersonal(fname, lname, phone_number, email);
		
		assertTrue(sp.apptPersonalNext.isEnabled());
		
		BrowserUtilities.waitFor(2);
	}
	
	//@Test(dataProvider = "personal-info-negative")
	public void appointmentForm1NegativeTest(String fname, String lname, String phone_number, String email) {
		
		logger = reporter.createTest("Negative Schedule Appointment Test");
		
		SellPage sp = new SellPage();
		sp.fillApptFormPersonal(fname, lname, phone_number, email);
		
		assertTrue(!sp.apptPersonalNext.isEnabled());
		
		BrowserUtilities.waitFor(2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	@Test
	public void whatToBringTest() {
		logger = reporter.createTest("What To Bring Form Test");
		SellPage sp = new SellPage();
		
		Select sel = new Select(sp.selectState);
		List<WebElement> states = sel.getOptions();
		sel.selectByIndex((int)(Math.random() * states.size()-1));
		
		sp.radioMakingPaymentsNo.click();
		sp.radioMultipleTitleOwnersNo.click();
		sp.radioTitleOwnersCanComeNo.click();
		
		sp.buttonWhatToBring.click();
		
		assertTrue(sp.popupWhatBringText.isDisplayed());
	}
	
	
	@DataProvider(name="personal-info-positive")
	public String[][] providePersonalInfoPositive() {
		return new String[][]{ 
			{"Evangelin", "Arndt", "7783644351", "earndt0@upenn.edu"},
			{"Mara", "Daltrey", "7052168429", "mdaltrey1@topsy.com"},
			{"Skippy", "Beloe", "2345026772", "sbeloe2@zimbio.com"},
			{"June", "Enterlein", "1551808338", "jenterlein3@slashdot.org"},
		};
		
	}
	
	@DataProvider(name="personal-info-negative")
	public String[][] providePersonalInfoNegative() {
		return new String[][]{ 
			{"", "Arndt", "7783644351", "earndt0@upenn.edu"},
			{"Mara", "", "7052168429", "mdaltrey1@topsy.com"},
			{"Skippy", "Beloe", "234502633", "sbeloe2@zimbio.com"},
			{"June", "Enterlein", "1551808338", "jenterlein3@slashdot"},
		};
		
	}
	

}

package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;
import pages.SavedCarsPage;
import pages.SearchPage;
import pages.SpecificCarPage;
import utilities.BrowserUtilities;

public class SpecificCarTest extends TestBase {

	@BeforeMethod(alwaysRun=true)
	public void setUpMethod2() {
		LoginPage lp = new LoginPage();		
		lp.login();
		
		SearchPage sp = new SearchPage();
		
		deleteBadCookies();
		
		sp.searchBox.sendKeys("2017 Honda Accord");
		sp.searchButton.click();
		
		MainPage mp = new MainPage();
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		
		deleteBadCookies();
		sp.carLinks.get(0).click();
	}
	
	@Test
	public void saveCarTest() {		
		
		logger = reporter.createTest("Testing Saving car in a specific car page");
		SpecificCarPage scp = new SpecificCarPage();
		deleteBadCookies();
		
		String title = scp.carTitle.getText();
		String year = title.replaceAll("(\\d{4}).*", "$1");
		String model = title.replaceAll("\\d{4} (\\w+).*", "$1");
		
		System.out.println(title);
		System.out.println(year);
		System.out.println(model);
		
		logger.info("If the car is not saved yet, then click on save button");
		if(scp.saveCarButtonFave.getAttribute("class").contains("hidden")) {
			scp.saveCarButton.click();
			BrowserUtilities.waitFor(3);
		}
		
		logger.info("Navigating to the Saved Cars Page");
		scp.profileButton.click();
		scp.savedCarsButton.click();
		
		logger.info("Checking if the car just saved appears in Saved Cars List");
		SavedCarsPage saved = new SavedCarsPage();
		boolean pass = false;
		for(WebElement t: saved.titles) {
			
			if(t.getText().contains(year) && t.getText().contains(model)) {
				pass = true;
			}
		}
		
		assertTrue(pass);
		
		
	}
	
	@Test(groups="smoke2")
	public void move360Test() throws IOException {
		SpecificCarPage scp = new SpecificCarPage();
		
		logger = reporter.createTest("Testing Interior 360 view feature");
		
		scp.open360Button.click();
		
		logger.info("Testing 360 view to left");
		BrowserUtilities.waitFor(5);
		
		actions.moveByOffset(500, 500).clickAndHold().pause(3000)
					.moveByOffset(50, 0).pause(500).moveByOffset(50, 0).pause(500).moveByOffset(50, 0).pause(500)
					.moveByOffset(50, 0).pause(500).moveByOffset(50, 0).pause(500).moveByOffset(50, 0).pause(500)
					.release().build().perform();
		
		logger.addScreenCaptureFromPath(BrowserUtilities.getScreenshot("car_interior1"));
		
		logger.info("Testing 360 view to right");
		actions.clickAndHold().pause(3000)			
					.moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500)
					.moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500)
					.moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500)
					.moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500)
					.release().build().perform();
		logger.addScreenCaptureFromPath(BrowserUtilities.getScreenshot("car_interior2"));
					
		
		
	}
	
	@Test
	public void slideButtonTest() throws IOException {
		
		SpecificCarPage scp = new SpecificCarPage();
		
		logger = reporter.createTest("Testing Exterior 360 view feature");
		
		scp.open360Button.click();
		
		logger.info("Testing 360 view to left");
		BrowserUtilities.waitFor(5);
		
		if (!scp.exteriorButton.isDisplayed()) {
			for(int i=0; i<3; i++) {
				scp.slideButtons.get(1).click();
			}
			logger.addScreenCaptureFromPath(BrowserUtilities.getScreenshot("car_exterior1"));
			for(int i=0; i<5; i++) {
				scp.slideButtons.get(0).click();
			}
			logger.addScreenCaptureFromPath(BrowserUtilities.getScreenshot("car_exterior2"));
		} else {
			
			scp.exteriorButton.click();
			BrowserUtilities.waitFor(3);
			
			logger.info("Testing 360 view to left");
			BrowserUtilities.waitFor(5);
			
			actions.moveByOffset(500, 500).clickAndHold().pause(3000)
						.moveByOffset(50, 0).pause(500).moveByOffset(50, 0).pause(500).moveByOffset(50, 0).pause(500)
						.moveByOffset(50, 0).pause(500).moveByOffset(50, 0).pause(500).moveByOffset(50, 0).pause(500)
						.release().build().perform();
			
			logger.addScreenCaptureFromPath(BrowserUtilities.getScreenshot("car_exterior1"));
			
			logger.info("Testing 360 view to right");
			actions.clickAndHold().pause(3000)			
						.moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500)
						.moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500)
						.moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500)
						.moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500)
						.release().build().perform();
			logger.addScreenCaptureFromPath(BrowserUtilities.getScreenshot("car_exterior2"));
			
		}
	}
}

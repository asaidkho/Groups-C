package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;
import pages.SavedCarsPage;
import pages.SearchPage;
import pages.SpecificCarPage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class SpecificCarTest extends TestBase {

	@BeforeMethod
	public void setUpMethod2() {
		LoginPage lp = new LoginPage();		
		lp.login();
		
		logger = reporter.createTest("Save Car Test");
		SearchPage sp = new SearchPage();
		
		deleteBadCookies();
		
		logger.info("Logged in at this point and searching for 2017 Honda Accord");
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
		
		SpecificCarPage scp = new SpecificCarPage();
		
		scp.saveCarButton.click();		
	}
	
	@Test
	public void move360Test() {
		SpecificCarPage scp = new SpecificCarPage();
		
		scp.open360Button.click();
		
		BrowserUtilities.waitFor(5);
		
		actions.moveByOffset(500, 500).clickAndHold().pause(5000)
					.moveByOffset(50, 0).pause(500).moveByOffset(50, 0).pause(500).moveByOffset(50, 0).pause(500)
					.moveByOffset(50, 0).pause(500).moveByOffset(50, 0).pause(500).moveByOffset(50, 0).pause(500)
					.moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500)
					.moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500)
					.moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500)
					.moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500).moveByOffset(-50, 0).pause(500)
					.release().moveByOffset(400,-400).clickAndHold().moveByOffset(50, 50).pause(500).
					moveByOffset(50, 50).pause(500).moveByOffset(50, 50).pause(500).moveByOffset(50, 50).pause(500)
					.moveByOffset(50, 50).pause(500).moveByOffset(50, 50).pause(500).moveByOffset(50, 50).pause(500)
					.moveByOffset(50, 50).pause(500)
					.release().build().perform();
		
		
	}
	
	@Test
	public void slideButtonTest() {
		
		SpecificCarPage scp = new SpecificCarPage();
		
		for(int i=0; i<5; i++) {
			scp.slideButtons.get(1).click();
		}
		for(int i=0; i<5; i++) {
			scp.slideButtons.get(0).click();
		}
	}
}

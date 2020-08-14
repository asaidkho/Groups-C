package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProfilePage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class ProfileUpdateTest extends TestBase{
	
	
	@BeforeMethod(alwaysRun=true)
	public void setUpMethod2() {
		deleteBadCookies();
		LoginPage lp = new LoginPage();
		lp.login();
		BrowserUtilities.waitFor(1);
		deleteBadCookies();
		
		lp.profileButton.click();
		lp.myProfileButton.click();
		BrowserUtilities.waitFor(1);
		deleteBadCookies();
	}
	
	@Test(dataProvider = "addresses", groups = {"sprint3"})
	public void EditProfileTest(String street, String city, String state, String zip) {
		logger = reporter.createTest("Test Profile editting feature");
		
		ProfilePage pp = new ProfilePage();
		pp.addressLine1.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
		pp.addressLine1.sendKeys(street);
		pp.city.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
		pp.city.sendKeys(city);
		pp.state.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
		pp.state.sendKeys(state);
		pp.zipCode.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
		pp.zipCode.sendKeys(zip);
		pp.profileSubmitButton.click();
		
		Driver.getDriver().navigate().refresh();
		deleteBadCookies();
		assertEquals(street, pp.addressLine1.getAttribute("value"));
		assertEquals(city, pp.city.getAttribute("value"));
		assertEquals(state, pp.state.getAttribute("value"));
		assertEquals(zip, pp.zipCode.getAttribute("value"));
		
		
	}
	
	
	@Test(groups = "sprint3")
	public void updatePreferencesTest() {
		logger = reporter.createTest("Test Update Preferences Form");
		
		int randInt = (int)(Math.random()*3);
		
		ProfilePage pp = new ProfilePage();
		
		List<WebElement> radioButtons = Arrays.asList(pp.radio0, pp.radio1, pp.radio2);
		deleteBadCookies();
		radioButtons.get(randInt).click();
		pp.preferencesSubmitButton.click();
		
		Driver.getDriver().navigate().refresh();
		deleteBadCookies();
		BrowserUtilities.waitFor(3);
		assertTrue(radioButtons.get(randInt).isSelected());
	}
	
	
	
	@DataProvider(name="addresses")
	public String[][] getAddresses() {
		return new String[][] {
			{"64071 Messerschmidt Avenue","Memphis","TN","38188"},
			{"1683 Talmadge Center","Seminole","FL","34642"}
			
		};
	}
	
}

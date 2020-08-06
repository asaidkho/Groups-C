package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FilterPage;
import pages.MainPage;
import utilities.BrowserUtilities;
import utilities.CSVUtility;
import utilities.Driver;

public class FiltersTest extends TestBase {
	
	
	@DataProvider (name ="file")
	public Object[][] getDataFromCSV() throws IOException{
			return CSVUtility.extractData("carData.csv");
	}

	@Test (dataProvider = "file") // add new data to file
	  public void addFilter(String make, String model) {
		logger = reporter.createTest("Search for a specific car model");
		MainPage mp = new MainPage();
		
		logger.info("Enter car make and model"); //BMW X5
		mp.searchBox.sendKeys(make,model);
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		deleteBadCookies();
		
		//assertTrue(mp.searchResults.getText().contains(make));
		//assertTrue(driver.getTitle().contains(make));
		
		logger.info("Expand distance wrapper icon");
		
		FilterPage fp = new FilterPage();
		
		deleteBadCookies();
		if (fp.locationConformPopUp.isEnabled()) {
			fp.locationConformPopUp.click();
		}
		fp.nationwide.click();
		
		BrowserUtilities.waitFor(2);
		driver.manage().deleteAllCookies();
		assertTrue(fp.nationwide.isEnabled());
		
		logger.info("Select Nationwide button");
		fp.nationwide.click();
		BrowserUtilities.waitFor(2);
		logger.info("Validate that Nationwide filter is applied");
		
		
		
		
	/* dont know how, changes on class name> (kmx-menu-item-button selected)
		assertTrue(driver.getTitle().contains("nationwide"));*/
	
	}

    @Test (dataProvider ="file")
    public void clearFilters(String make, String model) {
    	
    	
    	logger = reporter.createTest("Search for a Car");
		MainPage mp = new MainPage();
		
		logger.info("Enter car make"); //BMW X5
		mp.searchBox.sendKeys(make, model);
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		//assertTrue(mp.searchResults.getText().contains(make));
		//assertTrue(driver.getTitle().contains(make));
		deleteBadCookies();
		logger.info("Expand distance wrapper icon");
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		deleteBadCookies();
		FilterPage fp = new FilterPage();
		fp.nationwide.click();
		
		BrowserUtilities.waitFor(2);
		driver.manage().deleteAllCookies();
		assertTrue(fp.nationwide.isEnabled());
		
		logger.info("Select Nationwide button");
		fp.nationwide.click();
		BrowserUtilities.waitFor(2);
		logger.info("Clear Applied Filters");
		
		fp.clear.click();
		logger.info("Validate that all applied filters are cleared");
		assertTrue(Driver.getDriver().getCurrentUrl().equals("https://www.carmax.com/cars/all"));
		
		
     
    
    
    }


}

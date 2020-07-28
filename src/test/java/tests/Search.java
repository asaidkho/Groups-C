package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.MainPage;
import utilities.CSVUtility;

public class Search extends TestBase {
	
	
	@DataProvider (name ="file")
	public Object[][] getDataFromCSV() throws IOException{
			return CSVUtility.extractData("cars.csv");
	}
	/*
	@Test (dataProvider = "file")
	public void SearchByModel(String model, String make) throws Exception {
		logger = reporter.createTest("Search by Model");
		MainPage mp = new MainPage();
		
		logger.info("Entering car model");
		mp.searchBox.sendKeys(model);
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		//assertTrue(mp.searchResults.getText().contains(model));
	}
	
	@Test (dataProvider = "file")
	public void SearchByMake(String model, String make) throws Exception {
		logger = reporter.createTest("Search by Make");
		MainPage mp = new MainPage();
		
		logger.info("Entering car make");
		mp.searchBox.sendKeys(make);
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		//assertTrue(mp.searchResults.getText().contains(make));
	}
	
	@Test (dataProvider = "file")
	public void limitSearchResultsByLocationAndDistance(String model, String make) {
		
		logger = reporter.createTest("Limit Search Results by Location and Distance");
		MainPage mp = new MainPage();
		Faker f = new Faker();
		
		logger.info("Entering car make and model");
		mp.searchBox.sendKeys(make + " " + model);
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		
		logger.info("Entering zip code");
		mp.zipCode.sendKeys(f.address().zipCode());
		logger.info("Clicking on distance radius dropdown");
		mp.distanceRadiusDropdown.click();
		logger.info("Select the distance radius");
		mp.distanceRadiusDropdown.click();;
		
	}
	*/
	@Test
	public void searchByTypeFilterMake() {
		logger = reporter.createTest("Search by Type with applied filter of Make");
		MainPage mp = new MainPage();
		
		String[] type = {"SUVs","Trucks","Crossovers","Sedans","Coupes"};
		
		logger.info("Entering car type");
		mp.searchBox.sendKeys(type[2]);  //hardcoded
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		
		//not working
		logger.info("Select the Make(recomended) filter");
		if(mp.makeFilters.getText().contains("Toyota")) {
			driver.findElement(By.xpath("//[@class = 'smooth-carousel__content']//a[6]")).click();;
		}
		
	}
	
}

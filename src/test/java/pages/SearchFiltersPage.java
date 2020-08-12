package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.BrowserUtilities;

public class SearchFiltersPage extends BasePage {

	
	//Sprint 3
	
	
	    // make
		@FindBy(xpath = "//*[@id='Make']")
		public WebElement make;
	
		//DistanceDropDown
		@FindBy(css = "#search-bar-form > div > div.search-bar--fields-wrapper > div.search-bar--form-field.radius > div > button")
		public WebElement DistanceDropDown;
		
		//nationwide
		@FindBy(xpath = "//*[@id='search-bar-form']//ul/li[9]/button")
		public WebElement Nationwide;
		
		//Audi
		@FindBy(xpath = "//*[@id='Make']//ul/li[2]")
		public WebElement Audi;
	
		//Acura
		@FindBy(xpath = "//*[@id='Make']//ul/li[1]")
		public WebElement Acura;

        @FindBy(xpath = "/html/body/div[4]/div/div/div[1]")
        public WebElement locationConformPopUp;
        
        //Sort by
        @FindBy (xpath = "//*[@id=\"search-results-header\"]/div[3]/div/div/button")
		public WebElement sortBy;
        
        //Newest Year
        @FindBy (xpath = "//button[.='Newest year']")
        public WebElement newestYear;
        
        //Product
        @FindBy (xpath = "//article[3]//h3/span")
        public WebElement Car;
        
        //HIghest Milage
        @FindBy (xpath = "//button[.='Highest milage']")
        public WebElement highestMilage;
        
      //SocialMedia
        @FindBy (xpath = "//*[@id='footer']//section[1]/a[2]")
        public WebElement facebook;
        
        
        
        
        
}




		//milage Actual
		      //*[@class='price-mileage__car-title__year-make'] 
	
	
	
	
	//newest 
	//article["+i+"]//h3/span[1]
	
	
	
	/*
		@FindBy(xpath = "/html/body/div[4]/div/div/div[1]")
		public WebElement locationConformPopUp;
		
		//
		@FindBy(id = "Availability")
		public WebElement statusFilter;
			
		//
		@FindBy(xpath = "//*[@id='Availability']//div[3]/ul/li[2]")
		public WebElement newStatus;
		
		
		//
		@FindBy(xpath="//li//span[@class='refinement-value--name']")
		public List<WebElement> allFeatures;
	*/
	


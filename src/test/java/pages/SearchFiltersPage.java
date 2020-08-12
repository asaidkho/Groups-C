package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchFiltersPage extends BasePage {

	
	//Sprint 3
	
	
	 // make
		@FindBy(xpath = "//*[@id='Make']")
		public WebElement make;

		//Audi
		@FindBy(xpath = "//*[@id='Make']//ul/li[2]//span[2]")
		public WebElement Audi;

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
	


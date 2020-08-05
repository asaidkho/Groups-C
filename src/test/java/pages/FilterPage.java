package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterPage extends BasePage { 

	
	//drawer label
	@FindBy(id = "mpghighway")
	public WebElement MPGHighway;
	
	
	//slider
	@FindBy(xpath = "//*[@id=\"mpghighway\"]/div[3]/div/div/div[2]/div[4]")
	public WebElement sliderHandle;
	
	//inputBox
	//@FindBy(className = "slider-input__text")
	@FindBy(xpath = "//input[@type='tel']")
	public WebElement inputBox;
	
	
	//Features
	@FindBy(id = "Features")
	public WebElement features;
	
	//seeAllFromFeatures
	
	@FindBy(xpath="//*[@id=\"Features\"]/div[3]/ul/button")
	//@FindBy(className ="facet--curated-show-more kmx-button kmx-button--secondary visible");
	//@FindBy(xpath="//button[.='See All']");
	public WebElement seeAll;
	
	
	
	//clear filter
	@FindBy(className="sidebar-header--action clear--link")
	public WebElement clear;
	
	
	//drop down 
		@FindBy(className="kmx-menu-button kmx-button kmx-button--tertiary")
		public WebElement DropDown;
		
		
		//nationwide
		@FindBy(xpath="//*[@id=\"search-bar-form\"]/div/div[2]/div[2]/div/div/div/ul/li[9]/button")
		public WebElement nationwide;
	
		/*@FindBy (css = "#search-bar-form 
		 * > div > div.search-bar--fields-wrapper > div.search-bar--form-field.radius > div > button")
		public WebElement DropDown;
		
		
		@FindBy (xpath = "//*[@id=\"search-bar-form\"]/div/div[2]/div[2]/div/div/div/ul/li[9]/button")
		public WebElement distanceRadiusNationwide;*/
}

	
	
	
	//change place to searchPage.
	//search byMake>Nationwide
	//@FindBy(xpath = "")
	//public WebElement ;
	
	
	
	
	
	


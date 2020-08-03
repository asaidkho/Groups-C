package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrucksPage extends BasePage { 

	
	//drawer label
	@FindBy(xpath = "//*[@id=\"mpghighway\"]/div[2]/svg")
	public WebElement MPGHighway;
	
	//slider
	@FindBy(xpath = "//*[@id=\"mpghighway\"]/div[3]/div/div/div[2]/div[4]")
	public WebElement sliderHandle;
	
	
	//
	//@FindBy(className = "slider-input__text")
	@FindBy(xpath = "//input[@type='tel']")
	public WebElement inputBox;
	
	//change place to searchPage.
	//search byMake>Nationwide
	//@FindBy(xpath = "")
	//public WebElement ;
	
	
	
	
	
	
}

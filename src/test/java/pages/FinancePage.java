package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinancePage extends BasePage{
	@FindBy (xpath = "//*[@class='tombstone-container']/a[2]")
	public WebElement carPaymentCalculatorLink;
	
	@FindBy (xpath = "//*[@class='calc-price-dp-inputs']/div[1]//input")
	public WebElement vehicleBudgetTextField;
	
	@FindBy (xpath = "//*[@class='calc-price-dp-inputs']/div[2]//input")
	public WebElement downPaymentTextField;
	
	@FindBy (id = "select-state-location-select")
	public WebElement stateDropDown;
	
	@FindBy (id = "select-credit-rating-select")
	public WebElement creditRatingDropDown;
	
	@FindBy (id = "text-field-apr-text-field")
	public WebElement aprTextField;
	
	@FindBy (id = "select-term-length-select")
	public WebElement termLengthDropDown;
	
	@FindBy (id = "calc-button-shop-cars")
	public WebElement shopCarsInYourBudgetButton;
	
}

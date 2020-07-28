package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

	@FindBy (xpath = "//span[@class='year-make']")
	public WebElement searchResults;
	
	@FindBy (id = "zip")
	public WebElement zipCode;
	
	@FindBy (className = "kmx-menu-button kmx-button kmx-button--tertiary")
	public WebElement distanceRadiusDropdown;
	
	@FindBy (className = "location-confirm-modal--close--2psMn")
	public WebElement locationConformPopUp;
	
	@FindBy (xpath = "//[@class='kmx-list']//ul//li[3]")  //back to this to not hardcode
	public WebElement distanceRadius;
	
	@FindBy (className = "recommended-refinement kmx-typography--body-1")
	public WebElement makeFilters;
}

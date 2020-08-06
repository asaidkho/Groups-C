package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedCarsPage extends BasePage {
	
	@FindBy(css="div.d-flex-desktop button.kmx-icon-button--grey")
	public List<WebElement> deleteCarButtons;
	
	@FindBy(xpath="//div[@class='d-flex-desktop']//h4")
	public List<WebElement> carTitles;
	
	@FindBy(xpath="//div[@class='d-flex']//button[contains(@class,'kmx-icon-button')]")
	public WebElement sortButton;
	
	@FindBy(xpath="//div[.='Price: Low - High']")
	public WebElement sortPriceAsc;
	
	@FindBy(css="span.saved-car-price")
	public List<WebElement> prices;
	
	@FindBy(css=".d-flex-desktop > div > h4")
	public List<WebElement> titles;

}

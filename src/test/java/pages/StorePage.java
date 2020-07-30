package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StorePage extends BasePage{

	@FindBy(css="div.stores-list-cabinet--detailed-info")
	public List<WebElement> states;
	
	
	@FindBy(css="div.stores-list-cabinet--detailed-info > div > p")
	public List<WebElement> countByState;
	
	
	@FindBy(css="div.stores-list-cabinet--detailed-info")
	public List<WebElement> cities;
	
	
	@FindBy(css="div.stores-list-cabinet--detailed-info > div > p")
	public List<WebElement> countByCity;
	
}

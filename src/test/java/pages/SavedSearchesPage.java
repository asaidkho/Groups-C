package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedSearchesPage extends BasePage{
	
	@FindBy(css="span.d-flex > h3")
	public List<WebElement> savedSearchTitles;
	
	
	@FindBy(css = "div.kmx-icon-bar button")
	public List<WebElement> deleteSearchButtons;

}

package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedSearchesPage extends BasePage{
	
	@FindBy(css="span.d-flex > h3")
	public List<WebElement> savedSearchTitles;
	
	
	@FindBy(css = "div.kmx-icon-bar button")
	public List<WebElement> deleteSearchButtons;
	
	@FindBy(xpath = "(//span[contains(text(), 'Update')])")
	public List<WebElement> getUpdatesLink;
	
	@FindBy(id = "radio-0")
	public WebElement radio0;
	
	@FindBy(id = "radio-1")
	public WebElement radio1;
	
	@FindBy(id = "radio-2")
	public WebElement radio2;
	
	@FindBy(xpath="//button[contains(text(), 'Update')]")
	public WebElement alertUpdateButton;
	
	@FindBy(xpath="(//span[contains(text(), 'Update')])[1]/parent::span")
	public WebElement alertOption;

}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPage extends BasePage {

	@FindBy (xpath = "//*[@id='footer']//section[5]//a")
	public WebElement searchJobsLink;
	
	@FindBy (xpath = "//*[@class='job-filter']//input")
	public WebElement jobFilterTextField;
	
	@FindBy (xpath = "//*[@class='location-filter']//input")
	public WebElement locationEntryField;
	
	@FindBy (xpath = "//*[@class='input-group-btn']//button")
	public WebElement searchJobButton;
	
	@FindBy (xpath = "//*[@class='showing-jobs-block']//span[5]")
	public WebElement showingResultsForjobTitle;
}

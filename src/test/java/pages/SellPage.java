package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SellPage extends BasePage{
	
	
	@FindBy(xpath="//a[@href='https://www.carmax.com/stores']")
	public WebElement changeStoreLink;
	
	// We buy cars form elements:
	@FindBy(id="widget-year")
	public WebElement yearInput;
	
	@FindBy(id="widget-make__select")
	public WebElement selectMake;
	
	@FindBy(id="widget-model__select")
	public WebElement selectModel;
	
	@FindBy(id="widget-mileage")
	public WebElement mileageInput;
	
	@FindBy(id="widget-mileage")
	public WebElement submitButton;
	
	
	
	// Make an appointment form elements:
	@FindBy(id="appt-fname")
	public WebElement apptFname;
	
	@FindBy(id="appt-lname")
	public WebElement apptLname;
	
	@FindBy(id="appt-phone")
	public WebElement apptPhone;
	
	@FindBy(id="appt-email")
	public WebElement apptEmail;
	
	@FindBy(id="appt-personal__next")
	public WebElement apptPersonalNext;
	
	public void fillApptFormPersonal(String fname, String lname, String phone_number, String email) {
		SellPage sp = new SellPage();
		
		sp.apptFname.sendKeys(fname);
		sp.apptLname.sendKeys(lname);
		sp.apptPhone.sendKeys(phone_number);
		sp.apptEmail.sendKeys(email);
	}
	
	
	
	//What to bring form elements:
	@FindBy(id="wtb-selected-state")
	public WebElement selectState;
	
	@FindBy(id="wtb-makingPayments-Yes")
	public WebElement radioMakingPaymentsYes;
	
	@FindBy(id="wtb-makingPayments-No")
	public WebElement radioMakingPaymentsNo;
	
	@FindBy(id="wtb-multipleTitleOwners-Yes")
	public WebElement radioMultipleTitleOwnersYes;
	
	@FindBy(id="wtb-multipleTitleOwners-No")
	public WebElement radioMultipleTitleOwnersNo;
	
	@FindBy(id="wtb-titleOwnersCanCome-Yes")
	public WebElement radioTitleOwnersCanComeYes;
	
	@FindBy(id="wtb-titleOwnersCanCome-No")
	public WebElement radioTitleOwnersCanComeNo;
	
	@FindBy(xpath="//div[@id='what-to-bring']//button")
	public WebElement buttonWhatToBring;
	
	
	@FindBy(xpath="//h3[.='What to bring to CarMax']")
	public WebElement popupWhatBringText;
	
	
	
	
	@FindBy(xpath="//div[contains(@id, 'faq-')]/div/div[1]")
	public List<WebElement> faqs;
	
	@FindBy(xpath="//div[contains(@id, 'faq-')]/div/div[3]")
	public List<WebElement> faqs_text;
	
}

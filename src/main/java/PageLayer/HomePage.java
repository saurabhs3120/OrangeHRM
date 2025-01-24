package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.WebElementUtils;

public class HomePage extends BaseClass{

	//1 create Object Repository using POM with page Factory
	
	@FindBy(xpath="//img[@alt='client brand banner']")
	WebElement logo;
	
	@FindBy(xpath="//span[text()='PIM']")
	WebElement pimLink;
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement adminLink;
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	WebElement logoutDropDown;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
		
	//2 initialize the object repository using Page Factory dot initElements method by passing drive and this keyword
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	//3. create associated non static method for each and every object repository without entering test data

	public boolean checkLogoDisplayedStatus()
	{
		return logo.isDisplayed();
	}
	
	
	public void clickOnPimLink()
	{
		WebElementUtils.click(pimLink);
	}
	
	public void clickOnAdminLink()
	{
		WebElementUtils.click(adminLink);
	}
	
	
	public void logoutFunctionality()
	{
		WebElementUtils.click(logoutDropDown);
		WebElementUtils.click(logout);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

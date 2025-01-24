package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.WebElementUtils;

public class LoginPage extends BaseClass{
	
	//1. create Object Repository using POM with page Factory
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[text()=' Login ']")
	WebElement loginButton;
	
	//2 initialize the object repository using Page Factory dot initElements method by passing drive and this keyword
	
	public LoginPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	//3. create associated non static method for each and every object repository without entering test data
	
	public void loginFunctionality(String Username, String Password)
	{
		WebElementUtils.sendKeys(username, Username);
		
		WebElementUtils.sendKeys(password, Password);
		
		WebElementUtils.click(loginButton);
	}
	
	
	
	
}

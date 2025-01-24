package PageLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.HandleDropDown;
import UtilityLayer.WebElementUtils;

public class AdminPage extends BaseClass {

	@FindBy(xpath = "//button[text()=' Add ']")
	WebElement addButton;

	@FindBy(xpath = "//label[text()='User Role']/parent::div/following-sibling::div/child::div")
	WebElement userRoleDropDown;

	@FindBys(@FindBy(xpath = "//div[@class='oxd-select-option']"))
	List<WebElement> listUserRole;

	@FindBy(xpath = "//label[text()='Employee Name']/parent::div/following-sibling::div/descendant::input")
	WebElement employeeName;

	@FindBy(xpath = "//div[@class='oxd-autocomplete-option']")
	List<WebElement> listEmployeeSuggest;

	@FindBy(xpath = "//label[text()='Status']/parent::div/following-sibling::div/child::div")
	WebElement statusDropDown;

	@FindBys(@FindBy(xpath = "//div[@class='oxd-select-option']"))
	List<WebElement> listStatus;

	@FindBy(xpath = "//label[text()='Username']/parent::div/following-sibling::div/descendant::input")
	WebElement username;

	@FindBy(xpath = "//label[text()='Password']/parent::div/following-sibling::div/descendant::input")
	WebElement password;

	@FindBy(xpath = "//label[text()='Confirm Password']/parent::div/following-sibling::div/descendant::input")
	WebElement confirmPassword;

	@FindBy(xpath = "//button[text()=' Save ']")
	WebElement saveButton;

	public AdminPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void addUser(String UserRole, String EmployeeName, String Status, String Username, String Password,
			String cPassword) throws InterruptedException {

		WebElementUtils.click(addButton);
		WebElementUtils.click(userRoleDropDown);
		HandleDropDown.selectDropDownValue(listUserRole, UserRole);
		WebElementUtils.sendKeys(employeeName, EmployeeName);

		Thread.sleep(2000);

		for (int i = 0; i <= listEmployeeSuggest.size(); i++) {
			listEmployeeSuggest.get(0).click();
			break;
		}

		Thread.sleep(2000);
		WebElementUtils.click(statusDropDown);
		HandleDropDown.selectDropDownValue(listStatus, Status);
		WebElementUtils.sendKeys(username, Username);
		WebElementUtils.sendKeys(password, Password);
		WebElementUtils.sendKeys(confirmPassword, cPassword);

		Thread.sleep(3000);
		WebElementUtils.click(saveButton);
		Thread.sleep(4000);
	}

}

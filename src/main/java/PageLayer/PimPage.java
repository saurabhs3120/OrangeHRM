package PageLayer;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.HandleDropDown;
import UtilityLayer.WebElementUtils;

public class PimPage extends BaseClass {

	// 1 create Object Repository using POM with page Factory
	@FindBy(xpath = "//a[text()='Add Employee']")
	WebElement addEmployee;

	@FindBy(name = "firstName")
	WebElement firstName;

	@FindBy(name = "middleName")
	WebElement middleName;

	@FindBy(name = "lastName")
	WebElement lastName;

	@FindBy(xpath = "//button[text()=' Save ']")
	WebElement saveButton;

	@FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div/child::input")
	WebElement employeeId;

	@FindBy(xpath = "//label[text()='Nationality']/parent::div/following-sibling::div/child::div")
	WebElement nationalityDropDown;

	@FindBys(@FindBy(xpath = "//div[@class='oxd-select-option']/child::span"))
	List<WebElement> listNationality;

	@FindBy(xpath = "//label[text()='Marital Status']/parent::div/following-sibling::div/child::div")
	WebElement martialStatusDropDown;

	@FindBys(@FindBy(xpath = "//div[@class='oxd-select-option']"))
	List<WebElement> listOfMartialStatus;

	@FindBys(@FindBy(xpath = "//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input']/parent::label"))
	List<WebElement> listOfRadioButton;

	@FindBy(xpath = "//p[text()=' * Required']/following-sibling::button")
	WebElement saveMoreDetailsBtn;

	@FindBy(xpath = "//a[text()='Employee List']")
	WebElement employeeList;

	@FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div/child::input")
	WebElement employeeIdTextBoxSearch;

	@FindBy(xpath = "//button[text()=' Search ']")
	WebElement searchButton;

	// 2 initialize the object repository using Page Factory dot initElements method
	// by passing drive and this keyword

	public PimPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void addEmployee(String FirstName, String MiddleName, String LastName) throws InterruptedException {
		WebElementUtils.click(addEmployee);
		WebElementUtils.sendKeys(firstName, FirstName);
		WebElementUtils.sendKeys(middleName, MiddleName);
		WebElementUtils.sendKeys(lastName, LastName);
		Thread.sleep(5000);
		WebElementUtils.click(saveButton);

	}

	public void addEmployee(String FirstName, String LastName) throws InterruptedException {
		WebElementUtils.click(addEmployee);
		WebElementUtils.sendKeys(firstName, FirstName);
		WebElementUtils.sendKeys(lastName, LastName);
		Thread.sleep(5000);
		WebElementUtils.click(saveButton);
	}

	public String addMoreEmployeeDetailsAndCaptureId() {
		String empid = WebElementUtils.getAttribute(employeeId, "value");

		WebElementUtils.click(saveMoreDetailsBtn);

		return empid;
	}

	public String addMoreEmployeeDetailsAndCaptureId(String Nationality) throws InterruptedException {
		String empid = WebElementUtils.getAttribute(employeeId, "value");

		Thread.sleep(5000);

		WebElementUtils.click(nationalityDropDown);

		HandleDropDown.selectDropDownValue(listNationality, Nationality);

		WebElementUtils.click(saveMoreDetailsBtn);
		return empid;
	}

	public String addMoreEmployeeDetailsAndCaptureId(String Nationality, String martialStatus)
			throws InterruptedException {

		String empid = WebElementUtils.getAttribute(employeeId, "value");

		Thread.sleep(5000);

		WebElementUtils.click(nationalityDropDown);

		HandleDropDown.selectDropDownValue(listNationality, Nationality);

		WebElementUtils.click(martialStatusDropDown);

		HandleDropDown.selectDropDownValue(listOfMartialStatus, martialStatus);

		WebElementUtils.click(saveMoreDetailsBtn);

		return empid;
	}

	public String addMoreEmployeeDetailsAndCaptureId(String Nationality, String martialStatus, String gender)
			throws InterruptedException {

		String empid = WebElementUtils.getAttribute(employeeId, "value");

		Thread.sleep(5000);
		WebElementUtils.click(nationalityDropDown);

		HandleDropDown.selectDropDownValue(listNationality, Nationality);

		WebElementUtils.click(martialStatusDropDown);

		HandleDropDown.selectDropDownValue(listOfMartialStatus, martialStatus);

		WebElementUtils.selectRadioValue(listOfRadioButton, gender);

		WebElementUtils.click(saveMoreDetailsBtn);

		return empid;
	}

	public void searchEmployeeFunctionality(String empId) throws InterruptedException {
		WebElementUtils.click(employeeList);
		WebElementUtils.sendKeys(employeeIdTextBoxSearch, empId);
		Thread.sleep(5000);
		WebElementUtils.click(searchButton);
	}

	public void abc(String monthYear, String Date) {
		List<WebElement> listDates = getDriver()
				.findElements(By.xpath("//div[contains(@aria-label,'" + monthYear + "']"));

		for (WebElement wb : listDates) {
			String actualDate = wb.getText();

			if (actualDate.equals(Date)) {
				wb.click();
				break;
			}
		}

	}

}

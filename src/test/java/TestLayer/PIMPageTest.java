package TestLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.HomePage;
import PageLayer.PimPage;

@Test(groups = { "pim","RegressionTesting" }, dependsOnGroups = { "home" })
public class PIMPageTest extends BaseClass {
	PimPage pimPage;
	String employeeId;

	@Test(priority = 1)
	public void validatePimPage() {
		HomePage homePage = new HomePage();
		homePage.clickOnPimLink();
		String url = getDriver().getCurrentUrl();
		boolean actualurl = url.contains("pim");
		Assert.assertEquals(actualurl, true);

	}

	@Test(priority = 2)
	public void validateNewEmployee() throws InterruptedException {
		pimPage = new PimPage();
		pimPage.addEmployee("Akash", "Yadav");
	}

	@Test(priority = 3)
	public void validateEmployeeInformation() throws InterruptedException {
		employeeId = pimPage.addMoreEmployeeDetailsAndCaptureId("India");
	}

	@Test(priority = 4)
	public void validateSearchFunctionality() throws InterruptedException {
		pimPage.searchEmployeeFunctionality(employeeId);
	}

}

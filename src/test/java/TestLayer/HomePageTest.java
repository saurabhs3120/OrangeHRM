package TestLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.HomePage;

public class HomePageTest extends BaseClass {

	HomePage homePage;

	@Test(priority = 1, groups= {"home","RegressionTesting"}, dependsOnGroups = {"login"}, description = "Validate Home Page Logo Test Cases")
	public void validateLogo() {
		homePage = new HomePage();
		boolean actualLogoStatus = homePage.checkLogoDisplayedStatus();
		Assert.assertEquals(actualLogoStatus, true);

	}

	@Test(priority = 2, groups= {"home","RegressionTesting"}, dependsOnGroups = {"login"}, description = "Validate Home Page Title Test Cases")
	public void validateHomeTitle() {
		String actualTitle = getDriver().getTitle();

		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Test(priority = 3, groups= {"home","RegressionTesting"}, dependsOnGroups = {"login"})
	public void validateHomeUrl() {
		String url = getDriver().getCurrentUrl();
		boolean actualurl = url.contains("orangehrm");

		Assert.assertEquals(actualurl, true);

	}
}

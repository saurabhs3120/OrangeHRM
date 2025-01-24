package TestLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.AdminPage;
import PageLayer.HomePage;
import PageLayer.LoginPage;

@Test(groups = { "admin", "RegressionTesting" }, dependsOnGroups = { "pim" })
public class AdminPageTest extends BaseClass {

	HomePage homePage;

	@Test(priority = 1)
	public void validateAdminPage() {
		homePage = new HomePage();
		homePage.clickOnAdminLink();

		String url = getDriver().getCurrentUrl();
		boolean actualUrl = url.contains("admin");

		Assert.assertEquals(actualUrl, true);
	}

	@Test(priority = 2)
	public void addUserCredentails() throws InterruptedException {
		AdminPage adminPage = new AdminPage();
		adminPage.addUser("ESS", "Akash Yadav", "Enabled", "akashyadav@gmail.com", "Akash11@123", "Akash11@123");
	}

	@Test(priority = 3)
	public void logoutFunctionality() {
		homePage.logoutFunctionality();
	}

	@Test(priority = 4)
	public void validateLoginFunctionality() {
		LoginPage loginPage = new LoginPage();
		loginPage.loginFunctionality("akashyadav@gmail.com", "Akash11@123");
	}

}

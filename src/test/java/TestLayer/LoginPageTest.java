package TestLayer;

import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.LoginPage;

public class LoginPageTest extends BaseClass {

	@Test(groups = { "setup", "RegressionTesting" })
	public void setup() {
		BaseClass.initilalization("chrome");
	}

	@Test(groups = { "login", "RegressionTesting" }, dependsOnGroups = { "setup" })
	public void validateLoginFunctionality() {
		LoginPage loginPage = new LoginPage();
		loginPage.loginFunctionality("Admin", "admin123");
	}

}

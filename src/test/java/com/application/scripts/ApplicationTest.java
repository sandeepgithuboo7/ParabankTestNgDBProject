package com.application.scripts;

import org.testng.annotations.Test;

import com.application.actions.ForgotLoginPageActions;
import com.application.actions.LoginPageActions;
import com.application.actions.RegistrationPageActions;
import com.framework.webdriver.WebDriverClass;

public class ApplicationTest extends WebDriverClass {

	LoginPageActions loginPage;
	ForgotLoginPageActions forgotLoginPage;
	RegistrationPageActions registrationPage;

	@Test(priority = 1, groups = { "Smoke", "Sanity" })
	public void VerifyWhetherApplicationIsLaunchedSuccessfully() {
		loginPage = LoginPageActions.getLoginPage();
		loginPage.launchapplication();
	}

	@Test(priority = 2, groups = { "Sanity" })
	public void VerifyApplicationLogoAndCaption() {
		loginPage = LoginPageActions.getLoginPage();
		loginPage.launchapplication();
		loginPage.verifyLogoAndCaption();
	}

	@Test(priority = 3, groups = { "Sanity" })
	public void VerifyApplicationLoginpageHeader() {
		loginPage = LoginPageActions.getLoginPage();
		loginPage.launchapplication();
		loginPage.verifyLoginPageHeader();
	}

	@Test(priority = 4, groups = { "Regression" },dataProvider="testdata")
	public void VerifyApplicationLoginFeature(String user, String pass) {
		loginPage = LoginPageActions.getLoginPage();
		loginPage.launchapplication();
		loginPage.enterUsernameAndPassword(user, pass);
		loginPage.clickOnLoginAndVerifyLoginIsSuccessful();
	}

	@Test(priority = 5, groups = { "Regression" })
	public void VerifyForgotLoginInfoPageHeader() {
		loginPage = LoginPageActions.getLoginPage();
		forgotLoginPage = ForgotLoginPageActions.getForgotLoginPage();
		loginPage.launchapplication();
		loginPage.getForgotLoginPage();
		forgotLoginPage.verifyForgotLoginPageHeader();
	}

	@Test(priority = 6, groups = { "Regression" })
	public void VerifyRegistrationPageHeader() {
		loginPage = LoginPageActions.getLoginPage();
		registrationPage = RegistrationPageActions.getRegisterPage();
		loginPage.launchapplication();
		loginPage.getForgotLoginPage();
		registrationPage.verifyRegistrationPageHeader();
	}
}

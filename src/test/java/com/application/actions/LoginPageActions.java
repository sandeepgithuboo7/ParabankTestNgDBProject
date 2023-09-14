package com.application.actions;

import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.elements.LoginPageElements;
import com.framework.utilities.ReadProp;
import com.framework.webdriver.WebDriverClass;

public class LoginPageActions extends LoginPageElements{
	
	Properties prop = ReadProp.readData("Config.properties");
	
	public void launchapplication() {
		driver.get(prop.getProperty("url"));
		wait(2);
		Assert.assertEquals(getPageTitle(), prop.getProperty("title"));
		log("pass","Application is successfully launched");
	}
	
	public void verifyLogoAndCaption() {
		Assert.assertTrue(logo.isDisplayed());
		log("pass","Logo is succssfully displayed");
		Assert.assertEquals(getElementText(caption), prop.getProperty("caption"));
		log("pass","Caption is displayed as expected");
	}
	
	public void verifyLoginPageHeader() {
		Assert.assertEquals(getElementText(loginPageHeader), prop.getProperty("loginHeader"));
		log("pass","Application Login Page Header is Displayed Correctly");
	}
	
	public void enterUsernameAndPassword(String user, String pass) {
		enterInfo(usernameTxtb,user);
		enterInfo(passwordTxtb,pass);
		log("info","Username and Password entered");
	}
	
	public void clickOnLoginAndVerifyLoginIsSuccessful() {
		clickOnElement(loginBtn);
		waitForElement(accountOverviewPageHeader,10);
		log("pass","Application Login is Successful");
	}
	
	public void getRegistrationPage() {
		clickOnElement(registrationLink);
		log("pass","Clicked on Registration link Successfully");
		waitForElement(registrationPageHeader,10);
		log("pass","Registration page launched successfully");

	}
	
	public void getForgotLoginPage() {
		clickOnElement(forgotLoginLink);
		log("pass","Clicked on Forgot Login Info link Successfully");
		waitForElement(forgotLoginPageHeader,10);
		log("pass","Forgot login info page launched successfully");

	}
	
	public static LoginPageActions getLoginPage() {
		return PageFactory.initElements(new WebDriverClass().getDriver(), LoginPageActions.class);
	}

}

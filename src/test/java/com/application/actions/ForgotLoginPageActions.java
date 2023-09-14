package com.application.actions;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.elements.ForgotLoginPageElements;
import com.framework.webdriver.WebDriverClass;

public class ForgotLoginPageActions extends ForgotLoginPageElements{

	public void verifyForgotLoginPageHeader() {
		Assert.assertEquals(getElementText(forgotPassPageTitle),"Customer Lookup");
		log("pass", "Application Forgot Login Info page header is as expected");
	}
	
	public static ForgotLoginPageActions getForgotLoginPage() {
		return PageFactory.initElements(new WebDriverClass().getDriver(), ForgotLoginPageActions.class);
	}

}

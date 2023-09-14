package com.application.actions;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.elements.RegistrationPageElements;
import com.framework.webdriver.WebDriverClass;

public class RegistrationPageActions extends RegistrationPageElements{
	
	public void verifyRegistrationPageHeader() {
		Assert.assertEquals(getElementText(title),"Signing up is easy!" );
		log("pass", "Application registration page header is as expected");
	}

	public static RegistrationPageActions getRegisterPage() {
		return PageFactory.initElements(new WebDriverClass().getDriver(), RegistrationPageActions.class);
	}

}

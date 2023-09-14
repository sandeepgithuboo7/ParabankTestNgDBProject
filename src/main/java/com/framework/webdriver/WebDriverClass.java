package com.framework.webdriver;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.framework.reports.ReportsClass;
import com.framework.utilities.ReadExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverClass extends ReportsClass{

	// All the common methods to handle browser session
	static WebDriver driver=null;

	@BeforeMethod(alwaysRun = true)
	@Parameters(value = "browser")
	public void setupBrowser(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardownBrowser() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	@DataProvider(name="testdata")
	public String [][] testdata(Method method) {
		System.out.println(method.getName());
		String [][] data = ReadExcel.readData("TestData.xlsx", method.getName());
		return data;
	}
}

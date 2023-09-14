package com.framework.reports;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportsClass {
	
	public static ExtentHtmlReporter htmlreport = null;
	public static ExtentReports extent = null;
	public static ExtentTest logger = null;
	
	@BeforeSuite(alwaysRun=true)
	public static void setupReport() {
		htmlreport = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\AutomationReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		extent.setSystemInfo("Project Name", "Parabank");
		extent.setSystemInfo("Developer", "Bharath");
	}
	
	public static void startReporting(String testcase) {
		logger = extent.createTest(testcase);
	}
	
	@AfterSuite(alwaysRun=true)
	public static void stopReporting() {
		extent.flush();
	}
	

}

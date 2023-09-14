package com.framework.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.commons.WebCommons;
import com.framework.reports.ReportsClass;


public class TestListener extends ReportsClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		startReporting(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.pass("Test Execution is successful for "+result.getMethod().getMethodName());
		stopReporting();
	}

	public void onTestFailure(ITestResult result) {
		logger.fail("Test Execution is failed for "+result.getMethod().getMethodName());
		logger.fail(result.getThrowable().getMessage());
		try {
			logger.addScreenCaptureFromPath( new WebCommons().takeScreenshotOfWindow(result.getMethod().getMethodName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		stopReporting();
	}

	public void onTestSkipped(ITestResult result) {
		logger.skip("Test Execution is Skipped for "+result.getMethod().getMethodName());
		try {
			logger.addScreenCaptureFromPath( new WebCommons().takeScreenshotOfWindow(result.getMethod().getMethodName()));
		} catch (IOException e) {
			e.printStackTrace();
		}		stopReporting();
	}

}


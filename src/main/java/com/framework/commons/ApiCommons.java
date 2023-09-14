package com.framework.commons;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.framework.reports.ReportsClass;

import io.restassured.response.Response;

public class ApiCommons extends ReportsClass {

	// Print custom message in report
	public void log(String status, String message) {
		if (status.equalsIgnoreCase("pass")) {
			ReportsClass.logger.pass(message);
		} else if (status.equalsIgnoreCase("fail")) {
			ReportsClass.logger.fail(message);
		} else if (status.equalsIgnoreCase("warning")) {
			ReportsClass.logger.warning(message);
		} else if (status.equalsIgnoreCase("info")) {
			ReportsClass.logger.info(message);
		}
	}

	public void verifyStatusCode(Response response, int expCode) {
		int actualCode = response.getStatusCode();
		Assert.assertEquals(actualCode, expCode);
		log("pass","Status code is matching");
	}
	
	public void verifyStatusMessage(Response response, String expStatus) {
		String actualStatus = response.getStatusLine();
		Assert.assertTrue(actualStatus.contains(expStatus));
		log("pass","Status message is matching");
	}
	
	public void verifyResponseTime(Response response, long expTime) {
		long actualTime = response.getTimeIn(TimeUnit.SECONDS);
		Assert.assertTrue(actualTime<=expTime);
		log("pass","Response Time is as Expected");
	}
	
	public void verifyResponseBody(Response response, String key, String expValue) {
		String actualValue = response.getBody().jsonPath().getString(key);
		Assert.assertEquals(actualValue, expValue);
		log("pass","Response Body Parameter is matching for "+key);
	}
	
	public void verifyResponseHeaders(Response response, String headerName, String expValue) {
		String actualValue = response.getHeader(headerName);
		Assert.assertEquals(actualValue, expValue);
		log("pass","Response Header Parameter is matching for "+headerName);
	}

}

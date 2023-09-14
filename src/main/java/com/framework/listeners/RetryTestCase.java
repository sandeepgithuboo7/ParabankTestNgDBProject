package com.framework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTestCase implements IRetryAnalyzer{
	
	int count =0;
	int maxRetryCount = 2;

	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
			if(count<maxRetryCount) {
				count++;
				return true;
			}
		}		
		
		return false;
	}

}

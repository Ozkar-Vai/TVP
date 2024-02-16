package com.perfecto.stepdefinition;

import org.testng.ITestResult;
import com.perfecto.reportium.test.result.TestResult;
import com.perfecto.reportium.test.result.TestResultFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks{
    CommonSteps bu;
    
    public Hooks(CommonSteps bu) {
		this.bu = bu;
    }
    
	//@Before
	public void beforeMethod() {  
		System.out.println("Script Execution started");
		
	} 
	
	//@After
	public void afterMethod(ITestResult result) {
		//STOP TEST
		System.out.println("After method to conclude report...");

		TestResult testResult = null;
		if(result.getStatus() == result.SUCCESS) {
			testResult = TestResultFactory.createSuccess();
		}
		else if (result.getStatus() == result.FAILURE) {
			testResult = TestResultFactory.createFailure(result.getThrowable());
		}

		bu.getDriver().close();
		bu.getDriver().quit();
		bu.getReportiumClient().testStop(testResult);
		// Retrieve the URL to the DigitalZoom Report
		String reportURL = bu.getReportiumClient().getReportUrl();
		System.out.println(reportURL);
		
	}

}

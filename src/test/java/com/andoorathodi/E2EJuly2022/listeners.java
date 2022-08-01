package com.andoorathodi.E2EJuly2022;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReport;
import resources.base;

public class listeners extends base implements ITestListener{
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public Logger log = LogManager.getLogger(listeners.class.getName());
	ExtentReports extent =ExtentReport.getReportObjecgt();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	 log.info("TEST STARTED");
	 test = extent.createTest(result.getMethod().getMethodName());
	 extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
		 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		
		try {
			driver= (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String methodName = result.getMethod().getMethodName();
		
		
		try {
			String destinationFile = getScreenshot(methodName, driver);
			extentTest.get().addScreenCaptureFromPath(destinationFile, methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 log.error("TEST failed "+methodName);
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		 
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
 extent.flush();
	}

}

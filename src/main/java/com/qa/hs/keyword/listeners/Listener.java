package com.qa.hs.keyword.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.hs.keyword.base.Base;
import com.qa.hs.keyword.reporters.ExtentReporterConfig;
import com.qa.hs.tests.LoginTest;

public class Listener extends LoginTest implements ITestListener{
	
	ExtentReports report =  ExtentReporterConfig.configureReporter();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = report.createTest(result.getMethod().getMethodName());
		log.info("TEST STARTED : "+result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS,"Test Passed");
		log.info("TEST PASSED : "+result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		// TODO Auto-generated method stub
		try {
			String methodName = result.getMethod().getMethodName();
			log.error("TEST FAILED : "+methodName);
			//WebDriver dr = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			//System.out.println("=============== PARMS SENT  ================" +methodName+ "==="+driver);
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(methodName),result.getMethod().getMethodName());
			
		} catch (IllegalArgumentException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("TEST FINISHED");
		report.flush();


	} 

}

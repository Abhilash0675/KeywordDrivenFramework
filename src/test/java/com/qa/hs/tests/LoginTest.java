package com.qa.hs.tests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.qa.hs.keyword.base.*;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.hs.keyword.base.Base;
import com.qa.hs.keyword.engine.KeyWordEngine;
/**
 * 
 * AUTHOR : ABHILASH 
 *
 */
public class LoginTest {
	
	public KeyWordEngine keyWordEngine;
	public Base base;
	public Properties prop;
	public static WebDriver driver;
	public static Logger log;
	public ExtentReports report;

	
	@BeforeTest
	public void start() {
		base = new Base();
		prop = base.init_properties();
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = base.init_driver(prop.getProperty("browser"));
		log.debug("driver initiated");
//		System.out.println("===DRIVER in BEFORE TEST ===="+driver);
//		String path = System.getProperty("user.dir")+"/reports/index.html";
//		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//		reporter.config().setReportName("Avesdo Automation Report");
//		reporter.config().setDocumentTitle("Test Results");
//		report = new ExtentReports();
//		report.attachReporter(reporter);
		driver.manage().deleteAllCookies();
		log.info("cookies deleted");
		driver.manage().window().maximize();
		log.error("window maximized");
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
		log.fatal("initialization completed");
		
	}
	
	@Test (priority = 0)
	public void loginTest() throws InterruptedException{
		//report.createTest("LogIn Test");
		keyWordEngine = new KeyWordEngine();
		keyWordEngine.startExecution("login");
		Thread.sleep(2000);
		//report.flush();
		//done

	}
	

	
	@AfterTest
	public void end() {
		driver.manage().deleteAllCookies();
		driver.close();
	}
	
	@AfterSuite
	public void quit() {
		driver.quit();
	}
	
	public String getScreenShotPath(String methodName) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"/reports/"+methodName+".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return destination;
	}


	
	
	

}

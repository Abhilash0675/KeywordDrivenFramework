package com.qa.hs.tests;
//import com.qa.hs.keyword.base.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.qa.hs.keyword.base.Base;
import com.qa.hs.keyword.engine.KeyWordEngine;
import org.apache.logging.log4j.Logger;

/**
 * 
 * AUTHOR : ABHILASH 
 *
 */
public class BaseClass {
	
	public KeyWordEngine keyWordEngine;
	public Base base;
	public Properties prop;
	public static WebDriver driver;
	public static Logger log;
	public ExtentReports report;



	@BeforeSuite
	public void first() {
		try {
			FileUtils.cleanDirectory(new File(System.getProperty("user.dir")+"/reports/"));
			FileUtils.cleanDirectory(new File(System.getProperty("user.dir")+"/logs/"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeTest
	public void start() {
		
		base = new Base();
		prop = base.init_properties();
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = base.init_driver(prop.getProperty("browser"));
		log.info("driver initiated");
		
		driver.manage().deleteAllCookies();
		log.info("cookies deleted");
		driver.manage().window().maximize();
		log.info("window maximized");
		log.info("initialization completed");
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


}

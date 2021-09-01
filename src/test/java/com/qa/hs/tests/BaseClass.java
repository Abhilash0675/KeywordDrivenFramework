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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.hs.keyword.base.Base;
import com.qa.hs.keyword.engine.KeyWordEngine;
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

	@BeforeSuite
	public void first() {

	}
	
	@BeforeTest
	public void start() {
		
		base = new Base();
		prop = base.init_properties();
		driver = base.init_driver(prop.getProperty("browser"));
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
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

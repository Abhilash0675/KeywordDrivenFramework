package com.qa.hs.tests;
import com.qa.hs.keyword.base.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


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
	public WebDriver driver;

	
	@BeforeTest
	public void start() {
		base = new Base();
		prop = base.init_properties();
		driver = base.init_driver(prop.getProperty("browser"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
		
	}
	
	@Test (priority = 0)
	public void loginTest() throws InterruptedException{
		keyWordEngine = new KeyWordEngine(driver);
		keyWordEngine.startExecution("login");
		Thread.sleep(2000);
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
	

	
	
	

}

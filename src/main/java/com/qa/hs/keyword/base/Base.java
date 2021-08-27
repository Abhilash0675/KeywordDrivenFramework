package com.qa.hs.keyword.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * 
 * AUTHOR : ABHILASH 
 *
 */
public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(String browserName){
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverPath"));
			if(prop.getProperty("headless").equals("yes")){
				//headless mode:
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			}else{
				driver = new ChromeDriver();
			}
		} 
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	public Properties init_properties(){
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("/home/naveen/git/AvesdoAutomation/src/main/java/com/qa/hs/keyword/config/config.properties");
//			FileInputStream ip = new FileInputStream("C:\\selenium-automation\\KeywordDrivenFramework-master\\src\\main\\java\\com\\qa\\hs\\keyword\\config\\config.properties");
	
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
//	public String getScreenShotPath(String methodName, WebDriver dr) {
//		TakesScreenshot ts = (TakesScreenshot)dr;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		String destination = System.getenv("user.dir")+"/reports/"+methodName+".png";
//		try {
//			FileUtils.copyFile(source, new File(destination));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("=============== screenshot path  ================"+destination);
//
//		return destination;
//	}
	
	
	
	

}

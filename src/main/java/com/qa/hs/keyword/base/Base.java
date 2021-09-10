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
			//System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverPath"));
			//String path = "./resources/chromedriver";
			//String path = System.getProperty("user.dir")+"/resources/chromedriver";
			//System.out.println("************"+path+"*******************************");
			
			//System.setProperty("webdriver.chrome.driver","/home/naveen/git/AvesdoAutomation/resources/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriverPath"));

			//System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriverPath"));
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

			String extension = "/src/main/java/com/qa/hs/keyword/config/config.properties";
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+extension);
//			FileInputStream ip = new FileInputStream("C:\\selenium-automation\\KeywordDrivenFramework-master\\src\\main\\java\\com\\qa\\hs\\keyword\\config\\config.properties");
	
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	
	
	
	

}
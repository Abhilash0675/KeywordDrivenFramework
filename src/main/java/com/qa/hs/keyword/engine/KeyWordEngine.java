package com.qa.hs.keyword.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hs.keyword.base.Base;
import com.qa.hs.tests.LoginTest;

/**
 * 
 * AUTHOR : ABHILASH 
 *
 */
public class KeyWordEngine extends LoginTest {
	
//	public KeyWordEngine(WebDriver driver){
//		this.driver=driver;
//	}

	//public WebDriver driver;
	public Properties prop;

	public static Workbook book;
	public static Sheet sheet;

	public Base base;
	public WebElement element;
	

	public String SCENARIO_SHEET_PATH = "";

	public void startExecution(String sheetName) throws InterruptedException {
		
		//WebDriverWait wait = new WebDriverWait(driver,900);
		base = new Base();
		prop = base.init_properties();
		SCENARIO_SHEET_PATH = prop.getProperty("scenarioSheetPath");

		FileInputStream file = null;
		try {
			file = new FileInputStream(SCENARIO_SHEET_PATH);
			//System.out.println("------------ able to acccess file ---------");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		System.out.println(" *********** accessed *************"+sheetName);
		int k = 0;
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			//try {
			//System.out.println("ITERATION ------------- i: "+i);
			//System.out.println("TOTAL ROWS ---- : "+sheet.getLastRowNum());
				String testStep = sheet.getRow(i+1).getCell(k).toString().trim();
				String locatorType = sheet.getRow(i + 1).getCell(k + 1).toString().trim();
				String locatorValue = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
				String action = sheet.getRow(i + 1).getCell(k + 3).toString().trim();
			//	System.out.println(" *********** action ************* : "+action);
				String value = sheet.getRow(i + 1).getCell(k + 4).toString().trim();
				//System.out.println(" *********** value ************* : "+value);


				switch (action) {

				case "enter url":
//					System.out.println(" *********** entered got url ************* : "+value);
//					driver.get(value);
//					System.out.println(" *********** exit got url ************* : "+value);
					if (value.isEmpty() || value.equals("NA")) {
						driver.get(prop.getProperty("url"));
						log.info("Action Performed : "+testStep);
						//System.out.println(" *********** got url ************* : "+value);
					} else {
						driver.get(value);
						log.info("Action Performed : "+testStep);
						//System.out.println(" *********** got url ************* : "+value);
						//Thread.sleep(2000);
					}
					break;
				
				//case "enter search item":
					

				case "quit":
					driver.quit();
					break;
				default:
					break;
				}

				switch (locatorType) {
				case "scroll":
					Actions actions = new Actions(driver);
					actions.moveToElement(driver.findElement(By.xpath(locatorValue)));
					actions.perform();
					Thread.sleep(5000);
					break;
				case "wait":
					//System.out.println("++++++++++++++++++++++++++++++++++++++++++");
					Thread.sleep(30000);
					//System.out.println("===========================================");
					break;
				case "tab":
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(tabs.get(1));
					System.out.println("switched to second tab======================");
					Thread.sleep(1000);
					break;
					
				case "id":
					element = driver.findElement(By.id(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						element.clear();
						element.sendKeys(value);
						log.info("Action Performed : "+testStep);
					} else if (action.equalsIgnoreCase("click")) {
						element.click();
						log.info("Action Performed : "+testStep);
					} else if (action.equalsIgnoreCase("isDisplayed")) {
						element.isDisplayed();
						log.info("Action Performed : "+testStep);
					} else if (action.equalsIgnoreCase("getText")) {
						String elementText = element.getText();
						log.info("Action Performed : "+testStep);
					//	System.out.println("text from element : " + elementText);
					}
					locatorType = null;
					break;

				case "name":
					element = driver.findElement(By.name(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						element.click();
					} else if (action.equalsIgnoreCase("isDisplayed")) {
						element.isDisplayed();
					} else if (action.equalsIgnoreCase("getText")) {
						String elementText = element.getText();
						//System.out.println("text from element : " + elementText);
					}
					locatorType = null;
					break;

				case "xpath":
//					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locatorValue))));
//					System.out.println(" WAITED TILL ELEMENT FOUND");
					element = driver.findElement(By.xpath(locatorValue));
					//System.out.println("ELEMENT FOUND  ---"+element);
					if (action.equalsIgnoreCase("sendkeys")) {
						element.clear();
						element.sendKeys(value);
						log.info("Action Performed : "+testStep);
						Thread.sleep(1000);
					} else if (action.equalsIgnoreCase("click")) {
						//wait.until(ExpectedConditions.elementToBeClickable(element));
//						if(value.equals("wait")) {
//							System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//							wait.until(ExpectedConditions.visibilityOf(element));
//						}
						element.click();
						log.info("Action Performed : "+testStep);
						Thread.sleep(5000);
					} else if (action.equalsIgnoreCase("isDisplayed")) {
						element.isDisplayed();
						log.info("Action Performed : "+testStep);
					} else if (action.equalsIgnoreCase("getText")) {
						String elementText = element.getText();
						log.info("Action Performed : "+testStep);
					} else if (action.equalsIgnoreCase("mat select")) {
						element.click();
						Thread.sleep(2000);
						driver.findElement(By.xpath(value)).click();
						Thread.sleep(2000);
						log.info("Action Performed : "+testStep);

					}else if (action.equalsIgnoreCase("select")) {
						Select dropdodropwn = new Select(element);
						dropdodropwn.deselectByVisibleText(value);
						Thread.sleep(2000);
						log.info("Action Performed : "+testStep);

					}
					
					locatorType = null;
					break;

				case "cssSelector":
					element = driver.findElement(By.cssSelector(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						element.click();
						//Thread.sleep(5000);
					} else if (action.equalsIgnoreCase("isDisplayed")) {
						element.isDisplayed();
					} else if (action.equalsIgnoreCase("getText")) {
						String elementText = element.getText();
						//System.out.println("text from element : " + elementText);
					}
					locatorType = null;
					break;

				case "className":
					element = driver.findElement(By.className(locatorValue));
					if (action.equalsIgnoreCase("sendkeys")) {
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						element.click();
						//Thread.sleep(5000);
					} else if (action.equalsIgnoreCase("isDisplayed")) {
						element.isDisplayed();
					} else if (action.equalsIgnoreCase("getText")) {
						String elementText = element.getText();
						//System.out.println("text from element : " + elementText);
					}
					locatorType = null;
					break;

				case "linkText":
					element = driver.findElement(By.linkText(locatorValue));
					element.click();
					locatorType = null;
					break;

				case "partialLinkText":
					element = driver.findElement(By.partialLinkText(locatorValue));
					element.click();
					locatorType = null;
					break;

				default:
					break;
				}

//			} catch (Exception e) {
//
//			}

		}

	}
}

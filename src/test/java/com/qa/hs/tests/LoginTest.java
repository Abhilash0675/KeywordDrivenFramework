package com.qa.hs.tests;

import org.testng.annotations.Test;

import com.qa.hs.keyword.engine.KeyWordEngine;

public class LoginTest extends BaseClass{
	
	@Test (priority = 0)
	public void loginTest() throws InterruptedException{
		keyWordEngine = new KeyWordEngine();		
		keyWordEngine.startExecution("login");
		//Thread.sleep(2000);
		//done -
	}

}

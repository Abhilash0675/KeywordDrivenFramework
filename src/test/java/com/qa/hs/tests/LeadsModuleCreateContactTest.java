package com.qa.hs.tests;

import org.testng.annotations.Test;

import com.qa.hs.keyword.engine.KeyWordEngine;

public class LeadsModuleCreateContactTest extends BaseClass{
	
	@Test (priority = 1)
	public void leadsModuleCreateContactTest() throws InterruptedException{
		keyWordEngine = new KeyWordEngine();		
		keyWordEngine.startExecution("create_contact_form");
	}
	
}

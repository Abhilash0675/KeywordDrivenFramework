package com.qa.hs.tests;

import org.testng.annotations.Test;

import com.qa.hs.keyword.engine.KeyWordEngine;

public class LeadsModuleEditFormTest extends BaseClass {

	@Test (priority = 1)
	public void leadsTest() throws InterruptedException{
		keyWordEngine = new KeyWordEngine();		
		keyWordEngine.startExecution("edit_form");
	}
	
}

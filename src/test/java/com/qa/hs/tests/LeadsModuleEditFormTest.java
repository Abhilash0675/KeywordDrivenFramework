package com.qa.hs.tests;

import org.testng.annotations.Test;

public class LeadsModuleEditFormTest extends BaseClass {

	@Test (priority = 1)
	public void leadsTest() throws InterruptedException{
		keyWordEngine.startExecution("edit_form");
		Thread.sleep(2000);
	}
	
}

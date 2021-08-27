package com.qa.hs.tests;

import org.testng.annotations.Test;

public class LeadsModuleEditFormTest extends LoginTest {

	@Test (priority = 1)
	public void leadsTest() throws InterruptedException{
		//report.createTest("Leads Module Edit Form Test");
		keyWordEngine.startExecution("edit_form");
		Thread.sleep(2000);
		//report.flush();
		//done
	}
	
}

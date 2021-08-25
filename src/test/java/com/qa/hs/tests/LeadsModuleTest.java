package com.qa.hs.tests;

import org.testng.annotations.Test;

public class LeadsModuleTest extends LoginTest{
	

	
	@Test (priority = 1)
	public void leadsTest() throws InterruptedException{
		keyWordEngine.startExecution("create_contact_form");
		Thread.sleep(2000);
		//done
	}
	

}

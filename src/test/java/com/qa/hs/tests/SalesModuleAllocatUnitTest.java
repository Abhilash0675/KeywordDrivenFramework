package com.qa.hs.tests;

import org.testng.annotations.Test;

public class SalesModuleAllocatUnitTest extends LoginTest{
	
	@Test (priority = 1)
	public void salesModuleAllocatUnitTest() throws InterruptedException{
		keyWordEngine.startExecution("allocation");
		Thread.sleep(2000);
	}

}

package com.qa.hs.tests;

import org.testng.annotations.Test;

import com.qa.hs.keyword.engine.KeyWordEngine;

public class SalesModuleAllocatUnitIndividualRealtorTest extends BaseClass{
	
	@Test (priority = 1)
	public void salesModuleAllocatUnitIndividualRealtorTest() throws InterruptedException{
		keyWordEngine = new KeyWordEngine();		
		keyWordEngine.startExecution("allocation_individual_realtor");
	}

}

package com.qa.hs.tests;

import org.testng.annotations.Test;

import com.qa.hs.keyword.engine.KeyWordEngine;

public class SalesModuleAllocatUnitGroupRealtorsTest extends BaseClass {
	@Test (priority = 1)
	public void salesModuleAllocatUnitGroupRealtorsTest() throws InterruptedException{
		keyWordEngine = new KeyWordEngine();		
		keyWordEngine.startExecution("allocation_group_realtors");
	}
}

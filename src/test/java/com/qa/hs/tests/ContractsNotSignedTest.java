package com.qa.hs.tests;

import org.testng.annotations.Test;

import com.qa.hs.keyword.engine.KeyWordEngine;

public class ContractsNotSignedTest extends BaseClass{
	
	@Test (priority = 1)
	public void contractsNotSignedTest() throws InterruptedException{
		keyWordEngine = new KeyWordEngine();		
		keyWordEngine.startExecution("contracts");
	}
}

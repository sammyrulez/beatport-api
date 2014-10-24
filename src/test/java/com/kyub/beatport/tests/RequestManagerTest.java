package com.kyub.beatport.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kyub.beatport.api.RequestManager;

public class RequestManagerTest {
	
	@Test
	public void testGet() throws Exception {
		
		RequestManager reqManager = new RequestManager();
		
		assertNotNull(reqManager.sendGet("http://www.google.com", null));
		
		assertNotNull(reqManager.sendGet("http://www.google.com", ""));
		
		assertNotNull(reqManager.sendGet("http://www.google.com", "q=cute%20kittens"));
		
		
	}

}

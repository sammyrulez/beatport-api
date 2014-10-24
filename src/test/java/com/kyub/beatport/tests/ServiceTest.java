package com.kyub.beatport.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.scribe.model.Token;

import com.kyub.beatport.api.BeatportService;
import com.kyub.beatport.api.auth.BeatportAuthService;
import com.kyub.beatport.api.auth.OauthHolder;
import static org.mockito.Mockito.*;

public class ServiceTest {
	
	
	
	@Test
	public void testAuth() throws Exception {
		
		final String apiKey = System.getProperty("apikey");
		if(apiKey != null){
			BeatportAuthService service = new BeatportAuthService(apiKey, System.getProperty("apiSecret"));
			assertNotNull(service.getAuthorizationUrl());
			/*final OauthHolder auth = service.auth(,);
			assertNotNull(auth.getToken());*/
		}
	}
	
	@Test
	public void testConstructor() throws Exception {
		Token token = mock(Token.class);
		BeatportService service = new BeatportService(token);
		assertNotNull(service);
	}
	
	@Test(expected = Exception.class)
	public void testFailsConstructor() throws Exception {
		new BeatportService("IMPROPERVALUE");
	}

}

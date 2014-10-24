package com.kyub.beatport.tests;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.scribe.model.Token;

import com.kyub.beatport.api.ApiQuery;
import com.kyub.beatport.api.BeatportService;
import com.kyub.beatport.api.RequestManager;
import com.kyub.beatport.api.auth.AuthorizationKey;
import com.kyub.beatport.api.auth.BeatportAuthService;
import com.kyub.beatport.api.auth.OauthHolder;
import static org.mockito.Mockito.*;

public class ServiceTest {
	
	
	
	@Test
	public void testAuth() throws Exception {
		
		final String apiKey = System.getProperty("apikey");
		if(apiKey != null){
			final String apiSecret = System.getProperty("apiSecret");
			final BeatportAuthService authService = new BeatportAuthService(apiKey, apiSecret);
			final AuthorizationKey authorizationKey = authService.getAuthorizationKey();
			assertNotNull(authorizationKey);
			assertNotNull(authorizationKey.getAuthorizationUrl());
			String code = "123";
			final OauthHolder auth = authService.auth(code ,authorizationKey);
			assertNotNull(auth.getToken());
		}
	}
	
	@Test
	public void testConstructor() throws Exception {
		Token token = mock(Token.class);
		final BeatportService service = new BeatportService(token);
		assertNotNull(service);
	}
	
	@Test(expected = Exception.class)
	public void testFailsConstructor() throws Exception {
		new BeatportService("IMPROPERVALUE");
	}
	
	@Test
	public void testArtistsQuery() throws Exception {
		Token token = mock(Token.class);
		final RequestManager reqManagerMock = mock(RequestManager.class);
		final BeatportService service = new BeatportServiceAccessor(token,reqManagerMock);
		ApiQuery q = new ApiQuery();
		final Map<String, Object> artists = service.getArtists(q );
	}

}

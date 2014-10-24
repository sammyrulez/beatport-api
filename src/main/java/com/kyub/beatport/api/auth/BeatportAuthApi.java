package com.kyub.beatport.api.auth;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

public class BeatportAuthApi extends DefaultApi10a {
	
	 private static final String AUTHORIZATION_URL = "https://oauth-api.beatport.com/identity/1/oauth/authorize?oauth_token=%s";
	 private static final String BASE_URL = "https://oauth-api.beatport.com/identity/1/oauth/access-token";
	 private static final String REQUEST_TOKEN_URL = "https://oauth-api.beatport.com/identity/1/oauth/request-token";

	@Override
	public String getAccessTokenEndpoint() {
		
		return BASE_URL;
	}

	@Override
	public String getAuthorizationUrl(Token arg0) {		
		return AUTHORIZATION_URL;
	}

	@Override
	public String getRequestTokenEndpoint() {
		
		return REQUEST_TOKEN_URL;
	}

}

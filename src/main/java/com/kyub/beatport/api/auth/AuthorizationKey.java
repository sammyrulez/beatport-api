package com.kyub.beatport.api.auth;

import org.scribe.model.Token;

public class AuthorizationKey {
	
	private final String authorizationUrl;
	
	private final Token requestToken ;
	
	

	protected AuthorizationKey(String authorizationUrl, Token requestToken) {
		super();
		this.authorizationUrl = authorizationUrl;
		this.requestToken = requestToken;
	}

	public String getAuthorizationUrl() {
		return authorizationUrl;
	}

	protected Token getRequestToken() {
		return requestToken;
	}

	
	
	

	
	
}

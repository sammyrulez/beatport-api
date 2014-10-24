package com.kyub.beatport.api.auth;

import java.io.Serializable;

import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

public class OauthHolder {
	
	private Token token;
	
	private OAuthService serviceRef;

	protected OauthHolder(Token token2, OAuthService serviceRef) {
		super();
		this.token = token2;
		this.serviceRef = serviceRef;
	}

	public String getToken() {
		return token.getToken();
	}
	
	public String getSecret(){
		return token.getSecret();
	}

	protected OAuthService getServiceRef() {
		return serviceRef;
	}
	
	public Serializable persistableToken() {
		return token;
	}
	
	
	
	

}

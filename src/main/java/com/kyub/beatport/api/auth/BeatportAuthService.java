package com.kyub.beatport.api.auth;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

public class BeatportAuthService {
	
	final String apiKey;
	final String apiSecret;
	
	
	
	public BeatportAuthService(String apiKey, String apiSecret) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
	}


	public String getAuthorizationUrl() {
		final OAuthService service = buildService(apiKey, apiSecret);
		final Token requestToken = service.getRequestToken();
		final String authorizationUrl = service.getAuthorizationUrl(requestToken);
		return authorizationUrl;
	}
	
	
	public OauthHolder auth( String code, Token requestToken){
		final OAuthService service = buildService(apiKey, apiSecret);	
		 Verifier verifier = new Verifier(code);		 
		 Token accessToken = service.getAccessToken(requestToken, verifier);
		
		return new OauthHolder(accessToken, service);
	}

	private OAuthService buildService(final String apiKey, final String apiSecret) {
		final OAuthService service = new ServiceBuilder()
        .provider(BeatportAuthApi.class)
        .apiKey(apiKey)
        .apiSecret(apiSecret)
        .build();
		return service;
	}

}

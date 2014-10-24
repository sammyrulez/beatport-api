package com.kyub.beatport.api;

import java.io.Serializable;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.scribe.model.Token;

import com.kyub.beatport.api.auth.BeatportAuthService;

public class BeatportService {
	
	private Token token;
	
	private final ObjectMapper mapper = new ObjectMapper();
	
	private final static String API_URL = "https://oauth-api.beatport.com/catalog/3/";
	
	protected RequestManager requestManager = new RequestManager();
	
	public BeatportService(Serializable token) throws Exception  {
		if(token instanceof Token){
			this.token = (Token) token;
		}else{
			throw new Exception("Invalid token");
		}
	}
	
	public Map<String,Object> getArtists(ApiQuery query) throws Exception{
		final String response = requestManager.sendGet(API_URL+"artists/", query.buildFacetParams());
		return mapper.readValue(response, Map.class);		
	}
	
	public Map<String,Object> getArtist(String id) throws Exception{
		final String response = requestManager.sendGet(API_URL+"artists/detail","id="+id);
		return mapper.readValue(response, Map.class);		
	}
	
	
	
	
	

}

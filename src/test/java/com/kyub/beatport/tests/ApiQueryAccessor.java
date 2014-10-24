package com.kyub.beatport.tests;

import com.kyub.beatport.api.ApiQuery;

public class ApiQueryAccessor extends ApiQuery {
	
	public String extortFacet() {
		return this.buildFacetParams();
	}

}

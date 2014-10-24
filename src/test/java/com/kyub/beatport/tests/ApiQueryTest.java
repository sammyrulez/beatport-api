package com.kyub.beatport.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kyub.beatport.api.ApiQuery;

public class ApiQueryTest {
	
	@Test
	public void testFacetGeneration() throws Exception {
		ApiQueryAccessor q = (ApiQueryAccessor) new ApiQueryAccessor().addFilter("name", "gabriponte");
		assertEquals("facets=name%3Agabriponte",q.extortFacet());
		ApiQueryAccessor empty = (ApiQueryAccessor) new ApiQueryAccessor();
		assertEquals("",empty.extortFacet());
	}

}

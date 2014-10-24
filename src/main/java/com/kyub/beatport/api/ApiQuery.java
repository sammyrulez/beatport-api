package com.kyub.beatport.api;

import java.util.HashMap;
import java.util.Set;

public class ApiQuery {

	public HashMap<String, Object> facets = new HashMap<String, Object>();

	public Object getFilterValue(String field) {
		return facets.get(field);
	}

	public Set<String> getFilters() {
		return facets.keySet();
	}

	public ApiQuery addFilter(String field, Object value) {
		 facets.put(field, value);
		 return this;
	}

	public void removeFilter(Object field) {
		 facets.remove(field);
	}

	protected String buildFacetParams() {
		StringBuffer b = new StringBuffer();
		if (facets.size() > 0) {
			b.append("facets=");
			for (String k : facets.keySet()) {
				b.append(k + "%3A" + facets.get(k));
			}
		}
		return b.toString();
	}

}

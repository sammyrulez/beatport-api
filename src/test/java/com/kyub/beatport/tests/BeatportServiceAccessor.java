package com.kyub.beatport.tests;

import java.io.Serializable;

import com.kyub.beatport.api.BeatportService;
import com.kyub.beatport.api.RequestManager;

public class BeatportServiceAccessor extends BeatportService {

	public BeatportServiceAccessor(Serializable token,RequestManager manager) throws Exception {
		super(token);
		this.requestManager = manager;
	}

}

package com.michael.app.services;

import com.michael.app.beans.Origin;

public interface OriginService {
	Origin getOrigin(Integer id);
	void saveOrigin(Origin o);
	void deleteOrigin(Origin o);
}

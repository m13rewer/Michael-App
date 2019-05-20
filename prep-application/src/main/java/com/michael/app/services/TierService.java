package com.michael.app.services;

import com.michael.app.beans.Origin;
import com.michael.app.beans.Tier;

public interface TierService {
	Tier getTier(Integer id);
	void saveTier(Tier t);
	void deleteTier(Tier t);
}

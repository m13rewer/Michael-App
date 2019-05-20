package com.michael.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.michael.app.beans.Origin;
import com.michael.app.beans.Tier;
import com.michael.app.data.OriginRepository;
import com.michael.app.data.TierRepository;

@Service
public class TierServiceImpl implements TierService{
	@Autowired
	private TierRepository tr;

	public Tier getTier(Integer id) {
		return tr.getOne(id);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void saveTier(Tier t) {
		tr.save(t);
		//throw new RuntimeException();
	}

	public void deleteTier(Tier t) {
		tr.delete(t);
	}
}

package com.michael.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.michael.app.beans.Origin;
import com.michael.app.data.OriginRepository;

@Service
public class OriginServiceImpl implements OriginService{
	
	@Autowired
	private OriginRepository or;

	public Origin getOrigin(Integer id) {
		return or.getOne(id);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void saveOrigin(Origin o) {
		or.save(o);
		//throw new RuntimeException();
	}

	public void deleteOrigin(Origin o) {
		or.delete(o);
	}

}

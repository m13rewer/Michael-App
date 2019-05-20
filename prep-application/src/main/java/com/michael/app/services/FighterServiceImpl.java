package com.michael.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.michael.app.beans.Fighter;
import com.michael.app.beans.Origin;
import com.michael.app.beans.Tier;
import com.michael.app.data.FighterRepository;

@Service
@Transactional(readOnly=true)
public class FighterServiceImpl implements FighterService{
	@Autowired
	private FighterRepository fr;
	@Autowired
	private OriginService os;
	@Autowired
	private TierService ts;
	
	public Fighter getFighter(Integer id) {
		return fr.getOne(id);
	}

	public List<Fighter> getAll() {
		return fr.findAll();
	}

	@Transactional(readOnly=false)
	public void saveFighter(Fighter fighter) {
		fr.save(fighter);
	}

	@Transactional(readOnly=false)
	public void deleteFighter(Fighter fighter) {
		fr.delete(fighter);
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void createFighter() throws Exception {
		Origin o = new Origin();
		//o.setId(1);
		o.setName("Mario Bros.");
		
		Tier t = new Tier();
		t.setName("Mid");
		System.out.println("Before we call Tier service method");
		ts.saveTier(t);
		System.out.println("After we call Tier service method");
		
		
		Fighter f = new Fighter();
		System.out.println("Before we call Origin service method");
		os.saveOrigin(o);
		System.out.println("After we call Origin service method");
		
		f.setTier(ts.getTier(t.getId()));
		f.setOrigin(os.getOrigin(o.getId()));
		
		fr.save(f);
	}
	
	@Transactional(readOnly=false)
	public void updateFighter() {
		// TODO Auto-generated method stub
		
	}


}

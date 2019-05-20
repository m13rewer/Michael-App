package com.michael.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.michael.app.beans.Fighter;

@Service
public interface FighterService {
	Fighter getFighter(Integer id);
	List<Fighter> getAll();
	void saveFighter(Fighter fighter);
	void deleteFighter(Fighter fighter);
	 
	public void createFighter() throws Exception;
	public void updateFighter();

}

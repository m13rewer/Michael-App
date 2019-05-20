package com.michael.app.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michael.app.beans.Fighter;
import com.michael.app.beans.Origin;
import com.michael.app.beans.Tier;

@Repository
public interface FighterRepository extends JpaRepository<Fighter, Integer>{
	List<Fighter> findByName(String name);
	Fighter findByOrigin(Origin o);
	Fighter findByTier(Tier t);
	Fighter findByOriginId(Integer id);
	Fighter findByTierId(Integer id);
}

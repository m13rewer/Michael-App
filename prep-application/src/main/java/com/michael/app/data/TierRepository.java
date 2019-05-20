package com.michael.app.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.michael.app.beans.Tier;

@Repository
public interface TierRepository extends JpaRepository<Tier, Integer>{

}

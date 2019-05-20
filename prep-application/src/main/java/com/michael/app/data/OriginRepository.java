package com.michael.app.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.michael.app.beans.Origin;

@Repository
public interface OriginRepository extends JpaRepository<Origin, Integer> {

}

package com.cg.InHouseMarketPlace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.InHouseMarketPlace.model.Requirement;
@Repository
public interface RequirementRepository extends JpaRepository<Requirement,Integer>
{

	public List<Requirement> findByCategoryAndType(String category, String type);
	
	@Query("select r from Requirement r where req_id=?1")
	public Requirement findByRequirementId(int reqId);

}
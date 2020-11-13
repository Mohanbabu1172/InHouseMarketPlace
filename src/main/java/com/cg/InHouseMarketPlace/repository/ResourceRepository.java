package com.cg.InHouseMarketPlace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.InHouseMarketPlace.model.Resource;
@Repository
public interface ResourceRepository extends JpaRepository<Resource,Integer>{
	
	public List<Resource> findByCategoryAndType(String category, String type);
	
	@Query("select r from Resource r where emp_id=?1")
	public List<Resource> findByEmpId(int empId);
}

package com.cg.InHouseMarketPlace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.InHouseMarketPlace.model.Employee;
import com.cg.InHouseMarketPlace.model.Offer;
import com.cg.InHouseMarketPlace.model.Requirement;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	@Query("select o from Offer o where emp_id=?1")
	public List<Offer> findByEmpId(int empId);
	@Query("select r from Requirement r where emp_id=?1")
	public List<Requirement> findByempId(int empId);
}
package com.cg.InHouseMarketPlace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.InHouseMarketPlace.model.Employee;
import com.cg.InHouseMarketPlace.model.Offer;
import com.cg.InHouseMarketPlace.model.Proposal;
import com.cg.InHouseMarketPlace.model.Requirement;
import com.cg.InHouseMarketPlace.repository.EmployeeRepository;
import com.cg.InHouseMarketPlace.repository.OfferRepository;
import com.cg.InHouseMarketPlace.repository.ProposalRepository;
import com.cg.InHouseMarketPlace.repository.RequirementRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private OfferRepository offerRepository;
	@Autowired
	private RequirementRepository requirementRepository;
	@Autowired
	private ProposalRepository proposalRepository;


	/*
	 * Registering an employee
	 */
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}
	/*
	 * Updating an employee
	 */
	public Employee editEmployee(Employee employee) {
		if (employeeRepository.findById(employee.getEmpId()) != null) {
			return employeeRepository.save(employee);
		}

		else {
			return null;
		}
	}
	/*
	 * Get an employee by Id
	 */
	public Employee getEmployee(int empId) {
		return employeeRepository.findById(empId).orElse(new Employee());
	}
	/*
	 * update available offers by offer Id
	 */
	public Offer updateIsAvailable(int offerId) {
		
	Offer offer=offerRepository.findByOfferId(offerId);
	
	if(offer!=null && offer.isAvailable()==true)
	{
		return offer;		
	}
	else
		return new Offer();
	}
	/*
	 * update fulfilled Requirements by requirement Id
	 */
	public Requirement updateIsFulfilled(int reqId) {
		Requirement req=requirementRepository.findByRequirementId(reqId);
		
		if(req!=null && req.isFulfilled()==true)
		{
			return req;
			
		}
		else
			return new Requirement();
		}

	/*
	 * update accepted proposals by Proposal Id
	 */
	public Proposal updateIsAccepted(int propId) {
		Proposal prop=proposalRepository.findByProposalId(propId);
		
		if(prop!=null && prop.isAccepted()==true)
		{
			return prop;
			
		}
		else
			return new Proposal();
		}
	/*
	   * Get all offer by employee Id
	   */
	public List<Offer> getAllOffers(int empId) {
		return employeeRepository.findByEmpId(empId);
	}
	/*
	 * Get all requirements by employee Id
	 */
	public List<Requirement> getAllRequirements(int empId) {
		return employeeRepository.findByempId(empId);
		
	}
}
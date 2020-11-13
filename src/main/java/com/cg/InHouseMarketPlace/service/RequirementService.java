package com.cg.InHouseMarketPlace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.InHouseMarketPlace.model.Requirement;
import com.cg.InHouseMarketPlace.repository.RequirementRepository;

@Service
public class RequirementService {

	@Autowired
	private  RequirementRepository requirementRepository;
	
	/*
	 * adding requirement
	 */
	public Requirement addRequirement(Requirement requirement)
	{
		return requirementRepository.save(requirement);
	}

	/*
	 * updating requirement
	 */
	public Requirement editRequirement(Requirement requirement) 
	{
		if(requirementRepository.findById(requirement.getReqId())!=null) 
		{
			return requirementRepository.save(requirement);
		}
		else 
		   {
			   return null;
		   }
	}
	/*
	 * get all requirements by Id
	 */
	public Requirement getRequirement(int reqId)  
	{
		return requirementRepository.findById(reqId).orElse(new Requirement());
	}
	
	/*
	 * deleting requirement by requirement Id
	 */
	public Requirement removeRequirement(int reqId)
	{
		requirementRepository.deleteById(reqId);
		return null;
	}
	
	/*
	 * finding All requirements
	 */		
	public List<Requirement> getAllRequirements()
	{
		return (List<Requirement>) requirementRepository.findAll();
	}
	/*
	 * get all requirements by category and type
	 */
    public List<Requirement> getAllRequirements(String category, String type) 
    {
    	return requirementRepository.findByCategoryAndType(category, type);
    }
    
}
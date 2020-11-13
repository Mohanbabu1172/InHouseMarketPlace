package com.cg.InHouseMarketPlace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.InHouseMarketPlace.exception.InvalidRequirementException;
import com.cg.InHouseMarketPlace.model.Requirement;
import com.cg.InHouseMarketPlace.service.RequirementService;

@RestController
public class RequirementController {

	@Autowired
	private RequirementService requirementService;
	/*
	 * adding requirement
	 */
	@PostMapping("/addreq")
	public Requirement saveRequirement(@RequestBody Requirement requirement)
	{
		return requirementService.addRequirement(requirement);
	}
	/*
	 * updating requirement
	 */
	@PutMapping("/updatereq")
	public Requirement updateRequirement(@RequestBody Requirement requirement)
	{
		return requirementService.editRequirement(requirement);
	}
	/*
	 * finding All requirements
	 */
	@GetMapping("/findallreqs")
	public List<Requirement> findAllRequirements()
	{
		if(requirementService.getAllRequirements().isEmpty())
		{
			throw new InvalidRequirementException("No Records found");
		}
		return requirementService.getAllRequirements();
	}
	/*
	 * get all requirements by Id
	 */
	@GetMapping("/findreq/{reqId}")
	public ResponseEntity<Requirement> getRequirementById(@PathVariable int reqId){
		Requirement fetchedRequirement = requirementService.getRequirement(reqId);
		if(fetchedRequirement.getReqId()==0) {
			throw new InvalidRequirementException("No requirement found with id= : " + reqId);
		}
		else {
			return new ResponseEntity<Requirement>(fetchedRequirement,HttpStatus.OK);
		}
	}
	/*
	 * get all requirements by category and type
	 */
	@GetMapping("/getallrequirements")
	public List<Requirement> getAllRequirements(@RequestParam(value="category") String category,@RequestParam(value="type") String type)
	{
		return requirementService.getAllRequirements(category, type);
	}
	/*
	 * deleting requirement by requirement Id
	 */
	@DeleteMapping("/deletereq/{reqId}")
	public ResponseEntity<Requirement> deleteRequirement(@PathVariable int reqId ){
		Requirement isRequirementAvailable = requirementService.getRequirement(reqId);
		if(isRequirementAvailable.getReqId()==0) {
			throw new InvalidRequirementException("No requirement found with id : " + reqId);
		}
		else {
			requirementService.removeRequirement(reqId);
			return new ResponseEntity<Requirement>(HttpStatus.OK);
		}
	}
}
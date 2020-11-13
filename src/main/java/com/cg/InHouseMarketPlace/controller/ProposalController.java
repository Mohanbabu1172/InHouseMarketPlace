package com.cg.InHouseMarketPlace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.InHouseMarketPlace.exception.InvalidProposalException;
import com.cg.InHouseMarketPlace.model.Proposal;
import com.cg.InHouseMarketPlace.service.ProposalService;

@RestController
public class ProposalController {
	
	@Autowired
	private ProposalService proposalService;
	/*
	 * adding proposal
	 */
	@PostMapping("/addProposal")
	public ResponseEntity<Proposal> saveBook(@RequestBody Proposal prop){
		Proposal addedProposal = proposalService.addProposal(prop);		
		return new ResponseEntity<Proposal>(addedProposal, HttpStatus.OK);
	}
	/*
	 * updating proposal
	 */
	@PutMapping("/updateProposal")
	public Proposal editProposal(@RequestBody Proposal prop)
	{
		return proposalService.editProposal(prop);
	}
	/*
	 * get proposal by Id 
	 */
	@GetMapping("/proposalbyid/{propId}")
	public ResponseEntity<Proposal> getProposalById(@PathVariable int propId){
		Proposal fetchedProposal = proposalService.getProposal(propId);
		if(fetchedProposal.getPropId()==0) {
			throw new InvalidProposalException("No proposal found with id= : " + propId);
		}
		else {
			return new ResponseEntity<Proposal>(fetchedProposal,HttpStatus.OK);
		}
	}
	/*
	 * Delete proposal by Id
	 */
	@DeleteMapping("/delete/{propId}")
	public ResponseEntity<Proposal> deleteProposal(@PathVariable int propId ){
		Proposal isProposalAvailable = proposalService.getProposal(propId);
		if(isProposalAvailable.getPropId()==0) {
			throw new InvalidProposalException("No proposal found with id : " + propId);
		}
		else {
			proposalService.removeProposal(propId);
			return new ResponseEntity<Proposal>(HttpStatus.OK);
		}
	}
}
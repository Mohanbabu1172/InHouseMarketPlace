package com.cg.InHouseMarketPlace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.InHouseMarketPlace.model.Proposal;
import com.cg.InHouseMarketPlace.repository.ProposalRepository;

@Service
public class ProposalService {
	@Autowired
	private ProposalRepository proposalRepository;
	/*
	 * adding proposal
	 */
	public Proposal addProposal(Proposal prop) {
		return proposalRepository.save(prop);
	}
	/*
	 * updating proposal
	 */
	public Proposal editProposal(Proposal prop) {
		if(proposalRepository.findById(prop.getPropId())!=null) {
			return proposalRepository.save(prop);
		}
		else {
			return null;
		}
	}
	/*
	 * get proposal by Id 
	 */
	public Proposal getProposal(int propId)  {
		return proposalRepository.findById(propId).orElse(new Proposal());

	}
	/*
	 * Delete proposal by Id
	 */
	public Proposal removeProposal(int propId){
		Proposal deleteproposal= proposalRepository.findById(propId).orElse(new Proposal());

		 proposalRepository.deleteById(propId);
		 return deleteproposal;
	}
	
	public List<Proposal> getAllProposals() {
		return proposalRepository.findAll();

	}

}
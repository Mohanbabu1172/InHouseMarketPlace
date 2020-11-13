package com.cg.InHouseMarketPlace.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.InHouseMarketPlace.model.Employee;
import com.cg.InHouseMarketPlace.model.Proposal;
import com.cg.InHouseMarketPlace.model.Resource;
import com.cg.InHouseMarketPlace.repository.ProposalRepository;


@SpringBootTest
class ProposalServiceTest {

	@MockBean
	private ProposalRepository proposalRepository;
	@Autowired
	ProposalService proposalService;
	Employee emp=new Employee();
	Resource res=new Resource();
	Proposal proposal=new Proposal(10,"hii",2.0,LocalDate.now(),true,LocalDate.now(),res,emp);
	Proposal proposal2=new Proposal(12,"hik",3.0,LocalDate.now(),false,LocalDate.now(),res,emp);
	Proposal proposal3=new Proposal(14,"hio",2.0,LocalDate.now(),true,LocalDate.now(),res,emp);
	
	@Test
	public void testaddproposal()
	{
		when(proposalRepository.save(proposal)).thenReturn(proposal);
		assertEquals(proposal,proposalService.addProposal(proposal));
	}
	
	@Test
	public void testeditproposal()
	{
		when(proposalRepository.save(proposal)).thenReturn(proposal);
		when(proposalRepository.findById(proposal.getPropId())).thenReturn(Optional.of(proposal));
		assertEquals(proposal,proposalService.editProposal(proposal));
	}
	
	@Test
	public void testgetbyId()
	{
		when(proposalRepository.findById(proposal.getPropId())).thenReturn(Optional.of(proposal));
		assertEquals(proposal,proposalService.getProposal(proposal.getPropId()));
	}
	
	@Test
	public void testremoveproposal()
	{
		when(proposalRepository.findById(proposal.getPropId())).thenReturn(Optional.of(proposal));
		proposalService.removeProposal(proposal.getPropId());
		verify(proposalRepository,times(1)).deleteById(proposal.getPropId());
		
	}
	@Test
	public void testgetallproposalslist()
	{
		List <Proposal> proposalslist=new ArrayList <Proposal>();
		proposalslist.add(proposal);
		proposalslist.add(proposal2);
		proposalslist.add(proposal3);
		when(proposalRepository.findAll()).thenReturn(proposalslist);
		assertEquals(proposalslist.size(),proposalService.getAllProposals().size());
	}
}


































/*import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.InHouseMarketPlace.model.Employee;
import com.cg.InHouseMarketPlace.model.Proposal;
import com.cg.InHouseMarketPlace.model.Resource;


@ExtendWith(MockitoExtension.class)
class ProposalServiceTest {

	ProposalService proposalService=new ProposalService();
	Employee emp=new Employee();
	Resource res=new Resource();
	List <Proposal> proposalslist=new ArrayList <Proposal>();
	Proposal proposal=new Proposal(10,"hii",2.0,LocalDate.now(),true,LocalDate.now(),res,emp);
	Proposal proposal2=new Proposal(12,"hik",3.0,LocalDate.now(),false,LocalDate.now(),res,emp);
	Proposal proposal3=new Proposal(14,"hio",2.0,LocalDate.now(),true,LocalDate.now(),res,emp);
		
		@Test
		public void testaddproposal()
		{
			when(proposalService.addProposal(proposal)).thenReturn(proposal);
			assertEquals(proposal,proposalService.addProposal(proposal));
		}
		
		@Test
		public void testeditproposal()
		{
			when(proposalService.editProposal(proposal)).thenReturn(proposal);
			assertEquals(proposal,proposalService.editProposal(proposal));
		}
		
		@Test
		public void testgetbyId()
		{
			when(proposalService.getProposal(propId).thenReturn(proposal);
			assertEquals(proposal,proposalService.getProposal(proposal.getPropId()));
		}
		
		
		@Test
		public void testremoveproposal()
		{
			when(ProposalService.removeProposal(proposal.getPropId()).thenReturn(proposal);
			assertEquals(proposal,proposalService.removeProposal(proposal.getPropId()));
		}
		
		
		@Test
		public void testgetallproposalslist()
		{
			List <Proposal> proposalslist=new ArrayList <Proposal>();
			proposalslist.add(proposal);
			proposalslist.add(proposal2);
			proposalslist.add(proposal3);
			when(proposalService.getallProposals()).thenReturn(proposalslist);
			assertEquals(proposalslist,proposalService.getAllProposals());

		}*/


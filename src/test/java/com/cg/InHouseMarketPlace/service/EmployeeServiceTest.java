package com.cg.InHouseMarketPlace.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.InHouseMarketPlace.model.Employee;
import com.cg.InHouseMarketPlace.model.Offer;
import com.cg.InHouseMarketPlace.model.Proposal;
import com.cg.InHouseMarketPlace.model.Requirement;
import com.cg.InHouseMarketPlace.model.Resource;
import com.cg.InHouseMarketPlace.model.User;
import com.cg.InHouseMarketPlace.repository.EmployeeRepository;
import com.cg.InHouseMarketPlace.repository.OfferRepository;
import com.cg.InHouseMarketPlace.repository.ProposalRepository;
import com.cg.InHouseMarketPlace.repository.RequirementRepository;
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

	   @InjectMocks
		EmployeeService employeeService;
		@Mock
		EmployeeRepository employeeRepository;
		@Mock
		OfferRepository offerRepository;
		@Mock
		RequirementRepository requirementRepository;
		@Mock
		ProposalRepository proposalRepository;
		
		User user1=new User("vineesha122","vin122");
		User user2=new User("sirisha2","siri2");
		Employee emp1=new Employee(12,"vineesha","account","hyderabad",user1);
		Employee emp2=new Employee(21,"sirisha","finance","chennai",user2);
		
		
		@Test
		public void testsaveEmployee()
		{
			when(employeeRepository.save(emp1)).thenReturn(emp1);
			
			assertEquals(emp1,employeeService.saveEmployee(emp1));
		}
		
		@Test
		public void testeditEmployee()
		{
			
			when(employeeRepository.save(emp1)).thenReturn(emp1);
			
			assertEquals(emp1,employeeService.editEmployee(emp1));
		}
		public void testupdateIsAvailable() {
			Proposal proposal1=new Proposal();
			Proposal proposal2=new Proposal();
			List<Proposal> proposalList=new ArrayList<Proposal>();
			proposalList.add(proposal1);
			proposalList.add(proposal2);
			Offer offer=new Offer(2,true,LocalDate.now(),proposalList);
			
			when(offerRepository.findByOfferId(offer.getOfferId())).thenReturn(offer);
			
			assertNotNull(employeeService.updateIsAvailable(offer.getOfferId()));
			
			assertEquals(offer, employeeService.updateIsAvailable(offer.getOfferId()));
		}
		public void testupdateIsFulfilled() {
			Proposal proposal1=new Proposal();
			Proposal proposal2=new Proposal();
			List<Proposal> proposalList=new ArrayList<Proposal>();
			proposalList.add(proposal1);
			proposalList.add(proposal2);
			Requirement requirement=new Requirement(9,true,LocalDate.now(),proposalList);
			
			when(requirementRepository.findByRequirementId(requirement.getReqId())).thenReturn(requirement);
			
			assertNotNull(employeeService.updateIsFulfilled(requirement.getReqId()));
			
			assertEquals(requirement, employeeService.updateIsFulfilled(requirement.getReqId()));
			
		}
		
		public void testupdateIsAccepted() {
			
			Resource resource=new Resource();
			Proposal proposal1=new Proposal(123,"offer",2000.0,LocalDate.now(),false,LocalDate.now(),resource,emp1);		
			when(proposalRepository.findByProposalId(proposal1.getPropId())).thenReturn(proposal1);
			
			assertNotNull(employeeService.updateIsAccepted(proposal1.getPropId()));
			
			assertEquals(proposal1, employeeService.updateIsAccepted(proposal1.getPropId()));
			
		}
		public void testgetAllOffers()
		{
			Resource resource1=new Resource();
	         Resource resource2=new Resource();
			Proposal proposal1=new Proposal(123,"offer",2000.0,LocalDate.now(),false,LocalDate.now(),resource1,emp1);
		    Proposal proposal2=new Proposal(220,"offer",1000.0,LocalDate.now(),true,LocalDate.now(),resource2,emp2);
		    List<Proposal> proposalList=new ArrayList<Proposal>();
			proposalList.add(proposal1);
			proposalList.add(proposal2);
		    Offer offer1=new Offer(52,false,LocalDate.now(),proposalList);
		    Offer offer2=new Offer(66,true,LocalDate.now(),proposalList);
		    List<Offer> offerList=new ArrayList<Offer>();
			offerList.add(offer1);
			offerList.add(offer2);
		  
	        when(employeeRepository.findByEmpId(emp1.getEmpId())).thenReturn(offerList);
			
			assertNotNull(employeeService.getAllOffers(emp1.getEmpId()));
			
			assertEquals(offerList, employeeService.getAllOffers(emp1.getEmpId()));
				
		}
		
		public void testgetAllRequirements()
		{
			Resource resource1=new Resource();
	        Resource resource2=new Resource();
			Proposal proposal1=new Proposal(240,"requirement",5000.0,LocalDate.now(),false,LocalDate.now(),resource1,emp1);
		    Proposal proposal2=new Proposal(250,"offer",3000.0,LocalDate.now(),true,LocalDate.now(),resource2,emp2);
		    List<Proposal> proposalList=new ArrayList<Proposal>();
			proposalList.add(proposal1);
			proposalList.add(proposal2);
		    Requirement requirement1=new Requirement(88,false,LocalDate.now(),proposalList);
		    Requirement requirement2=new Requirement(95,true,LocalDate.now(),proposalList);
		    List<Requirement> requirementList=new ArrayList<Requirement>();
			requirementList.add(requirement1);
			requirementList.add(requirement2);	  
	        when(employeeRepository.findByempId(emp1.getEmpId())).thenReturn(requirementList);
			
			assertNotNull(employeeService.getAllRequirements(emp1.getEmpId()));
			
			assertEquals(requirementList, employeeService.getAllRequirements(emp1.getEmpId()));
				
		}
		
		
	}

package com.cg.InHouseMarketPlace.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.InHouseMarketPlace.model.Employee;
import com.cg.InHouseMarketPlace.model.Proposal;
import com.cg.InHouseMarketPlace.model.Requirement;
import com.cg.InHouseMarketPlace.model.Resource;

@ExtendWith(MockitoExtension.class)
class RequirementServiceTest
{
	RequirementService 	requirementService=mock(RequirementService.class);
	
	
		Employee emp=new Employee();
		Resource res=new Resource();
		Proposal proposal=new Proposal();
		@SuppressWarnings("deprecation")
		Requirement requirement1=new Requirement(11,true,new Date(2003,10,6),proposal);
		@SuppressWarnings("deprecation")
		Requirement requirement2=new Requirement(15,false,new Date(2003,10,7),proposal);
		
		@Test
		public void testaddRequirement()
		{
			when(requirementService.addRequirement(requirement1)).thenReturn(requirement1);
			assertEquals(requirement1,requirementService.addRequirement(requirement1));
		}
		
		@Test
		public void testeditRequirement()
		{
			when(requirementService.editRequirement(requirement1)).thenReturn(requirement1);
			assertEquals(requirement1,requirementService.editRequirement(requirement1));
		}
		
		@Test
		public void testgetRequirement()
		{
			when(requirementService.getRequirement(requirement1.getReqId())).thenReturn(requirement1);
			assertEquals(requirement1,requirementService.getRequirement(requirement1.getReqId()));
		}
		
		@Test
		public void testremoveRequirementbyId()
		{
			when(requirementService.removeRequirement(requirement1.getReqId())).thenReturn(requirement1);
			requirementService.removeRequirement(requirement1.getReqId());
			verify(requirementService,times(1)).removeRequirement(requirement1.getReqId());
		}
		@Test
		public void testgetallrequirementslist()
		{
			List<Requirement> requirementslist=new ArrayList <Requirement>();
			requirementslist.add(requirement1);
			requirementslist.add(requirement2);
			when(requirementService.getAllRequirements()).thenReturn(requirementslist);
			assertEquals(requirementslist.size(),requirementService.getAllRequirements().size());

		}
		@Test
		 void testGetAllRequirement()
		{
			List<Requirement> requirements=new ArrayList<Requirement>();
			requirements.add(requirement1);
			requirements.add(requirement2);
			when(requirementService.getAllRequirements("category", "type")).thenReturn(requirements);
			List<Requirement> resultList=requirementService.getAllRequirements("category", "type");
			assertNotNull(resultList);
			assertEquals(resultList.size(), requirements.size());
		}

}

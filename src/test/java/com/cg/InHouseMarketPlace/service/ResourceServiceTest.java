package com.cg.InHouseMarketPlace.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.InHouseMarketPlace.model.Resource;

@ExtendWith(MockitoExtension.class)
class ResourceServiceTest {

	ResourceService resourceService=mock(ResourceService.class);
	List<Resource> resz=new ArrayList<Resource>();
	Resource res=new Resource(12,"title","description","category",LocalDate.now(),"type",0.2f,1);
	Resource res1=new Resource(13,"titl","descriptio","categor",LocalDate.now(),"typ",0.3f,1);
	Resource res2=new Resource(14,"tit","descripti","catego",LocalDate.now(),"ty",0.4f,1);
	private int empId;
	
	@Test
	public void testGetAllResources()
	{	
		resz.add(res);
		resz.add(res1);
		resz.add(res2);
		
		when(resourceService.getAllResources("categor", "typ")).thenReturn(resz);
		List<Resource> resultList=resourceService.getAllResources("categor", "typ");
		
		assertNotNull(resultList);
		
		assertEquals(resultList.size(), resz.size());
	}
	@Test
	public void testAllResources()
	{
		
		resz.add(res);
		resz.add(res1);
		resz.add(res2);
		
		when(resourceService.getAllResources(empId)).thenReturn(resz);
		List<Resource> resultList=resourceService.getAllResources(empId);
		
		assertNotNull(resultList);
		
		assertEquals(resultList.size(), resz.size());
	}
}


package com.cg.InHouseMarketPlace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.InHouseMarketPlace.model.Resource;
import com.cg.InHouseMarketPlace.repository.ResourceRepository;

@Service
public class ResourceService {
	@Autowired
	public ResourceRepository resourceRepository;
	/*
	 * Getting all requirements by category and type
	 */
	public List<Resource> getAllResources(String category, String type) {
		return resourceRepository.findByCategoryAndType(category, type);
	}
	/*
	 * getting all resources by employee Id
	 */
	public List<Resource> getAllResources(int empId){
		return resourceRepository.findByEmpId(empId);
	}
}

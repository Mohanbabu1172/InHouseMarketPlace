package com.cg.InHouseMarketPlace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.InHouseMarketPlace.exception.InvalidEmployeeException;
import com.cg.InHouseMarketPlace.model.Resource;
import com.cg.InHouseMarketPlace.service.ResourceService;


@RestController
public class ResourceController {
	@Autowired
	ResourceService resourceService;
	/*
	 * Getting all requirements by category and type
	 */
	@GetMapping("/resource")
	public List<Resource> getAllResources(@RequestParam(value="category") String category,@RequestParam(value="type") String type){
		return resourceService.getAllResources(category, type);
	}
	/*
	 * getting all resources by employee Id
	 */
	@GetMapping("/resource/{empId}")
	public List<Resource> getAllResources(@PathVariable int empId) {
		List<Resource> resource = resourceService.getAllResources(empId);
		if (resource.isEmpty()) {
			throw new InvalidEmployeeException("Not found Employee with empId : " + empId + " to return");
		}
		return resource;
	}
}

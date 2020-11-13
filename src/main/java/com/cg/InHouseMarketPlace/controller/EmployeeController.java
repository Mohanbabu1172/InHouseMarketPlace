package com.cg.InHouseMarketPlace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.InHouseMarketPlace.exception.InvalidEmployeeException;
import com.cg.InHouseMarketPlace.exception.InvalidOfferException;
import com.cg.InHouseMarketPlace.exception.InvalidProposalException;
import com.cg.InHouseMarketPlace.exception.InvalidRequirementException;
import com.cg.InHouseMarketPlace.model.Employee;
import com.cg.InHouseMarketPlace.model.Offer;
import com.cg.InHouseMarketPlace.model.Proposal;
import com.cg.InHouseMarketPlace.model.Requirement;
import com.cg.InHouseMarketPlace.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	/*
	 * Registering an employee
	 */
	@PostMapping("/register")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		Employee addedEmployee = employeeService.saveEmployee(emp);
		return new ResponseEntity<Employee>(addedEmployee, HttpStatus.OK);
	}
	/*
	 * Updating an employee
	 */
	  @PutMapping("/update")
	  public Employee updateEmployee(@RequestBody Employee emp)
	  {
		return employeeService.editEmployee(emp);
	  }
	  /*
	   * Get an employee by Id
	   */
	  @GetMapping("/employebyid/{empId}")
	   public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId)
	  {
		Employee fetchedEmployee = employeeService.getEmployee(empId);
		if(fetchedEmployee.getEmpId()==0)
		{
			throw new InvalidEmployeeException("No employee found with id= : " + empId);
		}
		else 
		{
			return new ResponseEntity<Employee>(fetchedEmployee,HttpStatus.OK);
		}
      }
	  /*
	   * Get all offer by employee Id
	   */
	    @GetMapping("/getoffer/{empId}")
	    public ResponseEntity<List<Offer>> getAllOffers(@PathVariable int empId)
	    {
		      List<Offer> fetchedOffers=employeeService.getAllOffers(empId);
		         if(fetchedOffers.isEmpty())
		       {
			       throw new InvalidEmployeeException("No Employee found with id= : " + empId);
		       }
		           else
		       {
			      return new ResponseEntity<List<Offer>>(fetchedOffers,HttpStatus.OK);
		       }
	   }
	    /*
		 * Get all requirements by employee Id
		 */
	    @GetMapping("/getrequirements/{empId}")
	    public ResponseEntity<List<Requirement>> getAllRequirements(@PathVariable int empId)
	    {
		  List<Requirement> fetchedRequirements=employeeService.getAllRequirements(empId);
		  
		 if(fetchedRequirements.isEmpty())
		 {
			 throw new InvalidEmployeeException("No Employee found with id= : " + empId);
		 }
		 else
			 return new ResponseEntity<List<Requirement>>(fetchedRequirements,HttpStatus.OK);   
          }
	    /*
		 * update available offers by offer Id
		 */
	    @GetMapping("/updateOfferby/{offerId}")
	    public  Offer updateAvailable(@PathVariable int offerId)
	    {
	    	Offer res = employeeService.updateIsAvailable(offerId);
	    	if(res.getOfferId()==0)
	    	{
	    		throw new InvalidOfferException("No update available for offerId "+offerId);
	    	}
	    	else
	    	{
	    		return res;
	    	}
	    }
	    /*
		 * update fulfilled Requirements by requirement Id
		 */
	    @GetMapping("/updateRequirementbyEmpId/{reqId}")
	    public  Requirement updateFulfilled(@PathVariable int reqId)
	    {
	    	Requirement res = employeeService.updateIsFulfilled(reqId);
	    	if(res.getReqId()==0)
	    	{
	    		throw new InvalidRequirementException("No fulliled requirements available for reqId "+reqId);
	    	}
	    	else
	    	{
	    		return res;
	    	}	
	    }
	    /*
		 * update accepted proposals by Proposal Id
		 */
	    @GetMapping("/updateProposalbyEmpId/{propId}")
	    public  Proposal updateAccepted(@PathVariable int propId)
	    {
	    	Proposal res = employeeService.updateIsAccepted(propId);
	    	if(res.getPropId()==0)
	    	{
	    		throw new InvalidProposalException("No accepted proposals available for propId "+propId);
	    	}
	    	else
	    	{
	    		return res;
	    	}
	    	
	    }
}
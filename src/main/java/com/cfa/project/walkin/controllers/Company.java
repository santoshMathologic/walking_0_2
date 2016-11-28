package com.cfa.project.walkin.controllers;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cfa.project.walkin.models.CompanyDetails;
import com.cfa.project.walkin.repositories.CompanyDetailsRepository;

@Controller
@RequestMapping("/api/v1/company")
public class Company {
	
	@Autowired
	CompanyDetailsRepository companyDetailsRepository;
	    
	   @RequestMapping(value="/getInfo",method=RequestMethod.GET)
	   public @ResponseBody  Page<CompanyDetails> getInfo(
			   			@PathParam("orderBy") String orderBy,
			   			@PathParam("sortDir") String sortDir,
			   			@PathParam("limit") int limit,
			   			@PathParam("perPage")int perPage
				){
		        Page<CompanyDetails> CompanyDetailsList = companyDetailsRepository.findAll(new PageRequest(0, 10,Direction.ASC,"companyName"));
		        return CompanyDetailsList;
	   }
	   
	
	 
	  @RequestMapping(value="/createResource",method=RequestMethod.POST)
	   public @ResponseBody List<CompanyDetails> createCompany(@RequestBody CompanyDetails companyDetails){
		
		  
		  //System.out.println(""+companyDetails);
		  
		  
		  return (List<CompanyDetails>)companyDetailsRepository.save(companyDetails);
		   
		   
		   
		   
	   }

}

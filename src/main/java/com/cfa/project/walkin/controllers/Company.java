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
import org.springframework.web.bind.annotation.RequestParam;
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
			   			@PathParam("sort") String sort,
			   			@PathParam("sortDir") String sortDir,
			   			@PathParam("limit")int limit,
			   			@PathParam("page") int page,
			   			@PathParam("city") String city
			   			){
		   
		   
		      
		        Page<CompanyDetails> CompanyDetailsList = companyDetailsRepository.findByAllSearchParams("",city,new PageRequest(page, limit,Direction.ASC,"companyName"));
		        return CompanyDetailsList;
	   }
	   
	
	 
	  @RequestMapping(value="/createResource",method=RequestMethod.POST)
	   public @ResponseBody List<CompanyDetails> createCompany(@RequestBody CompanyDetails companyDetails){
		
		  
		  //System.out.println(""+companyDetails);
		  
		  
		  return (List<CompanyDetails>)companyDetailsRepository.save(companyDetails);
		   
		   
		   
		   
	   }

}

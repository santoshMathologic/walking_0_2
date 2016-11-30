package com.cfa.project.walkin.controllers;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cfa.project.walkin.models.CompanyDetails;
import com.cfa.project.walkin.repositories.CompanyDetailsRepository;
import com.cfa.projects.walking.custom.repositories.CompanyDetailsCustomRepository;


@Controller
@RequestMapping("/api/v1/company")
public class Company {
	
	@Autowired
	CompanyDetailsRepository companyDetailsRepository;
	
	@Autowired
	CompanyDetailsCustomRepository companyDetailsCustomRepository;
	

	   @RequestMapping(value="/getInfo",method=RequestMethod.GET)
	   public @ResponseBody  List<CompanyDetails> getInfo(
			   			@PathParam("sort") String sort,
			   			@PathParam("sortDir") String sortDir,
			   			@PathParam("limit")int limit,
			   			@PathParam("page") int page,
			   			@PathParam("walkingdate") String walkingdate,
			   			@PathParam("city") String city,
			   			@PathParam("state") String state
			   			){
		   
		   
		  
		   
		 
		   List<CompanyDetails> CompanyDetailsList  = (List<CompanyDetails>) companyDetailsCustomRepository.findByAllSearchParams(page, limit, city,state,walkingdate);
		 
		   //Page<CompanyDetails> CompanyDetailsList = companyDetailsRepository.findByAllSearchParams(walkingdate,"",city,state,new PageRequest(page, limit,Direction.ASC,"companyName"));
	        return CompanyDetailsList;
	   }
	   
	
	 
	  @RequestMapping(value="/createResource",method=RequestMethod.POST)
	   public @ResponseBody List<CompanyDetails> createCompany(@RequestBody CompanyDetails companyDetails){
		
		  
		  //System.out.println(""+companyDetails);
		  
		  
		  return (List<CompanyDetails>)companyDetailsRepository.save(companyDetails);
		   
		   
		   
		   
	   }



	public CompanyDetailsRepository getCompanyDetailsRepository() {
		return companyDetailsRepository;
	}



	public void setCompanyDetailsRepository(CompanyDetailsRepository companyDetailsRepository) {
		this.companyDetailsRepository = companyDetailsRepository;
	}



	public CompanyDetailsCustomRepository getCompanyDetailsCustomRepository() {
		return companyDetailsCustomRepository;
	}



	public void setCompanyDetailsCustomRepository(CompanyDetailsCustomRepository companyDetailsCustomRepository) {
		this.companyDetailsCustomRepository = companyDetailsCustomRepository;
	}

}

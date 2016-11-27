package com.cfa.project.walkin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cfa.project.walkin.models.WalkingDetails;
import com.cfa.project.walkin.repositories.WalkinDetailsRepository;

@RestController
@RequestMapping("app/v1/walking")
public class WalkinDetailsController {
	
	
	@Autowired
	WalkinDetailsRepository walkindetailsrepository;
	    
	   @RequestMapping(value="/getWalkinginfo",method=RequestMethod.GET)
	   public @ResponseBody  Page<WalkingDetails> getWalkinginfo(){
		   
		        Page<WalkingDetails> walkingdetailsList = walkindetailsrepository.findAll(new PageRequest(1, 10,Direction.ASC,"venu"));
		        //assertEquals()
		        return walkingdetailsList;
	   }
	
	
	
	

}

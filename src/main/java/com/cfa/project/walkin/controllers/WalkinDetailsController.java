package com.cfa.project.walkin.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cfa.project.walkin.models.WalkingDetails;
import com.cfa.project.walkin.repositories.WalkinDetailsRepository;

@RestController
@RequestMapping("api/v1/walking")
public class WalkinDetailsController {
	
	
	@Autowired
	WalkinDetailsRepository walkindetailsrepository;
	    
	   @RequestMapping(value="/getWalkinginfo",method=RequestMethod.GET)
	   public @ResponseBody WalkingDetails getWalkinginfo(
			   @PathParam("walkinId") Long walkinId
	   			){
		        WalkingDetails walkingDetail = walkindetailsrepository.findOne(walkinId);
		        return walkingDetail;
	   }
	
	
	
	

}

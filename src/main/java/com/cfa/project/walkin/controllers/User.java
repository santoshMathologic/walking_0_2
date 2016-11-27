/**
 * 
 */
package com.cfa.project.walkin.controllers;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cfa.project.walkin.repositories.UserRepository;


/**
 * @author SANTOSH
 *
 */

@Controller
@RequestMapping("/api/v1/user")
public class User {

	 @Autowired
	 UserRepository userrepository;
	
	public User() {
	}
	
	@RequestMapping(value="/getListUsers",method=RequestMethod.GET)
	public @ResponseBody String getListUsers(){
		
	List<com.cfa.project.walkin.models.User> userList	 = userrepository.findAll();
	System.out.print(""+userList);
	
		//return new Gson().toJson(userList);
	return "jjjj";
		
		
		
	}
	
	@RequestMapping(value="/getUsers",method=RequestMethod.GET)
	public @ResponseBody Page<com.cfa.project.walkin.models.User> getUsers(){
		
	Page<com.cfa.project.walkin.models.User> userList	 = userrepository.findAll(new PageRequest(0,10, Direction.ASC, "username"));
		
		return userList;
		
		
		
	}
	
	
	
	
	

}

/**
 * 
 */
package com.cfa.project.walkin.controllers;


import java.nio.charset.Charset;
import java.security.Key;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.cfa.project.walkin.exception.CustomException;
import com.cfa.project.walkin.models.CustomToken;

import com.cfa.project.walkin.repositories.UserPlanRepository;
import com.cfa.project.walkin.repositories.UserRepository;
import com.cfa.projects.walking.custom.repositories.UserCustomRepository;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.compression.CompressionCodecs;
import io.jsonwebtoken.impl.crypto.MacProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author SANTOSH
 *
 */
@RestController
@RequestMapping("/api/v1/login")
public class AuthController {


	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserPlanRepository userPlanRepository;
	
	@Autowired
	UserCustomRepository userCustomRepository;
	
	//private static final Logger WALKING_LOGGER = Logger.getLogger(AuthController.class);
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	public AuthController() {
	}
@RequestMapping(value="/getLoginInfoClass",method = RequestMethod.GET)
	public @ResponseBody String getLoginInfoClass(){
		  return "Call the Url to get the Login Information!!!!!!!!!";
	}
	

/***
 * 
 * 
 * 
 * @param httpRequest
 * @return  
 *  The Following Methods are Written for JWT BASE AUTHENTICATION IN JAVA 
 *  Dependency in Maven 
 *    <groupId>io.jsonwebtoken</groupId>
      <artifactId>jjwt</artifactId>
      <version>0.6.0</version>
 */
	@RequestMapping(value="/doLogin",method = RequestMethod.POST)
	public String doLogin(HttpServletRequest httpRequest){
		String generatedToken = null;
		
		final String authorization = httpRequest.getHeader("Authorization");
	    if (authorization != null && authorization.startsWith("Basic")) {

	        String base64Credentials = authorization.substring("Basic".length()).trim();
	        String credentials = new String(Base64.getDecoder().decode(base64Credentials),Charset.forName("UTF-8"));
	        // credentials = username:password
	        final String[] userCredentials= credentials.split(":",2);
	        
	           
	          
	        generatedToken =  validateUserInfo(userCredentials[0],userCredentials[1]);
	           
	          
	    }else{
	    	 System.out.println("Invalid Authorization");
	    }

		
	 
		logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return generatedToken;
	}
	
	
	public String validateUserInfo(String username, String password) {
		
		try {
			com.cfa.project.walkin.models.User user = userCustomRepository.findUsernameAndPassword(username, password);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		 return null;
	}

	public String generateJWTToken(String userName,String password, String roleCode/*, String currentPlan*/){
		
		
		
		 /**
         *   Create a object to stor UserName and password and Convert it to Gson Object
         */
		CustomToken customToken = new CustomToken();
		customToken.setUserName(userName);
	    customToken.setPassword(password);
	    customToken.setRoleCode(roleCode);
	   // customToken.setCurrentPlan(currentPlan);
        
		
		 // System.out.println(new Gson().toJson(authCont));
        
        Key key = MacProvider.generateKey();
        
        /**
         *  Encoding Algorithm using BASE AUTH 
         * 
         */
        String compactJwsToken = Jwts.builder()
     		   				.setSubject(new Gson().toJson(customToken))  
     		   				.compressWith(CompressionCodecs.DEFLATE)                         
     		   				.signWith(SignatureAlgorithm.HS512, key)
     		   				.compact();
        
      
        customToken.setToken(compactJwsToken);
        
        System.out.println(""+compactJwsToken);
        
        try {
     	   System.out.println(""+Jwts.parser().setSigningKey(key).parseClaimsJws(compactJwsToken)); 
     	} catch (SignatureException e) {
     	    //don't trust the JWT!
     	}
     
		return new Gson().toJson(customToken); 
		
	}
	
	
	

}

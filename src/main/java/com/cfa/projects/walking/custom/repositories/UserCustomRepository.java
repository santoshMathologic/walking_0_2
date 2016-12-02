/**
 * 
 */
package com.cfa.projects.walking.custom.repositories;

import com.cfa.project.walkin.exception.CustomException;
import com.cfa.project.walkin.models.User;

/**
 * @author SANTOSH
 *
 */
public interface UserCustomRepository {
	
	
	     User findUsernameAndPassword(String username,String password)throws CustomException;

}

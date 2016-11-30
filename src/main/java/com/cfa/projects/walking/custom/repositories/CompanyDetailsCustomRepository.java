/**
 * 
 */
package com.cfa.projects.walking.custom.repositories;

import java.util.List;

/**
 * @author SANTOSH
 *
 */
public interface CompanyDetailsCustomRepository {
	
		
	     List<?> findByAllSearchParams(int page, int limit,String City,String State);

}

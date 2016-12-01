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
	
		
	     List<?> findByAllSearchParams(int page, int limit,String sort,String City,String State,String walkdate);

}

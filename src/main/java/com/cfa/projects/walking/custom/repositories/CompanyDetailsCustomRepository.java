/**
 * 
 */
package com.cfa.projects.walking.custom.repositories;

import java.util.List;

import com.cfa.project.walkin.models.CompanyDetails;

/**
 * @author SANTOSH
 *
 */
public interface CompanyDetailsCustomRepository {
	
		
	     List<?> findByAllSearchParams(int page, int limit,String sort,String City,String State,String walkdate);
	     String deleteCompanyDetails(CompanyDetails companydetails);

}

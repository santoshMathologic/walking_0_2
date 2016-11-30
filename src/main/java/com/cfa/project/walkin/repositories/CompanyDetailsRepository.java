package com.cfa.project.walkin.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.cfa.project.walkin.models.CompanyDetails;

@RepositoryRestResource
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Long>{
	
	
	       @Query("Select cd from CompanyDetails as cd where (cd.companyName LIKE %:companyName% or :companyName is '%%' or :companyName is NULL ) "
	       		+ "AND (cd.city LIKE %:city% or :city is'%%' or :city is NULL)"
	       		+ "AND (cd.state LIKE %:state% or :state is'%%' or :state is NULL)"
	       		+ "AND (cd.walkingdetails.walkingdate LIKE %:walkingdate% or :walkingdate is'%%' or :walkingdate is NULL) ")
	       Page<CompanyDetails>findByAllSearchParams(
	    		   									//@Param("walkingdate") @Temporal(TemporalType.DATE) Date walkingdate
	    		   									@Param("walkingdate") String walkingdate,
	    		                                    @Param("companyName") String companyName,
	    		                                    @Param("city") String city,
	    		                                    @Param("state") String state,
	    		                                    Pageable pageable); 
	  

}

/**
 * 
 */
package com.cfa.projects.walking.custom.repositories;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cfa.project.walkin.models.CompanyDetails;

/**
 * @author SANTOSH
 *
 */

@Repository
public class CompanyDetailsCustomRepositoryImpl implements CompanyDetailsCustomRepository {

	/**
	 * 
	 */
	@Autowired
	private SessionFactory sessionFactory; 
	    
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(readOnly = false)
	public List<CompanyDetails> findByAllSearchParams(int page, int limit,String City) {
		  Session session = sessionFactory.openSession();
		   
		  /* return (List<ParentInfoTable>) find("from ParentInfoTable pld where pld.parentUserName like '"
					+ parentDetails.getParentUserName()
					+ "' and pld.parentPassword like '"
					+ parentDetails.getParentPassword() + "'");*/
		   
		//   String customQuery = "SELECT cd FROM CompanyDetails cd WHERE ((:city is null OR :city is '') or cd.city like :city) order by cd.companyName  ASC";
		  
		  
		  //String customQuery = "FROM CompanyDetails cd WHERE cd.city LIKE'"+city+"' ORDER BY cd.companyName  ASC";
		   
		  //OR '"+city+"' is NULL OR '"+city+"' is ''
		  
		  
		  String customQuery = "from CompanyDetails cd where (cd.city LIKE :City OR :City is null ) ORDER BY cd.companyName ASC";
		  
		  Query query = session.createQuery(customQuery);
		     //query.setParameter("city", '%'+city+'%');
		     ///query.setParameter("city", null);
		 
			  query.setParameter("City","%" + City + "%");
			  query.setParameter("City", null);
		  	//query.setParameter("City",City);
		  //.setParameter("type", type, Hibernate.STRING);
		     query.setFirstResult(page);
		     query.setMaxResults(limit);
		     @SuppressWarnings("unchecked")
		    List<CompanyDetails> CompanyDetailsList  = query.list();
		    return CompanyDetailsList;
	}

}

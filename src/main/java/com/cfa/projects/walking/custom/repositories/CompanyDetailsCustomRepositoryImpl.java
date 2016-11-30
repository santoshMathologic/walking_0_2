/**
 * 
 */
package com.cfa.projects.walking.custom.repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Query;
import com.cfa.project.walkin.models.CompanyDetails;
import com.cfa.project.walkin.models.WalkingDetails;

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
	
	@PersistenceContext
	private EntityManager entityManager;
	    
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(readOnly = false)
	public List<CompanyDetails> findByAllSearchParams(int page, int limit,String City,String State,String walkDate) {
		
		 Session session = sessionFactory.openSession();
		
		  /*Session session = sessionFactory.openSession();
		  List<?> result = null;
		  
		
		 
		  String customQuery = "FROM CompanyDetails cd WHERE (cd.city LIKE :City OR :City IS NULL or :City IS '') AND (cd.state LIKE :State OR :State IS NULL OR :State IS '') ORDER BY cd.companyName ASC";
		  
		  Query query = session.createQuery(customQuery);
		  	  query.setParameter("City",'%' + City + '%');
			  query.setParameter("City", null);
			  //query.setParameter("State",'%' + State + '%');
			  query.setParameter("State",State);
			  query.setParameter("State", null);
		      query.setFirstResult(page);
		      query.setMaxResults(limit);
		     
		     
		     try {
					result = query.list();
				} catch (Exception ex) {
					System.out.println("ERROR in QUERY: " + ex.getMessage());
				}
		     */
		   //List<CompanyDetails> finalResult = findByAllParamsByNative(page,limit,City,State);
		   
		   List<CompanyDetails> finalResult   = findByAllParamsByCriteria(page,limit,City,State,walkDate);
		  
		    return finalResult;
	}
	
	
	public List<CompanyDetails> findByAllParamsByNative (int page, int limit,String City,String State){
		  List<CompanyDetails> result = null;
		  
		  //String customQuery = "select cd from company_details as cd JOIN walking_details as wd ON(cd.walkingdetails_id = wd.id)";
		 
		  String customQuery = "FROM CompanyDetails cd WHERE (cd.city LIKE CONCAT('%', :City, '%') OR :City IS NULL or :City IS '') AND (cd.state LIKE :State OR :State IS NULL OR :State IS '') ORDER BY cd.companyName ASC";
				Query query2f = entityManager.createQuery(customQuery);
				
				//query2f.setParameter("City",'%' + City + '%');
				query2f.setParameter("City",City);
				query2f.setParameter("City", null);
				query2f.setParameter("State",'%' + State + '%');
				query2f.setParameter("State", null);
				query2f.setFirstResult(page);
				query2f.setMaxResults(limit);
		  
			try {
				result = query2f.getResultList();
			} catch (Exception ex) {
				System.out.println("ERROR in QUERY: " + ex.getMessage());
			}
			return result;
	}
	

	
	public List<CompanyDetails> findByAllParamsByCriteria (int page, int limit,String City,String State,String walkdate){
		  List<CompanyDetails> result = null;
		  Session session = sessionFactory.openSession();
		  Criteria cr = session.createCriteria(CompanyDetails.class,"CompanyDetails").createAlias("CompanyDetails.walkingdetails", "walkingdetails");
		  
		  SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-YYYY");
		  Date wdate = null;
		  try {
			  if(walkdate!=null){
				  wdate = formatter.parse(walkdate);
				  cr.add(Restrictions.eq("walkingdetails.walkingdate",wdate));
			  }
			 
		} catch (ParseException ex) {
			System.out.println("ERROR in Date Parsing: " + ex.getMessage());
		}
		  
		   
		
		    if(State!=null){
		    	cr.add(Restrictions.like("state", "%" +State + "%"));
		    }
		    if(City!=null){
		    	cr.add(Restrictions.like("city", "%" +City + "%"));
		    }
		    
		    cr.setFirstResult(page);
		    cr.setMaxResults(limit);
		 
			try {
				result = cr.list();
			} catch (Exception ex) {
				System.out.println("ERROR in QUERY: " + ex.getMessage());
			}
			return result;
	}
	
	
	 
		
	
}

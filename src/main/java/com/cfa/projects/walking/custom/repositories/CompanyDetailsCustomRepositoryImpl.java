/**
 * 
 */
package com.cfa.projects.walking.custom.repositories;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Query;
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
	public List<CompanyDetails> findByAllSearchParams(int page, int limit,String sort,String City,String State,String walkDate) {
		
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
		   
		   List<CompanyDetails> finalResult   = findByAllParamsByCriteria(page,limit,sort,City,State,walkDate);
		  
		    return finalResult;
	}
	
	
	public List<CompanyDetails> findByAllParamsByNative (int page, int limit,String City,String State){
		  List<CompanyDetails> result = null;
		  
		  //String customQuery = "select cd from company_details as cd JOIN walking_details as wd ON(cd.walkingdetails_id = wd.id)";
		 
		  String customQuery = "FROM CompanyDetails cd WHERE (cd.city LIKE CONCAT('%', :City, '%') OR :City IS NULL or :City IS '') AND (cd.state LIKE :State OR :State IS NULL OR :State IS '') ORDER BY cd.companyName ASC";
				Query query2f = entityManager.createQuery(customQuery);
				query2f.setParameter("City",'%' + City + '%');
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
	

	
	public List<CompanyDetails> findByAllParamsByCriteria (int page, int limit,String sort,String City,String State,String walkingDate){
 		  List<CompanyDetails> result = null;
		  Session session = sessionFactory.openSession();
		  Criteria cr = session.createCriteria(CompanyDetails.class,"CompanyDetails").createAlias("CompanyDetails.walkingdetails", "walkingdetails");
		  cr.setFirstResult(page);
		  cr.setMaxResults(limit);
		 
		String sortParam = "";
		String sortOrder = "";
		Order o = null;
		if (!(sort == null)) {
			sortParam = sort.split(",")[0];
			sortOrder = sort.split(",")[1];
			if (sortOrder.contains("asc")) {
				o = Order.asc(sortParam);
			}
			if (sortOrder.contains("desc")) {
				o = Order.desc(sortParam);
			}

			cr.addOrder(o);
		}
		  
		 
		  try {
			  if(walkingDate!=null){
			       String[] walkgdate = walkingDate.split("-");
		           String yyyy = walkgdate [0];
		           String mm = walkgdate   [1];
		           String dd = walkgdate   [2];
		           String completeConverted = getDayOfWeek(1)+" "+Month.of(Integer.parseInt(mm)).name().substring(0, 3)+" "+dd +" 00:00:00 "+"IST"+" "+yyyy;
		           DateFormat formatter1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy",Locale.US);
		           Date date1 = (Date)formatter1.parse(completeConverted);
		           java.sql.Date sqlDate2 = convertUtilToSql(date1);
		           cr.add(Restrictions.eq("walkingdetails.walkingdate", sqlDate2));
			  }
			 
		} catch (Exception ex) {
			System.out.println("ERROR in Date Parsing: " + ex.getMessage());
		}
		  
		   
		
		    if(State!=null){
		    	cr.add(Restrictions.like("state", "%" +State + "%"));
		    }
		    if(City!=null){
		    	cr.add(Restrictions.like("city", "%" +City + "%"));
		    }
		    
		    Criteria criteriaCount = session.createCriteria(CompanyDetails.class,"CompanyDetails").createAlias("CompanyDetails.walkingdetails", "walkingdetails");
		    criteriaCount.setProjection(Projections.rowCount());
		    Long count = (Long) criteriaCount.uniqueResult();
		    
			try {
				result = cr.list();
			} catch (Exception ex) {
				System.out.println("ERROR in QUERY: " + ex.getMessage());
			}
			return result;
	}

	private java.sql.Date convertUtilToSql(Date uDate) {
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		 return sDate;

	}

	private String getDayOfWeek(int value) {
		String day = "";
		switch (value) {
		case 1:
			day = "SUN";
			break;
		case 2:
			day = "MON";
			break;
		case 3:
			day = "TUES";
			break;
		case 4:
			day = "WED";
			break;
		case 5:
			day = "THURS";
			break;
		case 6:
			day = "FRI";
			break;
		case 7:
			day = "SAT";
			break;
		default : 
			      System.out.println("Invalid Days");
		}
		return day;
	}
	 
		
	
}

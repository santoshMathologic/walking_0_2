package com.cfa.project.walkin.models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="walking_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlRootElement
public class WalkingDetails {
	
	  @Id
	  @GeneratedValue
	  private Long id;
	  private String venu;
	  
	  @Temporal(TemporalType.DATE)
	  private Date walkingdate;
	 
	    @OneToMany(mappedBy="walkingdetails",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	    @JsonBackReference
	    private List<CompanyDetails> companys = new LinkedList<CompanyDetails>();
	    
	  
	  
	  
	  


	public WalkingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVenu() {
		return venu;
	}

	public void setVenu(String venu) {
		this.venu = venu;
	}

	public List<CompanyDetails> getCompanys() {
		return companys;
	}

	public void setCompanys(List<CompanyDetails> companys) {
		this.companys = companys;
	}

	public Date getWalkingdate() {
		return walkingdate;
	}

	public void setWalkingdate(Date walkingdate) {
		this.walkingdate = walkingdate;
	}



}

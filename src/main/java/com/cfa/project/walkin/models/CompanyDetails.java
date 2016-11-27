package com.cfa.project.walkin.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="company_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlRootElement
public class CompanyDetails {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String companyName;
	private String companyAddress;
	
	private String city;
	private String state;
	private String country;
	
	
	@NotNull
	@ManyToOne
	private WalkingDetails walkingdetails;

	public CompanyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyDetails(Long id, String companyName, WalkingDetails walkingdetails) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.walkingdetails = walkingdetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public WalkingDetails getWalkingdetails() {
		return walkingdetails;
	}

	public void setWalkingdetails(WalkingDetails walkingdetails) {
		this.walkingdetails = walkingdetails;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	} 
	
}

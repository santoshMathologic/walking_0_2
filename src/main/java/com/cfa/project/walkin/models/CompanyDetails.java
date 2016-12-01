package com.cfa.project.walkin.models;

import java.io.Serializable;

import javax.persistence.Column;
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
public class CompanyDetails implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="company_name")
	private String companyName;
	@Column(name="company_address")
	private String companyAddress;
	
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="country")
	private String country;
	
	
	@Column(name="markDelete",columnDefinition="BIT(1) DEFAULT b'0'")
	private Boolean markDelete;
	
	@NotNull
	@ManyToOne
	private WalkingDetails walkingdetails;

	public CompanyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CompanyDetails(Long id, String companyName, String companyAddress, String city, String state, String country,
			Boolean markDelete, WalkingDetails walkingdetails) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.markDelete = markDelete;
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



	public Boolean getMarkDelete() {
		return markDelete;
	}



	public void setMarkDelete(Boolean markDelete) {
		this.markDelete = markDelete;
	}

	
}

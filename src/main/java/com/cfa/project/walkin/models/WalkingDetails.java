package com.cfa.project.walkin.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;

import com.cfa.projects.walkin.utils.converters.LocalDateTimeAttributeConverter;
import com.cfa.projects.walkin.utils.converters.LocalTimeDeSerializer;
import com.cfa.projects.walkin.utils.converters.LocalTimeSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="walking_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlRootElement
public class WalkingDetails implements Serializable {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	  @GeneratedValue
	  private Long id;
	  @NotNull
	  private String venu;
	  
	  @Temporal(TemporalType.DATE)
	  private Date walkingdate;
	  
	  @Temporal(TemporalType.TIME)
	 // @JsonSerialize(using = LocalTimeSerializer.class)
	 // @JsonDeserialize(using = LocalTimeDeSerializer.class)
	  @JsonFormat
      (shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss")
	  private Date walkingTime;
	 
	    @OneToMany(mappedBy="walkingdetails",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	    @JsonBackReference
	    private List<CompanyDetails> companys = new LinkedList<CompanyDetails>();
	    
	  
	    //  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss")
	   //  @Column(name = "walkingRepTime", columnDefinition = "TIME", nullable = true)
	   // @JsonSerialize(using = LocalTimeSerializer.class)
		//@JsonDeserialize(using = LocalTimeDeSerializer.class)
	   // @JsonFormat(pattern = "KK:mm")
	    //@Column(name = "walkingRepTime", columnDefinition = "TIME", nullable = true)
	    //@Temporal(TemporalType.TIME)
	    //@Type(type = "java.time.LocalTime")
	     @Convert(converter = LocalDateTimeAttributeConverter.class)
	     private LocalDateTime  walkingRepTime;
	  
	  


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

	public Date getWalkingTime() {
		return walkingTime;
	}

	public void setWalkingTime(Date walkingTime) {
		this.walkingTime = walkingTime;
	}

	public LocalDateTime getWalkingRepTime() {
		return walkingRepTime;
	}

	public void setWalkingRepTime(LocalDateTime walkingRepTime) {
		this.walkingRepTime = walkingRepTime;
	}

	





}

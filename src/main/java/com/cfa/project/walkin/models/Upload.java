/**
 * 
 */
package com.cfa.project.walkin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author SANTOSH
 *
 */

@Entity
@Table(name="user_upload")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Upload {

	/**
	 * 
	 */

	@Id
    @GeneratedValue
    private Long id;
	
	private String dataType;
	private String fileType;
	private String originalFileName;
	private String uploadedBy;
	
	@Column(columnDefinition="BIT(1) DEFAULT b'0'")
	private boolean isProcessed;
	
	private String status;
	private String message;
	
	@Column(columnDefinition="BIT(1) DEFAULT b'0'")
	private boolean markDelete;
	private String uploadedTime;
	private String description;
	
	@Lob
	@Column(length=100000)
	private byte[] data;
	

	public Upload() {
		// TODO Auto-generated constructor stub
	}

	

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public boolean isProcessed() {
		return isProcessed;
	}

	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isMarkDelete() {
		return markDelete;
	}

	public void setMarkDelete(boolean markDelete) {
		this.markDelete = markDelete;
	}

	public String getUploadedTime() {
		return uploadedTime;
	}

	public void setUploadedTime(String uploadedTime) {
		this.uploadedTime = uploadedTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public byte[] getData() {
		return data;
	}



	public void setData(byte[] data) {
		this.data = data;
	}

	
}

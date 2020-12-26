package org.mvc.security.domain;

import java.util.Date;

public class Url {

	private Long id;
	private String urlAddress;
	private Date createdDate;
	private Date modifiedDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrlAddress() {
		return urlAddress;
	}
	public void setUrlAddress(String urlAddress) {
		this.urlAddress = urlAddress;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}

package org.mvc.security.domain;

import java.util.Date;
import java.util.List;

public class Role {
	
	private Long id;
	private String roleName;
	private Date createdDate;
	private Date modifiedDate;
	private List<Url> listOfUrl;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public List<Url> getListOfUrl() {
		return listOfUrl;
	}

	public void setListOfUrl(List<Url> listOfUrl) {
		this.listOfUrl = listOfUrl;
	}

}

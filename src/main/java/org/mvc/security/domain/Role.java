package org.mvc.security.domain;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable{
	private static final long serialVersionUID = 2170527594248278804L;
	
	private Long id;
	private String roleName;
	private Date createdDate;
	private Date modifiedDate;
	
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
}

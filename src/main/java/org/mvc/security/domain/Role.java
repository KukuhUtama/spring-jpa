package org.mvc.security.domain;

import java.io.Serializable;

public class Role implements Serializable{
	private static final long serialVersionUID = 2170527594248278804L;
	
	private Long id;
	private String roleName;

	
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
}

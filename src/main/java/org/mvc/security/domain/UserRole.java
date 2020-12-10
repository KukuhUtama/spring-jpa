package org.mvc.security.domain;

import java.io.Serializable;

public class UserRole implements Serializable{

	private static final long serialVersionUID = 2916335077625850354L;
	
	private Long id;
	private Long roleId;
	private Long userId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}

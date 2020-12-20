package org.mvc.security.domain;

import java.util.Date;
import java.util.List;

public class User {
	
	private Long id;
	private String userName;
	private String password;
	private String passwordConfirm;
	private Boolean isActive;
	private List<Role> listOfRole;
	private Date createdDate;
	private Date modifiedDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public List<Role> getListOfRole() {
		return listOfRole;
	}
	public void setListRole(List<Role> listOfRole) {
		this.listOfRole = listOfRole;
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
	public void setListOfRole(List<Role> listOfRole) {
		this.listOfRole = listOfRole;
	}
}

package org.mvc.security.domain;

import java.util.Date;
import java.util.List;

public class Group {
	
	private Long id;
	private String groupName;
	private Date createdDate;
	private Date modifiedDate;
	private List<Department> listOfDepartement;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
	public List<Department> getListOfDepartement() {
		return listOfDepartement;
	}
	public void setListOfDepartement(List<Department> listOfDepartement) {
		this.listOfDepartement = listOfDepartement;
	}
}

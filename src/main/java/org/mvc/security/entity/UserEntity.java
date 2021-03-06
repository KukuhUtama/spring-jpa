package org.mvc.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "t_user")
public class UserEntity {


	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;


	@Column(name = "user_name")
	private String userName;


	@Column(name = "password")
	private String password;

	@Transient
	private String passwordConfirm;
	
	@Column(name = "is_active")
	private boolean isActive;


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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}


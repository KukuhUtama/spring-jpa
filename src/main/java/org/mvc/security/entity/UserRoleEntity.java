package org.mvc.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_user_role")
public class UserRoleEntity {

	@Id
	@Column(name = "user_role_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;
    
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}

	public RoleEntity getRoleId() {
		return roleId;
	}

	public void setRoleId(RoleEntity roleId) {
		this.roleId = roleId;
	}
    
}

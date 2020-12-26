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
@Table(name = "t_url_role")
public class UrlRoleEntity extends CommonBase{

	private static final long serialVersionUID = 2011014997148989769L;

	@Id
	@Column(name = "url_role_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "url_id")
	private UrlEntity url;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleEntity role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UrlEntity getUrl() {
		return url;
	}

	public void setUrl(UrlEntity url) {
		this.url = url;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}
}

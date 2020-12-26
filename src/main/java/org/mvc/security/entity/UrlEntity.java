package org.mvc.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_url")
public class UrlEntity extends CommonBase {

	private static final long serialVersionUID = 7865094758905743216L;

	@Id
	@Column(name = "url_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "url_address")
	private String urlAddress;

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
}

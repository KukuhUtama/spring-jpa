package org.mvc.security.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails{

	private static final long serialVersionUID = 5331493162612543587L;
	
	private String userName;
	private String password;
	private boolean isActive;
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl(User user, List<GrantedAuthority> authorities) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.isActive = user.getIsActive().booleanValue();
		this.authorities = authorities;
	}
	
	public UserDetailsImpl() {}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return isActive;
	}
	
}

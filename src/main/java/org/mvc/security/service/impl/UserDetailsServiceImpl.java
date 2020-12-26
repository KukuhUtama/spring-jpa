package org.mvc.security.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mvc.security.domain.Role;
import org.mvc.security.domain.User;
import org.mvc.security.domain.UserDetailsImpl;
import org.mvc.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	private User user;
	private UserDetails userDetailsImpl;

	@Override
	public UserDetails loadUserByUsername(String username) {
		user = userService.findByUserName(username);
		userDetailsImpl = new UserDetailsImpl(user, getUserAuthority(user.getListOfRole()));
		return userDetailsImpl;
	}

	private List<GrantedAuthority> getUserAuthority(List<Role> listOfRole) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (Role role : listOfRole) {
			roles.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;
	}

}

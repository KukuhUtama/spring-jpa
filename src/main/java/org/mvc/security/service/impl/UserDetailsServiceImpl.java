package org.mvc.security.service.impl;

import org.mvc.security.domain.UserDetailsImpl;
import org.mvc.security.entity.User;
import org.mvc.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService 
{
	@Autowired
	private UserRepository userRepository;
	
	private User user;
	private UserDetailsImpl userDetailsImpl;

	@Override
	public UserDetails loadUserByUsername(String userName) {
	     user = userRepository.findByUserName(userName);
	     userDetailsImpl = new UserDetailsImpl(user);
	     return userDetailsImpl;
	}
	
}

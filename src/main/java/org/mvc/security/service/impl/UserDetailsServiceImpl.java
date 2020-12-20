package org.mvc.security.service.impl;

import org.modelmapper.ModelMapper;
import org.mvc.security.domain.User;
import org.mvc.security.domain.UserDetailsImpl;
import org.mvc.security.entity.UserEntity;
import org.mvc.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

          
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired 
	private UserRepository userRepository;
	 
	private UserEntity userEntity;
	private User user;
	private UserDetails userDetailsImpl;

	@Override
	public UserDetails loadUserByUsername(String userName) {
		userEntity = userRepository.findByUserName(userName);
		user = modelMapper.map(userEntity, User.class);
		userDetailsImpl = new UserDetailsImpl(user);
		return userDetailsImpl;
	}
	
}

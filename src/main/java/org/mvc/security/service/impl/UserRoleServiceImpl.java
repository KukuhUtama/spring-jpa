package org.mvc.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.mvc.security.domain.UserRole;
import org.mvc.security.entity.UserRoleEntity;
import org.mvc.security.repository.UserRoleRepository;
import org.mvc.security.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	private UserRoleEntity userRoleEntity;
	private UserRole userRole;
	private List<UserRoleEntity> listOfUserRoleEntity;
	
	@Override
	public void addListUserRole(List<UserRole> listOfUserRole) {
		listOfUserRoleEntity = new ArrayList<UserRoleEntity>();
		for(UserRole userRole : listOfUserRole){
			userRoleEntity = modelMapper.map(userRole, UserRoleEntity.class);
			listOfUserRoleEntity.add(userRoleEntity);
			userRoleEntity= null;
		}
		userRoleRepository.saveAll(listOfUserRoleEntity);
	}

	@Override
	public void deleteUserRoleByUserId(Long userId) {
		userRoleRepository.deleteUserRoleByUserId(userId);
	}

}

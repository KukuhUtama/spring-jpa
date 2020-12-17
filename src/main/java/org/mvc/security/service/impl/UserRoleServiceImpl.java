package org.mvc.security.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.mvc.security.entity.RoleEntity;
import org.mvc.security.entity.UserEntity;
import org.mvc.security.entity.UserRoleEntity;
import org.mvc.security.repository.RoleRepository;
import org.mvc.security.repository.UserRepository;
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
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;

	private UserRoleEntity userRoleEntity, userRoleEntityExist;
	private Optional<UserEntity> userEntityOpt;
	private List<UserRoleEntity> listOfUserRoleEntity, listOfUserRoleEntityExist;
	private List<RoleEntity> listOfRoleEntity;
	
	@Override
	public void addListUserRole(Long userId, List<Long> listOfRoleId) {
		listOfRoleEntity = roleRepository.getListOfRoleByListRoleId(listOfRoleId);
		userEntityOpt = userRepository.findById(userId);
		if(userEntityOpt.isPresent()){
			listOfUserRoleEntity = new ArrayList<UserRoleEntity>();
			for(RoleEntity roleEntity : listOfRoleEntity){
				userRoleEntity = new UserRoleEntity();
				userRoleEntity.setRole(roleEntity);
				userRoleEntity.setUser(userEntityOpt.get());
				listOfUserRoleEntity.add(userRoleEntity);
			}
		}
	    
		listOfUserRoleEntityExist = new ArrayList<UserRoleEntity>();
		for(UserRoleEntity userRoleEntity : listOfUserRoleEntity){
			userRoleEntityExist = userRoleRepository.selectByUserIdAndRoleId(userRoleEntity.getUser().getId(), userRoleEntity.getRole().getId());
			if(userRoleEntityExist != null && userRoleEntityExist.getId() != null){
				userRoleEntityExist.setModifiedDate(new Date());
				listOfUserRoleEntityExist.add(userRoleEntityExist);
			} else {
				userRoleEntity.setCreatedDate(new Date());
				listOfUserRoleEntityExist.add(userRoleEntity);
			}
		    userRoleEntityExist = null;
		}
		userRoleRepository.saveAll(listOfUserRoleEntityExist);
	}

	@Override
	public void deleteUserRoleByUserId(Long userId) {
		userRoleRepository.deleteUserRoleByUserId(userId);
	}

	@Override
	public void deleteUserRoleByUserIdAndRoleId(Long userId, List<Long> listOfRoleId) {
		userRoleRepository.deleteUserRoleByUserIdAndRoleId(userId, listOfRoleId);
	}

}

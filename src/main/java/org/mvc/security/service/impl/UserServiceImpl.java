package org.mvc.security.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.mvc.security.domain.Role;
import org.mvc.security.domain.User;
import org.mvc.security.entity.RoleEntity;
import org.mvc.security.entity.UserEntity;
import org.mvc.security.repository.RoleRepository;
import org.mvc.security.repository.UserRepository;
import org.mvc.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	private Optional<UserEntity> userEntityOpt;
	private UserEntity userEntity;
	private User user;
	private List<UserEntity> listOfUserEntity;
	private List<User> listOfUser;
	private List<RoleEntity> listOfRoleEntity;
	private List<Role> listOfRole;
	
	@Override
	public void addUser(User user) {
		userEntity = modelMapper.map(user, UserEntity.class);
		userRepository.save(userEntity);
	}

	@Override
	public User getUserById(Long id) {
		userEntityOpt = userRepository.findById(id);
		listOfRoleEntity = (List<RoleEntity>) roleRepository.findAll();
		listOfRole = listOfRoleEntity.stream()
				     .map(RoleEntity -> modelMapper.map(RoleEntity, Role.class))
				     .collect(Collectors.toList());
		user = modelMapper.map(userEntityOpt.get(), User.class);
		user.setListRole(listOfRole);
		return user;
	}

	@Override
	public List<User> getListOfUser() {
		listOfUserEntity = (List<UserEntity>) userRepository.findAll();
		listOfUser = listOfUserEntity
				  .stream()
				  .map(UserEntity -> modelMapper.map(UserEntity, User.class))
				  .collect(Collectors.toList());
		return listOfUser;
	}

	@Override
	public void deleteUserById(Long id) {
         userRepository.deleteById(id);	
	}

}

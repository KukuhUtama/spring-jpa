package org.mvc.security.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.mvc.security.domain.User;
import org.mvc.security.entity.UserEntity;
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
	
	private Optional<UserEntity> userEntityOpt;
	private UserEntity userEntity;
	private User user;
	private List<UserEntity> listOfUserEntity;
	private List<User> listOfUser;
	
	@Override
	public void addUser(User user) {
		userEntity = modelMapper.map(user, UserEntity.class);
		userRepository.save(userEntity);
	}

	@Override
	public User getUserById(Long id) {
		userEntityOpt = userRepository.findById(id);
		user = modelMapper.map(userEntityOpt.get(), User.class);
		return user;
	}

	@Override
	public List<User> getListOfUser() {
		listOfUserEntity = (List<UserEntity>) userRepository.findAll();
		List<User> listOfUser = listOfUserEntity
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

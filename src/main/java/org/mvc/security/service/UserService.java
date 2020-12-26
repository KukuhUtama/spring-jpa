package org.mvc.security.service;

import java.util.List;
import java.util.Map;

import org.mvc.security.domain.User;

public interface UserService {
	public void addUser(User user);
	public User getUserById(Long id);
	public List<User> getListOfUser();
	public void deleteUserById(Long id);
	public  Map<String, List<String>>  getRoleAndUrlAddressMap();
	public User findByUserName(String username);
}

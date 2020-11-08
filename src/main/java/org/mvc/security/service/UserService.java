package org.mvc.security.service;

import java.util.List;

import org.mvc.security.domain.User;

public interface UserService {
	public void addUser(User user);
	public User getUserById(Long id);
	public List<User> getListOfUser();
	public void deleteUserById(Long id);
}

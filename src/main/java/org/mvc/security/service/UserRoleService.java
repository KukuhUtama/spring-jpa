package org.mvc.security.service;

import java.util.List;

public interface UserRoleService {
	public void addListUserRole(Long userId, List<Long> listOfRoleId);
	public void deleteUserRoleByUserId(Long userId);
	public void deleteUserRoleByUserIdAndRoleId(Long userId,  List<Long> listOfRoleId);
}

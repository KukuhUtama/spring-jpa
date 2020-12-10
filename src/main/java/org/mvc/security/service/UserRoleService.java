package org.mvc.security.service;

import java.util.List;

import org.mvc.security.domain.UserRole;

public interface UserRoleService {
	public void addListUserRole(List<UserRole> listOfUserRole);
	public void deleteUserRoleByUserId(Long userId);
}

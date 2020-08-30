package org.mvc.security.service;

import java.util.List;

import org.mvc.security.domain.Role;

public interface RoleService {
	public void addRole(Role role);
	public List<Role> getListOfRole();
	public void deleteRoleById(Long id);
}

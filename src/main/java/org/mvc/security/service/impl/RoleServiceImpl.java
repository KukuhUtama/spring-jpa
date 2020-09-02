package org.mvc.security.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.mvc.security.domain.Role;
import org.mvc.security.entity.RoleEntity;
import org.mvc.security.repository.RoleRepository;
import org.mvc.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RoleRepository roleRepository;

	private Optional<RoleEntity> roleEntityOpt;
	private RoleEntity roleEntity;
	private Role role;
	private List<RoleEntity> listOfRoleEntity;
	private List<Role> listOfRole;
	
	@Override
	public void addRole(Role role) {
		roleEntity = modelMapper.map(role, RoleEntity.class);
		roleRepository.save(roleEntity);
	}

	@Override
	public List<Role> getListOfRole() {
		listOfRoleEntity = (List<RoleEntity>) roleRepository.findAll();
		List<Role> listOfRole = listOfRoleEntity
				  .stream()
				  .map(RoleEntity -> modelMapper.map(RoleEntity, Role.class))
				  .collect(Collectors.toList());
		return listOfRole;
	}

	@Override
	public void deleteRoleById(Long id) {
		roleRepository.deleteById(id);
	}

	@Override
	public Role getRoleById(Long id) {
		roleEntityOpt = roleRepository.findById(id);
		role = modelMapper.map(roleEntityOpt.get(), Role.class);
		return role;
	}

	@Override
	public void updateRole(Role role) {
		roleEntity = modelMapper.map(role, RoleEntity.class);
		roleRepository.updateRole(roleEntity.getId(), roleEntity.getRoleName());
	}

}

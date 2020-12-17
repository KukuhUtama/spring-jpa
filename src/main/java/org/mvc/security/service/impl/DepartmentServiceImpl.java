package org.mvc.security.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.mvc.security.domain.Department;
import org.mvc.security.domain.Group;
import org.mvc.security.entity.DepartmentEntity;
import org.mvc.security.entity.GroupEntity;
import org.mvc.security.repository.DepartmentRepository;
import org.mvc.security.repository.GroupRepository;
import org.mvc.security.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{


	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	private Optional<GroupEntity> groupEntityOpt;
	private GroupEntity groupEntity;
	private Group group;
	
	private Optional<DepartmentEntity> departmentEntityOpt;
	private DepartmentEntity departmentEntity;
	private Department department;
	private List<Department> listOfDepartment;
	private List<DepartmentEntity> listOfDepartmentEntity;
	
	
	@Override
	public Department addDepartment(Department department) {
		groupEntityOpt = groupRepository.findById(department.getIdGroup());
		if(groupEntityOpt.isPresent()){
			departmentEntity = modelMapper.map(department, DepartmentEntity.class);
			departmentEntity.setGroup(groupEntityOpt.get());
			departmentEntity = departmentRepository.save(departmentEntity);
		}
        department = modelMapper.map(departmentEntity, Department.class);
        department.setIdGroup(departmentEntity.getGroup().getId());
		
		return department;
	}

	@Override
	public Department getDepartmentById(Long id) {
		departmentEntityOpt = departmentRepository.findById(id);
		if(departmentEntityOpt.isPresent()){
		   department = modelMapper.map(departmentEntityOpt.get(), Department.class);
		   department.setIdGroup(departmentEntityOpt.get().getGroup().getId());
		}
     
		return department;
	}

	@Override
	public List<Department> getListOfDepartmentByGroupId(Long groupId) {
		listOfDepartmentEntity = (List<DepartmentEntity>) departmentRepository.getListOfDepartmentByGroupId(groupId);
		List<Department> listOfDepartment = listOfDepartmentEntity
				  .stream()
				  .map(DepartmentEntity -> modelMapper.map(DepartmentEntity, Department.class))
				  .collect(Collectors.toList());
		return listOfDepartment;
	}

}

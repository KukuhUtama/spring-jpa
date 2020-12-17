package org.mvc.security.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.mvc.security.domain.Department;
import org.mvc.security.domain.Group;
import org.mvc.security.entity.DepartmentEntity;
import org.mvc.security.entity.GroupEntity;
import org.mvc.security.repository.DepartmentRepository;
import org.mvc.security.repository.GroupRepository;
import org.mvc.security.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("groupService")
public class GroupServiceImpl implements GroupService{


	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	private Optional<GroupEntity> groupEntityOpt;
	private GroupEntity groupEntity;
	private Group group;
	private Department department;
	private List<Department> listDepartment;
	private List<GroupEntity> listOfGroupEntity;
	private List<DepartmentEntity> listDepartmentEntity;
	private Map<Long,List<Department>> mapOfListDepartment;
	
	@Override
	public Group addGroup(Group group) {
        groupEntity = modelMapper.map(group, GroupEntity.class);
        groupEntity = groupRepository.save(groupEntity);
        group = modelMapper.map(groupEntity, Group.class);
		return group;
	}

	@Override
	public Group getGroupById(Long id) {
		groupEntityOpt = groupRepository.findById(id);
		group = modelMapper.map(groupEntityOpt.get(), Group.class);
		return group;
	}

	@Override
	public List<Group> getListOfGroup() {
		listOfGroupEntity = (List<GroupEntity>) groupRepository.findAll();
		mapOfListDepartment = new HashMap<Long,List<Department>>();
		
		for(GroupEntity el : listOfGroupEntity){
			listDepartmentEntity = departmentRepository.getListOfDepartmentByGroupId(el.getId());
			listDepartment = new ArrayList<Department>();
			for(DepartmentEntity de : listDepartmentEntity){
				department = modelMapper.map(de, Department.class);
				listDepartment.add(department);
			}
			mapOfListDepartment.put(el.getId(), listDepartment);
		}
		
		List<Group> listOfGroup = listOfGroupEntity
				  .stream()
				  .map(GroupEntity -> modelMapper.map(GroupEntity, Group.class))
				  .collect(Collectors.toList());
	
		for(Group gr : listOfGroup){
			gr.setListOfDepartement(mapOfListDepartment.get(gr.getId()));
		}
		
		return listOfGroup;
	}

	@Override
	public Integer deleteGropuById(Long id) {
		return groupRepository.deleteGroupById(id);
	}

}

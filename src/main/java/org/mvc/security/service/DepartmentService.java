package org.mvc.security.service;

import java.util.List;

import org.mvc.security.domain.Department;

public interface DepartmentService {
    public Department addDepartment(Department department);
    public Department getDepartmentById(Long id);
    public List<Department> getListOfDepartmentByGroupId(Long groupId);
}

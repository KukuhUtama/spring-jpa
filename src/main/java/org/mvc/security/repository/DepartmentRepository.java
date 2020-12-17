package org.mvc.security.repository;

import java.util.List;

import org.mvc.security.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Long>{
	 @Query("SELECT d FROM DepartmentEntity d WHERE d.group.id = :groupId")
     public List<DepartmentEntity> getListOfDepartmentByGroupId(@Param("groupId") Long groupId);
}

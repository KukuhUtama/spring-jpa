package org.mvc.security.repository;


import java.util.Collection;
import java.util.List;

import org.mvc.security.entity.RoleEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

    @Query("SELECT r FROM RoleEntity r INNER JOIN UserRoleEntity ur ON r.id = ur.role.id WHERE ur.user.id= :userId")
	public List<RoleEntity> getListOfRoleByUserId(@Param("userId") Long userId);
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM RoleEntity r WHERE r.id NOT IN (SELECT role.id FROM UserRoleEntity) AND r.id = :roleId")
    public int deleteRoleById(@Param("roleId") Long roleId);
    
    @Query("SELECT r FROM RoleEntity r WHERE r.id IN :ids")
    public List<RoleEntity> getListOfRoleByListRoleId(@Param("ids") Collection<Long> listOfRoleId);
	
}

package org.mvc.security.repository;


import java.util.List;

import org.mvc.security.entity.RoleEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
	
	@Transactional
	@Modifying(clearAutomatically = true)
    @Query("UPDATE RoleEntity c SET c.roleName = :roleName WHERE c.id = :roleId")
    public int updateRole(@Param("roleId") Long roleId, @Param("roleName") String roleName);
	
    @Query("SELECT r FROM RoleEntity r INNER JOIN UserRoleEntity ur ON r.id = ur.roleId WHERE ur.userId= :userId")
	public List<RoleEntity> getListOfRoleByUserId(@Param("userId") Long userId);
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM RoleEntity r WHERE r.id NOT IN (SELECT roleId FROM UserRoleEntity) AND r.id = :roleId")
    public int deleteRoleById(@Param("roleId") Long roleId);
	
}

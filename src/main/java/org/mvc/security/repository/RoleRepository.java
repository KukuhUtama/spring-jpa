package org.mvc.security.repository;


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
    int updateRole(@Param("roleId") Long roleId, @Param("roleName") String roleName);
}

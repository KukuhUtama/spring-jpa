package org.mvc.security.repository;

import java.util.Collection;

import org.mvc.security.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRoleRepository extends CrudRepository<UserRoleEntity, Long>{
	
	 @Transactional
	 @Modifying(clearAutomatically = true)
	 @Query("DELETE FROM UserRoleEntity u WHERE u.user.id = :userId") 
	 public void deleteUserRoleByUserId(@Param("userId") Long userId);
	 
	 
	 @Transactional
	 @Modifying(clearAutomatically = true)
	 @Query("DELETE FROM UserRoleEntity u WHERE u.user.id = :userId AND u.role.id NOT IN :ids") 
	 public void deleteUserRoleByUserIdAndRoleId(@Param("userId") Long userId, @Param("ids") Collection<Long> listOfRoleId);
	 
	 @Query("SELECT ur FROM UserRoleEntity ur WHERE ur.user.id = :userId and ur.role.id= :roleId")
	 public UserRoleEntity selectByUserIdAndRoleId(@Param("userId") Long userId, @Param("roleId") Long roleId);
}

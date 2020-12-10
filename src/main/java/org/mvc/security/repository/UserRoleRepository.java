package org.mvc.security.repository;

import org.mvc.security.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRoleRepository extends CrudRepository<UserRoleEntity, Long>{
	
	 @Transactional
	 @Modifying(clearAutomatically = true)
	 @Query("DELETE FROM UserRoleEntity u WHERE u.userId = :userId") 
	 public void deleteUserRoleByUserId(@Param("userId") Long userId);
}

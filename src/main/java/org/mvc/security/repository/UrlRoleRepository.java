package org.mvc.security.repository;

import java.util.Collection;

import org.mvc.security.entity.UrlRoleEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UrlRoleRepository  extends CrudRepository<UrlRoleEntity, Long>{
	
	 @Transactional
	 @Modifying(clearAutomatically = true)
	 @Query("DELETE FROM UrlRoleEntity u WHERE u.role.id = :roleId") 
	 public void deleteUrlRoleByRoleId(@Param("roleId") Long roleId);
	 
	 @Transactional
	 @Modifying(clearAutomatically = true)
	 @Query("DELETE FROM UrlRoleEntity u WHERE u.role.id = :roleId AND u.url.id NOT IN :ids") 
	 public void deleteUrlRoleByRoleIdAndUrlId(@Param("roleId") Long roleId, @Param("ids") Collection<Long> listOfUrlId);
	
     @Query("SELECT u FROM UrlRoleEntity u WHERE u.role.id = :roleId and u.url.id= :urlId")
	 public UrlRoleEntity selectByUserIdAndRoleId(@Param("roleId") Long roleId, @Param("urlId") Long urlId);
}

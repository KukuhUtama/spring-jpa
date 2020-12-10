package org.mvc.security.repository;

import org.mvc.security.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	 @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName") 
	 public UserEntity findByUserName(@Param("userName") String userName);
	 
}

package org.mvc.security.repository;

import org.mvc.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Integer> {
	 @Query("SELECT u FROM User u WHERE u.userName = :userName") public User
	 findByUserName(@Param("userName") String userName);
}

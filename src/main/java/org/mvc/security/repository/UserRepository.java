package org.mvc.security.repository;

import java.util.List;

import org.mvc.security.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	 @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName") 
	 public UserEntity findByUserName(@Param("userName") String username);
	 
	 @Query(value="SELECT ro.role_name, url.url_address FROM  t_url url "+
	 		"INNER JOIN t_url_role ur ON  url.url_id = ur.url_id "+
            "INNER JOIN (SELECT ro.* FROM t_user usr, t_role ro, t_user_role usro WHERE usr.user_id = usro.user_id AND ro.role_id = usro.role_id) as ro ON ro.role_id = ur.role_id", nativeQuery = true)
	 public  List<Object[]> getRoleAndUrlAddressMap();

	 
}

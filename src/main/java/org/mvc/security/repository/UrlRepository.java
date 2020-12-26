package org.mvc.security.repository;

import java.util.Collection;
import java.util.List;

import org.mvc.security.entity.UrlEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UrlRepository extends CrudRepository<UrlEntity, Long> {

    @Query("SELECT r FROM UrlEntity r INNER JOIN UrlRoleEntity ur ON r.id = ur.url.id WHERE ur.role.id= :roleId")
	public List<UrlEntity> getListOfUrlByRoleId(@Param("roleId") Long roleId);
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM UrlEntity r WHERE r.id NOT IN (SELECT url.id FROM UrlRoleEntity) AND r.id = :urlId")
    public int deleteUrlById(@Param("urlId") Long urlId);
    
    @Query("SELECT r FROM UrlEntity r WHERE r.id IN :ids")
    public List<UrlEntity> getListOfUrlByListUrlId(@Param("ids") Collection<Long> listOfUrlId);
}

package org.mvc.security.repository;

import org.mvc.security.entity.GroupEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface GroupRepository extends CrudRepository<GroupEntity, Long>{

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM GroupEntity g WHERE g.id = :groupId")
    public int deleteGroupById(@Param("groupId") Long groupId);
}

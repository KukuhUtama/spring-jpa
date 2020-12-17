package org.mvc.security.service;

import java.util.List;

import org.mvc.security.domain.Group;

public interface GroupService {
     public Group addGroup(Group group);
     public Group getGroupById(Long id);
     public List<Group> getListOfGroup();
     public Integer deleteGropuById(Long id);
}

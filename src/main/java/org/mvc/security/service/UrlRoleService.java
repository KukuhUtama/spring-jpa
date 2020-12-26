package org.mvc.security.service;

import java.util.List;

public interface UrlRoleService {
	public void addListUrlRole(Long roleId, List<Long> listOfUrlId);
	public void deleteUrlRoleByRoleId(Long roleId);
	public void deleteUrlRoleByUrlIdAndRoleId(Long roleId,  List<Long> listOfUrlId);
	public void updateListUrlRole(Long roleId, List<Long> listOfUrlId);
}

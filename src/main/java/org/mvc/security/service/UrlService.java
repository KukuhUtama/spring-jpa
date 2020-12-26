package org.mvc.security.service;

import java.util.List;
import org.mvc.security.domain.Url;

public interface UrlService {
	public void addUrl(Url url);
	public List<Url> getListOfUrl();
	public Integer deleteUrlById(Long id);
	public Url getUrlById(Long id);
	public void updateUrl(Url url);
	public List<Url> getListOfUrlByRoleId(Long roleId);
}

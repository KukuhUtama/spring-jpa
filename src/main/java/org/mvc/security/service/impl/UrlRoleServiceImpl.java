package org.mvc.security.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.mvc.security.entity.RoleEntity;
import org.mvc.security.entity.UrlEntity;
import org.mvc.security.entity.UrlRoleEntity;
import org.mvc.security.entity.UserEntity;
import org.mvc.security.entity.UserRoleEntity;
import org.mvc.security.repository.RoleRepository;
import org.mvc.security.repository.UrlRepository;
import org.mvc.security.repository.UrlRoleRepository;
import org.mvc.security.repository.UserRepository;
import org.mvc.security.repository.UserRoleRepository;
import org.mvc.security.service.UrlRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("urlRoleService")
public class UrlRoleServiceImpl implements UrlRoleService{

	@Autowired
	private UserRoleRepository userRoleRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UrlRepository urlRepository;
	@Autowired
	private UrlRoleRepository urlRoleRepository;

	private UrlRoleEntity urlRoleEntity;
	
	private Optional<RoleEntity> roleEntityOpt;
	private Optional<UrlRoleEntity> urlRoleEntityopt;
	private UrlRoleEntity urlRoleEntityExist;
	
	private List<UrlEntity> listOfUrlEntity;
	private List<UrlRoleEntity> listOfUrlRoleEntity, listOfUrlRoleEntityExist;
	
	@Override
	public void addListUrlRole(Long roleId, List<Long> listOfUrlId) {
		listOfUrlEntity = urlRepository.getListOfUrlByListUrlId(listOfUrlId);
		roleEntityOpt = roleRepository.findById(roleId);
		
		if(roleEntityOpt.isPresent()){
			listOfUrlRoleEntity = new ArrayList<UrlRoleEntity>();
			for(UrlEntity urlEntity : listOfUrlEntity){
				urlRoleEntity = new UrlRoleEntity();
				urlRoleEntity.setCreatedDate(new Date());
				urlRoleEntity.setRole(roleEntityOpt.get());
				urlRoleEntity.setUrl(urlEntity);
				listOfUrlRoleEntity.add(urlRoleEntity);
			}
		}
		urlRoleRepository.saveAll(listOfUrlRoleEntity);
	}

	@Override
	public void deleteUrlRoleByRoleId(Long roleId) {
		urlRoleRepository.deleteUrlRoleByRoleId(roleId);
	}

	@Override
	public void deleteUrlRoleByUrlIdAndRoleId(Long roleId, List<Long> listOfUrlId) {
		urlRoleRepository.deleteUrlRoleByRoleIdAndUrlId(roleId, listOfUrlId);
	}

	@Override
	public void updateListUrlRole(Long roleId, List<Long> listOfUrlId) {
		listOfUrlEntity = urlRepository.getListOfUrlByListUrlId(listOfUrlId);
		roleEntityOpt = roleRepository.findById(roleId);
		if (roleEntityOpt.isPresent()) {
			listOfUrlRoleEntity = new ArrayList<UrlRoleEntity>();
			for (UrlEntity urlEntity : listOfUrlEntity) {
				urlRoleEntity = new UrlRoleEntity();
				urlRoleEntity.setRole(roleEntityOpt.get());
				urlRoleEntity.setUrl(urlEntity);
				listOfUrlRoleEntity.add(urlRoleEntity);
			}
		}

		listOfUrlRoleEntityExist = new ArrayList<UrlRoleEntity>();
		for (UrlRoleEntity urlRoleEntity : listOfUrlRoleEntity) {
			urlRoleEntityExist = urlRoleRepository.selectByUserIdAndRoleId(urlRoleEntity.getRole().getId(),urlRoleEntity.getUrl().getId());
			if (urlRoleEntityExist != null && urlRoleEntityExist.getId() != null) {
				urlRoleEntityExist.setModifiedDate(new Date());
				listOfUrlRoleEntityExist.add(urlRoleEntityExist);
			} else {
				urlRoleEntity.setCreatedDate(new Date());
				listOfUrlRoleEntityExist.add(urlRoleEntity);
			}
		}

		urlRoleRepository.saveAll(listOfUrlRoleEntityExist);
	}

}

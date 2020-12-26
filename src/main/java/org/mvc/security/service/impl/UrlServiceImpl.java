package org.mvc.security.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.mvc.security.domain.Url;
import org.mvc.security.entity.UrlEntity;
import org.mvc.security.repository.UrlRepository;
import org.mvc.security.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UrlRepository urlRepository;
	
	private Optional<UrlEntity> urlEntityOpt;
	private UrlEntity urlEntity;
	private Url url;
	private List<UrlEntity> listOfUrleEntity;
	private List<Url> listOfUrl;

	@Override
	public void addUrl(Url url) {
		urlEntity = modelMapper.map(url, UrlEntity.class);
		urlRepository.save(urlEntity);
	}

	@Override
	public List<Url> getListOfUrl() {
		listOfUrleEntity = (List<UrlEntity>) urlRepository.findAll();
		listOfUrl = listOfUrleEntity
				  .stream()
				  .map(UrlEntity -> modelMapper.map(UrlEntity, Url.class))
				  .collect(Collectors.toList());
		return listOfUrl;
	}

	@Override
	public Integer deleteUrlById(Long id) {
		return urlRepository.deleteUrlById(id);
	}

	@Override
	public Url getUrlById(Long id) {
		urlEntityOpt = urlRepository.findById(id);
		url = modelMapper.map(urlEntityOpt.get(), Url.class);
		return url;
	}

	@Override
	public void updateUrl(Url url) {
		urlEntity = modelMapper.map(url, UrlEntity.class);
		urlRepository.save(urlEntity);
	}

	@Override
	public List<Url> getListOfUrlByRoleId(Long roleId) {
		listOfUrleEntity = (List<UrlEntity>) urlRepository.getListOfUrlByRoleId(roleId);
		listOfUrl = listOfUrleEntity
				  .stream()
				  .map(UrlEntity -> modelMapper.map(UrlEntity, Url.class))
				  .collect(Collectors.toList());
		return listOfUrl;
	}

}

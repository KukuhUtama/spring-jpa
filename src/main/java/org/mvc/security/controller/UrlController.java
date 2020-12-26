package org.mvc.security.controller;

import java.util.Date;
import java.util.List;

import org.mvc.security.domain.Url;
import org.mvc.security.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/url")
public class UrlController {

	@Autowired
	private UrlService urlService;
	
	private ModelAndView mv;
	private Url url, currentUrl;
	private boolean isUpdate = false;
	private List<Url> listOfUrl;
	
	@RequestMapping(value = "/add-url.html", method = RequestMethod.GET)
	public ModelAndView addUrl() {
		mv = new ModelAndView("add-url");
		return mv;
	}
	
	@RequestMapping(value = "/add-url.html", method = RequestMethod.POST)
	public String addUrlProcess(@ModelAttribute("url")Url url) {
		mv = new ModelAndView("add-url");
		url.setCreatedDate(new Date());
		urlService.addUrl(url);
		return  "redirect:/url/list-url.html";
	}
	
	@RequestMapping(value = "/list-url.html", method = RequestMethod.GET)
	public ModelAndView getAllUrl() {
		mv = new ModelAndView("list-url");
		listOfUrl = urlService.getListOfUrl();
		mv.addObject("listOfUrl", listOfUrl);
		return mv;
	}
	
	@RequestMapping(value = "/delete-url-by-id.html", method = RequestMethod.GET)
	public String deleteUrlById(Integer urlId) {
		if(urlId != null) {
	        Long id = Long.valueOf(urlId.longValue());
			urlService.deleteUrlById(id);	
		}
		return  "redirect:/url/list-url.html";
	}
	
	@RequestMapping(value = "/update-url.html", method = RequestMethod.GET)
	public ModelAndView updateUrl(Integer urlId) {
		mv = new ModelAndView("update-url");
		isUpdate = true;
		if(urlId != null) {
	        Long id = Long.valueOf(urlId.longValue());
			url = urlService.getUrlById(id);	
		}
		mv.addObject("url", url);
		mv.addObject("isUpdate", isUpdate);
		return mv;
	}
	
	@RequestMapping(value = "/update-url.html", method = RequestMethod.POST)
	public String updateUrlProcess(@ModelAttribute("url")Url url) {
		currentUrl = urlService.getUrlById(url.getId());
		currentUrl.setUrlAddress(url.getUrlAddress());
		currentUrl.setModifiedDate(new Date());
		urlService.updateUrl(currentUrl);
		return  "redirect:/url/list-url.html";
	}
}

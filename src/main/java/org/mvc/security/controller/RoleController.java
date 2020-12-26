package org.mvc.security.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mvc.security.domain.Role;
import org.mvc.security.domain.Url;
import org.mvc.security.service.RoleService;
import org.mvc.security.service.UrlRoleService;
import org.mvc.security.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private UrlService urlService;
	@Autowired
	private UrlRoleService urlRoleService;
	  
	private ModelAndView mv;
	private Role role, currentRole;
	private boolean isUpdate = false;
	private List<Role> listOfRole;
	private List<Url> listOfUrl;
	private List<Integer> listUrlSelected;
	private List<Long> listOfUrlId;
	
	@RequestMapping(value = "/add-role.html", method = RequestMethod.GET)
	public ModelAndView addRole() {
		mv = new ModelAndView("add-role");
		listOfUrl = urlService.getListOfUrl();
		mv.addObject("listOfUrl", listOfUrl);
		return mv;
	}
	
	@RequestMapping(value = "/add-role.html", method = RequestMethod.POST)
	public String addRoleProcess(@ModelAttribute("role")Role role, @RequestParam(required = false)String urlsSelected) {
		mv = new ModelAndView("add-role");
		
		role.setCreatedDate(new Date());
		role = roleService.addRole(role);
		
		if(urlsSelected != null && !"".equals(urlsSelected)){
			String [] arrUrl = urlsSelected.split(",");
			if(arrUrl != null && arrUrl.length > 0){
				listOfUrlId = new ArrayList<Long>();
				for(int i=0; i<arrUrl.length; i++){
					listOfUrlId.add(Long.valueOf(arrUrl[i]));
				}
				urlRoleService.addListUrlRole(role.getId(), listOfUrlId);
			}
		}
		return  "redirect:/role/list-role.html";
	}
	
	@RequestMapping(value = "/list-role.html", method = RequestMethod.GET)
	public ModelAndView getAllRole() {
		mv = new ModelAndView("list-role");
		listOfRole = roleService.getListOfRole();
		mv.addObject("listOfRole", listOfRole);
		return mv;
	}
	
	@RequestMapping(value = "/delete-role-by-id.html", method = RequestMethod.GET)
	public String deleteRoleById(Integer roleId) {
		if(roleId != null) {
	        Long id = Long.valueOf(roleId.longValue());
			roleService.deleteRoleById(id);	
		}
		return  "redirect:/role/list-role.html";
	}
	
	@RequestMapping(value = "/update-role.html", method = RequestMethod.GET)
	public ModelAndView updateRole(Integer roleId) {
		mv = new ModelAndView("update-role");
		listUrlSelected = new ArrayList<Integer>();
		listOfUrl = urlService.getListOfUrl();
		isUpdate = true;
		
		if(roleId != null) {
	        Long id = Long.valueOf(roleId.longValue());
			role = roleService.getRoleById(id);	
			role.setListOfUrl(urlService.getListOfUrlByRoleId(role.getId()));
			for(Url url : role.getListOfUrl()){
				listUrlSelected.add(url.getId().intValue());
			}
		}
		
		mv.addObject("role", role);
		mv.addObject("listOfUrl", listOfUrl);
		mv.addObject("listUrlSelected", listUrlSelected);
		mv.addObject("isUpdate", isUpdate);
		return mv;
	}
	
	@RequestMapping(value = "/update-role.html", method = RequestMethod.POST)
	public String updateRoleProcess(@ModelAttribute("role")Role role, @RequestParam(required = false)String urlsSelected) {
		
		if(urlsSelected != null && !"".equals(urlsSelected)){
			String [] arrUrl = urlsSelected.split(",");
			if(arrUrl != null && arrUrl.length > 0){
				listOfUrlId = new ArrayList<Long>();
				for(int i=0; i<arrUrl.length; i++){
					listOfUrlId.add(Long.valueOf(arrUrl[i]));
				}
				urlRoleService.deleteUrlRoleByUrlIdAndRoleId(role.getId(), listOfUrlId);
				urlRoleService.updateListUrlRole(role.getId(), listOfUrlId);
			}
		}
		
		currentRole = roleService.getRoleById(role.getId());
		currentRole.setRoleName(role.getRoleName());
		currentRole.setModifiedDate(new Date());
		roleService.updateRole(currentRole);
		return  "redirect:/role/list-role.html";
	}
	
}

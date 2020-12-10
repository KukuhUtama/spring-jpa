package org.mvc.security.controller;


import java.util.List;

import org.mvc.security.domain.Role;
import org.mvc.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	  
	  
	private ModelAndView mv;
	private Role role;
	private boolean isUpdate = false;
	private List<Role> listOfRole;
	
	@RequestMapping(value = "/add-role.html", method = RequestMethod.GET)
	public ModelAndView addRole() {
		mv = new ModelAndView("add-role");
		return mv;
	}
	
	
	@RequestMapping(value = "/add-role.html", method = RequestMethod.POST)
	public String addRoleProcess(Role role) {
		mv = new ModelAndView("add-role");
		roleService.addRole(role);
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
		isUpdate = true;
		if(roleId != null) {
	        Long id = Long.valueOf(roleId.longValue());
			role = roleService.getRoleById(id);	
		}
		mv.addObject("role", role);
		mv.addObject("isUpdate", isUpdate);
		return mv;
	}
	
	
	@RequestMapping(value = "/update-role.html", method = RequestMethod.POST)
	public String updateRoleProcess(Role role) {
		roleService.updateRole(role);
		return  "redirect:/role/list-role.html";
	}
	

}

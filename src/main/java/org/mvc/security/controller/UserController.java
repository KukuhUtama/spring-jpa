package org.mvc.security.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mvc.security.domain.Role;
import org.mvc.security.domain.User;
import org.mvc.security.service.RoleService;
import org.mvc.security.service.UserRoleService;
import org.mvc.security.service.UserService;
import org.mvc.security.util.Utililty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserRoleService userRoleService;
	  
	private ModelAndView mv;
	private User user, currentUser;
	private List<Integer> listRoleSelected;
	private List<Long> listOfRoleId;
	private List<User> listOfUser;
	private List<Role> listOfRole;

	@RequestMapping(value = "/add-user.html", method = RequestMethod.GET)
	public ModelAndView addUser() {
		mv = new ModelAndView("add-user");
		listOfRole = roleService.getListOfRole();
		mv.addObject("listOfRole", listOfRole);
		return mv;
	}
	
	@RequestMapping(value = "/add-user.html", method = RequestMethod.POST)
	public String addUserProcess(@ModelAttribute("user")User user) {
		mv = new ModelAndView("add-user");
		user.setCreatedDate(new Date());
		user.setPassword(Utililty.passwordEncoder().encode(user.getPassword()));
		user.setIsActive(user.getIsActive() == null ? false : true);
		userService.addUser(user);
		return  "redirect:/user/list-user.html";
	}
	
	
	@RequestMapping(value = "/list-user.html", method = RequestMethod.GET)
	public ModelAndView getAllRole() {
		mv = new ModelAndView("list-user");
		listOfUser = userService.getListOfUser();
		mv.addObject("listOfUser", listOfUser);
		return mv;
	}
	
	@RequestMapping(value = "/delete-user-by-id.html", method = RequestMethod.GET)
	public String deleteUserById(Integer userId) {
		if(userId != null) {
	        Long id = Long.valueOf(userId.longValue());
			userService.deleteUserById(id);	
			userRoleService.deleteUserRoleByUserId(id);
		}
		return  "redirect:/user/list-user.html";
	}
	
	@RequestMapping(value = "/update-user.html", method = RequestMethod.GET)
	public ModelAndView updateUser(Integer userId) {
		mv = new ModelAndView("update-user");
		listRoleSelected = new ArrayList<Integer>();
		listOfRole = roleService.getListOfRole();
		
		if(userId != null) {
	        Long id = Long.valueOf(userId.longValue());
			user = userService.getUserById(id);
			user.setListRole(roleService.getListOfRoleByUserId(id));
			for(Role role : user.getListOfRole()){
				listRoleSelected.add(role.getId().intValue());
			}
		}
		
		mv.addObject("listRoleSelected", listRoleSelected);
		mv.addObject("listOfRole", listOfRole);
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping(value = "/update-user.html", method = RequestMethod.POST)
	public String updateUserProcess(@ModelAttribute("user")User user, @RequestParam(required = false)String rolesSelected) {
		mv = new ModelAndView("add-user");
		if(rolesSelected != null && !"".equals(rolesSelected)){
			String [] arrRole = rolesSelected.split(",");
			if(arrRole != null && arrRole.length > 0){
				listOfRoleId = new ArrayList<Long>();
				for(int i=0; i<arrRole.length; i++){
					listOfRoleId.add(Long.valueOf(arrRole[i]));
				}
				userRoleService.deleteUserRoleByUserIdAndRoleId(user.getId(), listOfRoleId);
				userRoleService.addListUserRole(user.getId(), listOfRoleId);
			}
		}
		currentUser = userService.getUserById(user.getId());
		currentUser.setPassword(Utililty.passwordEncoder().encode(user.getPassword()));
		currentUser.setPasswordConfirm(user.getPasswordConfirm());
		currentUser.setUserName(user.getUserName()); 
		currentUser.setModifiedDate(new Date());
		currentUser.setIsActive(user.getIsActive() == null ? false : true);
		userService.addUser(currentUser);
		return  "redirect:/user/update-user.html?userId="+user.getId();
	}
	

}

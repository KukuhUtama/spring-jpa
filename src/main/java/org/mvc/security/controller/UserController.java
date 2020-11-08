package org.mvc.security.controller;

import java.util.List;

import org.mvc.security.domain.User;
import org.mvc.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	  
	private ModelAndView mv;
	private User user;
	private List<User> listOfUser;
	
	@RequestMapping(value = "/add-user.html", method = RequestMethod.GET)
	public ModelAndView addUser() {
		mv = new ModelAndView("add-user");
		return mv;
	}
	
	@RequestMapping(value = "/add-user.html", method = RequestMethod.POST)
	public String addUserProcess(User user) {
		mv = new ModelAndView("add-user");
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
		}
		return  "redirect:/user/list-user.html";
	}
	
	
	@RequestMapping(value = "/update-user.html", method = RequestMethod.GET)
	public ModelAndView updateUser(Integer userId) {
		mv = new ModelAndView("update-user");
		if(userId != null) {
	        Long id = Long.valueOf(userId.longValue());
			user = userService.getUserById(id);
		}
		mv.addObject("user", user);
		return mv;
	}
	
	
}

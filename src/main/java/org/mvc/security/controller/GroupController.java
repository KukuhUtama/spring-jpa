package org.mvc.security.controller;

import java.util.Date;
import java.util.List;

import org.mvc.security.domain.Group;
import org.mvc.security.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/group")
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	  
	private ModelAndView mv;
	private boolean isUpdate;
	private Group group, currentGroup;
	private List<Group> listOfGroup;
	
	@RequestMapping(value = "/add-group.html", method = RequestMethod.GET)
	public ModelAndView addGroup() {
		mv = new ModelAndView("add-group");
		return mv;
	}
	
	@RequestMapping(value = "/add-group.html", method = RequestMethod.POST)
	public String addGroupProcess(@ModelAttribute("group")Group group) {
        group.setCreatedDate(new Date());
        groupService.addGroup(group);
		return  "redirect:/group/list-group.html";
	}
	
	@RequestMapping(value = "/list-group.html", method = RequestMethod.GET)
	public ModelAndView getAllRole() {
		mv = new ModelAndView("list-group");
		listOfGroup = groupService.getListOfGroup();
		mv.addObject("listOfGroup", listOfGroup);
		return mv;
	}
	
	@RequestMapping(value = "/update-group.html", method = RequestMethod.GET)
	public ModelAndView updateGroup(Integer groupId) {
		mv = new ModelAndView("update-group");
		isUpdate = true;
		if(groupId != null) {
	        Long id = Long.valueOf(groupId.longValue());
			group = groupService.getGroupById(id);
		}
		mv.addObject("group", group);
		mv.addObject("isUpdate", isUpdate);
		return mv;
	}
	
	@RequestMapping(value = "/update-group.html", method = RequestMethod.POST)
	public String updateGroupProcess(@ModelAttribute("group")Group group) {
		currentGroup = groupService.getGroupById(group.getId());
		currentGroup.setGroupName(group.getGroupName());
		currentGroup.setModifiedDate(new Date());
		groupService.addGroup(currentGroup);
		return  "redirect:/group/list-group.html";
	}
	
	@RequestMapping(value = "/delete-group-by-id.html", method = RequestMethod.GET)
	public String deleteGroupById(Integer groupId) {
		if(groupId != null) {
	        Long id = Long.valueOf(groupId.longValue());
			groupService.deleteGropuById(id);	
		}
		return  "redirect:/group/list-group.html";
	}
	
}

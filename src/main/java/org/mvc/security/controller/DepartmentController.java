package org.mvc.security.controller;

import java.util.Date;
import java.util.List;

import org.mvc.security.domain.Department;
import org.mvc.security.domain.Group;
import org.mvc.security.service.DepartmentService;
import org.mvc.security.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/department")
public class DepartmentController {

	@Autowired
	private GroupService groupService;
	@Autowired
	private DepartmentService departmentService;
	
	private ModelAndView mv;

	private boolean isUpdate;
	private Department department, currentDepartment;
	private List<Group> listOfGroup;
	private List<Department> listOfDepartment;
	
	@RequestMapping(value = "/add-department.html", method = RequestMethod.GET)
	public ModelAndView addDepartment() {
		mv = new ModelAndView("add-department");
		listOfGroup = groupService.getListOfGroup();
		mv.addObject("listOfGroup", listOfGroup);
		return mv;
	}
	
	@RequestMapping(value = "/add-department.html", method = RequestMethod.POST)
	public String addDepartmentProcess(@ModelAttribute("department")Department department) {
        department.setCreatedDate(new Date());
        departmentService.addDepartment(department);
		return  "redirect:/department/list-department.html";
	}
	
	@RequestMapping(value = "/list-department.html", method = RequestMethod.GET)
	public ModelAndView getAllDepartment() {
		mv = new ModelAndView("list-department");
		listOfDepartment = departmentService.getListOfDepartment();
		
		mv.addObject("listOfDepartment", listOfDepartment);
		return mv;
	}
	
	@RequestMapping(value = "/update-department.html", method = RequestMethod.GET)
	public ModelAndView updateDepartment(Integer departmentId) {
		mv = new ModelAndView("update-department");
		isUpdate = true;
		if(departmentId != null) {
	        Long id = Long.valueOf(departmentId.longValue());
			department = departmentService.getDepartmentById(id);
		}
		listOfGroup = groupService.getListOfGroup();
		
		mv.addObject("listOfGroup", listOfGroup);
		mv.addObject("department", department);
		mv.addObject("isUpdate", isUpdate);
		return mv;
	}
	
	@RequestMapping(value = "/update-department.html", method = RequestMethod.POST)
	public String updateDepartmentProcess(@ModelAttribute("department")Department department) {
		currentDepartment = departmentService.getDepartmentById(department.getId());
		currentDepartment.setDepartmentName(department.getDepartmentName());
		currentDepartment.setModifiedDate(new Date());
		departmentService.addDepartment(currentDepartment);
		return  "redirect:/department/list-department.html";
	}
	
	@RequestMapping(value = "/delete-department-by-id.html", method = RequestMethod.GET)
	public String deleteDepartmentById(Integer departmentId) {
		if(departmentId != null) {
	        Long id = Long.valueOf(departmentId.longValue());
			departmentService.deleteDepartmentById(id);
		}
		return  "redirect:/department/list-department.html";
	}
}

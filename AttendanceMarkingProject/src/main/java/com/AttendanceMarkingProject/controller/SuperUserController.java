package com.AttendanceMarkingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AttendanceMarkingProject.model.Admin;
import com.AttendanceMarkingProject.serviceImpl.AdminServiceImpl;

@Controller
public class SuperUserController{
	
	@Autowired
	AdminServiceImpl as;
	
	@GetMapping("Superlogin")
	public String Login() {
		return "./SuperUser/SuperUser";
	}
	
	@PostMapping("superuserlogin")
	public String Login1(@RequestParam String userName,@RequestParam String password,Model m) {
		if(userName.equals("superuser")&&password.equals("superuser@123")) {
			return "./SuperUser/SuperUserHome";
		}else {
			m.addAttribute("msg","Wrong username or password");
			return "./SuperUser/SuperUser";
		}
	}
	
	@GetMapping("TaskPage")
	public String task(Model m) {
		List<Admin> alist = as.showregadmins();
		m.addAttribute("alist",alist);
		return "./SuperUser/TaskPage";
	}
}
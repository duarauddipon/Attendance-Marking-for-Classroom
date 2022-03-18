package com.AttendanceMarkingProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SuperUserController{
	
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
	public String task() {
		return "./SuperUser/TaskPage";
	}
}
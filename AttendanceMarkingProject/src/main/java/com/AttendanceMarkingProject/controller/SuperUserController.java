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
		return "SuperUser";
	}
	
	@PostMapping("Superlogin")
	public String Login1(@RequestParam String userName,@RequestParam String password,Model m) {
		if(userName.equals("superuser")&&password.equals("superuser@123")) {
			return "AdminReg";
		}else {
			m.addAttribute("msg","Wrong username or password");
			return "SuperUser";
		}
		
	}
}
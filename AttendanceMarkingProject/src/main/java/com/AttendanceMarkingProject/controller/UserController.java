package com.AttendanceMarkingProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("userlogin")
	public String userLogin()
	{
		return "UserLogin";
	}
	
	@GetMapping("userreg")
	public String userregistration()
	{
		return "UserRegister";
	}
}

package com.AttendanceMarkingProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("Userlogin")
	public String userLogin()
	{
		return "userlogin";
	}
	
	@GetMapping("Userreg")
	public String userregistration()
	{
		return "userreg";
	}
}

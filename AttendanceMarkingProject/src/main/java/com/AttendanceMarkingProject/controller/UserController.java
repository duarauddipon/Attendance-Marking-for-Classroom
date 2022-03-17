package com.AttendanceMarkingProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.AttendanceMarkingProject.serviceImpl.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl us;
	
	@GetMapping("login")
	public String loginpage()
	{
		return "LoginPage";
	}
	
	@PostMapping("login")
	public String loginprocess()
	{
		return "";
	}

	@GetMapping("adminregister")
	public String adminRegPage()
	{
		return "AdminRegister";
	}
	
	@GetMapping("userregister")
	public String userRegPage()
	{
		return "UserRegister";
	}
}

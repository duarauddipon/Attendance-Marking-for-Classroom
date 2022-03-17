package com.AttendanceMarkingProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AttendanceMarkingProject.model.Admin;
import com.AttendanceMarkingProject.model.User;
import com.AttendanceMarkingProject.serviceImpl.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl us;
	
	private static User modelUser=null;
	
	public static void setModelUser(User user)
	{
		modelUser=user;
	}
	
	@GetMapping("Userlogin")
	public String userLogin()
	{
		return "Userlogin";
	}
	
	@GetMapping("Userreg")
	public String userRegistration()
	{
		return "Userreg";
	}
	
	@PostMapping("userregprocess")
	public String userRegProcess(@RequestParam String firstname,@RequestParam String lastname,
			@RequestParam String email,@RequestParam String password,Model m)
	{
		User usr = new User(firstname,lastname,email,password);
		String res=us.registeruser(usr);
		m.addAttribute("msg", res);
		return "Userreg";
	}
	
	@PostMapping("userloginprocess")
	public String userLoginProcess(@RequestParam int userid,@RequestParam String password,Model m)
	{
		User user=us.validateUser(userid, password);
		setModelUser(user);
		if(modelUser!=null)
		{
			return "UserHome";
		}
		m.addAttribute("msg","Wrong id/password");
		return "Userlogin";
	}
}

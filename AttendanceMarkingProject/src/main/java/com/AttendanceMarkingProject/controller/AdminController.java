package com.AttendanceMarkingProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AttendanceMarkingProject.model.Admin;
import com.AttendanceMarkingProject.serviceImpl.AdminServiceImpl;

@Controller
public class AdminController {
	
	@Autowired
	AdminServiceImpl as;
	
	@GetMapping("adminlogin")
	public String adminLogin() {
		return "Adminlogin";
	}
	
	@PostMapping("adminloginprocess")
	public String adminLoginProcess() {
		return "Adminlogin";
	}
	
	@GetMapping("adminreg")
	public String adminRegistration(){
		return "AdminReg";
	}
	
	@PostMapping("adminregprocess")
	public String adminRegProcess(@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,
			@RequestParam String gender,@RequestParam String number,@RequestParam String password,
			Model m) {
		Admin adm = new Admin(firstname,lastname,age,gender,number,password);
		String res = as.registerAdmin(adm);
		m.addAttribute("msg",res);
		return "AdminReg";
		
	}
}

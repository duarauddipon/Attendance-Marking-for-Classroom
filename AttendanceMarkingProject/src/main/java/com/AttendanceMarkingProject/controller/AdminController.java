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
	
	
	@GetMapping("adminreg")
	public String adminreg(){
		return "AdminReg";
	}
	
	@PostMapping("adminregprocess")
	public String adminregprocess(@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,
			@RequestParam String gender,@RequestParam String number,@RequestParam String password,
			Model m) {
		Admin adm = new Admin(firstname,lastname,age,gender,number,password);
		String adm1 = as.registerAdmin(adm);
		if(adm1!=null) {
			m.addAttribute("msg","Admin Details Addedd Successfully");
			return "AdminReg";
		}else {
			m.addAttribute("msg","Admin Details Not Addedd");
			return "AdminReg";
		}
		
	}
}

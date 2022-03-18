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
	
	private static Admin modelAdmin=null;
	
	public static void setModelAdmin(Admin admin)
	{
		modelAdmin=admin;
	}
	
	@GetMapping("adminlogin")
	public String adminLogin() {
		return "./Admin/Adminlogin";
	}
	
	@PostMapping("adminloginprocess")
	public String adminLoginProcess(@RequestParam int adminid,@RequestParam String password,Model m) {
		Admin admin=as.validateAdmin(adminid, password);
		setModelAdmin(admin);
		if(modelAdmin!=null)
		{
			if(modelAdmin.getApproval()==0)
			{
				m.addAttribute("msg","Approval pending");
				setModelAdmin(null);
				return "./Admin/Adminlogin";
			}
			else if(modelAdmin.getApproval()==-1)
			{
				m.addAttribute("msg","Registration rejected! Kindly register again");
				setModelAdmin(null);
				return "./Admin/Adminlogin";
			}
			return "./Admin/AdminHome";
		}
		m.addAttribute("msg","Wrong id/password");
		return "./Admin/Adminlogin";
	}
	
	@GetMapping("adminreg")
	public String adminRegistration(){
		return "./Admin/AdminReg";
	}
	
	@PostMapping("adminregprocess")
	public String adminRegProcess(@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,
			@RequestParam String gender,@RequestParam String number,@RequestParam String password,
			Model m) {
		Admin adm = new Admin(firstname,lastname,age,gender,number,password);
		adm.setApproval((byte) 0);
		String res = as.registerAdmin(adm);
		m.addAttribute("msg",res);
		return "./Admin/AdminReg";
	}

}
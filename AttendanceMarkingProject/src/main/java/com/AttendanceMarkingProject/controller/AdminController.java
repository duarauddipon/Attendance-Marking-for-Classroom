package com.AttendanceMarkingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.AttendanceMarkingProject.model.Admin;
import com.AttendanceMarkingProject.model.Enrollment;
import com.AttendanceMarkingProject.model.User;
import com.AttendanceMarkingProject.serviceImpl.AdminServiceImpl;
import com.AttendanceMarkingProject.serviceImpl.UserServiceImpl;

@Controller
public class AdminController {
	
	@Autowired
	AdminServiceImpl as;
	
	@Autowired
	UserServiceImpl us;
	
	private static Admin modelAdmin=null;
	
	public static void setModelAdmin(Admin admin)
	{
		modelAdmin=admin;
	}
	
	@GetMapping("adminhome")
	public String adminhome(){
		return "./Admin/AdminHome";
	}
	
	@GetMapping("adminlogin")
	public String adminLogin() {
		return "./Admin/Adminlogin";
	}
	
	@GetMapping("adminreg")
	public String adminRegistration(){
		return "./Admin/AdminReg";
	}
	
	@GetMapping("resetpassword")
	public String resetPassword() {
		return "./Admin/PasswordReset";
	}
	
	@PostMapping("resetsPassword")
	public String reset(@RequestParam String validation1,@RequestParam String validation2,
			@RequestParam String validation3,@RequestParam String firstName,@RequestParam String password,@RequestParam String number,Model m) 
	{
		String pass = as.passwordrecovery(validation1, validation2, validation3, number, firstName, password);
		m.addAttribute("msg", pass);
		return "./Admin/PasswordReset";
	}
	
	@PostMapping("adminloginprocess")
	public String adminLoginProcess(@RequestParam int adminid,@RequestParam String password,Model m) {
		Admin admin=as.validateAdmin(adminid, password);
		setModelAdmin(admin);
		if(modelAdmin!=null)
		{
			if(modelAdmin.getApproval().equals("Pending"))
			{
				m.addAttribute("msg","Approval pending");
				setModelAdmin(null);
				return "./Admin/Adminlogin";
			}
			else if(modelAdmin.getApproval().equals("Rejected"))
			{
				m.addAttribute("msg","Registration rejected! Kindly register again");
				setModelAdmin(null);
				return "./Admin/Adminlogin";
			}
			else
			{
				return "./Admin/AdminHome";
			}
		}
		m.addAttribute("msg","Wrong id/password");
		return "./Admin/Adminlogin";
	}
	
	@PostMapping("adminregprocess")
	public String adminRegProcess(@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,
			@RequestParam String gender,@RequestParam String number,@RequestParam String password,@RequestParam String validation1,
			@RequestParam String validation2,
			@RequestParam String validation3,
			Model m) {
		Admin adm = new Admin(firstname,lastname,age,gender,number,password,validation1,validation2,validation3);
		adm.setApproval("Pending");
		String res = as.registerAdmin(adm);
		m.addAttribute("msg",res);
		return "./Admin/AdminReg";
	}
	
	@GetMapping("adminnotification")
	public String showNotifications(Model m)
	{
		List<Enrollment> reslist=as.showEnrollment();
		m.addAttribute("elist", reslist);
		return "./Admin/AdminNotification";
	}

	@RequestMapping(value="doenroll",params="approve",method=RequestMethod.POST)
	public String doApprove(@RequestParam(name="eid") int empId,@RequestParam(name="sid") int sId,Model m)
	{
		as.approveEnrollment(empId,sId);
		List<Enrollment> reslist=as.showEnrollment();
		m.addAttribute("elist", reslist);
		
		return "./Admin/AdminNotification";
	}
	
	@RequestMapping(value="doenroll",params="reject",method=RequestMethod.POST)
	public String doReject(@RequestParam(name="eid") int empId,@RequestParam(name="sid") int sId,Model m)
	{
		as.rejectEnrollment(empId,sId);
		List<Enrollment> reslist=as.showEnrollment();
		m.addAttribute("elist", reslist);
		
		return "./Admin/AdminNotification";
	}
}
package com.AttendanceMarkingProject.controller;

import java.util.List;

import java.util.stream.Collectors;

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
	
	@GetMapping("adminhome")
	public String adminhome(Model m){
		List<Enrollment> l1= as.showEnrollment();
		List<String> l2 = l1.stream().map(obj->obj.getApproval()).collect(Collectors.toList());
		int c=(int) l2.stream().filter(str->str.equals("Pending")).count();
		m.addAttribute("notif",c);
		return "./Admin/AdminHome";
	}
	
	@GetMapping("adminlogin")
	public String adminLogin() {
		setModelAdmin(null);
		return "./Admin/Adminlogin";
	}
	
	@GetMapping("adminreg")
	public String adminRegistration(){
		return "./Admin/AdminReg";
	}
	
	@GetMapping("adminresetpassword")
	public String resetPassword() {
		return "./Admin/PasswordReset";
	}
	
	@PostMapping("adminresetpassword")
	public String reset(@RequestParam String validation1,@RequestParam String validation2,
			@RequestParam String validation3,@RequestParam String email,@RequestParam String password,@RequestParam String number,Model m) 
	{
		String pass = as.passwordrecovery(validation1, validation2, validation3, number, email, password);
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
				List<Enrollment> l1= as.showEnrollment();
				List<String> l2 = l1.stream().map(obj->obj.getApproval()).collect(Collectors.toList());
				int c=(int) l2.stream().filter(str->str.equals("Pending")).count();
				if(c!=0)
				{
					m.addAttribute("notif",Integer.toString(c));
					return "./Admin/AdminHome";
				}
				return "./Admin/AdminHome";
			}
		}
		m.addAttribute("msg","Wrong id/password");
		return "./Admin/Adminlogin";
	}
  
	@PostMapping("adminregprocess")
	public String adminRegProcess(@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,
			@RequestParam String gender,@RequestParam String email,@RequestParam String number,@RequestParam String password,@RequestParam String validation1,
			@RequestParam String validation2,
			@RequestParam String validation3,
			Model m) {
		Admin adm = new Admin(firstname,lastname,age,gender,email,number,password,validation1,validation2,validation3);
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

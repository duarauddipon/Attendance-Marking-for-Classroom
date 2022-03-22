package com.AttendanceMarkingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AttendanceMarkingProject.model.Session;
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
		return "./User/Userlogin";
	}
	
	@GetMapping("Userreg")
	public String userRegistration()
	{
		return "./User/Userreg";
	}
	
	@GetMapping("showAllSessions")
	public String showallsessions(Model m) {
		List<Session> slist = us.showAllSession();
		m.addAttribute("slist",slist);
		return "showallsessions";
	}
	
	@GetMapping("sessionDetails/{id}")
	public String sessionDetails(@PathVariable int id,Model m) {
		Session dlist = us.showSessionDetails(id);
		m.addAttribute("dlist",dlist);

		List<Session> slist = us.showAllSession();
		m.addAttribute("slist",slist);
		return "showallsessions";
	}
	
	@GetMapping("searchSession")
	public String searchSession() {
		return "searchSession";
	}
	
	@GetMapping("searchsession")
	public String searchSessionBySkillType(Model m) {
		List<Session> slist = us.showAllSession();
		m.addAttribute("salist",slist);
		return "searchSession";
	}
	
		
	@PostMapping("userregprocess")
	public String userRegProcess(@RequestParam String firstname,@RequestParam String lastname,
			@RequestParam String email,@RequestParam String password,Model m)
	{
		User usr = new User(firstname,lastname,email,password);
		String res=us.registeruser(usr);
		m.addAttribute("msg", res);
		return "./User/Userreg";
	}
	
	@PostMapping("userloginprocess")
	public String userLoginProcess(@RequestParam int userid,@RequestParam String password,Model m)
	{
		User user=us.validateUser(userid, password);
		setModelUser(user);
		if(modelUser!=null)
		{
			return "./User/UserHome";
		}
		m.addAttribute("msg","Wrong id/password");
		return "./User/Userlogin";
	}
	@PostMapping("searchSessionProcess")
	public String SearchSession(@RequestParam String sessionId, Model m)
	{		
		Session ss = us.SearchSession(Integer.parseInt(sessionId));
		if(ss!=null)
			m.addAttribute("ss", ss);
		else
			m.addAttribute("msg", "Session Not Found");
		return "searchSession";
	}

	
	
}
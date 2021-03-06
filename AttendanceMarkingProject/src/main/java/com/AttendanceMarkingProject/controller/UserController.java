package com.AttendanceMarkingProject.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AttendanceMarkingProject.model.Enrollment;
import com.AttendanceMarkingProject.model.Session;
import com.AttendanceMarkingProject.model.Skill;
import com.AttendanceMarkingProject.model.User;
import com.AttendanceMarkingProject.serviceImpl.SessionServiceImpl;
import com.AttendanceMarkingProject.serviceImpl.SkillServiceImpl;
import com.AttendanceMarkingProject.serviceImpl.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl us;
	
	@Autowired
	SkillServiceImpl ssi;
	
	@Autowired
	SessionServiceImpl sei;
	
	private static User modelUser=null;
	
	public static void setModelUser(User user)
	{
		modelUser=user;
	}
	
	public static User getModelUser()
	{
		return modelUser;
	}
	
	@GetMapping("Userlogin")
	public String userLogin()
	{
		setModelUser(null);
		return "./User/Userlogin";
	}
	
	@GetMapping("Userreg")
	public String userRegistration()
	{
		return "./User/Userreg";
	}
	
	@GetMapping("userhome")
	public String userHomepage(Model m)
	{
		List<String> notifs = us.showNotifications(modelUser.getEmpId());
		if(notifs.isEmpty())
		{
			notifs.add("No new notifications");
			m.addAttribute("notifs", notifs);
			m.addAttribute("notif", "0");
			return "./User/UserHome";
		}
		m.addAttribute("notifs", notifs);
		m.addAttribute("notif",Integer.toString(notifs.size()));
		return "./User/UserHome";
	}
	
	@GetMapping("showAllSessions")
	public String showallsessions(Model m) {
		
		List<Session> slist = sei.showSession();
		m.addAttribute("slist",slist);
		
		List<Skill> sklist=ssi.showSkill();
		m.addAttribute("sklist", sklist);
		
		return "ShowAllSessions";
	}
	
	@GetMapping("userresetpassword")
	public String passwordReset() {
		return "./User/PasswordReset";
	}
	
	@PostMapping("userresetpassword")
	public String doPasswordReset(@RequestParam String validation1,@RequestParam String validation2,
			@RequestParam String validation3,@RequestParam String email,@RequestParam String password,@RequestParam String number,Model m)
	{
		String res = us.passwordrecovery(validation1, validation2, validation3, number, email, password);
		m.addAttribute("msg", res);
		return "./User/PasswordReset";
	}
	
  @PostMapping("showsessiondetails")
	public String showSessionDetails(@RequestParam int sid,Model m)
	{
		List<Session> slist = sei.showSession();
		m.addAttribute("slist",slist);
		
		Session res=sei.searchSession(sid);
		List<Session> reslist=new ArrayList<>();
		reslist.add(res);
		m.addAttribute("dlist", reslist);
		
		List<Skill> sklist=ssi.showSkill();
		m.addAttribute("sklist", sklist);
		
		return "ShowAllSessions";
	}
  
  	@PostMapping("searchsessionbyid")
    public String searchSessionById(@RequestParam int selectId,Model m)
    {
  		
		List<Session> slist = sei.showSession();
		m.addAttribute("slist",slist);
		
		Session res=sei.searchSession(selectId);
		List<Session> reslist=new ArrayList<>();
		reslist.add(res);
		m.addAttribute("dlist", reslist);
		
		List<Skill> sklist=ssi.showSkill();
		m.addAttribute("sklist", sklist);
	  	
	    return "ShowAllSessions";
    }
  	
  	@PostMapping("searchsessionbyskill")
  	 public String searchSessionBySkill(@RequestParam String selectSkill,Model m)
    {
		List<Session> reslist=sei.searchBySKillType(selectSkill);
		m.addAttribute("slist", reslist);
		
		List<Skill> sklist=ssi.showSkill();
		m.addAttribute("sklist", sklist);
	  	
	    return "ShowAllSessions";
    }
		
	@PostMapping("userregprocess")
	public String userRegProcess(@RequestParam String firstname,@RequestParam String lastname,
			@RequestParam String email,@RequestParam String number,@RequestParam String password,@RequestParam String validation1,@RequestParam String validation2,
			@RequestParam String validation3,Model m)
	{
		User usr = new User(firstname,lastname,email,number,password,validation1,validation2,validation3);
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
			List<String> notifs = us.showNotifications(modelUser.getEmpId());
			if(notifs.isEmpty())
			{
				notifs.add("No new notifications");
				m.addAttribute("notifs", notifs);
				m.addAttribute("notif", "0");
				return "./User/UserHome";
			}
			m.addAttribute("notifs", notifs);
			m.addAttribute("notif",Integer.toString(notifs.size()));
			return "./User/UserHome";
		}
		m.addAttribute("msg","Wrong id/password");
		return "./User/Userlogin";
	}
	
	@PostMapping("enrollaction")
	public String enrollment(Model m,@RequestParam int enrollid)
	{
		String res=us.enrollUser(modelUser.getEmpId(), enrollid);
		m.addAttribute("msg", res);
		
		List<Session> slist = sei.showSession();
		m.addAttribute("slist",slist);
		
		List<Skill> sklist=ssi.showSkill();
		m.addAttribute("sklist", sklist);
		
		return "ShowAllSessions";
	}
	
	@GetMapping("mysessions")
	public String showMySessions(Model m)
	{
		List<Enrollment> resList=us.showEnrollments(modelUser.getEmpId());
		m.addAttribute("elist", resList);
		return "./User/MySessions";
	}
	
	@PostMapping("joinsession")
	public String joinSessionProcess(@RequestParam String sid,Model m)
	{
		Session session= sei.searchSession(Integer.parseInt(sid));
		if(LocalDate.now().toString().equals(session.getSessionDate()))
		{
			m.addAttribute("sId", sid);
			m.addAttribute("sname", session.getSessionDes());
			return "./User/SessionJoin";
		}
		m.addAttribute("msg", "Session not yet started!");
		List<Enrollment> resList=us.showEnrollments(modelUser.getEmpId());
		m.addAttribute("elist", resList);
		return "./User/MySessions";
	}
	
	@GetMapping("report")
	public String displayReport(Model m)
	{
		List<Session> reslist = us.showReport(modelUser.getEmpId());
		m.addAttribute("slist", reslist);
		
		return "./User/Report";
	}
}

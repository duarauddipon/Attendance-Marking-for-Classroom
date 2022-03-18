package com.AttendanceMarkingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AttendanceMarkingProject.model.Session;
import com.AttendanceMarkingProject.model.Skill;
import com.AttendanceMarkingProject.service.SessionService;
import com.AttendanceMarkingProject.service.SkillService;

@Controller
public class SessionController {

	
	@Autowired
	SessionService sr;
	
	@Autowired
	SkillService ss;
	
	
	@GetMapping("sessionadd")
	public String sessionAdd(Model m) {
		
		List<Skill> slist = ss.showSkill();
		m.addAttribute("salist",slist);
		return "SessionAdd";
	}
	
	/**
	 * @param sessionId
	 * @param sessionDes
	 * @param sessionDate
	 * @return
	 */
	@PostMapping("addSs")
	public String sessionAddProcess(@RequestParam String sessionId,
			
			@RequestParam String sessionDes,
			@RequestParam String skillSet,
			@RequestParam String sessionDate,
			@RequestParam String sessionTime,
			@RequestParam String availSlots,
			Model m) { 
		
		System.out.println(sessionDate);
		System.out.println(sessionTime);
		
		Session sn = new Session();
		
		sn.setSessionId(Integer.parseInt(sessionId));
		sn.setSessionDes(sessionDes);
		sn.setSkillSet(skillSet);
		sn.setSessionDate(sessionDate);
		sn.setSessionTime(sessionTime);
		sn.setAvailSlots(Integer.parseInt(availSlots));
		
		String res = sr.addSession(sn);
		m.addAttribute("msg",res);
		
		return "SessionAdd";
	}
	
	@GetMapping("search")
	public String searchSession(Model m) {
		List<Session> elist = sr.showSession();
		m.addAttribute("sslist",elist);
		return "SearchPage";
	}
	
}

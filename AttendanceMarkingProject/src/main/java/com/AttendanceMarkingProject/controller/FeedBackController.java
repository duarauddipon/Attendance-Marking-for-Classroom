package com.AttendanceMarkingProject.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AttendanceMarkingProject.model.Answers;
import com.AttendanceMarkingProject.model.Questions;
import com.AttendanceMarkingProject.model.Session;
import com.AttendanceMarkingProject.service.FeedService;
import com.AttendanceMarkingProject.service.SessionService;
import com.AttendanceMarkingProject.service.SkillService;

@Controller
public class FeedBackController {

	@Autowired
	SessionService as;
	
	@Autowired
	SkillService ad;
	
	@Autowired
	FeedService sf;
	
	
	@GetMapping("feedback")
	public String resp(Model m) {
		
		List<Session> aslist = sf.showSessionDet();
		
		m.addAttribute("salist",aslist);
		
		List<Questions> qwlist = sf.showQuestion();

		m.addAttribute("polist",qwlist);
		return "Feedback";
		
	}
	
	@PostMapping("resp")
	public String feedback(	
			@RequestParam String ansa,
			@RequestParam String ansb,
			
			@RequestParam(name="review") String ansc,
			@RequestParam(name="rating") String ansd,
			@RequestParam String sessionid,
			
			Model m) {
		
		Answers ans = new Answers();
		ans.setAnSa(ansa);
		ans.setAnSb(ansb);
		ans.setAnSc(ansc);
		ans.setAnSd(ansd);
		ans.setSessionId(Integer.parseInt(sessionid));
		
		String res = sf.addAnswer(ans);
		m.addAttribute("msg", res);
		
		
		return "Feedback";
	}
	
}

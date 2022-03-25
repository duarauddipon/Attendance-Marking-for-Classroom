package com.AttendanceMarkingProject.controller;

import java.net.http.HttpRequest;
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
import com.AttendanceMarkingProject.model.Skill;
import com.AttendanceMarkingProject.model.Trainer;
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
	
	@GetMapping("feedbackform")
	public String showAns(Model m) {
		List<Answers> lklist = sf.showAnswer();
		m.addAttribute("rlist", lklist);
		return "ShowFeedback";
		
		
	}
	
	@GetMapping("updateques")
	public String updateQues(Model m) {
		List<Session> hglist = sf.showSessionDet();
		m.addAttribute("plist", hglist);
		return "UpdateQuestion";
	}
	
	@PostMapping("updq")
	public String question(@RequestParam String queSa,
			@RequestParam String queSb,
			@RequestParam String queSc,
			@RequestParam String queSd,
			@RequestParam String session,
			
			Model m)
	{
	Questions q = new Questions();
	q.setQueSa(queSa);
	q.setQueSb(queSb);
	q.setQueSc(queSc);
	q.setQueSd(queSd);
	q.setSessionId(Integer.parseInt(session));
	
	String res = sf.updateQuestion(q);
	m.addAttribute("msg",res);
	
	
	return "UpdateTrainer";

}

}

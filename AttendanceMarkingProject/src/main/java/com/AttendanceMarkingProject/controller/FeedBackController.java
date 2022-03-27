package com.AttendanceMarkingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AttendanceMarkingProject.model.Answers;
import com.AttendanceMarkingProject.model.Questions;
import com.AttendanceMarkingProject.model.Session;
import com.AttendanceMarkingProject.service.FeedService;
import com.AttendanceMarkingProject.service.SessionService;

@Controller
public class FeedBackController {

	@Autowired
	SessionService as;
	
	@Autowired
	FeedService sf;
	
	@GetMapping("feedback/{id}")
	public String resp(Model m,@PathVariable("id") int sessionId) {
		
		Questions qwlist = sf.showQuestionBySessionId(sessionId);

		m.addAttribute("qwlist",qwlist);
		
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
	
	@GetMapping("feedbackreport")
	public String showAns(Model m) {
		List<Answers> lklist = sf.showAnswer();
		m.addAttribute("rlist", lklist);
		return "ShowFeedback";
		
		
	}
	
	@GetMapping("updatequestion")
	public String updateQues(Model m) {
		List<Session> slist = as.showSession();
		m.addAttribute("slist", slist);
		return "UpdateQuestion";
	}
	
	@PostMapping("updatequestion")
	public String question(@RequestParam String quesa,
			@RequestParam String quesb,
			@RequestParam String quesc,
			@RequestParam String quesd,
			@RequestParam String session,
			Model m)
	{
		Questions q = new Questions();
		q.setQueSa(quesa);
		q.setQueSb(quesb);
		q.setQueSc(quesc);
		q.setQueSd(quesd);
		q.setSessionId(Integer.parseInt(session));

		String res = sf.updateQuestion(q);
		m.addAttribute("msg",res);

		return "UpdateQuestion";
	}

}

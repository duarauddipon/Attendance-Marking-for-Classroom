package com.AttendanceMarkingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AttendanceMarkingProject.model.Skill;
import com.AttendanceMarkingProject.model.Trainer;
import com.AttendanceMarkingProject.service.SkillService;
import com.AttendanceMarkingProject.serviceImpl.TrainerServiceImpl;

@Controller
public class TrainerController {
	@Autowired
	TrainerServiceImpl ts;
	
	@Autowired
	SkillService ss;
	
	@GetMapping("trainerreg")
	public String trainer(Model m){
		List<Skill> slist = ss.showSkill();
		m.addAttribute("salist",slist);
		return "TrainerReg";
	}
	
	@PostMapping("trainerregprocess")
	public String trainerregprocess(@RequestParam int trainerId,@RequestParam String trainerName,@RequestParam String contactNumber,
			@RequestParam String email,@RequestParam String skillSet,
			Model m) {
		Trainer trn = new Trainer(trainerId,trainerName,contactNumber,email,skillSet);
		String res = ts.addTrainer(trn);
		m.addAttribute("msg",res);
		return "TrainerReg";
	
}
	@PostMapping("trainerUpdateProcess")
	public String UpdateTrainerDetails(@RequestParam int trainerId,@RequestParam String trainerName,@RequestParam String contactNumber,
			@RequestParam String email,@RequestParam String skillSet,
			Model m )
	{
		Trainer t = new Trainer();
		t.setTrainerId(trainerId);
		t.setTrainerName(trainerName);
		t.setContactNumber(contactNumber);
		t.setEmail(email);
		t.setSkillSet(skillSet);
		
		String ut1 = ts.updateTrainer(t);
		if(ut1.equals("Success"))
			m.addAttribute("msg", "Trainer Updated...");
		else
			m.addAttribute("msg", "Trainer Not Updated...");
		return "TrainerReg";		
	}
}

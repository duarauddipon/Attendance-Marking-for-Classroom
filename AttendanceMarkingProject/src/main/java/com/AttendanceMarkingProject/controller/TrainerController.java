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
	public String trainer1(Model m){
		List<Skill> slist = ss.showSkill();
		m.addAttribute("salist",slist);
		return "TrainerReg";
	}
	@GetMapping("updatetrainer")
	public String trainer(Model m){
		List<Skill> slist = ss.showSkill();
		m.addAttribute("salist",slist);
		return "UpdateTrainer";
	}
	@GetMapping("deletetrainer")
	public String trainer2(Model m){
		List<Trainer> tlist = ts.showTrainer();
		m.addAttribute("salist",tlist);
		return "DeleteTrainer";
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
	@PostMapping("trainerupdateprocess")
	public String updateTrainerDetails(@RequestParam int trainerId,@RequestParam String trainerName,@RequestParam String contactNumber,
			@RequestParam String email,@RequestParam String skillSet,
			Model m )
	{
		Trainer t = new Trainer(trainerId,trainerName,contactNumber,email,skillSet);
	
		
		String res = ts.updateTrainer(t);
		m.addAttribute("msg",res);
		return "UpdateTrainer";

	}
	
	@PostMapping("trainerdeletionprocess")
	public String deleteTrainerDetails(@RequestParam int trainerId,
			Model m )
	{
		Trainer t = new Trainer();
		t.setTrainerId(trainerId);
		
		
		String res = ts.deleteTrainer(t);
		m.addAttribute("msg",res);
		return "DeleteTrainer";
		
		
		
	}
}

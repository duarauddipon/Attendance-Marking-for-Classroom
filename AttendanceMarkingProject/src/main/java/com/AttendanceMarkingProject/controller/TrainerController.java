package com.AttendanceMarkingProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.AttendanceMarkingProject.model.Trainer;
import com.AttendanceMarkingProject.serviceImpl.TrainerServiceImpl;

@Controller
public class TrainerController {
	@Autowired
	TrainerServiceImpl ts;
	
	@GetMapping("trainerreg")
	public String trainer(){
		return "TrainerReg";
	}
	
	@PostMapping("trainerregprocess")
	public String trainerregprocess(@RequestParam int trainerId,@RequestParam String trainerName,@RequestParam String contactNumber,
			@RequestParam String email,@RequestParam String skillSet,
			Model m) {
		Trainer trn = new Trainer(trainerId,trainerName,contactNumber,email,skillSet);
		String trn1 = ts.addTrainer(trn);
		if(trn1!=null) {
			m.addAttribute("msg","Trainer Details Addedd Successfully");
			return "TrainerReg";
		}else {
			m.addAttribute("msg","Trainer Details Not Addedd");
			return "TrainerReg";
		}
		
		
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

package com.AttendanceMarkingProject.serviceImpl;

import com.AttendanceMarkingProject.model.Trainer;
import com.AttendanceMarkingProject.service.TrainerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



@Component
public class TrainerServiceImpl implements TrainerService {
	
	@Autowired
	JdbcTemplate jt;

	@Override
	public String addTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		
		String sql = "Insert into trainer(trainerId,trainerName,contactNumber,email,skillset) values(?,?,?,?,?);";
		try {
		int r = jt.update(sql, new Object[] {trainer.getTrainerId(),trainer.getSkillSet(),trainer.getContactNumber(),trainer.getEmail(),trainer.getTrainerName()});
		if(r>=1)
			return "Trainer Added";
		else
			return "Error....";
	}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return "Error..";
	}

}

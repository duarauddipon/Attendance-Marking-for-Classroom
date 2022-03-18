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
		int r = jt.update(sql, new Object[] {trainer.getTrainerId(),trainer.getTrainerName(),trainer.getContactNumber(),trainer.getEmail(),trainer.getSkillSet()});
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
	
	//@Override
	//public String UpdateTrainer(Trainer) {
	//	Trainer t = trainerrepo.saveAndFlush(std); // for updating entity details
	//	if(t!=null)
	//		return "Success";
	//	else
	//		return "Fail";
	//}




	@Override
	public String updateTrainer(Trainer utrainer) {
		// TODO Auto-generated method stub
		String sql = "update trainer set trainerName=?,contactNumber=?,email=?,skillset=?  where trainerId=? ;";
		try {
			int r = jt.update(sql, new Object[] {utrainer.getTrainerName(),utrainer.getContactNumber(),utrainer.getEmail(),utrainer.getSkillSet(),utrainer.getTrainerId()});
			if(r>=1)
				return "Trainer Updated";
			else
				return "Error....";
		}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			return "Error..";
		}

	@Override
	public String deleteTrainer(Trainer dtrainer) {
		// TODO Auto-generated method stub
		String sql="delete from trainer where trainerId=?;";
		int r=jt.update(sql, new Object[] {dtrainer.getTrainerId()});
		if(r>=1)
			return "Deletion successful!";
		else
			return "Trainer not found!";
	}
	}
		
		
		
	
	

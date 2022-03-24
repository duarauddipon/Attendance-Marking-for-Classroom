package com.AttendanceMarkingProject.service;

import java.util.List;

import com.AttendanceMarkingProject.model.Answers;
import com.AttendanceMarkingProject.model.Questions;
import com.AttendanceMarkingProject.model.Session;
import com.AttendanceMarkingProject.model.Trainer;




public interface FeedService {

	public String addAnswer(Answers answers);
		
	public List<Session> showSessionDet();
	 public String quest(Questions qwer);
	 
	 public List<Questions> showQuestion();
	 
	 public List<Answers> showAnswer();
	 public String updateQuestion(Questions quest);
	
	
}

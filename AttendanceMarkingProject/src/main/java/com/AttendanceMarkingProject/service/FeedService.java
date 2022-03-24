package com.AttendanceMarkingProject.service;

import java.util.List;

import com.AttendanceMarkingProject.model.Answers;
import com.AttendanceMarkingProject.model.Questions;
import com.AttendanceMarkingProject.model.Session;




public interface FeedService {

	public String addAnswer(Answers answers);
		
	public List<Session> showSessionDet();
	 public String quest(Questions qwer);
	 
	 public List<Questions> showQuestion();
	
	
}

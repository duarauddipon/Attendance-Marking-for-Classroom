package com.AttendanceMarkingProject.service;

import java.util.List;

import com.AttendanceMarkingProject.model.Answers;
import com.AttendanceMarkingProject.model.Questions;

public interface FeedService {

	public String addAnswer(Answers answers);
	public String addQuestion(Questions ques);
	public List<Answers> showAnswer();
	public String updateQuestion(Questions quest);
	public Questions showQuestionBySessionId(int sessionId);
	 public List<Questions> showQuestion();
}

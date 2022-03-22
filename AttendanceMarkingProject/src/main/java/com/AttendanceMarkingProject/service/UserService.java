package com.AttendanceMarkingProject.service;

import java.util.List;

import com.AttendanceMarkingProject.model.Session;
import com.AttendanceMarkingProject.model.User;

public interface UserService {
	public String registeruser(User user);
	public User validateUser(int empId,String password);
	public List<Session> showAllSession();
	public Session showSessionDetails(int sessionId);
	public Session SearchSession(int sessionId);
	public List<Session> SearchBySkillType(String skillType);
}

package com.AttendanceMarkingProject.service;

import java.util.List;

import com.AttendanceMarkingProject.model.Session;
import com.AttendanceMarkingProject.model.User;

public interface UserService {
	public String registeruser(User user);
	public User validateUser(int empId,String password);
	public List<Session> showAllSession();
	public Session searchSession(int sessionId);
}

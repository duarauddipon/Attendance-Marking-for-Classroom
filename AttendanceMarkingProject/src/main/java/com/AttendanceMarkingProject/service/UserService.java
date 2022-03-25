package com.AttendanceMarkingProject.service;

import java.util.List;

import com.AttendanceMarkingProject.model.Enrollment;
import com.AttendanceMarkingProject.model.User;

public interface UserService {
	public String registeruser(User user);
	public User validateUser(int empId,String password);
	public String enrollUser(int empId,int sessionId);
	public String passwordrecovery(String validation1,String validation2,String validation3,String number,String email,String password);
	public List<Enrollment> showEnrollments(int empId);
	public List<String> showNotifications(int empId);
}
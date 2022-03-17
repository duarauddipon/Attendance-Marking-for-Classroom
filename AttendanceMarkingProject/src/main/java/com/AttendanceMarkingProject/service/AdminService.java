package com.AttendanceMarkingProject.service;

import com.AttendanceMarkingProject.model.Admin;

public interface AdminService {
	public String registerAdmin(Admin admin);
	public Admin validateAdmin(int adminId,String password);
}

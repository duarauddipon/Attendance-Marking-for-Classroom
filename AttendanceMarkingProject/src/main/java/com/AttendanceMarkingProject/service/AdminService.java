package com.AttendanceMarkingProject.service;

import java.util.List;

import com.AttendanceMarkingProject.model.Admin;

public interface AdminService {
	public String registerAdmin(Admin admin);
	public Admin validateAdmin(int adminId,String password);
	public List<Admin> showregadmins();

}

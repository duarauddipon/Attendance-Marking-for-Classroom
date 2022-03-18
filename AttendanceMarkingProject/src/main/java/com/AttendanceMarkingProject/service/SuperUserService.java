package com.AttendanceMarkingProject.service;

import com.AttendanceMarkingProject.model.Admin;

public interface SuperUserService {
	public String approveAdmin(Admin admin);
	public String rejectAdmin(Admin admin);
}

package com.AttendanceMarkingProject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.AttendanceMarkingProject.model.Admin;
import com.AttendanceMarkingProject.service.AdminService;

public class AdminServiceImpl implements AdminService {
	
	@Autowired
	JdbcTemplate jt;

	@Override
	public boolean registerAdmin(Admin admin) {
		String sql = "Insert into adminreg(firstname,lastname,age,gender,number,adminid,password)values(?,?,?,?,?,?,?)";
		try
		{
			int a = jt.update(sql,new Object[] {admin.getFirstName(),admin.getLastName(),admin.getAge(),admin.getGender(),
					admin.getNumber(),admin.getAdminId(),admin.getPassword()});
			if(a>=1)
			{
				return true;
			}
			else
				return false;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return false;
	}

}

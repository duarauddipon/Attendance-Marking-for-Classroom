package com.AttendanceMarkingProject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.AttendanceMarkingProject.model.Admin;
import com.AttendanceMarkingProject.service.AdminService;

@Component
public class AdminServiceImpl implements AdminService {
		
	@Autowired
	JdbcTemplate jt;

	@Override
	public String registerAdmin(Admin admin) {
		String sql = "Insert into adminreg(firstname,lastname,age,gender,number,password)values(?,?,?,?,?,?)";
		try
		{
			int a = jt.update(sql,new Object[] {admin.getFirstName(),admin.getLastName(),admin.getAge(),admin.getGender(),
					admin.getNumber(),admin.getPassword()});
			if(a>=1)
			{
				return "Admin registered successfully";
			}
			else
				return "Error registering!";
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return "Error registering!";
	}

}

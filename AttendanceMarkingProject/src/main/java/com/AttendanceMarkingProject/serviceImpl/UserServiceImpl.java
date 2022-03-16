package com.AttendanceMarkingProject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.AttendanceMarkingProject.model.User;
import com.AttendanceMarkingProject.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	JdbcTemplate jt;

	@Override
	public String registeruser(User user) {
		String str="insert into userreg(firstname,lastname,empid,email,password) values(?,?,?,?,?);";
		try
		{
			int res=jt.update(str, new Object[] {user.getFirstName(),user.getLastName(),user.getEmpId(),user.getEmail(),user.getPassword()});
			if(res>=1)
			{
				return "User added successfully";
			}
			else
			{
				return "User not added!";
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return "User not added!";
	}

}

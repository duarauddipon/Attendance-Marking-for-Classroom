package com.AttendanceMarkingProject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.AttendanceMarkingProject.model.Session;
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

	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	@Override
	public User validateUser(int empId, String password) {
		String str="select * from userreg where empId=? and password=?;";
		try
		{
			User user=(User) jt.queryForObject(str, new Object[] {empId,password}, new BeanPropertyRowMapper(User.class));
			return user;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Session> showAllSession() {
		String str ="select * from sessiondet;";
		try {
			List<Session> slist = jt.query(str, new BeanPropertyRowMapper(Session.class)) ;
			return slist;
		}catch(Exception ex) {
			ex.getMessage();
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Override
	public Session showSessionDetails(int sessionId) {
		String str = "select * from sessiondet where sessionid=?";
		try {
			Session dlist = (Session) jt.queryForObject(str, new Object[] {sessionId}, new BeanPropertyRowMapper(Session.class));
			return dlist;
		}catch(Exception ex) {
			ex.getMessage();
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Session searchSession(int sessionId) {
		String sql="select * from sessiondet where sessionid=?";
		try {
			@SuppressWarnings("deprecation")
			Session dlist = (Session) jt.queryForObject(sql, new Object[] {sessionId}, new BeanPropertyRowMapper(Session.class));
			return dlist;
		}catch(Exception ex) {
			ex.getMessage();
		}
		return null;	}

	
}

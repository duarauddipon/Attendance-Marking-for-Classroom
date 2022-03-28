package com.AttendanceMarkingProject.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.AttendanceMarkingProject.model.Enrollment;
import com.AttendanceMarkingProject.model.Session;
import com.AttendanceMarkingProject.model.User;
import com.AttendanceMarkingProject.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	JdbcTemplate jt;

	@SuppressWarnings("deprecation")
	@Override
	public String registeruser(User user) {
		String str="insert into userreg(firstname,lastname,empid,email,number,password,validation1,validation2,validation3) values(?,?,?,?,?,?,?,?,?);";
		try
		{
			int res=jt.update(str, new Object[] {user.getFirstName(),user.getLastName(),user.getEmpId(),user.getEmail(),user.getNumber(),
					user.getPassword(),user.getValidation1(),user.getValidation2(),user.getValidation3()});
			if(res>=1)
			{
				String str1="select empid from userreg where email=?;";
				int empid=jt.queryForObject(str1, new Object[] {user.getEmail()},Integer.class);
				return "Registered successfully. Admin Id is "+empid;
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

	@SuppressWarnings("deprecation")
	@Override
	public String enrollUser(int empId, int sessionId) {
		
		String str1="select sno from enrolldet where empid=? and sessionid=?;";
		try
		{
			int r=jt.queryForObject(str1, new Object[] {empId,sessionId},Integer.class);
			if(r>=1)
			{
				return "You have already enrolled!";
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		String str2="insert into enrolldet(empid,sessionid,attendance,approval) values(?,?,?,?);";
		try
		{
			int r=jt.update(str2, new Object[] {empId,sessionId,"null","Pending"});
			if(r>=1)
			{
				return "You are successfully enrolled!";
			}
			else
			{
				return "Error enrolling";
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return "Error enrolling";
	}

	@Override
	public String passwordrecovery(String validation1, String validation2, String validation3, String number,
			String email, String password) {
		
		String str = "update userreg set password = ? where validation1= ? and validation2 =? and validation3 = ? and email = ? and number = ?;";
		try {
			int pass = jt.update(str,new Object[] {password,validation1,validation2,validation3,email,number});
			if(pass>=1) {
				return "Password Reseted Successfully";
			}else {
				return "Error Reseting. Please try again";
			}
		}catch(Exception ex) {
			ex.getMessage();
		}
	return "Error Reseting. Please try again";
	}

	@Override
	public List<Enrollment> showEnrollments(int empId) {
		String str="select e.empid,u.firstname,u.lastname,e.sessionid,s.sessiondes,e.attendance,e.approval from userreg as u "
				+"join enrolldet as e on u.empid=e.empid join sessiondet as s on s.sessionid=e.sessionid where s.sessiondate>? and e.empid=? and e.approval=?;";
		try
		{
			List<Enrollment> reslist = jt.query(str, new Object[] {LocalDate.now().minusDays(1),empId,"Approved"},new BeanPropertyRowMapper(Enrollment.class));
			return reslist;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public List<String> showNotifications(int empId) {
		List<String> notifs = new ArrayList<>();
		List<Enrollment> resList = showEnrollments(empId);
		if(!resList.isEmpty())
		{
			String s1="You have been enrolled to upcoming "+resList.size()+" sessions";
			notifs.add(s1);
		}
		LocalDate d1 = LocalDate.now().plusDays(3);
		try
		{
			String str="select e.empid,u.firstname,u.lastname,e.sessionid,s.sessiondes,e.attendance,e.approval from userreg as u "
					+"join enrolldet as e on u.empid=e.empid join sessiondet as s on s.sessionid=e.sessionid where s.sessiondate>? and s.sessiondate<? and e.empid=? and e.approval=?;";
			List<Enrollment> resList1 = jt.query(str, new Object[] {LocalDate.now().minusDays(1),d1,empId,"Approved"},new BeanPropertyRowMapper(Enrollment.class));
			if(!resList1.isEmpty())
			{
				String s2="Reminder : You have 2 days left to "+resList1.size()+" sessions";
				notifs.add(s2);
			}
			return notifs;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public List<Session> showReport(int empId) {
		String str = "select s.sessionid,s.sessiondes,s.skillset,s.sessiondate,s.sessiontime from enrolldet as e join sessiondet as s on e.sessionid=s.sessionid where e.empid=? and e.attendance=?;";
		try
		{
			List<Session> reslist = jt.query(str, new Object[] {empId,"Present"},new BeanPropertyRowMapper(Session.class));
			return reslist;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public String setAttendance(int empId, int sessionId) {
		String str = "update enrolldet set attendance=? where empid=? and sessionid=?;";
		try
		{
			int r= jt.update(str,new Object[] {"Present",empId,sessionId});
			if(r>=1)
			{
				return "Your attendance has been recorded";
			}
			else
				return "Attendance error!";
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return "Attendance error!";
	}
}

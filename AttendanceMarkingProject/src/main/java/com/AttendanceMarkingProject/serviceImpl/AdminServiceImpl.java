package com.AttendanceMarkingProject.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.AttendanceMarkingProject.model.Admin;
import com.AttendanceMarkingProject.model.Enrollment;
import com.AttendanceMarkingProject.service.AdminService;

@Component
public class AdminServiceImpl implements AdminService {
		
	@Autowired
	JdbcTemplate jt;

	@SuppressWarnings("deprecation")
	@Override
	public String registerAdmin(Admin admin) {
		String sql = "Insert into adminreg(firstname,lastname,age,gender,email,number,password,approval,validation1,validation2,validation3)values(?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
			int a = jt.update(sql,new Object[] {admin.getFirstName(),admin.getLastName(),admin.getAge(),admin.getGender(),admin.getEmail(),
					admin.getNumber(),admin.getPassword(),admin.getApproval(),admin.getValidation1(),admin.getValidation2(),admin.getValidation3()});
			if(a>=1)
			{
				String str1="select adminid from adminreg where email=?;";
				int adminid=jt.queryForObject(str1, new Object[] {admin.getEmail()},Integer.class);
				return "Registered successfully. Admin Id is "+adminid;
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

	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	@Override
	public Admin validateAdmin(int adminId, String password) {
		String str="select * from adminreg where adminid=? and password=?;";
		try
		{
			Admin admin=(Admin) jt.queryForObject(str, new Object[] {adminId,password}, new BeanPropertyRowMapper(Admin.class));
			return admin;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Admin> showRegAdmins() {
		String sql = "select * from adminreg;";
		try {
			List<Admin> alist = jt.query(sql, new BeanPropertyRowMapper(Admin.class));
			return alist;
		}catch(Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public String passwordrecovery(String validation1, String validation2, String validation3, String number,
			String email, String password) {
			String str = "update adminreg set password = ? where validation1= ? and validation2 =? and validation3 = ? and email = ? and number = ?";
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
	public String approveEnrollment(int empId,int sId) {
		String str="update enrolldet set approval=? where empid=? and sessionid=?;";
		try
		{
			int r=jt.update(str, new Object[] {"Approved",empId,sId});
			if(r>=1)
			{
				return "Approved";
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return "Error approving";
	}

	@Override
	public String rejectEnrollment(int empId,int sId) {
		String str="update enrolldet set approval=? where empid=? and sessionid=?;";
		try
		{
			int r=jt.update(str, new Object[] {"Rejected",empId,sId});
			if(r>=1)
			{
				return "Rejected";
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return "Error Rejecting";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Enrollment> showEnrollment() {
		List<Enrollment> reslist = new ArrayList<>();
		String str="select e.empid,u.firstname,u.lastname,e.sessionid,s.sessiondes,e.attendance,e.approval from userreg as u "
				+ "join enrolldet as e on u.empid=e.empid join sessiondet as s on s.sessionid=e.sessionid;";
		try
		{
			reslist= jt.query(str,new BeanPropertyRowMapper(Enrollment.class));
			return reslist;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	
}

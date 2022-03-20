package com.AttendanceMarkingProject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
		String sql = "Insert into adminreg(firstname,lastname,age,gender,number,password,approval)values(?,?,?,?,?,?,?)";
		try
		{
			int a = jt.update(sql,new Object[] {admin.getFirstName(),admin.getLastName(),admin.getAge(),admin.getGender(),
					admin.getNumber(),admin.getPassword(),admin.getApproval()});
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
	public List<Admin> showregadmins() {
		String sql = "select * from adminreg;";
		try {
			List<Admin> alist = jt.query(sql, new BeanPropertyRowMapper(Admin.class));
			return alist;
		}catch(Exception e) {
			e.getMessage();
		}
		return null;
	}

}

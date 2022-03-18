package com.AttendanceMarkingProject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.AttendanceMarkingProject.model.Session;
import com.AttendanceMarkingProject.service.SessionService;

@Component
public class SessionServiceImpl implements SessionService {

	@Autowired
	JdbcTemplate jt;
	
	@Override
	public String addSession(Session session) {
		// TODO Auto-generated method stub
		String sql = "Insert into sessiondet(sessionid,sessiondes,skillset,sessiondate,sessiontime,availslots) values(?,?,?,?,?,?);";
		try
		{
			int r = jt.update(sql, new Object[] {session.getSessionId(),session.getSessionDes(),session.getSkillSet(),session.getSessionDate(),session.getSessionTime(),session.getAvailSlots()});
			if(r>=1)
				return "Session Added";
			else
				return "Error...";
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return "Error...";
	}

}

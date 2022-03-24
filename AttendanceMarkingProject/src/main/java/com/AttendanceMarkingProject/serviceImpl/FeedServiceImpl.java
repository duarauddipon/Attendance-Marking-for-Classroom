package com.AttendanceMarkingProject.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.AttendanceMarkingProject.model.Answers;
import com.AttendanceMarkingProject.model.Questions;
import com.AttendanceMarkingProject.model.Session;

import com.AttendanceMarkingProject.service.FeedService;

@Component
public class FeedServiceImpl implements FeedService {

	@Autowired
	JdbcTemplate jt;

	@Override
	public String addAnswer(Answers answers) {
		// TODO Auto-generated method stub
		String sql = "Insert into feedans(ansa,ansb,ansc,ansd,sessionid) values(?,?,?,?,?);";
		try
		{
			int r = jt.update(sql, new Object[] {answers.getAnSa(),answers.getAnSb(),answers.getAnSc(),answers.getAnSd(),answers.getSessionId()});
			if(r>=1)
				return "FeedBack Submitted";
			else
				return "Error...";
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return "Error...";
		
		
	}

	@Override
	public List<Session> showSessionDet() {
		// TODO Auto-generated method stub
		
		List<Session> sllist = new ArrayList<>();
		String str = "select * from  sessiondet";
		
		sllist=jt.query(str, new BeanPropertyRowMapper(Session.class));
		return sllist;
		
	}

	@Override
	public String quest(Questions qwer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Questions> showQuestion() {
		// TODO Auto-generated method stub
		List<Questions> qlist = new ArrayList<>();
		String str ="select * from feedques";
		qlist = jt.query(str,new BeanPropertyRowMapper(Questions.class));
		return qlist;
		
	}

	@Override
	public List<Answers> showAnswer() {
		// TODO Auto-generated method stub
		List<Answers> alist = new ArrayList<>();
		String str = "select * from feedans";
		alist = jt.query(str, new BeanPropertyRowMapper(Answers.class));
		return alist;
	}

	@Override
	public String updateQuestion(Questions quest) {
		// TODO Auto-generated method stub
		String sql = "update feedques set quesb=?,quesb=?,=?,quesc=?,quesd=?  where sessionid=? ;";
		try {
			int r = jt.update(sql, new Object[] {quest.getQueSa(),quest.getQueSb(),quest.getQueSc(),quest.getQueSd(),quest.getSessionId()});
			if(r>=1)
				return "Questions Updated";
			else
				return "Error updating!";
		}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			return "Error updating!";
		
	}
	
	

}

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
	public String addQuestion(Questions ques) {
		
		String str= "insert into feedques(quesa,quesb,quesc,quesd,sessionid) values(?,?,?,?,?);";
		try
		{
			int r= jt.update(str,new Object[] {ques.getQueSa(),ques.getQueSb(),ques.getQueSc(),ques.getQueSd(),ques.getSessionId()});
			if(r>=1)
			{
				return "Success";
			}
			else
				return "Fail";
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return "Fail";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override

	public List<Questions> showQuestion() {
		// TODO Auto-generated method stub
		List<Questions> qlist = new ArrayList<>();
		String str ="select * from feedques";
		qlist = jt.query(str,new BeanPropertyRowMapper(Questions.class));
		return qlist;
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
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
		
		if(showQuestionBySessionId(quest.getSessionId())==null)
		{
			addQuestion(quest);
			return "Questions added";
		}
		String str = "update feedques set quesb=?,quesb=?,=?,quesc=?,quesd=? where sessionid=?;";
		try {
			int r = jt.update(str, new Object[] {quest.getQueSa(),quest.getQueSb(),quest.getQueSc(),quest.getQueSd(),quest.getSessionId()});
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

	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	@Override
	public Questions showQuestionBySessionId(int sessionId) {
		String str="select * from feedques where sessionid=?;";
		try
		{
			Questions qs= (Questions) jt.queryForObject(str, new Object[] {sessionId}, new BeanPropertyRowMapper(Questions.class));
			return qs;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}
}

package com.AttendanceMarkingProject.service;

import java.util.List;

import com.AttendanceMarkingProject.model.Session;

public interface SessionService {

	public String addSession(Session session);
	public Session searchSession(String sessionId);
	public List<Session> showSession();
	public String updateSession(Session session);
	
}

package com.AttendanceMarkingProject.model;

public class Enrollment {
	private int empId;
	private int sessionId;
	private String firstName;
	private String lastName;
	private String sessionDes;
	private String attendance;
	private String approval;
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSessionDes() {
		return sessionDes;
	}

	public void setSessionDes(String sessionDes) {
		this.sessionDes = sessionDes;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public Enrollment(String firstName, String lastName, String sessionDes, String attendance, String approval) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sessionDes = sessionDes;
		this.attendance = attendance;
		this.approval = approval;
	}
	
	public Enrollment()
	{
		super();
	}
	
}

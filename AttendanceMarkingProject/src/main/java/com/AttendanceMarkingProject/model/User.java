package com.AttendanceMarkingProject.model;

public class User {
	private String firstName;
	private String lastName;
	private int empId;
	private String email;
	private String password;
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
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String firstName, String lastName, int empId, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.empId = empId;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", empId=" + empId + ", email=" + email
				+ ", password=" + password + "]";
	}
	

}

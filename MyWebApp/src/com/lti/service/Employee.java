package com.lti.service;
public class Employee {
private int employeeId;
private String FirstName;
private String LastName;
private String Email;
private String Phonenumber;
private String HireDate;
private Double Salary;

public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPhonenumber() {
	return Phonenumber;
}
public void setPhonenumber(String phonenumber) {
	Phonenumber = phonenumber;
}
public String getHireDate() {
	return HireDate;
}
public void setHireDate(String hireDate) {
	HireDate = hireDate;
}
public Double getSalary() {
	return Salary;
}
public void setSalary(Double salary) {
	Salary = salary;
}


}

package com.lti.entity;
import com.lti.entity.Department;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_EMPLOYEE")
public class Employee {
	@Id         //primary key
    @GeneratedValue  //auto generate primary key
   private int empid;

private String name;
private Double salary;
@ManyToOne
@JoinColumn(name="deptno") //foreign key
private  Department dept;
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Double getSalary() {
	return salary;
}
public void setSalary(Double salary) {
	this.salary = salary;
}
public Department getDept() {
	return dept;
}
public void setDept(Department dept) {
	this.dept = dept;
}






}

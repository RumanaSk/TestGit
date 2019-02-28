package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabaseEmpService {
	public Employee  getviewdetails(int emp_id) {
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "Newuser123");
			
			String sql= "select FIRST_NAME,  LAST_NAME, EMAIL, PHONE_NUMBER ,hire_date,salary from employees where employee_id=? ";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, emp_id);
			rs=stmt.executeQuery();
    
			if(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(emp_id);
				emp.setFirstName(rs.getString(1));
				emp.setLastName(rs.getString(2));
				emp.setEmail(rs.getString(3));
				emp.setPhonenumber(rs.getString(4));
				emp.setHireDate(rs.getString(5));
				emp.setSalary(rs.getDouble(6));
				return emp;
			}	
			else 
				return null;
			
				} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
			return null;
		} finally {
			
				try {
					stmt.close();
				} catch (Exception e) {
				}
			
			
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
		}
	}

}

}

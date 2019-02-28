package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseLoginService {
	public String isValidUser(String userid, String pass) {
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		String fname=null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "Newuser123");
			String sql = "select count(1)   from table_user where userid=?  and pass=? and fullname=? and active='Y'";
			String sql1= "select fullname   from table_user where userid=?  and pass=? and active='Y'";
			stmt = conn.prepareStatement(sql1);
			stmt.setString(1, userid);
			stmt.setString(2, pass);
	
			

			rs = stmt.executeQuery();
			if (rs.next()) {
			 String fullname = rs.getString("fullname");//storing result of count function into count if 1 means user found if zero user not found
				
					return fullname;
			

			} else

				return fname;

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
			return "error";
		} finally {
			
				try {
					rs.close();
				} catch (Exception e) {
				}
			
			
			try {
				stmt.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
		}
	}

}
}
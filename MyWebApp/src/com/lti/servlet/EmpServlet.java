package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/emp.xls")
public class EmpServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType(" application/vnd.ms-excel");  //external application of excel is needed //vendor
	PrintWriter out=response.getWriter();
	out.println("Empno\tName\tSalary");
	out.println("1001\tRumana\t1000000");
	out.println("1002\tNeha\t100000");
	out.println("1003\tRuhane\t200000");
	
	
	}

}

package com.lti.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class empservlet
 */
@WebServlet("/empservlet")
public class empservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		

		DatabaseEmpService eService = new DatabaseEmpService();
		Employee emp=eService.getviewdetails(emp_id);

		HttpSession session = request.getSession();
        session.setAttribute("EmployeeData" ,emp);
        response.sendRedirect("EmpResult.jsp");
        
	

		}


	}



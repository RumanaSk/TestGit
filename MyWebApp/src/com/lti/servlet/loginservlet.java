package com.lti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.service.DatabaseLoginService;

@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
        String fname=" ";
        String message=" ";
		// InMemoryLoginService loginService=new InMemoryLoginService();
		DatabaseLoginService loginService = new DatabaseLoginService();
		String isValid = loginService.isValidUser(userid, pass);

		if (isValid !=null) {
			
            HttpSession session = request.getSession();
            session.setAttribute("LoggedInUser" ,isValid);
            
			response.sendRedirect("welcome.jsp");
		} else {
			HttpSession session1 = request.getSession();
			   session1.setAttribute("message","InValid  Username Password" );
			response.sendRedirect("login.jsp");

			// response.setContentType("text/html");
			// PrintWriter out=response.getWriter();

			/*
			 * if (userid.equals("rum") && pass.equals("neha"))
			 * response.sendRedirect("welcome.html");
			 * 
			 * else {
			 * 
			 * 
			 * response.sendRedirect("login.html");
			 * out.println("Invalid Username/Password");
			 */

		}

	}

}

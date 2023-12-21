package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddUser
 */
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		User newUser = new User(name,username,password);
		int status = UserDao.saveUser(newUser);
		
		if(status>0) {

			out.println("<h3>Registered successfully</h3>");			
			//request.getRequestDispatcher("Login.jsp").forward(request, response);	
			response.sendRedirect("Login.jsp");
		}
		else {
			out.println("<h3> Sorry!!! unable to save record</h3>");
		}
		 
	}

}

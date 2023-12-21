package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginUser
 */
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username= request.getParameter("username");
		String password= request.getParameter("password");

		
		int userid = UserDao.findUser(username,password);
		PrintWriter out = response.getWriter();
		if(userid >0) {
			List<Expense> list = UserDao.generateList(userid);
			session.setAttribute("ExpenseList", list);
			session.setAttribute("userid",userid);
//			request.getRequestDispatcher("ViewExpenseList.jsp").forward(request, response);
//			out.print("welcome" + username);
			response.sendRedirect("ViewExpenseList.jsp");
		}else {
			out.print("invalid credential");
		}
		
	}

}

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
 * Servlet implementation class DeleteExpense
 */
public class DeleteExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int expenseid = Integer.parseInt(request.getParameter("expid"));
		int userid =Integer.parseInt(request.getParameter("userid"));
		int result = UserDao.DeleteItem(expenseid);
		
		if(result > 0) {
			//session.removeAttribute("ExpenseList");
			List<Expense> list = UserDao.generateList(userid);
			session.setAttribute("ExpenseList", list);
			
			//request.setAttribute("ExpenseList", list);
//			RequestDispatcher rd = request.getRequestDispatcher("ViewExpenseList.jsp");
//			rd.forward(request, response);
			response.sendRedirect("ViewExpenseList.jsp");

		}else {
			out.print("<h3>Details not deleted</h3>");
		}
	}

}

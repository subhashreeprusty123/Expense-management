package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddProduct
 */
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		int userid = Integer.parseInt((String)request.getParameter("userid"));
		
		String strdate = (String)request.getParameter("expdate");
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		System.out.println("AddExpense Serv"+ userid + " " + strdate);
		Date date = null;
		try {
			date = format.parse(strdate);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		 String description = (String)request.getParameter("expdesc");
		 String type = (String)request.getParameter("exptype");
		 double amount = Double.parseDouble((String)request.getParameter("expamount"));
		 System.out.println("AddExpense Serv"+ userid + " " + strdate + " "+description + " " + type + " " + amount);
		 Expense newExp = new Expense(date,description,type,amount,userid);
		 System.out.println(newExp);
		 int result = UserDao.addItems(newExp);
		 
		 if(result>0) {
			 List<Expense> list = UserDao.generateList(userid);
			 
			 session.setAttribute("ExpenseList", list);
			 System.out.println("Add Product Serv " + list);
			//request.setAttribute("ExpenseList", list);
			// request.getRequestDispatcher("ViewExpenseList.jsp").forward(request, response);
			 response.sendRedirect("ViewExpenseList.jsp");
		 }else {
			 out.println("<h3>not able to add</h3>");
		 }
	}

}

package com.deloitte;

import java.sql.*;
import java.sql.Date;
import java.util.List;
import java.util.*;
import java.text.*;



public class UserDao {
	
	static Connection conn = null;
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensedb","root","Subha_1006");
			System.out.println("connected sucessfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//save user
	
		public static int saveUser(User user) {
			int status = 0;
			
			try {
				Connection conn = UserDao.getConnection();
				
				PreparedStatement ps = conn.prepareStatement("insert into user(name,username,password) values(?,?,?)");
				
				ps.setString(1, user.getName());
				ps.setString(2, user.getUsername());
				ps.setString(3, user.getPassword());
			
				status = ps.executeUpdate();	
			}catch(Exception e) {
				e.printStackTrace();
			}
			return status;
		}
		
		public static int findUser(String username,String password) {
			int id =0;
			
			try {
				Connection conn = UserDao.getConnection();
				PreparedStatement ps= conn.prepareStatement("select id from user where username =? and password = ?");
				
				ps.setString(1, username);
				ps.setString(2, password);
				
				
				ResultSet rs= ps.executeQuery();
				if(rs.next()) {
					id = rs.getInt(1);
					generateList(id);
					//return true;
				}
					
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return id;
		}
		
		public static List<Expense> generateList(int userid){
			List<Expense> list = new ArrayList();
			try {
				Connection conn = UserDao.getConnection();
				PreparedStatement ps= conn.prepareStatement("select expId,expense_date,expense_type,expense_description,amount from expense where ? = expense.userId");
				
				ps.setInt(1, userid);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					int expid=rs.getInt(1);
					Date date = rs.getDate(2);
					String type = rs.getString(3);
					String desc = rs.getString(4);
					double amount = rs.getDouble(5);
					
					Expense exp = new Expense(expid,date,type,desc,amount,userid);
					System.out.println("Dao " + exp);
					list.add(exp);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			return list;
			
		}

		public static int DeleteItem(int expenseid) {
			int result =0;
			try {
				Connection conn = UserDao.getConnection();
				PreparedStatement ps = conn.prepareStatement("delete from expense where expId = ?");
				
				ps.setInt(1, expenseid);
				
				result = ps.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}

		public static int addItems(Expense newExp) {
			System.out.println("User Dao "+ newExp);
			int result =0;
			try {
				Connection conn = UserDao.getConnection();
				PreparedStatement ps= conn.prepareStatement("insert into expense(expense_date, expense_type ,expense_description , amount,userId) values (?,?,?,?,?);");
	             
				SimpleDateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
				String formattedDate = outputFormatter.format(newExp.getExpense_date());
				 
  
                Date sqlDate = Date.valueOf(formattedDate);
				ps.setDate(1, sqlDate);
				ps.setString(2, newExp.getExpense_type());
				ps.setString(3, newExp.getExpense_desc());
				ps.setDouble(4, newExp.getAmount());
				ps.setInt(5, newExp.getUser_id());
				
				result = ps.executeUpdate();
				System.out.println(result + " row(s) updated");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}

}

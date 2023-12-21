package com.deloitte;

import java.util.Date;

public class Expense {
	private int expense_id;
	private Date expense_date;
	private String expense_type;
	private String expense_desc;
	private double amount;
	private int user_id;
	
	public Expense(Date expense_date, String expense_type, String expense_desc, double amount) {
		super();
		//this.userid = userid;
		this.expense_date = expense_date;
		this.expense_type = expense_type;
		this.expense_desc = expense_desc;
		this.amount = amount;
	}
	
	public Expense(int expense_id, Date expense_date, String expense_type, String expense_desc, double amount,
			int user_id) {
		
		this.expense_id = expense_id;
		this.expense_date = expense_date;
		this.expense_type = expense_type;
		this.expense_desc = expense_desc;
		this.amount = amount;
		this.user_id = user_id;
	}

	public Expense(Date expense_date, String expense_type, String expense_desc, double amount, int user_id) {
		super();
		this.expense_date = expense_date;
		this.expense_type = expense_type;
		this.expense_desc = expense_desc;
		this.amount = amount;
		this.user_id = user_id;
	}

	public Expense(int expense_id, Date expense_date, String expense_type, String expense_desc, double amount) {
		super();
		this.expense_id = expense_id;
		this.expense_date = expense_date;
		this.expense_type = expense_type;
		this.expense_desc = expense_desc;
		this.amount = amount;
	}

	public Date getExpense_date() {
		return expense_date;
	}
	public void setExpense_date(Date expense_date) {
		this.expense_date = expense_date;
	}
	public String getExpense_type() {
		return expense_type;
	}
	public void setExpense_type(String expense_type) {
		this.expense_type = expense_type;
	}
	public String getExpense_desc() {
		return expense_desc;
	}
	public void setExpense_desc(String expense_desc) {
		this.expense_desc = expense_desc;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getExpense_id() {
		return expense_id;
	}
	public void setExpense_id(int expense_id) {
		this.expense_id = expense_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Expense [ expense_date=" + expense_date + ", expense_type=" + expense_type
				+ ", expense_desc=" + expense_desc + ", amount=" + amount + ", user_id=" + user_id + "]";
	}

}

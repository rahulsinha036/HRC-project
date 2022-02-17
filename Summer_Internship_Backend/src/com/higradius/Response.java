package com.higradius;
import java.sql.Date;
public class Response {
	
	private String name_customer;
	private String cust_number;
	private long orderId;
	private Date due_date;
	private double total_open_amount;
	private String notes;
	
	public String getName_customer() {
		return name_customer;
	}
	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}
	
	public String getCust_number() {
		return cust_number;
	}
	public void setCust_number(String cust_number) {
		this.cust_number = cust_number;
	}
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	
	public double getTotal_open_amount() {
		return total_open_amount;
	}
	public void setTotal_open_amount(double total_open_amount) {
		this.total_open_amount = total_open_amount;
	}
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}

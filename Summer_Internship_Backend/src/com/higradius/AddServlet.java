package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.higradius.POJO;


public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection c;
    public Statement s=null;
    public String url="jdbc:mysql://localhost:3306/h2h_internship";
    public String user="root";
    public String password="root";
    public String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		POJO tempInvoice=new POJO();
		System.out.println("servlet call");
		tempInvoice.setcustname(request.getParameter("name_customer"));
		tempInvoice.setcustno(request.getParameter("cust_number"));
		tempInvoice.setinvoiceid(request.getParameter("invoice_id"));
		tempInvoice.settotal_open_amt(request.getParameter("total_open_amount"));
		try {
			tempInvoice.setdue_in_date(request.getParameter("due_in_date"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tempInvoice.setnotes(request.getParameter("notes"));
		tempInvoice.setdocid(request.getParameter("invoice_id"));
		try {
			Class.forName(jdbcDriver).newInstance();
			c = DriverManager.getConnection(url,user,password);
	        s = c.createStatement();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String query="insert into invoice_details(cust_number,name_customer,due_in_date,total_open_amount,invoice_id,notes,doc_id) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement psmt=c.prepareStatement(query);
			psmt.setString(1, tempInvoice.getcustno());
			psmt.setString(2, tempInvoice.getcustname());
			psmt.setDate(3, tempInvoice.getdue_in_date());
			psmt.setDouble(4, tempInvoice.gettotal_open_amt());
			psmt.setLong(5, tempInvoice.getinvoiceid());
			psmt.setString(6, tempInvoice.getnotes());
			psmt.setLong(7, tempInvoice.getdocid());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			c.close();
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.higradius.POJO;

public class SearchInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection c;
    public Statement s=null;
    public String url="jdbc:mysql://localhost:3306/h2h_internship";
    public String user="root";
    public String password="root";
    public String jdbcDriver = "com.mysql.cj.jdbc.Driver";
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<POJO> invoice = new ArrayList<POJO>();
		String str=req.getParameter("searchId");
		System.out.println(str);
		try {
			Class.forName(jdbcDriver).newInstance();
			c = DriverManager.getConnection(url,user,password);
	        s = c.createStatement();
	        
	        String query="SELECT * FROM invoice_details where CAST(invoice_id AS CHAR) LIKE '"+str+"%' Limit 100";
	        System.out.println(query);
	        ResultSet rs=s.executeQuery(query);
	        while(rs.next()) {
				POJO tempInvoice=new POJO();
				tempInvoice.setcustname(rs.getString("name_customer"));
				tempInvoice.setcustno(rs.getString("cust_number"));
				tempInvoice.setinvoiceid(rs.getString("invoice_id"));
				tempInvoice.settotal_open_amt(rs.getString("total_open_amount"));
				try {
					tempInvoice.setdue_in_date(rs.getString("due_in_date"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tempInvoice.setnotes(rs.getString("notes"));
				invoice.add(tempInvoice);
			}
	        
	        c.close();
			s.close();
	        
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Gson gson=new Gson();
		String data=gson.toJson(invoice);
		System.out.println(data);
		PrintWriter out=resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		out.print(data);
		out.flush();
	}
}

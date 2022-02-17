package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class dummyServlet
 */
@WebServlet(urlPatterns= {"/dummy"}, name="userdummy")
public class DummyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/h2h_internship";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";
    Connection conn=null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DummyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
			 Class.forName(JDBC_DRIVER).newInstance();
			 conn = DriverManager.getConnection(DB_URL,USER,PASS);
			 conn.setAutoCommit(false);
			 PreparedStatement stmt = conn.prepareStatement("Select name_customer,cust_number,doc_id,due_in_date,total_open_amount, notes from invoice_details");
			 
			 List<Response> resp=new ArrayList<Response>();
			 
			 ResultSet rs = stmt.executeQuery();
			 
			 while(rs.next()) {
				 Response pojo=new Response();
				 
				 pojo.setName_customer(rs.getString("name_customer"));
				 pojo.setCust_number(rs.getString("cust_number"));
				 pojo.setOrderId(rs.getLong("doc_id"));
				 pojo.setDue_date(rs.getDate("due_in_date"));
				 pojo.setTotal_open_amount(rs.getDouble("total_open_amount"));
				 pojo.setNotes(rs.getString("notes"));
				 
				 resp.add(pojo);
			 }
			 
			 Gson gson = new Gson();
			 String data = gson.toJson(resp);
			 PrintWriter out = response.getWriter();
			 response.setContentType("application/json");
			 response.setCharacterEncoding("UTF-8");
			 out.print(data);
			 out.flush();
			 
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

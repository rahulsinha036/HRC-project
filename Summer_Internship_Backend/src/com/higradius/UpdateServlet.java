package com.higradius;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteRecord
 */
@WebServlet("/update")

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static Connection conn = null;
	public static PreparedStatement pst = null;
	static ArrayList<Response> data ;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/h2h_internship";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("trying editing !!");  
		Response invoice =  new Response();
		 
		PrintWriter out = response.getWriter();
		try {
			
		Double inv_amt = Double.parseDouble(request.getParameter("total_order_amount"));
		String note = request.getParameter("notes");
		Long inv_id = (long) Integer.parseInt(request.getParameter("orderId"));
		
		invoice.setTotal_open_amount(inv_amt);
		invoice.setNotes(note);
		invoice.setOrderId(inv_id);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection conn=DriverManager.getConnection(  
			DB_URL,USER,PASS);  
			              
			PreparedStatement pst=conn.prepareStatement("update invoice_details set total_open_amount=?, notes=? where invoice_id=?");  
			pst.setDouble(1, invoice.getTotal_open_amount());
			pst.setString(2, invoice.getNotes());
			Long id = invoice.getOrderId();
			if(id != null) {
				pst.setLong(3, id);
			}else {
				pst.setNull(3, java.sql.Types.INTEGER);
			} 
			
			  
			int i = pst.executeUpdate();
			if(i>=0) {
				out.print("Row Edited !!");
			}
			 
			out.flush();   
			conn.close();
			System.out.println("Connection Closed!");
			}catch(SQLException se){
				
				se.printStackTrace();
			}catch(Exception e){
				
				e.printStackTrace();
			}finally{
				
				try{
					if(pst!=null)
						pst.close();
				}catch(SQLException se2){
					se2.printStackTrace();
				}
				try{
					if(conn!=null)
					conn.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
			}
					
		}
	}

package com.higradius;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteRecord
 */
@WebServlet("/delete")

public class DeleteServlet extends HttpServlet {
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
    public DeleteServlet() {
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
		System.out.print("trying deletion !!");
		Response invoice =  new Response();
		//response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
	try{
		Long inv_id =(long) Integer.parseInt(request.getParameter("orderId"));
		invoice.setOrderId(inv_id);
		
		System.out.println(inv_id);
		
	} catch (Exception e) {
			e.printStackTrace();
		}
		
		try{  
			
			Class.forName(JDBC_DRIVER);  
			Connection conn=DriverManager.getConnection(  
					DB_URL,USER,PASS);  
			              
			PreparedStatement pst=conn.prepareStatement("delete from invoice_details where invoice_id=?");  
			Long id = invoice.getOrderId();
			if(id != null) {
				pst.setLong(1, id);
			}else {
				pst.setNull(1, java.sql.Types.INTEGER);
			}  			               
			  
			int i = pst.executeUpdate();
			if(i>=0) {
				out.print("Row Deleted Successfully!!");
			}
		} 
			catch(SQLException se){
				//Handle errors for JDBC
				se.printStackTrace();
			}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
			}finally{
				//finally block used to close resources
				try{
					if(pst!=null)
						pst.close();
				}catch(SQLException se2){
				se2.printStackTrace();
				}
				try{
					if(conn!=null)
					conn.close();
					System.out.println("Connection Closed!");
				}catch(SQLException se){
					se.printStackTrace();
				}
			}			
	}
}


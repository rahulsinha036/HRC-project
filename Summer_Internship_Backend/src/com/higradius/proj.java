package com.higradius;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.sql.Date;
import java.util.*;


import com.higradius.pojo.pojoo;


public class proj {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/h2h_internship";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";


	public static void main(String[] args) {
		
		Connection conn = null;
		
		BufferedReader reader = null;
		String file="src//com//higradius//1806126.csv";
		
		String line = "";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO invoice_details (business_code,cust_number, name_customer,clear_date,business_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,area_business,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id,isOpen) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			reader= new BufferedReader(new FileReader(file));
			
			line=reader.readLine();
			int z=0;
			while ((line=reader.readLine())!=null) {
				z++;
				pojoo pj=new pojoo();
				String[] row=line.split(",");
						
				pj.setBusiness_code(row[0]);						
						
						
				pj.setCust_number(row[1]);
				pj.setName_customer(row[2]);
				
				if (row[3].isEmpty())
					row[3]=null;
						
				pj.setClear_date(row[3]);
				pj.setBuisness_year(row[4]);
				pj.setDoc_id(row[5]);
				pj.setPosting_date(row[6]);
				pj.setDocument_create_date(row[7]);
				pj.setDocument_create_date_1(row[8]);
				pj.setDue_in_date(row[9]);
				pj.setInvoice_currency(row[10]);
				pj.setDocument_type(row[11]);
				pj.setPosting_id(row[12]);
				pj.setArea_business(row[13]);
				pj.setTotal_open_amount(row[14]);
				pj.setBaseline_create_date(row[15]);
				pj.setCust_payment_terms(row[16]);
				pj.setInvoice_id(row[17]);
				pj.setIsOpen(row[18]);
						
				
				stmt.setString(1, pj.getBusiness_code());
				stmt.setString(2, pj.getCust_number());
				stmt.setString(3, pj.getName_customer());
				
				if (pj.getClear_date()==null) {
					stmt.setNull(4, java.sql.Types.DATE);
				}
				else {
					long clr=pj.getClear_date().getTime();
					java.sql.Date clrdate=new java.sql.Date(clr);
					stmt.setDate(4, (clrdate));
				}
				
				stmt.setInt(5, pj.getBuisness_year());
				stmt.setLong(6, pj.getDoc_id());
				
				long pd=pj.getPosting_date().getTime();
				java.sql.Date psd=new java.sql.Date(pd);
				stmt.setDate(7, psd);
				
				long dcd1=pj.getDocument_create_date_1().getTime();
				java.sql.Date dcdii=new java.sql.Date(dcd1);
				stmt.setDate(8, dcdii);
				
				long did=pj.getDue_in_date().getTime();
				java.sql.Date did1=new java.sql.Date(did);
				stmt.setDate(9, did1);
				
				stmt.setString(10, pj.getInvoice_currency());
				stmt.setString(11, pj.getDocument_type());
				stmt.setDouble(12, pj.getPosting_id());
				stmt.setString(13, pj.getArea_business());
				stmt.setDouble(14, pj.getTotal_open_amount());
				
				long bcd=pj.getBaseline_create_date().getTime();
				java.sql.Date bcdi=new java.sql.Date(bcd);
				stmt.setDate(15, bcdi);
				
				stmt.setString(16, pj.getCust_payment_terms());
				
				if (pj.getInvoice_id()==0)
					stmt.setNull(17, Types.NULL);
				else 
					stmt.setLong(17, pj.getInvoice_id());
				
				stmt.setInt(18, pj.getIsOpen());
				
				stmt.addBatch();
			}
			stmt.executeBatch();
			conn.setAutoCommit(true);
			System.out.println(z);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


}

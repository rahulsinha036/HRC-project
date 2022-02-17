package com.higradius.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class pojoo {
	private String business_code;
	private String cust_number;
	private String name_customer;
	private Date clear_date;
	private int buisness_year;
	private long doc_id;
	private Date posting_date;
	private Date document_create_date;
	private Date document_create_date_1;
	private Date due_in_date;
	private String invoice_currency;
	private String document_type;
	private double posting_id;
	private String area_business;
	private double total_open_amount;
	private Date baseline_create_date;
	private String cust_payment_terms;
	private long invoice_id;
	private int isOpen;
	
	

	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	
	public String getCust_number() {
		return cust_number;
	}
	public void setCust_number(String cust_number) {
		this.cust_number = cust_number;
	}
	
	public String getName_customer() {
		return name_customer;
	}
	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}
	
	public Date getClear_date() {
		return clear_date;
	}
	public void setClear_date(String clear_date) {
		if (clear_date==null)
			this.clear_date=null;
		else {
			SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
			try {
				this.clear_date = ft.parse(clear_date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getBuisness_year() {
		return buisness_year;
	}
	public void setBuisness_year(String buisness_year) {
		double b_year=Double.parseDouble(buisness_year);
		this.buisness_year = (int) b_year;
	}
	
	public long getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(String doc_id) {
		double d_id=Double.parseDouble(doc_id);
		this.doc_id = (long)(d_id);
	}
	
	public Date getPosting_date() {
		return posting_date;
	}
	public void setPosting_date(String posting_date) {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		try {
			this.posting_date = ft.parse(posting_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Date getDocument_create_date() {
		return document_create_date;
	}
	public void setDocument_create_date(String document_create_date) {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMdd");
		try {
			this.document_create_date = ft.parse(document_create_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Date getDocument_create_date_1() {
		return document_create_date_1;
	}
	public void setDocument_create_date_1(String document_create_date_1) {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMdd");
		try {
			this.document_create_date_1 = ft.parse(document_create_date_1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Date getDue_in_date() {
		return due_in_date;
	}
	public void setDue_in_date(String due_in_date) {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMdd");
		try {
			String did=Long.toString((long) Double.parseDouble(due_in_date));
			this.due_in_date = ft.parse(did);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getInvoice_currency() {
		return invoice_currency;
	}
	public void setInvoice_currency(String invoice_currency) {
		this.invoice_currency = invoice_currency;
	}
	
	public String getDocument_type() {
		return document_type;
	}
	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}
	
	public double getPosting_id() {
		return posting_id;
	}
	public void setPosting_id(String posting_id) {
		this.posting_id = Double.parseDouble(posting_id);
	}
	
	public String getArea_business() {
		return area_business;
	}
	public void setArea_business(String area_business) {
		this.area_business = area_business;
	}
	
	public double getTotal_open_amount() {
		return total_open_amount;
	}
	public void setTotal_open_amount(String total_open_amount) {
		this.total_open_amount = Double.parseDouble(total_open_amount);
	}
	
	public Date getBaseline_create_date() {
		return baseline_create_date;
	}
	public void setBaseline_create_date(String baseline_create_date) {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMdd");
		try {
			String bcd=Long.toString((long) Double.parseDouble(baseline_create_date));
			this.baseline_create_date = ft.parse(bcd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getCust_payment_terms() {
		return cust_payment_terms;
	}
	public void setCust_payment_terms(String cust_payment_terms) {
		this.cust_payment_terms = cust_payment_terms;
	}
	
	public long getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(String invoice_id) {
		if (invoice_id.isEmpty())
			this.invoice_id=0;
		else
			this.invoice_id = (long) Double.parseDouble(invoice_id);
	}
	
	public int getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		this.isOpen = Integer.parseInt(isOpen);
	}
		
}

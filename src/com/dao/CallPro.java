package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallPro {
	private Connection conn=null;
	private CallableStatement cstat=null;
	
	public String boRe(String sql,String cardCode,String bookCode){
		String msg=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn=DriverManager.getConnection(com.dao.Conf.DB_URL);
			cstat=conn.prepareCall(sql);
			cstat.setString(1, cardCode);
			cstat.setString(2, bookCode);
			cstat.executeQuery();
			
			msg=cstat.getString(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return msg;
	}
	
	private void close(){
		try {
			cstat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

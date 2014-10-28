package com.wepull.s1.dao;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;


public class DataSource {
    private static   BasicDataSource  bs;
    
    public static BasicDataSource getDataSource(){
    	if(bs==null){
    		 bs = new BasicDataSource();
    	    bs.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		 bs.setUrl("jdbc:sqlserver://localhost:1433;databaseName=struts");
    		 bs.setUsername("sa");
    		 bs.setPassword("123");
    		 bs.setMaxActive(5);
    	}
    	return bs;
    }
    
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con =
				DataSource.getDataSource().getConnection();
			System.out.println(con.isClosed());
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}

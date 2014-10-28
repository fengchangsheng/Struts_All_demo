package com.wepull.s1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public int validate(String username,String password){
		int id = 0;
		try {
			con = DataSource.getDataSource().getConnection();
			ps = con.prepareStatement
			("select * from login where username='"+username+"' and password= '"+password+"'");
			rs =ps.executeQuery();
			if(rs.next()){
				id = rs.getInt(1);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
}

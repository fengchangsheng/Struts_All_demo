package com.wepull.s1.dao;
import java.sql.*;
import java.util.*;
public class UserDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	private static final int PAGENO=3;
	public UserDAO() {
		super();
	}
	public UserDAO(Connection con) {
		super();
		this.con = con;
	}
	public void add(UserDTO dto){
		try {
			con = DataSource.getDataSource().getConnection();
			ps = con.prepareStatement("insert into users values(?,?,?)");
			//ps.setInt(1, dto.getUserId());
			//ps.setDate(2, new java.sql.Date(10100000));
			ps.setInt(1, dto.getUserId());
			ps.setString(2, dto.getUsername());
			ps.setString(3, dto.getPassword());
		
			ps.execute();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取总页数
	public int getMaxPage(){
		int maxPage=0;
		int total=0;
		try {
			con = DataSource.getDataSource().getConnection();
			ps = con.prepareStatement("select count(*) from users ");
			rs = ps.executeQuery();
			if(rs.next()){
				total=rs.getInt(1);
			}
			maxPage = (total+PAGENO-1)/PAGENO;
		   con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxPage;
		
	}
	public List<UserDTO>  pageInition(int page){
		int maxPage = this.getMaxPage();
		if(page<1)  page=1;
		else if(page>=maxPage){
			page = maxPage;
		}
		List<UserDTO> list = new ArrayList<UserDTO> ();
		try {
			con = DataSource.getDataSource().getConnection();
			ps = con.prepareStatement
			("select *  from users"
					,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs =ps.executeQuery();
			//定位(防止为0 故加1  多定一条)
			rs.absolute((page-1)*PAGENO+1);
			//此处回定
			rs.previous();
			
			int counter=0;
			while(rs.next()&&counter<PAGENO){
				UserDTO dto = new UserDTO();
				dto.setUserId(rs.getInt(1));
				dto.setUsername(rs.getString(2));
				dto.setPassword(rs.getString(3));
			
				list.add(dto);
				counter++;
				}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	/*public PagerModel  pageInition(int offset,int pagesize){
		PagerModel pm = new PagerModel();
		List<UserDTO> list = new ArrayList<UserDTO> ();
		try {
			con = DataSource.getDataSource().getConnection();
			ps = con.prepareStatement("select count(*)  from users");
			rs= ps.executeQuery();
			if(rs.next()){
				pm.setTotal(rs.getInt(1));
			}
			ps = con.prepareStatement
			("select *  from users"
					,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs =ps.executeQuery();
			// ���϶�λ��
			rs.absolute(offset);// offset =(page-1)*pagesize;
			// �ع�һ��
			//rs.previous();
			
			int counter=0;
			while(rs.next()&&counter<pagesize){
				UserDTO dto = new UserDTO();
				dto.setUserId(rs.getInt(1));
				dto.setUsername(rs.getString(2));
				dto.setPassword(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setTel(rs.getString(5));
				
				list.add(dto);
				counter++;
			}
				pm.setDatas(list);
				
				con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pm;
		
	}*/
	
	
	public List<UserDTO>  findAll(){

		List<UserDTO> list = new ArrayList<UserDTO> ();
		try {
			con = DataSource.getDataSource().getConnection();
			ps = con.prepareStatement
			("select *  from users");
			rs =ps.executeQuery();
			while(rs.next()){
				UserDTO dto = new UserDTO();
				dto.setUserId(rs.getInt(1));
				dto.setUsername(rs.getString(2));
				dto.setPassword(rs.getString(3));
				
				list.add(dto);
				}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public UserDTO  queryOne(int id){
		UserDTO  dto = new UserDTO();
		try {
			con = DataSource.getDataSource().getConnection();
			ps = con.prepareStatement
			("select *  from users where userId=? ");
			ps.setInt(1, id);
			rs =ps.executeQuery();
			if(rs.next()){
				dto.setUserId(rs.getInt(1));
				dto.setUsername(rs.getString(2));
				dto.setPassword(rs.getString(3));
				}
		con.close();
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
		
	}
	public void update(UserDTO dto){
		try {
			con = DataSource.getDataSource().getConnection();
			ps = con.prepareStatement(" update users set username=?,password=?" +
					"  where userId=?");
			ps.setString(1, dto.getUsername());
			ps.setString(2, dto.getPassword());
			//ps.setString(3, dto.getEmail());
			//ps.setString(4, dto.getTel());
			ps.setInt(3, dto.getUserId());
			ps.execute();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void delete(int userId){
		try {
			con = DataSource.getDataSource().getConnection();
			ps = con.prepareStatement(" delete from users where userId=?");
			ps.setInt(1, userId);
			ps.execute();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(String[] ids){
		
		try {
			con = DataSource.getDataSource().getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement("delete from users where userId=?");
			for(int i=0;i<ids.length;i++){
				ps.setInt(1, Integer.parseInt(ids[i]));
				ps.execute();
			}
			//2.提交事物
			con.commit();
			// 3 设置回自动提交
			con.setAutoCommit(true);
			con.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
     public static void main(String[] args) {
    	 try {
			Connection con = DataSource.getDataSource().getConnection();
			 UserDAO dao =new UserDAO(con);
	    	 List<UserDTO> list =dao.findAll();
	    	 for (UserDTO dto : list) {
				System.out.println(dto.getUserId()+"   :   "+dto.getUsername());
			 }
	    	 UserDTO  dto  = new UserDTO(16,"steven","sv");
	    	 dao.update(dto);
	    	 // 
	    	 //UserDTO  dto  = new UserDTO(4,"qiying","123","8999@qq.com","15972183723");
	    	 //dao.add(dto);
	    	 con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}

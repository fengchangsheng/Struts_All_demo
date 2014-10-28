package com.wepull.action1;

import com.opensymphony.xwork2.Action;
/**
 * @author fcs
 *	第一种获取值的方式 将参数定义成属性并写set/get方法
 * 2014-8-19
 */
public class UserAction implements Action{
	private int userId;
	private String username;
	private String password;
	
	//get/set方法
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toAdd(){
		return this.SUCCESS;
	}
	public String add(){
		System.out.println(this.userId+" "+this.username);
		return "list";
	}
	public String delete(){
		return "list";
	}
	
	public String toEdit(){
		return this.SUCCESS;
	}
	public String list(){
		return this.SUCCESS;
	}
	@Override
	public String execute() throws Exception {
		return this.SUCCESS;
	}
}

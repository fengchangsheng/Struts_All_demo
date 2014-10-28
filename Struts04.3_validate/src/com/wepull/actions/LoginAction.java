package com.wepull.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.wepull.s1.dao.LoginDAO;
import com.wepull.s1.dao.UserDAO;
/**
 * 验证是否合法--服务器端验证
 * 如果没有错误就执行下一步
 * 有错误则调转到input指向的页面
 * 每次进来都会自动调用validate()方法
 */
public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	
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

	@Override
	public void validate() {
		if(null==username||username.equals("")){
			this.addFieldError("usermsg", "用户名不能为空");
		}
		//应该到i18n里取 username.error
		if(null==password||password.equals("")){
			this.addFieldError("passmsg", "用户名不能为空");
		}
		LoginDAO dao = new LoginDAO();
		if(dao.validate(username, password)==0){
			this.addFieldError("errormsg", "用户名或密码输入错误");
		}
	}
	
	
}

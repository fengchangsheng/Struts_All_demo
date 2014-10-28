package com.wepull.action3;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.wepull.s1.dao.UserDAO;
import com.wepull.s1.dao.UserDTO;
/**
 * @author fcs
 *	第三种:实现modelDriven接口
 *  第四种:获取request response
 * 2014-8-19
 */
public class UserAction implements Action,ModelDriven{
	private UserDTO userdto = new UserDTO();
	private List<UserDTO> users;
	
	
	public UserDTO getUserdto() {
		return userdto;
	}
	public void setUserdto(UserDTO userdto) {
		this.userdto = userdto;
	}
	public List<UserDTO> getUsers() {
		return users;
	}
	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
	
	public String execute() throws Exception {
		/**
		 * 直接获取request response
		 * 
		 */
		HttpServletRequest request = ServletActionContext.getRequest();
		return this.SUCCESS;
	}
	public String toAdd(){
		return this.SUCCESS;
	}
	public String add(){
		//System.out.println(userdto.getUserId()+" "+userdto.getUsername());
		new UserDAO().add(userdto);
		return "list";
	}
	public String delete(){
		return "list";
	}
	
	public String toEdit(){
		return this.SUCCESS;
	}
	public String list(){
		UserDAO dao = new UserDAO();
		users = dao.findAll();
		return this.SUCCESS;
	}
	@Override
	public UserDTO getModel() {
		return userdto;
	}

}

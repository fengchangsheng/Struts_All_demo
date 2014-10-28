package com.wepull.actions;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.wepull.s1.dao.Pager;
import com.wepull.s1.dao.PagerModel;
import com.wepull.s1.dao.UserDAO;
import com.wepull.s1.dao.UserDTO;
/**
 * @author fcs
 *	分页组件  自动分页  显示存在的所有页数
 * 2014-8-20
 */
public class UserAction implements Action{
	private UserDTO userdto;
	private List<UserDTO> users;
	private String[] ids;
	private PagerModel pm;//分页组件
	private Pager pager;
	
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public PagerModel getPm() {
		return pm;
	}
	public void setPm(PagerModel pm) {
		this.pm = pm;
	}
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public List<UserDTO> getUsers() {
		return users;
	}
	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
	
	public UserDTO getUserdto() {
		return userdto;
	}
	public void setUserdto(UserDTO userdto) {
		this.userdto = userdto;
	}
	
	public String execute() throws Exception {
		return this.SUCCESS;
	}
	public String toAdd(){
		return this.SUCCESS;
	}
	public String add(){
		new UserDAO().add(userdto);
		return "list";
	}
	public String delete(){
		UserDAO dao = new UserDAO();
		dao.delete(ids);
		return "list";
	}
	
	public String toEdit(){
		UserDAO dao = new UserDAO();
		userdto = dao.queryOne(userdto.getUserId());
		return this.SUCCESS;
	}
	
	public String edit(){
		UserDAO dao = new UserDAO();
		dao.update(userdto);
		return "list";
	}
	
	public String list(){
		UserDAO dao = new UserDAO();
		int offset = 0;
		if(null!= pager){
			offset = pager.getOffset();
		}
		pm = dao.pageInition(offset, 3);
		return this.SUCCESS;
	}

}

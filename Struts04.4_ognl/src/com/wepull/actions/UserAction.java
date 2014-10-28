package com.wepull.actions;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.wepull.s1.dao.UserDAO;
import com.wepull.s1.dao.UserDTO;
/**
 * @author fcs
 *	第二种:将所有参数封装成一个javabean(dto....)
 *	将dto作为Action的属性 为其生成set/get方法
 * 2014-8-19
 */
public class UserAction implements Action{
	private UserDTO userdto;
	private List<UserDTO> users;
	private String[] ids;
	private String pageStr;//当前页
	private String maxPage;//最大页
	
	public String getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(String maxPage) {
		this.maxPage = maxPage;
	}
	public String getPageStr() {
		return pageStr;
	}
	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
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
//		users = dao.findAll();
		users = dao.pageInition(Integer.parseInt(pageStr));
		maxPage = dao.getMaxPage()+"";
		return this.SUCCESS;
	}

}

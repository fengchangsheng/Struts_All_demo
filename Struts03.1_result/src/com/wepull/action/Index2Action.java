package com.wepull.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * @author fcs
 * 2.继承ActionSupport类  方法返回字符串（返回值跟result配置有关）
 * 2014-8-18
 */
public class Index2Action extends ActionSupport {
	public String execute(){
		return this.SUCCESS;
		//return "success";
	}
	
	public String add(){
		return "add";
	}
	
	public String list(){
		return "list";
	}
}

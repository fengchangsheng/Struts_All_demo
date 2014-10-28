package com.wepull.action;
/**
 * @author fcs
 * 1.直接写Action类  方法返回字符串（返回值跟result配置有关）
 * 2014-8-18
 */
public class Index1Action {
	public String execute(){
		return "success";
	}
	
	public String add(){
		return "add";
	}
	
	public String list(){
		return "list";
	}
}

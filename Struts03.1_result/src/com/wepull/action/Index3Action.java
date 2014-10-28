package com.wepull.action;


import com.opensymphony.xwork2.Action;
/**
 * @author fcs
 * 3.实现Action接口  方法返回字符串（返回值跟result配置有关）
 * 2014-8-18
 */
public class Index3Action implements Action{
	public String execute(){
		return "success";//return this.SUCCESS;
	}
	
	public String add(){
		return "ddd";
	}
	
	public String list(){
		return "abc";
	}
}

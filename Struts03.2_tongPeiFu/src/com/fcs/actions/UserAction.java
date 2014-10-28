package com.fcs.actions;

import com.opensymphony.xwork2.Action;

public class UserAction implements Action {

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return this.SUCCESS;
	}
	
	public String toAdd(){
		return this.SUCCESS;
	}
	
	public String toUpdate(){
		return this.SUCCESS;
	}
	
	public String add(){
		return "list";
	}
	
	public String update(){
		return this.SUCCESS;
	}
	
	public String list(){
		return this.SUCCESS;
	}

}

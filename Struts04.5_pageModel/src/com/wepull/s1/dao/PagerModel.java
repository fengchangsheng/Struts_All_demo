package com.wepull.s1.dao;



import java.util.List;

public class PagerModel {

	private int total;//总的记录条数
	private List datas;//数据
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getDatas() {
		return datas;
	}
	public void setDatas(List datas) {
		this.datas = datas;
	}
	
	
}

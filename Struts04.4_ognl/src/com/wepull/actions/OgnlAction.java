package com.wepull.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
/**
 * @author fcs
 * OGNL
 * 2014-8-20
 */
public class OgnlAction implements Action {
	private String name = "wpj1403";
	public static final int LEN = 10;
	private Person per = new Person(21,"朱猪猪","female");
	private List<Person> pers = new ArrayList<Person>();
	private Map<String,Person> map = new HashMap<String,Person>();
	
	
	public Map<String, Person> getMap() {
		return map;
	}

	public void setMap(Map<String, Person> map) {
		this.map = map;
	}

	public Person getPer() {
		return per;
	}
	
	public List<Person> getPers() {
		return pers;
	}

	public void setPers(List<Person> pers) {
		this.pers = pers;
	}

	public void setPer(Person per) {
		this.per = per;
	}

	public static int getLen(){
		return LEN;
	}
	
	public String fun(){
		return "haha";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}
	public String show(){
		for (int i = 0; i < 5; i++) {
			Person p = new Person(i,"per","male");
			map.put(i+"", p);
			pers.add(p);
		}
		return "success";
	}

}

package com.wepull.actions;
/**
 * 一定要set/get??
 * @author fcs
 *
 * 2014-8-20
 */
public class Person {
	private int id;
	private String name;
	private String sex;
	
	public Person() {
		super();
	}

	public Person(int id, String name, String sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	
	public String say(){
		return "hello"+name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}

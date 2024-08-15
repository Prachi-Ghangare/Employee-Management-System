package com.qsp.model;

public class Employee {
	private int id;
	private String name;
	@Override
	public String toString() {
		return "id" + id + "\tname" + name + "\tsal=" + sal;
	}
	private double sal;
	
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
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
}

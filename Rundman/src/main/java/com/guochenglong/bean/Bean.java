package com.guochenglong.bean;

import java.io.Serializable;

public class Bean implements Serializable{
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @fieldName: id
	 * @fieldType: Integer
	 * @Description: id
	 */
	private Integer id;
	/**
	 * shirt+Alt+J
	 * @fieldName: name
	 * @fieldType: String
	 * @Description: 姓名
	 */
	private String name;
	/**
	 * @fieldName: phone
	 * @fieldType: String
	 * @Description: 电话
	 */
	private String phone;
	/**
	 * @fieldName: address
	 * @fieldType: String
	 * @Description: 地址
	 */
	private String address;
	/** 
	 * @Title:Employee
	 * @Description:TODO  
	 */
	
	/** 
	 * @Title:Employee
	 * @Description:TODO 
	 * @param id
	 * @param name
	 * @param phone
	 * @param address 
	 */
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
	public Bean(Integer id, String name, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public Bean() {
		super();
		// TODO Auto-generated constructor stub
	}

}

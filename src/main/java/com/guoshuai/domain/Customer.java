package com.guoshuai.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "name", "age", "id" })
@XmlRootElement(name="_customer",namespace="http://sina.com.cn/classannoce")
public class Customer {

	@XmlElement(name = "_name",required=true,namespace="http://sina.com.cn/metadata")
	String name;
	@XmlElement(name = "_age")
	int age;
	@XmlElement(name = "_id")
	int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	
	

}

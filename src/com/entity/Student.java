package com.entity;

import java.util.Date;

/**
 * Studentʵ����
 * 
 * @author Administrator
 *
 */
public class Student {
	private int id; // ѧ��id
	private String name; // ѧ������
	private String sex; // ѧ���Ա�
	private int age; // ѧ������
	private String email; // ѧ������
	private Date date; // �޸�����

	public Student() {
		super();
	}

	public Student(int id, String name, String sex, int age, String address, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.email = address;
		this.date = date;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", address=" + email
				+ ", date=" + date + "]";
	}

}

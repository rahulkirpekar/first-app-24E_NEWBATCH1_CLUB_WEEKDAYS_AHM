package com.royal.bean;

public class StudentBean 
{
	private int id	         ;
	private String fullname  ;
	private int age          ;
	private String course    ;
	private String gender    ;
	private String hobby[]     ;
	private String dob       ;
	private String email     ;
	private String mobile    ;
	private String address   ;
	
	public StudentBean() 
	{
	}

	public StudentBean(int id, String fullname, int age, String course, String gender, String[] hobby, String dob,
			String email, String mobile, String address) {
		this.id = id;
		this.fullname = fullname;
		this.age = age;
		this.course = course;
		this.gender = gender;
		this.hobby = hobby;
		this.dob = dob;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}
	public StudentBean(String fullname, int age, String course, String gender, String[] hobby, String dob,
			String email, String mobile, String address) 
	{
		this.fullname = fullname;
		this.age = age;
		this.course = course;
		this.gender = gender;
		this.hobby = hobby;
		this.dob = dob;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}

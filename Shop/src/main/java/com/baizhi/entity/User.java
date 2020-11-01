package com.baizhi.entity;

public class User {

	private Integer id;

	private String userName;

	private String passWord;

	private int age;

	private String mobile;

	private String email;

	private String address;

	private String status;

	private String head_pic;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHead_pic() {
		return head_pic;
	}

	public void setHead_pic(String head_pic) {
		this.head_pic = head_pic;
	}

	public User(Integer id, String userName, String passWord, int age, String mobile, String email, String address,
			String status, String head_pic) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.status = status;
		this.head_pic = head_pic;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", age=" + age + ", mobile="
				+ mobile + ", email=" + email + ", address=" + address + ", status=" + status + ", head_pic=" + head_pic
				+ "]";
	}

}

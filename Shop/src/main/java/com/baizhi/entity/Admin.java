package com.baizhi.entity;

public class Admin {
	private Integer id;

	private String name;

	private String pwd;

	private String mobile;

	private String email;

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public Admin(Integer id, String name, String pwd, String mobile, String email) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.mobile = mobile;
		this.email = email;
	}

	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", pwd=" + pwd + ", mobile=" + mobile + ", email=" + email + "]";
	}

}

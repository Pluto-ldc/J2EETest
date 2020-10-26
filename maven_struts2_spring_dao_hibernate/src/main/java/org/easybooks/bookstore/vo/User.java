package org.easybooks.bookstore.vo;
// Generated 2020年10月2日 下午2:59:36 by Hibernate Tools 5.4.18.Final

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String userName;
	private String passWord;

	public User() {
	}

	public User(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + "]";
	}

}

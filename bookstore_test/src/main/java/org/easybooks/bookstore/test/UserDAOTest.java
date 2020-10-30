package org.easybooks.bookstore.test;

import org.easybooks.bookstore.dao.IUserDAO;
import org.easybooks.bookstore.vo.User;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class UserDAOTest extends AbstractDependencyInjectionSpringContextTests{
	private IUserDAO userDAO;	//用于调用DAO层方法
	//指定spring配置文件的位置
	protected String[] getConfigLocations() {
		String[] str=new String[]{"classpath:org/easybooks/bookstore/test/applicationContext.xml"};
		return str;
	}
	//由Spring使用设值注入方式注入UserDAO的实例
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	//测试UserDAO中的validateUser()方法
	public void testValidateUser(){
		User u=userDAO.validateUser("大花","123");
		this.assertNull(u);
		//this.assertEquals(u,new User());
	}
	public void testExitUser(){
		boolean result=userDAO.exitUser("花花");
		this.assertEquals(true, result);
		boolean actual=userDAO.exitUser("大运");
		this.assertFalse(actual);
	}
	public void testSaveUser(){
		User u=new User();
		u.setUsername("大云");
		u.setPassword("345");
		u.setSex("男");
		u.setAge(67);
		userDAO.saveUser(u);
		this.assertTrue(true);
	}
}

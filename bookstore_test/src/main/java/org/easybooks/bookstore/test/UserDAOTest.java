package org.easybooks.bookstore.test;

import org.easybooks.bookstore.dao.IUserDAO;
import org.easybooks.bookstore.vo.User;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class UserDAOTest extends AbstractDependencyInjectionSpringContextTests{
	private IUserDAO userDAO;	//���ڵ���DAO�㷽��
	//ָ��spring�����ļ���λ��
	protected String[] getConfigLocations() {
		String[] str=new String[]{"classpath:org/easybooks/bookstore/test/applicationContext.xml"};
		return str;
	}
	//��Springʹ����ֵע�뷽ʽע��UserDAO��ʵ��
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	//����UserDAO�е�validateUser()����
	public void testValidateUser(){
		User u=userDAO.validateUser("��","123");
		this.assertNull(u);
		//this.assertEquals(u,new User());
	}
	public void testExitUser(){
		boolean result=userDAO.exitUser("����");
		this.assertEquals(true, result);
		boolean actual=userDAO.exitUser("����");
		this.assertFalse(actual);
	}
	public void testSaveUser(){
		User u=new User();
		u.setUsername("����");
		u.setPassword("345");
		u.setSex("��");
		u.setAge(67);
		userDAO.saveUser(u);
		this.assertTrue(true);
	}
}

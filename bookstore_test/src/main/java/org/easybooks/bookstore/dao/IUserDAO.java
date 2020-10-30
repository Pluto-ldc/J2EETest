package org.easybooks.bookstore.dao;

import org.easybooks.bookstore.vo.User;

public interface IUserDAO {
	//��֤�û���¼��Ϣ
	public User validateUser(String username,String password);
	//ע��ʱ��֤�û���Ϣ
	public void saveUser(User user);
	//ע��ʱ�ж��û����Ƿ��Ѿ�����
	public boolean exitUser(String username);
}
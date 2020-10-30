package org.easybooks.bookstore.dao.impl;

import java.util.List;

import org.easybooks.bookstore.dao.BaseDAO;
import org.easybooks.bookstore.dao.IUserDAO;
import org.easybooks.bookstore.vo.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO extends BaseDAO implements IUserDAO {

	public void saveUser(User user){
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}
	
	public User validateUser(String username, String password) 
	{
		Session session=getSession();//��ȡ�Ự
		String hql="from User u where u.username=? and u.password=?";
		Query query=session.createQuery(hql);//������ѯ����
		query.setParameter(0, username);
		query.setParameter(1, password);
		List users=query.list();//��ɲ�ѯ���õ�List����
		if (users.size()!=0) //���������0����֤�ɹ������Ե�¼
		{
			User u=(User)users.get(0);//ȡ�������еĵ�һ��Ԫ��
			return u;
		}
		session.close();//�رջỰ
		return null;
	}

	@Override
	public boolean exitUser(String username) {
		Session session=getSession();
		String hql="from User u where u.username=?";
		Query query=session.createQuery(hql);
		query.setParameter(0, username);
		List users=query.list();
		session.close();
		if(users.size()!=0){
			User user=(User)users.get(0);
			return true;
		}
		return false;
	}
	

}

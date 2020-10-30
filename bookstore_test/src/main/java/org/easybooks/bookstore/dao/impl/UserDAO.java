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
		Session session=getSession();//获取会话
		String hql="from User u where u.username=? and u.password=?";
		Query query=session.createQuery(hql);//创建查询对象
		query.setParameter(0, username);
		query.setParameter(1, password);
		List users=query.list();//完成查询，得到List集合
		if (users.size()!=0) //如果不等于0，验证成功，可以登录
		{
			User u=(User)users.get(0);//取出集合中的第一个元素
			return u;
		}
		session.close();//关闭会话
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

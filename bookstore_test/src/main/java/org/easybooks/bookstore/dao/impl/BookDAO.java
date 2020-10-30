package org.easybooks.bookstore.dao.impl;

import java.util.List;

import org.easybooks.bookstore.dao.*;
import org.easybooks.bookstore.vo.Book;
import org.hibernate.*;

public class BookDAO extends BaseDAO implements IBookDAO{
	public  List getBookbyCatalogid(Integer catalogid) {
		Session session=this.getSession();//��ȡ�Ự
		String hql="from Book b where b.catalog.catalogid=?";
		Query query=session.createQuery(hql);//������ѯ����
		query.setParameter(0, catalogid);
		List books=query.list();//��ɲ�ѯ���õ�List����
		session.close();//�رջỰ
		return null;
	}

	public List getBookbyCatalogidPaging(Integer catalogid, int currentPage,int pageSize) {
		Session session=getSession();
		String hql="from Book b where b.catalog.catalogid=?";
		Query query=session.createQuery(hql);
		query.setParameter(0, catalogid);
		int startRow=(currentPage-1)*pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List books=query.list();
		session.close();
		return books;
	}

	public int getTotalbyCatalog(Integer catalogid) {
		Session session=getSession();
		Query query=session.createQuery("from Book b where b.catalog.catalogid=?");
		query.setParameter(0, catalogid);
		List books=query.list();
		int totalSize=books.size();
		session.close();
		return totalSize;
	}
	
	public List getNewBook() {
		Session session=getSession();
		Query query=session.createQuery("from Book b where b.catalog.catalogid=1");
		List books=query.list();
		session.close();
		return books;
	}
	
	public List getRequiredBookbyHql(String hql){
		Session session=getSession();
		Query query=session.createQuery(hql);
		List books=query.list();
		return books;
	}

	public Book getBookbyId(Integer bookid) {
		Session session=getSession();
		Book book=(Book)session.get(Book.class,bookid);
		session.close();
		return book;
	}
	
	
}

package org.easybooks.bookstore.dao.impl;

import java.util.List;

import org.easybooks.bookstore.dao.*;
import org.easybooks.bookstore.vo.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class BookDAO extends BaseDAO implements IBookDAO {
	public List<Book> getBookbycatalogId(Integer catalogId) {
		Session session = this.getSession();
		String hql = "from Book b where b.catalog.catalogd=?0";
		Query<Book> query = session.createQuery(hql, Book.class);
		query.setParameter(0, catalogId);
		List<Book> books = query.list();
		session.close();
		return null;
	}

	public List<Book> getBookbycatalogIdPaging(Integer catalogId, int currentPage, int pageSize) {
		Session session = getSession();
		String hql = "from Book b where b.catalog.catalogId=?0";
		Query<Book> query = session.createQuery(hql, Book.class);
		query.setParameter(0, catalogId);
		int startRow = (currentPage - 1) * pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List<Book> books = query.getResultList();
		session.close();
		return books;
	}

	public int getTotalbyCatalog(Integer catalogId) {
		Session session = getSession();
		Query<?> query = session.createQuery("from Book b where b.catalog.catalogId=?0");
		query.setParameter(0, catalogId);
		List<?> books = query.list();
		int totalSize = books.size();
		session.close();
		return totalSize;
	}

	public List<Book> getNewBook() {
		Session session = getSession();
		Query<Book> query = session.createQuery("from Book b where b.catalog.catalogId=1", Book.class);
		List<Book> books = query.list();
		session.close();
		return books;
	}

	public List<Book> getRequiredBookbyHql(String hql) {
		Session session = getSession();
		Query<Book> query = session.createQuery(hql, Book.class);
		List<Book> books = query.list();
		return books;
	}

	public Book getBookbyId(Integer bookid) {
		Session session = getSession();
		Book book = (Book) session.get(Book.class, bookid);
		session.close();
		return book;
	}

}

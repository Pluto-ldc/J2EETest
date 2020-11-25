package org.easybooks.bookstore.dao.impl;

import java.util.List;

import org.easybooks.bookstore.dao.BaseDAO;
import org.easybooks.bookstore.dao.IBookDAO;
import org.easybooks.bookstore.vo.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class BookDAO extends BaseDAO implements IBookDAO {

	private Query<Book> getBookbyCatalogIdQuery(Session session, Integer catalogId) {
		String hql = "from Book b where b.catalog.catalogId = ?0";
		return session.createQuery(hql, Book.class).setParameter(0, catalogId);
	}

	@Override
	public List<Book> getBookbycatalogId(Integer catalogId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<Book> books = getBookbyCatalogIdQuery(session, catalogId).getResultList();
		session.close();
		return books;
	}

	@Override
	public Book getBookbyId(Integer bookId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Book book = session.get(Book.class, bookId);
		session.close();
		return book;
	}

	@Override
	public List<Book> getNewBooks() {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "FROM Book b ORDER BY bookId DESC";
		Query<Book> query = session.createQuery(hql, Book.class).setMaxResults(3);
		List<Book> bookList = query.getResultList();
		session.close();
		return bookList;
	}

	@Override
	public List<Book> getBookbybookName(String bookNameKey) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "from Book b where b.bookName like ?0";
		Query<Book> query = session.createQuery(hql, Book.class).setParameter(0, bookNameKey).setMaxResults(3);
		List<Book> bookList = query.getResultList();
		session.close();
		return bookList;
	}

	@Override
	public int getTotalSizebycatalogId(Integer catalogId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		int totalSize = getBookbyCatalogIdQuery(session, catalogId).getResultList().size();
		session.close();
		return totalSize;
	}

	@Override
	public List<Book> getBookbycatalogIdPaging(Integer catalogId, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<Book> books = getBookbyCatalogIdQuery(session, catalogId).setFirstResult((currentPage - 1) * pageSize)
				.setMaxResults(pageSize).getResultList();
		session.close();
		return books;
	}

}

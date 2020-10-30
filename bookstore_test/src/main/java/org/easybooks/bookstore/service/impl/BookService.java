package org.easybooks.bookstore.service.impl;

import java.util.List;

import org.easybooks.bookstore.dao.IBookDAO;
import org.easybooks.bookstore.service.IBookService;
import org.easybooks.bookstore.vo.Book;

public class BookService implements IBookService {
	private IBookDAO bookDAO;
	
	public List getBookbyCatalogid(Integer catalogid) {
		return bookDAO.getBookbyCatalogid(catalogid);
	}
	
	public List getBookbyCatalogidPaging(Integer catalogid, int currentPage,int pageSize) {
		return bookDAO.getBookbyCatalogidPaging(catalogid, currentPage, pageSize);
	}
	
	public int getTotalbyCatalog(Integer catalogid) {
		return bookDAO.getTotalbyCatalog(catalogid);
	}
	public IBookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(IBookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public List getNewBook() {
		return bookDAO.getNewBook();
	}
	//ËÑË÷Í¼Êé
	public List getRequiredBookbyHql(String hql) {
		return bookDAO.getRequiredBookbyHql(hql);
	}

	public Book getBookbyId(Integer bookid) {
		return bookDAO.getBookbyId(bookid);
	}
	
}

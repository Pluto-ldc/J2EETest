package org.easybooks.bookstore.service.impl;

import java.util.List;

import org.easybooks.bookstore.dao.IBookDAO;
import org.easybooks.bookstore.service.IBookService;
import org.easybooks.bookstore.vo.Book;

public class BookService implements IBookService {

	private IBookDAO bookDAO;

	public void setBookDAO(IBookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public List<Book> getBookbycatalogId(Integer catalogId) {
		// TODO Auto-generated method stub
		return bookDAO.getBookbycatalogId(catalogId);
	}

	@Override
	public Book getBookbyId(Integer bookId) {
		// TODO Auto-generated method stub
		return bookDAO.getBookbyId(bookId);
	}

	@Override
	public List<Book> getNewBooks() {
		// TODO Auto-generated method stub
		return bookDAO.getNewBooks();
	}

	@Override
	public List<Book> getBookbybookName(String bookNameKey) {
		// TODO Auto-generated method stub
		if (bookNameKey != null && bookNameKey.length() != 0) {
			bookNameKey = "%" + bookNameKey + "%";
		} else {
			bookNameKey = "%%";
		}
		return bookDAO.getBookbybookName(bookNameKey);
	}

	@Override
	public int getTotalSizebycatalogId(Integer catalogId) {
		// TODO Auto-generated method stub
		return bookDAO.getTotalSizebycatalogId(catalogId);
	}

	@Override
	public List<Book> getBookbycatalogIdPaging(Integer catalogId, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return bookDAO.getBookbycatalogIdPaging(catalogId, currentPage, pageSize);
	}

}

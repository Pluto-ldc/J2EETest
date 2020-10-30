package org.easybooks.bookstore.service;

import java.util.List;

import org.easybooks.bookstore.vo.Book;

public interface IBookService {
	
	public List<Book> getBookbyCatalogid(Integer catalogid);

	public List<Book> getBookbyCatalogidPaging(Integer catalogid, int currentPage, int pageSize);

	public int getTotalbyCatalog(Integer catalogid);

	public List<Book> getNewBook();

	public List<Book> getRequiredBookbyHql(String hql);

	public Book getBookbyId(Integer bookid);

}

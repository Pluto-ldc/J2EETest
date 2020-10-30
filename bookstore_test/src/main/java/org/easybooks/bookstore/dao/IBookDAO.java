package org.easybooks.bookstore.dao;

import java.util.List;

import org.easybooks.bookstore.vo.Book;

public interface IBookDAO {
	public List<Book> getBookbycatalogId(Integer catalogId);
	public List<Book> getBookbycatalogIdPaging(Integer catalogId,int currentPage,int pageSize);
	public int getTotalbyCatalog(Integer catalogId);
	public List<Book> getNewBook();
	public List<Book> getRequiredBookbyHql(String hql);
	public Book getBookbyId(Integer bookid);
	
}

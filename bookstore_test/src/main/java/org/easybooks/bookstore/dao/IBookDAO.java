package org.easybooks.bookstore.dao;

import java.util.List;

import org.easybooks.bookstore.vo.Book;

public interface IBookDAO {
	public List getBookbyCatalogid(Integer catalogid);
	public List getBookbyCatalogidPaging(Integer catalogid,int currentPage,int pageSize);
	public int getTotalbyCatalog(Integer catalogid);
	public List getNewBook();
	public List getRequiredBookbyHql(String hql);
	public Book getBookbyId(Integer bookid);
	
}

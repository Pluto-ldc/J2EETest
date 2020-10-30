package org.easybooks.bookstore.service;

import java.util.List;

import org.easybooks.bookstore.vo.Book;

public interface IBookService {
	public List getBookbyCatalogid(Integer catalogid);
	public List getBookbyCatalogidPaging(Integer catalogid,int currentPage,int pageSize);
	public int getTotalbyCatalog(Integer catalogid);
	public List getNewBook();
	public List getRequiredBookbyHql(String hql);//ËÑË÷Í¼Êé
	public Book getBookbyId(Integer bookid);
	
}

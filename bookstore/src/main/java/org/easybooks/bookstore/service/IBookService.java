package org.easybooks.bookstore.service;

import java.util.List;

import org.easybooks.bookstore.vo.Book;

public interface IBookService {

	/**
	 * 通过图书分类Id获取该分类下所有图书
	 * 
	 * @param catalogId 图书分类Id
	 * @return 返回图书集合
	 */
	List<Book> getBookbycatalogId(Integer catalogId);

	/**
	 * 通过图书Id获取图书对象
	 * 
	 * @param bookId 图书Id
	 * @return 返回图书Id对应的图书对象
	 */
	Book getBookbyId(Integer bookId);

	/**
	 * 获取最新图书，按照主键id倒序前三本书
	 * 
	 * @return 返回图书集合
	 */
	List<Book> getNewBooks();

	/**
	 * 通过图书名称关键字模糊查询图书
	 * 
	 * @return 返回图书集合
	 */
	List<Book> getBookbybookName(String bookNameKey);

	/**
	 * 通过图书Id获取当前分类下图书总数
	 * 
	 * @param catalogId 图书分类Id
	 * @return 目标分类下图书总数
	 */
	int getTotalSizebycatalogId(Integer catalogId);

	/**
	 * 通过图书Id和分页获取目标分类下分页后图书
	 * 
	 * @param catalogId   图书分类Id
	 * @param currentPage 图书当前页
	 * @param pageSize    图书每页条数
	 * @return pageSize条图书数据
	 */
	List<Book> getBookbycatalogIdPaging(Integer catalogId, int currentPage, int pageSize);

}

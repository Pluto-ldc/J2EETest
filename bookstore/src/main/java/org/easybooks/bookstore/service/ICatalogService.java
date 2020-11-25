package org.easybooks.bookstore.service;

import java.util.List;

import org.easybooks.bookstore.vo.Catalog;

public interface ICatalogService {

	/**
	 * 获取所有图书分类
	 * 
	 * @return 返回所有图书分类对象
	 */
	List<Catalog> getAllCatalogs();

}

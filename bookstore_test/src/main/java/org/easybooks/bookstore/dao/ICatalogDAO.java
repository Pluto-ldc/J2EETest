package org.easybooks.bookstore.dao;

import java.util.List;

import org.easybooks.bookstore.vo.Catalog;

public interface ICatalogDAO {
	
	public List<Catalog> getAllCatalogs();
	
}

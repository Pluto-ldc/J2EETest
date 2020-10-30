package org.easybooks.bookstore.service.impl;

import java.util.List;

import org.easybooks.bookstore.dao.ICatalogDAO;
import org.easybooks.bookstore.service.ICatalogService;
import org.easybooks.bookstore.vo.Catalog;

public class CatalogService implements ICatalogService {

	private ICatalogDAO catalogDAO;

	public List<Catalog> getAllCatalogs() {
		
		return catalogDAO.getAllCatalogs();
	}

	public ICatalogDAO getCatalogs() {
		return catalogDAO;
	}

	public void setCatalogDAO(ICatalogDAO catalogDAO) {
		this.catalogDAO = catalogDAO;
	}
}

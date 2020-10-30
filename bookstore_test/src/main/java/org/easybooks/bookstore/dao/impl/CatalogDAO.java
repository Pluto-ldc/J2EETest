package org.easybooks.bookstore.dao.impl;

import java.util.List;

import org.easybooks.bookstore.dao.BaseDAO;
import org.easybooks.bookstore.dao.ICatalogDAO;
import org.easybooks.bookstore.vo.Catalog;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class CatalogDAO extends BaseDAO implements ICatalogDAO {
	
	public List<Catalog> getAllCatalogs() {
		Session session = getSession();
		Query<Catalog> query = session.createQuery("from Catalog c", Catalog.class);
		List<Catalog> catalogs = query.getResultList();
		session.close();
		return catalogs;
	}

}

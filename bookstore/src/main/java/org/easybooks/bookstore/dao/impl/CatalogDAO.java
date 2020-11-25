package org.easybooks.bookstore.dao.impl;

import java.util.List;

import org.easybooks.bookstore.dao.BaseDAO;
import org.easybooks.bookstore.dao.ICatalogDAO;
import org.easybooks.bookstore.vo.Catalog;
import org.hibernate.Session;

public class CatalogDAO extends BaseDAO implements ICatalogDAO {

	@Override
	public List<Catalog> getAllCatalogs() {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<Catalog> catalogs = session.createQuery("from Catalog c", Catalog.class).getResultList();
		session.close();
		return catalogs;
	}

}

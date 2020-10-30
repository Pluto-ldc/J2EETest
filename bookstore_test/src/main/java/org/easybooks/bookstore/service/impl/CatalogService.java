package org.easybooks.bookstore.service.impl;

import java.util.List;

import org.easybooks.bookstore.dao.ICatalogDAO;
import org.easybooks.bookstore.service.ICatalogService;

public class CatalogService implements ICatalogService{
	
	private ICatalogDAO catalogDAO;//用于调用dao层的方法
	//获取所有图书类别
	public  List getAllCatalogs(){
		return catalogDAO.getAllCatalogs();
	}
	public  ICatalogDAO getCatalogs(){
		return catalogDAO;
	}
	public void setCatalogDAO(ICatalogDAO catalogDAO){
		this.catalogDAO=catalogDAO;
	}
}

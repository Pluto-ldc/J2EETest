package org.easybooks.bookstore.vo;
// Generated 2020年10月30日 下午3:55:50 by Hibernate Tools 5.4.21.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Book generated by hbm2java
 */
public class Book implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer bookId;
	private Catalog catalog;
	private String bookName;
	private int price;
	private String picture;
	private Set<?> orderItems = new HashSet<Object>(0);

	public Book() {
	}

	public Book(Catalog catalog, String bookName, int price, String picture) {
		this.catalog = catalog;
		this.bookName = bookName;
		this.price = price;
		this.picture = picture;
	}

	public Book(Catalog catalog, String bookName, int price, String picture, Set<?> orderItems) {
		this.catalog = catalog;
		this.bookName = bookName;
		this.price = price;
		this.picture = picture;
		this.orderItems = orderItems;
	}

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Catalog getCatalog() {
		return this.catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Set<?> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(Set<?> orderItems) {
		this.orderItems = orderItems;
	}

}

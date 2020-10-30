package org.easybooks.bookstore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private Integer bookid;
	private Catalog catalog;
	private String bookname;
	private Integer price;
	private String picture;
	private Set orderitems = new HashSet(0);

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** minimal constructor */
	public Book(Catalog catalog, String bookname, Integer price, String picture) {
		this.catalog = catalog;
		this.bookname = bookname;
		this.price = price;
		this.picture = picture;
	}

	/** full constructor */
	public Book(Catalog catalog, String bookname, Integer price,
			String picture, Set orderitems) {
		this.catalog = catalog;
		this.bookname = bookname;
		this.price = price;
		this.picture = picture;
		this.orderitems = orderitems;
	}

	// Property accessors

	public Integer getBookid() {
		return this.bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	public Catalog getCatalog() {
		return this.catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public String getBookname() {
		return this.bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Set getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

}
package org.easybooks.bookstore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Catalog entity. @author MyEclipse Persistence Tools
 */

public class Catalog implements java.io.Serializable {

	// Fields

	private Integer catalogid;
	private String catalogname;
	private Set books = new HashSet(0);

	// Constructors

	/** default constructor */
	public Catalog() {
	}

	/** minimal constructor */
	public Catalog(String catalogname) {
		this.catalogname = catalogname;
	}

	/** full constructor */
	public Catalog(String catalogname, Set books) {
		this.catalogname = catalogname;
		this.books = books;
	}

	// Property accessors

	public Integer getCatalogid() {
		return this.catalogid;
	}

	public void setCatalogid(Integer catalogid) {
		this.catalogid = catalogid;
	}

	public String getCatalogname() {
		return this.catalogname;
	}

	public void setCatalogname(String catalogname) {
		this.catalogname = catalogname;
	}

	public Set getBooks() {
		return this.books;
	}

	public void setBooks(Set books) {
		this.books = books;
	}

}
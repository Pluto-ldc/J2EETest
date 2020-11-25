package org.easybooks.bookstore.action;

import org.easybooks.bookstore.service.ICatalogService;
import org.easybooks.bookstore.util.Pager;
import org.easybooks.bookstore.vo.Book;
import org.easybooks.bookstore.vo.Catalog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.easybooks.bookstore.service.IBookService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String BOOKS = "books";

	private ICatalogService catalogService;

	private IBookService bookService;

	private Integer catalogId = 1;

	private Integer currentPage = 1;

	private String bookNameKey;

	public void setBookNameKey(String bookNameKey) {
		this.bookNameKey = bookNameKey;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 获取所有图书分类
	 * 
	 * @return
	 */
	public String browseCatalog() {
		List<Catalog> catalogs = catalogService.getAllCatalogs();
		ServletActionContext.getRequest().setAttribute("catalogs", catalogs);
		return SUCCESS;
	}

	/**
	 * 获取最新图书
	 * 
	 * @return
	 */
	public String browseNewBook() {
		List<Book> books = bookService.getNewBooks();
		ServletActionContext.getRequest().setAttribute(BOOKS, books);
		return SUCCESS;

	}

	/**
	 * 通过图书分类Id获取该分类下所有图书
	 * 
	 * @return
	 */
	public String browseBook() {
		List<Book> books = bookService.getBookbycatalogId(catalogId);
		ServletActionContext.getRequest().setAttribute(BOOKS, books);
		return SUCCESS;
	}

	/**
	 * 模糊查询图书
	 * 
	 * @return
	 */
	public String searchBook() {
		List<Book> books = bookService.getBookbybookName(bookNameKey);
		ServletActionContext.getRequest().setAttribute(BOOKS, books);
		return SUCCESS;
	}

	/**
	 * 分页查询图书
	 * 
	 * @return
	 */
	public String browseBookPaging() {
		if (currentPage < 1) {
			currentPage = 1;
		}
		int totalSize = bookService.getTotalSizebycatalogId(catalogId);
		Pager pager = new Pager(currentPage, totalSize);
		if (currentPage > pager.getTotalPage()) {
			this.currentPage = pager.getTotalPage() != 0 ? pager.getTotalPage() : 1;
			pager = new Pager(currentPage, totalSize);
		}
		List<Book> books = bookService.getBookbycatalogIdPaging(catalogId, pager.getCurrentPage(), pager.getPageSize());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute(BOOKS, books);
		request.setAttribute("pager", pager);
		ActionContext.getContext().getSession().put("catalogId", catalogId);
		return SUCCESS;
	}

}

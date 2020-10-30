package org.easybooks.bookstore.action;

import java.util.*;
import org.easybooks.bookstore.service.ICatalogService;
import org.easybooks.bookstore.service.IBookService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.easybooks.bookstore.util.Pager;

public class BookAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ICatalogService catalogService;
	protected IBookService bookService;
	protected Integer catalogid; 
	private Integer currentPage = 1;
	private String bookname;

	public String browseCatalog() throws Exception {
		List<?> catalogs = catalogService.getAllCatalogs();
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("catalogs", catalogs);
		return SUCCESS;
	}

	public String browseBook() throws Exception {
		List<?> books = bookService.getBookbyCatalogid(catalogid);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;
	}

	public String browseBookPaging() throws Exception {
		int totalSize = bookService.getTotalbyCatalog(catalogid);
		Pager pager = new Pager(currentPage, totalSize);
		List<?> books = bookService.getBookbyCatalogidPaging(catalogid, currentPage, pager.getPageSize());
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("books", books);
		request.put("pager", pager);
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("catalogid", catalogid);
		return SUCCESS;
	}

	public String searchBook() throws Exception {
		StringBuffer hql = new StringBuffer("from Book b ");
		if (bookname != null && bookname.length() != 0)
			hql.append("where b.bookname like '%" + bookname + "%'");
		List<?> books = bookService.getRequiredBookbyHql(hql.toString());
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;
	}

	public String browseNewBook() throws Exception {
		List<?> books = bookService.getNewBook();
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;
	}

	public ICatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public Integer getCatalogid() {
		return catalogid;
	}

	public void setCatalogid(Integer catalogid) {
		this.catalogid = catalogid;
	}

	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
}

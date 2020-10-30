package org.easybooks.bookstore.action;

import java.util.*;
import org.easybooks.bookstore.service.ICatalogService;
import org.easybooks.bookstore.service.IBookService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.easybooks.bookstore.util.Pager;
import org.easybooks.bookstore.vo.Book;

public class BookAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ICatalogService catalogService;
	protected IBookService bookService;
	protected Integer catalogId;
	private Integer currentPage = 1;
	private String bookName;

	public ICatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
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

	public Integer getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@SuppressWarnings("unchecked")
	public String browseCatalog() throws Exception {
		List<?> catalogs = catalogService.getAllCatalogs();
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("catalogs", catalogs);
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String browseBook() throws Exception {
		List<?> books = bookService.getBookbyCatalogid(catalogId);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String browseBookPaging() throws Exception {
		int totalSize = bookService.getTotalbyCatalog(catalogId);
		Pager pager = new Pager(currentPage, totalSize);
		List<Book> books = bookService.getBookbyCatalogidPaging(catalogId, currentPage, pager.getPageSize());
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		
		request.put("books", books);
		request.put("pager", pager);
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("catalogid", catalogId);
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String searchBook() throws Exception {
		StringBuffer hql = new StringBuffer("from Book b ");
		if (bookName != null && bookName.length() != 0)
			hql.append("where b.bookName like '%" + bookName + "%'");
		List<?> books = bookService.getRequiredBookbyHql(hql.toString());
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String browseNewBook() throws Exception {
		List<?> books = bookService.getNewBook();
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;
	}

}

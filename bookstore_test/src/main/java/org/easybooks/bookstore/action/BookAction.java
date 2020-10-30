package org.easybooks.bookstore.action;

import java.util.*;
import org.easybooks.bookstore.service.ICatalogService;
import org.easybooks.bookstore.service.IBookService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.easybooks.bookstore.util.Pager;
public class BookAction extends ActionSupport {
	protected ICatalogService catalogService;//用于调用Service层的方法
	protected IBookService bookService;//用于调用Service层的方法
	protected Integer catalogid;	//接收用户选中的图书类别对应的id
	private Integer currentPage=1;//从页面中获取值
	private String bookname;//接收页面上用户输入的图书名称
	
	
	public String browseCatalog() throws Exception{
		List catalogs=catalogService.getAllCatalogs();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("catalogs", catalogs);
		return SUCCESS;	
	}
	public String browseBook() throws Exception{
		List books=bookService.getBookbyCatalogid(catalogid);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;	
	}
	//分页显示图书
	public String browseBookPaging() throws Exception{
		int totalSize=bookService.getTotalbyCatalog(catalogid);
		Pager pager=new Pager(currentPage,totalSize);
		//获取分页显示的记录
		List books=bookService.getBookbyCatalogidPaging(catalogid, currentPage, pager.getPageSize());
		//将图书记录保存在request中
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("books", books);
		request.put("pager", pager);
		Map session=ActionContext.getContext().getSession();
		session.put("catalogid", catalogid);
		return SUCCESS;	
	}
	public String searchBook()throws Exception{
		StringBuffer hql=new StringBuffer("from Book b ");
		if(bookname!=null&&bookname.length()!=0)
			hql.append("where b.bookname like '%"+bookname+"%'");
		List books=bookService.getRequiredBookbyHql(hql.toString());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;
	}
	public String browseNewBook() throws Exception{
		List books=bookService.getNewBook();
		Map request=(Map)ActionContext.getContext().get("request");
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

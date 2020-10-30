package org.easybooks.bookstore.util;

public class Pager{
	private int currentPage;//当前页面
	private int pageSize=3;//每页显示的记录数，初值为3
	private int totalSize;//总的记录数
	private int totalPage;//总页数 totalSize=totalSize
	
	private boolean hasFirst;//是否有首页
	private boolean hasPrevious;//是否有上一页
	private boolean hasNext;//是否有下一页
	private boolean hasLast;//是否有最后一页
	public Pager(int currentPage, int totalSize){
		this.currentPage=currentPage;
		this.totalSize=totalSize;
	}
	
	public int getCurrentPage(){
		return currentPage;
	}
	public void setCurrentPage(int currentPage){
		this.currentPage=currentPage;
	}
	public int getPageSize(){
		return pageSize;
	}
	public void setPageSize(int pageSize){
		this.pageSize=pageSize;
	}
	public int getTotalSize(){
		return totalSize;
	}
	public void setTotalSize(int totalSize){
		this.totalSize = totalSize;
	}
	public int getTotalPage() {
		totalPage=totalSize/pageSize;
		if(totalSize%pageSize!=0)
			totalPage++;
		return totalPage;
	}
	public void setTotalPage(int totalPage){
		this.totalPage = totalPage;
	}
	public boolean isHasFirst(){
		if(currentPage==1){
			return false;
		}
		return true;
	}
	public void setHasFirst(boolean hasFirst){
		this.hasFirst=hasFirst;
	}
	public boolean isHasPrevious(){
		if(isHasFirst())
			return true;
		else
			return false;
	}
	public void setHasPrevious(boolean hasPrevious){
		this.hasPrevious=hasPrevious;
	}
	public boolean isHasNext(){
		if(isHasLast())
			return true;
		else
			return false;
	}
	public void setHasNext(boolean hasNext){
		this.hasNext = hasNext;
	}
	public boolean isHasLast(){
		if(currentPage==getTotalPage())
			return false;
		else
			return true;
	}
	public void setHasLast(boolean hasLast){
		this.hasLast = hasLast;
	}
	
}

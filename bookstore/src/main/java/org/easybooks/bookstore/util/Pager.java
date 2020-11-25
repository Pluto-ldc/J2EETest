package org.easybooks.bookstore.util;

public class Pager {

	/**
	 * 当前页码
	 */
	private int currentPage;

	/**
	 * 每页条数
	 */
	private int pageSize = 3;

	/**
	 * 目标总条数
	 */
	private int totalSize;

	/**
	 * 目标总页数
	 */
	private int totalPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	/**
	 * 获取目标总页数
	 * 
	 * @return
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * 设置目标总页数
	 * 
	 * @return
	 */
	public void setTotalPage() {
		// 目标页面页码等于总条数除以每页条数
		totalPage = totalSize / pageSize;
		// 若有余数则还需添加一页
		if (totalSize % pageSize != 0) {
			totalPage++;
		}
	}

	public Pager(int currentPage, int totalSize) {
		this.currentPage = currentPage;
		this.totalSize = totalSize;
		this.setTotalPage();
	}

	/**
	 * 在此之前是否还有数据
	 * 
	 * @return
	 */
	public Boolean isHasFirst() {
		return currentPage != 1 && totalPage != 0;
	}

	/**
	 * 在此之后是否还有数据
	 * 
	 * @return
	 */
	public Boolean isHasLast() {
		return currentPage != totalPage && totalPage != 0;
	}

	public Boolean isHasPrevious() {
		return this.isHasFirst();
	}

	public Boolean isHasNext() {
		return this.isHasLast();
	}
}

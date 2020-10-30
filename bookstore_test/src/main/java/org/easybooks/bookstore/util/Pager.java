package org.easybooks.bookstore.util;

public class Pager {
	private int currentPage;
	private int pageSize = 3;
	private int totalSize;
	private int totalPage;

	public Pager(int currentPage, int totalSize) {
		this.currentPage = currentPage;
		this.totalSize = totalSize;
	}

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

	public int getTotalPage() {
		totalPage = totalSize / pageSize;
		if (totalSize % pageSize != 0)
			totalPage++;
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public boolean isHasFirst() {
		if (currentPage == 1) {
			return false;
		}
		return true;
	}

	public boolean isHasPrevious() {
		if (isHasFirst())
			return true;
		else
			return false;
	}

	public boolean isHasNext() {
		if (isHasLast())
			return true;
		else
			return false;
	}

	public boolean isHasLast() {
		if (currentPage == getTotalPage())
			return false;
		else
			return true;
	}

}

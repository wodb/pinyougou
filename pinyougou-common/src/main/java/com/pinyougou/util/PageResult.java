package com.pinyougou.util;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	private String status;
	
	private List rows;
	
	private Long total;
	
	private int page;

	public PageResult(String message, String status, List rows, Long total, int page) {
		this.message = message;
		this.status = status;
		this.rows = rows;
		this.total = total;
		this.page = page;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "PageResult [message=" + message + ", status=" + status + ", rows=" + rows + ", total=" + total
				+ ", page=" + page + "]";
	}	

}

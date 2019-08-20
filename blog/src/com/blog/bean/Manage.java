package com.blog.bean;

public class Manage {
	private int pageSize;//页面条数数据条数
	private int currentPage;//当前页数	
	private int pageCount;//总页数
	private int countSize;//总数据条数
	
	private Text text;
	
	public Manage(){
		
	}
	public Manage(int pageSize, int currentPage, int pageCount, Text text,int countSize) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.pageCount = pageCount;
		this.text = text;
		this.countSize = countSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public Text getText() {
		return text;
	}
	public void setText(Text text) {
		this.text = text;
	}
	public int getCountSize() {
		return countSize;
	}
	public void setCountSize(int countSize) {
		this.countSize = countSize;
	}
}

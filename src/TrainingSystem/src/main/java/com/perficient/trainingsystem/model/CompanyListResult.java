package com.perficient.trainingsystem.model;

import java.util.List;

public class CompanyListResult {
	private Integer totalPage;
	private Integer nowPage;
	private Integer items;
	private List<Company> data;
	
	
	public CompanyListResult(Integer totalPage, Integer nowPage, List<Company> data) {
		super();
		this.nowPage = nowPage;
		this.totalPage = totalPage;
		this.data = data;
	}

	
	
	public CompanyListResult(Integer totalPage, Integer nowPage, Integer items, List<Company> data) {
		super();
		this.totalPage = totalPage;
		this.nowPage = nowPage;
		this.items = items;
		this.data = data;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public List<Company> getData() {
		return data;
	}

	public Integer getNowPage() {
		return nowPage;
	}

	public Integer getItems() {
		return items;
	}

}
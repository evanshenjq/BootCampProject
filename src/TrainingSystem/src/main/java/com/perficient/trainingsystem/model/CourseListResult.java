package com.perficient.trainingsystem.model;

import java.util.List;

public class CourseListResult {
	private Integer totalPage;
	private Integer nowPage;
	private Integer items;
	private List<Course> data;

	public CourseListResult(Integer totalPage, Integer nowPage, List<Course> data) {
		super();
		this.nowPage = nowPage;
		this.totalPage = totalPage;
		this.data = data;
	}

	public CourseListResult(Integer totalPage, Integer nowPage, Integer items, List<Course> data) {
		super();
		this.totalPage = totalPage;
		this.nowPage = nowPage;
		this.items = items;
		this.data = data;
	}
	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getNowPage() {
		return nowPage;
	}

	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}

	public Integer getItems() {
		return items;
	}

	public void setItems(Integer items) {
		this.items = items;
	}

	public List<Course> getData() {
		return data;
	}

	public void setData(List<Course> data) {
		this.data = data;
	}
}

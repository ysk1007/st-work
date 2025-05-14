package com.example.mbboard.dto;

import lombok.Data;

@Data
public class Page {
	
	private int rowPerPage;
	private int currentPage;
	
	private int beginRow;
	private int totalCount;
	
	private String searchWord;
	
	public Page(int rowPerPage, int currentPage, int totalCount, String searchWord) {
		this.rowPerPage = rowPerPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.searchWord = searchWord;
		
		this.beginRow = (this.currentPage - 1) * this.rowPerPage;
	}
	
	public int getLastPage() {
		int lastPage = 0;
		lastPage = this.totalCount / this.rowPerPage;
		if(this.totalCount % this.rowPerPage != 0) {
			lastPage++;
		}
		
		return lastPage;
	}
}

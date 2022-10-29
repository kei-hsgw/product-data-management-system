package com.example.pagenation;

public class Pagenation {

	/** 現在のページ */
	private int currentPage = 1;
	/** 1ページあたりの表示件数 */
	private int perPage = 30;
	/** 総ページ数 */
	private int totalPage;
	/** 総表示件数 */
	private int totalDisplrays;

	public Pagenation() {
	}

	public Pagenation(int currentPage, int perPage, int totalPage, int totalDisplrays) {
		this.currentPage = currentPage;
		this.perPage = perPage;
		this.totalPage = totalPage;
		this.totalDisplrays = totalDisplrays;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	// 総ページ数：総表示件数を1ページあたりの表示件数で割る
	public void setTotalPage(int perPage, int totalDisplays) {
		this.totalPage = totalDisplays / perPage;
		
		if (totalDisplays % perPage != 0) {
			this.totalPage++;
		}
	}

	public int getTotalDisplrays() {
		return totalDisplrays;
	}

	public void setTotalDisplrays(int totalDisplrays) {
		this.totalDisplrays = totalDisplrays;
	}

	@Override
	public String toString() {
		return "Pagenation [currentPage=" + currentPage + ", perPage=" + perPage + ", totalPage=" + totalPage
				+ ", totalDisplrays=" + totalDisplrays + "]";
	}

}

package com.example.entity;

public class Category {

	/** ID */
	private int id;
	/** 親ID */
	private int parentId;
	/** カテゴリ名 */
	private String categoryName;
	/** 全名前 */
	private String nameAll;

	public Category() {
	}

	public Category(int id, int parentId, String categoryName, String nameAll) {
		this.id = id;
		this.parentId = parentId;
		this.categoryName = categoryName;
		this.nameAll = nameAll;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getNameAll() {
		return nameAll;
	}

	public void setNameAll(String nameAll) {
		this.nameAll = nameAll;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", parentId=" + parentId + ", categoryName=" + categoryName + ", nameAll="
				+ nameAll + "]";
	}

}

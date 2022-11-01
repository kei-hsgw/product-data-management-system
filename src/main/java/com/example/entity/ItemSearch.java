package com.example.entity;

public class ItemSearch {

	/** 商品名 */
	private String name;
	/** 親カテゴリ */
	private String parentCategory;
	/** 子カテゴリ */
	private String childCategory;
	/** 孫カテゴリ */
	private String grandChild;
	/** ブランド */
	private String brand;

	public ItemSearch() {
	}

	public ItemSearch(String name, String parentCategory, String childCategory, String grandChild, String brand) {
		this.name = name;
		this.parentCategory = parentCategory;
		this.childCategory = childCategory;
		this.grandChild = grandChild;
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getChildCategory() {
		return childCategory;
	}

	public void setChildCategory(String childCategory) {
		this.childCategory = childCategory;
	}

	public String getGrandChild() {
		return grandChild;
	}

	public void setGrandChild(String grandChild) {
		this.grandChild = grandChild;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "ItemSearch [name=" + name + ", parentCategory=" + parentCategory + ", childCategory=" + childCategory
				+ ", grandChild=" + grandChild + ", brand=" + brand + "]";
	}

}

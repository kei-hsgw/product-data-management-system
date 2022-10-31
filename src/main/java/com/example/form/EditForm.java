package com.example.form;

public class EditForm {

	/** ID */
	private Integer id;
	/** 商品名 */
	private String name;
	/** 価格 */
	private String price;
	/** 親カテゴリ */
	private String parentCategory;
	/** 子カテゴリ */
	private String childCategory;
	/** 孫カテゴリ */
	private String grandChild;
	/** ブランド */
	private String brand;
	/** 状態 */
	private Integer condition;
	/** 商品説明 */
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public Integer getCondition() {
		return condition;
	}

	public void setCondition(Integer condition) {
		this.condition = condition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "EditForm [id=" + id + ", name=" + name + ", price=" + price + ", parentCategory=" + parentCategory
				+ ", childCategory=" + childCategory + ", grandChild=" + grandChild + ", brand=" + brand
				+ ", condition=" + condition + ", description=" + description + "]";
	}

}

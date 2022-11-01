package com.example.entity;

public class Item {

	/** ID */
	private int id;
	/** 商品名 */
	private String name;
	/** 状態 */
	private int condition;
	/** カテゴリ */
	private Category category;
	/** ブランド */
	private String brand;
	/** 価格 */
	private double price;
	/** 運送 */
	private int shipping;
	/** 商品説明 */
	private String description;

	public Item() {
	}

	public Item(int id, String name, int condition, Category category, String brand, double price, int shipping,
			String description) {
		this.id = id;
		this.name = name;
		this.condition = condition;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.shipping = shipping;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getShipping() {
		return shipping;
	}

	public void setShipping(int shipping) {
		this.shipping = shipping;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", condition=" + condition + ", category=" + category + ", brand="
				+ brand + ", price=" + price + ", shipping=" + shipping + ", description=" + description + "]";
	}

}

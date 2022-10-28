package com.example.entity;

public class Original {

	/** ID */
	private int trainId;
	/** 商品名 */
	private String name;
	/** 状態 */
	private int itemConditionId;
	/** カテゴリ名 */
	private String categoryName;
	/** ブランド名 */
	private String brandName;
	/** 価格 */
	private double price;
	/** 運送 */
	private int shipping;
	/** 商品説明 */
	private String itemDescription;

	public Original() {
	}

	public Original(int trainId, String name, int itemConditionId, String categoryName, String brandName, double price,
			int shipping, String itemDescription) {
		this.trainId = trainId;
		this.name = name;
		this.itemConditionId = itemConditionId;
		this.categoryName = categoryName;
		this.brandName = brandName;
		this.price = price;
		this.shipping = shipping;
		this.itemDescription = itemDescription;
	}

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getItemConditionId() {
		return itemConditionId;
	}

	public void setItemConditionId(int itemConditionId) {
		this.itemConditionId = itemConditionId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@Override
	public String toString() {
		return "Original [trainId=" + trainId + ", name=" + name + ", itemConditionId=" + itemConditionId
				+ ", categoryName=" + categoryName + ", brandName=" + brandName + ", price=" + price + ", shipping="
				+ shipping + ", itemDescription=" + itemDescription + "]";
	}
}

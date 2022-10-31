package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Category;

@Mapper
public interface CategoryMapper {

	/**
	 * DB登録
	 * @param category
	 */
	public void insert(List<Category> category);
	
	/**
	 * カテゴリ名から親カテゴリのIDを取得
	 * @param categoryName
	 * @return
	 */
	public int findByParentCategoryId(String categoryName);
	
	/**
	 * カテゴリ名から子カテゴリの親IDを取得
	 * @param parentId
	 * @param categoryName
	 * @return
	 */
	public int findByChildCategoryOfParentId(int parentId, String categoryName);
	
	/**
	 * parentCategory取得
	 * @return
	 */
	public List<String> findParentCategory();
	
	/**
	 * parentCategoryからchildCategory取得
	 * @param parentCategory
	 * @return
	 */
	public List<String> findChildCategoryByParentCategory(String parentCategory);
	
	/**
	 * childCategoryからgrandChild取得
	 * @param childCategory
	 * @return
	 */
	public List<String> findGrandChildByChildCategory(String childCategory);
}

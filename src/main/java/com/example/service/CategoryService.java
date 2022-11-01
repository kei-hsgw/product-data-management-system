package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.repository.CategoryMapper;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	/**
	 * parentCategory取得　
	 * @return
	 */
	public List<String> getParentCategory() {
		List<String> parentCategoryList = categoryMapper.findParentCategory();
		parentCategoryList.add(0, "");
		return parentCategoryList;
	}
	
	/**
	 * parentCategoryでchildCategory取得
	 * @param parentCategory
	 * @return
	 */
	public List<String> getChildCategoryByParentCategory(String parentCategory) {
		List<String> childCategoryList = categoryMapper.findChildCategoryByParentCategory(parentCategory);
		childCategoryList.add(0, "");
		return childCategoryList;
	}
	
	/**
	 * childCategoryでgrandChild取得
	 * @param childCategory
	 * @return
	 */
	public List<String> getGrandChildByChildCategory(String childCategory) {
		List<String> grandChildList = categoryMapper.findGrandChildByChildCategory(childCategory);
		grandChildList.add(0, "");
		return grandChildList;
	}
	
	/**
	 * childCategory取得
	 * @return
	 */
	public List<String> getChildCategory() {
		List<String> childCategoryList = categoryMapper.findChildCategory();
		childCategoryList.add(0, "");
		return childCategoryList;
	}
	
	/**
	 * grandChild取得
	 * @return
	 */
	public List<String> getGrandChild() {
		List<String> grandChildList = categoryMapper.findGrandChild();
		grandChildList.add(0, "");
		return grandChildList;
	}
}

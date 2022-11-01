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
		return categoryMapper.findParentCategory();
	}
	
	/**
	 * parentCategoryでchildCategory取得
	 * @param parentCategory
	 * @return
	 */
	public List<String> getChildCategoryByParentCategory(String parentCategory) {
		return categoryMapper.findChildCategoryByParentCategory(parentCategory);
	}
	
	/**
	 * childCategoryでgrandChild取得
	 * @param childCategory
	 * @return
	 */
	public List<String> getGrandChildByChildCategory(String childCategory) {
		return categoryMapper.findGrandChildByChildCategory(childCategory);
	}
	
	/**
	 * childCategory取得
	 * @return
	 */
	public List<String> getChildCategory() {
		return categoryMapper.findChildCategory();
	}
	
	/**
	 * grandChild取得
	 * @return
	 */
	public List<String> getGrandChild() {
		return categoryMapper.findGrandChild();
	}
}

package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OriginalMapper {
	
	/**
	 * カテゴリ全件検索
	 * @return
	 */
	public List<String> findAllCategory();
}

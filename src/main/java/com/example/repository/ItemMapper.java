package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Item;
import com.example.pagenation.Pagenation;

@Mapper
public interface ItemMapper {

	/**
	 * item全件取得
	 * @param pagenation
	 * @return
	 */
	public List<Item> findAll(Pagenation pagenation);
}

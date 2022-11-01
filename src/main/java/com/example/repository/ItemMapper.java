package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Item;
import com.example.entity.ItemSearch;
import com.example.pagenation.Pagenation;

@Mapper
public interface ItemMapper {

	/**
	 * item全件取得
	 * @param pagenation
	 * @return
	 */
	public List<Item> findAll(Pagenation pagenation);
	
	/**
	 * idでitemの詳細情報を取得
	 * @param id
	 * @return
	 */
	public Item findById(int id);
	
	/**
	 * item検索
	 * @param itemSearch
	 * @param pagenation
	 * @return
	 */
	public List<Item> search(ItemSearch itemSearch, Pagenation pagenation);
	
	/**
	 * 総レコード数取得
	 * @param itemSearch
	 * @return
	 */
	public int countItems(ItemSearch itemSearch);
}

package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Item;
import com.example.entity.ItemSearch;
import com.example.pagenation.Pagenation;
import com.example.repository.ItemMapper;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	/**
	 * item全件取得
	 * @param pagenation
	 * @return
	 */
	public List<Item> getShowList(Pagenation pagenation) {
		return itemMapper.findAll(pagenation);
	}
	
	/**
	 * idでitemの詳細情報を取得
	 * @param id
	 * @return
	 */
	public Item getShowDetail(int id) {
		return itemMapper.findById(id);
	}
	
	/**
	 * item検索
	 * @param itemSearch
	 * @param pagenation
	 * @return
	 */
	public List<Item> getSearchList(ItemSearch itemSearch, Pagenation pagenation) {
		return itemMapper.search(itemSearch, pagenation);
	}
	
	/**
	 * ページング処理
	 * @param itemSearch
	 * @param pagenation
	 * @return
	 */
	public Pagenation paging(ItemSearch itemSearch, Pagenation pagenation) {
		pagenation.setTotalDisplrays(itemMapper.countItems(itemSearch));
		pagenation.setTotalPage(pagenation.getPerPage(), pagenation.getTotalDisplrays());
		return pagenation;
	}
	
	/**
	 * item追加登録
	 * @param item
	 */
	public void insert(Item item) {
		itemMapper.insert(item);
	}
}

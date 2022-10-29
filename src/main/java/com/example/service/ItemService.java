package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Item;
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
	public Item getDetail(int id) {
		return itemMapper.findById(id);
	}
}

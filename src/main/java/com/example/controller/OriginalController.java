package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.OriginalService;

@Controller
@RequestMapping("/createTable")
public class OriginalController {

	@Autowired
	private OriginalService originalService;
	
	/**
	 * parentCategory登録
	 */
	@RequestMapping("/parentCategoryInsert")
	public void parentCategoryInsert() {
		originalService.parentCategoryInsert();
	}
	
	/**
	 * childCategory登録
	 */
	@RequestMapping("/childCategoryInsert")
	public void childCategoryInsert() {
		originalService.childCategoryInsert();
	}
	/**
	 * grandChild登録
	 */
	@RequestMapping("/grandChildInsert")
	public void grandChildInsert() {
		originalService.grandChildInsert();
	}
}

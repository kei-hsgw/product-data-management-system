package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Item;
import com.example.pagenation.Pagenation;
import com.example.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	// ページングの処理
	@ModelAttribute
	public Pagenation setUpPagenation() {
		return new Pagenation();
	}
	
	@RequestMapping("/showList")
	public String showList(Pagenation pagenation, Model model) {
		List<Item> itemList = itemService.getShowList(pagenation);
		model.addAttribute("itemList", itemList);
		return "list";
	}
	
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Item item = itemService.getDetail(Integer.parseInt(id));
		model.addAttribute("item", item);
		return "detail";
	}
}

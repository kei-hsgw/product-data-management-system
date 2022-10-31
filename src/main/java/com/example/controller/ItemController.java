package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Item;
import com.example.form.EditForm;
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
	
	@ModelAttribute
	public EditForm setUpEditForm() {
		return new EditForm();
	}
	
	/**
	 * トップページ表示
	 * @param pagenation
	 * @param model
	 * @return
	 */
	@RequestMapping("/showList")
	public String showList(Pagenation pagenation, Model model) {
		List<Item> itemList = itemService.getShowList(pagenation);
		System.out.println(itemList);
		model.addAttribute("itemList", itemList);
		return "list";
	}
	
	/**
	 * 詳細ページ表示
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Item item = itemService.getShowDetail(Integer.parseInt(id));
		model.addAttribute("item", item);
		return "detail";
	}
	
	/**
	 * 編集ページ表示
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(String id, Model model) {
		Item item = itemService.getShowDetail(Integer.parseInt(id));
		model.addAttribute("item", item);
		return "edit";
	}
}

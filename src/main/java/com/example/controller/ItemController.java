package com.example.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Item;
import com.example.entity.ItemSearch;
import com.example.form.AddForm;
import com.example.form.EditForm;
import com.example.form.SearchForm;
import com.example.pagenation.Pagenation;
import com.example.service.CategoryService;
import com.example.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CategoryService categoryService;
	
	// ページングの処理
	@ModelAttribute
	public Pagenation setUpPagenation() {
		return new Pagenation();
	}
	
	// parentCategoryプルダウン
	@ModelAttribute(name = "parentCategoryList")
	public List<String> getParebtCategory() {
		return categoryService.getParentCategory();
	}
	
	// childCategoryプルダウン
	@ModelAttribute(name = "childCategoryList")
	public List<String> getChildCategory() {
		return categoryService.getChildCategory();
	}
	
	// grandChildプルダウン
	@ModelAttribute(name = "grandChildList")
	public List<String> getGrandChild() {
		return categoryService.getGrandChild();
	}
	
	@ModelAttribute
	public EditForm setUpEditForm() {
		return new EditForm();
	}
	
	@ModelAttribute
	public AddForm setUpAddForm() {
		return new AddForm();
	}
	
	/**
	 * 一覧画面表示
	 * @param searchForm
	 * @param pagenation
	 * @param model
	 * @return
	 */
	@RequestMapping("/showList")
	public String showList(SearchForm searchForm, Pagenation pagenation, Model model) {
		ItemSearch itemSearch = new ItemSearch();
		BeanUtils.copyProperties(searchForm, itemSearch);
		
		List<Item> itemList = itemService.getSearchList(itemSearch, pagenation);
		model.addAttribute("itemList", itemList);
		pagenation = itemService.paging(itemSearch, pagenation);
		model.addAttribute("pagenation", pagenation);
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
	
	/**
	 * 追加登録ページ表示
	 * @return
	 */
	@RequestMapping("/add")
	public String add() {
		return "add";
	}
}

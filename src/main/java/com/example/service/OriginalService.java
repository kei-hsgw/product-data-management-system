package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Category;
import com.example.repository.CategoryMapper;
import com.example.repository.OriginalMapper;

@Service
@Transactional
public class OriginalService {

	@Autowired
	private OriginalMapper originalMapper;

	@Autowired
	private CategoryMapper categoryMapper;

	/**
	 * 大カテゴリ登録
	 */
	public void parentCategoryInsert() {

		// DB格納用リスト
		List<Category> parentCategories = new ArrayList<>();

		// オリジナルデータのカテゴリ全件検索
		List<String> categoryList = originalMapper.findAllCategory();
		// 重複を排除したcategoryリスト
		List<String> distinctCategoryList = categoryList.stream().distinct().collect(Collectors.toList());

		// parentカテゴリ全リストを格納
		List<String> parentList = new ArrayList<>();

		for (int i = 0; i < distinctCategoryList.size(); i++) {
			String[] categories = distinctCategoryList.get(i).split("/");
			parentList.add(categories[0]);
		}
		// parentListの重複を排除
		List<String> distinctParentList = parentList.stream().distinct().collect(Collectors.toList());

		for (String parent : distinctParentList) {
			Category parentCategory = new Category();
			parentCategory.setCategoryName(parent);
			parentCategories.add(parentCategory);
		}
		categoryMapper.insert(parentCategories);
	}

	/**
	 * 中カテゴリ登録
	 */
	public void childCategoryInsert() {

		// DB格納用リスト
		List<Category> childCategories = new ArrayList<>();

		// オリジナルデータのカテゴリ全件検索
		List<String> categorylList = originalMapper.findAllCategory();
		// 重複を排除したcategoryリスト
		List<String> distinctCategoryList = categorylList.stream().distinct().collect(Collectors.toList());

		// ①Kids
		List<String> kidsList = distinctCategoryList.stream().filter(f -> f.startsWith("Kids")).collect(Collectors.toList());

		// 格納リスト
		List<String> childKidsList = new ArrayList<>();
		// kidsListから中カテゴリを取得しchildKidsListに格納
		for (int i = 0; i < kidsList.size(); i++) {
			String[] kids = kidsList.get(i).split("/");
			childKidsList.add(kids[1]);
		}
		// 重複データ排除
		List<String> distinctChildKidsList = childKidsList.stream().distinct().collect(Collectors.toList());
		// DB登録準備
		for (String child : distinctChildKidsList) {
			Category childCategory = new Category();
			childCategory.setParentId(categoryMapper.findByParentCategoryId("Kids"));
			childCategory.setCategoryName(child);
			childCategories.add(childCategory);
		}

		// ②Women
		List<String> womenList = distinctCategoryList.stream().filter(f -> f.startsWith("Women")).collect(Collectors.toList());

		// 格納リスト
		List<String> childWomenList = new ArrayList<>();
		// womenListから中カテゴリを取得しchildWomenListに格納
		for (int i = 0; i < womenList.size(); i++) {
			String[] womens = womenList.get(i).split("/");
			childWomenList.add(womens[1]);
		}
		// 重複データ排除
		List<String> distinctChildWomenList = childWomenList.stream().distinct().collect(Collectors.toList());
		// DB登録準備
		for (String child : distinctChildWomenList) {
			Category childCategory = new Category();
			childCategory.setParentId(categoryMapper.findByParentCategoryId("Women"));
			childCategory.setCategoryName(child);
			childCategories.add(childCategory);
		}

		// ③Vintage & Collectibles
		List<String> vintageList = distinctCategoryList.stream().filter(f -> f.startsWith("Vintage")).collect(Collectors.toList());

		// 格納リスト
		List<String> childVintageList = new ArrayList<>();
		// vintageListから中カテゴリを取得しchildVintageListに格納
		for (int i = 0; i < vintageList.size(); i++) {
			String[] vintages = vintageList.get(i).split("/");
			childVintageList.add(vintages[1]);
		}
		// 重複データ排除
		List<String> distinctChildVintageList = childVintageList.stream().distinct().collect(Collectors.toList());
		// DB登録準備
		for (String child : distinctChildVintageList) {
			Category childCategory = new Category();
			childCategory.setParentId(categoryMapper.findByParentCategoryId("Vintage & Collectibles"));
			childCategory.setCategoryName(child);
			childCategories.add(childCategory);
		}

		// ④Sports & Outdoors
		List<String> sportsList = distinctCategoryList.stream().filter(f -> f.startsWith("Sports")).collect(Collectors.toList());

		// 格納リスト
		List<String> childSportsList = new ArrayList<>();
		// sportsListから中カテゴリを取得しchildSportsListに格納
		for (int i = 0; i < sportsList.size(); i++) {
			String[] sports = sportsList.get(i).split("/");
			childSportsList.add(sports[1]);
		}
		// 重複データ排除
		List<String> distinctChildSportsList = childSportsList.stream().distinct().collect(Collectors.toList());
		// DB登録準備
		for (String child : distinctChildSportsList) {
			Category childCategory = new Category();
			childCategory.setParentId(categoryMapper.findByParentCategoryId("Sports & Outdoors"));
			childCategory.setCategoryName(child);
			childCategories.add(childCategory);
		}

		// ⑤Beauty
		List<String> beautyList = distinctCategoryList.stream().filter(f -> f.startsWith("Beauty")).collect(Collectors.toList());

		// 格納リスト
		List<String> childBeautyList = new ArrayList<>();
		// beautyListから中カテゴリを取得しchildBeautyListに格納
		for (int i = 0; i < beautyList.size(); i++) {
			String[] beauties = beautyList.get(i).split("/");
			childBeautyList.add(beauties[1]);
		}
		// 重複データ排除
		List<String> distinctChildBeautyList = childBeautyList.stream().distinct().collect(Collectors.toList());
		// DB登録準備
		for (String child : distinctChildBeautyList) {
			Category childCategory = new Category();
			childCategory.setParentId(categoryMapper.findByParentCategoryId("Beauty"));
			childCategory.setCategoryName(child);
			childCategories.add(childCategory);
		}

		// ⑥Other
		List<String> otherList = distinctCategoryList.stream().filter(f -> f.startsWith("Other")).collect(Collectors.toList());

		// 格納リスト
		List<String> childOtherList = new ArrayList<>();
		// otherListから中カテゴリを取得しchildOtherListに格納
		for (int i = 0; i < otherList.size(); i++) {
			String[] others = otherList.get(i).split("/");
			childOtherList.add(others[1]);
		}
		// 重複データ排除
		List<String> distinctChildOtherList = childOtherList.stream().distinct().collect(Collectors.toList());
		// DB登録準備
		for (String child : distinctChildOtherList) {
			Category childCategory = new Category();
			childCategory.setParentId(categoryMapper.findByParentCategoryId("Other"));
			childCategory.setCategoryName(child);
			childCategories.add(childCategory);
		}

		// ⑦Electronics
		List<String> electronicsList = distinctCategoryList.stream().filter(f -> f.startsWith("Electronics")).collect(Collectors.toList());

		// 格納リスト
		List<String> childElectronicsList = new ArrayList<>();
		// electronicsListから中カテゴリを取得しchildElectronicsListに格納
		for (int i = 0; i < electronicsList.size(); i++) {
			String[] electronics = electronicsList.get(i).split("/");
			childElectronicsList.add(electronics[1]);
		}
		// 重複データ排除
		List<String> distinctChildElectronicsList = childElectronicsList.stream().distinct().collect(Collectors.toList());
		// DB登録準備
		for (String child : distinctChildElectronicsList) {
			Category childCategory = new Category();
			childCategory.setParentId(categoryMapper.findByParentCategoryId("Electronics"));
			childCategory.setCategoryName(child);
			childCategories.add(childCategory);
		}

		// ⑧Men
		List<String> menList = distinctCategoryList.stream().filter(f -> f.startsWith("Men")).collect(Collectors.toList());

		// 格納リスト
		List<String> childMenList = new ArrayList<>();
		// menListから中カテゴリを取得しchildMenListに格納
		for (int i = 0; i < menList.size(); i++) {
			String[] mens = menList.get(i).split("/");
			childMenList.add(mens[1]);
		}
		// 重複データ排除
		List<String> distinctChildMenList = childMenList.stream().distinct().collect(Collectors.toList());
		// DB登録準備
		for (String child : distinctChildMenList) {
			Category childCategory = new Category();
			childCategory.setParentId(categoryMapper.findByParentCategoryId("Men"));
			childCategory.setCategoryName(child);
			childCategories.add(childCategory);
		}

		// ⑨Home
		List<String> homeList = distinctCategoryList.stream().filter(f -> f.startsWith("Home")).collect(Collectors.toList());

		// 格納リスト
		List<String> childHomeList = new ArrayList<>();
		// homeListから中カテゴリを取得しchildHomeListに格納
		for (int i = 0; i < homeList.size(); i++) {
			String[] homes = homeList.get(i).split("/");
			childHomeList.add(homes[1]);
		}
		// 重複データ排除
		List<String> distinctChildHomeList = childHomeList.stream().distinct().collect(Collectors.toList());
		// DB登録準備
		for (String child : distinctChildHomeList) {
			Category childCategory = new Category();
			childCategory.setParentId(categoryMapper.findByParentCategoryId("Home"));
			childCategory.setCategoryName(child);
			childCategories.add(childCategory);
		}

		// ⑩Handmade
		List<String> handmadeList = distinctCategoryList.stream().filter(f -> f.startsWith("Handmade")).collect(Collectors.toList());

		// 格納リスト
		List<String> childHandmadeList = new ArrayList<>();
		// handmadeListから中カテゴリを取得しchildHandmadeListに格納
		for (int i = 0; i < handmadeList.size(); i++) {
			String[] handmades = handmadeList.get(i).split("/");
			childHandmadeList.add(handmades[1]);
		}
		// 重複データ排除
		List<String> distinctChildHandmadeList = childHandmadeList.stream().distinct().collect(Collectors.toList());
		// DB登録準備
		for (String child : distinctChildHandmadeList) {
			Category childCategory = new Category();
			childCategory.setParentId(categoryMapper.findByParentCategoryId("Handmade"));
			childCategory.setCategoryName(child);
			childCategories.add(childCategory);
		}

		// DB登録
		categoryMapper.insert(childCategories);
	}

	/**
	 * 小カテゴリ登録
	 */
	public void grandChildInsert() {

		// オリジナルデータのカテゴリ全件検索
		List<String> categoryList = originalMapper.findAllCategory();
		// 重複を排除したcategoryリストを作成
		List<String> distinctCategoryList = categoryList.stream().distinct().collect(Collectors.toList());

		// ①
		List<String> kidsList = distinctCategoryList.stream().filter(f -> f.startsWith("Kids")).collect(Collectors.toList());
		// 格納リスト
		List<Category> grandKidsList = new ArrayList<>();

		for (int i = 0; i < kidsList.size(); i++) {
			String[] kids = kidsList.get(i).split("/");
			Category grandCategory = new Category();
			grandCategory.setParentId(categoryMapper.findByChildCategoryOfParentId(1, kids[1]));
			grandCategory.setCategoryName(kids[2]);
			grandCategory.setNameAll(kidsList.get(i));
			grandKidsList.add(grandCategory);
		}
		// smallカテゴリの重複を排除
		List<Category> distinctGrandKidsList = grandKidsList.stream().distinct().collect(Collectors.toList());
		categoryMapper.insert(distinctGrandKidsList);

		// ②
		List<String> womenList = distinctCategoryList.stream().filter(f -> f.startsWith("Women")).collect(Collectors.toList());
		// 格納リスト
		List<Category> grandWomenList = new ArrayList<>();

		for (int i = 0; i < womenList.size(); i++) {
			String[] womens = womenList.get(i).split("/");
			Category grandCategory = new Category();
			grandCategory.setParentId(categoryMapper.findByChildCategoryOfParentId(2, womens[1]));
			grandCategory.setCategoryName(womens[2]);
			grandCategory.setNameAll(womenList.get(i));
			grandWomenList.add(grandCategory);
		}
		// smallカテゴリの重複を排除
		List<Category> distinctGrandWomenList = grandWomenList.stream().distinct().collect(Collectors.toList());
		categoryMapper.insert(distinctGrandWomenList);

		// ③
		List<String> vintagesList = distinctCategoryList.stream().filter(f -> f.startsWith("Vintage")).collect(Collectors.toList());
		// smallカテゴリ全リスト格納
		List<Category> grandVintagesList = new ArrayList<>();

		for (int i = 0; i < vintagesList.size(); i++) {
			String[] vintages = vintagesList.get(i).split("/");
			Category grandCategory = new Category();
			grandCategory.setParentId(categoryMapper.findByChildCategoryOfParentId(3, vintages[1]));
			grandCategory.setCategoryName(vintages[2]);
			grandCategory.setNameAll(vintagesList.get(i));
			grandVintagesList.add(grandCategory);
		}
		// smallカテゴリの重複を排除
		List<Category> distinctGrandVintagesList = grandVintagesList.stream().distinct().collect(Collectors.toList());
		categoryMapper.insert(distinctGrandVintagesList);

		// ④
		List<String> sportsList = distinctCategoryList.stream().filter(f -> f.startsWith("Sports")).collect(Collectors.toList());
		// smallカテゴリ全リスト格納
		List<Category> grandSportsList = new ArrayList<>();

		for (int i = 0; i < sportsList.size(); i++) {
			String[] sports = sportsList.get(i).split("/");
			Category grandCategory = new Category();
			grandCategory.setParentId(categoryMapper.findByChildCategoryOfParentId(4, sports[1]));
			grandCategory.setCategoryName(sports[2]);
			grandCategory.setNameAll(sportsList.get(i));
			grandSportsList.add(grandCategory);
		}
		// smallカテゴリの重複を排除
		List<Category> distinctGrandSportsList =grandSportsList.stream().distinct().collect(Collectors.toList());
		categoryMapper.insert(distinctGrandSportsList);

		// ⑤
		List<String> beautiesList = distinctCategoryList.stream().filter(f -> f.startsWith("Beauty")).collect(Collectors.toList());
		// smallカテゴリ全リスト格納
		List<Category> grandBeautiesList = new ArrayList<>();

		for (int i = 0; i < beautiesList.size(); i++) {
			String[] beauties = beautiesList.get(i).split("/");
			Category grandCategory = new Category();
			grandCategory.setParentId(categoryMapper.findByChildCategoryOfParentId(5, beauties[1]));
			grandCategory.setCategoryName(beauties[2]);
			grandCategory.setNameAll(beautiesList.get(i));
		    grandBeautiesList.add(grandCategory);
		}
		// smallカテゴリの重複を排除
		List<Category> distinctGrandBeautiesList = grandBeautiesList.stream().distinct().collect(Collectors.toList());
		categoryMapper.insert(distinctGrandBeautiesList);

		// ⑥
		List<String> othersList = distinctCategoryList.stream().filter(f -> f.startsWith("Other")).collect(Collectors.toList());
		// smallカテゴリ全リスト格納
		List<Category> grandOthersList = new ArrayList<>();

		for (int i = 0; i < othersList.size(); i++) {
			String[] others = othersList.get(i).split("/");
			Category grandCategory = new Category();
			grandCategory.setParentId(categoryMapper.findByChildCategoryOfParentId(6, others[1]));
			grandCategory.setCategoryName(others[2]);
			grandCategory.setNameAll(othersList.get(i));
			grandOthersList.add(grandCategory);
		}
		// smallカテゴリの重複を排除
		List<Category> distinctGrandOthersList = grandOthersList.stream().distinct().collect(Collectors.toList());
		categoryMapper.insert(distinctGrandOthersList);

		// ⑦
		List<String> electronicsList = distinctCategoryList.stream().filter(f -> f.startsWith("Electronics")).collect(Collectors.toList());
		// smallカテゴリ全リスト格納
		List<Category> grandElectronicsList = new ArrayList<>();

		for (int i = 0; i < electronicsList.size(); i++) {
			String[] Electronics = electronicsList.get(i).split("/");
			Category grandCategory = new Category();
			grandCategory.setParentId(categoryMapper.findByChildCategoryOfParentId(7, Electronics[1]));
			grandCategory.setCategoryName(Electronics[2]);
			grandCategory.setNameAll(electronicsList.get(i));
			grandElectronicsList.add(grandCategory);
		}
		// smallカテゴリの重複を排除
		List<Category> distinctGrandElectronicsList = grandElectronicsList.stream().distinct()
				.collect(Collectors.toList());
		categoryMapper.insert(distinctGrandElectronicsList);

		// ⑧
		List<String> menList = distinctCategoryList.stream().filter(f -> f.startsWith("Men")).collect(Collectors.toList());
		// smallカテゴリ全リスト格納
		List<Category> grandMenList = new ArrayList<>();

		for (int i = 0; i < menList.size(); i++) {
			String[] mens = menList.get(i).split("/");
			Category grandCategory = new Category();
			grandCategory.setParentId(categoryMapper.findByChildCategoryOfParentId(8, mens[1]));
			grandCategory.setCategoryName(mens[2]);
			grandCategory.setNameAll(menList.get(i));
			grandMenList.add(grandCategory);
		}
		// smallカテゴリの重複を排除
		List<Category> distinctGrandMenList = grandMenList.stream().distinct().collect(Collectors.toList());
		categoryMapper.insert(distinctGrandMenList);

		// ⑨
		List<String> homeList = distinctCategoryList.stream().filter(f -> f.startsWith("Home")).collect(Collectors.toList());
		// smallカテゴリ全リスト格納
		List<Category> grandHomeList = new ArrayList<>();

		for (int i = 0; i < homeList.size(); i++) {
			String[] homes = homeList.get(i).split("/");
			Category grandCategory = new Category();
			grandCategory.setParentId(categoryMapper.findByChildCategoryOfParentId(9, homes[1]));
			grandCategory.setCategoryName(homes[2]);
			grandCategory.setNameAll(homeList.get(i));
			grandHomeList.add(grandCategory);
		}
		// smallカテゴリの重複を排除
		List<Category> distinctGrandHomeList = grandHomeList.stream().distinct().collect(Collectors.toList());
		categoryMapper.insert(distinctGrandHomeList);

		// ⑩
		List<String> handmadeList = distinctCategoryList.stream().filter(f -> f.startsWith("Handmade")).collect(Collectors.toList());
		// smallカテゴリ全リスト格納
		List<Category> grandHandmadeList = new ArrayList<>();

		for (int i = 0; i < handmadeList.size(); i++) {
			String[] handmades = handmadeList.get(i).split("/");
			Category grandCategory = new Category();
			grandCategory.setParentId(categoryMapper.findByChildCategoryOfParentId(10, handmades[1]));
			grandCategory.setCategoryName(handmades[2]);
			grandCategory.setNameAll(handmadeList.get(i));
			grandHandmadeList.add(grandCategory);
		}
		// smallカテゴリの重複を排除
		List<Category> distinctGrandHandmadeList =grandHandmadeList.stream().distinct().collect(Collectors.toList());
		categoryMapper.insert(distinctGrandHandmadeList);
	}
}

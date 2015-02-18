package com.softfz.service;

import java.util.List;

import com.softfz.model.MenuInfo;

public interface IMenuService {

	//加载所有菜单
	List<MenuInfo> loadAllMenu();

	List<MenuInfo> loadMenusByRoleid(int rid);

	void save(MenuInfo menu);

	MenuInfo loadMenuById(Integer mid);

	void update(MenuInfo menu);

	void delete(MenuInfo menu);

}

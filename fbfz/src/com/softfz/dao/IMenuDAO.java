package com.softfz.dao;

import java.util.List;

import com.softfz.model.MenuInfo;

public interface IMenuDAO {

	List<MenuInfo> loadAllMenu();

	List<MenuInfo> loadMenusByRoleid(int rid);

	void deleteMenuByRoleId(int roleid);

	boolean isExit(String menuname);

	void save(MenuInfo menu);

	MenuInfo loadMenuById(Integer mid);

	void update(MenuInfo menu);

	void deleteChildren(int menuid);

	void delete(int menuid);

	void deleteMenuRoleRelation(int menuid);

}

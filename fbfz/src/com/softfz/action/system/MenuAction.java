package com.softfz.action.system;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.softfz.action.common.BaseAction;
import com.softfz.model.MenuInfo;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.IMenuService;
import com.softfz.service.factory.ServiceFactory;

public class MenuAction extends BaseAction implements ModelDriven<MenuInfo> {

	private MenuInfo menu = new MenuInfo();
	private Integer mid;
	private IMenuService menuService;
	List<MenuInfo> menus;

	public MenuAction() {
		menuService = ServiceFactory.getInstance().getMenuService();
	}

	// 获取所有菜单
	public String query() {
		menus = menuService.loadAllMenu();
		return SUCCESS;
	}

	// 跳转至修改页面
	public String jumptoUpdate() throws IllegalAccessException,
			InvocationTargetException {
		// System.out.println(mid);
		MenuInfo tmp = menuService.loadMenuById(mid);
		BeanUtils.copyProperties(menu, tmp);
		return "jumptoUpdate";
	}

	// 修改管理员
	public String updateMenu() {
		try {
			menuService.update(menu);
			message.success("修改菜单成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}

	// 跳转至新增菜单
	public String jumptoMenu() {
		menus = menuService.loadAllMenu();
		// 获取第一级菜单
		for (int i = menus.size() - 1; i >= 0; i--) {
			if (menus.get(i).getFatherid() != null) {
				menus.remove(i);
			}
		}
		return "jump";
	}

	// 删除菜单
	public String delete() {
		try {
			menu.setMenuid(mid);
			menuService.delete(menu);
			message.success("删除菜单成功！！！", false, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}

	// 新增菜单
	public String addMenu() {
		try {
			// System.out.println(menu.getFatherid());
			if (menu.getFatherid() == 0) {
				menu.setFatherid(null);
			}
			menuService.save(menu);

			message.success("新增菜单成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}

	@Override
	public MenuInfo getModel() {
		// TODO Auto-generated method stub
		return menu;
	}

	public List<MenuInfo> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuInfo> menus) {
		this.menus = menus;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

}

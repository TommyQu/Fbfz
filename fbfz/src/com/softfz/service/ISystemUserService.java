package com.softfz.service;

import java.util.List;

import com.softfz.model.MenuInfo;
import com.softfz.model.PageModel;
import com.softfz.model.SystemUser;

public interface ISystemUserService {
	/**
	 * 查询系统管理员
	 * @param systemUser 查询条件：目前只支持账号和状态查询
	 * @param currentPage 当前页
	 * @param pageSize 每页显示条数
	 * @return 分页数据模型
	 */
	PageModel querySystemUser(SystemUser systemUser, int currentPage,
			int pageSize);
	/**
	 * 判断用户名和密码是否合法，如果合法则返回当前登录的用户，必须包含用户所拥有的角色编号
	 * @param loginname 用户名
	 * @param password 密码
	 * @return 用户对象
	 */
	SystemUser login(String loginname, String password);
	/**
	 * 根据用户编号获取该用户所拥有的菜单
	 * @param userid 用户编号
	 * @return 菜单集合
	 */
	List<MenuInfo> getUserMenus(int userid);
	//保存管理员
	void save(SystemUser systemUser);
	//载入管理员
	SystemUser loadById(int uid);
	//新增管理员
	void update(SystemUser systemUser);
	//冻结管理员
	void userlocked(int uid);
	//解冻管理员
	void userunlocked(int uid);

}

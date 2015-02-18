package com.softfz.dao;

import java.util.List;

import com.softfz.model.MenuInfo;
import com.softfz.model.PageModel;
import com.softfz.model.SystemUser;

public interface ISystemUserDAO {
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
	 * 根据登录名查询用户对象，如果不存在则返回null
	 * @param loginname 登录名
	 * @return 用户对象
	 */
	SystemUser getSystemUserByLoginName(String loginname);
	/**
	 * 获取用户所拥有的角色编号
	 * @param userid 用户编号
	 * @return 角色编号集合
	 */
	List<Integer> getUserRoleids(int userid);
	/**
	 * 根据用户编号获取该用户所拥有的菜单
	 * @param userid 用户编号
	 * @return 菜单集合
	 */
	List<MenuInfo> getUserMenus(int userid);
	//判断管理员是否已经存在
	boolean isExit(SystemUser systemUser);
	//保存管理员
	int save(SystemUser systemUser);
	//保存用户角色关系
	void saveUserRoleRelation(int userid, List<Integer> userroles);
	//根据id载入管理员
	SystemUser loadById(int uid);
	//更新管理员
	void update(SystemUser systemUser);
	void userlocked(int uid);
	void userunlocked(int uid);

}

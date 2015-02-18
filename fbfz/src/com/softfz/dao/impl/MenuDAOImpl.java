package com.softfz.dao.impl;

import java.util.List;

import com.softfz.dao.IMenuDAO;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.model.MenuInfo;

public class MenuDAOImpl implements IMenuDAO {

	@Override
	public List<MenuInfo> loadAllMenu() {
		// TODO Auto-generated method stub
		String sql = "select * from menu";
		return JdbcUtils.getJdbcOperator().queryForJavaBeanList(sql,
				MenuInfo.class, null);
	}

	@Override
	public List<MenuInfo> loadMenusByRoleid(int rid) {
		String sql = "select distinct m.* from menu m join rolemenu rm on m.menuid"
				+ "=rm.menuid join role r on r.roleid=rm.roleid"
				+ " where r.roleid=? order by fatherid,orderno";
		// TODO Auto-generated method stub
		// String sql="select from menu where ";
		return JdbcUtils.getJdbcOperator().queryForJavaBeanList(sql,
				MenuInfo.class, rid);
	}

	@Override
	public void deleteMenuByRoleId(int roleid) {
		// TODO Auto-generated method stub
		String qsql = "select menuid from rolemenu where roleid=?";
		List<Integer> menus = JdbcUtils.getJdbcOperator().queryForList(qsql,
				Integer.class, roleid);
		String sql = "delete from menu where menuid=?";
		for (Integer menuid : menus) {
			// System.out.println(menuid);
			// JdbcUtils.getJdbcOperator().update(sql, menuid);
		}
	}

	@Override
	public boolean isExit(String menuname) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from menu t where menuname=?";
		int count = JdbcUtils.getJdbcOperator().queryForInt(sql,
				menuname.trim());
		return count > 0;
	}

	@Override
	public void save(MenuInfo menu) {
		// TODO Auto-generated method stub
		String idsql = "select req_menu.nextval from dual";
		int menuid = JdbcUtils.getJdbcOperator().queryForInt(idsql);
		String sql = "insert into menu(menuid,fatherid,menuname,menuuri,orderno)"
				+ " values(?,?,?,?,?)";
		JdbcUtils.getJdbcOperator().update(sql, menuid, menu.getFatherid(),
				menu.getMenuname(), menu.getMenuuri(), menu.getOrderno());

	}

	@Override
	public MenuInfo loadMenuById(Integer mid) {
		// TODO Auto-generated method stub
		String sql = "select * from menu where menuid=?";
		return (MenuInfo) JdbcUtils.getJdbcOperator().queryForJavaBean(sql,
				MenuInfo.class, mid);
	}

	@Override
	public void update(MenuInfo menu) {
		// TODO Auto-generated method stub
		String sql = "update menu set menuname=?,menuuri=?,orderno=? where menuid=?";
		JdbcUtils.getJdbcOperator().update(sql, menu.getMenuname(),
				menu.getMenuuri(), menu.getOrderno(), menu.getMenuid());
	}

	@Override
	public void deleteChildren(int menuid) {
		// TODO Auto-generated method stub
		String sql="delete from menu where fatherid=?";
		JdbcUtils.getJdbcOperator().update(sql, menuid);
	}

	@Override
	public void delete(int menuid) {
		// TODO Auto-generated method stub
		String sql="delete from menu where menuid=?";
		JdbcUtils.getJdbcOperator().update(sql, menuid);
	}

	@Override
	public void deleteMenuRoleRelation(int menuid) {
		// TODO Auto-generated method stub
		String sql="delete from rolemenu where menuid=?";
		JdbcUtils.getJdbcOperator().update(sql, menuid);
	}

}

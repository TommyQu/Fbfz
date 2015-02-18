package com.softfz.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.softfz.dao.IResourcesDAO;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.model.MenuInfo;
import com.softfz.model.PageModel;
import com.softfz.model.Resources;
import com.softfz.model.SystemUser;

public class ResourcesDAOImpl implements IResourcesDAO {

	public boolean isExit(Resources resources) {
		String sql = "select count(*) from resources t where resourcename=?";
		int count = JdbcUtils.getJdbcOperator().queryForInt(sql,
				resources.getResourcename().trim());
		return count > 0;
	}

	public void save(Resources resources) {
		String sql = "insert into resources(resourceid,resourcename,resdescription,resuri)"
				+ "values(REQ_RESOURCES.nextval,?,?,?)";
		JdbcUtils.getJdbcOperator().update(sql, resources.getResourcename(),
				resources.getResdescription(), resources.getResuri());
	}

	@Override
	public List<String> getAllResources() {
		String sql = "select resuri from resources ";
		return JdbcUtils.getJdbcOperator().queryForList(sql, String.class);
	}

	@Override
	public List<Map<String, String>> getRoleResourcesRelation() {
		String sql = "select t.roleid,r.resuri from roleresource t join resources r"
				+ " on t.resourceid=r.resourceid";
		return JdbcUtils.getJdbcOperator().queryForList(sql);
	}

	@Override
	public List<Resources> loadAllResources() {
		// TODO Auto-generated method stub
		String sql = "select * from resources";
		return JdbcUtils.getJdbcOperator().queryForJavaBeanList(sql,
				Resources.class, null);
	}

	@Override
	public List<Resources> loadResourcesById(int rid) {
		// TODO Auto-generated method stub
		String sql = "select distinct m.* from resources m join roleresource rm on m.resourceid"
				+ "=rm.resourceid join role r on r.roleid=rm.roleid"
				+ " where r.roleid=?";
		// TODO Auto-generated method stub
		// String sql="select from menu where ";
		return JdbcUtils.getJdbcOperator().queryForJavaBeanList(sql,
				Resources.class, rid);
	}

	@Override
	public PageModel queryResources(Resources resources, int currentPage,
			int pageSize) {
		// TODO Auto-generated method stub
		StringBuilder querySql = new StringBuilder("select * from resources ");
		StringBuilder countSql = new StringBuilder(
				"select count(*) from resources ");
		StringBuilder whereSql = new StringBuilder("");
		List paramList = new ArrayList();
		String logic = " where";
		if (resources != null) {
			if (resources.getResourcename() != null
					&& !resources.getResourcename().trim().equals("")) {
				whereSql.append(logic).append(" resourcename like ?");
				paramList.add("%" + resources.getResourcename() + "%");
				logic = " and";
			}
		}

		return JdbcUtils.getJdbcOperator().queryPagModel(querySql, countSql,
				whereSql, null, paramList, currentPage, pageSize,
				Resources.class);
	}

	@Override
	public boolean isExit(String resourcename) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from resources where resourcename=?";
		int count = JdbcUtils.getJdbcOperator().queryForInt(sql,
				resourcename.trim());
		return count > 0;
	}

	@Override
	public Resources loadResources(Integer rid) {
		// TODO Auto-generated method stub
		String sql = "select * from resources where resourceid=?";
		return (Resources) JdbcUtils.getJdbcOperator().queryForJavaBean(sql,
				Resources.class, rid);
	}

	@Override
	public void update(Resources resources) {
		// TODO Auto-generated method stub
		String sql = "update resources set resourcename=?,resuri=?,resdescription=? where resourceid=?";
		JdbcUtils.getJdbcOperator().update(sql, resources.getResourcename(),
				resources.getResuri(), resources.getResdescription(),resources.getResourceid());
	}

	@Override
	public void delete(int resourceid) {
		// TODO Auto-generated method stub
		String sql="delete from RESOURCES where resourceid=?";
		JdbcUtils.getJdbcOperator().update(sql, resourceid);
		
	}

	@Override
	public void deleteResourcesRoleRelation(int resourceid) {
		// TODO Auto-generated method stub
		String sql="delete from roleresource where resourceid=?";
		JdbcUtils.getJdbcOperator().update(sql, resourceid);
	}

}

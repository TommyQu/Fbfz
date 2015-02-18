package com.softfz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.softfz.dao.IRoleDAO;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.model.PageModel;
import com.softfz.model.Role;
import com.softfz.model.SystemUser;

public class RoleDAOImpl implements IRoleDAO {

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		String sql="select * from role";
		return JdbcUtils.getJdbcOperator().queryForJavaBeanList(sql, Role.class,null);
	}

	@Override
	public PageModel queryRole(Role role, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		StringBuilder querySql = new StringBuilder("select * from role ");
		StringBuilder countSql = new StringBuilder(
				"select count(*) from role ");
		StringBuilder whereSql = new StringBuilder("");
		List paramList = new ArrayList();
		String logic = " where";
		if (role != null) {
			if (role.getRolename() != null
					&& !role.getRolename().trim().equals("")) {
				whereSql.append(logic).append(" rolename like ?");
				paramList.add("%" + role.getRolename() + "%");
				logic = " and";
			}
		}
		return JdbcUtils.getJdbcOperator().queryPagModel(querySql, countSql,
				whereSql, null, paramList, currentPage, pageSize,
				Role.class);
	}

	@Override
	public boolean isExit(Role role) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from role where rolename=?";
		int count = JdbcUtils.getJdbcOperator().queryForInt(sql,
				role.getRolename().trim());
		return count > 0;
	}

	@Override
	public int save(Role role) {
		// TODO Auto-generated method stub
		String idsql = "select seq_role.nextval from dual";
		int roleid = JdbcUtils.getJdbcOperator().queryForInt(idsql);
		System.out.println(roleid);
		String sql = "insert into role(roleid,rolename,roledesr)"
				+ " values(?,?,?)";
		JdbcUtils.getJdbcOperator().update(sql, roleid,
				role.getRolename(), role.getRoledesr());
		return roleid;
	}

	@Override
	public void saveRoleMenuRelation(int roleid, Integer menuid) {
		// TODO Auto-generated method stub
		String sql="insert into rolemenu(roleid,menuid) values(?,?)";
		JdbcUtils.getJdbcOperator().update(sql, roleid,menuid);
		
	}

	@Override
	public void saveRoleResourceRelation(int roleid, Integer resourceid) {
		// TODO Auto-generated method stub
		String sql="insert into roleresource(roleid,resourceid) values(?,?)";
		JdbcUtils.getJdbcOperator().update(sql, roleid,resourceid);
	}

	@Override
	public Role loadById(int rid) {
		// TODO Auto-generated method stub
		String sql = "select * from role where roleid=?";
		return (Role) JdbcUtils.getJdbcOperator().queryForJavaBean(sql,
				Role.class, rid);
	}

	public void deleteRoleMenuRelation(Integer roleid) {
		// TODO Auto-generated method stub
		String sql="delete from rolemenu where roleid=?";
		JdbcUtils.getJdbcOperator().update(sql, roleid);
	}

	@Override
	public void deleteRoleResourceRelation(Integer roleid) {
		// TODO Auto-generated method stub
		String sql="delete from roleresource where roleid=?";
		JdbcUtils.getJdbcOperator().update(sql, roleid);
		
	}

	@Override
	public boolean isTaken(Role role) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from userrole where roleid=?";
		int count = JdbcUtils.getJdbcOperator().queryForInt(sql,
				role.getRoleid());
		return count > 0;

	}

	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		String sql="delete from role where roleid=?";
		JdbcUtils.getJdbcOperator().update(sql, role.getRoleid());
	}


}

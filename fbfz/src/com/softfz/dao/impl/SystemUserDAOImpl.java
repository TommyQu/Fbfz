package com.softfz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.softfz.dao.ISystemUserDAO;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.model.MenuInfo;
import com.softfz.model.PageModel;
import com.softfz.model.SystemUser;

public class SystemUserDAOImpl implements ISystemUserDAO {

	public PageModel querySystemUser(SystemUser systemUser, int currentPage,
			int pageSize) {
		StringBuilder querySql = new StringBuilder("select * from systemuser ");
		StringBuilder countSql = new StringBuilder(
				"select count(*) from systemuser ");
		StringBuilder whereSql = new StringBuilder("");
		List paramList = new ArrayList();
		String logic = " where";
		if (systemUser != null) {
			if (systemUser.getState() > 0) {
				whereSql.append(logic).append(" state=?");
				paramList.add(systemUser.getState());
				logic = " and";
			}
			if (systemUser.getLoginname() != null
					&& !systemUser.getLoginname().trim().equals("")) {
				whereSql.append(logic).append(" loginname like ?");
				paramList.add("%" + systemUser.getLoginname() + "%");
				logic = " and";
			}
		}

		return JdbcUtils.getJdbcOperator().queryPagModel(querySql, countSql,
				whereSql, null, paramList, currentPage, pageSize,
				SystemUser.class);
	}

	@Override
	public SystemUser getSystemUserByLoginName(String loginname) {
		String sql = "select * from systemuser where loginname=? ";
		return (SystemUser) JdbcUtils.getJdbcOperator().queryForJavaBean(sql,
				SystemUser.class, loginname);
	}

	@Override
	public List<Integer> getUserRoleids(int userid) {
		String sql = "select roleid from userrole where userid=?";
		return JdbcUtils.getJdbcOperator().queryForList(sql, Integer.class,
				userid);
	}

	@Override
	public List<MenuInfo> getUserMenus(int userid) {
		String sql = "select distinct m.* from menu m join rolemenu rm on m.menuid"
				+ "=rm.menuid join userrole ur on rm.roleid=ur.roleid"
				+ " where ur.userid=? order by fatherid,orderno";
		return JdbcUtils.getJdbcOperator().queryForJavaBeanList(sql,
				MenuInfo.class, userid);
	}

	// 判断管理员是否已经存在
	@Override
	public boolean isExit(SystemUser systemUser) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from systemuser t where loginname=?";
		int count = JdbcUtils.getJdbcOperator().queryForInt(sql,
				systemUser.getLoginname().trim());
		return count > 0;
	}

	@Override
	public int save(SystemUser systemUser) {
		// TODO Auto-generated method stub
		String idsql = "select seq_systemuser.nextval from dual";
		int userid = JdbcUtils.getJdbcOperator().queryForInt(idsql);
		// int userid=1;
		java.sql.Date sqlDate = new java.sql.Date(
				new java.util.Date().getTime());
		// System.out.println(sqlDate);
		String sql = "insert into systemuser(userid,loginname,username,password,opentime,usersex,idcard,email,mobileno,address,state)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?)";
		JdbcUtils.getJdbcOperator().update(sql, userid,
				systemUser.getLoginname(), systemUser.getUsername(),
				systemUser.getPassword(), sqlDate, systemUser.getUsersex(),
				systemUser.getIdcard(), systemUser.getEmail(),
				systemUser.getMobileno(), systemUser.getAddress(),
				systemUser.getState());
		return userid;

	}

	@Override
	public void saveUserRoleRelation(int userid, List<Integer> userroles) {
		// TODO Auto-generated method stub
		String sql = "insert into userrole(roleid,userid) " + "values(?,?)";
		String delsql="delete from userrole where userid=?";
		JdbcUtils.getJdbcOperator().update(delsql, userid);
		int count=0;
		for (Integer i : userroles) {
			String tmp = "select * from userrole where roleid=? and userid=?";
			count = JdbcUtils.getJdbcOperator().queryForInt(tmp, i, userid);
			if (count == 0) {
				JdbcUtils.getJdbcOperator().update(sql, i, userid);
			}
		}
	}

	@Override
	public SystemUser loadById(int uid) {
		// TODO Auto-generated method stub
		String sql = "select * from systemuser where userid=?";
		return (SystemUser) JdbcUtils.getJdbcOperator().queryForJavaBean(sql,
				SystemUser.class, uid);
	}

	// 更新管理员
	@Override
	public void update(SystemUser systemUser) {
		// TODO Auto-generated method stub
		String sql = "update systemuser set username=?,usersex=?,idcard=?,email=?,mobileno=?,address=? where userid=?";
		JdbcUtils.getJdbcOperator().update(sql, systemUser.getUsername(),
				systemUser.getUsersex(), systemUser.getIdcard(),
				systemUser.getEmail(), systemUser.getMobileno(),
				systemUser.getAddress(), systemUser.getUserid());
	}

	@Override
	public void userlocked(int uid) {
		// TODO Auto-generated method stub
		String sql="update systemuser set state=? where userid=?";
		JdbcUtils.getJdbcOperator().update(sql, 2,uid);
		
	}

	@Override
	public void userunlocked(int uid) {
		// TODO Auto-generated method stub
		String sql="update systemuser set state=? where userid=?";
		JdbcUtils.getJdbcOperator().update(sql, 1,uid);
	}
	

}

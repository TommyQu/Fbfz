package com.softfz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.softfz.dao.IUserMemberDAO;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.model.PageModel;
import com.softfz.model.SystemUser;
import com.softfz.model.UserMember;

public class UserMemberDAOImpl implements IUserMemberDAO {

	@Override
	public UserMember getUserMemberByUserName(String username) {
		String sql = "select * from usermember where username=?";
		return (UserMember) JdbcUtils.getJdbcOperator().queryForJavaBean(sql,
				UserMember.class, username);
	}
	
	public UserMember getUserMemberByUserId(int userid) {
		String sql = "select * from usermember where userid=?";
		return (UserMember) JdbcUtils.getJdbcOperator().queryForJavaBean(sql,
				UserMember.class, userid);
	}
	@Override
	public void saveUserMember(UserMember member) {
		String sql = "insert into usermember(userid,username,password,usersex,email,qq"
				+ ",mobileno)values(SEQ_USERMEMBER.Nextval,?,?,?,?,?,?)";
		JdbcUtils.getJdbcOperator().update(sql, member.getUsername(),
				member.getPassword(), member.getUsersex(), member.getEmail(),
				member.getQq(), member.getMobileno());
	}

	@Override
	public PageModel queryUserMember(UserMember userMember, int currentPage,
			int pageSize) {
		StringBuilder querySql = new StringBuilder("select * from usermember ");
		StringBuilder countSql = new StringBuilder(
				"select count(*) from usermember ");
		StringBuilder whereSql = new StringBuilder("");
		List paramList = new ArrayList();
		String logic = " where";
		if (userMember != null) {
			if (userMember.getState() > 0) {
				whereSql.append(logic).append(" state=?");
				paramList.add(userMember.getState());
				logic = " and";
			}
			if (userMember.getUsername() != null
					&& !userMember.getUsername().trim().equals("")) {
				whereSql.append(logic).append(" username like ?");
				paramList.add("%" + userMember.getUsername() + "%");
				logic = " and";
			}
		}

		return JdbcUtils.getJdbcOperator().queryPagModel(querySql, countSql,
				whereSql, null, paramList, currentPage, pageSize,
				UserMember.class);
	}

	@Override
	public int updateUserMember(UserMember userMember) {
		// TODO Auto-generated method stub
		String updateSql = "update usermember set state=? where userid=?";
		return JdbcUtils.getJdbcOperator().update(updateSql, userMember.getState(),userMember.getUserid());
	}


}
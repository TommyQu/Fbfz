package com.softfz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.softfz.dao.IAppraiseDAO;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.model.Appraise;
import com.softfz.model.Area;
import com.softfz.model.Cooperation;
import com.softfz.model.PageModel;
import com.softfz.model.UserMember;
import com.softfz.utils.StrUtils;

public class AppraiseDAOImpl implements IAppraiseDAO {

	public PageModel queryAppraise(Appraise appraise, int currentPage,
			int pageSize) {
		StringBuilder querySql = new StringBuilder("select * from appraise ");
		StringBuilder countSql = new StringBuilder(
				"select count(*) from appraise ");
		StringBuilder whereSql = new StringBuilder("");
		List paramList = new ArrayList();
		String logic = " where";
		if (appraise != null) {
			if (appraise.getAppid() > 0) {
				whereSql.append(logic).append(" appid=?");
				paramList.add(appraise.getAppid());
				logic = " and";
			}
			if (appraise.getMembername() != null
					&& !appraise.getMembername().trim().equals("")) {
				whereSql.append(logic).append(" membername like ?");
				paramList.add("%" + appraise.getMembername() + "%");
				logic = " and";
			}
		}
		return JdbcUtils.getJdbcOperator().queryPagModel(querySql, countSql,
				whereSql, null, paramList, currentPage, pageSize,
				Appraise.class);
	}

	@Override
	public void delete(int appid) {
		String sql="delete from appraise where appid=?";
		JdbcUtils.getJdbcOperator().update(sql, appid);
		
	}
}
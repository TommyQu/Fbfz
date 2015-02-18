package com.softfz.dao.impl;

import java.util.List;

import com.softfz.dao.ICooperationTypeDAO;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.model.Area;
import com.softfz.model.CooperationType;

public class CooperationTypeDAOImpl implements ICooperationTypeDAO {

	@Override
	public List<CooperationType> getAllType() {
		String sql = "select * from cooperationtype order by fatherid,orderno";
		return JdbcUtils.getJdbcOperator().queryForJavaBeanList(sql, CooperationType.class);
	}

	@Override
	public List<CooperationType> getAllBigType() {
		String sql = "select * from cooperationtype where fatherid is null order by orderno";
		return JdbcUtils.getJdbcOperator().queryForJavaBeanList(sql,
				CooperationType.class);
	}

	@Override
	public List<CooperationType> getSmallTypeByFatherid(Integer bigtypeid) {
		String sql = "select * from cooperationtype where fatherid=? order by orderno";
		return JdbcUtils.getJdbcOperator().queryForJavaBeanList(sql,
				CooperationType.class, bigtypeid);
	}

	@Override
	public boolean isExit(CooperationType cooperationType) {
		String sql = "select count(*) from cooperationtype t where typename=?";
		int count = JdbcUtils.getJdbcOperator().queryForInt(sql,
				cooperationType.getTypename().trim());
		return count > 0;
	}

	@Override
	public void save(CooperationType cooperationType) {
		String idsql = "select seq_type.nextval from dual";
		int typeid = JdbcUtils.getJdbcOperator().queryForInt(idsql);
		// int userid=1;
		 //System.out.println(areaid);
		String sql = "insert into cooperationtype(typeid,fatherid,typename,orderno)"
				+ " values(?,?,?,?)";
		JdbcUtils.getJdbcOperator().update(sql, typeid,
				cooperationType.getFatherid(), cooperationType.getTypename(),cooperationType.getOrderno());

		
	}

	@Override
	public void delete(int typeid) {
		String sql="delete from cooperationtype where typeid=?";
		JdbcUtils.getJdbcOperator().update(sql, typeid);
		
	}

	@Override
	public CooperationType loadById(int typeid) {
		String sql = "select * from cooperationtype where typeid=?";
		return (CooperationType) JdbcUtils.getJdbcOperator().queryForJavaBean(sql,
				CooperationType.class, typeid);
	}

	@Override
	public int update(CooperationType cooperationType) {
		String updateSql = "update cooperationtype set typename=?,orderno=?,fatherid=? where typeid=?";
		return JdbcUtils.getJdbcOperator().update(updateSql, cooperationType.getTypename(),cooperationType.getOrderno(),cooperationType.getFatherid(),cooperationType.getTypeid());
		
	}

}

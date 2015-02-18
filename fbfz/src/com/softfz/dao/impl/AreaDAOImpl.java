package com.softfz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.softfz.dao.IAreaDAO;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.model.Area;
import com.softfz.model.PageModel;
import com.softfz.model.Role;
import com.softfz.model.SystemUser;
import com.softfz.model.UserMember;

public class AreaDAOImpl implements IAreaDAO{

	@Override
	public PageModel queryArea(Area area, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Area> queryArea() {
		String sql="select * from area order by fatherid,orderno";
		return JdbcUtils.getJdbcOperator().queryForJavaBeanList(sql, Area.class,null);
	}

	@Override
	public boolean isExit(Area area) {
		String sql = "select count(*) from area t where areaname=?";
		int count = JdbcUtils.getJdbcOperator().queryForInt(sql,
				area.getAreaname().trim());
		return count > 0;
	}

	@Override
	public void save(Area area) {
		String idsql = "select seq_area.nextval from dual";
		int areaid = JdbcUtils.getJdbcOperator().queryForInt(idsql);
		// int userid=1;
		 //System.out.println(areaid);
		String sql = "insert into area(areaid,fatherid,areaname,orderno)"
				+ " values(?,?,?,?)";
		JdbcUtils.getJdbcOperator().update(sql, areaid,
				area.getFatherid(), area.getAreaname(),area.getOrderno());

		
	}

	@Override
	public List<Area> getAllBig() {
		String sql="select * from area where fatherid is null";
		return JdbcUtils.getJdbcOperator().queryForJavaBeanList(sql, Area.class,null);
	}

	@Override
	public void delete(int areaid) {
		// TODO Auto-generated method stub
		String sql="delete from area where areaid=?";
		JdbcUtils.getJdbcOperator().update(sql, areaid);
		
	}

	@Override
	public Area loadById(int areaid) {
		String sql = "select * from area where areaid=?";
		return (Area) JdbcUtils.getJdbcOperator().queryForJavaBean(sql,
				Area.class, areaid);
	}

	@Override
	public int update(Area area) {
		// TODO Auto-generated method stub
		String updateSql = "update area set areaname=?,orderno=?,fatherid=? where areaid=?";
		return JdbcUtils.getJdbcOperator().update(updateSql, area.getAreaname(),area.getOrderno(),area.getFatherid(),area.getAreaid());
	}

	@Override
	public List<Area> getSmall(int bigareaid) {
		String sql="select * from area where fatherid=?";
		return JdbcUtils.getJdbcOperator().queryForJavaBeanList(sql, Area.class,bigareaid);
	}
	

}

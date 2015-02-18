package com.softfz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.softfz.dao.ICooperationDAO;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.model.AdShop;
import com.softfz.model.Area;
import com.softfz.model.Cooperation;
import com.softfz.model.PageModel;
import com.softfz.utils.StrUtils;

public class CooperationDAOImpl implements ICooperationDAO {

	public PageModel<Cooperation> queryCooperation(Cooperation cooperation,
			int currentPage, int pageSize) {
		StringBuilder querySql = new StringBuilder(
				"select t.*,a.areaname as areaname,ct.typename as typename from cooperation t "
						+ " left join area a on t.areaid=a.areaid"
						+ " left join cooperationtype ct on t.typeid=ct.typeid");
		StringBuilder countSql = new StringBuilder(
				"select count(*) from cooperation t "
						+ " left join area a on t.areaid=a.areaid"
						+ " left join cooperationtype ct on t.typeid=ct.typeid");
		StringBuilder whereSql = new StringBuilder();
		List paramList = new ArrayList();
		String logic = " where";
		if (cooperation != null) {
			
			if (StrUtils.isNotEmpty(cooperation.getShopname())) {
				whereSql.append(logic).append(" shopname like ?");
				paramList.add("%" + cooperation.getShopname() + "%");
				logic = " and";
			}
			if (cooperation.getBigareaid() != null
					&& cooperation.getBigareaid() > 0) {
				if (cooperation.getAreaid() != null
						&& cooperation.getAreaid() > 0) {
					whereSql.append(logic).append("  t.areaid=?");
					paramList.add(cooperation.getAreaid());
					logic = " and";
				} else {
					whereSql.append(logic).append("  a.fatherid=?");
					paramList.add(cooperation.getBigareaid());
					logic = " and";
				}
			}
			if (cooperation.getBigtypeid() != null
					&& cooperation.getBigtypeid() > 0) {
				if (cooperation.getTypeid() != null
						&& cooperation.getTypeid() > 0) {
					whereSql.append(logic).append("  t.typeid=?");
					paramList.add(cooperation.getTypeid());
					logic = " and";
				} else {
					whereSql.append(logic).append("  ct.fatherid=?");
					paramList.add(cooperation.getBigtypeid());
					logic = " and";
				}
			}
			if (cooperation.getViplevel() > 0) {
				whereSql.append(logic).append("  t.viplevel=?");
				paramList.add(cooperation.getViplevel());
				logic = " and";
			}
			if (cooperation.getState() > 0) {
				whereSql.append(logic).append("  t.state=?");
				paramList.add(cooperation.getState());
				logic = " and";
			}
		}
		return JdbcUtils.getJdbcOperator().queryPagModel(querySql, countSql,
				whereSql, null, paramList, currentPage, pageSize,
				Cooperation.class);
	}

	@Override
	public List<Cooperation> getTopVip() {
		String sql="select * from(select t.* from COOPERATION t order by viplevel desc,createtime desc) where rownum<=10";
		return JdbcUtils.getJdbcOperator().queryForJavaBeanList(sql, Cooperation.class);
	}

	@Override
	public List<Cooperation> getTopTypeShop() {
		String sql="select * from (select t.*,ct.fatherid as bigtypeid," +
				" row_number()over(partition by ct.fatherid order by t.viplevel desc,t.createtime) rn" +
				" from cooperation t join cooperationtype ct   on t.typeid = ct.typeid)" +
				" where rn <= 10";
		return JdbcUtils.getJdbcOperator().queryForJavaBeanList(sql, Cooperation.class);
	}

	@Override
	public List<Cooperation> getTopTatalShop() {
		String sql="select * from (select * from cooperation c order by  c.totalscore desc) where rownum<=8";
		return JdbcUtils.getJdbcOperator().queryForJavaBeanList(sql, Cooperation.class);
	}

	@Override
	public List<AdShop> getOneLevelAd() {
		String sql="select t.* from ADSHOP t where adlevel=1 order by orderno";
		return JdbcUtils.getJdbcOperator().queryForJavaBeanList(sql, AdShop.class);
	}

	@Override
	public void save(Cooperation cooperation) {
		String idsql = "select seq_cooperation.nextval from dual";
		int shopid = JdbcUtils.getJdbcOperator().queryForInt(idsql);
		// int userid=1;
		 //System.out.println(areaid);
		String sql = "insert into cooperation(shopid,areaid,typeid,shippic,shopname,viplevel,telephone" +
				"mobileno,address,description,longitude,latitude,createtime,viptime,keepnum,servicescore" +
				"envscore,transcore,featurescore,totalscore,comments)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		JdbcUtils.getJdbcOperator().update(sql,shopid,cooperation.getAreaid(),
				cooperation.getTypeid(),cooperation.getShoppic(),cooperation.getShopname(),cooperation.getViplevel(),
				cooperation.getTelphone(),cooperation.getMobileno(),cooperation.getAddress(),cooperation.getDescription(),
				cooperation.getLongitude(),cooperation.getLatitude(),cooperation.getCreatetime(),cooperation.getViptime(),
				cooperation.getKeepnum(),cooperation.getServicescore(),cooperation.getEnvscore(),cooperation.getTranscore(),
				cooperation.getFeaturescore(),cooperation.getTotalscore(),cooperation.getComments());
		
	}

	@Override
	public boolean isExit(Cooperation cooperation) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from cooperation t where shopname=?";
		int count = JdbcUtils.getJdbcOperator().queryForInt(sql,
				cooperation.getShopname().trim());
		return count > 0;
	}


}

package com.softfz.dao;

import java.util.List;

import com.softfz.model.CooperationType;

/**
 * 联盟商家类型数据接口
 * @author Administrator
 *
 */
public interface ICooperationTypeDAO {
	/**
	 * 
	 * @return
	 */
	List<CooperationType> getAllType();
	/**
	 * 
	 * @return
	 */
	List<CooperationType> getAllBigType();
	/**
	 * 查询某个大类别下的所有小类别，要求按照排序号正序排序
	 * @param bigtypeid 大类编号
	 * @return 类别集合
	 */
	List<CooperationType> getSmallTypeByFatherid(Integer bigtypeid);
	boolean isExit(CooperationType cooperationType);
	void save(CooperationType cooperationType);
	void delete(int typeid);
	CooperationType loadById(int typeid);
	int update(CooperationType cooperationType);

}

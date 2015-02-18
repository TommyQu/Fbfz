package com.softfz.service;

import java.util.List;

import com.softfz.model.CooperationType;

/**
 * 联盟商家类型业务接口
 * @author huihewu
 *
 */
public interface ICooperationTypeService {
	/**
	 * 获取所有的联盟商家类别列表
	 * @return 类别集合
	 */
	public List<CooperationType> getAllType();
	/**
	 * 获取所有的联盟商家大类别列表
	 * @return 所有的大类别集合
	 */
	public List<CooperationType> getAllBigType();
	/**
	 * 查询某个大类别下的所有小类别，要求按照排序号正序排序
	 * @param bigtypeid 大类编号
	 * @return 类别集合
	 */
	public List<CooperationType> getSmallTypeByFatherid(Integer bigtypeid);
	public void save(CooperationType cooperationType);
	public void delete(int typeid);
	public CooperationType loadById(int typeid);
	public void update(CooperationType cooperationType);
}

package com.softfz.dao;

import java.util.List;
import java.util.Map;

import com.softfz.model.PageModel;
import com.softfz.model.Resources;

public interface IResourcesDAO {
	/**
	 * 判断资源名称是否已经被使用，如果被使用返回true，否则返回false
	 * @param resources
	 * @return
	 */
	boolean isExit(Resources resources);
	/**
	 * 保存资源对象数据到资源信息表中
	 * @param resources
	 */
	void save(Resources resources);
	/**
	 * 获取所有受保护的资源
	 * @return
	 */
	List<String> getAllResources();
	
	List<Map<String, String>> getRoleResourcesRelation();
	List<Resources> loadAllResources();
	List<Resources> loadResourcesById(int rid);
	PageModel queryResources(Resources resources, int currentPage, int pageSize);
	boolean isExit(String resourcename);
	Resources loadResources(Integer rid);
	void update(Resources resources);
	void delete(int resourceid);
	void deleteResourcesRoleRelation(int resourceid);

}

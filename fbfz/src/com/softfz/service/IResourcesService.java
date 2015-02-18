package com.softfz.service;

import java.util.List;
import java.util.Map;

import com.softfz.model.PageModel;
import com.softfz.model.Resources;

public interface IResourcesService {
	
	public void saveResources(Resources resources);
	/**
	 * 获取所有受保护的资源
	 * @return
	 */
	public List<String> getAllResources();
	/**
	 * 获取所有的角色和资源的关系
	 * @return
	 */
	public Map<Integer,List<String>> getRoleResourcesRelation();
	//获取所有资源
	public List<Resources> loadAllResources();
	public List<Resources> loadResourcesById(int rid);
	public PageModel queryResources(Resources resources, int currentPage,
			int pageSize);
	public void save(Resources resources);
	public Resources loadResource(Integer rid);
	public void update(Resources resources);
	public void delete(Resources resources);
}

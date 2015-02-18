package com.softfz.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.softfz.dao.IResourcesDAO;
import com.softfz.dao.factory.DAOFactory;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.jdbc.TransactionManager;
import com.softfz.model.PageModel;
import com.softfz.model.Resources;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.IResourcesService;

public class ResourcesServiceImpl implements IResourcesService{
	private IResourcesDAO resourcesDAO;
	public ResourcesServiceImpl(){
		resourcesDAO = DAOFactory.getInstance().getResourcesDAO();
	}
	public void saveResources(Resources resources) {
		//判断资源名称是否已经被使用
		boolean isExit=resourcesDAO.isExit(resources);
		if(isExit){
			throw new FBfzServiceException("资源名称已经被使用");
		}
		resourcesDAO.save(resources);
	}
	@Override
	public List<String> getAllResources() {
		return resourcesDAO.getAllResources();
	}
	@Override
	public Map<Integer, List<String>> getRoleResourcesRelation() {
		List<Map<String,String>> rs = resourcesDAO.getRoleResourcesRelation();
		Map<Integer, List<String>> result = new HashMap<Integer, List<String>>();
		for (Map<String, String> map : rs) {
			Integer roleid = Integer.parseInt(map.get("roleid"));
			String uri = map.get("resuri");
			if(result.get(roleid)==null){
				List<String> resources = new ArrayList<String>();
				resources.add(uri);
				result.put(roleid, resources);
			}else{
				result.get(roleid).add(uri);
			}
		}
		return result;
	}
	@Override
	public List<Resources> loadAllResources() {
		// TODO Auto-generated method stub
		
		return resourcesDAO.loadAllResources();
	}
	//获取资源
	@Override
	public List<Resources> loadResourcesById(int rid) {
		// TODO Auto-generated method stub
		
		return resourcesDAO.loadResourcesById(rid);
	}
	@Override
	public PageModel queryResources(Resources resources, int currentPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return resourcesDAO.queryResources(resources,currentPage,pageSize);
	}
	@Override
	public void save(Resources resources) {
		// TODO Auto-generated method stub
		boolean isExit=resourcesDAO.isExit(resources.getResourcename());
		if(isExit){
			throw new FBfzServiceException("资源名已经被使用");
		}
		resourcesDAO.save(resources);
	}
	@Override
	public Resources loadResource(Integer rid) {
		return resourcesDAO.loadResources(rid);
	}
	@Override
	public void update(Resources resources) {
		// TODO Auto-generated method stub
		boolean isExit=resourcesDAO.isExit(resources.getResourcename());
		if(isExit){
			throw new FBfzServiceException("资源名已经被使用");
		}
		resourcesDAO.update(resources);
	}
	@Override
	public void delete(Resources resources) {
		// TODO Auto-generated method stub
		TransactionManager transactionManager=JdbcUtils.getTransactionManager();
		try{
			transactionManager.beginTransaction();
			//先删除主表，后删除子表
			resourcesDAO.deleteResourcesRoleRelation(resources.getResourceid());
			resourcesDAO.delete(resources.getResourceid());
			
			transactionManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			transactionManager.rollback();
		}finally{
			transactionManager.endTransaction();
		}
	}

}

package com.softfz.action.system;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.softfz.action.common.BaseAction;
import com.softfz.action.common.JUIMessageAction;
import com.softfz.model.Resources;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.IResourcesService;
import com.softfz.service.factory.ServiceFactory;

public class ResourcesAction extends BaseAction implements
		ModelDriven<Resources> {
	private Resources resources = new Resources();
	private Integer rid;
	private IResourcesService resourcesService;

	public ResourcesAction() {
		resourcesService = ServiceFactory.getInstance().getResourcesService();
	}
	//查询
	public String query() throws Exception {
		pageModel = resourcesService.queryResources(resources, currentPage,
				pageSize);
		return SUCCESS;
	}
	
	//删除
	public String delete(){
		try {
			resources.setResourceid(rid);
			resourcesService.delete(resources);
			message.success("删除资源成功！！！", false, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}

	//更新
	public String update(){
		try {
			resourcesService.update(resources);
			message.success("修改资源成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}
	//保存
	public String save() throws Exception {
		try {
			resourcesService.saveResources(resources);
			// 正常添加
			message.success("新增资源成功", true, "adminQuery");
		} catch (FBfzServiceException e) {
			// 有业务逻辑异常
			message.fail(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			// 系统异常
			message.systemfail();
		}
		return returnjson();
	}
	
	//跳转至新增页面
	public String jumptoadd(){
		return "jumptoadd";
	}
	
	//新增资源
	public String add(){
		try {
			// System.out.println(menu.getFatherid());
			resourcesService.save(resources);
			message.success("新增资源成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}
	//跳转至修改资源页面
	public String jumptoupdate() throws IllegalAccessException, InvocationTargetException{
		Resources tmp=resourcesService.loadResource(rid);
		BeanUtils.copyProperties(resources, tmp);
		return "jumptoupdate";
	}
	
	public Resources getModel() {
		return resources;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}

}

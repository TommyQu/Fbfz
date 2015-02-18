package com.softfz.action.system;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.softfz.action.common.BaseAction;
import com.softfz.model.Area;
import com.softfz.model.CooperationType;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.ICooperationService;
import com.softfz.service.ICooperationTypeService;
import com.softfz.service.factory.ServiceFactory;

public class TypeManagerAction extends BaseAction implements ModelDriven<CooperationType>{
	private CooperationType cooperationType=new CooperationType();
	private ICooperationTypeService cooperationTypeService;
	private List<CooperationType> types;
	
	public TypeManagerAction()
	{
		cooperationTypeService=ServiceFactory.getInstance().getCooperationTypeService();
	}
	public String save() throws Exception
	{
		try {
			cooperationTypeService.save(cooperationType);
			message.success("新增分类成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}
	public String getAllbig() throws Exception
	{
		types=cooperationTypeService.getAllBigType();
		//System.out.println(areas.get(0).getAreaname());
		return "allbig";
	}
	public String list() throws Exception
	{
		types=cooperationTypeService.getAllType();
		return SUCCESS;
	}
	public String delete()
	{
		try {
			cooperationTypeService.delete(cooperationType.getTypeid());
			message.success("分类删除成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}
	public String update() throws Exception
	{
		try {
			cooperationTypeService.update(cooperationType);
			message.success("分类修改成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}
	
	public String jumptoUpdate() throws Exception{
		CooperationType type=cooperationTypeService.loadById(cooperationType.getTypeid());
		BeanUtils.copyProperties(cooperationType, type);
		types=cooperationTypeService.getAllBigType();
		return "jump";
	}
	
	public CooperationType getCooperationType() {
		return cooperationType;
	}
	public void setCooperationType(CooperationType cooperationType) {
		this.cooperationType = cooperationType;
	}
	public List<CooperationType> getTypes() {
		return types;
	}
	public void setTypes(List<CooperationType> types) {
		this.types = types;
	}
	@Override
	public CooperationType getModel() {
		// TODO Auto-generated method stub
		return cooperationType;
	}

	

}

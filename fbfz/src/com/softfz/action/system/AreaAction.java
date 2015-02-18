package com.softfz.action.system;

import java.util.ArrayList;
import com.softfz.action.common.BaseAction;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.softfz.model.Area;
import com.softfz.model.PageModel;
import com.softfz.model.SystemUser;
import com.softfz.model.UserMember;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.IAreaService;
import com.softfz.service.factory.ServiceFactory;

public class AreaAction extends BaseAction implements ModelDriven<Area>{
	private Area area=new Area();
	private IAreaService iAreaservice;
	private List<Area> areas;
	private String[] arealist;
	public AreaAction()
	{
		iAreaservice=ServiceFactory.getInstance().getAreaService();
	}
	public String query() throws Exception {
		areas=iAreaservice.queryArea();
		return SUCCESS;
	}
	public String getAllbig() throws Exception
	{
		areas=iAreaservice.getAllBig();
		//System.out.println(areas.get(0).getAreaname());
		return "allbig";
	}
	
	public Area getModel() {
		// TODO Auto-generated method stub
		return area;
	}
	public List<Area> getAreas() {
		return areas;
	}
	
	public String save() {
		// 根据管理员名查询是否已经存在
		// System.out.println(systemUser.getLoginname());
		try {
			iAreaservice.save(area);
			message.success("新增区域成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}
	
	public String delete()
	{
		try {
			iAreaservice.delete(area.getAreaid());
			message.success("区域删除成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}
	
	public String jumptoUpdate() throws Exception{
		Area tmp=iAreaservice.loadById(area.getAreaid());
		BeanUtils.copyProperties(area, tmp);
		areas=iAreaservice.getAllBig();
		return "jump";
	}
	
	public String update() throws Exception
	{
		try {
			iAreaservice.update(area);
			message.success("区域修改成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}
}

package com.softfz.action.system;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.softfz.action.common.BaseAction;
import com.softfz.action.common.PageAction;
import com.softfz.model.Area;
import com.softfz.model.Cooperation;
import com.softfz.model.CooperationType;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.IAreaService;
import com.softfz.service.ICooperationService;
import com.softfz.service.ICooperationTypeService;
import com.softfz.service.factory.ServiceFactory;

public class CooperationAction extends BaseAction implements ModelDriven<Cooperation>{
	private Cooperation cooperation=new Cooperation();
	private ICooperationService cooperationService;
	private IAreaService iAreaService;
	private List<Cooperation> cooperations;
	private List<CooperationType> types;
	private List<Area> areas;
	private ICooperationTypeService cooperationTypeService;
	private String bigtypeid;
	public CooperationAction()
	{
		cooperationService=ServiceFactory.getInstance().getCooperationService();
		iAreaService=ServiceFactory.getInstance().getAreaService();
		cooperationTypeService=ServiceFactory.getInstance().getCooperationTypeService();
	}
	public String query() throws Exception
	{
		pageModel = cooperationService.queryCooperation(cooperation, currentPage, pageSize);
		areas=iAreaService.getAllBig();
		types=cooperationTypeService.getAllBigType();
		return SUCCESS;
	}
	/*public String querySmallArea() throws Exception
	{
		areas=iAreaService.getSmall(bigtypeid);
		return "";
	}*/
	public String querySmallType() throws Exception
	{
		types=cooperationTypeService.getSmallTypeByFatherid(cooperation.getBigtypeid());
		return "typeview";
	}
	public String querySmallArea() throws Exception
	{
		areas=iAreaService.getSmall(cooperation.getBigareaid());
		return "areaview";
	}
	public String jumptoAdd() throws Exception
	{
		areas=iAreaService.getAllBig();
		types=cooperationTypeService.getAllBigType();
		return "jumptoadd";
	}
	public String save() throws Exception
	{
		try {
			cooperationService.save(cooperation);
			message.success("新增商家联盟成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}
	public Cooperation getCooperation() {
		return cooperation;
	}
	public void setCooperation(Cooperation cooperation) {
		this.cooperation = cooperation;
	}
	@Override
	public Cooperation getModel() {
		// TODO Auto-generated method stub
		return cooperation;
	}
	public List<Cooperation> getCooperations() {
		return cooperations;
	}
	public void setCooperations(List<Cooperation> cooperations) {
		this.cooperations = cooperations;
	}
	public List<CooperationType> getTypes() {
		return types;
	}
	public List<Area> getAreas() {
		return areas;
	}
	public String getBigtypeid() {
		return bigtypeid;
	}
	public void setBigtypeid(String bigtypeid) {
		this.bigtypeid = bigtypeid;
	}
	
}

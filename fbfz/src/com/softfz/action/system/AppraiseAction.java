package com.softfz.action.system;

import com.opensymphony.xwork2.ModelDriven;
import com.softfz.action.common.BaseAction;
import com.softfz.action.common.PageAction;
import com.softfz.model.Appraise;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.IAppraiseService;
import com.softfz.service.factory.ServiceFactory;

public class AppraiseAction extends BaseAction implements ModelDriven<Appraise>{
	private Appraise appraise=new Appraise();
	private IAppraiseService appraiseService;
	public AppraiseAction()
	{
		appraiseService=ServiceFactory.getInstance().getAppraiseService();
	}
	public String query() throws Exception
	{
		pageModel = appraiseService.queryAppraise(appraise, currentPage, pageSize);
		return SUCCESS;
	}
	public String delete() throws Exception
	{
		try {
			appraiseService.delete(appraise.getAppid());
			message.success("评价删除成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}
	@Override
	public Appraise getModel() {
		// TODO Auto-generated method stub
		return appraise;
	}

}

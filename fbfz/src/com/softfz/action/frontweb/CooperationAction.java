package com.softfz.action.frontweb;

import com.opensymphony.xwork2.ModelDriven;
import com.softfz.action.common.PageAction;
import com.softfz.model.Cooperation;
import com.softfz.service.ICooperationService;
import com.softfz.service.factory.ServiceFactory;

public class CooperationAction extends PageAction implements
		ModelDriven<Cooperation> {
	private Cooperation cooperation = new Cooperation();
	private ICooperationService cooperationService;

	public CooperationAction() {
		cooperationService = ServiceFactory.getInstance()
				.getCooperationService();
	}

	public String query() throws Exception {
		this.pageModel = cooperationService.queryCooperation(cooperation,
				currentPage, pageSize);
		return SUCCESS;
	}

	public Cooperation getModel() {

		return cooperation;
	}

}

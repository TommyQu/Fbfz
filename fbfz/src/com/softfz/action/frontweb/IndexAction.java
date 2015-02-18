package com.softfz.action.frontweb;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.softfz.model.AdShop;
import com.softfz.model.Cooperation;
import com.softfz.model.CooperationType;
import com.softfz.service.ICooperationService;
import com.softfz.service.ICooperationTypeService;
import com.softfz.service.factory.ServiceFactory;

public class IndexAction extends ActionSupport {
	private List<Cooperation> topVip;
	private List<Cooperation> topTypeShop;
	private List<Cooperation> topTotal;
	private List<CooperationType> allTypes;
	private List<AdShop> allShops;
	private ICooperationService cooperationService;
	private ICooperationTypeService  cooperationTypeService;
	
	public IndexAction(){
		this.cooperationService = ServiceFactory.getInstance().getCooperationService();
		this. cooperationTypeService = ServiceFactory.getInstance().getCooperationTypeService();
	}

	@Override
	public String execute() throws Exception {
		this.topVip=this.cooperationService.getTopVip();
		this.topTypeShop=this.cooperationService.getTopTypeShop();
		this.topTotal = this.cooperationService.getTopTatalShop();
		this.allTypes = this.cooperationTypeService.getAllType();
		this.allShops = this.cooperationService.getOneLevelAd();
		return SUCCESS;
	}

	public List<Cooperation> getTopVip() {
		return topVip;
	}

	public List<Cooperation> getTopTypeShop() {
		return topTypeShop;
	}

	public List<Cooperation> getTopTotal() {
		return topTotal;
	}

	public List<CooperationType> getAllTypes() {
		return allTypes;
	}

	public List<AdShop> getAllShops() {
		return allShops;
	}
	
}

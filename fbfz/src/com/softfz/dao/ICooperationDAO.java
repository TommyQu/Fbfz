package com.softfz.dao;

import java.util.List;

import com.softfz.model.AdShop;
import com.softfz.model.Cooperation;
import com.softfz.model.PageModel;

/**
 * 联盟商家管理数据层接口
 * @author Administrator
 *
 */
public interface ICooperationDAO {
	/**
	 * 联盟商家分页查询
	 * 
	 * @param cooperation
	 *            查询条件，目前只支持，商家名称，类别，区域，等级，状态。
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            每页显示条数
	 * @return 分页数据模型
	 */
	public PageModel<Cooperation> queryCooperation(Cooperation cooperation, int currentPage,
			int pageSize);

	public List<Cooperation> getTopVip();

	public List<Cooperation> getTopTypeShop();

	public List<Cooperation> getTopTatalShop();

	public List<AdShop> getOneLevelAd();

	public void save(Cooperation cooperation);

	public boolean isExit(Cooperation cooperation);
	
	
}

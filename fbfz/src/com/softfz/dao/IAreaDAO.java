package com.softfz.dao;

import java.util.List;

import com.softfz.model.Area;
import com.softfz.model.PageModel;

public interface IAreaDAO {

	PageModel queryArea(Area area, int currentPage, int pageSize);

	List<Area> queryArea();

	boolean isExit(Area area);

	void save(Area area);

	List<Area> getAllBig();

	void delete(int areaid);

	Area loadById(int areaid);

	int update(Area area);

	List<Area> getSmall(int bigareaid);


}

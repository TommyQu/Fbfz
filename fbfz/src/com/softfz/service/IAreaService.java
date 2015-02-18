package com.softfz.service;

import java.util.List;

import com.softfz.model.Area;
import com.softfz.model.PageModel;

public interface IAreaService {

	List<Area> queryArea();

	void save(Area area);

	List<Area> getAllBig();

	void delete(int areaid);

	Area loadById(int areaid);

	void update(Area area);

	List<Area> getSmall(int bigareaid);

}

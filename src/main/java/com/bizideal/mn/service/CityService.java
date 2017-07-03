package com.bizideal.mn.service;

import com.bizideal.mn.bean.City;

/**
 * @author 作者 liulq:
 * @data 创建时间：2017年6月30日 上午11:16:07
 * @version 1.0
 * @description 描述
 */
public interface CityService {

	public City getById(int id);

	public int updateById(City city);

	public int deleteById(int id);
}

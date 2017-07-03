package com.bizideal.mn.service;

import com.bizideal.mn.bean.City;

/**
 * @author 作者 liulq:
 * @data 创建时间：2017年7月3日 下午5:45:53
 * @version 1.0
 * @description 描述
 */
public interface NonAnnotationCityService {

	public City getById(int id);

	public int updateById(City city);

	public int deleteById(int id);
}

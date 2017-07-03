package com.bizideal.mn.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bizideal.mn.bean.City;

/**
 * @author 作者 liulq:
 * @data 创建时间：2017年6月30日 上午11:11:49
 * @version 1.0
 * @description 描述
 */
@Mapper
public interface CityMapper {

	public City getById(int id);

	public int updateById(City city);

	public int deleteById(int id);
}

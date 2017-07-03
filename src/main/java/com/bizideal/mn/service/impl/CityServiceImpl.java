package com.bizideal.mn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bizideal.mn.bean.City;
import com.bizideal.mn.mapper.CityMapper;
import com.bizideal.mn.service.CityService;

/**
 * @author 作者 liulq:
 * @data 创建时间：2017年6月30日 上午11:16:28
 * @version 1.0
 * @description 基于注解实现
 */
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityMapper;

	/**
	 *
	 * 添加缓存，键的自动生成方式为类权限定名+方法名，key的存储位置为cachetest下
	 */
	@Override
	@Cacheable(value = "cachetest", key = "'city_'+#id")
	public City getById(int id) {
		System.out.println("查询数据库....");
		return cityMapper.getById(id);

	}

	@Override
	@CacheEvict(value = "cachetest", key = "'city_'+#city.id")
	public int updateById(City city) {
		System.out.println("更新数据库....");
		return cityMapper.updateById(city);

	}

	@Override
	@CacheEvict(value = "cachetest", key = "'city_'+#id")
	public int deleteById(int id) {
		System.out.println("删除数据库....");
		return cityMapper.deleteById(id);
	}

}

package com.bizideal.mn.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.bizideal.mn.bean.City;
import com.bizideal.mn.mapper.CityMapper;
import com.bizideal.mn.service.NonAnnotationCityService;

/**
 * @author 作者 liulq:
 * @data 创建时间：2017年7月3日 下午5:46:21
 * @version 1.0
 * @description 非注解实现
 */
@Service("nonAnnotationCityService")
public class NonAnnotationCityServiceImpl implements NonAnnotationCityService {

	@Autowired
	private CityMapper cityMapper;
	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 *
	 * 添加缓存，键的自动生成方式为类权限定名+方法名，key的存储位置为cachetest下
	 */
	@Override
	public City getById(int id) {
		System.out.println("查询数据库....");

		// 从缓存中获取城市信息
		String key = "city_" + id;
		ValueOperations<String, City> operations = redisTemplate.opsForValue();

		// 缓存存在
		boolean hasKey = redisTemplate.hasKey(key);
		if (hasKey) {
			City city = operations.get(key);

			System.out.println("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> " + city.toString());
			return city;
		}

		// 从 DB 中获取城市信息
		City city = cityMapper.getById(id);

		// 插入缓存
		operations.set(key, city, 120, TimeUnit.SECONDS);
		System.out.println("CityServiceImpl.findCityById() : 城市插入缓存 >> " + city.toString());
		return city;

	}

	@Override
	public int updateById(City city) {

		System.out.println("更新数据库...");
		int ret = cityMapper.updateById(city);

		// 缓存存在，删除缓存
		String key = "city_" + city.getId();
		boolean hasKey = redisTemplate.hasKey(key);
		if (hasKey) {
			redisTemplate.delete(key);

			System.out.println("CityServiceImpl.updateCity() : 从缓存中删除城市 >> " + city.toString());
		}

		return ret;
	}

	@Override
	public int deleteById(int id) {

		int ret = cityMapper.deleteById(id);

		// 缓存存在，删除缓存
		String key = "city_" + id;
		boolean hasKey = redisTemplate.hasKey(key);
		if (hasKey) {
			redisTemplate.delete(key);

			System.out.println("CityServiceImpl.deleteCity() : 从缓存中删除城市 ID >> " + id);
		}
		return ret;

	}

}

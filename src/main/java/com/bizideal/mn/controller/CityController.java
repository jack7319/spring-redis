package com.bizideal.mn.controller;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bizideal.mn.bean.City;
import com.bizideal.mn.service.CityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 作者 liulq:
 * @data 创建时间：2017年6月30日 上午11:28:25
 * @version 1.0
 * @description 描述
 */
@Api(value = "测试接口")
@Controller
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityService cityService;

	@ApiOperation(value = "根据id查询城市", httpMethod = "GET", notes = "根据id查询城市")
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public City getById(@PathVariable("id") Integer id) {
		return cityService.getById(id);
	}

	@ApiOperation(value = "根据id更新城市", httpMethod = "POST", notes = "根据id更新城市")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> getById(@RequestBody City city) {
		Map<String, String> map = new HashMap<String, String>();
		int updateById = cityService.updateById(city);
		if (updateById > 0) {
			map.put("status", "0");
			map.put("msg", "ok");
			return map;
		}
		map.put("status", "1");
		map.put("msg", "更新失败");
		return map;
	}
}

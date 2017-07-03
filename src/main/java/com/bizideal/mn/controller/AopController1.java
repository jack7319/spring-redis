package com.bizideal.mn.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 作者 liulq:
 * @data 创建时间：2017年7月3日 上午9:56:01
 * @version 1.0
 * @description 描述
 */
@RestController
@RequestMapping("/aop1")
public class AopController1 {

	@RequestMapping("/get")
	public Map<String, String> get(String phone) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "1");
		map.put("name", "liu");
		return map;
	}
}

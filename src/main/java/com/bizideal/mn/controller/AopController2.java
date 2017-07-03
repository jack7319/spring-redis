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
@RequestMapping("/aop2")
public class AopController2 {

	@RequestMapping("/get")
	public Map<String, String> get(String phone) {
		System.out.println("aop2 get");
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "2");
		map.put("name", "get");
		return map;
	}

	@RequestMapping("/post")
	public Map<String, String> post(String phone) {
		System.out.println("aop2 post");
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "2");
		map.put("name", "post");
		return map;
	}

	@RequestMapping("/delete")
	public Map<String, String> delete(String phone) {
		System.out.println("aop2 get");
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "2");
		map.put("name", "zhang");
		return map;
	}
}

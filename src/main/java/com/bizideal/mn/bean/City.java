package com.bizideal.mn.bean;

import java.io.Serializable;

/**
 * @author 作者 liulq:
 * @data 创建时间：2017年6月30日 上午11:09:52
 * @version 1.0
 * @description 描述
 */
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;

	public City() {
		super();
	}

	public City(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}

}

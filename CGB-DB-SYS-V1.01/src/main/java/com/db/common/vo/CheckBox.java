package com.db.common.vo;

import java.io.Serializable;

/**
 * 基于此对象封装CheckBox相关信息,例如
 * 角色信息(角色id,角色名称)
 * @author Administrator
 *
 */
public class CheckBox implements Serializable{
	private static final long serialVersionUID = 282985653226440750L;
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
		return "CheckBox [id=" + id + ", name=" + name + "]";
	}

}

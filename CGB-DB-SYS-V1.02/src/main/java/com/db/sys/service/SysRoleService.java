package com.db.sys.service;

import java.util.List;

import com.db.common.vo.CheckBox;
import com.db.common.vo.PageObject;
import com.db.sys.entity.SysRole;
import com.db.sys.vo.SysRoleMenuVo;

public interface SysRoleService {
	List<CheckBox> findObjects();
	
	
	int updateObject(SysRole entity,Integer[] menuIds);
	
	/**
	 * 基于角色id执行角色信息以及角色与菜单关系数据
	 * @param id
	 * @return
	 */
	SysRoleMenuVo findObjectById(Integer id);
	
	/**
	 * 本方法中要分页查询角色信息,并查询角色总记录数据
	 * @param name
	 * @param pageCurrent 当表要查询的当前页的页码值
	 * @return 封装当前试题数据以及分页信息
	 */
	PageObject<SysRole> findPageObjects(String name,Integer pageCurrent);
	
	/**
	 * 基于角色id删除角色以及对应关系
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	/**
	 * 保存角色以及角色和菜单的关系数据
	 * @param entity
	 * @param menuId
	 * @return
	 */
	int saveObject(SysRole entity,Integer[] menuIds);
}

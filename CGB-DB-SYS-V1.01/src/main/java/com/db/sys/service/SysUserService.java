package com.db.sys.service;


import java.util.Map;

import com.db.common.vo.PageObject;
import com.db.common.vo.SysUserDeptVo;
import com.db.sys.entity.SysUser;

public interface SysUserService {
	/**
	 * 基于用户id获取用户信息以及对应的部门信息,以及用户对应的角色信息
	 * @param id
	 * @return
	 */
	Map<String,Object>findObjectById(Integer id);
	
	/**
	 * 更新用户信息
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int updateObject(SysUser entity,Integer[] roleIds);
	
	int saveObject(SysUser entity,Integer[] roleIds);
	
	/**
	 * 禁用或者启用用户
	 * @param id
	 * @param valid
	 * @param mopdifiledUser
	 * @return
	 */
	int validById(Integer id,Integer valid,String modifiedUser);
	
	/**
	 * 基于条件查询用户的相关信息
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	PageObject<SysUserDeptVo> findPageObjects(
			String username,
			Integer pageCurrent);

}

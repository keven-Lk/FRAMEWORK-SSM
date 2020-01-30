package com.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysUserRoleDao {
	/**
	 * 基于用户id获取所有的角色id
	 * @param id
	 * @return
	 */
	List<Integer> findRoleIdsByUserId(Integer id);
	
	/**
	 * 负责将用户与角色的关系数据写入到数据库
	 * @param userId 用户id
	 * @param roleIds 多个角色id
	 * @return
	 */
	int insertObject(
			@Param("userId")Integer userId,
			@Param("roleIds")Integer[]roleIds);

	
	/**
	 * 基于角色id删除角色与用户关系数据
	 * @param roleId
	 * @return
	 */
	int deleteObjectsByRoleId(Integer roleId);
	/**
	 * 基于角色id删除角色与用户关系数据
	 * @param UserId
	 * @return
	 */
	int deleteObjectsByUserId(Integer UserId);
}

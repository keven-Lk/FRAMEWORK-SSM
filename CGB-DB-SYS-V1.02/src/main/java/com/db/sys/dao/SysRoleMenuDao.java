package com.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.db.sys.entity.SysMenu;

public interface SysRoleMenuDao {
	List<Integer> findMenuIdsByRoleIds(
			@Param("roleIds")Integer[] roleIds);


	int findMenuIdsByRoleId(int id);
	/**
	 * 基于菜单id删除关系表数据
	 * @param menuId
	 * @return
	 */
	int deleteObjectsByMenuId(Integer menuId);

	int indertObject(SysMenu entity);

	/**
	 * 基于角色id删除角色和菜单关系数据
	 * @param roleId
	 * @return
	 */
	int deleteObjectsByRoleId(Integer roleId);

	int insertObject(
			@Param("roleId")Integer roleId,
			@Param("menuIds") Integer[] menuIds);
}

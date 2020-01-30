package com.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.db.sys.entity.SysMenu;

public interface SysRoleMenuDao {
	List<Integer> findMenuIdsByRoleIds(
			@Param("roleIds")Integer[] roleIds);


	int findMenuIdsByRoleId(int id);
	/**
	 * ���ڲ˵�idɾ����ϵ������
	 * @param menuId
	 * @return
	 */
	int deleteObjectsByMenuId(Integer menuId);

	int indertObject(SysMenu entity);

	/**
	 * ���ڽ�ɫidɾ����ɫ�Ͳ˵���ϵ����
	 * @param roleId
	 * @return
	 */
	int deleteObjectsByRoleId(Integer roleId);

	int insertObject(
			@Param("roleId")Integer roleId,
			@Param("menuIds") Integer[] menuIds);
}

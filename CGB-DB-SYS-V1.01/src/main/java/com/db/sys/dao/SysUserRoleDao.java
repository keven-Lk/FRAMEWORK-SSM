package com.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysUserRoleDao {
	/**
	 * �����û�id��ȡ���еĽ�ɫid
	 * @param id
	 * @return
	 */
	List<Integer> findRoleIdsByUserId(Integer id);
	
	/**
	 * �����û����ɫ�Ĺ�ϵ����д�뵽���ݿ�
	 * @param userId �û�id
	 * @param roleIds �����ɫid
	 * @return
	 */
	int insertObject(
			@Param("userId")Integer userId,
			@Param("roleIds")Integer[]roleIds);

	
	/**
	 * ���ڽ�ɫidɾ����ɫ���û���ϵ����
	 * @param roleId
	 * @return
	 */
	int deleteObjectsByRoleId(Integer roleId);
	/**
	 * ���ڽ�ɫidɾ����ɫ���û���ϵ����
	 * @param UserId
	 * @return
	 */
	int deleteObjectsByUserId(Integer UserId);
}

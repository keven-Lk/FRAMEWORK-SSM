package com.db.sys.service;


import java.util.Map;

import com.db.common.vo.PageObject;
import com.db.common.vo.SysUserDeptVo;
import com.db.sys.entity.SysUser;

public interface SysUserService {
	/**
	 * �����û�id��ȡ�û���Ϣ�Լ���Ӧ�Ĳ�����Ϣ,�Լ��û���Ӧ�Ľ�ɫ��Ϣ
	 * @param id
	 * @return
	 */
	Map<String,Object>findObjectById(Integer id);
	
	/**
	 * �����û���Ϣ
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int updateObject(SysUser entity,Integer[] roleIds);
	
	int saveObject(SysUser entity,Integer[] roleIds);
	
	/**
	 * ���û��������û�
	 * @param id
	 * @param valid
	 * @param mopdifiledUser
	 * @return
	 */
	int validById(Integer id,Integer valid,String modifiedUser);
	
	/**
	 * ����������ѯ�û��������Ϣ
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	PageObject<SysUserDeptVo> findPageObjects(
			String username,
			Integer pageCurrent);

}

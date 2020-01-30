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
	 * ���ڽ�ɫidִ�н�ɫ��Ϣ�Լ���ɫ��˵���ϵ����
	 * @param id
	 * @return
	 */
	SysRoleMenuVo findObjectById(Integer id);
	
	/**
	 * ��������Ҫ��ҳ��ѯ��ɫ��Ϣ,����ѯ��ɫ�ܼ�¼����
	 * @param name
	 * @param pageCurrent ����Ҫ��ѯ�ĵ�ǰҳ��ҳ��ֵ
	 * @return ��װ��ǰ���������Լ���ҳ��Ϣ
	 */
	PageObject<SysRole> findPageObjects(String name,Integer pageCurrent);
	
	/**
	 * ���ڽ�ɫidɾ����ɫ�Լ���Ӧ��ϵ
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	/**
	 * �����ɫ�Լ���ɫ�Ͳ˵��Ĺ�ϵ����
	 * @param entity
	 * @param menuId
	 * @return
	 */
	int saveObject(SysRole entity,Integer[] menuIds);
}

package com.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.db.common.vo.CheckBox;
import com.db.sys.entity.SysRole;
import com.db.sys.vo.SysRoleMenuVo;

public interface SysRoleDao {
	/**
	 * ��ȡ��ɫ�����Ϣ
	 * @return
	 */
	List<CheckBox> findObjects();
	
	int updateObject(SysRole entity);
	
	/**
	 * ���ڽ�ɫid��ѯ��ɫ��Ϣ�Լ���ɫ��Ӧ�Ĳ˵���Ϣ
	 * �ص��ע:one2many��ѯ��ʵ��
	 * @param id
	 * @return
	 */
	SysRoleMenuVo findObjectById(Integer id);
	
	/**
	 * ����ɫ������Ϣ���µ����ݿ�
	 * @param entity
	 * @return
	 */
	int insertObject(SysRole entity);
	
	/**
	 * ����������ѯ��ǰҳ��¼
	 * @param name ��ѯ����
	 * @param startIndex ��ǰҳ��ʼλ��
	 * @param pageSize ҳ���С
	 * @return
	 */
	List<SysRole> findPageObjects(@Param("name") String name,
			@Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);
	
	/**
	 * ��ѯ��¼����
	 * @param name
	 * @return
	 */
	int getRowCount(@Param("name")String name);
	
	/**
	 * ���ڽ�ɫidɾ����ɫ������Ϣ
	 * @param id ��ʾ��ɫid
	 * @return
	 */
	int deleteObject(Integer id);
}

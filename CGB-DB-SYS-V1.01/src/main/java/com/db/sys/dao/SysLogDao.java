package com.db.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.db.sys.entity.SysLog;

public interface SysLogDao {
	/**
	 * ������־id,ִ����־ɾ������
	 * @param ids
	 * @return
	 */
	int deleteObjects(@Param("ids") Integer...ids);
	
	Map<String, Object> findById(Integer id);
	
	/*
	 * ��������ͳ����־��Ϣ
	 * @Param username
	 * @return ���û�����Ϊ��־��Ϣ����
	 */
	int getRowCount(@Param("username") String username);

	/**
	 * ���ڲ�ѯ����,��ҳ��ѯ�û���Ϊ��־��Ϣ
	 * @param username ��ѯ����
	 * @param startIndex ��ʼλ��
	 * @param pageSize ҳ���С
	 * @return
	 */
	List<SysLog> findPageObjects(@Param("username") String username,
			@Param("startIndex") Integer startIndex,
					@Param("pageSize") Integer pageSize);
}

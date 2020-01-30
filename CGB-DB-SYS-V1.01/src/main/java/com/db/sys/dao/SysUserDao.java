package com.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.db.common.vo.SysUserDeptVo;
import com.db.sys.entity.SysUser;

public interface SysUserDao {
	/**
	 * ����id��ѯ�û��Լ���Ӧ�Ĳ�����Ϣ
	 * @param id
	 * @return
	 */
	SysUserDeptVo findObjectById(Integer id);
	
	/**
	 * �����û���Ϣ���µ����ݿ�
	 * @param entity
	 * @return
	 */
	int updateObject(SysUser entity);
	/**
	 * �����û���Ϣд�뵽���ݿ�
	 * @param entity
	 * @return
	 */
	int insertObject(SysUser entity);

	
	/**
	 * ִ���û����û����ò���
	 * @param id�û�id
	 * @param valid��ʾ״̬(1,0)
	 * @param modifiedUser�޸��û�
	 * @return
	 */
	int validById(@Param("id")Integer id,
					@Param("valid")Integer valid, 
					@Param("modifiedUser")String modifiedUser);
	
	/**
	 * ����������ѯ��ǰҳ��¼
	 * @param username
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<SysUserDeptVo> findPageObjects(
			@Param("username") String username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**
	 * ͳ���ܼ�¼��
	 * @param username
	 * @return
	 */
	int getRowCount(@Param("username") String username);
	

}

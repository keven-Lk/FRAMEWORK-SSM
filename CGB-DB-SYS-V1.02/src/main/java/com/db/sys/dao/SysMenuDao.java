package com.db.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.db.common.vo.Node;
import com.db.sys.entity.SysMenu;

public interface SysMenuDao {
	/**
	 * ���ڲ˵�id��ȡȨ�ޱ�ʶ
	 * @param menuIds
	 * @return
	 */

	List<String> findPermissions(
			@Param("menuIds")
			Integer[] menuIds);


	/**
	 * ��ѯ���в˵��Լ��ϼ��˵�(��ȡ�ϼ��˵���)�����Ϣ
	 * 1)һ�м�¼ӳ��1��map
	 * 2)���м�¼�洢��list����
	 * @return
	 */
	List<Map<String,Object>> findObjects();

	/**
	 * ͳ�Ƶ�ǰ�˵���Ӧ���Ӳ˵�
	 * @param id Ϊ��ǰ�˵���id
	 * @return
	 */
	int getChileCount(Integer id);

	/**
	 * ɾ��Ҷ�ӽڵ�Ԫ��
	 * ����idɾ���˵�
	 * @param id ��ʾ�˵�id
	 * @return
	 */
	int deleteObject(Integer id);

	/**
	 * ��ѯ�˵��ڵ���Ϣ,���Ҫ������Ϣ�ڿͻ��������ṹ��ʽ����
	 * @return
	 */
	List<Node> findZtreeMenuNodes();

	int insertObject(SysMenu entity);

	int updateObject(SysMenu entity);

	int deleteObjectsByRoleId(Integer roleId);
}

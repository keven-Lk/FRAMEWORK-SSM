package com.db.sys.service;

import java.util.List;
import java.util.Map;

import com.db.common.vo.Node;
import com.db.sys.entity.SysMenu;

public interface SysMenuService {
	List<Map<String,Object>> findObjects();
	
	/**
	 * ���ڲ˵�idִ��ɾ������
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	List<Node> findZtreeMenuNodes();
	
	int saveObject(SysMenu entitiy);
	
	int updateObject(SysMenu entity);
		
}

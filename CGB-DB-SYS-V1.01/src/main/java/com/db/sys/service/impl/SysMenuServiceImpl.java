package com.db.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.db.common.vo.Node;
import com.db.sys.common.exception.ServiceException;
import com.db.sys.dao.SysMenuDao;
import com.db.sys.dao.SysRoleMenuDao;
import com.db.sys.entity.SysMenu;
import com.db.sys.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService{
	@Autowired
	private SysMenuDao sysMenuDao;
	
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	
	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String,Object>> list = sysMenuDao.findObjects();
		if(list==null||list.size() == 0)
			throw new ServiceException("û�ж�Ӧ�Ĳ˵���Ϣ");
		return list;
	}

	@Override
	public int deleteObject(Integer id) {
		//1.��֤���ݵĺϷ���(�ж�id����Ч��)
		if(id == null || id<=0) {
			throw new IllegalArgumentException("����ѡ��");
		}
		//2.ͳ�Ƶ�ǰ�˵���Ӧ���Ӳ˵�����,�������ж�
		int rowcount = sysMenuDao.getChileCount(id);
		if(rowcount>0)
			throw new ServiceException("����ɾ���Ӳ˵�");
		//3.ɾ���˵�Ԫ��
		int rows = sysMenuDao.deleteObject(id);
		if(rows == 0)
			throw new ServiceException("�˲˵������Ѿ�������");
		//4.ɾ���˵���ϵ����
		sysRoleMenuDao.deleteObjectsByMenuId(id);
		//5.���ؽ��
		return rows;
	}

	@Override
	public List<Node> findZtreeMenuNodes() {
		List<Node> list = sysMenuDao.findZtreeMenuNodes();
		if(list==null || list.size()==0)
			throw new ServiceException("û�в˵���Ϣ");
		return list;
	}

	@Override
	public int saveObject(SysMenu entity) {
		//1.�Ϸ���֤
		if(entity == null)
			throw new ServiceException("���������Ϊ��");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("�˵�������Ϊ��");
		int rows;
		//2.�������� �����ݳ־û�������
		try {
			rows = sysMenuDao.insertObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			//����(����ά��Ա������)
			throw new ServiceException("����ʧ��");
		}
		//3.��������
		
		return rows;
	}

	@Override
	public int updateObject(SysMenu entity) {
		//1.�Ϸ���֤
		if(entity == null)
			throw new ServiceException("���������Ϊ��");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("�˵�������Ϊ��");
		
		//2.��������
		int rows = sysMenuDao.updateObject(entity);
		if(rows == 0)
			throw new ServiceException("��¼�����Ѿ�������");
		//3.��������
		return rows;
	}
	
}

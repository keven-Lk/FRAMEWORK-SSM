package com.db.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.db.common.utils.PageUtil;
import com.db.common.vo.CheckBox;
import com.db.common.vo.PageObject;
import com.db.sys.common.exception.ArgumentException;
import com.db.sys.common.exception.ServiceException;
import com.db.sys.dao.SysRoleDao;
import com.db.sys.dao.SysRoleMenuDao;
import com.db.sys.dao.SysUserRoleDao;
import com.db.sys.entity.SysRole;
import com.db.sys.service.SysRoleService;
import com.db.sys.vo.SysRoleMenuVo;

@Service
public class SysRoleServiceImpl implements SysRoleService{
	@Autowired
	@Qualifier("sysRoleDao")
	//�����ֶ��������ͬ�Ķ��󻹿��Խ���@Qualifierָ��ע��
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	@Override
	public List<CheckBox> findObjects() {
		return sysRoleDao.findObjects();
	}
	
	@Override
	public int updateObject(SysRole entity, Integer[] menuIds) {
		//1.�Ϸ�����֤
		if(entity==null)
			throw new ArgumentException("���µĶ�����Ϊ��");
		if(entity.getId()==null)
			throw new ArgumentException("id��ֵ����Ϊ��");

		if(StringUtils.isEmpty(entity.getName()))
			throw new ArgumentException("��ɫ������Ϊ��");
		if(menuIds==null||menuIds.length==0)
			throw new ArgumentException("����Ϊ��ɫָ��һ��Ȩ��");

		//2.��������
		int rows=sysRoleDao.updateObject(entity);
		if(rows==0)
			throw new ServiceException("��������Ѿ�������");
		sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
		sysRoleMenuDao.insertObject(entity.getId(),menuIds);

		//3.���ؽ��
		return rows;
	}
	
	@Override
	public SysRoleMenuVo findObjectById(Integer id) {
		//1.�Ϸ�����֤
		if(id==null||id<=0)
			throw new ArgumentException("id��ֵ���Ϸ�");
		//2.ִ�в�ѯ
		SysRoleMenuVo result=sysRoleDao.findObjectById(id);
		//3.��֤���������
		if(result==null)
			throw new ServiceException("�˼�¼�Ѿ�������");
		return result;
	}


	@Override
	public PageObject<SysRole> findPageObjects(
			String name, Integer pageCurrent) {
		//1.����У��
		if(pageCurrent == null||pageCurrent<1)
			throw new ArgumentException("ҳ��ֵ����ȷ");
		//2.��ѯ�ܼ�¼��
		int rowCount = sysRoleDao.getRowCount(name);
		if(rowCount == 0)
			throw new ServiceException("��¼������");
		//3.ִ�з�ҳ��ѯ
		int pageSize = 3;
		int startIndex = pageSize*(pageCurrent-1);
		List<SysRole> records = 
				sysRoleDao.findPageObjects(name, startIndex, pageSize);
		return PageUtil.newPageObeject(pageCurrent, rowCount, pageSize, records);
	}
	@Override
	public int deleteObject(Integer id) {
		//1.��֤�����ĺϷ���
		if(id==null||id<1)
			throw new ArgumentException("id��ֵ����ȷ,id="+id);
		//2.ɾ����ɫ�˵���ϵ����
		int rows = sysRoleDao.deleteObject(id);
		if(rows == 0)
			throw new ServiceException("���ݿ����Ѿ�������");
		//3.ɾ����ɫ�˵���ϵ����
		sysRoleMenuDao.deleteObjectsByMenuId(id);
		//4.ɾ����ɫ�û���ϵ����
		sysUserRoleDao.deleteObjectsByRoleId(id);
		//5.���ؽ��
		return rows;
	}
	@Override
	public int saveObject(SysRole entity, Integer[] menuIds) {
		//1.����У��
		if(StringUtils.isEmpty(entity.getName()))
			throw new ArgumentException("��ɫ������Ϊ��");
		//...
		if(menuIds == null || menuIds.length == 0)
			throw new ArgumentException("����Ϊ��ɫָ��Ȩ��");
		//2.�����ɫ������Ϣ
		int rows = sysRoleDao.insertObject(entity);
		//3.�����ɫ�Ͳ˵���ϵ����
		sysRoleMenuDao.insertObject(entity.getId(), menuIds);
		//4.���ؽ��
		return rows;
	}
}

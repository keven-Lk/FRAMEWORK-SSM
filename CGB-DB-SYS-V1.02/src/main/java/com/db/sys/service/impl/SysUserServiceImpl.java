package com.db.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.db.common.annotation.RequiredCache;
import com.db.common.annotation.RequiredLog;
import com.db.common.vo.PageObject;
import com.db.common.vo.SysUserDeptVo;
import com.db.sys.common.exception.ArgumentException;
import com.db.sys.common.exception.ServiceException;
import com.db.sys.dao.SysUserDao;
import com.db.sys.dao.SysUserRoleDao;
import com.db.sys.entity.SysUser;
import com.db.sys.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService{
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	//��ȡһ����־����
	private Logger log = Logger.getLogger(SysUserServiceImpl.class);

	@Override
	public int updatePassword(String pwd, String newPwd,String cfgPwd) {
		//1.����У��
		if(StringUtils.isEmpty(pwd))
			throw new ServiceException("ԭ���벻��Ϊ��");
		if(StringUtils.isEmpty(newPwd))
			throw new ServiceException("�����벻��Ϊ��");
		if(StringUtils.isEmpty(cfgPwd))
			throw new ServiceException("ȷ�����벻��Ϊ��");
		if(!newPwd.equals(cfgPwd))
			throw new ArgumentException("��������������벻һ��");
		//��ȡ�û�������
		SysUser sysUser = (SysUser)SecurityUtils.getSubject().getPrincipal();
		if(sysUser == null)
			throw new ServiceException("���ȵ�¼");
		String sourcePwd = sysUser.getPassword();
		SimpleHash sHash = new SimpleHash("MD5",pwd,sysUser.getSalt(),1);
		String hashPwd = sHash.toHex();
		if(!sourcePwd.equals(hashPwd)) {//������־
			throw new ServiceException("�����ԭ���벻��ȷ");
		}
		//3.��������
		String newSalt = UUID.randomUUID().toString();
		sHash = new SimpleHash("MD5",newPwd,newSalt,1);
		int rows = sysUserDao.updatePassword(sysUser.getUsername(),
				sHash.toHex(), newSalt);
		if(rows == 0)
			throw new ServiceException("��¼�����Ѿ�������");
		return rows;
	}

	/**
	 * ִ�н������ò���
	 * @RequiresPermissions ע�����εķ�����ʾ�˷���������Ȩ����
	 * 						(ע���ڲ����ַ�����ʾȨ�ޱ�ʾ(�û�ӵ�д�Ȩ�޲ſ��Է�����Դ))
	 */
	@RequiresPermissions("sys:user:valid")
	@RequiredLog("��������")
	@Override
	public int validById(Integer id, Integer valid, String modifiedUser) {
		//1.��֤��Ч��
		if(id == null || id <1)
			throw new ArgumentException("id����ֵ��Ч");
		if(valid != 1 && valid != 0)
			throw new ArgumentException("״ֵ̬��Ч");
		//2.ִ�н��û����ò���
		int rows = sysUserDao.validById(id, valid, modifiedUser);
		if(rows == 0)
			throw new ServiceException("�˼�¼�����Ѿ�������");
		return rows;

	}
	@Override
	public int updateObject(SysUser entity, Integer[] roleIds) {
		//1.����У��
		if(entity == null)
			throw new ArgumentException("���������Ϊ��");
		if(StringUtils.isEmpty(entity.getUsername()))
			throw new ArgumentException("�û�������Ϊ��");
		if(roleIds == null || roleIds.length == 0)
			throw new ArgumentException("����Ϊ�û������ɫ");
		//...
		//2.���û����ɫ��ϵ����д�뵽���ݿ�
		int rows = sysUserDao.updateObject(entity);
		if(rows == 0)
			throw new ServiceException("��¼�����Ѿ�������");
		//3.���û����ɫ��ϵ����д�뵽���ݿ�
		sysUserRoleDao.deleteObjectsByUserId(entity.getId());
		sysUserRoleDao.insertObject(entity.getId(),roleIds);
		return rows;
	}

	@Override
	public Map<String, Object> findObjectById(Integer id) {
		//1.�Ϸ�����֤
		if(id==null||id<=0)
			throw new ServiceException(
					"�������ݲ��Ϸ�,userId="+id);
		//2.ҵ���ѯ
		SysUserDeptVo user=
				sysUserDao.findObjectById(id);
		if(user==null)
			throw new ServiceException("���û��Ѿ�������");
		List<Integer> roleIds=
				sysUserRoleDao.findRoleIdsByUserId(id);
		//3.���ݷ�װ
		Map<String,Object> map=new HashMap<>();
		map.put("user", user);
		map.put("roleIds", roleIds);
		return map;
	}

	@Override
	public int saveObject(SysUser entity, Integer[] roleIds) {
		//1.����У��
		if(entity == null)
			throw new ArgumentException("���������Ϊ��");
		if(StringUtils.isEmpty(entity.getUsername()))
			throw new ArgumentException("�û�������Ϊ��");
		if(StringUtils.isEmpty(entity.getPassword()))
			throw new ArgumentException("���벻��Ϊ��");
		if(roleIds == null || roleIds.length == 0)
			throw new ArgumentException("����Ϊ�û������ɫ");
		//...
		//2.�û�������Ϣд�����ݿ�
		String salt = UUID.randomUUID().toString();
		SimpleHash sh = new SimpleHash(
				"MD5",//algorithmName �����㷨���� MD5��ϢժҪ�㷨
				entity.getPassword(), //Ҫ���ܵĶ���
				salt,//������
				1);//Ҫ���ܵĴ���
		String newPassword = sh.toHex();
		entity.setSalt(salt);
		entity.setPassword(newPassword);//���ܽ��תΪ16����
		int rows = sysUserDao.insertObject(entity);
		//3.���û����ɫ��ϵ����д�뵽���ݿ�
		sysUserRoleDao.insertObject(entity.getId(), roleIds);
		return rows;
	}

	@RequiredCache
	@Override
	public PageObject<SysUserDeptVo> findPageObjects(String username, 
			Integer pageCurrent) {                       
		//1.���ݺϷ�����֤
		if(pageCurrent==null||pageCurrent<=0)
			throw new ServiceException("�������Ϸ�");
		//2.����������ȡ�ܼ�¼��
		int rowCount=sysUserDao.getRowCount(username);
		if(rowCount==0)
			throw new ServiceException("��¼������");
		//3.����startIndex��ֵ
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		//4.����������ȡ��ǰҳ����
		List<SysUserDeptVo> records=sysUserDao.findPageObjects(
				username, startIndex, pageSize);
		//5.��װ����
		PageObject<SysUserDeptVo> pageObject=new PageObject<>();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(records);
		pageObject.setPageCount((rowCount-1)/pageSize+1);
		return pageObject;
	}

}

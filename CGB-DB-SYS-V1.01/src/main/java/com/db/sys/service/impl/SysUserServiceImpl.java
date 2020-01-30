package com.db.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
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
	
	@Override
	public int updateObject(SysUser entity, Integer[] roleIds) {
		//1.参数校验
		if(entity == null)
			throw new ArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getUsername()))
			throw new ArgumentException("用户名不能为空");
		if(roleIds == null || roleIds.length == 0)
			throw new ArgumentException("必须为用户分配角色");
		//...
		//2.将用户与角色关系数据写入到数据库
		int rows = sysUserDao.updateObject(entity);
		if(rows == 0)
			throw new ServiceException("记录可能已经不存在");
		//3.将用户与角色关系数据写入到数据库
		sysUserRoleDao.deleteObjectsByUserId(entity.getId());
		sysUserRoleDao.insertObject(entity.getId(),roleIds);
		return rows;
	}
	
	@Override
	public Map<String, Object> findObjectById(Integer id) {
		//1.合法性验证
		if(id==null||id<=0)
		throw new ServiceException(
		"参数数据不合法,userId="+id);
		//2.业务查询
		SysUserDeptVo user=
		sysUserDao.findObjectById(id);
		if(user==null)
		throw new ServiceException("此用户已经不存在");
		List<Integer> roleIds=
		sysUserRoleDao.findRoleIdsByUserId(id);
		//3.数据封装
		Map<String,Object> map=new HashMap<>();
		map.put("user", user);
		map.put("roleIds", roleIds);
		return map;
	}
	
	@Override
	public int saveObject(SysUser entity, Integer[] roleIds) {
		//1.参数校验
		if(entity == null)
			throw new ArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getUsername()))
			throw new ArgumentException("用户名不能为空");
		if(StringUtils.isEmpty(entity.getPassword()))
			throw new ArgumentException("密码不能为空");
		if(roleIds == null || roleIds.length == 0)
			throw new ArgumentException("必须为用户分配角色");
		//...
		//2.用户自身信息写到数据库
		String salt = UUID.randomUUID().toString();
		SimpleHash sh = new SimpleHash(
				"MD5",//algorithmName 加密算法名称 MD5消息摘要算法
				entity.getPassword(), //要加密的对象
				salt,//加密盐
				1);//要加密的次数
		String newPassword = sh.toHex();
		entity.setSalt(salt);
		entity.setPassword(newPassword);//加密结果转为16进制
		int rows = sysUserDao.insertObject(entity);
		//3.将用户与角色关系数据写入到数据库
		sysUserRoleDao.insertObject(entity.getId(), roleIds);
		return rows;
	}

	
	@Override
	public int validById(Integer id, Integer valid, String modifiedUser) {
		//1.验证有效性
		if(id == null || id <1)
			throw new ArgumentException("id参数值无效");
		if(valid != 1 && valid != 0)
			throw new ArgumentException("状态值无效");
		//2.执行禁用或启用操作
		int rows = sysUserDao.validById(id, valid, modifiedUser);
		if(rows == 0)
			throw new ServiceException("此记录可能已经不存在");
		return rows;
		
	}
	@Override
	public PageObject<SysUserDeptVo> findPageObjects(String username, 
			Integer pageCurrent) {
		//1.数据合法性验证
		if(pageCurrent==null||pageCurrent<=0)
			throw new ServiceException("参数不合法");
		//2.依据条件获取总记录数
		int rowCount=sysUserDao.getRowCount(username);
		if(rowCount==0)
			throw new ServiceException("记录不存在");
		//3.计算startIndex的值
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		//4.依据条件获取当前页数据
		List<SysUserDeptVo> records=sysUserDao.findPageObjects(
				username, startIndex, pageSize);
		//5.封装数据
		PageObject<SysUserDeptVo> pageObject=new PageObject<>();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(records);
		pageObject.setPageCount((rowCount-1)/pageSize+1);
		return pageObject;
	}

}

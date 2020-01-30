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
			throw new ServiceException("没有对应的菜单信息");
		return list;
	}

	@Override
	public int deleteObject(Integer id) {
		//1.验证数据的合法性(判断id的有效性)
		if(id == null || id<=0) {
			throw new IllegalArgumentException("请先选择");
		}
		//2.统计当前菜单对应的子菜单个数,并进行判定
		int rowcount = sysMenuDao.getChileCount(id);
		if(rowcount>0)
			throw new ServiceException("请先删除子菜单");
		//3.删除菜单元素
		int rows = sysMenuDao.deleteObject(id);
		if(rows == 0)
			throw new ServiceException("此菜单可能已经不存在");
		//4.删除菜单关系数据
		sysRoleMenuDao.deleteObjectsByMenuId(id);
		//5.返回结果
		return rows;
	}

	@Override
	public List<Node> findZtreeMenuNodes() {
		List<Node> list = sysMenuDao.findZtreeMenuNodes();
		if(list==null || list.size()==0)
			throw new ServiceException("没有菜单信息");
		return list;
	}

	@Override
	public int saveObject(SysMenu entity) {
		//1.合法验证
		if(entity == null)
			throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("菜单名不能为空");
		int rows;
		//2.保存数据 将数据持久化到数据
		try {
			rows = sysMenuDao.insertObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			//报警(给运维人员发短信)
			throw new ServiceException("保存失败");
		}
		//3.返回数据
		
		return rows;
	}

	@Override
	public int updateObject(SysMenu entity) {
		//1.合法验证
		if(entity == null)
			throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("菜单名不能为空");
		
		//2.更新数据
		int rows = sysMenuDao.updateObject(entity);
		if(rows == 0)
			throw new ServiceException("记录可能已经不存在");
		//3.返回数据
		return rows;
	}
	
}

package com.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.db.sys.dao.SysMenuDao;
import com.db.sys.entity.SysMenu;

public class TestSysMenuDao extends TestBase{
	@Test
	public void testInsertObject() {
		SysMenuDao dao = ctx.getBean("sysMenuDao",SysMenuDao.class);
		SysMenu entity = new SysMenu();
		entity.setName("商品管理");
		entity.setParentId(null);
		entity.setNote("商品模块的数据管理");
		entity.setSort(10);
		entity.setPermission("sys:product:view");
		entity.setType(1);
		entity.setUrl("product/doFindPageObjects");
		entity.setCreatedUser("admin");
		entity.setModifiedUser("admin");
		int rows = dao.insertObject(entity);
		System.out.println("rows:"+rows);
	}
	
	@Test
	public void testFindObjects() {
		SysMenuDao dao = ctx.getBean("sysMenuDao",SysMenuDao.class);
		List<Map<String, Object>> list = dao.findObjects();
		for(Map<String, Object> map:list) {
			System.out.println(map);
		}
	}
}

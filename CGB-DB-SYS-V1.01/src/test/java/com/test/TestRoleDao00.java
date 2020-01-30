package com.test;

import java.util.List;

import org.junit.Test;

import com.db.common.vo.PageObject;
import com.db.sys.dao.SysRoleDao;
import com.db.sys.entity.SysRole;
import com.db.sys.service.SysRoleService;


public class TestRoleDao00 extends TestBase{
	
	@Test
	public void testFindRole() {
		SysRoleDao dao = ctx.getBean("sysRoleDao",SysRoleDao.class);
		List<SysRole> list = dao.findPageObjects("系统管理员", 0, 45);
		System.out.println(list);
	}
	
	@Test
	public void testFindPageObejects() {
		SysRoleService roleService = 
			ctx.getBean("sysRoleServiceImpl",SysRoleService.class);
		PageObject<SysRole> po = roleService.findPageObjects("系统管理员", 1);
		System.out.println(po.getRowCount());
	}
	
}

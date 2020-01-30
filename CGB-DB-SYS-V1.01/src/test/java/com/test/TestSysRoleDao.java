package com.test;

import java.util.List;

import org.junit.Test;

import com.db.sys.dao.SysRoleDao;
import com.db.sys.entity.SysRole;

public class TestSysRoleDao extends TestBase{
	@Test
	public void testGetRowCount() {
		SysRoleDao roleDao = ctx.getBean("sysRoleDao",SysRoleDao.class);
		int rows = roleDao.getRowCount(null);
		System.out.println(rows);
		
		List<SysRole> roles = roleDao.findPageObjects(null, 0, 3);
		for(SysRole r:roles) {
			System.out.println(r);
		}
		
	}

}

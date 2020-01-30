package com.test;

import java.util.List;
import java.util.Map;
import org.junit.Test;

import com.db.sys.dao.SysLogDao;
import com.db.sys.entity.SysLog;


public class TestSysLogDao extends TestBase{
	@Test
	public void testFindById() {
		SysLogDao dao = ctx.getBean("sysLogDao",SysLogDao.class);
		Map<String,Object> map = dao.findById(9);
		System.out.println(map);
	}
	
	@Test
	public void testGetRowCount() {
		SysLogDao dao = ctx.getBean("sysLogDao",SysLogDao.class);
		int rowCounts = dao.getRowCount("admin");
		System.out.println(rowCounts);
	}
	
	@Test
	public void testFindPageObgects() {
		SysLogDao dao = ctx.getBean("sysLogDao",SysLogDao.class);
		List<SysLog> list = dao.findPageObjects("admin",0,3);
		System.out.println(list.size());
		
	}
	@Test
	public void testDeletePageObgects() {
		SysLogDao dao = ctx.getBean("sysLogDao",SysLogDao.class);
		int rows = dao.deleteObjects(36,37,38);
		System.out.println(rows);
		
	}
}

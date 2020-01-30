package com.test;

import org.junit.Test;

import com.db.common.vo.PageObject;
import com.db.sys.entity.SysLog;
import com.db.sys.service.SysLogService;

public class TestSysLogService extends TestBase{
	@Test
	public void testFindPageObejects() {
		SysLogService logService = 
			ctx.getBean("sysLogServiceImpl",SysLogService.class);
		PageObject<SysLog> po = logService.findPageObjects("admin", 1);
		System.out.println(po.getRowCount());
	}

}

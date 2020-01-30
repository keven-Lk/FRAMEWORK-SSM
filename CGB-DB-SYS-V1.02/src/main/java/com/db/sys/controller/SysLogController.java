package com.db.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.common.vo.JsonResult;
import com.db.common.vo.PageObject;
import com.db.sys.entity.SysLog;
import com.db.sys.service.SysLogService;

@RequestMapping("/log/")
@Controller
public class SysLogController {
	@Autowired
	private SysLogService sysLogService;
	
	@RequestMapping("doLogListUI")
	public String doLogListUI() {
		return "sys/log_list";
	}
	
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer...ids){
		sysLogService.deleteObjects(ids);
		return new JsonResult("delete ok");
	}
		
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody//����������ֵ��json��ʽת��
	public JsonResult doFindPageObejcts(
			Integer pageCurrent, String username){
		PageObject<SysLog> po = sysLogService.findPageObjects(
				username, pageCurrent);
		return new JsonResult(po);
	}//mvc�ײ�����������api������ֵת��Ϊָ����ʽjson
	
}

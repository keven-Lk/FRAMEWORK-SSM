package com.db.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.common.vo.JsonResult;
import com.db.sys.entity.SysRole;
import com.db.sys.service.SysRoleService;
import com.fasterxml.jackson.core.JsonProcessingException;
@Controller
@RequestMapping("/role/")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	
	@RequestMapping("doFindRoles")
	@ResponseBody
	public JsonResult doFindRoles() {
		return new JsonResult(sysRoleService.findObjects());
	}

	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id){
		return new JsonResult(sysRoleService.findObjectById(id));
	}

	@RequestMapping("doRoleListUI")
	public String doRoleListUI() {
		return "sys/role_list";
	}

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String name,Integer pageCurrent) throws JsonProcessingException{
		JsonResult r = 
				new JsonResult(sysRoleService.findPageObjects(name, pageCurrent));
		//ObjectMapper为Jackson提供的一些API
		//return new ObjectMapper().writeValueAsString(r);
		return r;
	}

	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		sysRoleService.deleteObject(id);
		return new JsonResult("delete OK");
	}

	@RequestMapping("doRoleEditUI")
	public String doRoleEditUI() {
		return "sys/role_edit";
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysRole entity,Integer[] menuIds) {
		sysRoleService.saveObject(entity, menuIds);
		return new JsonResult("save ok");
	}

	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysRole entity,
			Integer[] menuIds){
		sysRoleService.updateObject(entity,menuIds);
		return new JsonResult("update ok");
	}
}
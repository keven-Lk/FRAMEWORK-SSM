package com.db.sys.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.common.vo.JsonResult;
import com.db.common.vo.PageObject;
import com.db.common.vo.SysUserDeptVo;
import com.db.sys.entity.SysUser;
import com.db.sys.service.SysUserService;

@Controller
@RequestMapping("/user/")
public class SysUserController {
	@Autowired
	SysUserService sysUserService;
	
	@RequestMapping("doUpdatePassword")
	@ResponseBody
	public JsonResult doUpdatePassword(
			String pwd,String newPwd,String cfgPwd) {
		sysUserService.updatePassword(pwd, newPwd, cfgPwd);
		return new JsonResult("update ok");
	}
	
	/**
	 * 修改密码
	 * @author Administrator
	 *
	 */
	@Controller
	@RequestMapping("/pwd/")
	public class SysPwdController {
		@RequestMapping("doPwdListUI")
		public String doDeptEditUI(){
			return "sys/pwd_edit";
		}
	}
	
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(String username,String password) {
		//1.获取subject对象
		Subject subject = SecurityUtils.getSubject();
		//2.将用户信息提交到shiro框架的securitymanager
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		subject.login(token);
		//securitymanager将认证操作委托给认证器对象
		return new JsonResult("login ok");
	}
	
	
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(
			Integer id){
		Map<String,Object> map=
		sysUserService.findObjectById(id);
		return new JsonResult(map);
	}

	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(
			SysUser entity,
			Integer[] roleIds){
		sysUserService.updateObject(entity,roleIds);
		return new JsonResult("update ok");
	}
	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(
			SysUser entity,
			Integer[] roleIds){
		sysUserService.saveObject(entity,roleIds);
		return new JsonResult("save ok");
	}

	@RequestMapping("doUserEditUI")
	public String doUserEdit() {
		return "sys/user_edit";
	}

	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(Integer id,Integer valid) {
		//获取登陆的用户信息
		SysUser user = 
				(SysUser) SecurityUtils.getSubject().getPrincipal();
		sysUserService.validById(id, valid, user.getUsername());
		return new JsonResult("update ok");
	}

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(
			String username,Integer pageCurrent){
		PageObject<SysUserDeptVo> pageObject=
				sysUserService.findPageObjects(username,
						pageCurrent);
		//底层将对象转换成Json串时会调用对象对应的get方法获取属性值
		return new JsonResult(pageObject);
	}

	@RequestMapping("doUserListUI")
	public String doUserListUI() {
		return "sys/user_list";
	}

}

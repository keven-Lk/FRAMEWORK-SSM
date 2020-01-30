package com.db.common.web;


import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
/*
 * @ControllerAdvice
 * 修饰的类一般为spring mvc中的全局异常处理类,此类中可以定义一些异常处理方法
 */
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.db.common.vo.JsonResult;
import com.db.sys.common.exception.ServiceException;
//@RestControllerAdvice 是把controllerAdvice和ResponseBody混在一起
/*
 * @ControllerAdvice修饰的类一般为spring mvc中的全局异常处理类,
 * 	此类中可以定义一些异常处理方法
 * 
 * @RestControllerAdvic也可以修饰全局异常处理类,此注解相当于
 * 在@ControllerAdvice和@ResponseBody注解的组合
 */
@RestControllerAdvice
//@ControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * shiro异常处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public JsonResult doHandleShiroException(ShiroException e) {
		JsonResult r = new JsonResult();
		r.setState(0);//执行到此方法肯定是出异常了
		if(e instanceof UnknownAccountException) {
			r.setMessage("账户不存在");
			System.out.println("zhanghubucunzai");
		}else if(e instanceof LockedAccountException) {
			r.setMessage("账户已被禁用");
		}else if(e instanceof IncorrectCredentialsException) {
			r.setMessage("密码不正确");
		}else if(e instanceof AuthorizationException) {
			r.setMessage("没有权限");
		}else {//还有其它异常
			r.setMessage(e.getMessage());
		}
		return r;
	}
	
	/**
	 * @ExceptionHandler 注解描述的方法为异常处理方法
	 * 注解内部给定的异常类型为此方法可以处理的异常类型
	 * @param e
	 * @return
	 */
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public JsonResult doHandleServiceExceprion(ServiceException e) {
		e.printStackTrace();//也可以以日志形式输出
		return new JsonResult(e);
	}
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleServiceExceprion(RuntimeException e) {
		e.printStackTrace();//也可以以日志形式输出
		JsonResult r = new JsonResult();
		r.setMessage("底层出现了运行时错误,稍等片刻");
		r.setState(0);
		return r;
	}
}

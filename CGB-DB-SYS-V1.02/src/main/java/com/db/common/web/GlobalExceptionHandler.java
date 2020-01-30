package com.db.common.web;


import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
/*
 * @ControllerAdvice
 * ���ε���һ��Ϊspring mvc�е�ȫ���쳣������,�����п��Զ���һЩ�쳣������
 */
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.db.common.vo.JsonResult;
import com.db.sys.common.exception.ServiceException;
//@RestControllerAdvice �ǰ�controllerAdvice��ResponseBody����һ��
/*
 * @ControllerAdvice���ε���һ��Ϊspring mvc�е�ȫ���쳣������,
 * 	�����п��Զ���һЩ�쳣������
 * 
 * @RestControllerAdvicҲ��������ȫ���쳣������,��ע���൱��
 * ��@ControllerAdvice��@ResponseBodyע������
 */
@RestControllerAdvice
//@ControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * shiro�쳣����
	 * @param e
	 * @return
	 */
	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public JsonResult doHandleShiroException(ShiroException e) {
		JsonResult r = new JsonResult();
		r.setState(0);//ִ�е��˷����϶��ǳ��쳣��
		if(e instanceof UnknownAccountException) {
			r.setMessage("�˻�������");
			System.out.println("zhanghubucunzai");
		}else if(e instanceof LockedAccountException) {
			r.setMessage("�˻��ѱ�����");
		}else if(e instanceof IncorrectCredentialsException) {
			r.setMessage("���벻��ȷ");
		}else if(e instanceof AuthorizationException) {
			r.setMessage("û��Ȩ��");
		}else {//���������쳣
			r.setMessage(e.getMessage());
		}
		return r;
	}
	
	/**
	 * @ExceptionHandler ע�������ķ���Ϊ�쳣������
	 * ע���ڲ��������쳣����Ϊ�˷������Դ�����쳣����
	 * @param e
	 * @return
	 */
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public JsonResult doHandleServiceExceprion(ServiceException e) {
		e.printStackTrace();//Ҳ��������־��ʽ���
		return new JsonResult(e);
	}
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleServiceExceprion(RuntimeException e) {
		e.printStackTrace();//Ҳ��������־��ʽ���
		JsonResult r = new JsonResult();
		r.setMessage("�ײ����������ʱ����,�Ե�Ƭ��");
		r.setState(0);
		return r;
	}
}

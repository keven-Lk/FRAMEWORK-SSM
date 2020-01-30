package com.db.common.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
/*
 * @ControllerAdvice
 * ���ε���һ��Ϊspring mvc�е�ȫ���쳣������,�����п��Զ���һЩ�쳣������
 */
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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
@ControllerAdvice
public class GlobalExceptionHandler {
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

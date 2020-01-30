package com.db.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PageController {//springmvc�к�˿�������������֮Ϊhandler
	//�������ù���?
	//1.�����url�ύ��DispatcherServlet����
	//2.DispatcherServlet�����������url��HandleMapping�л�ȡHandleMethod����
	//3.DispatcherServlet�������ڷ��似�����ô˷���
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";//WEB-INF/pages/starter.html
	}

	//��������ֵ�Ĵ������
	//1.��ֵ("start")�᷵�ظ�DispatcherServlet(ǰ�˿�����)
	//2.DispatcherServlet������ͼ������(ViewResolver)�Է��ص�view���н���
	//3.��ͼ������������������ظ�DispatcherServlet����
	//4.DispatcherServlet��ҳ����Ӧ���ͻ���
	
	/*
	 * ���ڴ˷������ط�ҳҳ��
	 */
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
}

package com.db.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PageController {//springmvc中后端控制器往往被称之为handler
	//方法调用过程?
	//1.请求的url会交给DispatcherServlet对象
	//2.DispatcherServlet对象基于请求url从HandleMapping中获取HandleMethod对象
	//3.DispatcherServlet对象会基于反射技术调用此方法
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";//WEB-INF/pages/starter.html
	}

	//方法返回值的处理过程
	//1.此值("start")会返回给DispatcherServlet(前端控制器)
	//2.DispatcherServlet调用视图解析器(ViewResolver)对返回的view进行解析
	//3.视图解析器将解析结果返回给DispatcherServlet对象
	//4.DispatcherServlet将页面响应到客户端
	
	/*
	 * 基于此方法返回分页页面
	 */
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
}
